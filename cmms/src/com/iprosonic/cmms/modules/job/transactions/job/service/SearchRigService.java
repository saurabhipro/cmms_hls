package com.iprosonic.cmms.modules.job.transactions.job.service;
import com.iprosonic.cmms.modules.job.transactions.job.dao.JobRigDaoImpl;
import com.iprosonic.cmms.modules.job.transactions.job.domain.JobRigBean;

public class SearchRigService {

	public JobRigBean getRigByNo(String rigNo) throws Exception
	{
		JobRigDaoImpl RigDao = new JobRigDaoImpl();
		return RigDao.getRigByNo(rigNo);	
	}
	
	public JobRigBean getRigByJobNo(String jobNo) throws Exception {
		JobRigDaoImpl iRigDao = new JobRigDaoImpl();
		return iRigDao.getRigByJobNo(jobNo);
	}

}