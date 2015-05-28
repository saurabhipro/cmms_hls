package com.iprosonic.cmms.modules.job.transactions.job.web;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.iprosonic.cmms.modules.job.transactions.job.domain.JobExplBean;
import com.iprosonic.cmms.modules.job.transactions.job.service.UpdateJobExplosive;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UpdateJobExplosiveAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private JobExplBean jobExplBean = new JobExplBean();
	private UpdateJobExplosive updateJobExplosive = new UpdateJobExplosive();

	public String execute() {
		HttpServletRequest request = (HttpServletRequest) ActionContext
				.getContext().get(ServletActionContext.HTTP_REQUEST);

		HttpServletResponse responce = (HttpServletResponse) ActionContext
				.getContext().get(ServletActionContext.HTTP_RESPONSE);

		System.out
				.println("---------------UpdateJobServiceAction------------------------");
		try {
			jobExplBean.setJobNo(request.getParameter("jobNo"));
			
			jobExplBean.setServiceNo(request.getParameter("serviceNo"));
			jobExplBean.setExplNo(request.getParameter("explNo"));
			jobExplBean.setExplStatus(request.getParameter("explStatus"));
			jobExplBean.setPartCd(request.getParameter("partCd"));
			jobExplBean.setQty(request.getParameter("qty"));
			jobExplBean.setUom(request.getParameter("uom"));
			updateJobExplosive.updateJobExplosive(jobExplBean);
			request.setAttribute("jobNo", request.getParameter("jobNo"));

			PrintWriter out = responce.getWriter();
			out.write("Explosive updated successfully please close these window and referce parent window manually");

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

}
