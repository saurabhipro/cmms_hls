package com.iprosonic.cmms.pjcommons.valuelist;


import java.util.Collections; 
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;

import com.iprosonic.cmms.modules.masters.user.domain.EmployeeBean;
import com.iprosonic.cmms.pjcommons.utility.HibernateSession;

public class EmployeeCdListAction {
	public List<String> getOriginatedByString() {
		List<String> originatedByCdList = null;
		Transaction transaction = null;

		Session session = null;
		try {
			session = HibernateSession.getSessionFactory().openSession();
			transaction = session.beginTransaction();

			Criteria criteria = session.createCriteria(EmployeeBean.class);
			criteria.setProjection(Projections.distinct(Projections
					.property("employeeName")));
			
			originatedByCdList = criteria.list();
			Collections.sort(originatedByCdList);
			transaction.commit();
			session.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		

		return originatedByCdList;
	}




}