package com.iprosonic.cmms.modules.job.transactions.job.dao;
import java.util.Iterator;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import com.iprosonic.cmms.modules.job.transactions.job.domain.JobExplBean;
import com.iprosonic.cmms.pjcommons.utility.HibernateSession;

public class JobExplosiveDaoImpl {
	public JobExplBean getExplosiveByNo(String explNo) throws Exception {
		JobExplBean jobExplBean = null;
		Session session = HibernateSession.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(JobExplBean.class);
		criteria.add(Restrictions.like("explNo", explNo));
		Iterator<JobExplBean> itr = criteria.list().iterator();
		while (itr.hasNext()) {

			jobExplBean = itr.next();
		}
		session.close();
		HibernateSession.shoutDown();
		return jobExplBean;
	}

	public void updateJobExplosive(JobExplBean jobExplBean) throws Exception {

		Session session = HibernateSession.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.saveOrUpdate(jobExplBean);
		transaction.commit();
		session.close();
		HibernateSession.shoutDown();
		
	}

}
