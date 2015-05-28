package com.iprosonic.cmms.modules.job.reports.was.web;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.iprosonic.cmms.modules.job.transactions.job.dao.JobRigDaoImpl;
import com.iprosonic.cmms.modules.job.transactions.job.dao.JobRunDaoImpl;
import com.iprosonic.cmms.modules.job.transactions.job.domain.JobBean;
import com.iprosonic.cmms.modules.job.transactions.job.domain.JobRigBean;
import com.iprosonic.cmms.modules.job.transactions.job.domain.JobRunBean;
import com.iprosonic.cmms.modules.job.transactions.job.domain.JobServiceBean;
import com.iprosonic.cmms.modules.job.transactions.job.service.SearchJobService;
import com.iprosonic.cmms.modules.masters.user.dao.EmployeeDaoImpl;
import com.iprosonic.cmms.modules.masters.user.domain.EmployeeBean;
import com.iprosonic.cmms.pjcommons.model.OperationReportBean;
import com.iprosonic.cmms.pjcommons.utility.DateUtil;
import com.iprosonic.cmms.pjcommons.utility.EmpContainsMatch;
import com.opensymphony.xwork2.ActionSupport;

public class EngWiseConsolidateServiceReport extends ActionSupport {
	private static final long serialVersionUID = 1L;
	SimpleDateFormat fromformat=new SimpleDateFormat("yyyy-MM-01");
	SimpleDateFormat toformat=new SimpleDateFormat("yyyy-MM-dd");
	private String fromDate=fromformat.format(new Date()).toString();
	private String toDate=toformat.format(new Date()).toString();
	private SearchJobService searchJobService = new SearchJobService();
	private EmployeeDaoImpl employeeDaoImpl = new EmployeeDaoImpl();
	private JobRigDaoImpl jobRigDaoImpl = new JobRigDaoImpl();
	private JobRunDaoImpl jobRunDaoImpl = new JobRunDaoImpl();
	private List<OperationReportBean> operationList = new ArrayList<OperationReportBean>();

