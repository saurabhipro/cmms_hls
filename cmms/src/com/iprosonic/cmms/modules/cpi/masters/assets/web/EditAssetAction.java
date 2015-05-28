package com.iprosonic.cmms.modules.cpi.masters.assets.web;



import com.iprosonic.cmms.modules.cpi.masters.assets.domain.AssetBean;
import com.iprosonic.cmms.modules.cpi.masters.assets.service.AssetService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class EditAssetAction extends ActionSupport implements
		ModelDriven<AssetBean> {
	private static final long serialVersionUID = -2579182397723383541L;

	private AssetBean assetBean = new AssetBean();

	AssetService assetService = new AssetService();
	@Override
	public String execute() {
		assetBean = assetService.getAssertById(getModel().getId());
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
	

}
