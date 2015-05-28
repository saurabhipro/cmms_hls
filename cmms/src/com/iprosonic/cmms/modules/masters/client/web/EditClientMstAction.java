package com.iprosonic.cmms.modules.masters.client.web;


import java.util.List;

import com.iprosonic.cmms.modules.masters.client.domain.ClientMasterBean;
import com.iprosonic.cmms.modules.masters.client.service.SearchClientMaster;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class EditClientMstAction extends ActionSupport implements ModelDriven<ClientMasterBean>{

	
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



	@Override
	public ClientMasterBean getModel() {
		// TODO Auto-generated method stub
		return clientMasterBean;
	}



	public List<ClientMasterBean> getClientMasterList() {
		return clientMasterList;
	}
	


	public void setClientMasterList(List<ClientMasterBean> clientMasterList) {
		this.clientMasterList = clientMasterList;
	}


	

	@Override
	public String execute() {
		// TODO Auto-generated method stub
		try{
		
		clientMasterList=searchClientMaster.getClientList();
		
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return SUCCESS;
	}
	
	

}
