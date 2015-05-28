package com.iprosonic.cmms.modules.job.transactions.job.web;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.iprosonic.cmms.modules.job.transactions.job.domain.JobBean;
import com.iprosonic.cmms.modules.job.transactions.job.service.SearchJobService;
import com.iprosonic.cmms.modules.masters.client.service.SearchClientMaster;
import com.iprosonic.cmms.modules.masters.location.service.LocationCDService;
import com.iprosonic.cmms.pjcommons.utility.DateUtil;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class InitSearchJobAction extends ActionSupport implements ModelDriven<JobBean> {
	SimpleDateFormat			sdf					= new SimpleDateFormat("yyyy-MM-dd");
	private static final long	serialVersionUID	= 1L;
	private List<String>		jobNoHlsList		= new ArrayList<String>();
	private List<String>		clientNameList		= new ArrayList<String>();
	private List<String>		statusList			= new ArrayList<String>();
	private List<String>		locationList			= new ArrayList<String>();

	private SearchJobService	searchJobService	= new SearchJobService();
	private LocationCDService	locationCDService	= new LocationCDService();
	private JobBean				jobBean				= new JobBean();
	private SearchClientMaster	searchClientMaster	= new SearchClientMaster();

	private String				fromDate			= "";
	private String				toDate				= "";
	private String				locationCd				= "";

	public String execute() {
		try {
			Map<String, Object> session = (Map<String, Object>) ActionContext.getContext().get("session");

			fromDate = sdf.format(new Date());
			toDate = sdf.format(new Date());
			jobBean.setJobDate(DateUtil.getCurrentJobDate());

			locationList = locationCDService.getUnitNameList();
			clientNameList = searchClientMaster.getClientNameList();
			jobNoHlsList = searchJobService.getJobHlsNoList();

			statusList.add("PENDING_WITH_ENGINEER");
			statusList.add("PENDING_WITH_FSQC");
			statusList.add("CLOSE_JOB");
			statusList.add("DELETED");

			session.put("locationList", locationList);
			session.put("clientNameList", clientNameList);
			session.put("jobNoHlsList", jobNoHlsList);
			session.put("statusList", statusList);

		} catch (Exception e) {

			e.printStackTrace();
		}
		return SUCCESS;
	}

	@Override
	public JobBean getModel() {

		return null;
	}

	public void setJobBean(JobBean jobBean) {
		this.jobBean = jobBean;
	}

	public JobBean getJobBean() {
		return jobBean;
	}

	public void setClientNameList(List<String> clientNameList) {
		this.clientNameList = clientNameList;
	}

	public List<String> getClientNameList() {
		return clientNameList;
	}

	public void setJobNoHlsList(List<String> jobNoHlsList) {
		this.jobNoHlsList = jobNoHlsList;
	}

	public List<String> getJobNoHlsList() {
		return jobNoHlsList;
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

	public List<String> getStatus() {
		return statusList;
	}

	public void setStatus(List<String> jobStatus) {
		this.statusList = jobStatus;
	}


	public List<String> getLocationList() {
		return locationList;
	}

	public void setLocationList(List<String> locationList) {
		this.locationList = locationList;
	}

	public String getLocationCd() {
		return locationCd;
	}

	public void setLocationCd(String locationCd) {
		this.locationCd = locationCd;
	}
}
