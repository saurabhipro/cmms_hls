package com.iprosonic.cmms.modules.cpi.masters.assets.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "assetmaster")

public class AssetBean {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	
	private int id;
	
	@Column(name = "regionCd")
	private String regionCd;
    
	@Column(name = "locationCd")
	private String locationCd;
	
	@Column(name = "unitCd")
	private String unitCd;
	
	@Column(name = "clientCd")
	private String clientCd;
    
	@Column(name = "assetType")
	private String assetType;
	
	@Column(name = "assetCd")
	private String assetCd;
	
	@Column(name = "assetSerialNo")
	private String assetSerialNo;
    
	@Column(name = "sectionCd")
	private String sectionCd;
	
	@Column(name = "sectionSerialNo")
	private String sectionSerialNo;
	
	@Column(name = "maintanenceType")
	private String maintanenceType;
	
	@Column(name = "pmSchedule")
	private String pmSchedule;
    
	@Column(name = "pmScheduleUnit")
	private String pmScheduleUnit;

    public String getAssetCd() {
        return assetCd;
    }

    public void setAssetCd(String assetCd) {
        this.assetCd = assetCd;
    }

    public String getAssetSerialNo() {
        return assetSerialNo;
    }

    public void setAssetSerialNo(String assetSerialNo) {
        this.assetSerialNo = assetSerialNo;
    }

    public String getAssetType() {
        return assetType;
    }

    public void setAssetType(String assetType) {
        this.assetType = assetType;
    }

    public String getClientCd() {
        return clientCd;
    }

    public void setClientCd(String clientCd) {
        this.clientCd = clientCd;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocationCd() {
        return locationCd;
    }

    public void setLocationCd(String locationCd) {
        this.locationCd = locationCd;
    }

    public String getMaintanenceType() {
        return maintanenceType;
    }

    public void setMaintanenceType(String maintanenceType) {
        this.maintanenceType = maintanenceType;
    }

    public String getPmSchedule() {
        return pmSchedule;
    }

    public void setPmSchedule(String pmSchedule) {
        this.pmSchedule = pmSchedule;
    }

    public String getPmScheduleUnit() {
        return pmScheduleUnit;
    }

    public void setPmScheduleUnit(String pmScheduleUnit) {
        this.pmScheduleUnit = pmScheduleUnit;
    }

    public String getRegionCd() {
        return regionCd;
    }

    public void setRegionCd(String regionCd) {
        this.regionCd = regionCd;
    }

    public String getSectionCd() {
        return sectionCd;
    }

    public void setSectionCd(String sectionCd) {
        this.sectionCd = sectionCd;
    }

    public String getSectionSerialNo() {
        return sectionSerialNo;
    }

    public void setSectionSerialNo(String sectionSerialNo) {
        this.sectionSerialNo = sectionSerialNo;
    }

    public String getUnitCd() {
        return unitCd;
    }

    public void setUnitCd(String unitCd) {
        this.unitCd = unitCd;
    }
    
}
