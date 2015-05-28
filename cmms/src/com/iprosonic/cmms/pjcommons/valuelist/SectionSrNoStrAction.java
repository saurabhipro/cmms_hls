package com.iprosonic.cmms.pjcommons.valuelist;

import java.util.Collections;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.iprosonic.cmms.modules.cpi.masters.assets.domain.AssetBean;
import com.iprosonic.cmms.modules.cpi.transactions.cpi.domain.CpiBean;
import com.iprosonic.cmms.pjcommons.utility.HibernateSession;

public class SectionSrNoStrAction {
	public String getSectionSrNo(String sectionName, String type) {
		List<String> sectionSrNoList = null;
		Session session = null;
		String listString = "-Select-:";
		Criteria criteria = null;
		try {
			session = HibernateSession.getSessionFactory().openSession();
			if (type.equalsIgnoreCase("getSectionSerialNo1")) {
				criteria = session.createCriteria(AssetBean.class);
				criteria.add(Restrictions.like("sectionCd", sectionName));
				criteria.setProjection(Projections.distinct(Projections.property("sectionSerialNo")));
				sectionSrNoList = criteria.list();
			}
			for (String assetSr1 : sectionSrNoList) {
				listString += assetSr1 + ":";
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session.isConnected()) {
				session.close();
				HibernateSession.shoutDown();
			}
		}
		return listString;

	}

	public String getSectionSrNo(String sectionSerialNo) {

		List<String> sectionSrNoList = null;
		Session session = null;
		String listString = "-Select-:";
		Criteria criteria = null;
		try {
			session = HibernateSession.getSessionFactory().openSession();
			criteria = session.createCriteria(AssetBean.class);
			criteria.add(Restrictions.like("assetSerialNo", sectionSerialNo));
			criteria.setProjection(Projections.distinct(Projections.property("sectionSerialNo")));
			sectionSrNoList = criteria.list();
			Collections.sort(sectionSrNoList);
			for (String assetSr1 : sectionSrNoList) {
				listString += assetSr1 + ":";
			}
		} catch (Exception e) {
		}
		return listString;
	}

	public List<String> getSectionSrNoList() {
		List<String> sectionSrNoList = null;
		Session session = null;
		Criteria criteria = null;
		try {
			session = HibernateSession.getSessionFactory().openSession();
			criteria = session.createCriteria(CpiBean.class);
			criteria.setProjection(Projections.distinct(Projections.property("sectionSerialNo")));
			sectionSrNoList = criteria.list();
			System.out.println("Serial no." + sectionSrNoList);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session.isConnected()) {
				session.close();
				HibernateSession.shoutDown();

			}
		}
		return sectionSrNoList;

	}
}
