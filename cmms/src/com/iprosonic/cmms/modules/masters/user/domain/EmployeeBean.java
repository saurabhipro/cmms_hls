package com.iprosonic.cmms.modules.masters.user.domain;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employeemaster")
public class EmployeeBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@Column(name = "employeeCd")
	private String employeeCd;
	
	@Column(name = "employeeShortName")
	private String employeeShortName;

	@Column(name = "password")
	private String password;

	@Column(name = "employeeName")
	private String employeeName;

	@Column(name = "departmentName")
	private String departmentName;

	@Column(name = "designation")
	private String designation;

	@Column(name = "locationCd")
	private String locationCd;

	@Column(name = "mobileNo")
	private String mobileNo;

	@Column(name = "emailId")
	private String emailId;

	@Column(name = "maintainenceType")
	private String maintainenceType;


	@Column(name = "roleCd")
	private String roleCd;

	@Column(name = "status")
	private String status;

	@Column(name = "module1")
	private String module1;

	@Column(name = "module2")
	private String module2;

	@Column(name = "module3")
	private String module3;

	@Column(name = "module4")
	private String module4;

	public EmployeeBean() {

	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmployeeCd() {
		return this.employeeCd;
	}

	public void setEmployeeCd(String employeeCd) {
		this.employeeCd = employeeCd;
	}

	public String getEmployeeName() {
		return this.employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getDepartmentName() {
		return this.departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getDesignation() {
		return this.designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getLocationCd() {
		return this.locationCd;
	}

	public void setLocationCd(String locationCd) {
		this.locationCd = locationCd;
	}

	public String getMobileNo() {
		return this.mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmailId() {
		return this.emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getMaintainenceType() {
		return this.maintainenceType;
	}

	public void setMaintainenceType(String maintainenceType) {
		this.maintainenceType = maintainenceType;
	}


	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setRoleCd(String roleCd) {
		this.roleCd = roleCd;
	}

	public String getRoleCd() {
		return roleCd;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public void setModule1(String module1) {
		this.module1 = module1;
	}

	public String getModule1() {
		return module1;
	}

	public void setModule2(String module2) {
		this.module2 = module2;
	}

	public String getModule2() {
		return module2;
	}

	public void setModule3(String module3) {
		this.module3 = module3;
	}

	public String getModule3() {
		return module3;
	}

	public void setModule4(String module4) {
		this.module4 = module4;
	}

	public String getModule4() {
		return module4;
	}

	public void setEmployeeShortName(String employeeShortName) {
		this.employeeShortName = employeeShortName;
	}

	public String getEmployeeShortName() {
		return employeeShortName;
	}


}
