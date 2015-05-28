package com.iprosonic.cmms.modules.job.transactions.job.dao;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.iprosonic.cmms.modules.job.transactions.job.domain.JobBean;
import com.iprosonic.cmms.modules.job.transactions.job.domain.JobRigBean;
import com.iprosonic.cmms.modules.job.transactions.job.domain.JobWellBean;
import com.iprosonic.cmms.pjcommons.utility.HibernateSession;

public class JobDAOImpl  {

	private Session session;
	private Transaction transaction;

	@SuppressWarnings("unchecked")
	public List<JobBean> getJobList(Criteria criteria) throws Exception {
		return criteria.list();
	}


	public JobBean getJobBean(String jobNo) throws Exception {

		session = HibernateSession.getSessionFactory().openSession();

		JobBean jobBean = null;

		Criteria criteria = session.createCriteria(JobBean.class);
		criteria.add(Restrictions.like("jobNo", jobNo));
		Iterator<JobBean> itr = criteria.list().iterator();
		while (itr.hasNext()) {
			jobBean = itr.next();
		}
		return jobBean;
	}

	public JobWellBean getJobWellBean(String jobNo) throws Exception {
		JobWellBean jobWellBean = null;

		session = HibernateSession.getSessionFactory().openSession();
		
		Criteria criteria = session.createCriteria(JobWellBean.class);
		criteria.add(Restrictions.like("jobNo", jobNo));
		List<JobWellBean> list = criteria.list();
		Iterator<JobWellBean> itr = list.iterator();
		while (itr.hasNext()) {

			jobWellBean = itr.next();
		}
		return jobWellBean;
	}

	// @Override
	public List<JobRigBean> getRigList(Criteria criteria) throws Exception {
		return criteria.list();
	}

}
