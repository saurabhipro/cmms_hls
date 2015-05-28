package com.iprosonic.cmms.modules.masters.client.web;


import java.util.List;

import com.iprosonic.cmms.modules.masters.client.domain.ClientMasterBean;
import com.iprosonic.cmms.modules.masters.client.service.SearchClientMaster;
import com.opensymphony.xwork2.ActionSupport;

public class InitClientMstAction extends ActionSupport {

	
	private static final long serialVersionUID = 1L;
	private SearchClientMaster searchClientMaster=new SearchClientMaster();
	private List<ClientMasterBean> clientMasterList=null;
	private ClientMasterBean clientMasterBean=new ClientMasterBean();
	
	

	public ClientMasterBean getClientMasterBean() {
		return clientMasterBean;
	}



	public void setClientMasterBean(ClientMasterBean clientMasterBean) {
		this.clientMasterBean = clientMasterBean;
	}



	public List<ClientMasterBean> getClientMasterList() {
		return clientMasterList;
	}
	


	public void setClientMasterList(List<ClientMasterBean> clientMasterList) {
		this.clientMasterList = clientMasterList;
	}



	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		clientMasterList=searchClientMaster.getClientList();
		return SUCCESS;
	}
	
	

}
