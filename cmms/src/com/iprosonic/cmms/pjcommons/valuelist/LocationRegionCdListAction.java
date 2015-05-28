package com.iprosonic.cmms.pjcommons.valuelist;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.iprosonic.cmms.modules.cpi.masters.assets.domain.AssetBean;
import com.iprosonic.cmms.pjcommons.utility.HibernateSession;

public class LocationRegionCdListAction 
{
	public String getLocationCdString(String regionCd) {
		List<String> locationCdList = null;

		String listString = "-Select-:";
		Session session = null;
		try {
			session = HibernateSession.getSessionFactory().openSession();
			Criteria criteria = session.createCriteria(AssetBean.class);
			criteria.add(Restrictions.like("regionCd", regionCd));
			criteria.setProjection(Projections.distinct(Projections
					.property("locationCd")));
			locationCdList = criteria.list();
			for (String s : locationCdList) {
				listString += s + ":";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return listString;
	}

}