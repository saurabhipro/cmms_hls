package com.iprosonic.cmms.modules.job.transactions.job.web;

import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringBufferInputStream;
import java.io.StringWriter;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.iprosonic.cmms.modules.job.transactions.job.domain.JobBean;
import com.iprosonic.cmms.modules.job.transactions.job.domain.JobExplBean;
import com.iprosonic.cmms.modules.job.transactions.job.domain.JobRigBean;
import com.iprosonic.cmms.modules.job.transactions.job.domain.JobRunBean;
import com.iprosonic.cmms.modules.job.transactions.job.domain.JobServiceBean;
import com.iprosonic.cmms.modules.job.transactions.job.domain.JobWellBean;
import com.iprosonic.cmms.modules.job.transactions.job.service.JobNumberingService;
import com.iprosonic.cmms.pjcommons.utility.DateUtil;
import com.iprosonic.cmms.pjcommons.utility.HibernateSession;
import com.iprosonic.cmms.pjcommons.utility.WorkFlow;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class SaveJobAction extends ActionSupport {

	private InputStream	inputStream	= null;

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	private static final long	serialVersionUID	= 1L;
	private JobNumberingService	saveJobService		= new JobNumberingService();

	public String execute() {
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		HttpServletResponse response = (HttpServletResponse) ActionContext.getContext().get(ServletActionContext.HTTP_RESPONSE);
		Transaction transaction = null;

		try {

			Session session = HibernateSession.getSessionFactory().openSession();
			transaction = session.beginTransaction();

			Set<JobRigBean> rigBeanSet = new HashSet<JobRigBean>();
			Set<JobRunBean> jobRunBeanSet = new HashSet<JobRunBean>();
			Set<JobServiceBean> jobServiceBeanSet = new HashSet<JobServiceBean>();
			Set<JobExplBean> jobExplBeanSet = new HashSet<JobExplBean>();

			JobBean jobBean = new JobBean();
			JobRigBean jobRigBean = null;
			JobRunBean jobRunBean = null;
			JobServiceBean jobServiceBean = null;
			JobExplBean jobExplBean = null;

			String rigIdFormat = "rig-1";// 5
			String runIdFormat = "rig-1-run-1";// 11
			String serIdFormat = "rig-1-run-1-ser-01";// 18
			String expIdFormat = "rig-1-run-1-ser-01-exp-1";

			request.getSession(true);
			HttpSession sessionData = request.getSession(true);
			if (sessionData.isNew()) {
				response.sendRedirect(response.encodeRedirectUrl("LoginAction.action"));
			}
			String unitNo = request.getParameter("unitNo").trim();
			String engineer = request.getParameter("engineer").trim();
			String crew = request.getParameter("crew").trim();
			String wellNo = request.getParameter("wellNo");
			String clientName = request.getParameter("clientName");
			String unitReachedBase = request.getParameter("unitReachedBase");
			String unitReachedSite = request.getParameter("unitReachedSite");
			String unitLeftBase = request.getParameter("unitLeftBase");
			String unitLeftSite = request.getParameter("unitLeftSite");
			String truckMileage = request.getParameter("truckMileage");
			String vanMileage = request.getParameter("vanMileage");
			String lostTime = request.getParameter("lostTime");
			String unitMileage = request.getParameter("unitMileage");

			String ejcs1 = request.getParameter("ejcs1");
			String ejcs2 = request.getParameter("ejcs2");
			String ejcs3 = request.getParameter("ejcs3");
			String ejcs4 = request.getParameter("ejcs4");

			String safetyMeet = request.getParameter("safetyMeet");
			String remarks = request.getParameter("remarks").trim();
			String jobNoHlsa = request.getParameter("jobNoHlsa");

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
			String deviation = request.getParameter("deviation");

			String rmValue = request.getParameter("rmValue");
			String rmTemp = request.getParameter("rmTemp");
			String rmf = request.getParameter("rmf");
			String rmc = request.getParameter("rmc");
			String solid = request.getParameter("solid");
			String jobDate = request.getParameter("jobDate");
			jobBean.setUnitNo(unitNo);
			String latestNo = saveJobService.genereateJobCd("JOB", unitNo);
			String jobNo = "JOB-" + unitNo + "-" + clientName + "-" + DateUtil.getCurrentMonth() + DateUtil.getCurrentYear() + "-" + latestNo;

			jobBean.setJobNo(jobNo.trim());
			jobBean.setEngineer(engineer);
			jobBean.setJobStatus(WorkFlow.PENDING_WITH_ENGINEER);
			if (jobDate == null) {
				jobDate = DateUtil.getCurrentDateWasCpi();
			}
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
			jobBean.setSafetyMeet(safetyMeet);
			jobBean.setRemarks(remarks);
			jobBean.setJobNoHlsa(jobNoHlsa);
			JobWellBean jobWellBean = new JobWellBean();
			jobWellBean.setHoleSize("NA");
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

			String rig = request.getParameter("hiddenRig");
			String run = request.getParameter("hiddenRun");
			String ser = request.getParameter("hiddenSer");
			String exp = request.getParameter("hiddenExpl");

			String rigArray[] = rig.split("/");
			String runArray[] = run.split("/");
			String serArray[] = ser.split("/");

			if (rig != "") {
				for (int i = 0; i < rigArray.length; i++) {
					String rigValArr[] = rigArray[i].split(",");
					jobRigBean = new JobRigBean();
					jobRigBean.setJobNo(jobNo.trim());
					jobRigBean.setRigNo(jobNo + "-" + rigValArr[0].substring(0, rigIdFormat.length()));
					jobRigBean.setRigUpStart(rigValArr[1]);
					jobRigBean.setRigUpEnd(rigValArr[2]);
					jobRigBean.setRigDownStart(rigValArr[3]);
					jobRigBean.setRigDownEnd(rigValArr[4]);
					jobRigBean.setOpTime(DateUtil.getOpTime(rigValArr[2], rigValArr[1]));
					rigBeanSet.add(jobRigBean);
				}
			}

			if (run != "") {
				for (int i = 0; i < runArray.length; i++) {
					String runValArr[] = runArray[i].split(",");
					jobRunBean = new JobRunBean();
					String rigNo = jobNo + "-" + runValArr[0].substring(0, rigIdFormat.length());
					String runNo = jobNo + "-" + runValArr[0].substring(0, runIdFormat.length());
					jobRunBean.setRigNo(rigNo);
					jobRunBean.setRunNo(runNo);
					jobRunBean.setJobNo(jobNo.trim());
					jobRunBean.setBht(runValArr[1].trim());
					jobRunBean.setRih(runValArr[2].trim());
					jobRunBean.setPooh(runValArr[3].trim());
					jobRunBean.setOt(DateUtil.getOpTime(runValArr[2], runValArr[3]));
					if (!runValArr[4].toString().equals("")) {
						jobRunBean.setWt(Double.parseDouble(runValArr[4]) + "");
					} else {
						jobRunBean.setWt(Double.parseDouble("0") + "");
					}
					jobRunBeanSet.add(jobRunBean);
				}
			}

			if (ser != "") {
				for (int i = 0; i < serArray.length; i++) {
					String serValArr[] = serArray[i].split(",");
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
			}

			if (exp != "") {
				String expArray[] = exp.split("/");
				for (int i = 0; i < expArray.length; i++) {
					jobExplBean = new JobExplBean();
					String expValArr[] = expArray[i].split(",");
					String serNo = jobNo + "-" + expValArr[0].substring(0, serIdFormat.length());
					String expNo = jobNo + "-" + expValArr[0].substring(0, expIdFormat.length());

					jobExplBean.setServiceNo(serNo);
					jobExplBean.setExplNo(expNo);
					jobExplBean.setPartCd(expValArr[1]);
					jobExplBean.setQty(expValArr[2]);
					jobExplBean.setUom(expValArr[3]);
					jobExplBean.setJobNo(jobNo.trim());
					jobExplBeanSet.add(jobExplBean);
				}
			}

			try {
				jobBean.setJobWellBean(jobWellBean);
				jobWellBean.setJobBean(jobBean);

				if (rigBeanSet.size() > 0) {
					jobBean.setJobRigBean(rigBeanSet);
				}
				if (jobRunBeanSet.size() > 0) {
					jobRigBean.setJobRunBeanSet(jobRunBeanSet);
				}
				if (jobServiceBeanSet.size() > 0) {
					jobRunBean.setJobServiceBeanSet(jobServiceBeanSet);
				}
				if (jobExplBeanSet.size() > 0) {
					jobServiceBean.setJobExplBeanSet(jobExplBeanSet);
				}
				session.save(jobBean);
				transaction.commit();
			} catch (Exception e) {
				transaction.rollback();
				e.printStackTrace();
				return ERROR;
			} finally {
				session.flush();
				session.clear();
				session.close();
			}
			String message = "Job No. " + jobNo + " generated succefully.";
			request.setAttribute("message", message);

		} catch (Exception e) {
			StringWriter sw = new StringWriter();
			e.printStackTrace(new PrintWriter(sw));
			String stacktrace = sw.toString();
			StringBufferInputStream sbis = new StringBufferInputStream(stacktrace);
			setInputStream(sbis);
			// transaction.rollback();
			String message = "Please add rig ,run and services  error occure at server -[" + e.getMessage() + "]";
			request.setAttribute("message", message);
			e.printStackTrace();
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