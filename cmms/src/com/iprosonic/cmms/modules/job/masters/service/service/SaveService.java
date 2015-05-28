package com.iprosonic.cmms.modules.job.masters.service.service;
import java.util.Iterator;
import java.util.List;

import com.iprosonic.cmms.modules.job.masters.service.dao.ServiceDaoImpl;
import com.iprosonic.cmms.modules.job.masters.service.domain.ServiceMstBean;

public class SaveService {

	private ServiceDaoImpl iServiceDao = null;
	
	public SaveService()
	{
		iServiceDao = new ServiceDaoImpl();
	}
	public void saveService(ServiceMstBean serviceMstBean) {
		iServiceDao.saveService(serviceMstBean);
	}
	public boolean isServiveTypeExists(String type) {
		boolean res = false;		
		List<ServiceMstBean> list = iServiceDao.searchServiceListByType(type);
		Iterator<ServiceMstBean> itr = list.iterator();
		while (itr.hasNext()) {
			ServiceMstBean jobTypeBean = itr.next();
			if (jobTypeBean.getServiceType().equalsIgnoreCase(type)) {
				res = true;
			}
		}
		return res;

	}
	public void updateService(ServiceMstBean model) {
		// TODO Auto-generated method stub
		iServiceDao.updateSerivce(model);
	}
}
