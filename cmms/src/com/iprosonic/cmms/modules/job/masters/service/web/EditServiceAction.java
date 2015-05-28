package com.iprosonic.cmms.modules.job.masters.service.web;


import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.iprosonic.cmms.modules.job.masters.service.domain.ServiceMstBean;
import com.iprosonic.cmms.modules.job.masters.service.service.SearcheService;
import com.opensymphony.xwork2.ActionSupport;

public class EditServiceAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private ServiceMstBean serviceMstBean = new ServiceMstBean();
	private SearcheService searcheService = new SearcheService();

	public String execute() {
		System.out
				.println("----------------------EditServiceAction--------------------------");
		HttpServletRequest request = ServletActionContext.getRequest();
		setServiceMstBean(searcheService.searchServiceById(Integer
				.parseInt(request.getParameter("id"))));
		return SUCCESS;
	}

	public void setServiceMstBean(ServiceMstBean serviceMstBean) {
		this.serviceMstBean = serviceMstBean;
	}

	public ServiceMstBean getServiceMstBean() {
		return serviceMstBean;
	}



}
