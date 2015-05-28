package com.iprosonic.cmms.modules.job.transactions.job.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.iprosonic.cmms.modules.job.transactions.job.dao.JobDAOImpl;
import com.iprosonic.cmms.modules.job.transactions.job.dao.JobServiceDaoImpl;
import com.iprosonic.cmms.modules.job.transactions.job.domain.JobBean;
import com.iprosonic.cmms.modules.job.transactions.job.domain.JobRigBean;
import com.iprosonic.cmms.modules.job.transactions.job.domain.JobServiceBean;
import com.iprosonic.cmms.modules.job.transactions.job.domain.JobWellBean;
import com.iprosonic.cmms.pjcommons.utility.HibernateSession;
import com.iprosonic.cmms.pjcommons.utility.WorkFlow;

public class SearchJobService {

	Session		session		= null;
	Transaction	transaction	= null;

	public List<JobBean> getAllJobBean() throws Exception {
		JobDAOImpl iJobDAO = new JobDAOImpl();
		List<String> jobNoList = new ArrayList<String>();
		session = HibernateSession.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(JobBean.class);
		List<JobBean> jobBeanList = iJobDAO.getJobList(criteria);

		session.close();
		return jobBeanList;
	}

	public List<String> getJobNoList() throws Exception {
		JobDAOImpl iJobDAO = new JobDAOImpl();
		List<String> jobNoList = new ArrayList<String>();
		session = HibernateSession.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(JobBean.class);
		List<JobBean> jobBeanList = iJobDAO.getJobList(criteria);
		Iterator<JobBean> itr = jobBeanList.iterator();
		while (itr.hasNext()) {
			JobBean jobBean = itr.next();
			jobNoList.add(jobBean.getJobNo());
		}
		session.close();
		return jobNoList;
	}

	public List<String> getJobHlsNoList() throws Exception {
		JobDAOImpl iJobDAO = new JobDAOImpl();
		List<String> jobNoList = new ArrayList<String>();
		session = HibernateSession.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(JobBean.class);
		List<JobBean> jobBeanList = iJobDAO.getJobList(criteria);
		Iterator<JobBean> itr = jobBeanList.iterator();
		while (itr.hasNext()) {
			JobBean jobBean = itr.next();
			jobNoList.add(jobBean.getJobNoHlsa());
		}
		session.close();
		return jobNoList;
	}

	public List<JobBean> getJobList( String fromDate, String toDate, String clientName, String jobStatus, String locationCd) throws Exception {
		JobDAOImpl iJobDAO = new JobDAOImpl();
		session = HibernateSession.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(JobBean.class);
		criteria.add(Restrictions.ge("jobDate", fromDate));
		criteria.add(Restrictions.le("jobDate", toDate));

		if (!locationCd.equalsIgnoreCase("-Select-"))
			criteria.add(Restrictions.eq("unitNo", locationCd));


		if (!clientName.equalsIgnoreCase("-Select-")) {
			criteria.add(Restrictions.like("clientName", clientName));
		}

		if (!jobStatus.equalsIgnoreCase("-Select-")) {
			criteria.add(Restrictions.like("jobStatus", jobStatus));
		} else {
			criteria.add(Restrictions.ne("jobStatus", WorkFlow.DELETE_JOB));
		}

		List<JobBean> jobList = iJobDAO.getJobList(criteria);
		session.close();
		return jobList;
	}

	public List<JobBean> getJobListByDate(String fromDate, String toDate) throws Exception {
		JobDAOImpl iJobDAO = new JobDAOImpl();
		session = HibernateSession.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(JobBean.class);
		criteria.add(Restrictions.ge("jobDate", fromDate));
		criteria.add(Restrictions.le("jobDate", toDate));

		List<JobBean> jobList = iJobDAO.getJobList(criteria);
		session.close();
		return jobList;
	}

