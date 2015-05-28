package com.iprosonic.cmms.modules.masters.location.web;



import java.util.List;

import com.iprosonic.cmms.modules.masters.location.domain.Locationmst;
import com.iprosonic.cmms.modules.masters.location.service.LocationCDService;
import com.opensymphony.xwork2.ActionSupport;

public class InitLocationMstAction extends ActionSupport {

	
	private static final long serialVersionUID = 1L;
	private LocationCDService locationCDService=new LocationCDService();
	private List<Locationmst> locationMstList=null;
	private Locationmst locationmst=new Locationmst();
	
	


	public List<Locationmst> getLocationMstList() {
		return locationMstList;
	}




	public void setLocationMstList(List<Locationmst> locationMstList) {
		this.locationMstList = locationMstList;
	}




	public Locationmst getLocationmst() {
		return locationmst;
	}




	public void setLocationmst(Locationmst locationmst) {
		this.locationmst = locationmst;
	}




	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		locationMstList=locationCDService.getLocationList();
		return SUCCESS;
	}
	
	

}
