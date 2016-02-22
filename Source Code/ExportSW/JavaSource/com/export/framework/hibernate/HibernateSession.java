package com.export.framework.hibernate;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateSession {
	
	private static Log log = LogFactory.getLog(HibernateSession.class);

	private static final SessionFactory sessionFactory;

	/**
	 * Initialize Hibernate session factory.
	 */
	static {
		try {
			// Create the SessionFactory
			sessionFactory = new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			// Make sure you log the exception, as it might be swallowed
			log.error("Initial SessionFactory creation failed.", ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	/**
	 * Hibernate session associated with current thread.
	 */
	public static final ThreadLocal session = new ThreadLocal();

	/**
	 * Obtain Hibernate session object associated with current thread. If current thread has no Hibernate session,
	 * it will be created.
	 * @return Hibernate session associated with current thread.
	 */
	public static Session currentSession() {
		Session s = (Session) session.get();
		// Open a new Session, if this Thread has none yet
		if (s == null) {
			s = sessionFactory.openSession();
			session.set(s);
		}
		return s;
	}

	/**
	 * Close Hibernate session associated with current thread.
	 */
	public static void closeSession() {
		// Now implemented using Filter.
		/*
		Session s = (Session) session.get();
		if (s != null) {
			s.flush();
			s.close();
		}
		session.set(null);
		*/
	}	

}
