package com.iprosonic.cmms.modules.job.transactions.job.dao;

import java.text.ParseException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.iprosonic.cmms.modules.job.transactions.job.domain.JobBean;
import com.iprosonic.cmms.modules.job.transactions.job.domain.JobRigBean;
import com.iprosonic.cmms.modules.job.transactions.job.domain.JobRunBean;
import com.iprosonic.cmms.modules.masters.user.domain.EmployeeBean;
import com.iprosonic.cmms.pjcommons.utility.DateUtil;
import com.iprosonic.cmms.pjcommons.utility.HibernateSession;

public class JobRunDaoImpl{
	private Session session;
	public JobRunBean getRunByNo(String runNo) throws Exception {
		JobRunBean jobRunBean = null;
		Session session = HibernateSession.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(JobRunBean.class);
		criteria.add(Restrictions.like("runNo", runNo));
		@SuppressWarnings("unchecked")
		Iterator<JobRunBean> itr = criteria.list().iterator();
		while (itr.hasNext()) {
			jobRunBean = itr.next();

		}
		session.close();
		HibernateSession.shoutDown();
		return jobRunBean;
	}

	public JobRunBean getRunByJobNo(String jobNo) throws Exception {
		JobRunBean jobRunBean = null;
		session = HibernateSession.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(JobRunBean.class);
		criteria.add(Restrictions.like("jobNo", jobNo));
		criteria.addOrder(Order.desc("runNo"));
		@SuppressWarnings("unchecked")
		Iterator<JobRunBean> itr = criteria.list().iterator();
		while (itr.hasNext()) {
			jobRunBean = itr.next();

		}
		session.close();
		HibernateSession.shoutDown();
		return jobRunBean;
	}

	public void updateJobRun(JobRunBean jobRunBean) {
		
		session = HibernateSession.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.update(jobRunBean);
		transaction.commit();
		session.flush();
		// session.evict(jobRunBean);
		session.flush();
		session.clear();
		session.close();

	}

	public String getJobBonusReport(String fromDate, String toDate, String jobNo) {
		int i = 0;
		String width = "100%";
		JobRigBean jobRigBean = null;
		String totalOpTime = "";
		StringBuffer stringBuffer = new StringBuffer();
		Session session = HibernateSession.getSessionFactory().openSession();

		stringBuffer
				.append("<div align='center' style='width: auto; height:600px;'>");
		stringBuffer
				.append("<div   class='CSSTableGenerator' style='width: 90%; height: auto;'>");

		stringBuffer.append("<table>");

		stringBuffer.append("<tr>");
		stringBuffer.append("<td>Job No</td>");
		stringBuffer.append("<td>Rig No</td>");
		stringBuffer.append("<td>OP Time</td>");
		stringBuffer.append("<td>Empoyee</td>");
		stringBuffer.append("<td>Role</td>");

		stringBuffer.append("</tr>");

		Set<JobRigBean> jobRigBeanSet = null;
		Criteria jobCriteria = session.createCriteria(JobBean.class);

		jobCriteria.add(Restrictions.ge("jobDate", fromDate));
		jobCriteria.add(Restrictions.le("jobDate", toDate));
		if (!jobNo.equalsIgnoreCase("-Select-")) {
			jobCriteria.add(Restrictions.like("jobNo", jobNo));
		}
		Integer hours = 0;
		Integer minutes = 0;

		String oipTime = null;
		List<JobBean> jobList = jobCriteria.list();
		Iterator<JobBean> jobItr = jobList.iterator();

		while (jobItr.hasNext()) {
			jobRigBeanSet = jobItr.next().getJobRigBean();

			Iterator<JobRigBean> jobRigItr = jobRigBeanSet.iterator();
			while (jobRigItr.hasNext()) {
				jobRigBean = jobRigItr.next();
				jobNo = jobRigBean.getJobNo();

				String ru = jobRigBean.getRigDownStart();
				String rd = jobRigBean.getRigDownEnd();

				try {
					totalOpTime = DateUtil.getTotalOpTime(ru, rd);

					hours += Integer.parseInt(totalOpTime.split(";")[0]);
					minutes = +Integer.parseInt(totalOpTime.split(";")[1]);

				} catch (ParseException e) {

					e.printStackTrace();
				}

				oipTime = jobRigBean.getOpTime();
				String rigNo = jobRigBean.getRigNo();
				Criteria jobRunCriteria = session
						.createCriteria(JobRunBean.class);
				jobRunCriteria.add(Restrictions.like("rigNo", rigNo));
				@SuppressWarnings("unchecked")
				Iterator<JobRunBean> jobRunItr = jobRunCriteria.list()
						.iterator();
				while (jobRunItr.hasNext()) {
					JobRunBean jobRunBean = jobRunItr.next();
					String userSortName = jobRunBean.getEngi()
							+ jobRunBean.getCrew();

					Set<EmployeeBean> userSet = getUserList(userSortName);
					getUserList(userSortName);

					

					for (EmployeeBean emp : userSet) {

						stringBuffer.append("<tr>");
						stringBuffer.append("<td>" + jobNo + "</td>");
						stringBuffer.append("<td>" + rigNo + "</td>");

						stringBuffer.append("<td>" + oipTime + "</td>");
						stringBuffer.append("<td>" + emp.getEmployeeShortName()
								+ "</td>");
						stringBuffer.append("<td>" + emp.getRoleCd() + "</td>");

						stringBuffer.append("</tr>");

					}

				}

			}
		}

		stringBuffer.append("<tr>");
		stringBuffer.append("<td></td>");
		stringBuffer.append("<td></td>");
		stringBuffer.append("<td>Gross Total time " + hours + "Hrs," + minutes
				+ "Mins</td>");
		stringBuffer.append("<td></td>");
		stringBuffer.append("<td></td>");
		stringBuffer.append("</tr>");

		stringBuffer.append("</div>");
		stringBuffer.append("</div>");

		stringBuffer.append("</table>");

		session.close();
		HibernateSession.shoutDown();

		return stringBuffer.toString();

	}

	@SuppressWarnings("unchecked")
	public Set<EmployeeBean> getUserList(String employeeShortName) {
		Set<EmployeeBean> set = new HashSet<EmployeeBean>();
		String[] crewArr = employeeShortName.split(";");
		Session session = HibernateSession.getSessionFactory().openSession();
		for (String empSortName : crewArr) {
			Criteria criteria = session.createCriteria(EmployeeBean.class);
			criteria.add(Restrictions.like("employeeShortName", empSortName));
			Iterator<EmployeeBean> itr = criteria.list().iterator();
			while (itr.hasNext()) {
				EmployeeBean employeeBean = itr.next();
				set.add(employeeBean);
			}
		}

		return set;
	}

	public Integer getRunCount(String jobNo) {
		Integer size = 0;
		Session session = HibernateSession.getSessionFactory().openSession();
		size = session.createCriteria(JobRunBean.class)
				.add(Restrictions.like("jobNo", jobNo)).list().size();
		return size;
	}

	public JobRunBean getLastRunNo(String jobNo){
		JobRunBean jobRunBean = null;
		session = HibernateSession.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(JobRunBean.class);
		criteria.add(Restrictions.like("jobNo", jobNo));
		criteria.addOrder(Order.desc("runNo"));
		jobRunBean = (JobRunBean) criteria.list().get(0);
		session.close();
		HibernateSession.shoutDown();
		return jobRunBean;
	}
	public List<JobRunBean> getRunList(){
		session = HibernateSession.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(JobRunBean.class);
		List l=criteria.list();
		session.close();
		HibernateSession.shoutDown();
		return l;
	}
	
}
