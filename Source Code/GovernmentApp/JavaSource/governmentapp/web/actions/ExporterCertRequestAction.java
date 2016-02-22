package governmentapp.web.actions;

import governmentapp.domain.CertificateRequest;
import governmentapp.domain.RequestStatus;

import java.util.List;

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

public class ExporterCertRequestAction extends Action {

    private static Log logger = LogFactory.getLog(ExporterCertRequestAction.class);
    
	public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
		logger.debug("Enter execute.");
		
    	Session session = HibernateSession.currentSession();
    	List exporterCertRequests = session.createCriteria(CertificateRequest.class).list();
    	List statuses = session.createCriteria(RequestStatus.class).list();

    	logger.debug("exporterCertRequests: " + exporterCertRequests);
    	logger.debug("statuses: " + statuses);
    	
    	// Save beans to request.
    	request.setAttribute("exporterCertRequests", exporterCertRequests);
    	request.setAttribute("requestStatuses", statuses);
    	
    	return mapping.findForward("success");
    }
}
