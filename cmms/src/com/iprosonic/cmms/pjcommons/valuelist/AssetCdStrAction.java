package com.iprosonic.cmms.pjcommons.valuelist;


import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.iprosonic.cmms.modules.cpi.masters.assets.domain.AssetBean;
import com.iprosonic.cmms.pjcommons.utility.HibernateSession;

public class AssetCdStrAction {
	public String getAssetCd(String assetType) {
		Session session = null;
		Transaction transaction = null;
		List<String> assetCdList = null;
		String listString = "-Select-:";
		Criteria criteria = null;
		try {
			session = HibernateSession.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			criteria = session.createCriteria(AssetBean.class);
			criteria.add(Restrictions.like("assetType", assetType));
			criteria.setProjection(Projections.distinct(Projections
					.property("assetCd")));
			assetCdList = criteria.list();
			for (String s : assetCdList) {
				listString += s + ":";
			}
			transaction.commit();
		} catch (HibernateException e) {
			if (transaction.wasCommitted()) {
				transaction.rollback();
				e.printStackTrace();
			}
			e.printStackTrace();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return listString;
	}

	public static List<String> getAssetCdList() {
		List<String> assetCdList = null;
		Session session = null;
		Transaction transaction = null;
		Criteria criteria = null;
		try {
			session = HibernateSession.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			criteria = session.createCriteria(AssetBean.class);
			criteria.setProjection(Projections.distinct(Projections
					.property("assetCd")));
			assetCdList = criteria.list();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}

		finally {
			if (session.isConnected()) {
				session.close();
				
			}
		}

		return assetCdList;
	}

}
