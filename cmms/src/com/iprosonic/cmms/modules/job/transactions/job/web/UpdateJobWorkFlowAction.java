package com.iprosonic.cmms.modules.job.transactions.job.web;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
import com.iprosonic.cmms.modules.job.transactions.job.domain.JobRigBean;
import com.iprosonic.cmms.modules.job.transactions.job.service.UpdateJobService;
import com.iprosonic.cmms.pjcommons.utility.WorkFlow;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UpdateJobWorkFlowAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private JobRigBean jobRigBean = new JobRigBean();
	UpdateJobService updateJobService = new UpdateJobService();

	public String execute() {
		HttpServletRequest request = (HttpServletRequest) ActionContext
				.getContext().get(ServletActionContext.HTTP_REQUEST);

		HttpServletResponse response = (HttpServletResponse) ActionContext
				.getContext().get(ServletActionContext.HTTP_RESPONSE);
		jobRigBean.setJobNo(request.getParameter("jobNo"));

		String jobStatus = null;
		String role = null;
		try {

			
			String jobNo = request.getParameter("jobNo");
			String status = request.getParameter("status");
		 	
			@SuppressWarnings("unchecked")
			Map<String ,Object> session = (Map<String ,Object>) ActionContext.getContext().get("session");
			role = (String) session.get("role");

			if (status.equalsIgnoreCase("Send to FSQC")) {
				updateJobService.updateJobStatus(jobNo,
						WorkFlow.PENDING_WITH_FSQC);
	        }
			if (status.equalsIgnoreCase("Send to ENG")){
				updateJobService.updateJobStatus(jobNo,
						WorkFlow.PENDING_WITH_ENGINEER);
			}

			if (status.equalsIgnoreCase("Close")){
				updateJobService.updateJobStatus(jobNo,
						WorkFlow.CLOSE_JOB);
			}
		
			if (status.equalsIgnoreCase("Delete Job")){
				updateJobService.updateJobStatus(jobNo,WorkFlow.DELETE_JOB);
			}
			
			
			request.setAttribute("message", "Job " + jobNo
					+ " status  updated succefully.");

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message",
					"Problem on server" + e.getMessage());

			return ERROR;
		}

		return SUCCESS;
	}

}
