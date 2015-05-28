package com.iprosonic.cmms.modules.masters.user.web;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.iprosonic.cmms.modules.masters.user.dao.EmployeeDaoImpl;
import com.iprosonic.cmms.modules.masters.user.domain.EmployeeBean;
import com.iprosonic.cmms.modules.masters.user.service.SaveOrUpdateEmployeeService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class SaveEmployeeAction extends ActionSupport implements
		ModelDriven<EmployeeBean> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private EmployeeBean employeeBean = new EmployeeBean();
	private EmployeeDaoImpl employeeDao = new EmployeeDaoImpl();
	SaveOrUpdateEmployeeService saveOrUpdateUserService = new SaveOrUpdateEmployeeService();

	public void validate() {
		if (employeeDao.isLoginIdExist(getEmployeeBean().getEmployeeCd()) == true) {
			
			addFieldError("employeeCd",
					"This employee Code already exists \n Please enter another employeeCd");
		}
	}

	public String execute() {

		HttpServletRequest request = ServletActionContext.getRequest();

		String message = "Employee " + employeeBean.getEmployeeCd()
				+ "  is created.";
		request.setAttribute("message", message);

		
		saveOrUpdate();
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

	public void setEmployeeBean(EmployeeBean employeeBean) {
		this.employeeBean = employeeBean;
	}

	public EmployeeBean getEmployeeBean() {
		return employeeBean;
	}

}
