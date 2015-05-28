package com.iprosonic.cmms.modules.masters.location.web;



import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.iprosonic.cmms.modules.masters.client.domain.ClientMasterBean;
import com.iprosonic.cmms.modules.masters.client.service.SearchClientMaster;
import com.iprosonic.cmms.modules.masters.location.domain.Locationmst;
import com.iprosonic.cmms.modules.masters.location.service.LocationCDService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class SaveLocationMstAction extends ActionSupport implements ModelDriven<Locationmst>{

	
	private static final long serialVersionUID = 1L;
	private LocationCDService locationCDService=new LocationCDService();
	private Locationmst locationmst=new Locationmst();
	private List<Locationmst> locationMstList=null;
	
	
	
	




	public Locationmst getLocationmst() {
		return locationmst;
	}




	public void setLocationmst(Locationmst locationmst) {
		this.locationmst = locationmst;
	}







	public List<Locationmst> getLocationMstList() {
		return locationMstList;
	}




	public void setLocationMstList(List<Locationmst> locationMstList) {
		this.locationMstList = locationMstList;
	}




	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		if(locationCDService.getLocationById(locationmst.getId())){
			locationCDService.editLocation(locationmst);
		}else{
			locationCDService.saveLocationSer(locationmst);
		}
		locationMstList=locationCDService.getLocationList();
		
		return SUCCESS;
	}




	@Override
	public Locationmst getModel() {
		// TODO Auto-generated method stub
		
		return locationmst;
	}




	
	
 
}