	public Set<JobBean> getJobListSetByDate(String fromDate, String toDate) throws Exception {
		JobDAOImpl iJobDAO = new JobDAOImpl();
		session = HibernateSession.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(JobBean.class);
		criteria.add(Restrictions.ge("jobDate", fromDate));
		criteria.add(Restrictions.le("jobDate", toDate));
		criteria.add(Restrictions.ne("jobStatus", "DELETED"));
		List<JobBean> jobList = iJobDAO.getJobList(criteria);
		Set<JobBean> jobset = new HashSet<JobBean>(jobList);
		session.close();
		return jobset;
	}

	public Set<JobBean> getJobListSetByDateNServType(String fromDate, String toDate, String servtype) throws Exception {

		session = HibernateSession.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(JobServiceBean.class);
		criteria.add(Restrictions.eq("serviceType", servtype));
		/* criteria.setProjection(Projections.property("serviceType")); */
		criteria.setProjection(Projections.property("jobNo"));
		@SuppressWarnings("unchecked")
		List<String> seList = criteria.list();

		Set<JobBean> jobset = getJobListSetByDate(fromDate, toDate);
		Iterator<JobBean> it = jobset.iterator();

		while (it.hasNext()) {
			if (seList.contains((String) it.next().getJobNo())) {

			} else {
				it.remove();
			}

		}

		return jobset;
	}

	public List<JobRigBean> getRigList(String jobNo) throws Exception {
		Session session = HibernateSession.getSessionFactory().openSession();

		Criteria criteria = session.createCriteria(JobRigBean.class);
		criteria.add(Restrictions.like("jobNo", jobNo));
		List<JobRigBean> list = criteria.list();

		return list;
	}

	public List<JobRigBean> getAllRigList() throws Exception {
		Session session = HibernateSession.getSessionFactory().openSession();

		Criteria criteria = session.createCriteria(JobRigBean.class);
		List<JobRigBean> list = criteria.list();

		return list;

	}

	public List<JobServiceBean> getJobServiceBeans(String runNo) throws Exception {
		Session session = HibernateSession.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(JobServiceBean.class);
		criteria.add(Restrictions.like("runNo", runNo));
		List<JobServiceBean> list = criteria.list();

		return list;

	}

	public JobBean getJobBean(String jobNo) throws Exception {
		JobDAOImpl iJobDAO = new JobDAOImpl();
		return iJobDAO.getJobBean(jobNo);
	}

	public JobWellBean getJobWellBean(String jobNo) throws Exception {
		JobDAOImpl JobDAO = new JobDAOImpl();
		return JobDAO.getJobWellBean(jobNo);
	}

	public JobServiceBean getJobServiceByNo(String serviceNo) throws Exception {
		JobServiceDaoImpl iJobServiceDao = new JobServiceDaoImpl();
		return iJobServiceDao.getServiceByNo(serviceNo);

	}

	public List<JobServiceBean> getJobServiceList() throws Exception {
		session = HibernateSession.getSessionFactory().openSession();
		session.getTransaction().begin();
		Criteria criteria = session.createCriteria(JobServiceBean.class);
		List<JobServiceBean> jobServiceList = criteria.list();
		session.getTransaction().commit();
		session.close();
		return jobServiceList;
	}

	public Set<JobServiceBean> getJobServiceSet() throws Exception {
		session = HibernateSession.getSessionFactory().openSession();
		session.getTransaction().begin();
		Criteria criteria = session.createCriteria(JobServiceBean.class);
		List<JobServiceBean> jobServiceList = criteria.list();
		Set<JobServiceBean> set = new HashSet<JobServiceBean>(jobServiceList);
		session.getTransaction().commit();
		session.close();
		return set;
	}

	public List<String> getServiceTypes() {

		JobServiceDaoImpl sJobDAO = new JobServiceDaoImpl();
		List<String> srvcType = new ArrayList<String>();
		session = HibernateSession.getSessionFactory().openSession();

		List<String> SrvTypes = sJobDAO.getServiceType();
		Iterator<String> itr = SrvTypes.iterator();
		String typ = "";
		while (itr.hasNext()) {
			typ = itr.next();
			srvcType.add(typ);
		}
		session.close();
		return srvcType;

	}

}
