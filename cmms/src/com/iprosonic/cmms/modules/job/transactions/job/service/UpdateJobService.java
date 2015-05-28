package com.iprosonic.cmms.modules.job.transactions.job.service;
import com.iprosonic.cmms.modules.job.transactions.job.dao.JobServiceDaoImpl;
import com.iprosonic.cmms.modules.job.transactions.job.domain.JobServiceBean;

public class UpdateJobService {
	public void updateJobService(JobServiceBean jobServiceBean)
			throws Exception {
		JobServiceDaoImpl JobServiceDao = new JobServiceDaoImpl();
		JobServiceDao.updateJobService(jobServiceBean);

	}

	public void updateJobStatus(String jobNo, String jobStatus) {
		JobServiceDaoImpl JobServiceDao = new JobServiceDaoImpl();
		JobServiceDao.updateJobStatus(jobNo, jobStatus);
	}
}
