package com.export.web.actions;

import iso3166CountryCode01.CountryCodedType;
import iso4217CurrencyCode01.CurrencyCodedType;

import java.math.BigDecimal;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.Session;

import tHeDOCSTDED.AddressStructuredType;
import tHeDOCSTDED.ConsigneePartyType;
import tHeDOCSTDED.ConsignmentTransportDetailsType;
import tHeDOCSTDED.CountryOfDestinationType;
import tHeDOCSTDED.DistrictType;
import tHeDOCSTDED.FreightForwarderPartyType;
import tHeDOCSTDED.PortOfDischargeType;
import tHeDOCSTDED.PortOfLoadingType;
import tHeDOCSTDED.ProvinceType;
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
import th.ac.ku.singlewindow.schema.shipmentCertificateRequest.InvoiceReferenceType;
import th.ac.ku.singlewindow.schema.shipmentCertificateRequest.ItemAmountType;
import th.ac.ku.singlewindow.schema.shipmentCertificateRequest.LineItemGrossWeightType;
import th.ac.ku.singlewindow.schema.shipmentCertificateRequest.LineItemType;
import th.ac.ku.singlewindow.schema.shipmentCertificateRequest.ProductOriginType;
import th.ac.ku.singlewindow.schema.shipmentCertificateRequest.RequiredTemperatureType;
import th.ac.ku.singlewindow.schema.shipmentCertificateRequest.StorageTemperatureType;
import th.ac.ku.singlewindow.schema.shipmentCertificateRequest.TransportTemperatureType;
import unREC19ModeofTransport01.ModeOfTransportCodedType;
import unREC20UnitsofMeasurement01.MeasureUnitCodedType;

import com.export.dao.CertificateTypeDAO;
import com.export.dao.CodeListDAO;
import com.export.dao.UtilityDAO;
import com.export.dao.hibernate.CertificateTypeDAOHibernate;
import com.export.dao.hibernate.CodeListDAOHibernate;
import com.export.dao.hibernate.UtilityDAOHibernate;
import com.export.domain.Address;
import com.export.domain.CertificateRequest;
import com.export.domain.CertificateRequestConsignee;
import com.export.domain.CertificateRequestDetail;
import com.export.domain.CertificateRequestHalal;
import com.export.domain.CertificateRequestHealthCertificate;
import com.export.domain.CertificateRequestInvoice;
import com.export.domain.CertificateRequestTransport;
import com.export.domain.CertificateType;
import com.export.domain.Country;
import com.export.domain.Exporter;
import com.export.domain.Location;
import com.export.domain.Province;
import com.export.domain.TransportMode;
import com.export.framework.hibernate.HibernateSession;
import com.export.msh.ActionNames;
import com.export.msh.MSHConstants;
import com.export.msh.MSHUtils;
import com.export.util.DateUtils;
import com.export.util.NumberUtils;
import com.export.util.XmlBeansUtils;
import com.export.web.forms.CertificateRequestForm;
import com.export.web.util.WebUtils;

public class ShipmentCertRequestAction extends Action {
	
	private static Log logger = LogFactory.getLog(ShipmentCertRequestAction.class);
	
	private CertificateTypeDAO certTypeDAO 	= new CertificateTypeDAOHibernate();
	private CodeListDAO codeListDAO			= new CodeListDAOHibernate();
	private UtilityDAO utilDAO				= new UtilityDAOHibernate();
	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		logger.debug("Enter execute.");
		
