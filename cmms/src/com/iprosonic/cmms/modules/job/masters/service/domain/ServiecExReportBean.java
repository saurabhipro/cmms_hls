package com.iprosonic.cmms.modules.job.masters.service.domain;

import java.util.Set;

import com.iprosonic.cmms.modules.job.transactions.job.domain.JobExplBean;
import com.iprosonic.cmms.modules.job.transactions.job.domain.JobServiceBean;

 


public class ServiecExReportBean {
	
	private String jobNo;
	private Set<JobExplBean> jobExplNos;
	private Set<JobServiceBean> jobServiceNos;
	
	
	
	public String getJobNo() {
		return jobNo;
	}
	public void setJobNo(String jobNo) {
		this.jobNo = jobNo;
	}
	public Set<JobServiceBean> getJobServiceNos() {
		return jobServiceNos;
	}
	public void setJobServiceNos(Set<JobServiceBean> jobServiceNos) {
		this.jobServiceNos = jobServiceNos;
	}
	public Set<JobExplBean> getJobExplNos() {
		return jobExplNos;
	}
	public void setJobExplNos(Set<JobExplBean> jobExplNos) {
		this.jobExplNos = jobExplNos;
	}
	
    
	
   }
