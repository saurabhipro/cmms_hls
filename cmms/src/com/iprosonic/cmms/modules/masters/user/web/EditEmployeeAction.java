package com.iprosonic.cmms.modules.masters.user.web;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.iprosonic.cmms.modules.masters.user.dao.EmployeeDaoImpl;
import com.iprosonic.cmms.modules.masters.user.domain.EmployeeBean;
import com.iprosonic.cmms.modules.masters.user.service.EditEmployeeService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class EditEmployeeAction extends ActionSupport implements
		ModelDriven<EmployeeBean> {
	private static final long serialVersionUID = -6659925652584240539L;
	private EmployeeBean employeeBean = new EmployeeBean();
	private List<EmployeeBean> employeeList = new ArrayList<EmployeeBean>();
	private EmployeeDaoImpl employeeDao = new EmployeeDaoImpl();
	private String userName;

	EditEmployeeService editUserService = new EditEmployeeService();

	public String execute() {
		
		HttpServletRequest request = (HttpServletRequest) ActionContext
				.getContext().get(ServletActionContext.HTTP_REQUEST);
		String message = "Employee updated succesfully";
		request.setAttribute("message", message);

		request.setAttribute("edit", "true");
		edit();
		setEmployeeList(employeeDao.listUser());

		return SUCCESS;
	}

	public void edit() {
		
		
		HttpServletRequest request = (HttpServletRequest) ActionContext
				.getContext().get(ServletActionContext.HTTP_REQUEST);
		setEmployeeBean(editUserService.edit(request.getParameter("id")));
	
	}

	@Override
	public EmployeeBean getModel() {
		return null;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserName() {
		return userName;
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
