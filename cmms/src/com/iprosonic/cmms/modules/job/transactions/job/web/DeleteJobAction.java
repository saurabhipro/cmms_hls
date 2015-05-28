package com.iprosonic.cmms.modules.job.transactions.job.web;

import java.sql.Connection;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import com.iprosonic.cmms.modules.job.transactions.job.domain.JobExplBean;
import com.iprosonic.cmms.modules.job.transactions.job.domain.JobRigBean;
import com.iprosonic.cmms.modules.job.transactions.job.domain.JobRunBean;
import com.iprosonic.cmms.modules.job.transactions.job.domain.JobServiceBean;
import com.iprosonic.cmms.modules.job.transactions.job.service.DatabaseConnection;
import com.iprosonic.cmms.pjcommons.utility.HibernateSession;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteJobAction extends ActionSupport {
	private static final long	serialVersionUID	= 1L;

	public String execute() {

		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		Connection con = null;
		Session session = HibernateSession.getSessionFactory().openSession();
		session.beginTransaction();

		try {
			con = DatabaseConnection.getConnection();
			String id = request.getParameter("id");
			if (id.contains("rig") && id.contains("run") && id.contains("ser") && id.contains("exp")) {
				JobExplBean jobExplBean = new JobExplBean();
				jobExplBean.setExplNo(id);
				session.delete(jobExplBean);

				SQLQuery sql = session.createSQLQuery("DELETE FROM jobservice_jobexpl WHERE jobExplBeanSet_explNo='" + id + "'");
				sql.executeUpdate();
			} else if (id.contains("rig") && id.contains("run") && id.contains("ser")) {
				JobServiceBean jobServiceBean = (JobServiceBean) session.get(JobServiceBean.class, new String(id));

				Statement st = con.createStatement();

				boolean f2 = st.execute("delete from jobrun_jobservice where jobServiceBeanSet_serviceNo='" + jobServiceBean.getServiceNo() + "'");

				boolean f1 = st.execute("delete from jobservice where serviceNo='" + jobServiceBean.getServiceNo() + "'");

				if (f1 && f2) {

				}

				con.close();
				// session.delete(jobServiceBean);

				/*
				 * SQLQuery query=
				 * session.createSQLQuery("DELETE FROM jobservice WHERE serviceNo='"
				 * +id+"'"); session.createSQLQuery(
				 * "DELETE FROM jobrun_jobservice WHERE jobServiceBeanSet_serviceNo='"
				 * +id+"'");
				 */
			} else if (id.contains("rig") && id.contains("run")) {
				JobRunBean jobRunBean = new JobRunBean();
				jobRunBean.setRunNo(id);
				session.delete(jobRunBean);

				Statement st = con.createStatement();

				st.execute("DELETE FROM jobrig_jobrun WHERE jobRunBeanSet_runNo='" + id + "'");

			} else if (id.contains("rig")) {
				JobRigBean jobRigBean = new JobRigBean();
				jobRigBean.setRigNo(id);
				session.delete(jobRigBean);

			}
			session.getTransaction().commit();
		} catch (Exception e) {

			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {

			session.close();

		}

		return null;
	}

}
