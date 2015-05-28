package com.iprosonic.cmms.pjcommons.action;

import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.iprosonic.cmms.modules.masters.location.domain.Locationmst;
import com.iprosonic.cmms.modules.masters.location.service.LocationCDService;
import com.opensymphony.xwork2.ActionSupport;

public class GetLocationNameAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private LocationCDService locationCDService = new LocationCDService();
	private List<Locationmst> locationMstList = null;
	private String output="";

	public List<Locationmst> getLocationMstList() {
		return locationMstList;
	}

	public void setLocationMstList(List<Locationmst> locationMstList) {
		this.locationMstList = locationMstList;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html");
		locationMstList = locationCDService.getLocationList();
		Iterator itr=locationMstList.iterator();
		while (itr.hasNext()) {
			Locationmst object = (Locationmst) itr.next();
			output=output+object.getLocationName()+":";
			
		}
		
		PrintWriter out = response.getWriter();
		out.print(output);
		return NONE;
	}

}
