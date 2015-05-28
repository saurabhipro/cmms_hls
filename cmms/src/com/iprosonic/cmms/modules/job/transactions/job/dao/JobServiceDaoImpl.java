package com.iprosonic.cmms.modules.job.transactions.job.dao;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.iprosonic.cmms.modules.job.transactions.job.domain.JobServiceBean;
import com.iprosonic.cmms.pjcommons.utility.HibernateSession;

public class JobServiceDaoImpl{

	public JobServiceBean getServiceByNo(String serviceNo) throws Exception {
		JobServiceBean jobServiceBean = null;
		Session session = HibernateSession.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(JobServiceBean.class);
		criteria.add(Restrictions.like("serviceNo", serviceNo));
		Iterator<JobServiceBean> itr = criteria.list().iterator();
		while (itr.hasNext()) {

			jobServiceBean = itr.next();
		}
		session.close();
		HibernateSession.shoutDown();
		return jobServiceBean;
	}


	public JobServiceBean getServiceByRunNo(String jobNo) {
		JobServiceBean jobServiceBean = null;
		Session session = HibernateSession.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(JobServiceBean.class);
		criteria.add(Restrictions.like("jobNo", jobNo));
		criteria.addOrder(Order.desc("serviceNo"));
		if (criteria.list().size() > 0) {
			jobServiceBean = (JobServiceBean) criteria.list().get(0);
		}
		session.close();
		HibernateSession.shoutDown();
		return jobServiceBean;
	}

	public void updateJobService(JobServiceBean jobServiceBean)
			throws Exception {
		Session session = HibernateSession.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.update(jobServiceBean);
		transaction.commit();
		session.flush();
		session.clear();
		session.close();		
		HibernateSession.shoutDown();
	}

	public void updateJobStatus(String jobNo, String jobStatus) {
		Session session = HibernateSession.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		String hqlQuery = "update JobBean set jobStatus =:jobStatus WHERE jobNo =:jobNo";
		Query query = session.createQuery(hqlQuery);
		query.setString("jobStatus", jobStatus);
		query.setString("jobNo", jobNo);
		query.executeUpdate();
		transaction.commit();
		session.close();
	}

	public Integer getServiceCount(String jobNo) {
		Integer size = 0;
		Session session = HibernateSession.getSessionFactory().openSession();
		size = session.createCriteria(JobServiceBean.class)
				.add(Restrictions.like("jobNo", jobNo)).list().size();
		return size;
	}
	
	@SuppressWarnings("unchecked")
	public List<String> getServiceType() {
		ArrayList<String> srvType=new ArrayList<String>();
		Session session = HibernateSession.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(JobServiceBean.class);
		
		
        criteria.setProjection(Projections.distinct(Projections.property("serviceType")));
		
		 srvType=(ArrayList<String>)criteria.list();
		 session.close();
		return srvType;
	}
	
	
	

}
