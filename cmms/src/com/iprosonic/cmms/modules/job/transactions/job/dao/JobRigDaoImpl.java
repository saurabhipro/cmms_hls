package com.iprosonic.cmms.modules.job.transactions.job.dao;


import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.iprosonic.cmms.modules.job.transactions.job.domain.JobRigBean;
import com.iprosonic.cmms.pjcommons.utility.HibernateSession;

public class JobRigDaoImpl {

	private Session session;
	private Transaction transaction;

	public void updateJobRig(final JobRigBean jobRigBean) {
		session = HibernateSession.getSessionFactory().openSession();
		transaction = session.beginTransaction();

		JobRigBean rigBean = (JobRigBean) session.get(JobRigBean.class,
				jobRigBean.getRigNo());

		rigBean.setRigUpStart(jobRigBean.getRigUpStart());
		rigBean.setRigUpEnd(jobRigBean.getRigUpEnd());
		rigBean.setRigDownStart(jobRigBean.getRigDownStart());
		rigBean.setRigDownEnd(jobRigBean.getRigDownEnd());
		session.update(rigBean);

		transaction.commit();
		session.flush();
		session.clear();
		session.close();

	}

	public JobRigBean getRigByNo(String no) throws Exception {
		session = HibernateSession.getSessionFactory().openSession();
		JobRigBean jobRigBean = null;
		Criteria criteria = session.createCriteria(JobRigBean.class);
		criteria.add(Restrictions.like("rigNo", no));
		@SuppressWarnings("unchecked")
		Iterator<JobRigBean> itr = criteria.list().iterator();
		while (itr.hasNext()) {
			jobRigBean = itr.next();
		}
		return jobRigBean;
	}

	public JobRigBean getRigByJobNo(String jobNo) throws Exception {
		session = HibernateSession.getSessionFactory().openSession();
		JobRigBean jobRigBean = null;
		Criteria criteria = session.createCriteria(JobRigBean.class);
		criteria.add(Restrictions.like("jobNo", jobNo));
		criteria.addOrder(Order.desc("rigNo"));
		@SuppressWarnings("unchecked")
		Iterator<JobRigBean> itr = criteria.list().iterator();
		while (itr.hasNext()) {
			jobRigBean = itr.next();
		}
		return jobRigBean;
	}
	
	public List<JobRigBean> getRigList() throws Exception {
		session = HibernateSession.getSessionFactory().openSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(JobRigBean.class);
		List l=criteria.list();
		session.getTransaction().commit();
		session.close();
		return l;
	}
	

}
