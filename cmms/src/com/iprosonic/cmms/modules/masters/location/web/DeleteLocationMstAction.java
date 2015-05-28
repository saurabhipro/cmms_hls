package com.iprosonic.cmms.modules.masters.location.web;



import java.util.List;

import com.iprosonic.cmms.modules.masters.location.domain.Locationmst;
import com.iprosonic.cmms.modules.masters.location.service.LocationCDService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class DeleteLocationMstAction extends ActionSupport implements ModelDriven<Locationmst>{

	
	private static final long serialVersionUID = 1L;
	LocationCDService locationCDService=new LocationCDService();
	private Locationmst locationmst=new Locationmst();
	private List<Locationmst> locationMstList=null;
	
	
	

	public List<Locationmst> getLocationMstList() {
		return locationMstList;
	}




	public void setLocationMstList(List<Locationmst> locationMstList) {
		this.locationMstList = locationMstList;
	}




	public LocationCDService getLocationCDService() {
		return locationCDService;
	}




	public void setLocationCDService(LocationCDService locationCDService) {
		this.locationCDService = locationCDService;
	}




	public Locationmst getLocationmst() {
		return locationmst;
	}




	public void setLocationmst(Locationmst locationmst) {
		this.locationmst = locationmst;
	}





	@Override
	public String execute() {
		// TODO Auto-generated method stub
		try{
		locationCDService.deleteClient(locationmst);
		locationMstList=locationCDService.getLocationList();
		
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return SUCCESS;
	}




	@Override
	public Locationmst getModel() {
		// TODO Auto-generated method stub
		return locationmst;
	}
	
	

}
