package com.export.web.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.Session;

import com.export.dao.CertificateTypeDAO;
import com.export.dao.ExporterDAO;
import com.export.dao.hibernate.CertificateTypeDAOHibernate;
import com.export.dao.hibernate.ExporterDAOHibernate;
import com.export.domain.Exporter;
import com.export.framework.hibernate.HibernateSession;
import com.export.web.forms.LoginForm;

/**
 * @version 	1.0
 * @author
 */
public class LoginAction extends Action {
	
	private static Log logger = LogFactory.getLog(LoginAction.class);

	private ExporterDAO exporterDAO 				= new ExporterDAOHibernate();
	private CertificateTypeDAO certificateTypeDAO 	= new CertificateTypeDAOHibernate();
	
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

    	logger.debug("Enter execute()");
    	
        ActionErrors errors = new ActionErrors();
        ActionForward forward = new ActionForward(); // return value
        LoginForm f = (LoginForm) form;

        try {
        	Session session = HibernateSession.currentSession();
        	
        	String exporterId = f.getExporterId();
        	
        	logger.debug("Retrieving exporter with exporterId: " + exporterId);
        	Exporter exporter = exporterDAO.getExporter(session, exporterId);
        	logger.debug("exporter: " + exporter);

        	// Return error if exporter does not exist.
        	if (exporter == null) {
        		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("exporter.not.exist", f.getExporterId()));
                saveErrors(request, errors);
        		return mapping.getInputForward();
        	}
        	// Verify password
        	if (!f.getPassword().equals(exporter.getPassword())) {
        		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("password.invalid"));
                saveErrors(request, errors);
        		return mapping.getInputForward();
        	}
        	
        	// Store exporter information in HttpSession.
        	HttpSession httpSession = request.getSession();
        	httpSession.setAttribute("exporter", exporter);
        }
        catch (Exception e) {
        	e.printStackTrace();
        	logger.error("Exception in execute.", e);
        	throw e;
        }

        // Write logic determining how the user should be forwarded.
        forward = mapping.findForward("success");

        // Finish with
        return (forward);

    }
}
