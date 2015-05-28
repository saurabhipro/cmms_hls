package com.iprosonic.cmms.pjcommons.utility;


import java.util.ArrayList;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;



import com.iprosonic.cmms.modules.job.transactions.job.dao.JobRigDaoImpl;
import com.iprosonic.cmms.modules.job.transactions.job.dao.JobRunDaoImpl;
import com.iprosonic.cmms.modules.job.transactions.job.domain.JobBean;
import com.iprosonic.cmms.modules.job.transactions.job.domain.JobRigBean;
import com.iprosonic.cmms.modules.job.transactions.job.domain.JobRunBean;
import com.iprosonic.cmms.modules.job.transactions.job.domain.JobServiceBean;
import com.iprosonic.cmms.modules.job.transactions.job.service.SearchJobService;
import com.iprosonic.cmms.modules.masters.user.domain.EmployeeBean;
import com.iprosonic.cmms.pjcommons.model.OperationReportBean;

import com.iprosonic.cmms.modules.masters.user.dao.EmployeeDaoImpl;

import com.iprosonic.cmms.pjcommons.utility.DateUtil;

public class Fusionutil {

	
	private EmployeeDaoImpl employeeDaoImpl = new EmployeeDaoImpl();
	private JobRigDaoImpl jobRigDaoImpl = new JobRigDaoImpl();
	private JobRunDaoImpl jobRunDaoImpl = new JobRunDaoImpl();
	private SearchJobService searchJobService = new SearchJobService();
	private List<OperationReportBean> operationList = new ArrayList<OperationReportBean>();
	
