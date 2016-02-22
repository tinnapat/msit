package governmentapp.actions;

import governmentapp.domain.CertificateRequest;
import governmentapp.forms.UpdateExporterCerificateForm;

import java.io.InputStream;
import java.security.PrivateKey;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;
import org.hibernate.Session;

import th.ac.ku.singlewindow.schema.ExporterCertificateUpdateMsgDocument;

import com.export.framework.hibernate.HibernateSession;
import com.export.msh.ActionNames;
import com.export.msh.MSHConstants;
import com.export.msh.MSHUtils;
import com.export.util.DateUtils;
import com.export.util.XmlBeansUtils;
import com.export.vo.ExporterCertificateStatusVO;
import com.tinnapat.util.security.CryptographyUtil;
import com.tinnapat.util.security.KeyUtil;

public class UpdateExporterCertificateAction extends Action {
	
	private static Log logger = LogFactory.getLog(UpdateExporterCertificateAction.class);

    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
    	logger.debug("Enter execute()");

    	UpdateExporterCerificateForm f = (UpdateExporterCerificateForm) form;
    	
    	// Read private key file.
    	FormFile keyFile = f.getPrivateKeyFile();
    	InputStream is = keyFile.getInputStream();
    	PrivateKey key = null;
    	try {
    		key = KeyUtil.readRSAPrivateKey(is);
    	}
    	catch (Exception e) {
    		ActionErrors errors = new ActionErrors();
    		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("privateKey.invalid"));
    		saveErrors(request, errors);
    		return mapping.getInputForward();
    	}
    	
    	// Prepare VO for digesting.
    	ExporterCertificateStatusVO vo = new ExporterCertificateStatusVO();
		vo.setExporterId(f.getExporterId());
		vo.setCertificateTypeCode(f.getCertificateTypeCode());
		vo.setIssueDate(f.getIssueDate());
		vo.setExpireDate(f.getExpireDate());
		vo.setIssueBy(f.getIssueBy());
		vo.setStatusCode(f.getStatusCode());
    	String text = vo.encode();
    	
    	logger.debug("Signing exporter certificate request status");
    	logger.debug("text: " + text);
    	logger.debug("private key: " + key);
    	
    	String signature = CryptographyUtil.sign(text, key);
    	logger.debug("signature: " + signature);
    	
		// Construct XML payload message.
    	ExporterCertificateUpdateMsgDocument root = ExporterCertificateUpdateMsgDocument.Factory.newInstance();
		ExporterCertificateUpdateMsgDocument.ExporterCertificateUpdateMsg msg = root.addNewExporterCertificateUpdateMsg();
		msg.setExporterId(f.getExporterId());
		msg.setCertificateTypeCode(f.getCertificateTypeCode());
		msg.setStatusCode(f.getStatusCode());
		msg.setIssueBy(f.getIssueBy());
		msg.setSignature(signature);
		
		Date issueDateDate = DateUtils.stringToDate(f.getIssueDate());
		if (issueDateDate != null) {
			Calendar issueDate = new GregorianCalendar();
			issueDate.setTime(issueDateDate);
			msg.setIssueDate(issueDate);
		}
		
		Date expireDateDate = DateUtils.stringToDate(f.getExpireDate());
		if (expireDateDate != null) {
			Calendar expireDate = new GregorianCalendar();
			expireDate.setTime(expireDateDate);
			msg.setExpireDate(expireDate);
		}
		
		// Send message to MSH
		MSHUtils.sentMshMessage(
			MSHConstants.PARTY_GOVERNMENT,
			MSHConstants.PARTY_SINGLE_WINDOW,
			MSHConstants.TARGET_SINGLE_WINDOW, 
			ActionNames.UPDATE_EXPORTER_CERTIFICATE, 
			XmlBeansUtils.printXmlObject(root)
		);
    	
		// Update certificate request detail status.
    	Session session = HibernateSession.currentSession();
    	CertificateRequest certRequest = (CertificateRequest) session.get(CertificateRequest.class, Long.valueOf(f.getCertificateRequestId()));
    	certRequest.setStatusCode(f.getStatusCode());
    	session.flush();
		
		String successMsg = "ปรับปรุงข้อมูลคำร้องเรียบร้อยแล้ว";
    	request.setAttribute("successMessage", successMsg);
    	
		return mapping.findForward("success");
    }
}