	@Override
	public String execute() {
		try {
			List<EmployeeBean> employees = employeeDaoImpl.englist();
			Set<JobBean> jobListByDate = searchJobService.getJobListSetByDate(
					fromDate, toDate);
			Set<JobServiceBean> serviceList = new HashSet<JobServiceBean>(
					searchJobService.getJobServiceList());
			List<JobServiceBean> serviceListByDate = serviceListByDate(
					jobListByDate, serviceList);
			Set<JobRunBean> jobRunBeans = new HashSet<JobRunBean>(
					jobRunDaoImpl.getRunList());
			Set<JobRigBean> jobRigBeans = new HashSet<JobRigBean>(
					jobRigDaoImpl.getRigList());
			Set<String> getTotalJobs=new HashSet<String>();
			Set<String> runNos=new HashSet<String>();
			Set<JobServiceBean> srvices=new HashSet<JobServiceBean>();
			
			
			double totalOT = 0.0;
			double totalRigUp = 0.0;
			double totalRigDown = 0.0;
			double totalLQAT = 0.0;
			double totalLQAP = 0.0;
			double totalCHRuns = 0.0;
			double totalLT = 0.0;
			int totalCHMissRun = 0;
			int totalNoofChMissRun=0;
			int countJobNos = 0;
			int countServiceNos = 0;
			int countLossTime = 0;
			int countLqat=0; 
			int countLqap=0;
			int totalRun=0;
			
			for (EmployeeBean empBean : employees) {
				OperationReportBean o = new OperationReportBean();
				o.setEngName(empBean.getEmployeeShortName());
				totalOT = 0.0;
				totalRigUp = 0.0;
				totalRigDown = 0.0;
				totalLQAT = 0.0;
				totalLQAP = 0.0;
				totalCHRuns = 0.0;
				totalLT = 0.0;
				totalCHMissRun = 0;
				countJobNos = 0;
				countServiceNos = 0;
				countLossTime = 0;
				countLqat=0;
				countLqap=0;
				totalNoofChMissRun=0;
				 
				Boolean isContains=false;
				for (JobBean jb : jobListByDate) {
					
					for (JobServiceBean servicebean : serviceList) {
						isContains = EmpContainsMatch.matchEmp(servicebean.getEngi(),empBean.getEmployeeShortName());
						if (jb.getJobNo().equals(servicebean.getJobNo()) &&  isContains) {
							
							
							srvices.add(servicebean);
							getTotalJobs.add(servicebean.getJobNo());
							runNos.add(servicebean.getRunNo());
							
						}
					}
				}
				
				for(String strRun:runNos){
					for (JobRunBean runbean : jobRunBeans) {
						if (strRun.equals(runbean.getRunNo())) {
								totalOT = totalOT
										+ calculateOT(runbean.getOt());
							 
						}

					}
				}
				
				for(String strJob:getTotalJobs){
					for (JobRigBean rig : jobRigBeans) {
						if (strJob.equals(rig.getJobNo())) {
							if (!rig.getRigUpStart()
									.equals("0")
									|| !rig.getRigUpEnd()
											.equals("0")) {
								totalRigUp = totalRigUp
										+ DateUtil
												.getTotalOTTime(
														rig.getRigUpStart(),
														rig.getRigUpEnd());
							}
							if (!rig.getRigDownStart().equals(
									"0")
									|| !rig.getRigDownEnd()
											.equals("0")) {
								totalRigDown = totalRigDown
										+ DateUtil
												.getTotalOTTime(
														rig.getRigDownStart(),
														rig.getRigDownEnd());
							}
						}
					}
					
					 
					
					
				}
				

				for (JobServiceBean jobServiceBean : srvices) {
					countServiceNos++;
					String lqat = jobServiceBean.getLqaTechnical();
					String lqap = jobServiceBean
							.getLqaPresentation();
					String LT = jobServiceBean.getLossTime();
					String ch = jobServiceBean.getChruns();
					String chmissruns = jobServiceBean
							.getChmisRuns();
					 
					try {
						if (isNumeric(LT) && Double.parseDouble(LT)>0.0){
							countLossTime++;
							totalLT = totalLT+Double.parseDouble(LT);
							
						}
						
							totalLQAT = totalLQAT
										+ Double
												.parseDouble(isNumeric(lqat) ? lqat
														: 0 + "");
						
						if(isNumeric(lqat) && Double.parseDouble(lqat)>0){
							countLqat++;
						}
						
						
						totalLQAP = totalLQAP
								+ Integer
										.parseInt(isNumeric(lqap) ? lqap
												: 0 + "");
						if(isNumeric(lqap) && Integer.parseInt(lqap)>0){
							countLqap++;
						}
						totalCHRuns = totalCHRuns
								+ Double.parseDouble(isNumeric(ch) ? ch
										: 0 + "");
						totalCHMissRun = totalCHMissRun
								+ Integer
										.parseInt(isNumeric(chmissruns) ? chmissruns
												: 0 + "");
						if(Integer.parseInt(isNumeric(chmissruns) ? chmissruns : 0 + "") >= 0 ){
							totalNoofChMissRun++;
						}
						
						
					
										
						}catch (Exception e) {
							e.printStackTrace();
						}
				}
				
				
				
				int h = (int) totalOT; 
				int m = (int) ((totalOT - (double)h)*60);
				
				o.setTotalOT(String.valueOf(Math.abs(h) + " Hrs," + Math.abs(m)
						+ " Mins"));
				
				
				
				
				h = 0;
				m = 0;
				h = (int) (totalRigUp / 60);
				m = (int) (totalRigUp - 60 * h);
				o.setTotalRigUp(String.valueOf(h + " Hrs,"
						+m + " Mins"));
				h = 0;
				m = 0;
				h = (int) (totalRigDown / 60);
				m = (int) (totalRigDown - 60 * h);
				o.setTotalRigDown(String.valueOf(h + " Hrs,"
						+ m + " Mins"));
				o.setTotalLT(totalLT + " Hrs");
				o.setTotalCHRuns(String.valueOf(Math.round(totalCHRuns)));
				if(countLqat==0){
					countLqat=1;
				}
				o.setTotalLQAT(Math.round(totalLQAT / countLqat)+ "%");
				if(countLqap==0){
					countLqap=1;
				}
				double roundedLQAP = (double) Math.round((totalLQAP / countLqap) * 100.0) / 100.0;
				
//				int nonMisRun=totalRun-totalNonChMissRun;
				totalRun=runNos.size();
				double runEff=0.0;
				if(totalRun>0){
					runEff=(double)(((double)totalRun-(double)totalCHMissRun)/(double)totalRun)*100.0; 
				}else{
					runEff=0;
				}
//				System.out.println("("+totalRun +" - "+totalCHMissRun +") /"+ totalRun + " = "+runEff);
				
				double roundedRunEff = (double) Math.round(runEff * 100.0) / 100.0;
				o.setRunEfficiency(roundedRunEff+"%");
				
				o.setTotalLQAP(roundedLQAP+ "%");
				o.setTotalNoJobs(getTotalJobs.size() + "");
				o.setTotalNoServices(countServiceNos + "");
				o.setTotalNoLossTime(countLossTime + "");
				o.setTotalNoCHMissRuns(totalCHMissRun + "");
//				double ot=totalOT/60;
				Double oe = (((totalOT - totalLT) / totalOT) * 100);
				double rounded = (double) Math.round(oe * 100.0) / 100.0;
				o.setTotalOE(rounded+"%" );
				
				
				double se =  (((double)countServiceNos-(double)countLossTime)/countServiceNos);
				
				rounded = ((double) Math.round(se * 10000.0))/100.0;/*RoundTo2Decimals(se);*/
			
				o.setTotalSE(rounded+"%");
				
				
				operationList.add(o);
				srvices.clear();
				getTotalJobs.clear();
				runNos.clear();

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return INPUT;

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

	public boolean isNumeric(String data) {
		try {

			Double.parseDouble(data);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	private List<JobServiceBean> serviceListByDate(Set<JobBean> jobListByDate,
			Set<JobServiceBean> serviceList) {
		List<JobServiceBean> services = new ArrayList<JobServiceBean>();
		for (JobBean jobBean : jobListByDate) {
			for (JobServiceBean jobServiceBean : serviceList) {
				if (jobBean.getJobNo().equals(jobServiceBean.getJobNo())) {
					services.add(jobServiceBean);
				}
			}
		}

		return services;
	}
	
/*	double RoundTo2Decimals(double val) {
		double d=0.0d;
        try {
			DecimalFormat df2 = new DecimalFormat("###.##");
			d =Double.valueOf(df2.format(val)); 
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			System.out.println(val);
			e.printStackTrace();
		}
		System.out.println(d);
		return d;
        
	}*/
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

	public List<OperationReportBean> getOperationList() {
		return operationList;
	}

	public void setOperationList(List<OperationReportBean> operationList) {
		this.operationList = operationList;
	}

}
