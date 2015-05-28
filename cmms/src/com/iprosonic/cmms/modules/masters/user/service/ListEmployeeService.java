package com.iprosonic.cmms.modules.masters.user.service;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.iprosonic.cmms.modules.masters.user.dao.EmployeeDaoImpl;
import com.iprosonic.cmms.modules.masters.user.domain.EmployeeBean;
import com.opensymphony.xwork2.ActionContext;

public class ListEmployeeService
{
	private static final long serialVersionUID = -6659925652584240539L;
	private EmployeeBean emp = new EmployeeBean();
	private EmployeeDaoImpl empDao = new EmployeeDaoImpl();
	private String userName;
	
	public void delete(String id) {
		HttpServletRequest request = (HttpServletRequest) ActionContext
				.getContext().get(ServletActionContext.HTTP_REQUEST);
		
	}	
}
