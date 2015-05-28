package com.iprosonic.cmms.modules.job.reports.was.web;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;

import com.iprosonic.cmms.modules.job.masters.service.domain.ServiecExReportBean;
import com.iprosonic.cmms.modules.job.transactions.job.dao.JobRunDaoImpl;
import com.iprosonic.cmms.modules.job.transactions.job.domain.JobBean;
import com.iprosonic.cmms.modules.job.transactions.job.domain.JobExplBean;
import com.iprosonic.cmms.modules.job.transactions.job.domain.JobRigBean;
import com.iprosonic.cmms.modules.job.transactions.job.domain.JobRunBean;
import com.iprosonic.cmms.modules.job.transactions.job.domain.JobServiceBean;
import com.iprosonic.cmms.modules.job.transactions.job.service.SearchJobService;
import com.iprosonic.cmms.modules.masters.user.dao.EmployeeDaoImpl;
import com.iprosonic.cmms.modules.masters.user.domain.EmployeeBean;
import com.iprosonic.cmms.pjcommons.utility.DateUtil;
import com.iprosonic.cmms.pjcommons.utility.HibernateSession;
import com.opensymphony.xwork2.ActionSupport;

public class ServiceExplosiveReport extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	SimpleDateFormat fromformat=new SimpleDateFormat("yyyy-MM-01");
	SimpleDateFormat toformat=new SimpleDateFormat("yyyy-MM-dd");
	private String fromDate=fromformat.format(new Date()).toString();
	private String toDate=toformat.format(new Date()).toString();
	private SearchJobService searchJobService=new SearchJobService();
	private Set<JobServiceBean> serviceBeanList=new HashSet<JobServiceBean>(); 
	private List<ServiecExReportBean> bean=new ArrayList<ServiecExReportBean>();
	
	public List<ServiecExReportBean> getBean() {
		return bean;
	}
	public void setBean(List<ServiecExReportBean> bean) {
		this.bean = bean;
	}
	
	public Set<JobServiceBean> getServiceBeanList() {
		return serviceBeanList;
	}
	public void setServiceBeanList(Set<JobServiceBean> serviceBeanList) {
		this.serviceBeanList = serviceBeanList;
	}
	public SimpleDateFormat getToformat() {
		return toformat;
	}
	public void setToformat(SimpleDateFormat toformat) {
		this.toformat = toformat;
	}
	public String getToDate() {
		return toDate;
	}
	public void setToDate(String toDate) {
		this.toDate = toDate;
	}
	public String execute() throws Exception {
		
		 
		Set<JobBean> allJob=new HashSet<JobBean>(searchJobService.getAllJobBean());
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
		session.close();
		/*
		Set<JobBean> jobListByDate = searchJobService.getJobListSetByDate(fromDate, toDate);
		Set<JobServiceBean> serviceList = searchJobService
				.getJobServiceSet();
		serviceBeanList = serviceListByDate(jobListByDate, serviceList);
		
		for (JobBean jobBean : jobListByDate) {
			ServiecExReportBean ex=new ServiecExReportBean();
			Set<JobServiceBean> services=new HashSet<JobServiceBean>();
			Set<JobExplBean> expls=new HashSet<JobExplBean>();
			ex.setJobNo(jobBean.getJobNo());
			for (JobServiceBean jobServiceBean : serviceList) {
				if (jobBean.getJobNo().equals(jobServiceBean.getJobNo())) {
					services.add(jobServiceBean);
					expls= jobServiceBean.getJobExplBeanSet();
				}
			}
			
			ex.setJobServiceNos(services);
			ex.setJobExplNos(expls);
			bean.add(ex);
		}
		
		
		return INPUT;*/
		return null;
		
	}

	private Set<JobServiceBean> serviceListByDate(Set<JobBean> jobListByDate,
			Set<JobServiceBean> serviceList) {
		Set<JobServiceBean> services = new HashSet<JobServiceBean>();
		try{
		for (JobBean jobBean : jobListByDate) {
			for (JobServiceBean jobServiceBean : serviceList) {
				{
					if (jobBean.getJobNo().equals(jobServiceBean.getJobNo())) {
						
								services.add(jobServiceBean);
							}
						}
					}
				}
			}catch(Exception e){
				e.printStackTrace();
			}

		

		return services;
	}
	

	
	
}
