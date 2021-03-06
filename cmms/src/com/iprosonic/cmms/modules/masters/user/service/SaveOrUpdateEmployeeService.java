package com.iprosonic.cmms.modules.masters.user.service;

import com.iprosonic.cmms.modules.masters.user.dao.EmployeeDaoImpl;
import com.iprosonic.cmms.modules.masters.user.domain.EmployeeBean;

public class SaveOrUpdateEmployeeService {

	private EmployeeBean emp = new EmployeeBean();
	private EmployeeDaoImpl empDao = new EmployeeDaoImpl();

	public String saveOrUpdate(EmployeeBean emp) {
		try {
			empDao.saveOrUpdateEmployee(emp);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "SUCCESS";
	}
}
