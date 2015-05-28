package com.iprosonic.cmms.modules.masters.user.web;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.iprosonic.cmms.modules.masters.user.dao.EmployeeDaoImpl;
import com.iprosonic.cmms.modules.masters.user.domain.EmployeeBean;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class DeleteEmployeeAction extends ActionSupport implements
		ModelDriven<EmployeeBean> {
	private static final long serialVersionUID = -6659925652584240539L;
	private EmployeeBean employeeBean = new EmployeeBean();
	private List<EmployeeBean> employeeList = new ArrayList<EmployeeBean>();
	private EmployeeDaoImpl employeeDao = new EmployeeDaoImpl();

	@Override
	public String execute() throws Exception {

		HttpServletRequest request = ServletActionContext.getRequest();
		String id = request.getParameter("id");
		String employeeCd = request.getParameter("employeeCd");
		
		employeeDao.updateEmplyeeStatus(Integer.parseInt(id));
		String message = "Employee code " + employeeCd
				+ " is succefully inactive";
		request.setAttribute("message", message);
		
		return SUCCESS;
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
		// TODO Auto-generated method stub
		return null;
	}

}
