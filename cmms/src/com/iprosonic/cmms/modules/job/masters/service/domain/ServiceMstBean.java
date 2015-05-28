package com.iprosonic.cmms.modules.job.masters.service.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "servicemaster")

public class ServiceMstBean {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	
	private int id;
	
	@Column(name = "serviceType")
	private String serviceType;
    
	@Column(name = "serviceName")
	private String serviceName;
	
	@Column(name = "exp")
	private String exp;
	
	@Column(name = "deepestDepth")
	private String deepestDepth;
	
	@Column(name = "meterageLogged")
	private String  meterageLogged;
	
	@Column(name="chRuns")
	private String  chRuns;
	
	@Column(name="chMisRuns")
	private String  chMisRuns;
		
	@Column(name="meteragePerforated")
	private String meteragePerforated;
	
	@Column(name="spf")
	private String spf;
	
	@Column(name="coresCount")
	private String coresCount;
	
	@Column(name="surfacePressure")
	private String surfacePressure;
	
	@Column(name="levelCount")
	private String levelCount;
	
	
	@Column(name="pretestCount")
	private String pretestCount;
	
	@Column(name="dryTestCount")
	private String dryTestCount;
	
	
	@Column(name="pumpOutTime")
	private String pumpOutTime;
	
	@Column(name="pvtSample")
	private String pvtSample;
	
	@Column(name="normalSample")
	private String normalSample;
	
	@Column(name="revenue")
	private String revenue;
	
	@Column(name="remarks")
	private String remarks;
	
	@Column(name="failureGroup")
	private String failureGroup;

	@Column(name="gunSize")
	private String gunSize;
	
	@Column(name="logSentFromBase")
	private String logSentFromBase;
	
	@Column(name="logRecievedAtHo")
	private String logRecievedAtHo;
	
	@Column(name="lqaDoneDate")
	private String lqaDoneDate;
	
	@Column(name="lqaTpoints")
	private String lqaTpoints;
	
	@Column(name="lqaPpoints")
	private String lqaPpoints;

	
	@Column(name="snpSnd")
	private String snpSnd;

	
	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public String getServiceType() {
		return serviceType;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setExp(String exp) {
		this.exp = exp;
	}

	public String getExp() {
		return exp;
	}

	public void setDeepestDepth(String deepestDepth) {
		this.deepestDepth = deepestDepth;
	}

	public String getDeepestDepth() {
		return deepestDepth;
	}

	public void setMeterageLogged(String meterageLogged) {
		this.meterageLogged = meterageLogged;
	}

	public String getMeterageLogged() {
		return meterageLogged;
	}

	public void setChRuns(String chRuns) {
		this.chRuns = chRuns;
	}

	public String getChRuns() {
		return chRuns;
	}

	public void setChMisRuns(String chMisRuns) {
		this.chMisRuns = chMisRuns;
	}

	public String getChMisRuns() {
		return chMisRuns;
	}

	public void setMeteragePerforated(String meteragePerforated) {
		this.meteragePerforated = meteragePerforated;
	}

	public String getMeteragePerforated() {
		return meteragePerforated;
	}

	public void setSpf(String spf) {
		this.spf = spf;
	}

	public String getSpf() {
		return spf;
	}

	public void setCoresCount(String coresCount) {
		this.coresCount = coresCount;
	}

	public String getCoresCount() {
		return coresCount;
	}

	public void setSurfacePressure(String surfacePressure) {
		this.surfacePressure = surfacePressure;
	}

	public String getSurfacePressure() {
		return surfacePressure;
	}

	public void setLevelCount(String levelCount) {
		this.levelCount = levelCount;
	}

	public String getLevelCount() {
		return levelCount;
	}

	public void setPretestCount(String pretestCount) {
		this.pretestCount = pretestCount;
	}

	public String getPretestCount() {
		return pretestCount;
	}

	public void setDryTestCount(String dryTestCount) {
		this.dryTestCount = dryTestCount;
	}

	public String getDryTestCount() {
		return dryTestCount;
	}

	public void setPumpOutTime(String pumpOutTime) {
		this.pumpOutTime = pumpOutTime;
	}

	public String getPumpOutTime() {
		return pumpOutTime;
	}

	public void setPvtSample(String pvtSample) {
		this.pvtSample = pvtSample;
	}

	public String getPvtSample() {
		return pvtSample;
	}

	public void setNormalSample(String normalSample) {
		this.normalSample = normalSample;
	}

	public String getNormalSample() {
		return normalSample;
	}

	public void setRevenue(String revenue) {
		this.revenue = revenue;
	}

	public String getRevenue() {
		return revenue;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setFailureGroup(String failureGroup) {
		this.failureGroup = failureGroup;
	}

	public String getFailureGroup() {
		return failureGroup;
	}

	public void setLogSentFromBase(String logSentFromBase) {
		this.logSentFromBase = logSentFromBase;
	}

	public String getLogSentFromBase() {
		return logSentFromBase;
	}

	public void setLogRecievedAtHo(String logRecievedAtHo) {
		this.logRecievedAtHo = logRecievedAtHo;
	}

	public String getLogRecievedAtHo() {
		return logRecievedAtHo;
	}

	public void setLqaDoneDate(String lqaDoneDate) {
		this.lqaDoneDate = lqaDoneDate;
	}

	public String getLqaDoneDate() {
		return lqaDoneDate;
	}

	public void setLqaTpoints(String lqaTpoints) {
		this.lqaTpoints = lqaTpoints;
	}

	public String getLqaTpoints() {
		return lqaTpoints;
	}

	public void setLqaPpoints(String lqaPpoints) {
		this.lqaPpoints = lqaPpoints;
	}

	public String getLqaPpoints() {
		return lqaPpoints;
	}

	public void setGunSize(String gunSize) {
		this.gunSize = gunSize;
	}

	public String getGunSize() {
		return gunSize;
	}

	public void setSnpSnd(String snpSnd) {
		this.snpSnd = snpSnd;
	}

	public String getSnpSnd() {
		return snpSnd;
	}
	
	
    
    }
