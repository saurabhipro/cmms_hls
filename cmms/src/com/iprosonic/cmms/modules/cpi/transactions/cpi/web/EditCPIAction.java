package com.iprosonic.cmms.modules.cpi.transactions.cpi.web;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.iprosonic.cmms.modules.cpi.transactions.cpi.dao.CpiDAOImpl;
import com.iprosonic.cmms.modules.cpi.transactions.cpi.domain.CpiBean;
import com.iprosonic.cmms.modules.cpi.transactions.cpi.service.CpiService;
import com.iprosonic.cmms.modules.cpi.transactions.cpi.service.EditCPIService;
import com.iprosonic.cmms.pjcommons.valuelist.CpiGetList;
import com.iprosonic.cmms.pjcommons.valuelist.GroupCodeListAction;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class EditCPIAction extends ActionSupport implements
		ModelDriven<CpiBean> {

	private static final long serialVersionUID = 1L;
	private CpiBean cpiBean = new CpiBean();
	CpiDAOImpl cpiDAOImpl = new CpiDAOImpl();
	CpiService cpiService = new CpiService();
	CpiGetList cpiGetList = new CpiGetList();
	GroupCodeListAction groupCodeListAction = new GroupCodeListAction();
	EditCPIService editCpiService = new EditCPIService();
	
	private List<String> cpiProcessList;
	private List<String> cpiStatusList;
	private List<String> cpiWhyOpenList;
	private List<String> assetTypeList;
	private List<String> assetNameList;
	private List<String> assetSrNoList;
	private List<String> sectionCdList;
	private List<String> sectionSerialNoList;
	private List<String> correctiveActionDoneByList;
	private List<String> typeOfCpiList;
	private List<String> sourceOfCpiList;
	private List<String> subSourceOfCpiList;
	private List<String> subGroupCdList;
	private List<String> cpiCategoryList;
	private List<String> cpiSubCategoryList;
	private List<String> gropCdList;

	public String execute() {
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		request.setAttribute("edit", "true");
		edit();
		cpiProcessList = cpiGetList.getCpiProcess();		
		cpiStatusList = cpiGetList.getCpiStatus();
		cpiWhyOpenList = cpiGetList.getWhyOpen();
		assetTypeList = cpiGetList.getAssetTypeList();
		assetNameList = cpiGetList.getAssetNameList();
		assetSrNoList = cpiGetList.getAssetSrNoList();
		sectionCdList = cpiGetList.getSectionNoList();
		sectionSerialNoList = cpiGetList.getSectionSerialNoList();
		correctiveActionDoneByList = cpiGetList.correctiveActionDoneBy();
		typeOfCpiList = cpiGetList.correctiveActionDoneBy();		
		sourceOfCpiList = cpiGetList.getSourceOfCpiList();
		subSourceOfCpiList = cpiGetList.getSubSourceOfCpiList();
		subGroupCdList = cpiGetList.getsubGroupCdList();
		cpiCategoryList = cpiGetList.getCpiCategoryList();
		cpiSubCategoryList = cpiGetList.getCpiSubCategoryList();
		gropCdList = groupCodeListAction.getGroupCodeList();
		return SUCCESS;
	}

	public void edit() {
		HttpServletRequest request = (HttpServletRequest) ActionContext
				.getContext().get(ServletActionContext.HTTP_REQUEST);
		cpiBean = editCpiService.edit(request.getParameter("id"));
		setCpiBean(cpiBean);
	}

	@Override
	public CpiBean getModel() {
		// TODO Auto-generated method stub
		return cpiBean;
	}

	public void setCpiBean(CpiBean cpiBean) {
		this.cpiBean = cpiBean;
	}

	public CpiBean getCpiBean() {
		return cpiBean;
	}

	public void setCpiProcessList(List<String> cpiProcessList) {
		this.cpiProcessList = cpiProcessList;
	}

	public List<String> getCpiProcessList() {
		return cpiProcessList;
	}

	public void setCpiStatusList(List<String> cpiStatusList) {
		this.cpiStatusList = cpiStatusList;
	}

	public List<String> getCpiStatusList() {
		return cpiStatusList;
	}

	public void setCpiWhyOpenList(List<String> cpiWhyOpenList) {
		this.cpiWhyOpenList = cpiWhyOpenList;
	}

	public List<String> getCpiWhyOpenList() {
		return cpiWhyOpenList;
	}

	public void setAssetTypeList(List<String> assetTypeList) {
		this.assetTypeList = assetTypeList;
	}

	public List<String> getAssetTypeList() {
		return assetTypeList;
	}

	public void setAssetNameList(List<String> assetNameList) {
		this.assetNameList = assetNameList;
	}

	public List<String> getAssetNameList() {
		return assetNameList;
	}

	public void setAssetSrNoList(List<String> assetSrNoList) {
		this.assetSrNoList = assetSrNoList;
	}

	public List<String> getAssetSrNoList() {
		return assetSrNoList;
	}

	public void setSectionCdList(List<String> sectionCdList) {
		this.sectionCdList = sectionCdList;
	}

	public List<String> getSectionCdList() {
		return sectionCdList;
	}

	public void setSectionSerialNoList(List<String> sectionSerialNoList) {
		this.sectionSerialNoList = sectionSerialNoList;
	}

	public List<String> getSectionSerialNoList() {
		return sectionSerialNoList;
	}

	public void setCorrectiveActionDoneByList(
			List<String> correctiveActionDoneByList) {
		this.correctiveActionDoneByList = correctiveActionDoneByList;
	}

	public List<String> getCorrectiveActionDoneByList() {
		return correctiveActionDoneByList;
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

	public void setSubSourceOfCpiList(List<String> subSourceOfCpiList) {
		this.subSourceOfCpiList = subSourceOfCpiList;
	}

	public List<String> getSubSourceOfCpiList() {
		return subSourceOfCpiList;
	}

	public void setSubGroupCdList(List<String> subGroupCdList) {
		this.subGroupCdList = subGroupCdList;
	}

	public List<String> getSubGroupCdList() {
		return subGroupCdList;
	}

	public void setCpiCategoryList(List<String> cpiCategoryList) {
		this.cpiCategoryList = cpiCategoryList;
	}

	public List<String> getCpiCategoryList() {
		return cpiCategoryList;
	}

	public void setCpiSubCategoryList(List<String> cpiSubCategoryList) {
		this.cpiSubCategoryList = cpiSubCategoryList;
	}

	public List<String> getCpiSubCategoryList() {
		return cpiSubCategoryList;
	}

	public void setGropCdList(List<String> gropCdList) {
		this.gropCdList = gropCdList;
	}

	public List<String> getGropCdList() {
		return gropCdList;
	}

}