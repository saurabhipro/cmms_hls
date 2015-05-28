package com.iprosonic.cmms.pjcommons.valuelist;



import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;

import com.iprosonic.cmms.modules.cpi.masters.group.domain.CpiMasterBean;
import com.iprosonic.cmms.pjcommons.utility.HibernateSession;

public class SubGroupCodeStrAction {

	public String getSubGroupCodeStr(String groupCd) {
	
		List<String> subGropCdList = null;
		Session session = null;
		Transaction transaction = null;
		String listString = "-Select-:";
		Criteria criteria = null;
		try {
			session = HibernateSession.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			criteria = session.createCriteria(CpiMasterBean.class);
			ProjectionList projectionList = Projections.projectionList();
			projectionList.add(Projections.distinct(Projections
					.property("subGroupName")));
			criteria.setProjection(projectionList);
			subGropCdList = criteria.list();
			for(String values : subGropCdList)
			{
				listString += values + ":";
				
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
