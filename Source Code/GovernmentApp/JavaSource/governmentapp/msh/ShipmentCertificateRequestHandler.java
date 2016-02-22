package governmentapp.msh;

import governmentapp.domain.ShipmentCertificateRequest;
import governmentapp.domain.ShipmentCertificateRequestDetail;
import hk.hku.cecid.phoenix.message.handler.MessageListener;
import hk.hku.cecid.phoenix.message.packaging.EbxmlMessage;
import hk.hku.cecid.phoenix.message.packaging.PayloadContainer;

import java.net.URL;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;

import tHeDOCSTDED.AddressStructuredType;
import tHeDOCSTDED.ConsigneePartyType;
import tHeDOCSTDED.ConsignmentTransportDetailsType;
import tHeDOCSTDED.CountryOfDestinationType;
import tHeDOCSTDED.CountryOfOriginType;
import tHeDOCSTDED.FreightForwarderPartyType;
import tHeDOCSTDED.PortOfDischargeType;
import tHeDOCSTDED.PortOfLoadingType;
import tHeDOCSTDED.TransportMeansType;
import tHeDOCSTDED.TransportModeType;
import th.ac.ku.singlewindow.schema.shipmentCertificateRequest.AuthorizedPersonType;
import th.ac.ku.singlewindow.schema.shipmentCertificateRequest.CertificateRequestDocument;
import th.ac.ku.singlewindow.schema.shipmentCertificateRequest.CertificateRequestHeaderType;
import th.ac.ku.singlewindow.schema.shipmentCertificateRequest.CertificateRequestInformationType;
import th.ac.ku.singlewindow.schema.shipmentCertificateRequest.CertificateRequestType;
import th.ac.ku.singlewindow.schema.shipmentCertificateRequest.CertificateTypeType;
import th.ac.ku.singlewindow.schema.shipmentCertificateRequest.ConsignmentInformationType;
import th.ac.ku.singlewindow.schema.shipmentCertificateRequest.ExporterInformationType;
import th.ac.ku.singlewindow.schema.shipmentCertificateRequest.HalalInformationType;
import th.ac.ku.singlewindow.schema.shipmentCertificateRequest.HealthCertificateInformationType;
import th.ac.ku.singlewindow.schema.shipmentCertificateRequest.InvoiceInformationType;
import th.ac.ku.singlewindow.schema.shipmentCertificateRequest.LineItemType;
import th.ac.ku.singlewindow.schema.shipmentCertificateRequest.ProductOriginType;
import th.ac.ku.singlewindow.schema.shipmentCertificateRequest.StorageTemperatureType;
import th.ac.ku.singlewindow.schema.shipmentCertificateRequest.TransportTemperatureType;

import com.export.framework.hibernate.HibernateSession;
import com.export.msh.MSHUtils;
import com.export.util.DateUtils;
import com.export.util.NumberUtils;

public class ShipmentCertificateRequestHandler implements MessageListener {
	
	private static Log logger = LogFactory.getLog(ShipmentCertificateRequestHandler.class);

	public ShipmentCertificateRequestHandler() {
		System.out.println(this.getClass().getName() + " created.");
	}
	public URL getClientUrl() {
		return null;
	}

