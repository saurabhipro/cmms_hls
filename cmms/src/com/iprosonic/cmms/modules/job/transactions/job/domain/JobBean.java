package com.iprosonic.cmms.modules.job.transactions.job.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "job", uniqueConstraints = { @UniqueConstraint(columnNames = "jobNo") })
public class JobBean implements Serializable 
{
	private static final long serialVersionUID = -8767337896773261247L;
	
	@Id
	@Column(name = "jobNo", unique = true, nullable = false)
	private String jobNo;

	@OneToOne(mappedBy = "jobBean", cascade = CascadeType.ALL)
	private JobWellBean jobWellBean;

	@ManyToMany(fetch = FetchType.LAZY, targetEntity = JobRigBean.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "jobNo", referencedColumnName = "jobNo")
	private Set<JobRigBean> jobRigBean = new HashSet<JobRigBean>();


	@Column(name = "jobNoHlsa")
	private String jobNoHlsa;

	@Column(name = "unitNo")
	private String unitNo;

	@Column(name = "engineer")
	private String engineer;

	@Column(name = "jobDate")
	private String jobDate;

	@Column(name = "jobStatus")
	private String jobStatus;

	@Column(name = "crew")
	private String crew;

	@Column(name = "wellNo")
	private String wellNo;

	@Column(name = "clientName")
	private String clientName;

	@Column(name = "unitLeftBase")
	private String unitLeftBase;

	

	@Column(name = "unitReachedBase")
	private String unitReachedBase;

	@Column(name = "unitReachedSite")
	private String unitReachedSite;

	@Column(name = "unitLeftSite")
	private String unitLeftSite;

	@Column(name = "truckMileage")
	private String truckMileage;

	@Column(name = "vanMileage")
	private String vanMileage;

	@Column(name = "lostTime")
	private String lostTime;

	@Column(name = "ejcs1")
	private String ejcs1;

	@Column(name = "ejcs2")
	private String ejcs2;
	
	@Column(name = "ejcs3")
	private String ejcs3;

	@Column(name = "ejcs4")
	private String ejcs4;

	@Column(name = "ejcs5")
	private String ejcs5;


	
	@Column(name = "safetyMeet")
	private String safetyMeet;

	@Column(name = "remarks",length=5000)
	private String remarks;
 
	
	
	
	
 
	public void setEngineer(String engineer) {
		this.engineer = engineer;
	}

	public String getEngineer() {
		return engineer;
	}

	public void setCrew(String crew) {
		this.crew = crew;
	}

	public String getCrew() {
		return crew;
	}

	public void setWellNo(String wellNo) {
		this.wellNo = wellNo;
	}

	public String getWellNo() {
		return wellNo;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getClientName() {
		return clientName;
	}

	 

	public void setUnitReachedSite(String unitReachedSite) {
		this.unitReachedSite = unitReachedSite;
	}

	public String getUnitReachedSite() {
		return unitReachedSite;
	}

	public void setUnitLeftSite(String unitLeftSite) {
		this.unitLeftSite = unitLeftSite;
	}

	public String getUnitLeftSite() {
		return unitLeftSite;
	}

	public void setTruckMileage(String truckMileage) {
		this.truckMileage = truckMileage;
	}

	public String getTruckMileage() {
		return truckMileage;
	}

	public void setVanMileage(String vanMileage) {
		this.vanMileage = vanMileage;
	}

	public String getVanMileage() {
		return vanMileage;
	}

	public void setLostTime(String lostTime) {
		this.lostTime = lostTime;
	}

	public String getLostTime() {
		return lostTime;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setUnitNo(String unitNo) {
		this.unitNo = unitNo;
	}

	public String getUnitNo() {
		return unitNo;
	}

	public void setUnitLeftBase(String unitLeftBase) {
		this.unitLeftBase = unitLeftBase;
	}

	public String getUnitLeftBase() {
		return unitLeftBase;
	}

	public void setUnitReachedBase(String unitReachedBase) {
		this.unitReachedBase = unitReachedBase;
	}

	public String getUnitReachedBase() {
		return unitReachedBase;
	}

	public void setJobWellBean(JobWellBean jobWellBean) {
		this.jobWellBean = jobWellBean;
	}

	public JobWellBean getJobWellBean() {
		return jobWellBean;
	}

	public void setJobRigBean(Set<JobRigBean> jobRigBean) {
		this.jobRigBean = jobRigBean;
	}

	public Set<JobRigBean> getJobRigBean() {
		return jobRigBean;
	}

	public void setSafetyMeet(String safetyMeet) {
		this.safetyMeet = safetyMeet;
	}

	public String getSafetyMeet() {
		return safetyMeet;
	}

	public void setJobDate(String jobDate) {
		this.jobDate = jobDate;
	}

	public String getJobDate() {
		return jobDate;
	}

	public void setJobStatus(String jobStatus) {
		this.jobStatus = jobStatus;
	}

	public String getJobStatus() {
		return jobStatus;
	}


	

	public String getEjcs1() {
		return ejcs1;
	}

	public void setEjcs1(String ejcs1) {
		this.ejcs1 = ejcs1;
	}

	public String getEjcs2() {
		return ejcs2;
	}

	public void setEjcs2(String ejcs2) {
		this.ejcs2 = ejcs2;
	}

	public String getEjcs3() {
		return ejcs3;
	}

	public void setEjcs3(String ejcs3) {
		this.ejcs3 = ejcs3;
	}

	public String getEjcs4() {
		return ejcs4;
	}

	public void setEjcs4(String ejcs4) {
		this.ejcs4 = ejcs4;
	}

	public String getEjcs5() {
		return ejcs5;
	}

	public void setEjcs5(String ejcs5) {
		this.ejcs5 = ejcs5;
	}

	public void setJobNoHlsa(String jobNoHlsa) {
		this.jobNoHlsa = jobNoHlsa;
	}

	public String getJobNoHlsa() {
		return jobNoHlsa;
	}

	public void setJobNo(String jobNo) {
		this.jobNo = jobNo;
	}

	public String getJobNo() {
		return jobNo;
	}

	
}
