package com.iprosonic.cmms.modules.job.transactions.job.service;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.iprosonic.cmms.modules.job.transactions.job.domain.JobBean;
import com.iprosonic.cmms.pjcommons.model.NumberingBean;
import com.iprosonic.cmms.pjcommons.utility.DateUtil;
import com.iprosonic.cmms.pjcommons.utility.HibernateSession;

public class JobNumberingService {

	public String genereateLatest(String codeType, String unitCd) {
		return null;
	}

	public String genereateJobCd(String codeType, String unitCd) {
		String latestJobNo = "";
		Session session = null;
		Transaction transaction = null;
		List<String> codeTypeList = null;
		String updateQuery = null;
		String updateNo = "";
		int nextNo = 0;
		try {
			session = HibernateSession.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(NumberingBean.class);
			ProjectionList projectionList = Projections.projectionList();
			criteria.add(Restrictions.like("codeType", codeType));
			criteria.add(Restrictions.like("unitCd", unitCd));
			projectionList.add(Projections.property("latestNo"));
			criteria.setProjection(projectionList);			
			codeTypeList = criteria.list();
			Iterator<String> codeTypeIterator = codeTypeList.iterator();
			while (codeTypeIterator.hasNext()) {
				latestJobNo = codeTypeIterator.next();
			}
	
			nextNo = Integer.parseInt(latestJobNo) + 1;
			updateNo = String.valueOf(nextNo);
			updateQuery = "update NumberingBean set latestNo =:latestNo where codeType =:codeType and  unitCd =:unitCd";
			Query updateNumberingQuery = session.createQuery(updateQuery);
			updateNumberingQuery.setString("latestNo", updateNo);
			updateNumberingQuery.setString("codeType", codeType);
			updateNumberingQuery.setString("unitCd", unitCd);
			updateNumberingQuery.executeUpdate();
			transaction.commit();

		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			if (session.isConnected()) {
				session.close();
				HibernateSession.shoutDown();
			}
		}
		return updateNo;
	}

	public void resetNumberingNo(String unitNo, String codeType) {
		int count = 0;
		int currentMonth = Integer.parseInt(DateUtil.getCurrentMonth());
		Session session = HibernateSession.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(JobBean.class);
		criteria.add(Restrictions.like("unitNo", unitNo));
		List<JobBean> list = criteria.list();
		Iterator<JobBean> itr = list.iterator();
		while (itr.hasNext()) {
			JobBean jobBean = itr.next();
			int jobMonth = Integer.parseInt((jobBean.getJobDate().substring(5,
					7)));
			if (currentMonth == jobMonth) {
				count++;
			}
		}

		if (count == 0) {
			String updateQuery = "update NumberingBean set latestNo =:latestNo where codeType =:codeType and  unitCd =:unitCd";
			session = HibernateSession.getSessionFactory().openSession();
			Transaction transaction = session.beginTransaction();
			Query updateNumberingQuery = session.createQuery(updateQuery);
			updateNumberingQuery.setString("latestNo", "0");
			updateNumberingQuery.setString("codeType", codeType);
			updateNumberingQuery.setString("unitCd", unitNo);
			updateNumberingQuery.executeUpdate();
			transaction.commit();
		}
	}

	public String getLatestNo(String codeType, String unitCd) {
		String latestNo = "";
		Session session = null;
		List<String> codeTypeList = null;
		try {
			session = HibernateSession.getSessionFactory().openSession();
			Criteria criteria = session.createCriteria(NumberingBean.class);
			ProjectionList projectionList = Projections.projectionList();
			criteria.add(Restrictions.like("codeType", codeType));
			criteria.add(Restrictions.like("unitCd", unitCd));
			projectionList.add(Projections.property("latestNo"));
			criteria.setProjection(projectionList);
			codeTypeList = criteria.list();
			Iterator<String> codeTypeIterator = codeTypeList.iterator();
			while (codeTypeIterator.hasNext()) {
				latestNo = codeTypeIterator.next();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateSession.shoutDown();
		}
		
		if (latestNo == "") {
			latestNo = "0";
		}
		return String.valueOf(Integer.parseInt(latestNo) - 1);
	}
}