		try {
		
			CertificateRequestForm f = (CertificateRequestForm) form;
			logger.debug("Processing ActionForm: " + f);
			
			Session session = HibernateSession.currentSession();
			HttpSession httpSession = request.getSession();
			
			/******************************************
			 * Create certificate request information *
			 ******************************************/ 
			CertificateRequest cr = new CertificateRequest();
			
			// Set common information
			Exporter exporter = WebUtils.getCurrentExporter(request);
			cr.setExporter(exporter);
			cr.setOriginDistrict(f.getProductOriginDistrict());
			cr.setOriginProvinceCode(f.getProductOriginProvince());
			cr.setAuthorizedPersonName(f.getProxyName());
			cr.setAuthorizedPersonId(f.getProxyId());
			
			// Set audit information
			Date date = new Date();
			cr.setCreateDate(date);
			cr.setModifyDate(date);
			
			// Perform create.
			logger.debug("Saving CertificateRequest: " + cr);
			Long id = (Long) session.save(cr);
			
			/********************************
			 * Create consignee information *
			 ********************************/
			CertificateRequestConsignee consignee = new CertificateRequestConsignee();
			consignee.setCertificateRequestId(id);
			consignee.setConsigneeName(f.getConsigneeName());
			consignee.setConsigneeAddress(f.getConsigneeAddress());
			consignee.setDestinationCountryCode(f.getDestinationCountryCode());
			
			// Perform create
			logger.debug("Saving CertificateRequestConsignee: " + consignee);
			session.save(consignee);
			
			/********************************
			 * Create transport information *
			 ********************************/
			CertificateRequestTransport transport = new CertificateRequestTransport();
			transport.setCertificateRequestId(id);
			transport.setDischargeLocationCode(f.getDischargeLocationCode());
			transport.setDispatcherAddress(f.getDispatcherAddress());
			transport.setDispatcherName(f.getDispatcherName());
			transport.setJourneyId(f.getTransportMeansJourneyId());
			transport.setLoadingLocationCode(f.getLoadingLocationCode());
			transport.setTransportModeCode(f.getTransportMode());
	
			Date shipmentDate = DateUtils.stringToDate(f.getShipmentDate());
			if (shipmentDate != null) {
				transport.setShipmentDate(shipmentDate);
			}
			
			// Perform create
			logger.debug("Saving CertificateRequestTransport: " + transport);
			session.save(transport);
			
			/******************************
			 * Create invoice information *
			 ******************************/
			CertificateRequestInvoice invoice = new CertificateRequestInvoice();
			invoice.setCertificateRequestId(id);
			invoice.setInvoiceDate(DateUtils.stringToDate(f.getInvoiceDate()));
			invoice.setInvoiceNo(f.getInvoiceNo());
			invoice.setItemDescription(f.getProductDescription());
			invoice.setItemHarmonizeCode(f.getCommodityCode());
			invoice.setItemPrice(NumberUtils.stringToDouble(f.getProductValue()));
			invoice.setItemPriceCurrencyCode(f.getProductCurrency());
			invoice.setItemQuantity(NumberUtils.stringToDouble(f.getPackageQuantity()));
			invoice.setItemWeight(NumberUtils.stringToDouble(f.getProductAmount()));
			invoice.setItemWeightUom(f.getProductAmountUom());
			invoice.setPackageType(f.getPackageType());
	
			// Perform create
			logger.debug("Saving CertificateRequestInvoice: " + invoice);
			session.save(invoice);
			
			/****************************
			 * Create Halal information *
			 ****************************/
			CertificateRequestHalal halal = new CertificateRequestHalal();
			halal.setCertificateRequestId(id);
			halal.setHalalCompanyCode(f.getHalalCompanyCode());
			halal.setHalalNo(f.getHalalNo());
			halal.setManufacturer(f.getManufacturer());
			halal.setProductDescription(f.getHalalProductDescription());
			
			// Perform create
			logger.debug("Saving CertificateRequestHalal: " + halal);
			session.save(halal);
	
			/*****************************************
			 * Create Health Certificate information *
			 *****************************************/
			CertificateRequestHealthCertificate hc = new CertificateRequestHealthCertificate();
			hc.setCertificateRequestId(id);
			hc.setCodeNumber(f.getCodeNumber());
			hc.setProductDescription(f.getProductPresentation());
			hc.setSpecies(f.getSpecies());
			hc.setStorageTemperature(NumberUtils.stringToDouble(f.getStorageTemperature()));
			hc.setStorageTemperatureUom(f.getStorageTemperatureUom());
			hc.setTransportTemperature(NumberUtils.stringToDouble(f.getTransportTemperature()));
			hc.setTransportTemperatureUom(f.getTransportTemperatureUom());
	
			// Perform create
			logger.debug("Saving CertificateRequestHealthCertificate: " + hc);
			session.save(hc);
			
			/*************************************************
			 * Create certificate request detail information *
			 *************************************************/
			String[] certificateTypes = f.getCertificateTypes();
			for (int i = 0; i < certificateTypes.length; i++) {
				CertificateRequestDetail detail = new CertificateRequestDetail();
				detail.setCertificateRequestId(id);
				detail.setCertificateTypeId(Long.valueOf(certificateTypes[i]));
				detail.setCreateDate(date);
				detail.setModifyDate(date);
				detail.setStatusCode("P");
				
				// Perform create
				logger.debug("Saving CertificateRequestDetail: " + detail);
				session.save(detail);
			}
			
			// Create XML message.
			Country thailand = codeListDAO.getCountryByCountryCode(session, CountryCodedType.TH.toString());
			
			CertificateRequestDocument root = CertificateRequestDocument.Factory.newInstance();
			CertificateRequestType crXml = root.addNewCertificateRequest();
			CertificateRequestHeaderType crHeaderXml = crXml.addNewCertificateRequestHeader();
			crHeaderXml.setCertificateRequestID(id.toString());
	
			// CertificateRequestHeader element.
			for (int i = 0; i < certificateTypes.length; i++) {
				CertificateTypeType certTypeXml = crHeaderXml.addNewCertificateType();
				CertificateType certType = certTypeDAO.getCertificateType(session, Long.valueOf(certificateTypes[i]));
				certTypeXml.setCertificateTypeID(certificateTypes[i]);
				certTypeXml.setCertificateTypeName(certType.getName());
			}
			
			// CertificateReqeustInformation element
			CertificateRequestInformationType crInfoXml = crXml.addNewCertificateRequestInformation();
			
			AuthorizedPersonType authorizedPersonXml = crInfoXml.addNewAuthorizedPerson();
			authorizedPersonXml.setAuthorizedPersonID(f.getProxyId());
			authorizedPersonXml.setAuthorizedPersonName(f.getProxyName());
			
			ProductOriginType productOriginXml = crInfoXml.addNewProductOrigin();
			DistrictType districtXml = productOriginXml.addNewOriginDistrict();
			districtXml.setDistrictName(f.getProductOriginDistrict());
			
			Province originProvince = utilDAO.getProvince(session, f.getProductOriginProvince());
			ProvinceType provinceXml = productOriginXml.addNewOriginProvince();
			provinceXml.setProvinceCode(f.getProductOriginProvince());
			if (originProvince != null) {
				provinceXml.setProvinceName(originProvince.getName());
			}
			
			// ExporterInformationElement
			ExporterInformationType exporterXml = crXml.addNewExporterInformation();
			exporterXml.setExporterID(exporter.getExporterId());
	
			Address exporterAddress = exporter.getExporterAddress();
			Address factoryAddress = exporter.getFactoryAddress();
			
			AddressStructuredType exporterAddressDoc = exporterXml.addNewAddressStructured();
			exporterAddressDoc.setName(exporter.getName());
			exporterAddressDoc.setStreet(exporterAddress.getStreet());
			exporterAddressDoc.setCity(exporterAddress.getCity());
			exporterAddressDoc.setCountrySubEntity(exporterAddress.getCountrySubEntity());
			exporterAddressDoc.setCountryCode(CountryCodedType.TH);
			exporterAddressDoc.setCountryName(thailand.getCountryName());
			exporterAddressDoc.setPostalZone(exporterAddress.getPostalZone());
			
			AddressStructuredType factoryAddressDoc = exporterXml.addNewFactoryAddressStructured();
			factoryAddressDoc.setName(factoryAddress.getName());
			factoryAddressDoc.setStreet(factoryAddress.getStreet());
			factoryAddressDoc.setCity(factoryAddress.getCity());
			factoryAddressDoc.setCountrySubEntity(factoryAddress.getCountrySubEntity());
			factoryAddressDoc.setCountryCode(CountryCodedType.TH);
			factoryAddressDoc.setCountryName(thailand.getCountryName());
			factoryAddressDoc.setPostalZone(factoryAddress.getPostalZone());
			
			// ConsignmentInformation element
			ConsignmentInformationType consignmentXml = crXml.addNewConsignmentInformation();
			ConsigneePartyType consigneeXml = consignmentXml.addNewConsigneeParty();
			consigneeXml.addNewAddressStructured().setName(f.getConsigneeName());
			consigneeXml.addNewConsigneeNameAddressUnstructured().addNameAddressUnstructured(f.getConsigneeAddress());
			
			CountryOfDestinationType destinationCountryXml = consignmentXml.addNewCountryOfDestination();
			Country destinationCountry = codeListDAO.getCountryByCountryCode(session, f.getDestinationCountryCode());
			destinationCountryXml.setCountryCode(destinationCountry.getCountryCode());
			destinationCountryXml.setCountryName(destinationCountry.getCountryName());
			
			// ConsignmentTransportDetails element
			ConsignmentTransportDetailsType transportXml = consignmentXml.addNewConsignmentTransportDetails();
			
			// ConsignmentTransportDetails/TransportMeans element
			TransportMeansType transportMeansXml = transportXml.addNewTransportMeans();
			transportMeansXml.setTransportMeansJourneyID(f.getTransportMeansJourneyId());
			transportMeansXml.setTransportMeansEstimatedDepartureDateTime(f.getShipmentDate());
			
			// ConsignmentTransportDetails/TransportMode element
			TransportMode transportMode = utilDAO.getTransportMode(session, f.getTransportMode());
			TransportModeType transportModeXml = transportXml.addNewTransportMode();
			transportModeXml.setTransportModeCode(ModeOfTransportCodedType.Enum.forString(f.getTransportMode()));
			transportModeXml.setTransportModeText(transportMode.getThaiName());
			
			Location dischargeLocation = utilDAO.getLocation(session, f.getDischargeLocationCode());
			PortOfDischargeType portOfDischargeXml = transportXml.addNewPortOfDischarge(); 
			portOfDischargeXml.setDischargeLocationID(f.getDischargeLocationCode());
			portOfDischargeXml.setDischargeLocationName(dischargeLocation.getLocationName());
			
			Location loadingLocation = utilDAO.getLocation(session, f.getLoadingLocationCode());
			PortOfLoadingType portOfLoadingXml = transportXml.addNewPortOfLoading();  
			portOfLoadingXml.setLoadingLocationID(f.getLoadingLocationCode());
			portOfLoadingXml.setLoadingLocationName(loadingLocation.getLocationName());
	
			// FreightForwarderParty element 
			FreightForwarderPartyType forwarderXml = consignmentXml.addNewFreightForwarderParty();
			forwarderXml.addNewAddressStructured().setName(f.getDispatcherName());
			forwarderXml.addNewForwarderNameAddressUnstructured().addNameAddressUnstructured(f.getDispatcherAddress());
			
			// InvoceInformation element
			InvoiceInformationType invoiceXml = crXml.addNewInvoiceInformation();
			
			// InvoiceReference element
			InvoiceReferenceType invoiceReferenceXml = invoiceXml.addNewInvoiceReference();
			invoiceReferenceXml.setInvoiceNumber(f.getInvoiceNo());
			invoiceReferenceXml.setReferenceDate(f.getInvoiceDate());
			
			// LineItem element
			LineItemType lineItemXml = invoiceXml.addNewLineItem();
			lineItemXml.setItemID("1");
			lineItemXml.setItemDescription(f.getProductDescription());
			lineItemXml.setNumberOfPackages(f.getPackageQuantity());
			lineItemXml.setKindOfPackages(f.getPackageType());
			lineItemXml.addNewCommodityCodeType().setCommodityCode(f.getCommodityCode());
			
			ItemAmountType itemAmountXml = lineItemXml.addNewItemValues().addNewItemAmount();
			itemAmountXml.setItemAmount(f.getProductValue());
			itemAmountXml.setCurrencyCode(CurrencyCodedType.Enum.forString(f.getProductCurrency()));
			
			LineItemGrossWeightType weigntXml = lineItemXml.addNewLineItemMeasurements().addNewGrossWeight();
			weigntXml.setMeasure(new BigDecimal(f.getProductAmount()));
			weigntXml.setMeasureUnitCode(MeasureUnitCodedType.Enum.forString(f.getProductAmountUom()));
			
			// HalalInformation element
			HalalInformationType halalXml = crXml.addNewHalalInformation();
			halalXml.setProductDescription(f.getHalalProductDescription());
			halalXml.setHalalNumber(f.getHalalNo());
			halalXml.setHalalCompanyCode(f.getHalalCompanyCode());
			halalXml.addNewManufacturerParty().addNewManufacturerNameAddressUnstructured().addNameAddressUnstructured(f.getManufacturer());
			
			// HealthCertificateInformation element
			HealthCertificateInformationType hcXml = crXml.addNewHealthCertificateInformation();
			hcXml.setCodeNumber(f.getCodeNumber());
			hcXml.setItemDescription(f.getProductPresentation());
			hcXml.setScientificName(f.getSpecies());
			
			// HealthCertificateInformation/RequiredTemperature element
			RequiredTemperatureType temperatureXml = hcXml.addNewRequiredTemperature();
			
			StorageTemperatureType storageTemperatureXml = temperatureXml.addNewStorageTemperature();
			storageTemperatureXml.setStorageTemperatureMeasure(f.getStorageTemperature());
			storageTemperatureXml.setMeasureUnitCode(MeasureUnitCodedType.Enum.forString(f.getStorageTemperatureUom()));
			
			TransportTemperatureType transportTemperatureXml = temperatureXml.addNewTransportTemperature();
			transportTemperatureXml.setTransportTemperatureMeasure(f.getTransportTemperature());
			transportTemperatureXml.setMeasureUnitCode(MeasureUnitCodedType.Enum.forString(f.getTransportTemperatureUom()));
			
			logger.debug("XML message constructed:");
			logger.debug(XmlBeansUtils.printXmlObject(root));
	
			// Send XML message to MSH
			MSHUtils.sentMshMessage(
				MSHConstants.PARTY_SINGLE_WINDOW,
				MSHConstants.PARTY_GOVERNMENT,
				MSHConstants.TARGET_GOVERNMENT, 
				ActionNames.CREATE_SHIPMENT_CERTIFICATE, 
				XmlBeansUtils.printXmlObject(root)
			);
			
			// Set success message.
			request.setAttribute("successMessage", "ข้อมูลคำร้องของท่าน ได้ถูกบันทึกเรียบร้อยแล้ว หมายเลขคำร้องของท่านคือ " + id);

		}
		catch (Exception e) {
			logger.error("Exception in execute()", e);
		}
		
		return mapping.findForward("success");
	}

}

