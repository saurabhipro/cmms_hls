package com.iprosonic.cmms.pjcommons.action;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import com.iprosonic.cmms.pjcommons.utility.Fusionutil;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class FusionChartsAction extends ActionSupport {

	
	
private static final long serialVersionUID = 1L;
private String enddate;
private String fromDate;	
private String serviceType;	   


	public String execute(){
		PrintWriter pw=null;
		
		HttpServletResponse resp = ServletActionContext.getResponse();
		resp.setContentType("text/html");
		try{
			pw=resp.getWriter();	
		
		}catch(Exception io){io.printStackTrace();}
		
		 ArrayList<String> charts= new Fusionutil().GetAllCharts(enddate,fromDate,serviceType);
		
		   Iterator<String> it=charts.iterator();
		   
		   while(it.hasNext()){
			   
			   pw.write(it.next()+";");
			   
		   }
		
		
		return null;
	}


	public String getEnddate() {
		return enddate;
	}


	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}


	public String getFromDate() {
		return fromDate;
	}


	public String getServiceType() {
		return serviceType;
	}


	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}


	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	
}
