package com.iprosonic.cmms.modules.job.transactions.job.web;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.iprosonic.cmms.modules.masters.client.service.SearchClientMaster;
import com.iprosonic.cmms.modules.masters.location.service.LocationCDService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class InitCreateJobAction extends ActionSupport {

	SimpleDateFormat			jobDateFormate		= new SimpleDateFormat("yyyy-MM-dd");
	private String				jobDate				= jobDateFormate.format(new Date()).toString();
	private static final long	serialVersionUID	= 1L;
	private List<String>		clientNameList		= new ArrayList<String>();
	private LocationCDService	locationCDService	= new LocationCDService();
	SearchClientMaster			searchClientMaster	= new SearchClientMaster();

	public String execute() {
		Map<String, Object> session = (Map<String, Object>) ActionContext.getContext().get("session");
		session.put("clientNameList", searchClientMaster.getClientNameList());
		session.put("locationMstList", locationCDService.getUnitNameList());
		return SUCCESS;
	}

	public void setClientNameList(List<String> clientNameList) {
		this.clientNameList = clientNameList;
	}

	public List<String> getClientNameList() {
		return clientNameList;
	}

	public String getJobDate() {
		return jobDate;
	}

	public void setJobDate(String jobDate) {
		this.jobDate = jobDate;
	}

}
