package com.iprosonic.cmms.modules.cpi.masters.assets.web;




import com.iprosonic.cmms.modules.cpi.masters.assets.domain.AssetBean;
import com.opensymphony.xwork2.ActionSupport;

public class InitAssetAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
    
	private AssetBean assetBean = new AssetBean();
	@Override
	public String execute()
    {
    	return SUCCESS;
    }
	public void setAssetBean(AssetBean assetBean) {
		this.assetBean = assetBean;
	}
	public AssetBean getAssetBean() {
		return assetBean;
	}
}
