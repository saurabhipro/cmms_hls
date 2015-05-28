package com.iprosonic.cmms.modules.masters.user.service;
import com.iprosonic.cmms.modules.masters.user.dao.EmployeeDaoImpl;
import com.iprosonic.cmms.modules.masters.user.domain.EmployeeBean;

public class EditEmployeeService {
	private EmployeeBean emp = new EmployeeBean();
	private EmployeeDaoImpl empDao = new EmployeeDaoImpl();
	
	public EmployeeBean edit(String id) {			
		emp= empDao.listEmployeeById(Integer.parseInt(id));
		return emp;
	}
}