	public  ArrayList<String> GetAllCharts(String toDate, String fromDate,String stype){
		    
		  
		    
		try {
			List<EmployeeBean> employees = employeeDaoImpl.englist();
			
			 System.out.println("employee size .. "+employees.size());
			 
			 Set<JobBean> jobListByDate=null;
			 
			if(stype.equals("")){ 
			 jobListByDate = searchJobService.getJobListSetByDate(
					fromDate, toDate);
			}
			else
			{
				jobListByDate = searchJobService.getJobListSetByDateNServType(
						fromDate, toDate,stype);
			}
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
			int countJobNos = 0;
			int countServiceNos = 0;
			int countLossTime = 0;
			int countLqat=0; 
			int countLqap=0;
			
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
				Boolean isContains=false;
				for (JobBean jb : jobListByDate) {
					for (JobServiceBean servicebean : serviceList) {
						isContains = EmpContainsMatch.matchEmp(servicebean.getEngi(),empBean.getEmployeeShortName());
						if (jb.getJobNo().equals(servicebean.getJobNo()) && isContains ) {
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
								
								/*System.out.println(empBean.getEmployeeShortName()+"- OT "+totalOT +" upcoming OT :"+runbean.getOt());*/
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
						
						
					
										
						}catch (Exception e) {
							e.printStackTrace();
						}
				}
				

				
				int h = (int) totalOT; 
				int m = (int) ((totalOT - (double)h)*60);
				
				o.setTotalOT(String.valueOf(Math.abs(h) + "." + Math.abs(m)));
				h = 0;
				m = 0;
				h = (int) (totalRigUp / 60);
				m = (int) (totalRigUp - 60 * h);
				o.setTotalRigUp(String.valueOf(h+"."+m));
				h = 0;
				m = 0;
				h = (int) (totalRigDown / 60);
				m = (int) (totalRigDown - 60 * h);
				o.setTotalRigDown(String.valueOf(h + "."+ m));
				o.setTotalLT(totalLT +"");
				o.setTotalCHRuns(String.valueOf(Math.round(totalCHRuns)));
				if(countLqat==0){
					countLqat=1;
				}
				o.setTotalLQAT(Math.round(totalLQAT / countLqat)+ "");
				if(countLqap==0){
					countLqap=1;
				}
				
				double roundedLQAP = (double) Math.round((totalLQAP / countLqap) * 100.0) / 100.0;
				o.setTotalLQAP(roundedLQAP+ "");
				o.setTotalNoJobs(getTotalJobs.size() + "");
				o.setTotalNoServices(countServiceNos + "");
				o.setTotalNoLossTime(countLossTime + "");
				o.setTotalNoCHMissRuns(totalCHMissRun + "");
//				double ot=totalOT/60;
				Double oe = (((totalOT - totalLT) / totalOT) * 100);
				double rounded = (double) Math.round(oe * 100.0) / 100.0;
				o.setTotalOE(rounded+"" );
				
				
				float se =  (((float)countServiceNos-(float)countLossTime)/countServiceNos);
				
				rounded = (double) Math.round(se * 100.0) ;
				
				o.setTotalSE(rounded+"");
				operationList.add(o);
				srvices.clear();
				getTotalJobs.clear();
				runNos.clear();
			}

		} catch (Exception e) {
			e.printStackTrace();
		  
		}
		          		
		return generateCharts();
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
	
	
	
	public ArrayList<String> generateCharts(){
		
	
		 ArrayList<String> charts=new ArrayList<String>();
		
		StringBuffer jobs=new StringBuffer("<graph caption='Jobs By engineers ' subcaption='For the year 2013' xAxisName='engineers ' yAxisMinValue='0' yAxisName='Job Numbers' decimalPrecision='0' formatNumberScale='0' numberPrefix='' rotateNames='1' showNames='1' showValues='0'  showAlternateHGridColor='1' AlternateHGridColor='ff5904' divLineColor='ff5904' yAxisMaxValue='1'  divLineAlpha='20' alternateHGridAlpha='5' >");
		StringBuffer ltService=new StringBuffer("<graph caption='Services with lost times by engineers' xAxisName='engineers' yAxisName='LT Services' decimalPrecision='0' formatNumberScale='1' rotateNames='1' showLimits='0' yAxisMaxValue='1'>");
		StringBuffer services=new StringBuffer("<graph caption='Services by engineers' xAxisName='engineers' yAxisName='Number Of Servcices' decimalPrecision='0' formatNumberScale='0' rotateNames='1' yAxisMaxValue='1'>");
		
		StringBuffer chmissrun=new StringBuffer("<graph caption='CHMissRuns by engineers' xAxisName='engineers' yAxisName='CHMissRuns' decimalPrecision='0' formatNumberScale='0' rotateNames='1' yAxisMaxValue='1'>");
		
		StringBuffer opTime=new StringBuffer("<graph caption='OperationTime by engineers' xAxisName='engineers' yAxisName='OT' decimalPrecision='0' formatNumberScale='0' rotateNames='1' yAxisMaxValue='1'>");
		StringBuffer oEff=new StringBuffer("<graph caption='OverAll Efficiency Of Engineers' xAxisName='engineers' yAxisName='OE in %' decimalPrecision='0' formatNumberScale='0' rotateNames='1' yAxisMaxValue='1'>");
		
		 Iterator<OperationReportBean> it=operationList.iterator();
		 
		 OperationReportBean op;
		 String ename="";
		  String[] colrs={"008E8E","F6BD0F","008E8E","FF8E46","008E8E","D64646","008E8E","588526","008E8E","008ED6"};
		 int i=0;
		    while(it.hasNext()){
		    	
		    	op=(OperationReportBean)it.next();
		    	
		    	ename=op.getEngName();
		    
		    	jobs.append("<set name='"+ename+"' value='"+op.getTotalNoJobs()+"' color='"+colrs[i]+"'/>");
		    	ltService.append("<set name='"+ename+"' value='"+op.getTotalNoLossTime()+"' color='"+colrs[i]+"'/>");
		    	services.append("<set name='"+ename+"' value='"+op.getTotalNoServices()+"' color='"+colrs[i]+"'/>");
		    	chmissrun.append("<set name='"+ename+"' value='"+op.getTotalNoCHMissRuns()+"' color='"+colrs[i]+"'/>");
		    	opTime.append("<set name='"+ename+"' value='"+op.getTotalOT()+"' color='"+colrs[i]+"'/>");
                oEff.append("<set name='"+ename+"' value='"+op.getTotalOE()+"' color='"+colrs[i]+"'/>");
                if(i>8){i=0;}
                else{i++;}
		            
		    }
		    jobs.append("</graph>");
		    ltService.append("</graph>");
		    services.append("</graph>");
		    chmissrun.append("</graph>");
		    opTime.append("</graph>");
		    oEff.append("</graph>");
		
		     charts.add(jobs.toString());
		     charts.add(ltService.toString());
		     charts.add(services.toString());
		     charts.add(chmissrun.toString());
		     charts.add(opTime.toString());
		     charts.add(oEff.toString());
		     
		return charts;
	}
	
	
}
