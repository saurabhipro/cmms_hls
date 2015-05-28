package com.iprosonic.cmms.modules.masters.client.service;


import java.util.List;

import com.iprosonic.cmms.modules.masters.client.dao.ClientMasterDaoImpl;
import com.iprosonic.cmms.modules.masters.client.domain.ClientMasterBean;

public class SearchClientMaster {
	private ClientMasterDaoImpl clientMasterDao = null;

	public SearchClientMaster() {
		clientMasterDao = new ClientMasterDaoImpl();
	}

	public List<String> getClientNameList() {
		return clientMasterDao.getClientNameList();
	}
	public void saveClientSer(ClientMasterBean bean){
		clientMasterDao.saveClient(bean);
	}
	public List<ClientMasterBean> getClientList(){
		return clientMasterDao.getClient();
	}
	public void deleteClient(ClientMasterBean bean){
		clientMasterDao.deleteClientById(bean);
	}
	public void editClient(ClientMasterBean bean){
		clientMasterDao.editClientById(bean);
	}
	public boolean getClientById(int id){
		boolean b=clientMasterDao.getClientId(id);
		return b;
	}
}
