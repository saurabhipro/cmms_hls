package com.iprosonic.cmms.pjcommons.valuelist;


import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;

import com.iprosonic.cmms.modules.cpi.masters.assets.domain.AssetBean;
import com.iprosonic.cmms.pjcommons.utility.HibernateSession;

public class ClientCdListAction {
	public String getClientCdString(String unitCd) {
		List<String> clientCdList = null;

		String listString = "-Select-:";
		Session session = null;
		try {
			session = HibernateSession.getSessionFactory().openSession();
			Criteria criteria = session.createCriteria(AssetBean.class);
			criteria.setProjection(Projections.distinct(Projections
					.property("clientCd")));
			clientCdList = criteria.list();

			for (String s : clientCdList) {

				listString += s + ":";

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return listString;
	}

	public List<String> getClientCdList() {
		List<String> clientCdList = null;

		Session session = null;
		try {
			session = HibernateSession.getSessionFactory().openSession();
			Criteria criteria = session.createCriteria(AssetBean.class);
			criteria.setProjection(Projections.distinct(Projections
					.property("clientCd")));
			clientCdList = criteria.list();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return clientCdList;
	}

}