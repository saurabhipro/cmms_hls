package com.iprosonic.cmms.pjcommons.utility;



import org.hibernate.cfg.*;
import org.hibernate.SessionFactory;

public class HibernateSession {
	private static SessionFactory sessionFactory;
	static {
		try {
			Configuration configuration = new AnnotationConfiguration();
			
			synchronized (HibernateSession.class) {
				sessionFactory =  configuration.configure()
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