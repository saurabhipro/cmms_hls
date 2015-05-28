package com.iprosonic.cmms.pjcommons.valuelist;


import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;

import com.iprosonic.cmms.modules.cpi.transactions.cpi.domain.CpiBean;
import com.iprosonic.cmms.pjcommons.utility.HibernateSession;

public class CPICdListAction 
{
	public List<String> getCpiCdList() {
		List<String> cpiCdList = null;
		Session session = null;
		Transaction transaction = null;
		Criteria criteria = null;
		try {
			session = HibernateSession.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			criteria = session.createCriteria(CpiBean.class);
			criteria.setProjection(Projections.distinct(Projections
					.property("cpiCd")));
			cpiCdList = criteria.list();

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
		return cpiCdList;
	}
}