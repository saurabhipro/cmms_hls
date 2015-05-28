package com.iprosonic.cmms.modules.login.web;
 


import org.hibernate.Session;

import com.iprosonic.cmms.modules.masters.client.domain.ClientMasterBean;
import com.iprosonic.cmms.pjcommons.utility.HibernateSession;

public class Test {

	public static void main(String[] args) {
		Session session=HibernateSession.getSessionFactory().openSession();
		session.beginTransaction();
		ClientMasterBean c=(ClientMasterBean) session.get(ClientMasterBean.class, new Integer(12));
		System.out.println(c.getClientName());
		session.getTransaction().commit();
		session.close();
	}
}
