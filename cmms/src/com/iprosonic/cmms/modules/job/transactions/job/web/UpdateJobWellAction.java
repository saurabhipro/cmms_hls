package com.iprosonic.cmms.modules.job.transactions.job.web;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.iprosonic.cmms.modules.job.transactions.job.domain.JobBean;
import com.iprosonic.cmms.modules.job.transactions.job.domain.JobWellBean;
import com.iprosonic.cmms.modules.job.transactions.job.service.JobNumberingService;
import com.iprosonic.cmms.pjcommons.utility.DateUtil;
import com.iprosonic.cmms.pjcommons.utility.HibernateSession;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UpdateJobWellAction extends ActionSupport {
	private static final long	serialVersionUID	= 1L;

	private JobNumberingService	saveJobService		= new JobNumberingService();

	public String updateJob() {
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		try {
			JobBean jobBean = new JobBean();
			Map sessionMap = (Map) ActionContext.getContext().get("session");
			String jobNoHlsa = request.getParameter("jobNoHlsa");
			String unitNo = request.getParameter("unitNo");
			String engineer = request.getParameter("engineer");
			String crew = request.getParameter("crew");
			String wellNo = request.getParameter("wellNo");
			String clientName = request.getParameter("clientName");
			String unitReachedBase = request.getParameter("unitReachedBase");
			String unitReachedSite = request.getParameter("unitReachedSite");
			String unitLeftBase = request.getParameter("unitLeftBase");
			String unitLeftSite = request.getParameter("unitLeftSite");
			String truckMileage = request.getParameter("truckMileage");
			String vanMileage = request.getParameter("vanMileage");
			String lostTime = request.getParameter("lostTime");
			String ejcs1 = request.getParameter("ejcs1");
			String ejcs2 = request.getParameter("ejcs2");
			String ejcs3 = request.getParameter("ejcs3");
			String ejcs4 = request.getParameter("ejcs4");
			String ejcs5 = request.getParameter("ejcs5");
			String unitMileage = request.getParameter("unitMileage");
			String safetyMeet = request.getParameter("safetyMeet");
			String remarks = request.getParameter("remarks");
			String jobStatus = request.getParameter("jobStatus");
			String jobNo = request.getParameter("jobNo");
			String jobDate = request.getParameter("jobDate");

			if (jobDate == null) {
				jobDate = DateUtil.getCurrentDateWasCpi();
			}
			jobBean.setJobDate(DateUtil.getJobDate(jobDate));
			jobBean.setJobNo(jobNo.trim());
			jobBean.setUnitNo(unitNo);
			jobBean.setEngineer(engineer.trim());
			jobBean.setJobNoHlsa(jobNoHlsa);
			jobBean.setJobStatus(jobStatus);
			jobBean.setCrew(crew);
			jobBean.setUnitNo(unitNo);
			jobBean.setWellNo(wellNo);
			jobBean.setClientName(clientName);
			jobBean.setUnitLeftBase(unitLeftBase);
			jobBean.setUnitLeftSite(unitLeftSite);
			jobBean.setUnitReachedBase(unitReachedBase);
			jobBean.setUnitReachedSite(unitReachedSite);
			jobBean.setTruckMileage(truckMileage);
			jobBean.setVanMileage(vanMileage);
			jobBean.setLostTime(lostTime);
			jobBean.setRemarks(remarks);
			jobBean.setEjcs1(ejcs1);
			jobBean.setEjcs2(ejcs2);
			jobBean.setEjcs3(ejcs3);
			jobBean.setEjcs4(ejcs4);

			double sum = toNumeric(ejcs1) + toNumeric(ejcs2) + toNumeric(ejcs3) + toNumeric(ejcs4);
			double av = sum / 4;
			jobBean.setEjcs5(av + "");

			jobBean.setSafetyMeet(safetyMeet);
			jobBean.setRemarks(remarks);

			/* ====== Setting values to Well Bean class ========= */

			Session session = HibernateSession.getSessionFactory().openSession();
			Transaction transaction = session.beginTransaction();

			try {

				session.saveOrUpdate(jobBean);
				String message = "Job No. " + jobNo + " updated succefully.";
				request.setAttribute("message", message);

			} catch (Exception e) {
				String message = "Exception" + e.getMessage();
				request.setAttribute("message", message);

				e.printStackTrace();
			}

			Query hQuery = session.createQuery("update JobRigBean set jobNo = :jobNo WHERE jobNo is NULL");
			hQuery.setString("jobNo", jobNo);
			hQuery.executeUpdate();
			transaction.commit();
			session.flush();
			session.close();
			HibernateSession.shoutDown();

		} catch (Exception e) {

			String message = "Please add rig ,run and services or error occure at server.";
			request.setAttribute("message", message);
			e.printStackTrace();

			return ERROR;

		}
		return SUCCESS;

	}

	public String updateWell() {
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);

		try {

			String holesize = request.getParameter("holesize");
			String field = request.getParameter("field");

			String latitude_d = request.getParameter("latitude_d");
			String latitude_m = request.getParameter("latitude_m");
			String latitude_s = request.getParameter("latitude_s");

			String longitude_d = request.getParameter("longitude_d");
			String longitude_m = request.getParameter("longitude_m");
			String longitude_s = request.getParameter("longitude_s");

			String kb = request.getParameter("kb");
			String dl = request.getParameter("dl");
			String td = request.getParameter("td");
			String casing_size = request.getParameter("casing_size");
			String casing_size_at_depth = request.getParameter("casing_size_at_depth");
			String rigName = request.getParameter("rigName");
			String tdDriller = request.getParameter("tdDriller");
			String csDriller = request.getParameter("csDriller");
			String wp = request.getParameter("wp");
			String bitSize = request.getParameter("bitSize");
			String startCirculation = request.getParameter("startCirculation");
			String stopCirculation = request.getParameter("stopCirculation");
			String gf = request.getParameter("gf");
			String density = request.getParameter("density");
			String viscosity = request.getParameter("viscosity");
			String ph = request.getParameter("ph");
			String salinity = request.getParameter("salinity");
			String barities = request.getParameter("barities");
			String rmValue = request.getParameter("rmValue");
			String rmTemp = request.getParameter("rmTemp");
			String rmf = request.getParameter("rmf");
			String rmc = request.getParameter("rmc");
			String solid = request.getParameter("solid");
			String jobNo = request.getParameter("jobNo");
			String deviation = request.getParameter("deviation");

			/* ====== Setting values to Well Bean class ========= */
			JobWellBean jobWellBean = new JobWellBean();
			jobWellBean.setHoleSize(holesize);
			jobWellBean.setJobNo(jobNo.trim());
			jobWellBean.setField(field);

			jobWellBean.setLatitude_d(latitude_d);
			jobWellBean.setLatitude_m(latitude_m);
			jobWellBean.setLatitude_s(latitude_s);

			jobWellBean.setLongitude_d(longitude_d);
			jobWellBean.setLongitude_m(longitude_m);
			jobWellBean.setLongitude_s(longitude_s);

			jobWellBean.setKb(kb);
			jobWellBean.setDl(dl);
			jobWellBean.setTd(td);
			jobWellBean.setCasingSize(casing_size);
			jobWellBean.setCasingSizeDepth(casing_size_at_depth);
			jobWellBean.setRigName(rigName);
			jobWellBean.setTdDriller(tdDriller);
			jobWellBean.setCsDriller(csDriller);
			jobWellBean.setWeekPoint(wp);
			jobWellBean.setBitSize(bitSize);
			jobWellBean.setStartCirculation(startCirculation);
			jobWellBean.setStopCirculation(stopCirculation);
			jobWellBean.setGf(gf);
			jobWellBean.setDensity(density);
			jobWellBean.setViscosity(viscosity);
			jobWellBean.setPh(ph);
			jobWellBean.setSalinity(salinity);
			jobWellBean.setBarities(barities);
			jobWellBean.setRmValue(rmValue);
			jobWellBean.setRmTemp(rmTemp);
			jobWellBean.setRmf(rmf);
			jobWellBean.setRmc(rmc);
			jobWellBean.setSolid(solid);
			jobWellBean.setDeviation(deviation);
			jobWellBean.setViscosity(viscosity);

			Session session = HibernateSession.getSessionFactory().openSession();
			Transaction transaction = session.beginTransaction();

			try {
				session.saveOrUpdate(jobWellBean);
				String message = "Job No. " + jobNo + " updated succefully.";
				request.setAttribute("message", message);

			} catch (Exception e) {
				String message = "Exception" + e.getMessage();
				request.setAttribute("message", message);
				return ERROR;
			}

			Query hQuery = session.createQuery("update JobRigBean set jobNo = :jobNo WHERE jobNo is NULL");
			hQuery.setString("jobNo", jobNo);
			hQuery.executeUpdate();
			transaction.commit();
			session.flush();
			session.close();
			HibernateSession.shoutDown();

		} catch (Exception e) {

			String message = "Please add rig ,run and services or error occure at server.";
			return ERROR;

		}
		return SUCCESS;

	}

	public double toNumeric(String data) {
		Double d = null;
		try {

			d = Double.parseDouble(data);
		} catch (Exception e) {

			return 0.0;
		}
		return d;
	}

}