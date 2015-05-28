package com.iprosonic.cmms.modules.job.transactions.job.web;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.iprosonic.cmms.modules.job.transactions.job.dao.JobRunDaoImpl;
import com.iprosonic.cmms.modules.job.transactions.job.dao.JobServiceDaoImpl;
import com.iprosonic.cmms.modules.job.transactions.job.domain.JobBean;
import com.iprosonic.cmms.modules.job.transactions.job.domain.JobExplBean;
import com.iprosonic.cmms.modules.job.transactions.job.domain.JobRigBean;
import com.iprosonic.cmms.modules.job.transactions.job.domain.JobRunBean;
import com.iprosonic.cmms.modules.job.transactions.job.domain.JobServiceBean;
import com.iprosonic.cmms.modules.job.transactions.job.domain.JobWellBean;
import com.iprosonic.cmms.modules.job.transactions.job.service.JobNumberingService;
import com.iprosonic.cmms.modules.job.transactions.job.service.SearchRigService;
import com.iprosonic.cmms.pjcommons.utility.DateUtil;
import com.iprosonic.cmms.pjcommons.utility.HibernateSession;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UpdateJobAction extends ActionSupport {

	private static final long	serialVersionUID	= 1L;
	private JobNumberingService	saveJobService		= new JobNumberingService();

	SearchRigService			searchRigService	= new SearchRigService();
	JobServiceDaoImpl			jobServiceDaoImpl	= new JobServiceDaoImpl();
	JobRunDaoImpl				jobRunDaoImpl		= new JobRunDaoImpl();

	@SuppressWarnings("unused")
	public String execute() {
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);

		String rigIdFormat = "rig-1";// 5
		String runIdFormat = "rig-1-run-1";// 11
		String serIdFormat = "rig-1-run-1-ser-01";// 18
		String expIdFormat = "rig-1-run-1-ser-01-exp-1";

		Session session = HibernateSession.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		try {
			JobBean jobBean = new JobBean();
			Map sessionMap = (Map) ActionContext.getContext().get("session");
			String jobId = request.getParameter("jobId");
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
			String safetyMeet = request.getParameter("safetyMeet");
			String remarks = request.getParameter("remarks");

			String jobDate = request.getParameter("jobDate");
			String jobStatus = request.getParameter("jobStatus");
			String deviation = request.getParameter("deviation");
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
			String mud = request.getParameter("mud");
			String density = request.getParameter("density");
			String viscosity = request.getParameter("viscosity");
			String ph = request.getParameter("ph");
			String salinity = request.getParameter("salinity");
			String barities = request.getParameter("barities");
			String mudResistivityParameters = request.getParameter("mudResistivityParameters");
			String rmValue = request.getParameter("rmValue");
			String rmTemp = request.getParameter("rmTemp");
			String rmf = request.getParameter("rmf");
			String rmc = request.getParameter("rmc");
			String solid = request.getParameter("solid");
			String jobNoHlsa = request.getParameter("jobNoHlsa");

			jobBean.setUnitNo(unitNo);
			String latestNo = saveJobService.getLatestNo("JOB", unitNo);
			String jobNo = request.getParameter("jobNo");
			String jobNoBase = "JOB-" + unitNo + "-" + clientName;
			jobBean.setJobNo(jobNo.trim());
			jobBean.setEngineer(engineer);
			jobBean.setJobNoHlsa(jobNoHlsa);
			jobBean.setJobStatus(jobStatus);

			jobBean.setJobDate(DateUtil.getJobDate(jobDate));

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
			jobBean.setEjcs1(ejcs1);
			jobBean.setEjcs2(ejcs2);
			jobBean.setEjcs3(ejcs3);
			jobBean.setEjcs4(ejcs4);

			double sum = toNumeric(ejcs1) + toNumeric(ejcs2) + toNumeric(ejcs3) + toNumeric(ejcs4);
			double av = sum / 4;
			jobBean.setEjcs5(av + "");

			/*
			 * jobBean.setEjcs5(((double)(Integer.parseInt(ejcs1)+Integer.parseInt
			 * (ejcs2)+ Integer.parseInt(ejcs3)+Integer.parseInt(ejcs4))/4)+"");
			 */

			jobBean.setSafetyMeet(safetyMeet);
			jobBean.setRemarks(remarks);

			/* ====== Setting values to Well Bean class ========= */
			JobWellBean jobWellBean = new JobWellBean();
			jobWellBean.setHoleSize(holesize);
			jobWellBean.setJobNo(jobNo.trim());
			jobWellBean.setField(field);
			
			jobWellBean.setLatitude_d(latitude_d);
			jobWellBean.setLatitude_m(latitude_m);
			jobWellBean.setLatitude_s(latitude_s);

			
			jobWellBean.setLongitude_d(longitude_d);
			jobWellBean.setLongitude_d(longitude_m);
			jobWellBean.setLongitude_d(longitude_s);
			
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

			String rig = request.getParameter("hiddenRig");
			String run = request.getParameter("hiddenRun");
			String ser = request.getParameter("hiddenSer");
			String exp = request.getParameter("hiddenExpl");

			String rigArray[] = rig.split("/");
			String runArray[] = run.split("/");
			String serArray[] = ser.split("/");

			HashSet<JobRigBean> rigBeanSet = new HashSet<JobRigBean>();
			JobRigBean jobRigBean = null;

			if (!rig.equalsIgnoreCase("")) {
				for (int i = 0; i < rigArray.length; i++) {
					String rigValArr[] = rigArray[i].split(",");
					jobRigBean = new JobRigBean();
					jobRigBean.setJobNo(jobNo.trim());
					jobRigBean.setRigNo(jobNo + "-" + rigValArr[0].substring(0, rigIdFormat.length()));
					jobRigBean.setRigUpStart(rigValArr[1]);
					jobRigBean.setRigUpEnd(rigValArr[2]);
					jobRigBean.setRigDownStart(rigValArr[3]);
					jobRigBean.setRigDownEnd(rigValArr[4]);
					jobRigBean.setOpTime(DateUtil.getOpTime(rigValArr[1], rigValArr[2]));
					rigBeanSet.add(jobRigBean);
				}
			} else {
				jobRigBean = searchRigService.getRigByJobNo(jobNo);
				rigBeanSet.add(jobRigBean);
			}

			Set<JobRunBean> jobRunBeanSet = new HashSet<JobRunBean>();
			JobRunBean jobRunBean = null;
			if (!run.equalsIgnoreCase("")) {
				for (int i = 0; i < runArray.length; i++) {
					String runValArr[] = runArray[i].split(",");
					jobRunBean = new JobRunBean();

					String rigNo = jobNo + "-" + runValArr[0].substring(0, rigIdFormat.length());
					String runNo = jobNo + "-" + runValArr[0].substring(0, runIdFormat.length());

					jobRunBean.setRigNo(rigNo);
					jobRunBean.setRunNo(runNo);
					jobRunBean.setJobNo(jobNo.trim());
					jobRunBean.setBht(runValArr[1]);
					jobRunBean.setRih(runValArr[2]);
					jobRunBean.setPooh(runValArr[3]);
					jobRunBean.setOt(DateUtil.getOpTime(runValArr[2], runValArr[3]));
					try {
						jobRunBean.setWt(Double.parseDouble((runValArr[5].equals("") ? 0.0 + "" : runValArr[5])) + "");
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						jobRunBean.setWt("0.0");
					}
					jobRunBeanSet.add(jobRunBean);
				}
			} else {
				jobRunBean = jobRunDaoImpl.getRunByJobNo(jobNo);
				jobRunBeanSet.add(jobRunBean);
			}

			Set<JobServiceBean> jobServiceBeanSet = new HashSet<JobServiceBean>();
			JobServiceBean jobServiceBean = null;
			System.out.println("***********" + serArray.length);
			if (!ser.equalsIgnoreCase("")) {
				for (int i = 0; i < serArray.length; i++) {
					String serValArr[] = serArray[i].split(",");

					int ii = 0;
					for (String string : serValArr) {

						ii++;
					}

					String runNo = jobNo + "-" + serValArr[0].substring(0, runIdFormat.length());
					String serNo = jobNo + "-" + serValArr[0].substring(0, serIdFormat.length());

					jobServiceBean = new JobServiceBean();
					jobServiceBean.setRunNo(runNo);
					jobServiceBean.setJobNo(jobNo.trim());
					jobServiceBean.setServiceNo(serNo);
					jobServiceBean.setServiceType(serValArr[1]);
					jobServiceBean.setServiceName(serValArr[2]);
					jobServiceBean.setLossTime(serValArr[3]);
					jobServiceBean.setDeepestDepth(serValArr[4]);
					jobServiceBean.setMeterageLogged(serValArr[5]);
					jobServiceBean.setRev(serValArr[6]);
					jobServiceBean.setFailureGroup(serValArr[7]);
					jobServiceBean.setPretestCount(serValArr[8]);
					jobServiceBean.setPumpOutTime(serValArr[9]);
					jobServiceBean.setDryTestCount(serValArr[10]);
					jobServiceBean.setPvtSample(serValArr[11]);
					jobServiceBean.setNormalSample(serValArr[12]);
					jobServiceBean.setLevelCount(serValArr[13]);
					jobServiceBean.setCoresCount(serValArr[14]);
					jobServiceBean.setGunSize(serValArr[15]);
					jobServiceBean.setSpf(serValArr[16]);
					jobServiceBean.setMeteragePerforated(serValArr[17]);
					jobServiceBean.setSurfacePressure(serValArr[18]);
					jobServiceBean.setChruns(serValArr[19]);
					jobServiceBean.setChmisRuns(serValArr[20]);
					jobServiceBean.setTcpmissrun(serValArr[21]);
					jobServiceBean.setAssetCd(serValArr[22]);
					jobServiceBean.setSerialNo(serValArr[23]);
					jobServiceBean.setEngi(serValArr[24]);
					jobServiceBean.setCrew(serValArr[25]);
					jobServiceBean.setLogSendFromBase(serValArr[27]);
					jobServiceBean.setRemarks(serValArr[26]);
					jobServiceBean.setLogRcieveAtHo(serValArr[28]);
					jobServiceBean.setLqaDoneDate(serValArr[29]);
					jobServiceBean.setLqaTechnical(serValArr[30]);
					jobServiceBean.setLqaPresentation(serValArr[31]);
					jobServiceBean.setSnpSnd(serValArr[32]);

					jobServiceBeanSet.add(jobServiceBean);

				}
			} else {
				if (jobServiceBean != null) {
					jobServiceBean = jobServiceDaoImpl.getServiceByRunNo(jobNo);
					jobServiceBeanSet.add(jobServiceBean);
				}
				jobServiceBean = jobServiceDaoImpl.getServiceByRunNo(jobNo);
			}

			JobExplBean jobExplBean = null;

			if (exp != "") {
				String expArray[] = exp.split("/");
				if (ser.equalsIgnoreCase("")) {
					jobServiceBean = jobServiceDaoImpl.getServiceByRunNo(jobNo);

				}
				for (int i = 0; i < expArray.length; i++) {
					jobExplBean = new JobExplBean();
					String expValArr[] = expArray[i].split(",");
					String expNo = jobNo + "-" + expValArr[0].substring(0, expIdFormat.length());
					String serNo = jobNo + "-" + expValArr[0].substring(0, serIdFormat.length());

					jobExplBean.setServiceNo(jobServiceBean.getSerialNo());

					jobExplBean.setServiceNo(serNo);
					jobExplBean.setExplNo(expNo);
					jobExplBean.setJobNo(jobNo.trim());
					jobExplBean.setPartCd(expValArr[1]);
					jobExplBean.setQty(expValArr[2]);
					jobExplBean.setUom(expValArr[3]);
					// Hibernate.initialize(jobBean.get);
					jobServiceBean.getJobExplBeanSet().add(jobExplBean);
				}
			}

			try {

				jobBean.setJobWellBean(jobWellBean);
				jobWellBean.setJobBean(jobBean);
				jobBean.setJobRigBean(rigBeanSet);
				jobRigBean.setJobRunBeanSet(jobRunBeanSet);

				if (jobRunBean != null) {
					jobRunBean.setJobServiceBeanSet(jobServiceBeanSet);
				}
				if (!exp.equalsIgnoreCase("")) {
					session.saveOrUpdate(jobServiceBean);
				}

				session.saveOrUpdate(jobBean);
				String message = "Job No. " + jobNo + " updated successfully.";
				request.setAttribute("message", message);
			} catch (Exception e) {
				String message = "Exception" + e.getMessage();
				request.setAttribute("message", message);
				e.printStackTrace();
			}
			Query hQuery = null;

			if (jobRunBean != null) {
				transaction = session.beginTransaction();
				// Hibernate.initialize(jobBean);
				hQuery = session.createQuery("update JobRigBean set jobNo = :jobNo WHERE jobNo is NULL");
				hQuery.setString("jobNo", jobNo);
				hQuery.executeUpdate();
				transaction.commit();
			}

			if (jobServiceBean != null) {
				transaction = session.beginTransaction();
				// Hibernate.initialize(jobServiceBean);
				hQuery = session.createQuery("update JobExplBean set serviceNo = :serviceNo WHERE serviceNo is NULL");
				hQuery.setString("serviceNo", jobServiceBean.getServiceNo());
				hQuery.executeUpdate();
				transaction.commit();
			}

		} catch (Exception e) {
			String message = e.getMessage();
			e.printStackTrace();
			request.setAttribute("message", message);
			return ERROR;
		} finally {
			session.flush();
			session.clear();
			session.close();
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
