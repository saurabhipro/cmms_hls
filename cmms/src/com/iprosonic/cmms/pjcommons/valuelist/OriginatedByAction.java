package com.iprosonic.cmms.pjcommons.valuelist;


import java.util.Collections;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;

import com.iprosonic.cmms.modules.masters.user.domain.EmployeeBean;
import com.iprosonic.cmms.pjcommons.utility.HibernateSession;

public class OriginatedByAction {
	public List<String> getOriginatedBy1() {
		List<String> employeeList = null;
		Session session = null;
		Transaction transaction = null;
		String listString = "-select-:";
		Criteria criteria = null;
		try {
			session = HibernateSession.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			criteria = session.createCriteria(EmployeeBean.class);
			ProjectionList projectionList = Projections.projectionList();
			projectionList.add(Projections.property("employeeName"));
			criteria.setProjection(projectionList);
			employeeList = criteria.list();
			Collections.sort(employeeList);

			
		} catch (Exception e) {
			if (transaction.wasCommitted()) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session.isConnected()) {
				session.close();
				HibernateSession.shoutDown();
			}
		}
		return employeeList;

	}

}
