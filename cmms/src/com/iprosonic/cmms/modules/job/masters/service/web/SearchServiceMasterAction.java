package com.iprosonic.cmms.modules.job.masters.service.web;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.iprosonic.cmms.modules.job.masters.service.domain.ServiceMstBean;
import com.iprosonic.cmms.modules.job.masters.service.service.SearcheService;
import com.opensymphony.xwork2.ActionSupport;

public class SearchServiceMasterAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	private ServiceMstBean serviceMstBean = new ServiceMstBean();
	private SearcheService searcheService = new SearcheService();

	private List<ServiceMstBean> serviceList = new ArrayList<ServiceMstBean>();;

	public String execute() {
		String serviceType = ServletActionContext.getRequest().getParameter(
				"serviceType");
		
		HttpServletRequest request = ServletActionContext.getRequest();
		setServiceList(searcheService.searchServiceByType(serviceType));
		request.setAttribute("serviceList", getServiceList());
		
		return SUCCESS;
	}


	public void setServiceMstBean(ServiceMstBean serviceMstBean) {
		this.serviceMstBean = serviceMstBean;
	}

	public ServiceMstBean getServiceMstBean() {
		return serviceMstBean;
	}


	public void setServiceList(List<ServiceMstBean> serviceList) {
		this.serviceList = serviceList;
	}


	public List<ServiceMstBean> getServiceList() {
		return serviceList;
	}

}
