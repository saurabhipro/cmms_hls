package com.iprosonic.cmms.modules.job.transactions.job.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.print.DocFlavor.STRING;

@Entity
@Table(name = "jobrun")
public class JobRunBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "runNo", unique = true, nullable = false, length = 100)
	private String runNo;

	@ManyToMany(fetch = FetchType.LAZY, targetEntity = JobServiceBean.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "runNo", referencedColumnName = "runNo")
	private Set<JobServiceBean> jobServiceBeanSet = new HashSet<JobServiceBean>();

	@JoinColumn(name = "rigNo")
	private String rigNo;

	@Column(name = "runStatus")
	private String runStatus;

	@Column(name = "ot")
	private String ot;

	@Column(name = "wt")
	private String wt;

	@Column(name = "jobNo")
	private String jobNo;

	@Column(name = "engi")
	private String engi;

	@Column(name = "crew")
	private String crew;

	@Column(name = "bht")
	private String bht;

	@Column(name = "rih")
	private String rih;

	@Column(name = "pooh")
	private String pooh;

	public String getRunStatus() {
		return runStatus;
	}

	public void setRunStatus(String runStatus) {
		this.runStatus = runStatus;
	}

	public String getEngi() {
		return engi;
	}

	public void setEngi(String engi) {
		this.engi = engi;
	}

	public String getCrew() {
		return crew;
	}

	public void setCrew(String crew) {
		this.crew = crew;
	}

	public String getBht() {
		return bht;
	}

	public void setBht(String bht) {
		this.bht = bht;
	}

	public String getRih() {
		return rih;
	}

	public void setRih(String rih) {
		this.rih = rih;
	}

	public String getPooh() {
		return pooh;
	}

	public void setPooh(String pooh) {
		this.pooh = pooh;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setRunNo(String runNo) {
		this.runNo = runNo;
	}

	public String getRunNo() {
		return runNo;
	}

	public void setRigNo(String rigNo) {
		this.rigNo = rigNo;
	}

	public String getRigNo() {
		return rigNo;
	}

	public void setJobNo(String jobNo) {
		this.jobNo = jobNo;
	}

	public String getJobNo() {
		return jobNo;
	}

	public void setOt(String ot) {
		this.ot = ot;
	}

	public String getOt() {
		return ot;
	}

	public void setWt(String wt) {
		this.wt = wt;
	}

	public String getWt() {
		return wt;
	}

	public void setJobServiceBeanSet(Set<JobServiceBean> jobServiceBeanSet) {
		this.jobServiceBeanSet = jobServiceBeanSet;
	}

	public Set<JobServiceBean> getJobServiceBeanSet() {
		return jobServiceBeanSet;
	}

}
