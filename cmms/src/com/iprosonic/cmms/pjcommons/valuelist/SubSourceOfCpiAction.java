package com.iprosonic.cmms.pjcommons.valuelist;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.iprosonic.cmms.modules.cpi.masters.assets.domain.AssetBean;
import com.iprosonic.cmms.modules.cpi.masters.group.domain.CpiMasterBean;
import com.iprosonic.cmms.pjcommons.utility.HibernateSession;

public class SubSourceOfCpiAction {
	
	public String getSubSourceOfCpiStr(String sourceOfCpi) {
		List<String> subSourceOfCpiList = null;
		String listString = "-Select-:";
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateSession.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Criteria subSourceOfCpiCriteria = session
					.createCriteria(CpiMasterBean.class);
			subSourceOfCpiCriteria.add(Restrictions.like("sourceOfCpi", sourceOfCpi));
			subSourceOfCpiCriteria.setProjection(Projections
					.distinct(Projections.property("subSourceOfCpi")));
			subSourceOfCpiList = subSourceOfCpiCriteria.list();

			for (String values : subSourceOfCpiList) {
				listString += values + ":";
				
			}

		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();

		} finally {
			if (session.isConnected()) {
				session.close();
				HibernateSession.shoutDown();
			}

		}

		return listString;

	}
	
	
	
	public String getSectionName(String assetCd, String type) {
		List<String> sectionNameList = null;

		Session session = null;
		Transaction transaction = null;
		Criteria criteria = null;
		String listString = "-Select-:";

		try {
			session = HibernateSession.getSessionFactory().openSession();
			transaction = session.beginTransaction();

			if (type.equalsIgnoreCase("getSectionName1")) {
				criteria = session.createCriteria(AssetBean.class);
				//criteria.add(Restrictions.like("assetCd", assetCd));
				criteria.setProjection(Projections.distinct(Projections.property("sectionCd")));
				sectionNameList = criteria.list();
			}

			for (String assetSr1 : sectionNameList) {
				listString += assetSr1 + ":";
			}

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
		return listString;
	}


}
