package com.iprosonic.cmms.pjcommons.utility;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.iprosonic.cmms.modules.job.transactions.job.dao.JobRunDaoImpl;
import com.iprosonic.cmms.modules.job.transactions.job.domain.JobBean;
import com.iprosonic.cmms.modules.job.transactions.job.domain.JobRunBean;
import com.iprosonic.cmms.modules.job.transactions.job.domain.JobServiceBean;
import com.iprosonic.cmms.modules.job.transactions.job.service.SearchJobService;
import com.iprosonic.cmms.modules.masters.user.dao.EmployeeDaoImpl;
import com.iprosonic.cmms.modules.masters.user.domain.EmployeeBean;
import com.opensymphony.xwork2.ActionSupport;

public class UpdateEngInServiceUtils  {

	
	
public static void main(String[] args) {
	
		// TODO Auto-generated method stub
		
		try {
			SearchJobService searchJobService = new SearchJobService();
			JobRunDaoImpl jobRunDaoImpl = new JobRunDaoImpl();

			List<JobServiceBean> allJobService=searchJobService.getJobServiceList();
			List<JobRunBean> allJobRun=jobRunDaoImpl.getRunList();
			Session session = HibernateSession.getSessionFactory().openSession();
			session.beginTransaction();
			for(JobRunBean jobrunbean:allJobRun){
				for(JobServiceBean jobservicebean:allJobService){
					if(jobrunbean.getJobNo().equals(jobservicebean.getJobNo())){
						jobservicebean.setCrew(jobrunbean.getCrew());
						session.saveOrUpdate(jobservicebean);
					}
				}
			}
			session.getTransaction().commit();
			session.close();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}
	

	
	
}
