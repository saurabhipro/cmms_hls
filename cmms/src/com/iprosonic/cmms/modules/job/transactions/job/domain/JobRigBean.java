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

@Entity
@Table(name = "jobrig")
public class JobRigBean implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "rigNo", unique = true, nullable = false, length = 100)
	private String rigNo;

	
	@ManyToMany(fetch = FetchType.LAZY, targetEntity = JobRunBean.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "rigNo", referencedColumnName = "rigNo")
	private Set<JobRunBean> jobRunBeanSet = new HashSet<JobRunBean>();
	
	
	@JoinColumn(name = "jobNo",nullable=false)
	private String jobNo;

	@Column(name = "rigUpStart")
	private String rigUpStart;

	@Column(name = "rigUpEnd")
	private String rigUpEnd;
	
	@Column(name = "rigDownStart")
	private String rigDownStart;

	@Column(name = "rigDownEnd")
	private String rigDownEnd;
	
	
	@Column(name = "opTime")
	private String opTime;


		public void setOpTime(String opTime) {
		this.opTime = opTime;
	}

	public String getOpTime() {
		return opTime;
	}

	public void setJobNo(String jobNo) {
		this.jobNo = jobNo;
	}

	public String getJobNo() {
		return jobNo;
	}

	public void setRigNo(String rigNo) {
		this.rigNo = rigNo;
	}

	public String getRigNo() {
		return rigNo;
	}

	public void setJobRunBeanSet(Set<JobRunBean> jobRunBeanSet) {
		this.jobRunBeanSet = jobRunBeanSet;
	}

	public Set<JobRunBean> getJobRunBeanSet() {
		return jobRunBeanSet;
	}

	public void setRigUpStart(String rigUpStart) {
		this.rigUpStart = rigUpStart;
	}

	public String getRigUpStart() {
		return rigUpStart;
	}

	public void setRigUpEnd(String rigUpEnd) {
		this.rigUpEnd = rigUpEnd;
	}

	public String getRigUpEnd() {
		return rigUpEnd;
	}

	public void setRigDownStart(String rigDownStart) {
		this.rigDownStart = rigDownStart;
	}

	public String getRigDownStart() {
		return rigDownStart;
	}

	public void setRigDownEnd(String rigDownEnd) {
		this.rigDownEnd = rigDownEnd;
	}

	public String getRigDownEnd() {
		return rigDownEnd;
	}

	


}
