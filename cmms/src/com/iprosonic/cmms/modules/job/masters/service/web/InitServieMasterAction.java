package com.iprosonic.cmms.modules.job.masters.service.web;


import com.iprosonic.cmms.modules.job.masters.service.domain.ServiceMstBean;
import com.opensymphony.xwork2.ActionSupport;

public class InitServieMasterAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	private ServiceMstBean serviceMstBean = new ServiceMstBean();

	public String execute() {
		return SUCCESS;
	}

	public void setServiceMstBean(ServiceMstBean serviceMstBean) {
		this.serviceMstBean = serviceMstBean;
	}

	public ServiceMstBean getServiceMstBean() {
		return serviceMstBean;
	}

}
