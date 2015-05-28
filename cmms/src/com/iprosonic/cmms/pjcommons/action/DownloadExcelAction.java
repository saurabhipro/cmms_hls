package com.iprosonic.cmms.pjcommons.action;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.iprosonic.cmms.pjcommons.utility.DownloadExcelUtil;
import com.opensymphony.xwork2.ActionSupport;

public class DownloadExcelAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	public String downloadExcel() {
		HttpServletRequest request=null;
		try
		{
			ServletContext context = ServletActionContext.getServletContext();
			HttpServletResponse response = ServletActionContext.getResponse();
			request = ServletActionContext.getRequest();			
			String jobNo= request.getParameter("jobNo").toString();
			response.setContentType("application/octet-stream");
			response.setHeader("Content-Disposition", "attachment;filename="+jobNo + ".xls");
		    DownloadExcelUtil.downloadExcelUtil(context, response, jobNo);
				
		}
		catch (Exception e) {
			String message="Problem is on the server";
			request.setAttribute("message", message);
			
			e.printStackTrace();
			return ERROR;
		
		}
		
		return null;
	}
	public String downloadAllJob() {
		HttpServletRequest request=null;
		try
		{
			ServletContext context = ServletActionContext.getServletContext();
			HttpServletResponse response = ServletActionContext.getResponse();
			request = ServletActionContext.getRequest();
			HttpSession session=request.getSession(false);
			List jobList=(List) session.getAttribute("jobList");
			response.setContentType("application/octet-stream");
			response.setHeader("Content-Disposition", "attachment;filename=AllJobExcel.xls");
		    DownloadExcelUtil.downloadExcelAllJobUtil(context, response,jobList);
				
		}
		catch (Exception e) {
			String message="Problem is on the server";
			request.setAttribute("message", message);
			
			e.printStackTrace();
			return ERROR;
		
		}
		
		return null;
	}

}
