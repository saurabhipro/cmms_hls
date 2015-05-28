package com.iprosonic.cmms.modules.job.transactions.job.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "jobtypemaster")

public class JobTypeBean {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long id;
	
	@Column(name = "jobType")
	private String jobType;
	
	@Column(name = "explosiveRequire")
	private String explosiveRequire;
	
	
	@Column(name = "jobCategory")
	private String jobCategory;
	
	public void setId(long id) {
		this.id = id;
	}
	public long getId() {
		return id;
	}
	public void setJobType(String jobType) {
		this.jobType = jobType;
	}
	public String getJobType() {
		return jobType;
	}
	public void setJobCategory(String jobCategory) {
		this.jobCategory = jobCategory;
	}
	public String getJobCategory() {
		return jobCategory;
	}
	public void setExplosiveRequire(String explosiveRequire) {
		this.explosiveRequire = explosiveRequire;
	}
	public String getExplosiveRequire() {
		return explosiveRequire;
	}
	

}
