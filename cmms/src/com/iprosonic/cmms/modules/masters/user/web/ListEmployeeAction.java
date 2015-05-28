package com.iprosonic.cmms.modules.masters.user.web;

import java.util.ArrayList;
import java.util.List;

import com.iprosonic.cmms.modules.masters.user.dao.EmployeeDaoImpl;
import com.iprosonic.cmms.modules.masters.user.domain.EmployeeBean;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ListEmployeeAction extends ActionSupport implements
		ModelDriven<EmployeeBean> {

	private static final long serialVersionUID = -6659925652584240539L;
	private EmployeeBean emp = new EmployeeBean();
	private List<EmployeeBean> employeeList = new ArrayList<EmployeeBean>();
	private EmployeeDaoImpl employeeDao = new EmployeeDaoImpl();

	public EmployeeBean getModel() {
		return emp;
	}

	public String execute() {
		userlist();
		return SUCCESS;
	}

	public void userlist() {

		employeeList = employeeDao.listUser();
		setEmployeeList(employeeList);
	}

	public void setEmployeeList(List<EmployeeBean> employeeList) {
		this.employeeList = employeeList;
	}

	public List<EmployeeBean> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeDao(EmployeeDaoImpl employeeDao) {
		this.employeeDao = employeeDao;
	}

	public EmployeeDaoImpl getEmployeeDao() {
		return employeeDao;
	}

}
