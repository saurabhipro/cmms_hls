package com.iprosonic.cmms.modules.cpi.transactions.cpi.service;
import com.iprosonic.cmms.modules.masters.user.dao.EmployeeDaoImpl;
import com.iprosonic.cmms.modules.masters.user.domain.EmployeeBean;
public class SaveOrUpdateCPIService {
	private EmployeeDaoImpl userDAO = new EmployeeDaoImpl();
	public String saveOrUpdate(EmployeeBean user) {
		try {
			userDAO.saveOrUpdateEmployee(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "SUCCESS";
	}
}
