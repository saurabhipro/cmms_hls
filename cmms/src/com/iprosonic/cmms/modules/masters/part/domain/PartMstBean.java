package com.iprosonic.cmms.modules.masters.part.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "partmst")
public class PartMstBean {

	@Id
	@Column(name = "partCd", unique = true)
	private String partCd;

	@Column(name = "l3CategoryCd")
	private String l3CategoryCd;

	//

	public void setPartCd(String partCd) {
		this.partCd = partCd;
	}

	public String getPartCd() {
		return partCd;
	}

	public void setL3CategoryCd(String l3CategoryCd) {
		this.l3CategoryCd = l3CategoryCd;
	}

	public String getL3CategoryCd() {
		return l3CategoryCd;
	}

}
