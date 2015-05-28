package com.iprosonic.cmms.modules.job.reports.jobbonus.service;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

import com.iprosonic.cmms.modules.job.transactions.job.dao.JobDAOImpl;
import com.iprosonic.cmms.modules.job.transactions.job.dao.JobRunDaoImpl;
import com.iprosonic.cmms.modules.job.transactions.job.domain.JobBean;
import com.iprosonic.cmms.pjcommons.utility.HibernateSession;

public class JobBonusReportService {

	private JobRunDaoImpl jobRunDaoImpl = null;

	public JobBonusReportService() {
		jobRunDaoImpl = new JobRunDaoImpl();
	}

	public String getBonusReport(String fromDate, String toDate,
			String jobNo) {
		return jobRunDaoImpl.getJobBonusReport(fromDate, toDate, jobNo);
	}

	public List<String> getJobNoList() throws Exception {
		JobDAOImpl iJobDAO = new JobDAOImpl();

		List<String> jobNoList = new ArrayList<String>();
		Session session = HibernateSession.getSessionFactory().openSession();
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

}
