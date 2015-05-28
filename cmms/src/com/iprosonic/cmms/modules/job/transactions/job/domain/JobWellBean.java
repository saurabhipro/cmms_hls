package com.iprosonic.cmms.modules.job.transactions.job.domain;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "jobswell")
public class JobWellBean implements Serializable{
 

	/**
	 * 
	 */
	private static final long serialVersionUID = 8388314243817471040L;

	@Id
	@Column(name = "jobNo")
	private String jobNo;

	@OneToOne
	@PrimaryKeyJoinColumn
	private JobBean jobBean;

	@Column(name = "holeSize")
	private String holeSize;

	@Column(name = "field")
	private String field;

	@Column(name = "latitude_d")
	private String latitude_d;

	@Column(name = "latitude_m")
	private String latitude_m;

	@Column(name = "latitude_s")
	private String latitude_s;

	
	@Column(name = "longitude_d")
	private String longitude_d;
	
	@Column(name = "longitude_m")
	private String longitude_m;
	
	@Column(name = "longitude_s")
	private String longitude_s;
	

	@Column(name = "kb")
	private String kb;

	@Column(name = "dl")
	private String dl;

	@Column(name = "td")
	private String td;
	
	@Column(name = "casingSize")
	private String casingSize;

	@Column(name = "casingSizeDepth")
	private String casingSizeDepth;

	@Column(name = "rigName")
	private String rigName;

	@Column(name = "tdDriller")
	private String tdDriller;

	@Column(name = "csDriller")
	private String csDriller;

	@Column(name = "weekPoint")
	private String weekPoint;

	@Column(name = "bitSize")
	private String bitSize;

	@Column(name = "deviation")
	private String deviation;

	@Column(name = "startCirculation")
	private String startCirculation;

	@Column(name = "stopCirculation")
	private String stopCirculation;

	@Column(name = "gf")
	private String gf;


	@Column(name = "density")
	private String density;

	@Column(name = "viscosity")
	private String viscosity;

	@Column(name = "ph")
	private String ph;

	@Column(name = "salinity")
	private String salinity;

	@Column(name = "barities")
	private String barities;

	@Column(name = "rmValue")
	private String rmValue;

	@Column(name = "rmTemp")
	private String rmTemp;

	@Column(name = "rmf")
	private String rmf;

	@Column(name = "rmc")
	private String rmc;

	@Column(name = "solid")
	private String solid;

	public void setHoleSize(String holeSize) {
		this.holeSize = holeSize;
	}

	public String getHoleSize() {
		return holeSize;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getField() {
		return field;
	}


	
	public void setKb(String kb) {
		this.kb = kb;
	}

	public String getKb() {
		return kb;
	}

	public void setDl(String dl) {
		this.dl = dl;
	}

	public String getDl() {
		return dl;
	}

	public void setTd(String td) {
		this.td = td;
	}

	public String getTd() {
		return td;
	}

	public void setCasingSize(String casingSize) {
		this.casingSize = casingSize;
	}

	public String getCasingSize() {
		return casingSize;
	}

	public void setCasingSizeDepth(String casingSizeDepth) {
		this.casingSizeDepth = casingSizeDepth;
	}

	public String getCasingSizeDepth() {
		return casingSizeDepth;
	}

	public void setRigName(String rigName) {
		this.rigName = rigName;
	}

	public String getRigName() {
		return rigName;
	}

	public void setTdDriller(String tdDriller) {
		this.tdDriller = tdDriller;
	}

	public String getTdDriller() {
		return tdDriller;
	}

	public void setCsDriller(String csDriller) {
		this.csDriller = csDriller;
	}

	public String getCsDriller() {
		return csDriller;
	}

	public void setWeekPoint(String weekPoint) {
		this.weekPoint = weekPoint;
	}

	public String getWeekPoint() {
		return weekPoint;
	}

	public void setBitSize(String bitSize) {
		this.bitSize = bitSize;
	}

	public String getBitSize() {
		return bitSize;
	}

	public void setDeviation(String deviation) {
		this.deviation = deviation;
	}

	public String getDeviation() {
		return deviation;
	}

	public void setStartCirculation(String startCirculation) {
		this.startCirculation = startCirculation;
	}

	public String getStartCirculation() {
		return startCirculation;
	}

	
	public void setGf(String gf) {
		this.gf = gf;
	}

	public String getGf() {
		return gf;
	}


	public void setDensity(String density) {
		this.density = density;
	}

	public String getDensity() {
		return density;
	}

	public void setViscosity(String viscosity) {
		this.viscosity = viscosity;
	}

	public String getViscosity() {
		return viscosity;
	}

	public void setPh(String ph) {
		this.ph = ph;
	}

	public String getPh() {
		return ph;
	}

	public void setSalinity(String salinity) {
		this.salinity = salinity;
	}

	public String getSalinity() {
		return salinity;
	}

	public void setBarities(String barities) {
		this.barities = barities;
	}

	public String getBarities() {
		return barities;
	}

	public void setRmValue(String rmValue) {
		this.rmValue = rmValue;
	}

	public String getRmValue() {
		return rmValue;
	}

	public void setRmTemp(String rmTemp) {
		this.rmTemp = rmTemp;
	}

	public String getRmTemp() {
		return rmTemp;
	}

	public void setRmf(String rmf) {
		this.rmf = rmf;
	}

	public String getRmf() {
		return rmf;
	}

	public void setRmc(String rmc) {
		this.rmc = rmc;
	}

	public String getRmc() {
		return rmc;
	}

	public void setSolid(String solid) {
		this.solid = solid;
	}

	public String getSolid() {
		return solid;
	}

	public void setJobNo(String jobNo) {
		this.jobNo = jobNo;
	}

	public String getJobNo() {
		return jobNo;
	}

	public void setJobBean(JobBean jobBean) {
		this.jobBean = jobBean;
	}

	public JobBean getJobBean() {
		return jobBean;
	}

	public void setStopCirculation(String stopCirculation) {
		this.stopCirculation = stopCirculation;
	}

	public String getStopCirculation() {
		return stopCirculation;
	}

	public String getLatitude_d() {
		return latitude_d;
	}

	public void setLatitude_d(String latitude_d) {
		this.latitude_d = latitude_d;
	}

	public String getLatitude_m() {
		return latitude_m;
	}

	public void setLatitude_m(String latitude_m) {
		this.latitude_m = latitude_m;
	}

	public String getLatitude_s() {
		return latitude_s;
	}

	public void setLatitude_s(String latitude_s) {
		this.latitude_s = latitude_s;
	}

	public String getLongitude_d() {
		return longitude_d;
	}

	public void setLongitude_d(String longitude_d) {
		this.longitude_d = longitude_d;
	}

	public String getLongitude_m() {
		return longitude_m;
	}

	public void setLongitude_m(String longitude_m) {
		this.longitude_m = longitude_m;
	}

	public String getLongitude_s() {
		return longitude_s;
	}

	public void setLongitude_s(String longitude_s) {
		this.longitude_s = longitude_s;
	}


}
