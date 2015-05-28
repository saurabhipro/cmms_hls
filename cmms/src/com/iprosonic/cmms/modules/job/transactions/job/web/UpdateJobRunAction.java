package com.iprosonic.cmms.modules.job.transactions.job.web;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.iprosonic.cmms.modules.job.transactions.job.domain.JobRunBean;
import com.iprosonic.cmms.modules.job.transactions.job.service.UpdateJobRunService;
import com.iprosonic.cmms.pjcommons.utility.DateUtil;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UpdateJobRunAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private JobRunBean jobRunBean = new JobRunBean();
	private UpdateJobRunService updateJobRunService = new UpdateJobRunService();

	public String execute() {
		HttpServletRequest request = (HttpServletRequest) ActionContext
				.getContext().get(ServletActionContext.HTTP_REQUEST);
		HttpServletResponse response = (HttpServletResponse) ActionContext
				.getContext().get(ServletActionContext.HTTP_RESPONSE);
		try {
			jobRunBean.setJobNo(request.getParameter("jobNo"));
			jobRunBean.setRunNo(request.getParameter("runNo"));
			jobRunBean.setRigNo(request.getParameter("rigNo"));
			jobRunBean.setRunStatus(request.getParameter("runStatus"));
//			jobRunBean.setEngi(request.getParameter("engin").trim());
//			jobRunBean.setCrew(request.getParameter("crew").trim());
			jobRunBean.setBht(request.getParameter("bht"));
			jobRunBean.setRih(request.getParameter("rih"));
			jobRunBean.setPooh(request.getParameter("pooh"));
			jobRunBean.setWt(request.getParameter("wt"));
			jobRunBean.setOt(DateUtil.getOpTime(request.getParameter("rih"),
					request.getParameter("pooh")));

			updateJobRunService.updatejobRun(jobRunBean);
			request.setAttribute("jobNo", request.getParameter("jobNo"));
			request.setAttribute("jobNo", request.getParameter("jobNo"));
						
		    PrintWriter out= response.getWriter();
			out.write("Run updated successfully please close these window and referce parent window manually");

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

}
