package com.iprosonic.cmms.modules.cpi.reports.historycard.web;



import java.util.List;
import java.util.Map;

import com.iprosonic.cmms.modules.cpi.masters.assets.domain.AssetBean;
import com.iprosonic.cmms.pjcommons.valuelist.AssetTypeListAction;
import com.iprosonic.cmms.pjcommons.valuelist.CpiGetList;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class InitHistoryCardReportAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

     private AssetBean assetBean = new AssetBean(); 
	
	CpiGetList cpiGetList = new CpiGetList();

	AssetTypeListAction assetTypeListAction = new AssetTypeListAction();

	private List<String> assetTypeList;
    Map<String, Object> session;
	@Override
	public String execute() {
		
		session = ActionContext.getContext().getSession();
      	setAssetTypeList(assetTypeListAction.getAssetType());
      	session.put("assetType", assetTypeList);
		return SUCCESS;
	}


	

	public Map<String, Object> getSession() {
		return this.session;
	}

	

	public void setAssetTypeList(List<String> assetTypeList) {
		this.assetTypeList = assetTypeList;
	}

	public List<String> getAssetTypeList() {
		return assetTypeList;
	}


	


	public void setAssetBean(AssetBean assetBean) {
		this.assetBean = assetBean;
	}


	public AssetBean getAssetBean() {
		return assetBean;
	}

}
