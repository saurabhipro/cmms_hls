package com.iprosonic.cmms.modules.masters.user.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.iprosonic.cmms.modules.masters.user.dao.EmployeeDaoImpl;
import com.iprosonic.cmms.modules.masters.user.domain.EmployeeBean;
import com.opensymphony.xwork2.ActionSupport;
public class InitSearchEmployeeAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private Map<String, String> accordion;
	private EmployeeBean employeeBean = new EmployeeBean();
	private List<EmployeeBean> employeeList = new ArrayList<EmployeeBean>();
	private EmployeeDaoImpl employeeDao = new EmployeeDaoImpl();

	public void validate() {

	}

	public String execute() {
		employeeList = employeeDao.listEmployee();
		return SUCCESS;
	}

	public Map<String, String> getAccordion() {
		return accordion;
	}

	public void setEmployeeBean(EmployeeBean employeeBean) {
		this.employeeBean = employeeBean;
	}

	public EmployeeBean getEmployeeBean() {
		return employeeBean;
	}

	public void setEmployeeList(List<EmployeeBean> employeeList) {
		this.employeeList = employeeList;
	}

	public List<EmployeeBean> getEmployeeList() {
		return employeeList;
	}

}
