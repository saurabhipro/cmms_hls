package com.iprosonic.cmms.modules.dashboard.web;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.iprosonic.cmms.modules.job.transactions.job.domain.JobBean;
import com.iprosonic.cmms.modules.job.transactions.job.service.SearchJobService;
import com.iprosonic.cmms.modules.masters.client.service.SearchClientMaster;
import com.iprosonic.cmms.pjcommons.utility.DateUtil;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class DashboardSearch extends ActionSupport implements SessionAware {
	
	private String fromDate;
	private String toDate;
	SearchJobService searchJobService = new SearchJobService();
	
	public Map sessionmap;
	
	private List<JobBean> deshboardList = new ArrayList<JobBean>();

	@Override
	public String execute() throws Exception {

		deshboardList = searchJobService.getJobListByDate(getFromDate(), getToDate());
		
		sessionmap.put("deshboardList", deshboardList);
		
		
		return SUCCESS;
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

	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		sessionmap=arg0;
	}

	public List<JobBean> getDeshboardList() {
		return deshboardList;
	}

	public void setDeshboardList(List<JobBean> deshboardList) {
		this.deshboardList = deshboardList;
	}
	
	

	
	
}
