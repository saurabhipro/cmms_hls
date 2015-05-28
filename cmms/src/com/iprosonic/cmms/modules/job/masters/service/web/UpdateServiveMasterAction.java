package com.iprosonic.cmms.modules.job.masters.service.web;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.iprosonic.cmms.modules.job.masters.service.domain.ServiceMstBean;
import com.iprosonic.cmms.modules.job.masters.service.service.UpdateService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UpdateServiveMasterAction extends ActionSupport implements
		ModelDriven<ServiceMstBean> {
	private static final long serialVersionUID = 1L;

	private ServiceMstBean serviceMstBean = new ServiceMstBean();
	private UpdateService updateService= new UpdateService();

	public String execute() {
		getUpdateService().updateService(getModel());
		String message = "Service type " + getModel().getServiceType()
				+ " updated succefully.";
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("message", message);

		return SUCCESS;
	}


	@Override
	public ServiceMstBean getModel() {

		return serviceMstBean;
	}


	public void setUpdateService(UpdateService updateService) {
		this.updateService = updateService;
	}


	public UpdateService getUpdateService() {
		return updateService;
	}

}
