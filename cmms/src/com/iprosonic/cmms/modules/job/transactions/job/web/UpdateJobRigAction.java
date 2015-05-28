package com.iprosonic.cmms.modules.job.transactions.job.web;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.iprosonic.cmms.modules.job.transactions.job.domain.JobRigBean;
import com.iprosonic.cmms.modules.job.transactions.job.service.UpdateJobRigService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UpdateJobRigAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private JobRigBean jobRigBean = new JobRigBean();

	private UpdateJobRigService updateJobRigService = new UpdateJobRigService();

	public String execute() {

		HttpServletRequest request = (HttpServletRequest) ActionContext
				.getContext().get(ServletActionContext.HTTP_REQUEST);

		HttpServletResponse response = (HttpServletResponse) ActionContext
				.getContext().get(ServletActionContext.HTTP_RESPONSE);

		try {
			
			

			
			jobRigBean = new JobRigBean();
			jobRigBean.setJobNo(request.getParameter("jobNo").trim());
			jobRigBean.setRigNo(request.getParameter("rigNo").trim());
			jobRigBean.setRigUpStart(request.getParameter("rigUpStart"));
			jobRigBean.setRigUpEnd(request.getParameter("rigUpEnd"));
			jobRigBean.setRigDownStart(request.getParameter("rigDownStart"));
			jobRigBean.setRigDownEnd(request.getParameter("rigDownEnd"));
			updateJobRigService.updateRig(jobRigBean);
			
		    PrintWriter out=	response.getWriter();
		    out.write("Rig updated successfully please close these window and referce parent window");
			request.setAttribute("jobNo", request.getParameter("jobNo"));
			

		} catch (Exception e){
			e.printStackTrace();
		}

		return null;
	}
}
