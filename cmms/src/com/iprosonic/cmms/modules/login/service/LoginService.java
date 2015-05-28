package com.iprosonic.cmms.modules.login.service;

import java.util.Iterator;

import com.iprosonic.cmms.modules.masters.user.dao.EmployeeDaoImpl;
import com.iprosonic.cmms.modules.masters.user.domain.EmployeeBean;

public class LoginService {
	public boolean getValidLoginUser(String employeeCd, String pwd
			) {
		EmployeeDaoImpl empDao = new EmployeeDaoImpl();
		boolean result = false;
		Iterator userIterator = empDao.listUser().iterator();
		while (userIterator.hasNext()) {
			EmployeeBean emp = (EmployeeBean) userIterator.next();
			if (emp.getEmployeeCd().equalsIgnoreCase(employeeCd)
					&& emp.getPassword().equals(pwd)
					) {

				result = true;
				break;
			}
		}
		return result;
	}

	public EmployeeBean getEmployeeByCode(String cd) {
		EmployeeDaoImpl empDao = new EmployeeDaoImpl();
		return empDao.getEmployeeByCd(cd);
	}

	public String getRoleCd(String loginId) {
		EmployeeDaoImpl empDao = new EmployeeDaoImpl();
		return empDao.getRoleCd(loginId);
	}

}
