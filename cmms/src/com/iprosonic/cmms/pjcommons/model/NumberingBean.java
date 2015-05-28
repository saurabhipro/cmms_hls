package com.iprosonic.cmms.pjcommons.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "numbering")
public class NumberingBean {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@Column(name = "latestNo")
	private String latestNo;

	@Column(name = "codeType")
	private String codeType;

	@Column(name = "unitCd")
	private String unitCd;

	
	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setLatestNo(String latestNo) {
		this.latestNo = latestNo;
	}

	public String getLatestNo() {
		return latestNo;
	}

	public void setCodeType(String codeType) {
		this.codeType = codeType;
	}

	public String getCodeType() {
		return codeType;
	}

	public void setUnitCd(String unitCd) {
		this.unitCd = unitCd;
	}

	public String getUnitCd() {
		return unitCd;
	}

}
