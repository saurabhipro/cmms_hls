package com.iprosonic.cmms.modules.job.transactions.job.service;
import com.iprosonic.cmms.modules.job.transactions.job.dao.JobRunDaoImpl;
import com.iprosonic.cmms.modules.job.transactions.job.domain.JobRunBean;

public class SearchRunService {
	public JobRunBean getRunByNo(String rigNo) throws Exception
	{
		JobRunDaoImpl iJobRunDao = new JobRunDaoImpl();
	    return iJobRunDao.getRunByNo(rigNo);	
	}
}
