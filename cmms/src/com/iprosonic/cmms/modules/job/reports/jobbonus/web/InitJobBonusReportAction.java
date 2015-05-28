package com.iprosonic.cmms.modules.job.reports.jobbonus.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.iprosonic.cmms.modules.job.reports.jobbonus.service.JobBonusReportService;
import com.iprosonic.cmms.modules.job.transactions.job.domain.JobBean;
import com.iprosonic.cmms.modules.job.transactions.job.domain.JobRunBean;
import com.iprosonic.cmms.pjcommons.utility.DateUtil;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class InitJobBonusReportAction extends ActionSupport implements
		ModelDriven<JobBean> {
	private static final long serialVersionUID = 1L;

	private JobBean jobBean = new JobBean();
	private List<String> jobNoList = new ArrayList<String>();
	private List<JobRunBean> jobRunList = new ArrayList<JobRunBean>();

	private JobBonusReportService jobBonusReportService = new JobBonusReportService();

	@Override
	public String execute() {
		Map session = (Map) ActionContext.getContext().get("session");
		try {
			jobBean.setJobDate(DateUtil.getCurrentJobDate());
	        jobNoList = jobBonusReportService.getJobNoList();
			session.put("jobNoList", jobNoList);
		} catch (Exception e) {

			e.printStackTrace();
		}

		
		return SUCCESS;
	}

	public void setJobNoList(List<String> jobNoList) {
		this.jobNoList = jobNoList;
	}

	public List<String> getJobNoList() {
		return jobNoList;
	}

	public void setJobRunList(List<JobRunBean> jobRunList) {
		this.jobRunList = jobRunList;
	}

	public List<JobRunBean> getJobRunList() {
		return jobRunList;
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
