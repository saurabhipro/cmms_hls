package com.iprosonic.cmms.modules.job.reports.was.web;


import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.struts2.interceptor.SessionAware;

import com.iprosonic.cmms.modules.cpi.transactions.cpi.domain.CpiBean;
import com.iprosonic.cmms.pjcommons.valuelist.AssetTypeListAction;
import com.iprosonic.cmms.pjcommons.valuelist.CpiGetList;
import com.iprosonic.cmms.pjcommons.valuelist.EmployeeCdListAction;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
public class InitMWasReportAction extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = 1L;
	private CpiBean cpiBean = new CpiBean();
	CpiGetList cpiGetList = new CpiGetList();
	EmployeeCdListAction employeeCdListAction = new EmployeeCdListAction();
	AssetTypeListAction assetTypeListAction = new AssetTypeListAction();	
	private List<String> cpiCdList;
	private List<String> unitCdList;
	private Map<String, Object> session;
	private List<String> cpiStatusList;
	private List<String> assetTypeList;
	
	private Set<String> impactToCoustomerSet;
	private Set<String> effectOnCustomerSet;
	private List<String> typeOfCpiList;
	private List<String> subSourceOfCpiList;
	private List<String> subGroupCdList;
	private Set<String> subGroupCdSet;
	private List<String> cpiCategoryList;
	private List<String>frcaDoneByList;
	private List<String>prcaDoneByList;
	private List<String> sourceOfCpiList;
	private List<String>cpiSubCategoryList;
	private List<String>correctiveActionDoneByList;
	
	
	
	
	

	@Override
	public String execute() {
		
		session = ActionContext.getContext().getSession();
		cpiCdList = cpiGetList.getCpiCd();
		unitCdList = cpiGetList.getUnitCdList();
		cpiStatusList = cpiGetList.getCpiStatus();
		setAssetTypeList(assetTypeListAction.getAssetType());	
		subSourceOfCpiList = cpiGetList.getSubSourceOfCpiList();		
		cpiCategoryList = cpiGetList.getCpiCategoryList();
		frcaDoneByList = employeeCdListAction.getOriginatedByString();
		prcaDoneByList = employeeCdListAction.getOriginatedByString();
		correctiveActionDoneByList=	employeeCdListAction.getOriginatedByString();
		typeOfCpiList = cpiGetList.getTypeOfCpiList();
		setSubGroupCdList(cpiGetList.getsubGroupCdList());
		cpiCategoryList = cpiGetList.getCpiCategoryList();
		sourceOfCpiList =cpiGetList.getSourceOfCpiList();
		setCpiSubCategoryList(cpiGetList.getCpiSubCategoryList());
		session.put("cpiCd", cpiCdList);
		session.put("unitCd", unitCdList);
		session.put("cpiStatus", cpiStatusList);
		session.put("assetType", getAssetTypeList());
		session.put("correctiveActionDoneBy1", correctiveActionDoneByList);
		session.put("sourceOfCpi", sourceOfCpiList);
		session.put("subSourceOfCpi", subSourceOfCpiList);
		session.put("subGroupCd", subGroupCdList);
		session.put("typeOfCpi", typeOfCpiList);
		session.put("frcaDoneBy", frcaDoneByList);
		session.put("prcaDoneBy", prcaDoneByList);
		session.put("category", cpiCategoryList);
		session.put("subCategory", cpiSubCategoryList);
		return SUCCESS;
	}

	public void setCpiCdList(List<String> cpiCdList) {
		this.cpiCdList = cpiCdList;
	}

	public List<String> getCpiCdList() {
		return cpiCdList;
	}

	public void setUnitCdList(List<String> unitCdList) {
		this.unitCdList = unitCdList;
	}

	public List<String> getUnitCdList() {
		return unitCdList;
	}

	public void setCpiBean(CpiBean cpiBean) {
		this.cpiBean = cpiBean;
	}

	public CpiBean getCpiBean() {
		return cpiBean;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public Map<String, Object> getSession() {
		return this.session;
	}

	public void setCpiStatusList(List<String> cpiStatusList) {
		this.cpiStatusList = cpiStatusList;
	}

	public List<String> getCpiStatusList() {
		return cpiStatusList;
	}

	

	public void setImpactToCoustomerSet(Set<String> impactToCoustomerSet) {
		this.impactToCoustomerSet = impactToCoustomerSet;
	}

	public Set<String> getImpactToCoustomerSet() {
		return impactToCoustomerSet;
	}

	public void setEffectOnCustomerSet(Set<String> effectOnCustomerSet) {
		this.effectOnCustomerSet = effectOnCustomerSet;
	}

	public Set<String> getEffectOnCustomerSet() {
		return effectOnCustomerSet;
	}







	public void setSubGroupCdSet(Set<String> subGroupCdSet) {
		this.subGroupCdSet = subGroupCdSet;
	}

	public Set<String> getSubGroupCdSet() {
		return subGroupCdSet;
	}

	

	
	public void setFrcaDoneByList(List<String> frcaDoneByList) {
		this.frcaDoneByList = frcaDoneByList;
	}

	public List<String> getFrcaDoneByList() {
		return frcaDoneByList;
	}

	public void setPrcaDoneByList(List<String> prcaDoneByList) {
		this.prcaDoneByList = prcaDoneByList;
	}

	public List<String> getPrcaDoneByList() {
		return prcaDoneByList;
	}

	public void setAssetTypeList(List<String> assetTypeList) {
		this.assetTypeList = assetTypeList;
	}

	public List<String> getAssetTypeList() {
		return assetTypeList;
	}

	public void setTypeOfCpiList(List<String> typeOfCpiList) {
		this.typeOfCpiList = typeOfCpiList;
	}

	public List<String> getTypeOfCpiList() {
		return typeOfCpiList;
	}

	public void setSourceOfCpiList(List<String> sourceOfCpiList) {
		this.sourceOfCpiList = sourceOfCpiList;
	}

	public List<String> getSourceOfCpiList() {
		return sourceOfCpiList;
	}

	public void setSubGroupCdList(List<String> subGroupCdList) {
		this.subGroupCdList = subGroupCdList;
	}

	public List<String> getSubGroupCdList() {
		return subGroupCdList;
	}

	public void setCpiSubCategoryList(List<String> cpiSubCategoryList) {
		this.cpiSubCategoryList = cpiSubCategoryList;
	}

	public List<String> getCpiSubCategoryList() {
		return cpiSubCategoryList;
	}

	public void setCorrectiveActionDoneByList(
			List<String> correctiveActionDoneByList) {
		this.correctiveActionDoneByList = correctiveActionDoneByList;
	}

	public List<String> getCorrectiveActionDoneByList() {
		return correctiveActionDoneByList;
	}
}
