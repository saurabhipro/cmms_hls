package com.iprosonic.cmms.modules.job.reports.jobbonus.web;



import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.iprosonic.cmms.modules.job.reports.jobbonus.service.JobBonusReportService;
import com.iprosonic.cmms.modules.job.transactions.job.domain.JobBean;
import com.iprosonic.cmms.modules.job.transactions.job.domain.JobRunBean;
import com.iprosonic.cmms.pjcommons.utility.DateUtil;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class JobBonusReportAction extends ActionSupport implements
ModelDriven<JobBean>{
	private static final long serialVersionUID = 1L;

	private JobBonusReportService jobBonusReportService = new JobBonusReportService();
    private JobBean jobBean = new JobBean();
	private Set<JobRunBean> jobRunSet = new HashSet<JobRunBean>();

	@Override
	public String execute() {

		HttpServletRequest request = ServletActionContext.getRequest();
		try{
			jobBean.setJobDate(DateUtil.getCurrentJobDate());
			request.setAttribute(
					"bonusReport",
					jobBonusReportService.getBonusReport(
							request.getParameter("fromDate"),
							request.getParameter("toDate"),
							request.getParameter("jobNo")));
			

		} catch (Exception e) {
			e.printStackTrace();
		}

		return SUCCESS;
	}

	public void setJobRunSet(Set<JobRunBean> jobRunSet) {
		this.jobRunSet = jobRunSet;
	}

	public Set<JobRunBean> getJobRunSet() {
		return jobRunSet;
	}

	@Override
	public JobBean getModel() {
		
		return jobBean;
	}

	public void setJobBean(JobBean jobBean) {
		this.jobBean = jobBean;
	}

	public JobBean getJobBean() {
		return jobBean;
	}

}
