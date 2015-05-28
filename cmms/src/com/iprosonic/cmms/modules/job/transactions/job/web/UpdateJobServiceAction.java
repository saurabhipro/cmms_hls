package com.iprosonic.cmms.modules.job.transactions.job.web;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.iprosonic.cmms.modules.job.transactions.job.dao.JobServiceDaoImpl;
import com.iprosonic.cmms.modules.job.transactions.job.domain.JobServiceBean;
import com.iprosonic.cmms.pjcommons.utility.HibernateSession;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UpdateJobServiceAction extends ActionSupport implements
		ModelDriven<JobServiceBean> {

	private static final long serialVersionUID = 1L;
	private JobServiceBean jobServiceBean;
	JobServiceDaoImpl jobServiceDaoImpl = new JobServiceDaoImpl();

	public String execute() {
		HttpServletRequest request = (HttpServletRequest) ActionContext
				.getContext().get(ServletActionContext.HTTP_REQUEST);
		HttpServletResponse response = (HttpServletResponse) ActionContext
				.getContext().get(ServletActionContext.HTTP_RESPONSE);
		Session session= HibernateSession.getSessionFactory().openSession();
		Transaction transaction=session.beginTransaction();
		try {
			jobServiceBean=(JobServiceBean) session.get(JobServiceBean.class, request.getParameter("serviceNo").trim());
			jobServiceBean.setJobNo(request.getParameter("jobNo").trim());
			jobServiceBean.setRunNo(request.getParameter("runNo").trim());
			jobServiceBean.setServiceType(request.getParameter("serviceType"));
			jobServiceBean.setServiceName(request.getParameter("serviceName"));
			jobServiceBean.setLossTime(request.getParameter("lossTime"));
			jobServiceBean.setSerialNo(request.getParameter("serialNo"));
			jobServiceBean.setAssetCd(request.getParameter("assetCd").trim());
			jobServiceBean
					.setDeepestDepth(request.getParameter("deepestDepth"));
			jobServiceBean.setMeterageLogged(request
					.getParameter("meterageLogged"));
			jobServiceBean.setMeteragePerforated(request
					.getParameter("meteragePerforated"));

			jobServiceBean.setChruns(request.getParameter("chruns"));
			jobServiceBean.setChmisRuns(request.getParameter("chmisRuns"));
			jobServiceBean.setSpf(request.getParameter("spf"));
			jobServiceBean.setCoresCount(request.getParameter("coresCount"));
			jobServiceBean.setSurfacePressure(request
					.getParameter("surfacePressure"));
			jobServiceBean.setLevelCount(request.getParameter("levelCount"));
			jobServiceBean
					.setPretestCount(request.getParameter("pretestCount"));
			jobServiceBean
					.setDryTestCount(request.getParameter("dryTestCount"));
			jobServiceBean.setPumpOutTime(request.getParameter("pumpOutTime"));
			jobServiceBean.setPvtSample(request.getParameter("pvtSample"));
			jobServiceBean
					.setNormalSample(request.getParameter("normalSample"));
			jobServiceBean.setRev(request.getParameter("rev"));
			jobServiceBean.setRemarks(request.getParameter("remarks"));
			jobServiceBean
					.setFailureGroup(request.getParameter("failureGroup"));
			jobServiceBean.setLogSendFromBase(request
					.getParameter("logRcieveAtBase"));
			jobServiceBean.setLogRcieveAtHo(request
					.getParameter("logRcieveAtHo"));
			jobServiceBean.setLqaDoneDate(request.getParameter("lqaDoneDate"));
			jobServiceBean
					.setLqaTechnical(request.getParameter("lqaTechnical"));
			jobServiceBean.setLqaPresentation(request
					.getParameter("lqaPresentation"));
			jobServiceBean.setGunSize(request.getParameter("gunSize"));
			jobServiceBean.setSnpSnd(request.getParameter("snpSnd"));
			jobServiceBean.setEngi(request.getParameter("engi"));
			jobServiceBean.setCrew(request.getParameter("crew"));
			jobServiceBean.setTcpmissrun(request.getParameter("tcpmissrun"));
			session.saveOrUpdate(jobServiceBean);
			transaction.commit();
			PrintWriter out=  response.getWriter();
			out.write("Service updated successfully please close these window and referce parent window");
			out.flush();
			out.close();
			request.setAttribute("jobNo", request.getParameter("jobNo"));
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

	@Override
	public JobServiceBean getModel() {
		return jobServiceBean;
	}

}
