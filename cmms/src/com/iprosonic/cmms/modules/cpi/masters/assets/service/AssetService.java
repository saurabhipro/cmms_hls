package com.iprosonic.cmms.modules.cpi.masters.assets.service;
import java.util.List;

import com.iprosonic.cmms.modules.cpi.masters.assets.dao.AssetDaoImp;
import com.iprosonic.cmms.modules.cpi.masters.assets.domain.AssetBean;

public class AssetService {

	public void saveAsset(AssetBean assetBean) {
		AssetDaoImp assetDaoImp = new AssetDaoImp();
		assetDaoImp.saveAsset(assetBean);
	}

	public List<AssetBean> getAssertList(String assetType,String assetCd) {
		AssetDaoImp assetDaoImp = new AssetDaoImp();

		return assetDaoImp.assetList(assetType,assetCd);
	}

	public AssetBean getAssertById(int id){
		AssetDaoImp assetDaoImp = new AssetDaoImp();
		return assetDaoImp.listAssetById(id);
	}
	
	public void updateAssert(AssetBean assetBean)
	{
		AssetDaoImp assetDaoImp = new AssetDaoImp();
		assetDaoImp.updateAssertById(assetBean);
	}

}
