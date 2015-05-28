package com.iprosonic.cmms.modules.job.transactions.job.web;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;

import com.iprosonic.cmms.modules.job.transactions.job.domain.JobBean;
import com.iprosonic.cmms.modules.job.transactions.job.service.DatabaseConnection;
import com.iprosonic.cmms.pjcommons.utility.HibernateSession;
import com.mysql.jdbc.PreparedStatement;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteJob extends ActionSupport {
	private static final long serialVersionUID = 1L;
 

	public String execute() {
		HttpServletRequest request = (HttpServletRequest) ActionContext
				.getContext().get(ServletActionContext.HTTP_REQUEST);
		HttpServletResponse responce = (HttpServletResponse) ActionContext
				.getContext().get(ServletActionContext.HTTP_RESPONSE);

		Map session = (Map) ActionContext.getContext().get("session");
		String jobNo = request.getParameter("jobNo");
		
		Session hibernateSession= HibernateSession.getSessionFactory().openSession();
		try {
			hibernateSession.beginTransaction();
			JobBean jobBean=(JobBean) hibernateSession.load(JobBean.class, jobNo);
			jobBean.setJobStatus("DELETED");
			hibernateSession.saveOrUpdate(jobBean);
			hibernateSession.getTransaction().commit();
			
			String message = "Job No. " + jobNo + " deleted succefully.";
			request.setAttribute("message", message);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			hibernateSession.getTransaction().rollback();
			request.setAttribute("message", "Error : "+e.getMessage());
			
		}finally{
			if(hibernateSession.isOpen()){
				hibernateSession.close();
			}
		}

		return SUCCESS;
	}

	 

}
