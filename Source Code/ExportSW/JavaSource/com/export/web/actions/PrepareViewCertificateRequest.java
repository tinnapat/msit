package com.export.web.actions;

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

import com.export.dao.CertificateRequestDAO;
import com.export.dao.hibernate.CertificateRequestDAOHibernate;
import com.export.framework.hibernate.HibernateSession;
import com.export.web.util.WebUtils;

public class PrepareViewCertificateRequest extends Action {

	private static Log logger = LogFactory.getLog(PrepareViewCertificateRequest.class);
	
	private CertificateRequestDAO crDAO = new CertificateRequestDAOHibernate();
	
	/* (non-Javadoc)
	 * @see org.apache.struts.action.Action#execute(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		logger.debug("Enter execute()");
		
		// Check if exporter is logged in
		if (!WebUtils.isUserLoggedIn(request)) {
			return mapping.findForward("error");
		}
		
		// Query current exporter's certificate request.
		Session session = HibernateSession.currentSession();
		List certificateRequests = crDAO.getCertificateRequestByExporterId(session, WebUtils.getCurrentExporterId(request));
		HibernateSession.closeSession();
		
		// Store result in request
		request.setAttribute("certificateRequests", certificateRequests);
		
		return mapping.findForward("success");
	}
}
