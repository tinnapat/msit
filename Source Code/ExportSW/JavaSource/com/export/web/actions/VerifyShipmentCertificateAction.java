package com.export.web.actions;

import java.io.InputStream;
import java.security.cert.X509Certificate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;
import org.hibernate.Session;

import com.export.dao.CertificateRequestDAO;
import com.export.dao.ExporterDAO;
import com.export.dao.hibernate.CertificateRequestDAOHibernate;
import com.export.dao.hibernate.ExporterDAOHibernate;
import com.export.domain.CertificateRequestDetail;
import com.export.framework.hibernate.HibernateSession;
import com.export.util.DateUtils;
import com.export.vo.ShipmentCertificateStatusVO;
import com.export.web.forms.VerifyShipmentCertificateForm;
import com.export.web.util.WebUtils;
import com.tinnapat.util.security.CryptographyUtil;
import com.tinnapat.util.security.KeyUtil;

public class VerifyShipmentCertificateAction extends Action {
	
	private static Log logger = LogFactory.getLog(VerifyShipmentCertificateAction.class);
	
	private ExporterDAO exporterDAO = new ExporterDAOHibernate();
	private CertificateRequestDAO crDAO = new CertificateRequestDAOHibernate();

    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
    	logger.debug("Enter execute.");
    	
		// Check if exporter is logged in
		if (!WebUtils.isUserLoggedIn(request)) {
			return mapping.findForward("error");
		}
    	
    	VerifyShipmentCertificateForm f = (VerifyShipmentCertificateForm) form;
    	String certificateStatusId = f.getCertificateRequestId();
    	String certificateTypeId = f.getCertificateTypeId();
    	FormFile certificateFile = f.getCertificateFile();
    	
    	// Retrieve exporter certificate status.
    	Session session = HibernateSession.currentSession();
    	CertificateRequestDetail detail = crDAO.getCertificateRequestDetail(session, Long.valueOf(certificateStatusId), Long.valueOf(certificateTypeId));
    	logger.debug("Retrieve shipment certificate status: " + detail);
    	
    	if (detail == null) {
    		return mapping.findForward("error");
    	}
    	
    	// Read certificate file.
    	InputStream is = certificateFile.getInputStream();
    	X509Certificate cert = KeyUtil.readX509Certificate(is);
    	
    	// Prepare VO for digesting.
    	ShipmentCertificateStatusVO vo = new ShipmentCertificateStatusVO();
		vo.setCertificateRequestId(detail.getCertificateRequestId().toString());
		vo.setCertificateTypeId(detail.getCertificateTypeId().toString());
		vo.setIssueDate(DateUtils.dateToString(detail.getIssueDate()));
		vo.setExpireDate(DateUtils.dateToString(detail.getExpireDate()));
		vo.setIssueBy(detail.getIssueBy());
		vo.setStatusCode(detail.getStatusCode());
    	
    	String text = vo.encode();
    	
    	logger.debug("Verifying shipment certificate request status.");
    	logger.debug("text: " + text);
    	logger.debug("signature: " + detail.getSignature());
    	logger.debug("certificate: " + cert);
    	boolean verify = CryptographyUtil.verify(text, cert, detail.getSignature());
    	logger.debug("Verification result: " + verify);
    	
    	// Save result to request.
    	request.setAttribute("certText", cert.toString());
    	request.setAttribute("signature", detail.getSignature());
    	request.setAttribute("verifyResult", new Boolean(verify));
    	
    	return mapping.findForward("success");
    }
}
