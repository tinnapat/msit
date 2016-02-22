package com.export.web.actions;

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
import org.hibernate.Session;

import com.export.dao.ExporterDAO;
import com.export.dao.hibernate.ExporterDAOHibernate;
import com.export.domain.ExporterCertificateStatus;
import com.export.framework.hibernate.HibernateSession;
import com.export.web.util.WebUtils;

public class ViewExporterCertificateAction extends Action {
	
	private ExporterDAO exporterDAO = new ExporterDAOHibernate();
	
	private static Log logger = LogFactory.getLog(ViewExporterCertificateAction.class);

    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
    	logger.debug("Enter execute.");
    	
		// Check if exporter is logged in
		if (!WebUtils.isUserLoggedIn(request)) {
			return mapping.findForward("error");
		}
    	
    	ActionErrors errors = new ActionErrors();
    	
    	String certTypeId = request.getParameter("certTypeId");
    	String exporterId = WebUtils.getCurrentExporterId(request);
    	
    	logger.debug("Retrieving certificate request information for exporter: " + exporterId + ", certificate type: " + certTypeId);
    	
    	Session session = HibernateSession.currentSession();
    	ExporterCertificateStatus status = exporterDAO.getExporterCertStatus(session, exporterId, Long.valueOf(certTypeId));
    	logger.debug("Retrieve exporter certificate status: " + status);
    	
    	// Error if exporter certificate status not exist.
    	if (status == null) {
    		ActionError error = new ActionError("exporter.cert.not.found", exporterId, certTypeId);
    		errors.add(ActionErrors.GLOBAL_ERROR, error);
    		
    		saveErrors(request, errors);
    		return mapping.findForward("error");
    	}
    	
    	// Save data to request.
    	request.setAttribute("exporterCertStatus", status);

    	return mapping.findForward("success");
    }
}
