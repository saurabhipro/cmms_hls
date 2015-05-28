package com.iprosonic.cmms.modules.job.transactions.job.domain;


import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "jobexpl")
public class JobExplBean implements Serializable {

	private static final long serialVersionUID = 1L;


	@JoinColumn(name = "serviceNo")
	private String serviceNo;
	
	@Id
	@Column(name = "explNo", unique = true, nullable = false, length = 100)
	private String explNo;
	
	@Column(name = "jobNo")
	private String jobNo;
	
	@Column(name = "explStatus")
	private String explStatus;

	@Column(name = "partCd")
	private String partCd;
	
	@Column(name = "qty")
	private String qty;

	@Column(name = "uom")
	private String uom;

	

	public void setExplStatus(String explStatus) {
		this.explStatus = explStatus;
	}

	public String getExplStatus() {
		return explStatus;
	}




	public void setUom(String uom) {
		this.uom = uom;
	}

	public String getUom() {
		return uom;
	}

	public void setServiceNo(String serviceNo) {
		this.serviceNo = serviceNo;
	}

	public String getServiceNo() {
		return serviceNo;
	}

	public void setPartCd(String partCd) {
		this.partCd = partCd;
	}

	public String getPartCd() {
		return partCd;
	}

	public void setExplNo(String explNo) {
		this.explNo = explNo;
	}

	public String getExplNo() {
		return explNo;
	}

	public void setJobNo(String jobNo) {
		this.jobNo = jobNo;
	}

	public String getJobNo() {
		return jobNo;
	}

	public void setQty(String qty) {
		this.qty = qty;
	}

	public String getQty() {
		return qty;
	}



}
