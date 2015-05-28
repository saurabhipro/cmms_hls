package com.iprosonic.cmms.pjcommons.valuelist;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;

import com.iprosonic.cmms.modules.cpi.masters.group.domain.CpiMasterBean;
import com.iprosonic.cmms.pjcommons.utility.HibernateSession;

public class GroupCodeListAction {

	public List<String> getGroupCodeList() {
		List<String> gropCdList = null;
		Session session = null;
		Transaction transaction = null;

		Criteria criteria = null;
		try {
			session = HibernateSession.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			criteria = session.createCriteria(CpiMasterBean.class);
			ProjectionList projectionList = Projections.projectionList();
			projectionList.add(Projections.distinct(Projections
					.property("groupName")));
			criteria.setProjection(projectionList);
			gropCdList = criteria.list();

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
		return gropCdList;

	}

}
