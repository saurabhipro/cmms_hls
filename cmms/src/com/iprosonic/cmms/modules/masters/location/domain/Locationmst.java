package com.iprosonic.cmms.modules.masters.location.domain;


import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Locationmst entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "locationmst", catalog = "wascpi_demo")
public class Locationmst {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	@Column(name = "locationCd", length = 20)
	private String locationCd;
	@Column(name = "locationName", length = 100)
	private String locationName;
	@Column(name = "countryName", length = 100)
	private String countryName;
	@Column(name = "stateName", length = 100)
	private String stateName;
	@Column(name = "cityName", length = 100)
	private String cityName;
	@Column(name = "description")
	private String description;
	@Column(name = "locationStatus", length = 29)
	private String locationStatus;
	
	
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
	public String getLocationName() {
		return locationName;
	}
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLocationStatus() {
		return locationStatus;
	}
	public void setLocationStatus(String locationStatus) {
		this.locationStatus = locationStatus;
	}
	
	
	

}
