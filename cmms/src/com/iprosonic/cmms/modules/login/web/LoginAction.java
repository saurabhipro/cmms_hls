package com.iprosonic.cmms.modules.login.web;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.iprosonic.cmms.modules.login.service.LoginService;
import com.iprosonic.cmms.modules.masters.location.domain.Locationmst;
import com.iprosonic.cmms.modules.masters.user.domain.EmployeeBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
	private static final Logger	logger				= Logger.getLogger(LoginAction.class);
	private static final long	serialVersionUID	= 1L;
	private static final String	SUCCESS				= "success";
	private static final String	ERROR				= "error";
	private Map<String, Object>	session;
	private List<Locationmst>	locationMstList		= null;
	private EmployeeBean		employeeBean		= new EmployeeBean();
	LoginService				loginService		= new LoginService();

	private String				employeeCd;
	private String				password;
	private String				locationCd;
	private String				role;

	public List<Locationmst> getLocationMstList() {
		return locationMstList;
	}

	public void setLocationMstList(List<Locationmst> locationMstList) {
		this.locationMstList = locationMstList;
	}

	@Override
	public void validate() {

		try {

			if (locationCd != null || employeeCd != null) {

				if (locationCd.equalsIgnoreCase("-Select-") || locationCd.equals("")) {
					addFieldError("locationCd", "select location code");
				}
				if (!employeeCd.equalsIgnoreCase("")) {
					if (loginService.getValidLoginUser(employeeCd, password) == false) {
						addFieldError("employeeCd", "UserId and password is Wrong");
					}

				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public String execute() {

		try {

			if (loginService.getValidLoginUser(employeeCd, password) == true) {
				session = ActionContext.getContext().getSession();
				session.put("loginid", employeeCd);
				session.put("roleCd", loginService.getRoleCd(employeeCd));
				EmployeeBean emp = loginService.getEmployeeByCode(employeeCd);
				Map<String, String> session = (Map) ActionContext.getContext().get("session");
				session.put("module1", emp.getModule1());
				session.put("module2", emp.getModule2());
				session.put("module3", emp.getModule3());
				session.put("module4", emp.getModule4());
				session.put("role", emp.getRoleCd());
				session.put("employeeName", emp.getEmployeeName());
				session.put("locationCd", locationCd);
				return SUCCESS;
			} else {
				return SUCCESS;

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return NONE;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public Map<String, Object> setSession() {
		return session;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPassword() {
		return this.password;
	}

	public String getRole() {
		return this.role;
	}

	public void setEmployeeBean(EmployeeBean employeeBean) {
		this.employeeBean = employeeBean;
	}

	public EmployeeBean getEmployeeBean() {
		return employeeBean;
	}

	public void setEmployeeCd(String employeeCd) {
		this.employeeCd = employeeCd;
	}

	public String getEmployeeCd() {
		return employeeCd;
	}

	public void setLocationCd(String locationCd) {
		this.locationCd = locationCd;
	}

	public String getLocationCd() {
		return locationCd;
	}

}
