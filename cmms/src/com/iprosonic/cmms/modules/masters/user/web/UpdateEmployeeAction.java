package com.iprosonic.cmms.modules.masters.user.web;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.iprosonic.cmms.modules.masters.user.domain.EmployeeBean;
import com.iprosonic.cmms.modules.masters.user.service.SaveOrUpdateEmployeeService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UpdateEmployeeAction extends ActionSupport implements
		ModelDriven<EmployeeBean> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private EmployeeBean employeeBean = new EmployeeBean();
	private List<EmployeeBean> employeeList = new ArrayList<EmployeeBean>();
	
	SaveOrUpdateEmployeeService saveOrUpdateUserService = new SaveOrUpdateEmployeeService();

	public void validate() {

	}

	public String execute() {

		
		saveOrUpdate();
		HttpServletRequest request = ServletActionContext.getRequest();

		String message= employeeBean.getEmployeeCd() + " employee code is updated successfully.";
		request.setAttribute("message", message);
		return SUCCESS;
	}

	public void saveOrUpdate() {
		try {
			
			saveOrUpdateUserService.saveOrUpdate(getEmployeeBean());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public EmployeeBean getModel() {
		return getEmployeeBean();
	}

	public void setEmployeeList(List<EmployeeBean> employeeList) {
		this.employeeList = employeeList;
	}

	public List<EmployeeBean> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeBean(EmployeeBean employeeBean) {
		this.employeeBean = employeeBean;
	}

	public EmployeeBean getEmployeeBean() {
		return employeeBean;
	}

}
