package com.export.web;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;

import com.export.dao.CertificateTypeDAO;
import com.export.dao.UtilityDAO;
import com.export.dao.hibernate.CertificateTypeDAOHibernate;
import com.export.dao.hibernate.UtilityDAOHibernate;
import com.export.framework.hibernate.HibernateSession;
import com.export.web.util.Constants;

public class InitServlet extends HttpServlet {

	private static Log logger = LogFactory.getLog(InitServlet.class);
	
	public void init() throws ServletException {
		logger.debug("Enter init()");
		
		Session session = HibernateSession.currentSession();
		
		// Create DAO
		UtilityDAO utilDAO = new UtilityDAOHibernate();
    	CertificateTypeDAO certificateTypeDAO = new CertificateTypeDAOHibernate();

    	// Query
    	List provinces = utilDAO.getAllProvinces(session);
    	List countries = utilDAO.getAllCountries(session);
    	List transportModes = utilDAO.getAllTransportModes(session);
    	List thaiLocations = utilDAO.getAllThaiLocations(session);
    	List locations = utilDAO.getAllThaiLocations(session);
		List certificateTypes = certificateTypeDAO.getAllCertificateTypes(session);
		List currencies = utilDAO.getAllCurrency(session);
		
		HibernateSession.closeSession();
		
		// Store result in ServletContext
		getServletContext().setAttribute("provinces", provinces);
		getServletContext().setAttribute("countries", countries);
		getServletContext().setAttribute("transportModes", transportModes);
		getServletContext().setAttribute("thaiLocations", thaiLocations);
		getServletContext().setAttribute("locations", locations);
		getServletContext().setAttribute("currencies", currencies);
		getServletContext().setAttribute(Constants.CERTIFICATE_TYPE, certificateTypes);
		
		logger.debug("Init servlet initizized!!");
	}

}