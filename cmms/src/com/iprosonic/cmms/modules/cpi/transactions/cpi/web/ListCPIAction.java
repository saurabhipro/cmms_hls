package com.iprosonic.cmms.modules.cpi.transactions.cpi.web;

import java.util.ArrayList;
import java.util.List;

import com.iprosonic.cmms.modules.masters.user.dao.EmployeeDaoImpl;
import com.iprosonic.cmms.modules.masters.user.domain.EmployeeBean;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ListCPIAction extends ActionSupport implements
		ModelDriven<EmployeeBean> {

	private static final long serialVersionUID = -6659925652584240539L;
	private EmployeeBean user = new EmployeeBean();
	private List<EmployeeBean> userList = new ArrayList<EmployeeBean>();
	private EmployeeDaoImpl userDAO = new EmployeeDaoImpl();

	public EmployeeBean getModel() {
		return user;
	}

	public String execute() {
		userlist();
		return SUCCESS;
	}

	public void userlist() {

		userList = userDAO.listUser();
		setUserList(userList);
	}

	public EmployeeBean getUser() {
		return user;
	}

	public void setUser(EmployeeBean user) {
		this.user = user;
	}

	public List<EmployeeBean> getUserList() {
		return userList;
	}

	public void setUserList(List<EmployeeBean> userList) {
		this.userList = userList;
	}
}
