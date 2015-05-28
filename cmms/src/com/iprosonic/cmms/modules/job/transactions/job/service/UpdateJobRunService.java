package com.iprosonic.cmms.modules.job.transactions.job.service;
import com.iprosonic.cmms.modules.job.transactions.job.dao.JobRunDaoImpl;
import com.iprosonic.cmms.modules.job.transactions.job.domain.JobRunBean;

public class UpdateJobRunService {	
	public void updatejobRun(JobRunBean jobRunBean)
	{
		JobRunDaoImpl JobRunDao = new JobRunDaoImpl();
		JobRunDao.updateJobRun(jobRunBean);
	}
}
