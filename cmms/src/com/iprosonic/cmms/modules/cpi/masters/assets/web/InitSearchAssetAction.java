package com.iprosonic.cmms.modules.cpi.masters.assets.web;
import java.util.List;
import java.util.Map;

import com.iprosonic.cmms.modules.cpi.masters.assets.domain.AssetBean;
import com.iprosonic.cmms.pjcommons.valuelist.AssetTypeListAction;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class InitSearchAssetAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private AssetBean assetBean = new AssetBean();
	AssetTypeListAction assetTypeListAction = new AssetTypeListAction();
	private List<String> assetTypeList;

	@Override
	public String execute() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		assetTypeList = assetTypeListAction.getAssetType();
		session.put("assetType", assetTypeList);
		return SUCCESS;
	}

	public void setAssetBean(AssetBean assetBean) {
		this.assetBean = assetBean;
	}

	public AssetBean getAssetBean() {
		return assetBean;
	}

	public void setAssetTypeList(List<String> assetTypeList) {
		this.assetTypeList = assetTypeList;
	}

	public List<String> getAssetTypeList() {
		return assetTypeList;
	}

}
