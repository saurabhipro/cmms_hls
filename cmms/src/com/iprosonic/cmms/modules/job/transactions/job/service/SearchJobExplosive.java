package com.iprosonic.cmms.modules.job.transactions.job.service;



import com.iprosonic.cmms.modules.job.transactions.job.dao.JobExplosiveDaoImpl;
import com.iprosonic.cmms.modules.job.transactions.job.domain.JobExplBean;
public class SearchJobExplosive {

	public JobExplBean getJobExplosiveByNo(String explNo) throws Exception {
		JobExplosiveDaoImpl iJobSExplosiveDao = new JobExplosiveDaoImpl();
		return iJobSExplosiveDao.getExplosiveByNo(explNo);

	}

}
