package governmentapp.msh;

import governmentapp.domain.CertificateRequest;
import governmentapp.domain.ExporterCertificateRequestDetail;
import hk.hku.cecid.phoenix.message.handler.MessageListener;
import hk.hku.cecid.phoenix.message.packaging.EbxmlMessage;
import hk.hku.cecid.phoenix.message.packaging.PayloadContainer;

import java.net.URL;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;

import tHeDOCSTDED.AddressStructuredType;
import th.ac.ku.singlewindow.schema.ExporterCertificateRequestDocument;
import th.ac.ku.singlewindow.schema.ExporterCertificateRequestHeaderType;
import th.ac.ku.singlewindow.schema.ExporterCertificateRequestType;
import th.ac.ku.singlewindow.schema.ExporterInformationType;

import com.export.framework.hibernate.HibernateSession;
import com.export.msh.MSHUtils;

public class ExporterCertificateRequestHandler implements MessageListener {
	
	private static Log logger = LogFactory.getLog(ExporterCertificateRequestHandler.class);

	public ExporterCertificateRequestHandler() {
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
			ExporterCertificateRequestDocument root = ExporterCertificateRequestDocument.Factory.parse(payload);
			ExporterCertificateRequestType msg =  root.getExporterCertificateRequest();
			ExporterCertificateRequestHeaderType header = msg.getExporterCertificateRequestHeader();
			ExporterInformationType exporter = msg.getExporterInformation();
			AddressStructuredType exporterAddress = exporter.getAddressStructured();
			AddressStructuredType factoryAddress = exporter.getFactoryAddressStructured();
			
			// Save request information.
			CertificateRequest request = new CertificateRequest();
			request.setExporterId(exporter.getExporterID());
			request.setExporterName(exporterAddress.getName());
			request.setCertificateTypeId(Long.valueOf(header.getCertificateTypeID()));
			request.setCertificateTypeName(header.getCertificateTypeName());
			request.setStatusCode("P");
			request.setRequestDate(new Date());

			ExporterCertificateRequestDetail detail = new ExporterCertificateRequestDetail();
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
			
			Session session = HibernateSession.currentSession();
			session.beginTransaction();
			
			Long requestId = (Long) session.save(request);
			detail.setId(requestId);
			session.save(detail);
			
			session.getTransaction().commit();
			
			logger.debug("Exporter request information saved.");
		}
		catch (Exception e) {
			logger.error("Exception in onMessage.", e);
			e.printStackTrace();
		}
	}
	
}
