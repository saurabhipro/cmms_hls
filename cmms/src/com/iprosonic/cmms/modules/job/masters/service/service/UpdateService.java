package com.iprosonic.cmms.modules.job.masters.service.service;

import com.iprosonic.cmms.modules.job.masters.service.dao.ServiceDaoImpl;
import com.iprosonic.cmms.modules.job.masters.service.domain.ServiceMstBean;

public class UpdateService {

	private ServiceDaoImpl iServiceDao = null;

	public UpdateService() {
		iServiceDao = new ServiceDaoImpl();

	}

	public void updateService(ServiceMstBean serviceMstBean) {

		iServiceDao.updateSerivce(serviceMstBean);
	}

}
