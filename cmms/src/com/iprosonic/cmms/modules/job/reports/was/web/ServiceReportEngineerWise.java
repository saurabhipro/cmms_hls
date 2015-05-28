package com.iprosonic.cmms.modules.job.reports.was.web;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.iprosonic.cmms.modules.job.transactions.job.dao.JobRunDaoImpl;
import com.iprosonic.cmms.modules.job.transactions.job.domain.JobBean;
import com.iprosonic.cmms.modules.job.transactions.job.domain.JobRunBean;
import com.iprosonic.cmms.modules.job.transactions.job.domain.JobServiceBean;
import com.iprosonic.cmms.modules.job.transactions.job.service.SearchJobService;
import com.iprosonic.cmms.modules.masters.user.dao.EmployeeDaoImpl;
import com.iprosonic.cmms.modules.masters.user.domain.EmployeeBean;
import com.iprosonic.cmms.pjcommons.utility.EmpContainsMatch;
import com.opensymphony.xwork2.ActionSupport;

public class ServiceReportEngineerWise extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int noofJobs;
	private int totalmissruns;
	private double totalchRuns;
	private double totallosstime;
	private double totallqat;
	private double totallqap;
	private int noofServices;
	private String error;
	
	SimpleDateFormat fromformat=new SimpleDateFormat("yyyy-MM-01");
	SimpleDateFormat toformat=new SimpleDateFormat("yyyy-MM-dd");
	private String fromDate=fromformat.format(new Date()).toString();
	private String toDate=toformat.format(new Date()).toString();
	private String engi;
	private List<String> engList=new ArrayList<String>(); 
	private EmployeeDaoImpl employeeDaoImpl = new EmployeeDaoImpl();
	private SearchJobService searchJobService = new SearchJobService();
	private Set<JobServiceBean> serviceBeanList=new HashSet<JobServiceBean>();
	
	
	
	 
	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public int getNoofServices() {
		return noofServices;
	}

	public void setNoofServices(int noofServices) {
		this.noofServices = noofServices;
	}

	public int getTotalmissruns() {
		return totalmissruns;
	}

	public void setTotalmissruns(int totalmissruns) {
		this.totalmissruns = totalmissruns;
	}

	public int getNoofJobs() {
		return noofJobs;
	}

	public void setNoofJobs(int noofJobs) {
		this.noofJobs = noofJobs;
	}

	

	public double getTotalchRuns() {
		return totalchRuns;
	}

	public void setTotalchRuns(double totalchRuns) {
		this.totalchRuns = totalchRuns;
	}

	 

	public double getTotallosstime() {
		return totallosstime;
	}

	public void setTotallosstime(double totallosstime) {
		this.totallosstime = totallosstime;
	}

	

	public double getTotallqat() {
		return totallqat;
	}

	public void setTotallqat(double totallqat) {
		this.totallqat = totallqat;
	}

	public double getTotallqap() {
		return totallqap;
	}

	public void setTotallqap(double totallqap) {
		this.totallqap = totallqap;
	}

	public void setTotallqap(int totallqap) {
		this.totallqap = totallqap;
	}


	public Set<JobServiceBean> getServiceBeanList() {
		return serviceBeanList;
	}

	public void setServiceBeanList(Set<JobServiceBean> serviceBeanList) {
		this.serviceBeanList = serviceBeanList;
	}

	public List<String> getEngList() {
		List<EmployeeBean> employees = employeeDaoImpl.englist();
		for (EmployeeBean employeeBean : employees) {
			engList.add(employeeBean.getEmployeeShortName());
		}
		return engList;
	}

	public void setEngList(List<String> engList) {
		this.engList = engList;
	}
	
	
	
	public String getFromDate() {
		return fromDate;
	}




	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}




	public String getToDate() {
		return toDate;
	}




	public void setToDate(String toDate) {
		this.toDate = toDate;
	}




	public String getEngi() {
		return engi;
	}




	public void setEngi(String engi) {
		this.engi = engi;
	}




	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		Set<JobBean> jobListByDate = searchJobService.getJobListSetByDate(fromDate, toDate);
		Set<JobServiceBean> serviceList = searchJobService
				.getJobServiceSet();
		JobRunDaoImpl jobRunDaoImpl = new JobRunDaoImpl();
		Set<JobRunBean> jobRunBeans = new HashSet<JobRunBean>(
				jobRunDaoImpl.getRunList());
		serviceBeanList = serviceListByDate(jobListByDate, serviceList,jobRunBeans);
		
		
		return INPUT;
	}
	
	private Set<JobServiceBean> serviceListByDate(Set<JobBean> jobListByDate,
			Set<JobServiceBean> serviceList, Set<JobRunBean> jobRunBeans) {
		Set<JobServiceBean> services = new HashSet<JobServiceBean>();
		Boolean isContains=false;
		try{
		for (JobBean jobBean : jobListByDate) {
			for (JobServiceBean jobServiceBean : serviceList) {
				{
					if (jobBean.getJobNo().equals(jobServiceBean.getJobNo()) ) {
						
						String engArr=jobServiceBean.getEngi()!=null ? jobServiceBean.getEngi().trim() : "";
						isContains = EmpContainsMatch.matchEmp(engArr,engi);
							if(isContains){
								JobServiceBean bean=new JobServiceBean();
								bean.setJobNo(jobServiceBean.getJobNo());
								bean.setChmisRuns(isNumeric(jobServiceBean.getChmisRuns()) ? jobServiceBean.getChmisRuns(): "0" );
								bean.setChruns(isNumeric((jobServiceBean.getChruns())) ? jobServiceBean.getChruns(): "0" );
								bean.setLossTime(isNumeric((jobServiceBean.getLossTime())) ? jobServiceBean.getLossTime(): "0" );
								bean.setLqaPresentation(isNumeric((jobServiceBean.getLqaPresentation())) ? jobServiceBean.getLqaPresentation(): "0" );
								bean.setLqaTechnical(isNumeric((jobServiceBean.getLqaTechnical())) ? jobServiceBean.getLqaTechnical(): "0" );
								bean.setServiceNo(jobServiceBean.getServiceNo());
								
								services.add(bean);
							}
						}
					}
				}
				
			
			}
//		}
		int countLQAT=0;
		int countLQAP=0;
		double totalOT=0; 
			
		Set<String> set=new HashSet<String>();
		for (JobServiceBean jobServiceBean : services) {
			for (JobRunBean jobRunBean : jobRunBeans) {
				if(jobServiceBean.getJobNo().equals(jobRunBean.getJobNo())){
					double d=calculateOT(jobRunBean.getOt());
					if(d <= 0.0d){
						error="error";
					}
				}
			}
			totalmissruns=totalmissruns+Integer.parseInt(jobServiceBean.getChmisRuns().equals("") ?"0" :jobServiceBean.getChmisRuns());
			totalchRuns=totalchRuns+Double.parseDouble(jobServiceBean.getChruns().equals("")? "0" :jobServiceBean.getChruns());
			totallosstime=totallosstime+Double.parseDouble(jobServiceBean.getLossTime().equals("")?"0":jobServiceBean.getLossTime());
			totallqat=totallqat+Integer.parseInt(jobServiceBean.getLqaTechnical().equals("")?"0":jobServiceBean.getLqaTechnical());
			if(Integer.parseInt(jobServiceBean.getLqaTechnical()) > 0 ){
				countLQAT=countLQAT+1;
			}
			totallqap=totallqap+Integer.parseInt(jobServiceBean.getLqaPresentation().equals("")?"0":jobServiceBean.getLqaPresentation());
			if(Integer.parseInt(jobServiceBean.getLqaPresentation()) > 0 ){
				countLQAP=countLQAP+1;
			}
			
			set.add(jobServiceBean.getJobNo());
		}
	
		noofServices=services.size();
		noofJobs=set.size();
		if(countLQAT < totallqat){
			
			totallqat=totallqat/countLQAT;
		}
		if(countLQAP < totallqap){
			
			totallqap=totallqap/countLQAP;
		}
		}catch(Exception e){
			e.printStackTrace();
			totallqat=0;
			totallqap=0;

		}
		

		return services;
	}
	public boolean isNumeric(String data) {
		try {

			Double.parseDouble(data);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	private double calculateOT(String ot) {
		// TODO Auto-generated method stub
		double doubleOT=0.0d;
		try {
			String[] sOT=ot.split(",");
			String hstr=sOT[0].replace("Hrs", "");
			String mstr=sOT[1].replace("Mins", "");
			
			doubleOT = Double.parseDouble(hstr)+Double.parseDouble(mstr)/60;
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			System.out.println("input ot="+ot);
			e.printStackTrace();
		}
		
		return doubleOT;
	}
	
	
}
