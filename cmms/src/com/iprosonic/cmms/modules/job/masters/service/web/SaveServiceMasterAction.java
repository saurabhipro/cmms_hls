package com.iprosonic.cmms.modules.job.masters.service.web;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.iprosonic.cmms.modules.job.masters.service.domain.ServiceMstBean;
import com.iprosonic.cmms.modules.job.masters.service.service.SaveService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class SaveServiceMasterAction extends ActionSupport implements
		ModelDriven<ServiceMstBean> 
{
	private static final long serialVersionUID = 1L;

	private ServiceMstBean serviceMstBean = new ServiceMstBean();
	SaveService saveService=new SaveService(); 
	@Override
	public void validate() {
	}

	public String execute() {
		saveService.updateService(getModel());
		String message = "Service  " + getModel().getServiceType()
				+ " saved succefully.";
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("message", message);

		return SUCCESS;
	}


	@Override
	public ServiceMstBean getModel() {

		return serviceMstBean;
	}

	public void setServiceMstBean(ServiceMstBean serviceMstBean) {
		this.serviceMstBean = serviceMstBean;
	}

	public ServiceMstBean getServiceMstBean() {
		return serviceMstBean;
	}

}
