package com.iprosonic.cmms.modules.cpi.masters.group.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cpigroupmst")
public class CpiGroupBean {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@Column(name = "groupCd")
	private String groupCd;

	@Column(name = "groupCdName")
	private String groupCdName;
	
	@Column(name = "subGroupCd")
	private String subGroupCd;

	@Column(name = "subGroupName")
	private String subGroupName;

	public String getGroupCd() {
		return groupCd;
	}

	public void setGroupCd(String groupCd) {
		this.groupCd = groupCd;
	}

	public String getGroupCdName() {
		return groupCdName;
	}

	public void setGroupCdName(String groupCdName) {
		this.groupCdName = groupCdName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSubGroupCd() {
		return subGroupCd;
	}

	public void setSubGroupCd(String subGroupCd) {
		this.subGroupCd = subGroupCd;
	}

	public String getSubGroupName() {
		return subGroupName;
	}

	public void setSubGroupName(String subGroupName) {
		this.subGroupName = subGroupName;
	}
}
