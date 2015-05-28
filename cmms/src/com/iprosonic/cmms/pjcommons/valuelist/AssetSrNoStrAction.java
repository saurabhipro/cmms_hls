package com.iprosonic.cmms.pjcommons.valuelist;



import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.iprosonic.cmms.modules.cpi.masters.assets.domain.AssetBean;
import com.iprosonic.cmms.modules.cpi.transactions.cpi.domain.CpiBean;
import com.iprosonic.cmms.pjcommons.utility.HibernateSession;

public class AssetSrNoStrAction {
	public String getAssetSrNo(String assertCd1, String type) {

		List<String> assetSrNo1List = null;
		Session session = null;
		Transaction transaction = null;
		Criteria criteria = null;
		String listString = "-Select-:";

		try {

			session = HibernateSession.getSessionFactory().openSession();

			if (type.equalsIgnoreCase("getAssetSrNo1")) {
				
				criteria = session.createCriteria(AssetBean.class);
				transaction = session.beginTransaction();
				criteria.add(Restrictions.like("assetCd", assertCd1));
				criteria.setProjection(Projections.distinct(Projections
						.property("assetSerialNo")));
				assetSrNo1List = criteria.list();

				for (String assetSrNo : assetSrNo1List) {

					listString += assetSrNo + ":";
					

				}

				transaction.commit();
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

	public Set<String> getAssetSrNo() {
		Set<String> set = null;
		Session session = null;
		Transaction transaction = null;
		Criteria criteria = null;
		try {
			set = new HashSet<String>();
			session = HibernateSession.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			criteria = session.createCriteria(CpiBean.class);
			criteria.setProjection(Projections.property("assetSrNo1"));
			Iterator<String> itr = criteria.list().iterator();
			while (itr.hasNext()) {
				String assetSrNo = itr.next();
				set.add(assetSrNo);
			}
			transaction.commit();

		} catch (Exception e) {
		} finally {
			session.close();
		}
		return set;

	}

	
	public static List<String> getSerialNoList() {
		List<String> assetCdList = null;
		Session session = null;
		Transaction transaction = null;
		Criteria criteria = null;
		try {
			session = HibernateSession.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			criteria = session.createCriteria(AssetBean.class);
			criteria.setProjection(Projections.distinct(Projections
					.property("assetSerialNo")));
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
