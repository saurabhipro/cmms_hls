package com.iprosonic.cmms.modules.job.transactions.job.domain;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "jobservice")
public class JobServiceBean implements Serializable {

	private static final long serialVersionUID = 4834199195444805898L;

	@ManyToMany(fetch = FetchType.EAGER, targetEntity = JobExplBean.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "serviceNo", referencedColumnName = "serviceNo")
	private Set<JobExplBean> jobExplBeanSet = new HashSet<JobExplBean>(0);

	@Id
	@Column(name = "serviceNo", unique = true, nullable = false, length = 100)
	private String serviceNo;
	
	@JoinColumn(name = "runNo")
	private String runNo;

	@Column(name = "jobNo")
	private String jobNo;
	
	
	@Column(name = "serviceStatus")
	private String serviceStatus;

	@Column(name = "jobType")
	private String jobType;

	@Column(name = "serviceType")
	private String serviceType;

	@Column(name = "serviceName")
	private String serviceName;

	@Column(name = "lossTime")
	private String lossTime;

	@Column(name = "serialNo")
	private String serialNo;

	@Column(name = "assetCd")
	private String assetCd;

	@Column(name = "deepestDepth")
	private String deepestDepth;

	@Column(name = "meterageLogged")
	private String meterageLogged;

	@Column(name = "meteragePerforated")
	private String meteragePerforated;

	@Column(name = "chruns")
	private String chruns;

	@Column(name = "chmisRuns")
	private String chmisRuns;

	@Column(name = "spf")
	private String spf;

	@Column(name = "coresCount")
	private String coresCount;

	@Column(name = "surfacePressure")
	private String surfacePressure;

	@Column(name = "levelCount")
	private String levelCount;

	@Column(name = "pretestCount")
	private String pretestCount;

	@Column(name = "dryTestCount")
	private String dryTestCount;

	@Column(name = "pumpOutTime")
	private String pumpOutTime;

	@Column(name = "pvtSample")
	private String pvtSample;

	@Column(name = "normalSample")
	private String normalSample;

	@Column(name = "rev")
	private String rev;

	@Column(name = "remarks")
	private String remarks;

	@Column(name = "failureGroup")
	private String failureGroup;

	@Column(name = "gunSize")
	private String gunSize;

	@Column(name = "logSendFromBase")
	private String logSendFromBase;

	@Column(name = "logRcieveAtBase")
	private String logRcieveAtBase;

	@Column(name = "logRcieveAtHo")
	private String logRcieveAtHo;

	@Column(name = "lqaDoneDate")
	private String lqaDoneDate;

	@Column(name = "lqaTechnical")
	private String lqaTechnical;

	@Column(name = "lqaPresentation")
	private String lqaPresentation;

	@Column(name = "snpSnd")
	private String snpSnd;
	
	@Column(name = "engi")
	private String engi;

	@Column(name = "crew")
	private String crew;

	@Column(name="tcpmissrun")
	private String tcpmissrun;
	
	
	

	public String getTcpmissrun() {
		return tcpmissrun;
	}

	public void setTcpmissrun(String tcpmissrun) {
		this.tcpmissrun = tcpmissrun;
	}

	public String getCrew() {
		return crew;
	}

	public void setCrew(String crew) {
		this.crew = crew;
	}

	public String getEngi() {
		return engi;
	}

	public void setEngi(String engi) {
		this.engi = engi;
	}

	public void setServiceStatus(String serviceStatus) {
		this.serviceStatus = serviceStatus;
	}

	public String getServiceStatus() {
		return serviceStatus;
	}

	public void setJobType(String jobType) {
		this.jobType = jobType;
	}

	public String getJobType() {
		return jobType;
	}

	public void setLossTime(String lossTime) {
		this.lossTime = lossTime;
	}

	public String getLossTime() {
		return lossTime;
	}

	public void setAssetCd(String assetCd) {
		this.assetCd = assetCd;
	}

	public String getAssetCd() {
		return assetCd;
	}

	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}

	public String getSerialNo() {
		return serialNo;
	}

	public void setDeepestDepth(String deepestDepth) {
		this.deepestDepth = deepestDepth;
	}

	public String getDeepestDepth() {
		return deepestDepth;
	}

	public void setRev(String rev) {
		this.rev = rev;
	}

	public String getRev() {
		return rev;
	}

	public void setChruns(String chruns) {
		this.chruns = chruns;
	}

	public String getChruns() {
		return chruns;
	}

	public void setChmisRuns(String chmisRuns) {
		this.chmisRuns = chmisRuns;
	}

	public String getChmisRuns() {
		return chmisRuns;
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

	public void setRunNo(String runNo) {
		this.runNo = runNo;
	}

	public String getRunNo() {
		return runNo;
	}

	public void setServiceNo(String serviceNo) {
		this.serviceNo = serviceNo;
	}

	public String getServiceNo() {
		return serviceNo;
	}

	public void setJobNo(String jobNo) {
		this.jobNo = jobNo;
	}

	public String getJobNo() {
		return jobNo;
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

	public void setLogRcieveAtBase(String logRcieveAtBase) {
		this.logRcieveAtBase = logRcieveAtBase;
	}

	public String getLogRcieveAtBase() {
		return logRcieveAtBase;
	}

	public void setLogRcieveAtHo(String logRcieveAtHo) {
		this.logRcieveAtHo = logRcieveAtHo;
	}

	public String getLogRcieveAtHo() {
		return logRcieveAtHo;
	}

	public void setLqaDoneDate(String lqaDoneDate) {
		this.lqaDoneDate = lqaDoneDate;
	}

	public String getLqaDoneDate() {
		return lqaDoneDate;
	}

	public void setLqaTechnical(String lqaTechnical) {
		this.lqaTechnical = lqaTechnical;
	}

	public String getLqaTechnical() {
		return lqaTechnical;
	}

	public void setLqaPresentation(String lqaPresentation) {
		this.lqaPresentation = lqaPresentation;
	}

	public String getLqaPresentation() {
		return lqaPresentation;
	}

	public void setMeterageLogged(String meterageLogged) {
		this.meterageLogged = meterageLogged;
	}

	public String getMeterageLogged() {
		return meterageLogged;
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

	public void setLogSendFromBase(String logSendFromBase) {
		this.logSendFromBase = logSendFromBase;
	}

	public String getLogSendFromBase() {
		return logSendFromBase;
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

	public void setJobExplBeanSet(Set<JobExplBean> jobExplBeanSet) {
		this.jobExplBeanSet = jobExplBeanSet;
	}

	public Set<JobExplBean> getJobExplBeanSet() {
		return jobExplBeanSet;
	}

	
	
	
	
}
