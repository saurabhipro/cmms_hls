package com.iprosonic.cmms.modules.job.reports.was.web;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.transform.ToListResultTransformer;

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

public class OperationReportAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private String fromDate;
	private String toDate;
	private SearchJobService searchJobService = new SearchJobService();
	private EmployeeDaoImpl employeeDaoImpl = new EmployeeDaoImpl();
	private JobRigDaoImpl jobRigDaoImpl = new JobRigDaoImpl();
	private JobRunDaoImpl jobRunDaoImpl = new JobRunDaoImpl();
	private List<OperationReportBean> operationList = new ArrayList<OperationReportBean>();

	@Override
	public String execute() {
		try {
			List<EmployeeBean> employees = employeeDaoImpl.englist();
			List<JobBean> jobListByDate = searchJobService.getJobListByDate(
					fromDate, toDate);
			List<JobServiceBean> serviceList = searchJobService
					.getJobServiceList();
			List<JobServiceBean> serviceListByDate = serviceListByDate(
					jobListByDate, serviceList);
			List<JobRunBean> jobRunBeans = jobRunDaoImpl.getRunList();
			List<JobRigBean> jobRigBeans = jobRigDaoImpl.getRigList();
			
			 

			for (EmployeeBean empBean : employees) {
				OperationReportBean o = new OperationReportBean();
				o.setEngName(empBean.getEmployeeShortName());
				Long totalOT = 0L;
				Long totalRigUp = 0L;
				Long totalRigDown = 0L;
				Long totalLQAT = 0L;
				Long totalLQAP = 0L;
				Double totalCHRuns = 0.0;
				Double totalLT = 0.0;
				int totalCHMissRun = 0;
				int countJobNos = 0;
				int countServiceNos = 0;
				int countLossTime = 0;
				Boolean isContains= false;
				
				for (JobBean jb : jobListByDate) {				
					
			
					
					 
						++countJobNos;
						for (JobRunBean runbean : jobRunBeans) {
							if (jb.getJobNo().equals(runbean.getJobNo())) {
								if (!runbean.getRih().equals("0")
										|| !runbean.getPooh().equals("0")) {

									totalOT = totalOT
											+ DateUtil.getTotalOTTime(
													runbean.getRih(),
													runbean.getPooh());
								}
								for (JobRigBean rig : jobRigBeans) {
									if (jb.getJobNo().equals(rig.getJobNo())) {

										if (!rig.getRigUpStart().equals("0")
												|| !rig.getRigUpEnd().equals(
														"0")) {
											totalRigUp = totalRigUp
													+ DateUtil
															.getTotalOTTime(
																	rig.getRigUpStart(),
																	rig.getRigUpEnd());
										}
										if (!rig.getRigDownStart().equals("0")
												|| !rig.getRigDownEnd().equals(
														"0")) {
											totalRigDown = totalRigDown
													+ DateUtil
															.getTotalOTTime(
																	rig.getRigDownStart(),
																	rig.getRigDownEnd());
										}
									}
								}
								
								
								
								
								for (JobServiceBean servicebean : serviceListByDate) {
									isContains = EmpContainsMatch.matchEmp(jb.getEngineer(),empBean.getEmployeeShortName());
									if (servicebean.getJobNo()
											.equalsIgnoreCase(jb.getJobNo()) && isContains) {
										countServiceNos = countServiceNos + 1;
										String lqat = servicebean
												.getLqaTechnical();
										String lqap = servicebean
												.getLqaPresentation();
										String LT = servicebean.getLossTime();
										String ch = servicebean.getChruns();
										String chmissruns = servicebean
												.getChmisRuns();
										try {
											if (!LT.equals("0"))
												countLossTime++;
											try {
												totalLQAT = totalLQAT
														+ Integer
																.parseInt(isNumeric(lqat) ? lqat
																		: 0 + "");
											} catch (Exception e) {

											}
											totalLQAP = totalLQAP
													+ Integer
															.parseInt(isNumeric(lqap) ? lqap
																	: 0 + "");
											totalCHRuns = totalCHRuns
													+ Double.parseDouble(isNumeric(ch) ? ch
															: 0 + "");
											totalCHMissRun = totalCHMissRun
													+ Integer
															.parseInt(isNumeric(chmissruns) ? chmissruns
																	: 0 + "");

											totalLT = totalLT
													+ Double.parseDouble(isNumeric(LT) ? LT
															: 0 + "");

										} catch (Exception e) {
											e.printStackTrace();
										}
									}
								}
							}
						}
					}
				
				int h = (int) (totalOT / 60);
				int m = (int) (totalOT - 60 * h);
				o.setTotalOT(String.valueOf(Math.abs(h) + " Hrs," + Math.abs(m)
						+ " Mins"));
				h = 0;
				m = 0;
				h = (int) (totalRigUp / 60);
				m = (int) (totalRigUp - 60 * h);
				o.setTotalRigUp(String.valueOf(Math.abs(h) + " Hrs,"
						+ Math.abs(m) + " Mins"));
				h = 0;
				m = 0;
				h = (int) (totalRigDown / 60);
				m = (int) (totalRigDown - 60 * h);
				o.setTotalRigDown(String.valueOf(Math.abs(h) + " Hrs,"
						+ Math.abs(m) + " Mins"));
				o.setTotalLT(totalLT + " Hrs");
				o.setTotalCHRuns(String.valueOf(Math.round(totalCHRuns)));
				o.setTotalLQAT(String.valueOf((totalLQAT) / 100
						* countServiceNos)
						+ " %");
				o.setTotalLQAP(String.valueOf((totalLQAP) / 100
						* countServiceNos)
						+ " %");
				o.setTotalNoJobs(countJobNos + "");
				o.setTotalNoServices(countServiceNos + "");
				o.setTotalNoLossTime(countLossTime + "");
				o.setTotalNoCHMissRuns(totalCHMissRun + "");
				Double oe = (((totalOT - totalLT / 60) / totalOT) * 100);
				double rounded = (double) Math.round(oe * 100) / 100;
				o.setTotalOE(rounded + " %");
				System.out.println("Eng name - "
						+ empBean.getEmployeeShortName());
				System.out.println("LQAT -" + totalLQAT);
				System.out.println("LQAP - " + totalLQAP);
				System.out.println("Total no of services" + countServiceNos);
				operationList.add(o);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return INPUT;

	}

	public boolean isNumeric(String data) {
		try {

			Double.parseDouble(data);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	private List<JobServiceBean> serviceListByDate(List<JobBean> jobListByDate,
			List<JobServiceBean> serviceList) {
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
