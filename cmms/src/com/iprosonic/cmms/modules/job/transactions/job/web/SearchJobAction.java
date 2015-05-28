package com.iprosonic.cmms.modules.job.transactions.job.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.iprosonic.cmms.modules.job.transactions.job.domain.JobBean;
import com.iprosonic.cmms.modules.job.transactions.job.service.SearchJobService;
import com.iprosonic.cmms.modules.masters.location.service.LocationCDService;
import com.iprosonic.cmms.pjcommons.utility.DateUtil;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class SearchJobAction extends ActionSupport implements ModelDriven<JobBean>, SessionAware {

	private static final long	serialVersionUID	= 1L;
	SearchJobService			searchJobService	= new SearchJobService();

	public Map<String, Object>	sessionmap;
	private String				locationCd			= "-Select-";
	private String				toDate				= "";
	private String				fromDate			= "";
	private String				jobStatus			= "";
	private String				clientName			= "";

	private List<String>		statusList			= new ArrayList<String>();
	private List<JobBean>		jobList				= new ArrayList<JobBean>();
	List<String>				unitList			= new ArrayList<String>();
	private JobBean				jobBean				= new JobBean();
	private LocationCDService	locationCDService	= new LocationCDService();

	public String execute() {
		try {
			jobBean.setJobDate(DateUtil.getCurrentJobDate());
			HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
			unitList = locationCDService.getUnitNameList();
			String fromDate = request.getParameter("fromDate");
			String toDate = request.getParameter("toDate");
			String clientName = request.getParameter("clientName");
			String jobStatus = request.getParameter("jobStatus");
			String locationCd = request.getParameter("locationCd");
			
		

			if (toDate == null && fromDate == null) {
				toDate = DateUtil.getCurrentJobDate();
				fromDate = DateUtil.getCurrentJobDate();
				jobStatus = "-Select-";
				locationCd = "-Select-";
				clientName= "-Select-";
			}
			
			this.clientName= clientName;
			this.jobStatus = jobStatus;
			this.locationCd = locationCd;
			this.fromDate = fromDate;
			this.toDate = toDate;

			statusList.add("PENDING_WITH_ENGINEER");
			statusList.add("PENDING_WITH_FSQC");
			statusList.add("CLOSE_JOB");
			statusList.add("DELETED");

			jobList = searchJobService.getJobList(fromDate, toDate, clientName, jobStatus, locationCd);
			sessionmap.put("jobList", jobList);

		} catch (Exception e) {

			e.printStackTrace();
		}
		return SUCCESS;
	}

	public void setJobList(List<JobBean> jobList) {
		this.jobList = jobList;
	}

	public List<JobBean> getJobList() {
		return jobList;
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

	@Override
	public void setSession(Map<String, Object> arg0) {
		sessionmap = arg0;
	}

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getJobStatus() {
		return jobStatus;
	}

	public void setJobStatus(String jobStatus) {
		this.jobStatus = jobStatus;
	}

	public String getLocationCd() {
		return locationCd;
	}

	public void setLocationCd(String locationCd) {
		this.locationCd = locationCd;
	}

	public List<String> getStatusList() {
		return statusList;
	}

	public void setStatusList(List<String> statusList) {
		this.statusList = statusList;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

}