	public void onMessage(EbxmlMessage message) {
		logger.debug("Enter onMessage.");
		logger.debug("EbxmlMessage: " + message);
		
		System.out.println();
		System.out.println("================================");
		System.out.println(this.getClass().getName() + ": Message received!!");
		System.out.println("Date: " + new Date());
		System.out.println("Number of payload: " + message.getPayloadCount());
		
		if (message.getPayloadCount() != 1) {
			System.err.println("Invalid payload count!!");
			return;
		}
		
		try {
			// Read ebXML Payload
			PayloadContainer pc = (PayloadContainer) message.getPayloadContainers().next();
			String payload = MSHUtils.getEbXmlPayloadAsString(pc);
			System.out.println("Payload:");
			System.out.println(payload);
			logger.debug("ebXML payload: " + payload);

			// Extract data from XMLBean
			CertificateRequestDocument root = CertificateRequestDocument.Factory.parse(payload);
			CertificateRequestType crXml = root.getCertificateRequest();
			
			// CertificateRequestHeader.
			CertificateRequestHeaderType headerXml = crXml.getCertificateRequestHeader();
			CertificateTypeType[] certTypes = headerXml.getCertificateTypeArray();

			// CertificateRequest/ExporterInformation
			ExporterInformationType exporter = crXml.getExporterInformation();
			AddressStructuredType exporterAddress = exporter.getAddressStructured();
			AddressStructuredType factoryAddress = exporter.getFactoryAddressStructured();
			
			// CertificateRequest/CertificateRequestInformation
			CertificateRequestInformationType crInfoXml = crXml.getCertificateRequestInformation();
			AuthorizedPersonType authorizedPersonXml = crInfoXml.getAuthorizedPerson();
			ProductOriginType productOriginXml = crInfoXml.getProductOrigin();
			
			// CertificateRequest/ConsignementInformation
			ConsignmentInformationType consignmentXml = crXml.getConsignmentInformation();
			ConsigneePartyType consigneeXml = consignmentXml.getConsigneeParty();
			CountryOfOriginType originCountryXml = consignmentXml.getCountryOfOrigin();
			CountryOfDestinationType destinationCountryXml = consignmentXml.getCountryOfDestination();
			FreightForwarderPartyType forwarderXml = consignmentXml.getFreightForwarderParty();
			
			// CertificateRequest/ConsignementInformation/ConsignmentTransportDetailsType
			ConsignmentTransportDetailsType transportXml = consignmentXml.getConsignmentTransportDetails();
			TransportMeansType transportMeansXml = transportXml.getTransportMeans();
			TransportModeType transportModeXml = transportXml.getTransportMode();
			PortOfLoadingType loadingLocationXml = transportXml.getPortOfLoading();
			PortOfDischargeType dischargeLocationXml = transportXml.getPortOfDischarge();
			
			// CertificateRequest/InvoiceInformation
			InvoiceInformationType invoiceXml = crXml.getInvoiceInformation();
			LineItemType itemXml = invoiceXml.getLineItemArray(0);
			
			// CertificateRequest/HalalInformation
			HalalInformationType halalXml = crXml.getHalalInformation();
			
			// CertificateRequest/HealthCertificateInformation
			HealthCertificateInformationType hcXml = crXml.getHealthCertificateInformation();
			StorageTemperatureType storageTemeratureXml = hcXml.getRequiredTemperature().getStorageTemperature();
			TransportTemperatureType transportTemeratureXml = hcXml.getRequiredTemperature().getTransportTemperature();

			// Begin transaction.
			Session session = HibernateSession.currentSession();
			session.beginTransaction();

			for (int i = 0; i < certTypes.length; i++) {
				
				// Save information
				ShipmentCertificateRequest request = new ShipmentCertificateRequest();
				request.setExporterId(exporter.getExporterID());
				request.setExporterName(exporterAddress.getName());
				request.setCertificateRequestId(Long.valueOf(headerXml.getCertificateRequestID()));
				request.setCertificateTypeId(Long.valueOf(certTypes[i].getCertificateTypeID()));
				request.setCertificateTypeName(certTypes[i].getCertificateTypeName());
				request.setStatusCode("P");
				request.setRequestDate(new Date());
				
				ShipmentCertificateRequestDetail detail = new ShipmentCertificateRequestDetail();
				detail.setExporterAddressName(exporterAddress.getName());
				detail.setExporterAddressStreet(exporterAddress.getStreet());
				detail.setExporterAddressCity(exporterAddress.getCity());
				detail.setExporterAddressProvince(exporterAddress.getCountrySubEntity());
				detail.setExporterAddressCountry(exporterAddress.getCountryName());
				detail.setExporterAddressPostalZone(exporterAddress.getPostalZone());

				detail.setFactoryAddressName(factoryAddress.getName());
				detail.setFactoryAddressStreet(factoryAddress.getStreet());
				detail.setFactoryAddressCity(factoryAddress.getCity());
				detail.setFactoryAddressProvince(factoryAddress.getCountrySubEntity());
				detail.setFactoryAddressCountry(factoryAddress.getCountryName());
				detail.setFactoryAddressPostalZone(factoryAddress.getPostalZone());
				
				detail.setProxyId(authorizedPersonXml.getAuthorizedPersonID());
				detail.setProxyName(authorizedPersonXml.getAuthorizedPersonName());
				detail.setProductOriginDistrict(productOriginXml.getOriginDistrict().getDistrictName());
				detail.setProductOriginProvince(productOriginXml.getOriginProvince().getProvinceCode());
				
				detail.setConsigneeName(consigneeXml.getAddressStructured().getName());
				detail.setConsigneeAddress(consigneeXml.getConsigneeNameAddressUnstructured().getNameAddressUnstructuredArray(0));
				
				detail.setDestinationCountry(destinationCountryXml.getCountryName());
				detail.setDestinationCountryCode(destinationCountryXml.getCountryCode());

				detail.setDispatcherName(forwarderXml.getAddressStructured().getName());
				detail.setDispatcherAddress(forwarderXml.getForwarderNameAddressUnstructured().getNameAddressUnstructuredArray(0));
				
				// Transport
				detail.setTransportMeansJourneyId(transportMeansXml.getTransportMeansJourneyID());
				detail.setTransportMode(transportModeXml.getTransportModeText());
				detail.setTransportModeCode(transportModeXml.getTransportModeCode().toString());
				detail.setShipmentDate(DateUtils.stringToDate(transportMeansXml.getTransportMeansEstimatedDepartureDateTime()));
				detail.setDischargeLocation(dischargeLocationXml.getDischargeLocationName());
				detail.setDischargeLocationCode(dischargeLocationXml.getDischargeLocationID());
				detail.setLoadingLocation(loadingLocationXml.getLoadingLocationName());
				detail.setLoadingLocationCode(loadingLocationXml.getLoadingLocationID());
				
				// Invoice
				detail.setInvoiceDate(DateUtils.stringToDate(invoiceXml.getInvoiceReference().getReferenceDate()));
				detail.setInvoiceNo(invoiceXml.getInvoiceReference().getInvoiceNumber());
				detail.setProductDescription(itemXml.getItemDescription());
				detail.setProductAmount(NumberUtils.stringToDouble(itemXml.getLineItemMeasurements().getGrossWeight().getMeasure().toString()));
				detail.setProductAmountUom(itemXml.getLineItemMeasurements().getGrossWeight().getMeasureUnitCode().toString());
				detail.setProductValue(NumberUtils.stringToDouble(itemXml.getItemValues().getItemAmount().getItemAmount()));
				detail.setCommodityCode(itemXml.getCommodityCodeType().getCommodityCode());
				detail.setPackageQuantity(NumberUtils.stringToDouble(itemXml.getNumberOfPackages()));
				detail.setPackageType(itemXml.getKindOfPackages());
				
				// Halal
				detail.setHalalProductDescription(halalXml.getProductDescription());
				detail.setManufacturer(halalXml.getManufacturerParty().getManufacturerNameAddressUnstructured().getNameAddressUnstructuredArray(0));
				detail.setHalalNo(halalXml.getHalalNumber());
				detail.setHalalCompanyCode(halalXml.getHalalCompanyCode());
				
				// Health Certificate
				detail.setSpecies(hcXml.getScientificName());
				detail.setProductPresentation(hcXml.getItemDescription());
				detail.setCodeNumber(hcXml.getCodeNumber());
				
				detail.setStorageTemperature(NumberUtils.stringToDouble(storageTemeratureXml.getStorageTemperatureMeasure()));
				detail.setStorageTemperatureUom(storageTemeratureXml.getMeasureUnitCode().toString());
				detail.setTransportTemperature(NumberUtils.stringToDouble(transportTemeratureXml.getTransportTemperatureMeasure()));
				detail.setTransportTemperatureUom(transportTemeratureXml.getMeasureUnitCode().toString());

				// Save request information.
				
				Long requestId = (Long) session.save(request);
				detail.setId(requestId);
				session.save(detail);
			}

			// Commit transaction
			session.getTransaction().commit();
			logger.debug("Shipment request information saved.");
		}
		catch (Exception e) {
			logger.error("Exception in onMessage.", e);
			e.printStackTrace();
		}
	}
}
