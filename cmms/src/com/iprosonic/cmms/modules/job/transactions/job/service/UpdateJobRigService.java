package com.iprosonic.cmms.modules.job.transactions.job.service;
import com.iprosonic.cmms.modules.job.transactions.job.dao.JobRigDaoImpl;
import com.iprosonic.cmms.modules.job.transactions.job.domain.JobRigBean;

public class UpdateJobRigService {	
	public void updateRig(JobRigBean jobRigBean)
	{
		JobRigDaoImpl  RigDao = new JobRigDaoImpl();
		RigDao.updateJobRig(jobRigBean);   
	}
}
