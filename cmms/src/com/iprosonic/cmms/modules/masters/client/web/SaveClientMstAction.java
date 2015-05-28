package com.iprosonic.cmms.modules.masters.client.web;


import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.iprosonic.cmms.modules.masters.client.domain.ClientMasterBean;
import com.iprosonic.cmms.modules.masters.client.service.SearchClientMaster;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class SaveClientMstAction extends ActionSupport implements ModelDriven<ClientMasterBean>{

	
	private static final long serialVersionUID = 1L;
	SearchClientMaster searchClientMaster=new SearchClientMaster();
	private ClientMasterBean clientMasterBean=new ClientMasterBean();
	private List<ClientMasterBean> clientMasterList=null;
	
	

	public List<ClientMasterBean> getClientMasterList() {
		return clientMasterList;
	}
	


	public void setClientMasterList(List<ClientMasterBean> clientMasterList) {
		this.clientMasterList = clientMasterList;
	}
	
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


	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		if(searchClientMaster.getClientById(clientMasterBean.getId())){
			searchClientMaster.editClient(clientMasterBean);
		}else{
		searchClientMaster.saveClientSer(clientMasterBean);
		}
		clientMasterList=searchClientMaster.getClientList();
		
		return SUCCESS;
	}
	
	
 
}
