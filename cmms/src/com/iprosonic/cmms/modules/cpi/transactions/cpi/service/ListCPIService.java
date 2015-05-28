package com.iprosonic.cmms.modules.cpi.transactions.cpi.service;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.iprosonic.cmms.modules.masters.user.dao.EmployeeDaoImpl;
import com.iprosonic.cmms.modules.masters.user.domain.EmployeeBean;
import com.opensymphony.xwork2.ActionContext;

public class ListCPIService
{
	private static final long serialVersionUID = -6659925652584240539L;
	private EmployeeBean user = new EmployeeBean();
	private List<EmployeeBean> userList = new ArrayList<EmployeeBean>();
	private EmployeeDaoImpl userDAO = new EmployeeDaoImpl();
	private String userName;

	public void delete(String id) {
		HttpServletRequest request = (HttpServletRequest) ActionContext
				.getContext().get(ServletActionContext.HTTP_REQUEST);
	}	
}
