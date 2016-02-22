package com.export.web.actions;

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

import com.export.dao.ExporterDAO;
import com.export.dao.hibernate.ExporterDAOHibernate;
import com.export.domain.Exporter;
import com.export.framework.hibernate.HibernateSession;
import com.export.web.util.WebUtils;

public class PrepareViewExporterAction extends Action {

	private static Log logger = LogFactory.getLog(PrepareViewExporterAction.class);
	
	private ExporterDAO exporterDAO = new ExporterDAOHibernate();
	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		logger.debug("Enter execute.");
		
		// Check if exporter is logged in
		if (!WebUtils.isUserLoggedIn(request)) {
			return mapping.findForward("error");
		}
		
		HttpSession httpSession = request.getSession();
		Exporter exporter = (Exporter) httpSession.getAttribute("exporter");
		
		Session session = HibernateSession.currentSession();
		exporter = exporterDAO.getExporter(session, exporter.getExporterId());
		httpSession.setAttribute("exporter", exporter);
		
		return mapping.findForward("success");
	}
}
