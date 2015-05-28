package com.iprosonic.cmms.pjcommons.utility;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;

import com.iprosonic.cmms.modules.job.transactions.job.domain.JobBean;
import com.iprosonic.cmms.modules.job.transactions.job.domain.JobRigBean;

public class RigDownEndToJobDate {
	 
	/*Set<JobBean> allJob=new HashSet<JobBean>(searchJobService.getAllJobBean());
	Set<JobRigBean> allRig=new HashSet<JobRigBean>(searchJobService.getAllRigList());
	Session session = HibernateSession.getSessionFactory().openSession();
	for (JobBean jobBean : allJob) {
		for (JobRigBean jobRigBean : allRig) {
			if(jobBean.getJobNo().equalsIgnoreCase(jobRigBean.getJobNo())){
				String rigDownEnd=jobRigBean.getRigDownEnd();
				String st[]=rigDownEnd.split(" ");
				String jobDate=DateUtil.getJobDateFromTimeFormate(st[0]);
				
				
				jobBean.setJobDate(jobDate);
				session.beginTransaction();
				session.saveOrUpdate(jobBean);
				session.getTransaction().commit();
			}
		}
	}
	session.close();*/
	
}
