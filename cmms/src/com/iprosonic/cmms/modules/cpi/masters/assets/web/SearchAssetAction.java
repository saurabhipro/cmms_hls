package com.iprosonic.cmms.modules.cpi.masters.assets.web;

import java.util.List;

import com.iprosonic.cmms.modules.cpi.masters.assets.domain.AssetBean;
import com.iprosonic.cmms.modules.cpi.masters.assets.service.AssetService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class SearchAssetAction extends ActionSupport implements
		ModelDriven<AssetBean> {

	private static final long serialVersionUID = 1L;

	private AssetBean assetBean = new AssetBean();

	private List<AssetBean> assetBeansList;
	AssetService assetService = new AssetService();

	@Override
	public String execute() {
		String assetType = getModel().getAssetType();
		String assetName = getModel().getAssetCd();
		assetBeansList = assetService.getAssertList(assetType, assetName);
		return SUCCESS;
	}

	@Override
	public AssetBean getModel() {
		return assetBean;
	}

	public void setAssetBean(AssetBean assetBean) {
		this.assetBean = assetBean;
	}

	public AssetBean getAssetBean() {
		return assetBean;
	}

	public void setAssetBeansList(List<AssetBean> assetBeansList) {
		this.assetBeansList = assetBeansList;
	}

	public List<AssetBean> getAssetBeansList() {
		return assetBeansList;
	}

}
