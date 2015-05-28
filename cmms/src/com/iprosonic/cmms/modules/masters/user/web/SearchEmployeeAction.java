package com.iprosonic.cmms.modules.masters.user.web;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.iprosonic.cmms.modules.masters.user.dao.EmployeeDaoImpl;
import com.iprosonic.cmms.modules.masters.user.domain.EmployeeBean;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class SearchEmployeeAction extends ActionSupport implements
		ModelDriven<EmployeeBean> {

	private static final long serialVersionUID = 1L;
	private Map<String, String> accordion;
	private EmployeeBean employeeBean = new EmployeeBean();
	private List<EmployeeBean> employeeList = new ArrayList<EmployeeBean>();
	private EmployeeDaoImpl employeeDao = new EmployeeDaoImpl();

	public String execute() {

		HttpServletRequest httpServletRequest = ServletActionContext
				.getRequest();
		String cd = httpServletRequest.getParameter("employeeCd");
		String name = httpServletRequest.getParameter("employeeName");
		setEmployeeList(employeeDao.listUser(cd, name));

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

	@Override
	public EmployeeBean getModel() {
		return getEmployeeBean();

	}
}
