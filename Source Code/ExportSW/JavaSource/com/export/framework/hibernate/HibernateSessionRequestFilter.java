package com.export.framework.hibernate;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;

public class HibernateSessionRequestFilter implements Filter {
	
	private Log logger = LogFactory.getLog(HibernateSessionRequestFilter.class);

	public void init(FilterConfig config) throws ServletException { 
		logger.info("HibernateSessionRequestFilter initialized.");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		try {
			logger.debug("Starting a database transaction.");
			Session session = HibernateSession.currentSession();
			session.beginTransaction();
			
			// Continue processing
			chain.doFilter(request, response);
			
			logger.debug("Commiting the database transaction");
			session.getTransaction().commit();
		}
		catch (Exception e) {
			logger.error("Exception occurs", e);
			
			// Rollback only
			try {
				if (HibernateSession.currentSession().getTransaction().isActive()) {
					logger.debug("Trying to rollback database transaction after exception");
					HibernateSession.currentSession().getTransaction().rollback();
				}
			}
			catch (Exception ee) {
				logger.error("Could not rollback database transaction after exception", ee);
			}
			
			throw new ServletException(e);
		}
	}

	public void destroy() {
		logger.info("HibernateSessionRequestFilter destroyed.");
	}

}
