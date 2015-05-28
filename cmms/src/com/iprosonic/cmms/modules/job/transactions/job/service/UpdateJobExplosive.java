package com.iprosonic.cmms.modules.job.transactions.job.service;
import com.iprosonic.cmms.modules.job.transactions.job.dao.JobExplosiveDaoImpl;
import com.iprosonic.cmms.modules.job.transactions.job.domain.JobExplBean;

public class UpdateJobExplosive {

	public void updateJobExplosive(JobExplBean jobExplBean) throws Exception
	{
		JobExplosiveDaoImpl JobSExplosiveDao = new JobExplosiveDaoImpl();
		JobSExplosiveDao.updateJobExplosive(jobExplBean);
		
	}
}
