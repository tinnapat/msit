package governmentapp.web.actions;

import java.util.List;

import governmentapp.domain.CertificateRequest;
import governmentapp.domain.ExporterCertificateRequestDetail;
import governmentapp.domain.RequestStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.Session;

import com.export.framework.hibernate.HibernateSession;

public class ExporterCertRequestDetailAction extends Action {
	
	private static Log logger = LogFactory.getLog(ExporterCertRequestDetailAction.class);

    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
    	logger.debug("Enter execute.");
    	
    	String certId = request.getParameter("requestId");
    	
    	// Query to Hibernate.
    	Session session = HibernateSession.currentSession();
    	CertificateRequest certRequest = (CertificateRequest) session.get(CertificateRequest.class, Long.valueOf(certId));
    	ExporterCertificateRequestDetail detail = (ExporterCertificateRequestDetail) session.get(ExporterCertificateRequestDetail.class, Long.valueOf(certId));
    	
    	// Query all status to render select box.
    	List statuses = session.createCriteria(RequestStatus.class).list();

    	logger.debug("certRequest: " + certRequest);
    	logger.debug("detail: " + detail);
    	logger.debug("statuses: " + statuses);
    	
    	// Save result to request.
    	request.setAttribute("certRequest", certRequest);
    	request.setAttribute("detail", detail);
    	request.setAttribute("statuses", statuses);

    	return mapping.findForward("success");
    }
}
