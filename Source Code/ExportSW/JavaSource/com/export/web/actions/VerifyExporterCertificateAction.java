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

import com.export.dao.ExporterDAO;
import com.export.dao.hibernate.ExporterDAOHibernate;
import com.export.domain.ExporterCertificateStatus;
import com.export.framework.hibernate.HibernateSession;
import com.export.vo.ExporterCertificateStatusVO;
import com.export.web.forms.VerifyExporterCertificateForm;
import com.export.web.util.WebUtils;
import com.tinnapat.util.security.CryptographyUtil;
import com.tinnapat.util.security.KeyUtil;

public class VerifyExporterCertificateAction extends Action {
	
	private static Log logger = LogFactory.getLog(VerifyExporterCertificateAction.class);
	
	private ExporterDAO exporterDAO = new ExporterDAOHibernate();

    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
    	logger.debug("Enter execute.");
    	
		// Check if exporter is logged in
		if (!WebUtils.isUserLoggedIn(request)) {
			return mapping.findForward("error");
		}
    	
    	VerifyExporterCertificateForm f = (VerifyExporterCertificateForm) form;
    	String exporterCertStatusId = f.getExporterCertRequestId();
    	FormFile certificateFile = f.getCertificateFile();
    	
    	// Retrieve exporter certificate status.
    	Session session = HibernateSession.currentSession();
    	ExporterCertificateStatus exporterCertStatus = exporterDAO.getExporterCertStatus(session, Long.valueOf(exporterCertStatusId));
    	logger.debug("Retrieve exporter certificate status: " + exporterCertStatus);
    	
    	if (exporterCertStatus == null) {
    		return mapping.findForward("error");
    	}
    	
    	// Read certificate file.
    	InputStream is = certificateFile.getInputStream();
    	X509Certificate cert = KeyUtil.readX509Certificate(is);
    	
    	// Prepare VO for digesting.
    	ExporterCertificateStatusVO vo = new ExporterCertificateStatusVO();
		vo.setExporterId(exporterCertStatus.getExporterId());
		vo.setCertificateTypeCode(exporterCertStatus.getCertificateType().getId().toString());
		vo.setIssueDate(exporterCertStatus.getIssueDate());
		vo.setExpireDate(exporterCertStatus.getExpireDate());
		vo.setIssueBy(exporterCertStatus.getIssueBy());
		vo.setStatusCode(exporterCertStatus.getStatusCode());
    	
    	String text = vo.encode();
    	
    	logger.debug("Verifying exporter certificate request status.");
    	logger.debug("text: " + text);
    	logger.debug("signature: " + exporterCertStatus.getSignature());
    	logger.debug("certificate: " + cert);
    	boolean verify = CryptographyUtil.verify(text, cert, exporterCertStatus.getSignature());
    	logger.debug("Verification result: " + verify);
    	
    	// Save result to request.
    	request.setAttribute("certText", cert.toString());
    	request.setAttribute("signature", exporterCertStatus.getSignature());
    	request.setAttribute("verifyResult", new Boolean(verify));
    	
    	return mapping.findForward("success");
    }
}

