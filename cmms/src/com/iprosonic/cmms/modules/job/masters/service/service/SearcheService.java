package com.iprosonic.cmms.modules.job.masters.service.service;
import java.util.List;

import com.iprosonic.cmms.modules.job.masters.service.dao.ServiceDaoImpl;
import com.iprosonic.cmms.modules.job.masters.service.domain.ServiceMstBean;

public class SearcheService {

	private ServiceDaoImpl serviceDao = null;

	public SearcheService() {
		serviceDao = new ServiceDaoImpl();

	}

	public List<ServiceMstBean> getServiceList() {

		return serviceDao.getSerivceList();
	}

	public ServiceMstBean searchServiceById(int id) {
		return serviceDao.searchSerivceById(id);

	}

	public List<ServiceMstBean> searchServiceByType(String type) {
		return serviceDao.searchServiceListByType(type);

	}

}
