package com.iprosonic.cmms.modules.job.transactions.job.web;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.iprosonic.cmms.modules.job.transactions.job.dao.JobServiceDaoImpl;
import com.iprosonic.cmms.modules.job.transactions.job.domain.JobExplBean;
import com.iprosonic.cmms.modules.job.transactions.job.domain.JobServiceBean;
import com.iprosonic.cmms.modules.job.transactions.job.service.SearchJobService;
import com.iprosonic.cmms.modules.job.transactions.job.service.UpdateJobExplosive;
import com.iprosonic.cmms.modules.job.transactions.job.service.UpdateJobService;
import com.iprosonic.cmms.pjcommons.utility.HibernateSession;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class InsertServiceExplAction extends ActionSupport
		{

	private static final long serialVersionUID = 1L;
	private UpdateJobService updateJobService=new UpdateJobService();
	
	private SearchJobService searchJobService = new SearchJobService();
	JobServiceDaoImpl jobServiceDaoImpl = new JobServiceDaoImpl();

	public String execute() {
		HttpServletRequest request = (HttpServletRequest) ActionContext
				.getContext().get(ServletActionContext.HTTP_REQUEST);
		
		HttpServletResponse response = (HttpServletResponse) ActionContext
				.getContext().get(ServletActionContext.HTTP_RESPONSE);
		Session session= HibernateSession.getSessionFactory().openSession();
		Transaction transaction=session.beginTransaction();

		try {
			JobExplBean jobExpBean=new JobExplBean();
			String expid=request.getParameter("expno").trim();
			int len=expid.length();
			jobExpBean.setJobNo(request.getParameter("jobNo").trim());
			jobExpBean.setPartCd(request.getParameter("partNo").trim());
			jobExpBean.setQty(request.getParameter("qty"));
			jobExpBean.setUom(request.getParameter("uom"));
			jobExpBean.setServiceNo(request.getParameter("serviceNo").trim());
			Query q=session.createQuery("from JobExplBean where serviceNo=:service");
			q.setParameter("service", request.getParameter("serviceNo").trim());
			List<JobExplBean> list=q.list();
			Set<JobExplBean> ss = new HashSet<JobExplBean>(list);
			TreeSet<Integer> t = new TreeSet<Integer>();
			int SizeofEx=0;
			if (ss.size() == 0) {
				SizeofEx=1;
				
			} else {
				for (JobExplBean jeb : ss) {
			
					int i = jeb.getExplNo().toCharArray().length;
					String exNo = jeb.getExplNo().substring(i - 1);
					t.add(Integer.parseInt(exNo));
				}
				SizeofEx=t.last()+1;
			}
			
			String genExpId = request.getParameter("serviceNo").trim() + "-exp-" + SizeofEx + "";
			jobExpBean.setExplNo(genExpId);
			
			Query qq=session.createQuery("from JobServiceBean where serviceNo=:service");
			qq.setParameter("service", request.getParameter("serviceNo").trim());
			JobServiceBean jobServiceBean=(JobServiceBean) session.get(JobServiceBean.class, request.getParameter("serviceNo").trim());
			jobServiceBean.getJobExplBeanSet().add(jobExpBean);
			
			
			session.saveOrUpdate(jobServiceBean);
			
			/*String hqlQuery = "update JobServiceBean set jobStatus =:jobStatus WHERE serviceNo =:serviceNo";
			Query query = session.createQuery(hqlQuery);
			query.setString("jobStatus", jobStatus);
			query.setString("serviceNo", jobServiceBean);
			query.executeUpdate();*/
			
			transaction.commit();
			
			request.setAttribute("jobNo", request.getParameter("jobNo"));
			PrintWriter out=  response.getWriter();
			out.write("Exp Inserted successfully please close these window and referce parent window");
		/*	response.setIntHeader("Refresh", 2);*/
		} catch (Exception e) {
			e.printStackTrace();
		}finally
		{
			session.flush();
			session.clear();
			session.close();
		}

		
		return null;
	}


}
