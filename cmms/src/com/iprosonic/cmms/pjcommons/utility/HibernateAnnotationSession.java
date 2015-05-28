package com.iprosonic.cmms.pjcommons.utility;


import org.hibernate.cfg.*;
import org.hibernate.SessionFactory;

public class HibernateAnnotationSession {
	private static SessionFactory sessionFactory;
	static {
		try {
			Configuration configuration = new AnnotationConfiguration();
			
			synchronized (HibernateAnnotationSession.class) {
				sessionFactory =  configuration.configure("hibernate.cfg.xml")
						.buildSessionFactory();
			}
		} catch (Throwable ex) {
			ex.printStackTrace();
			throw new ExceptionInInitializerError(ex);
		}
	}
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void shoutDown() {
		sessionFactory.close();
	}
}