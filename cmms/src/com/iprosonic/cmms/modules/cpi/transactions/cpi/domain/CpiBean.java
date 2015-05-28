package com.iprosonic.cmms.modules.cpi.transactions.cpi.domain;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cpi")
public class CpiBean  implements Serializable{

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name = "id")
	private int id;

	@Column(name = "regionCd")
	private String regionCd;
	
	@Column(name = "updownFlag")
	private String updownFlag;

	
	@Column(name = "locationCd")
	private String locationCd;

	@Column(name = "unitCd")
	private String unitCd;

	@Column(name = "clientCd")
	private String clientCd;

	@Column(name = "originatedBy")
	private String originatedBy;

	@Column(name = "dateOfCpi")
	private String dateOfCpi;

	@Column(name = "updateDate")
	private String updateDate;

	@Column(name = "priority")
	private String priority;

	@Column(name = "cpiType")
	private String cpiType;

	@Column(name = "maintanenceType")
	private String maintanenceType;

	@Column(name = "assetType")
	private String assetType;

	@Column(name = "assetType1")
	private String assetType1;

	@Column(name = "assetType2")
	private String assetType2;

	@Column(name = "assetType3")
	private String assetType3;

	@Column(name = "assetType4")
	private String assetType4;

	@Column(name = "assetType5")
	private String assetType5;

	@Column(name = "assetType6")
	private String assetType6;

	@Column(name = "assetName")
	private String assetName;

	@Column(name = "assetName1")
	private String assetName1;

	@Column(name = "assetName2")
	private String assetName2;

	@Column(name = "assetName3")
	private String assetName3;

	@Column(name = "assetName4")
	private String assetName4;

	@Column(name = "assetName5")
	private String assetName5;

	@Column(name = "assetName6")
	private String assetName6;

	@Column(name = "assetSrNo")
	private String assetSrNo;

	@Column(name = "assetSrNo1")
	private String assetSrNo1;

	@Column(name = "assetSrNo2")
	private String assetSrNo2;

	@Column(name = "assetSrNo3")
	private String assetSrNo3;

	@Column(name = "assetSrNo4")
	private String assetSrNo4;

	@Column(name = "assetSrNo5")
	private String assetSrNo5;

	@Column(name = "assetSrNo6")
	private String assetSrNo6;

	@Column(name = "sectionSerialNo")
	private String sectionSerialNo;

	@Column(name = "sectionSerialNo1")
	private String sectionSerialNo1;

	@Column(name = "sectionSerialNo2")
	private String sectionSerialNo2;

	@Column(name = "sectionSerialNo3")
	private String sectionSerialNo3;

	@Column(name = "sectionSerialNo4")
	private String sectionSerialNo4;

	@Column(name = "sectionSerialNo5")
	private String sectionSerialNo5;

	@Column(name = "sectionSerialNo6")
	private String sectionSerialNo6;

	@Column(name = "sectionName")
	private String sectionName;

	@Column(name = "sectionName1")
	private String sectionName1;

	@Column(name = "sectionName2")
	private String sectionName2;

	@Column(name = "sectionName3")
	private String sectionName3;

	@Column(name = "sectionName4")
	private String sectionName4;

	@Column(name = "sectionName5")
	private String sectionName5;

	@Column(name = "sectionName6")
	private String sectionName6;

	@Column(name = "problem")
	private String problem;
	@Column(name = "depth")
	private String depth;

	@Column(name = "mudType")
	private String mudType;

	@Column(name = "bht")
	private String bht;

	@Column(name = "mudWeight")
	private String mudWeight;

	@Column(name = "pressure")
	private String pressure;

	@Column(name = "holeCondition")
	private String holeCondition;

	@Column(name = "bitSize")
	private String bitSize;

	@Column(name = "deviation")
	private String deviation;

	@Column(name = "cpiStatus")
	private String cpiStatus;

	@Column(name = "cpiProcess")
	private String cpiProcess;

	@Column(name = "whyOpen")
	private String whyOpen;

	@Column(name = "whyOpenOthers")
	private String whyOpenOthers;

	@Column(name = "jobSuccessfullyDone")
	private String jobSuccessfullyDone;

	@Column(name = "cpiCd")
	private String cpiCd;

	@Column(name = "pm2status")
	private String pm2status;

	@Column(name = "lastCalibrationDate")
	private String lastCalibrationDate;

	@Column(name = "lastJobDone")
	private String lastJobDone;

	@Column(name = "lastFailure")
	private String lastFailure;
	// DIAGNOSIS PART

	@Column(name = "correctiveAction1")
	private String correctiveAction1;

	@Column(name = "correctiveAction2")
	private String correctiveAction2;

	@Column(name = "correctiveAction3")
	private String correctiveAction3;

	@Column(name = "correctiveAction4")
	private String correctiveAction4;

	@Column(name = "correctiveAction5")
	private String correctiveAction5;

	@Column(name = "correctiveAction6")
	private String correctiveAction6;

	@Column(name = "correctiveActionDoneBy1")
	private String correctiveActionDoneBy1;

	@Column(name = "correctiveActionDoneBy2")
	private String correctiveActionDoneBy2;

	@Column(name = "correctiveActionDoneBy3")
	private String correctiveActionDoneBy3;

	@Column(name = "correctiveActionDoneBy4")
	private String correctiveActionDoneBy4;

	@Column(name = "correctiveActionDoneBy5")
	private String correctiveActionDoneBy5;

	@Column(name = "correctiveActionDoneBy6")
	private String correctiveActionDoneBy6;

	@Column(name = "openDate1")
	private String openDate1;

	@Column(name = "openDate2")
	private String openDate2;

	@Column(name = "openDate3")
	private String openDate3;

	@Column(name = "openDate4")
	private String openDate4;

	@Column(name = "openDate5")
	private String openDate5;

	@Column(name = "openDate6")
	private String openDate6;

	@Column(name = "closeDate1")
	private String closeDate1;

	@Column(name = "closeDate2")
	private String closeDate2;

	@Column(name = "closeDate3")
	private String closeDate3;

	@Column(name = "closeDate4")
	private String closeDate4;

	@Column(name = "closeDate5")
	private String closeDate5;

	@Column(name = "closeDate6")
	private String closeDate6;

	@Column(name = "correctiveActionCode1")
	private String correctiveActionCode1;

	@Column(name = "correctiveActionCode2")
	private String correctiveActionCode2;

	@Column(name = "correctiveActionCode3")
	private String correctiveActionCode3;

	@Column(name = "correctiveActionCode4")
	private String correctiveActionCode4;

	@Column(name = "cpiNature")
	
	private String cpiNature;
	
	
	@Column(name = "correctiveActionCode5")
	private String correctiveActionCode5;

	@Column(name = "correctiveActionCode6")
	private String correctiveActionCode6;
	
	
	@Column(name = "mrfNo")
	private String mrfNo;
	
	@Column(name = "remarksOnMrf")
	private String remarksOnMrf;
	
	
	// ANALYSIS PART
	
	@Column(name = "prcaAssignedTo")
	private String prcaAssignedTo;
	
	
	@Column(name = "prcaDoneBy")
	private String prcaDoneBy;
	
	@Column(name = "dateOfPrca")
	private String dateOfPrca;
	
	
	@Column(name = "prcaReport")
	private String prcaReport;
	
	@Column(name = "prcaRemarks")
	private String prcaRemarks;
	
	@Column(name = "frcaAssignedTo")
	private String frcaAssignedTo;
	
	@Column(name = "frcaDoneBy")
	private String frcaDoneBy;
	
	@Column(name = "dateOfFrca")
	private String dateOfFrca;
	
	@Column(name = "frcaReport")
	private String frcaReport;
	
	@Column(name = "frcaRemarks")
	private String frcaRemarks;
	
	@Column(name = "typeOfCpi")
	private String typeOfCpi;
	
	@Column(name = "sourceOfCpi")
	private String sourceOfCpi;
	
	@Column(name = "subSourceOfCpi")
	private String subSourceOfCpi;
	
	@Column(name = "groupCode")
	private String groupCode;
	
	@Column(name = "subGroupCd")
	private String subGroupCd;
	
	@Column(name = "category")
	private String category;
	
	@Column(name = "subCategory")
	private String subCategory;
	
	@Column(name = "effectOnCustomer")
	private String effectOnCustomer;
	
	@Column(name = "impactToCoustomer")
	private String impactToCoustomer;
	
	@Column(name = "commentsOnCloser")
	private String commentsOnCloser;
	

	public String getAssetName() {
		return assetName;
	}

	public void setAssetName(String assetName) {
		this.assetName = assetName;
	}

	public String getAssetName1() {
		return assetName1;
	}

	public void setAssetName1(String assetName1) {
		this.assetName1 = assetName1;
	}

	public String getAssetName2() {
		return assetName2;
	}

	public void setAssetName2(String assetName2) {
		this.assetName2 = assetName2;
	}

	public String getAssetName3() {
		return assetName3;
	}

	public void setAssetName3(String assetName3) {
		this.assetName3 = assetName3;
	}

	public String getAssetName4() {
		return assetName4;
	}

	public void setAssetName4(String assetName4) {
		this.assetName4 = assetName4;
	}

	public String getAssetName5() {
		return assetName5;
	}

	public void setAssetName5(String assetName5) {
		this.assetName5 = assetName5;
	}

	public String getAssetName6() {
		return assetName6;
	}

	public void setAssetName6(String assetName6) {
		this.assetName6 = assetName6;
	}

	public String getAssetSrNo() {
		return assetSrNo;
	}

	public void setAssetSrNo(String assetSrNo) {
		this.assetSrNo = assetSrNo;
	}

	public String getAssetSrNo1() {
		return assetSrNo1;
	}

	public void setAssetSrNo1(String assetSrNo1) {
		this.assetSrNo1 = assetSrNo1;
	}

	public String getAssetSrNo2() {
		return assetSrNo2;
	}

	public void setAssetSrNo2(String assetSrNo2) {
		this.assetSrNo2 = assetSrNo2;
	}

	public String getAssetSrNo3() {
		return assetSrNo3;
	}

	public void setAssetSrNo3(String assetSrNo3) {
		this.assetSrNo3 = assetSrNo3;
	}

	public String getAssetSrNo4() {
		return assetSrNo4;
	}

	public void setAssetSrNo4(String assetSrNo4) {
		this.assetSrNo4 = assetSrNo4;
	}

	public String getAssetSrNo5() {
		return assetSrNo5;
	}

	public void setAssetSrNo5(String assetSrNo5) {
		this.assetSrNo5 = assetSrNo5;
	}

	public String getAssetSrNo6() {
		return assetSrNo6;
	}

	public void setAssetSrNo6(String assetSrNo6) {
		this.assetSrNo6 = assetSrNo6;
	}

	public String getAssetType() {
		return assetType;
	}

	public void setAssetType(String assetType) {
		this.assetType = assetType;
	}

	public String getAssetType1() {
		return assetType1;
	}

	public void setAssetType1(String assetType1) {
		this.assetType1 = assetType1;
	}

	public String getAssetType2() {
		return assetType2;
	}

	public void setAssetType2(String assetType2) {
		this.assetType2 = assetType2;
	}

	public String getAssetType3() {
		return assetType3;
	}

	public void setAssetType3(String assetType3) {
		this.assetType3 = assetType3;
	}

	public String getAssetType4() {
		return assetType4;
	}

	public void setAssetType4(String assetType4) {
		this.assetType4 = assetType4;
	}

	public String getAssetType5() {
		return assetType5;
	}

	public void setAssetType5(String assetType5) {
		this.assetType5 = assetType5;
	}

	public String getAssetType6() {
		return assetType6;
	}

	public void setAssetType6(String assetType6) {
		this.assetType6 = assetType6;
	}

	public String getBht() {
		return bht;
	}

	public void setBht(String bht) {
		this.bht = bht;
	}

	public String getBitSize() {
		return bitSize;
	}

	public void setBitSize(String bitSize) {
		this.bitSize = bitSize;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getClientCd() {
		return clientCd;
	}

	public void setClientCd(String clientCd) {
		this.clientCd = clientCd;
	}

	public String getCloseDate1() {
		return closeDate1;
	}

	public void setCloseDate1(String closeDate1) {
		this.closeDate1 = closeDate1;
	}

	public String getCloseDate2() {
		return closeDate2;
	}

	public void setCloseDate2(String closeDate2) {
		this.closeDate2 = closeDate2;
	}

	public String getCloseDate3() {
		return closeDate3;
	}

	public void setCloseDate3(String closeDate3) {
		this.closeDate3 = closeDate3;
	}

	public String getCloseDate4() {
		return closeDate4;
	}

	public void setCloseDate4(String closeDate4) {
		this.closeDate4 = closeDate4;
	}

	public String getCloseDate5() {
		return closeDate5;
	}

	public void setCloseDate5(String closeDate5) {
		this.closeDate5 = closeDate5;
	}

	public String getCloseDate6() {
		return closeDate6;
	}

	public void setCloseDate6(String closeDate6) {
		this.closeDate6 = closeDate6;
	}

	public String getCommentsOnCloser() {
		return commentsOnCloser;
	}

	public void setCommentsOnCloser(String commentsOnCloser) {
		this.commentsOnCloser = commentsOnCloser;
	}

	public String getCorrectiveAction1() {
		return correctiveAction1;
	}

	public void setCorrectiveAction1(String correctiveAction1) {
		this.correctiveAction1 = correctiveAction1;
	}

	public String getCorrectiveAction2() {
		return correctiveAction2;
	}

	public void setCorrectiveAction2(String correctiveAction2) {
		this.correctiveAction2 = correctiveAction2;
	}

	public String getCorrectiveAction3() {
		return correctiveAction3;
	}

	public void setCorrectiveAction3(String correctiveAction3) {
		this.correctiveAction3 = correctiveAction3;
	}

	public String getCorrectiveAction4() {
		return correctiveAction4;
	}

	public void setCorrectiveAction4(String correctiveAction4) {
		this.correctiveAction4 = correctiveAction4;
	}

	public String getCorrectiveAction5() {
		return correctiveAction5;
	}

	public void setCorrectiveAction5(String correctiveAction5) {
		this.correctiveAction5 = correctiveAction5;
	}

	public String getCorrectiveAction6() {
		return correctiveAction6;
	}

	public void setCorrectiveAction6(String correctiveAction6) {
		this.correctiveAction6 = correctiveAction6;
	}

	public String getCorrectiveActionCode1() {
		return correctiveActionCode1;
	}

	public void setCorrectiveActionCode1(String correctiveActionCode1) {
		this.correctiveActionCode1 = correctiveActionCode1;
	}

	public String getCorrectiveActionCode2() {
		return correctiveActionCode2;
	}

	public void setCorrectiveActionCode2(String correctiveActionCode2) {
		this.correctiveActionCode2 = correctiveActionCode2;
	}

	public String getCorrectiveActionCode3() {
		return correctiveActionCode3;
	}

	public void setCorrectiveActionCode3(String correctiveActionCode3) {
		this.correctiveActionCode3 = correctiveActionCode3;
	}

	public String getCorrectiveActionCode4() {
		return correctiveActionCode4;
	}

	public void setCorrectiveActionCode4(String correctiveActionCode4) {
		this.correctiveActionCode4 = correctiveActionCode4;
	}

	public String getCorrectiveActionCode5() {
		return correctiveActionCode5;
	}

	public void setCorrectiveActionCode5(String correctiveActionCode5) {
		this.correctiveActionCode5 = correctiveActionCode5;
	}

	public String getCorrectiveActionCode6() {
		return correctiveActionCode6;
	}

	public void setCorrectiveActionCode6(String correctiveActionCode6) {
		this.correctiveActionCode6 = correctiveActionCode6;
	}

	public String getCorrectiveActionDoneBy1() {
		return correctiveActionDoneBy1;
	}

	public void setCorrectiveActionDoneBy1(String correctiveActionDoneBy1) {
		this.correctiveActionDoneBy1 = correctiveActionDoneBy1;
	}

	public String getCorrectiveActionDoneBy2() {
		return correctiveActionDoneBy2;
	}

	public void setCorrectiveActionDoneBy2(String correctiveActionDoneBy2) {
		this.correctiveActionDoneBy2 = correctiveActionDoneBy2;
	}

	public String getCorrectiveActionDoneBy3() {
		return correctiveActionDoneBy3;
	}

	public void setCorrectiveActionDoneBy3(String correctiveActionDoneBy3) {
		this.correctiveActionDoneBy3 = correctiveActionDoneBy3;
	}

	public String getCorrectiveActionDoneBy4() {
		return correctiveActionDoneBy4;
	}

	public void setCorrectiveActionDoneBy4(String correctiveActionDoneBy4) {
		this.correctiveActionDoneBy4 = correctiveActionDoneBy4;
	}

	public String getCorrectiveActionDoneBy5() {
		return correctiveActionDoneBy5;
	}

	public void setCorrectiveActionDoneBy5(String correctiveActionDoneBy5) {
		this.correctiveActionDoneBy5 = correctiveActionDoneBy5;
	}

	public String getCorrectiveActionDoneBy6() {
		return correctiveActionDoneBy6;
	}

	public void setCorrectiveActionDoneBy6(String correctiveActionDoneBy6) {
		this.correctiveActionDoneBy6 = correctiveActionDoneBy6;
	}

	public String getCpiCd() {
		return cpiCd;
	}

	public void setCpiCd(String cpiCd) {
		this.cpiCd = cpiCd;
	}

	public String getCpiProcess() {
		return cpiProcess;
	}

	public void setCpiProcess(String cpiProcess) {
		this.cpiProcess = cpiProcess;
	}

	public String getCpiStatus() {
		return cpiStatus;
	}

	public void setCpiStatus(String cpiStatus) {
		this.cpiStatus = cpiStatus;
	}

	public String getCpiType() {
		return cpiType;
	}

	public void setCpiType(String cpiType) {
		this.cpiType = cpiType;
	}

	public String getDateOfCpi() {
		return dateOfCpi;
	}

	public void setDateOfCpi(String dateOfCpi) {
		this.dateOfCpi = dateOfCpi;
	}

	public String getDateOfFrca() {
		return dateOfFrca;
	}

	public void setDateOfFrca(String dateOfFrca) {
		this.dateOfFrca = dateOfFrca;
	}

	public String getDateOfPrca() {
		return dateOfPrca;
	}

	public void setDateOfPrca(String dateOfPrca) {
		this.dateOfPrca = dateOfPrca;
	}

	public String getDepth() {
		return depth;
	}

	public void setDepth(String depth) {
		this.depth = depth;
	}

	public String getDeviation() {
		return deviation;
	}

	public void setDeviation(String deviation) {
		this.deviation = deviation;
	}

	public String getEffectOnCustomer() {
		return effectOnCustomer;
	}

	public void setEffectOnCustomer(String effectOnCustomer) {
		this.effectOnCustomer = effectOnCustomer;
	}

	public String getFrcaAssignedTo() {
		return frcaAssignedTo;
	}

	public void setFrcaAssignedTo(String frcaAssignedTo) {
		this.frcaAssignedTo = frcaAssignedTo;
	}

	public String getFrcaDoneBy() {
		return frcaDoneBy;
	}

	public void setFrcaDoneBy(String frcaDoneBy) {
		this.frcaDoneBy = frcaDoneBy;
	}

	public String getFrcaRemarks() {
		return frcaRemarks;
	}

	public void setFrcaRemarks(String frcaRemarks) {
		this.frcaRemarks = frcaRemarks;
	}

	public String getFrcaReport() {
		return frcaReport;
	}

	public void setFrcaReport(String frcaReport) {
		this.frcaReport = frcaReport;
	}

	public String getGroupCode() {
		return groupCode;
	}

	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}

	public String getHoleCondition() {
		return holeCondition;
	}

	public void setHoleCondition(String holeCondition) {
		this.holeCondition = holeCondition;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getImpactToCoustomer() {
		return impactToCoustomer;
	}

	public void setImpactToCoustomer(String impactToCoustomer) {
		this.impactToCoustomer = impactToCoustomer;
	}

	public String getJobSuccessfullyDone() {
		return jobSuccessfullyDone;
	}

	public void setJobSuccessfullyDone(String jobSuccessfullyDone) {
		this.jobSuccessfullyDone = jobSuccessfullyDone;
	}

	public String getLastCalibrationDate() {
		return lastCalibrationDate;
	}

	public void setLastCalibrationDate(String lastCalibrationDate) {
		this.lastCalibrationDate = lastCalibrationDate;
	}

	public String getLastFailure() {
		return lastFailure;
	}

	public void setLastFailure(String lastFailure) {
		this.lastFailure = lastFailure;
	}

	public String getLastJobDone() {
		return lastJobDone;
	}

	public void setLastJobDone(String lastJobDone) {
		this.lastJobDone = lastJobDone;
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

	public String getMrfNo() {
		return mrfNo;
	}

	public void setMrfNo(String mrfNo) {
		this.mrfNo = mrfNo;
	}

	public String getMudType() {
		return mudType;
	}

	public void setMudType(String mudType) {
		this.mudType = mudType;
	}

	public String getMudWeight() {
		return mudWeight;
	}

	public void setMudWeight(String mudWeight) {
		this.mudWeight = mudWeight;
	}

	public String getOpenDate1() {
		return openDate1;
	}

	public void setOpenDate1(String openDate1) {
		this.openDate1 = openDate1;
	}

	public String getOpenDate2() {
		return openDate2;
	}

	public void setOpenDate2(String openDate2) {
		this.openDate2 = openDate2;
	}

	public String getOpenDate3() {
		return openDate3;
	}

	public void setOpenDate3(String openDate3) {
		this.openDate3 = openDate3;
	}

	public String getOpenDate4() {
		return openDate4;
	}

	public void setOpenDate4(String openDate4) {
		this.openDate4 = openDate4;
	}

	public String getOpenDate5() {
		return openDate5;
	}

	public void setOpenDate5(String openDate5) {
		this.openDate5 = openDate5;
	}

	public String getOpenDate6() {
		return openDate6;
	}

	public void setOpenDate6(String openDate6) {
		this.openDate6 = openDate6;
	}

	public String getOriginatedBy() {
		return originatedBy;
	}

	public void setOriginatedBy(String originatedBy) {
		this.originatedBy = originatedBy;
	}

	public String getPm2status() {
		return pm2status;
	}

	public void setPm2status(String pm2status) {
		this.pm2status = pm2status;
	}

	public String getPrcaAssignedTo() {
		return prcaAssignedTo;
	}

	public void setPrcaAssignedTo(String prcaAssignedTo) {
		this.prcaAssignedTo = prcaAssignedTo;
	}

	public String getPrcaDoneBy() {
		return prcaDoneBy;
	}

	public void setPrcaDoneBy(String prcaDoneBy) {
		this.prcaDoneBy = prcaDoneBy;
	}

	public String getPrcaRemarks() {
		return prcaRemarks;
	}

	public void setPrcaRemarks(String prcaRemarks) {
		this.prcaRemarks = prcaRemarks;
	}

	public String getPrcaReport() {
		return prcaReport;
	}

	public void setPrcaReport(String prcaReport) {
		this.prcaReport = prcaReport;
	}

	public String getPressure() {
		return pressure;
	}

	public void setPressure(String pressure) {
		this.pressure = pressure;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getProblem() {
		return problem;
	}

	public void setProblem(String problem) {
		this.problem = problem;
	}

	public String getRegionCd() {
		return regionCd;
	}

	public void setRegionCd(String regionCd) {
		this.regionCd = regionCd;
	}

	public String getRemarksOnMrf() {
		return remarksOnMrf;
	}

	public void setRemarksOnMrf(String remarksOnMrf) {
		this.remarksOnMrf = remarksOnMrf;
	}

	public String getSectionName() {
		return sectionName;
	}

	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}

	public String getSectionName1() {
		return sectionName1;
	}

	public void setSectionName1(String sectionName1) {
		this.sectionName1 = sectionName1;
	}

	public String getSectionName2() {
		return sectionName2;
	}

	public void setSectionName2(String sectionName2) {
		this.sectionName2 = sectionName2;
	}

	public String getSectionName3() {
		return sectionName3;
	}

	public void setSectionName3(String sectionName3) {
		this.sectionName3 = sectionName3;
	}

	public String getSectionName4() {
		return sectionName4;
	}

	public void setSectionName4(String sectionName4) {
		this.sectionName4 = sectionName4;
	}

	public String getSectionName5() {
		return sectionName5;
	}

	public void setSectionName5(String sectionName5) {
		this.sectionName5 = sectionName5;
	}

	public String getSectionName6() {
		return sectionName6;
	}

	public void setSectionName6(String sectionName6) {
		this.sectionName6 = sectionName6;
	}

	public String getSectionSerialNo() {
		return sectionSerialNo;
	}

	public void setSectionSerialNo(String sectionSerialNo) {
		this.sectionSerialNo = sectionSerialNo;
	}

	public String getSectionSerialNo1() {
		return sectionSerialNo1;
	}

	public void setSectionSerialNo1(String sectionSerialNo1) {
		this.sectionSerialNo1 = sectionSerialNo1;
	}

	public String getSectionSerialNo2() {
		return sectionSerialNo2;
	}

	public void setSectionSerialNo2(String sectionSerialNo2) {
		this.sectionSerialNo2 = sectionSerialNo2;
	}

	public String getSectionSerialNo3() {
		return sectionSerialNo3;
	}

	public void setSectionSerialNo3(String sectionSerialNo3) {
		this.sectionSerialNo3 = sectionSerialNo3;
	}

	public String getSectionSerialNo4() {
		return sectionSerialNo4;
	}

	public void setSectionSerialNo4(String sectionSerialNo4) {
		this.sectionSerialNo4 = sectionSerialNo4;
	}

	public String getSectionSerialNo5() {
		return sectionSerialNo5;
	}

	public void setSectionSerialNo5(String sectionSerialNo5) {
		this.sectionSerialNo5 = sectionSerialNo5;
	}

	public String getSectionSerialNo6() {
		return sectionSerialNo6;
	}

	public void setSectionSerialNo6(String sectionSerialNo6) {
		this.sectionSerialNo6 = sectionSerialNo6;
	}

	public String getSourceOfCpi() {
		return sourceOfCpi;
	}

	public void setSourceOfCpi(String sourceOfCpi) {
		this.sourceOfCpi = sourceOfCpi;
	}

	public String getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}

	public String getSubGroupCd() {
		return subGroupCd;
	}

	public void setSubGroupCd(String subGroupCd) {
		this.subGroupCd = subGroupCd;
	}

	public String getSubSourceOfCpi() {
		return subSourceOfCpi;
	}

	public void setSubSourceOfCpi(String subSourceOfCpi) {
		this.subSourceOfCpi = subSourceOfCpi;
	}

	public String getTypeOfCpi() {
		return typeOfCpi;
	}

	public void setTypeOfCpi(String typeOfCpi) {
		this.typeOfCpi = typeOfCpi;
	}

	public String getUnitCd() {
		return unitCd;
	}

	public void setUnitCd(String unitCd) {
		this.unitCd = unitCd;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public String getWhyOpen() {
		return whyOpen;
	}

	public void setWhyOpen(String whyOpen) {
		this.whyOpen = whyOpen;
	}

	public String getWhyOpenOthers() {
		return whyOpenOthers;
	}

	public void setWhyOpenOthers(String whyOpenOthers) {
		this.whyOpenOthers = whyOpenOthers;
	}

	public void setCpiNature(String cpiNature) {
		this.cpiNature = cpiNature;
	}

	public String getCpiNature() {
		return cpiNature;
	}

	public void setUpdownFlag(String updownFlag) {
		this.updownFlag = updownFlag;
	}

	public String getUpdownFlag() {
		return updownFlag;
	}

}
