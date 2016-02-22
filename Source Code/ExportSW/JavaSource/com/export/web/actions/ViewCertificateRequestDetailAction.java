package com.export.web.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.Session;

import com.export.dao.CertificateRequestDAO;
import com.export.dao.hibernate.CertificateRequestDAOHibernate;
import com.export.domain.CertificateRequest;
import com.export.framework.hibernate.HibernateSession;
import com.export.util.StringUtil;
import com.export.web.util.WebUtils;

public class ViewCertificateRequestDetailAction extends Action {

    private static Log logger = LogFactory.getLog(ViewCertificateRequestDetailAction.class);
    
    private CertificateRequestDAO crDAO = new CertificateRequestDAOHibernate();
	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

		logger.debug("Enter execute()");
		
		try {
			// Check if exporter is logged in
			if (!WebUtils.isUserLoggedIn(request)) {
				logger.warn("User not logged in.");
				return mapping.findForward("error");
			}
			
			String crId = request.getParameter("crId");
			if (!StringUtil.isValidString(crId)) {
				logger.error("Parameter 'crId' not found.");
				return mapping.findForward("error");
			}
		
			Session session = HibernateSession.currentSession();
			session.clear();
			CertificateRequest certificateRequest = crDAO.getCertificateRequestById(session, Long.valueOf(crId));
			logger.debug("CertificateRequest retrieved: " + certificateRequest);
			
			request.setAttribute("certificateRequest", certificateRequest);
		}
		catch (Exception e) {
			logger.error("Exception in execute()", e);
			throw e;
		}

    	return mapping.findForward("success");
    }
}
