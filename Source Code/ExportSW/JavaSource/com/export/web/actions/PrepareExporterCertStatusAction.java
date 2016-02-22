package com.export.web.actions;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.Session;

import com.export.dao.CertificateTypeDAO;
import com.export.dao.ExporterDAO;
import com.export.dao.hibernate.CertificateTypeDAOHibernate;
import com.export.dao.hibernate.ExporterDAOHibernate;
import com.export.domain.CertificateType;
import com.export.domain.Exporter;
import com.export.domain.ExporterCertificateStatus;
import com.export.framework.hibernate.HibernateSession;
import com.export.web.util.WebUtils;

public class PrepareExporterCertStatusAction extends Action {
	
	private static Log logger = LogFactory.getLog(PrepareExporterCertStatusAction.class);
	
	private ExporterDAO exporterDAO 				= new ExporterDAOHibernate();
	private CertificateTypeDAO certificateTypeDAO 	= new CertificateTypeDAOHibernate();

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

		Session session = HibernateSession.currentSession();
		
		HttpSession httpSession = request.getSession();
		Exporter exporter = (Exporter) httpSession.getAttribute("exporter");
		String exporterId = exporter.getExporterId();
		
		List certStatuses = new ArrayList();
    	// Retrieve all exporter certificate type.
    	List exporterCerts = certificateTypeDAO.getAllExporterCertificateTypes(session);
    	for (Iterator i = exporterCerts.iterator(); i.hasNext(); ) {
    		CertificateType certType = (CertificateType) i.next();
    		Long certTypeId = certType.getId();
    		
    		ExporterCertificateStatus status = exporterDAO.getExporterCertStatus(session, exporterId, certTypeId);
    		// If this certificate type does not exist, create one.
    		if (status == null) {
    			status = new ExporterCertificateStatus();
    			status.setExporterId(exporterId);
    			status.setCertificateType(certType);
    			status.setStatusCode("X");
    			status.setCreateDate(new Date());
    			
    			Long id = exporterDAO.createExporterCertificateStatus(session, status);
    			logger.debug("New ExporterCertificateStatus created with id: " + id);
    			
    			// Refresh object.
    			session.refresh(status);
    		}
			certStatuses.add(status);
    	}
    	
    	// Retrieve exporter's certificate statuses.
    	logger.debug("Retrieved certificate statuses of exporterId: " + exporterId);
    	logger.debug(certStatuses);

    	request.setAttribute("exporterCertStatuses", certStatuses);
    	
    	return mapping.findForward("success");
	}
}
