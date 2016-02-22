package com.export.web.actions;

import iso3166CountryCode01.CountryCodedType;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.Session;

import tHeDOCSTDED.AddressStructuredType;
import th.ac.ku.singlewindow.schema.ExporterCertificateRequestDocument;
import th.ac.ku.singlewindow.schema.ExporterCertificateRequestHeaderType;
import th.ac.ku.singlewindow.schema.ExporterCertificateRequestType;
import th.ac.ku.singlewindow.schema.ExporterInformationType;

import com.export.dao.CodeListDAO;
import com.export.dao.ExporterDAO;
import com.export.dao.hibernate.CodeListDAOHibernate;
import com.export.dao.hibernate.ExporterDAOHibernate;
import com.export.domain.Address;
import com.export.domain.Country;
import com.export.domain.Exporter;
import com.export.domain.ExporterCertificateStatus;
import com.export.framework.hibernate.HibernateSession;
import com.export.msh.ActionNames;
import com.export.msh.MSHConstants;
import com.export.msh.MSHUtils;
import com.export.util.XmlBeansUtils;
import com.export.web.forms.ExporterCertRequestForm;

public class ExporterCertRequestAction extends Action {
	
	private static Log logger = LogFactory.getLog(ExporterCertRequestAction.class);
	
	private ExporterDAO exporterDAO = new ExporterDAOHibernate();
	private CodeListDAO codeListDAO	= new CodeListDAOHibernate();

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		logger.debug("Enter execute.");
		
		try {
			ExporterCertRequestForm f = (ExporterCertRequestForm) form;
			String exporterId = f.getExporterId();
			String certTypeId = f.getCertTypeId();
			
			logger.debug("exporterId: " + exporterId);
			logger.debug("certTypeId: " + certTypeId);
			
			/*
			 * Update status in Single Window system.
			 */
			
			// Retrieve Hibernate session.
			Session session = HibernateSession.currentSession();
			
			// Retrieve exporter information
			Exporter exporter = exporterDAO.getExporter(session, exporterId);
			Address exporterAddress = exporter.getExporterAddress();
			Address factoryAddress = exporter.getFactoryAddress();
			
			// Update exporter certificate status to "In Progress" (P).
			ExporterCertificateStatus status = exporterDAO.getExporterCertStatus(session, exporterId, Long.valueOf(certTypeId));
			status.setStatusCode("P");
			status.setIssueDate(null);
			status.setExpireDate(null);
			
			/*
			 * Send data to MSH
			 */
			Country thailand = codeListDAO.getCountryByCountryCode(session, CountryCodedType.TH.toString());
			
			// Prepare XML message
			logger.debug("Creating XML message");
			ExporterCertificateRequestDocument root = ExporterCertificateRequestDocument.Factory.newInstance();
			ExporterCertificateRequestType req = root.addNewExporterCertificateRequest();
			
			ExporterCertificateRequestHeaderType header = req.addNewExporterCertificateRequestHeader();
			header.setCertificateTypeID(certTypeId);
			header.setCertificateTypeName(status.getCertificateType().getName());
			
			ExporterInformationType exporterInfo = req.addNewExporterInformation();
			exporterInfo.setExporterID(exporterId);
			
			AddressStructuredType exporterAddressDoc = exporterInfo.addNewAddressStructured();
			exporterAddressDoc.setName(exporter.getName());
			exporterAddressDoc.setStreet(exporterAddress.getStreet());
			exporterAddressDoc.setCity(exporterAddress.getCity());
			exporterAddressDoc.setCountrySubEntity(exporterAddress.getCountrySubEntity());
			exporterAddressDoc.setCountryCode(CountryCodedType.TH);
			exporterAddressDoc.setCountryName(thailand.getCountryName());
			exporterAddressDoc.setPostalZone(exporterAddress.getPostalZone());
			
			AddressStructuredType factoryAddressDoc = exporterInfo.addNewFactoryAddressStructured();
			factoryAddressDoc.setName(factoryAddress.getName());
			factoryAddressDoc.setStreet(factoryAddress.getStreet());
			factoryAddressDoc.setCity(factoryAddress.getCity());
			factoryAddressDoc.setCountrySubEntity(factoryAddress.getCountrySubEntity());
			factoryAddressDoc.setCountryCode(CountryCodedType.TH);
			factoryAddressDoc.setCountryName(thailand.getCountryName());
			factoryAddressDoc.setPostalZone(factoryAddress.getPostalZone());
			
			logger.debug("XML message constructed:");
			logger.debug(XmlBeansUtils.printXmlObject(root));
			
			// Send XML message to MSH
			MSHUtils.sentMshMessage(
				MSHConstants.PARTY_SINGLE_WINDOW,
				MSHConstants.PARTY_GOVERNMENT,
				MSHConstants.TARGET_GOVERNMENT, 
				ActionNames.CREATE_EXPORTER_CERTIFICATE, 
				XmlBeansUtils.printXmlObject(root)
			);
	
			// Set success message.
			request.setAttribute("successMessage", "ข้อมูลคำร้องของท่าน ได้ถูกบันทึกเรียบร้อยแล้ว");
			
			return mapping.findForward("success");
		}
		catch (Exception e) {
			logger.error(e);
			throw e;
		}
	}
}
