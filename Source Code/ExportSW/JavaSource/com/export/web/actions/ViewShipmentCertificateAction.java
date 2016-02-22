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
import com.export.domain.CertificateRequestDetail;
import com.export.framework.hibernate.HibernateSession;

public class ViewShipmentCertificateAction extends Action{ 

    private static Log logger = LogFactory.getLog(ViewShipmentCertificateAction.class);
    
    private CertificateRequestDAO certReqDAO = new CertificateRequestDAOHibernate();
	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
		logger.debug("Enter execute()");
		
		Long certTypeId = Long.valueOf(request.getParameter("certTypeId"));
		Long certReqId = Long.valueOf(request.getParameter("certReqId"));
		
		// Retrieve Hibernate session.
		Session session = HibernateSession.currentSession();
		
		CertificateRequestDetail detail = certReqDAO.getCertificateRequestDetail(session, certReqId, certTypeId);
		logger.debug("Retrieve CertificateRequestDetail: " + detail);
		
		request.setAttribute("detail", detail);

    	return mapping.findForward("success");
    }
}
