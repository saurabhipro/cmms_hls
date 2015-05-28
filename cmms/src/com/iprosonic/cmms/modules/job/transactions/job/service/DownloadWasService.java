package com.iprosonic.cmms.modules.job.transactions.job.service;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellRangeAddress;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.hibernate.Criteria;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;

import com.iprosonic.cmms.modules.job.transactions.job.domain.JobBean;
import com.iprosonic.cmms.modules.job.transactions.job.domain.JobExplBean;
import com.iprosonic.cmms.modules.job.transactions.job.domain.JobRigBean;
import com.iprosonic.cmms.modules.job.transactions.job.domain.JobRunBean;
import com.iprosonic.cmms.modules.job.transactions.job.domain.JobServiceBean;
import com.iprosonic.cmms.modules.job.transactions.job.domain.JobWellBean;
import com.iprosonic.cmms.pjcommons.utility.HibernateSession;

public class DownloadWasService {

	static boolean	jobMergeEnable	= false;
	static boolean	rigMergeEnable	= false;
	static boolean	runMergeEnable	= false;
	static boolean	serMergeEnable	= false;

	static String	jobHeader[]		= { "Service No", "Unit No", "Hlsa Job No", "Well No", "Client Name", "Unit Left Base", "Unit Reached WellSite", "Unit Reached Base",
			"Unit Left BaseSite", "Truck Milage", "Van Milage", "Rig Up Start", "Rig Up End", "Rig Down Start", "Rig Down End", "Eng1", "Eng2", "Eng3", "Eng4", "Crew1", "Crew2",
			"Crew3", "Crew4", "Crew5", "Crew6", "Crew7", "BHT", "Operating time start", "Operating time stop", "OT", "WT", "Service Type", "Service Name", "Loss Time",
			"Serial No", "Asset Cd", "Deepest Depth", "Meterage Logged", "Meterage Perforated", "CH Runs", "CH Mis Runs", "SPF", "Cores Count", "Surface Pressure", "Level Count",
			"Pretest Count", "DryTest Count", "Pump Out Time", "PVT Sample", "Normal Sample", "Rev($)", "Failure Group", "Gun Size", "Log Send from  Base:", "Log recieved at HO",
			"LQA Done date", "LQA Technical", "LQA Presentation", "SND SNP", "Remarks", "EJCS1", "EJCS2", "EJCS3", "EJCS4", "EJCS5", "SafetyMeet", "HoleSize", "Field", "Lat",
			"Long", "KB(m)", "DL(m)", "CasingSize", "CS Depth(m)", "Rig Name", "Td driller", "C S driller", "Week Point", "Bit size", "Deviation", "Start circulation",
			"Stop circulation", "GF", "Density", "RM(value)", "PH", "Salinity", "Barities", "RM(temp)", "RMF(value)", "RMC(temp)", "Solid" };

	public static Integer getServiceCountByRunNo(String runNo) {
		Integer count = 0;
		Session session = HibernateSession.getSessionFactory().openSession();
		Criteria criteria1 = session.createCriteria(JobServiceBean.class);
		criteria1.add(Restrictions.like("runNo", runNo));

		List<JobServiceBean> list1 = criteria1.list();
		Iterator<JobServiceBean> jobServiceItr = list1.iterator();

		while (jobServiceItr.hasNext()) {
			jobServiceItr.next();
			count++;
		}
		return count;
	}

	public static Integer getServiceCountByRigNo(String rigNo) {
		Integer count = 0;
		Session session = HibernateSession.getSessionFactory().openSession();
		Criteria criteria1 = session.createCriteria(JobRunBean.class);
		criteria1.add(Restrictions.like("rigNo", rigNo));

		List<JobRunBean> list1 = criteria1.list();
		Iterator<JobRunBean> jobRunItr = list1.iterator();

		while (jobRunItr.hasNext()) {
			JobRunBean jobRunBean = jobRunItr.next();
			Criteria criteria2 = session.createCriteria(JobServiceBean.class);
			criteria2.add(Restrictions.like("runNo", jobRunBean.getRunNo()));
			List<JobServiceBean> list2 = criteria2.list();
			Iterator<JobServiceBean> jobServiceItr = list2.iterator();
			while (jobServiceItr.hasNext()) {
				jobServiceItr.next();
				count++;
			}
		}
		return count;
	}

	public static SortedSet<String> getRigSet(String jobNo) {
		Integer size = 0;
		String rig_No = ";";
		Session session = HibernateSession.getSessionFactory().openSession();
		@SuppressWarnings("unchecked")
		List<JobRigBean> list = session.createCriteria(JobRigBean.class).add(Restrictions.like("jobNo", jobNo)).list();
		Collections.sort(list, new Comparator<JobRigBean>() {
			@Override
			public int compare(JobRigBean obj1, JobRigBean obj2) {
				return obj1.getRigNo().compareTo(obj2.getRigNo());

			}
		});

		SortedSet<String> sortedSet = new TreeSet<String>();
		Iterator<JobRigBean> itr = list.iterator();
		while (itr.hasNext()) {
			sortedSet.add(itr.next().getRigNo());
		}

		return sortedSet;
	}

	public static String getRunByRigNo(String rigNo) {
		String runNo = null;
		Session session = HibernateSession.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(JobRunBean.class).add(Restrictions.like("rigNo", rigNo));
		List<JobRunBean> list = criteria.list();
		Iterator<JobRunBean> itr = list.iterator();

		while (itr.hasNext()) {

			runNo = itr.next().getRunNo();
		}
		return runNo;
	}

	public static Integer getRigCount(String jobNo) {
		Integer size = 0;
		Session session = HibernateSession.getSessionFactory().openSession();
		size = session.createCriteria(JobRigBean.class).add(Restrictions.like("jobNo", jobNo)).list().size();
		return size;
	}

	public static Integer getRunCount(String rigNo) {
		Integer size = 0;
		Session session = HibernateSession.getSessionFactory().openSession();
		size = session.createCriteria(JobRunBean.class).add(Restrictions.like("rigNo", rigNo)).list().size();
		return size;
	}

	public static Integer getServiceCount(String runNo) {
		Integer size = 0;
		Session session = HibernateSession.getSessionFactory().openSession();
		size = session.createCriteria(JobServiceBean.class).add(Restrictions.like("runNo", runNo)).list().size();
		return size;

	}

	public static Integer getAllServices(String jobNo) {
		Integer size = 0;
		Session session = HibernateSession.getSessionFactory().openSession();
		size = session.createCriteria(JobServiceBean.class).add(Restrictions.like("jobNo", jobNo)).list().size();
		return size;
	}

	public static Integer getAllRuns(String jobNo) {
		Integer size = 0;
		Session session = HibernateSession.getSessionFactory().openSession();
		size = session.createCriteria(JobRunBean.class).add(Restrictions.like("jobNo", jobNo)).list().size();
		return size;
	}

	public static Integer getExplosiveCount(String serNo) {
		Integer size = 0;
		Session session = HibernateSession.getSessionFactory().openSession();
		size = session.createCriteria(JobExplBean.class).add(Restrictions.like("serviceNo", serNo)).list().size();
		return size;
	}

	// Created By Arpit Kumar

	public static void genrateAllWas(List jobList, String filePath) {

		try {
			FileOutputStream fileOut = null;

			fileOut = new FileOutputStream(filePath);
			HSSFWorkbook wb = new HSSFWorkbook();
			HSSFSheet sheet = wb.createSheet();
			HSSFCellStyle styleHeader = wb.createCellStyle();
			styleHeader.setRotation((short) 90);
			styleHeader.setFillForegroundColor(HSSFColor.AQUA.index);
			styleHeader.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
			styleHeader.setBorderBottom(CellStyle.BORDER_THIN);
			styleHeader.setBottomBorderColor(IndexedColors.BLACK.getIndex());
			styleHeader.setBorderLeft(CellStyle.BORDER_THIN);
			styleHeader.setLeftBorderColor(IndexedColors.GREEN.getIndex());
			styleHeader.setBorderRight(CellStyle.BORDER_THIN);
			styleHeader.setRightBorderColor(IndexedColors.BLUE.getIndex());
			styleHeader.setBorderTop(CellStyle.BORDER_MEDIUM_DASHED);
			styleHeader.setTopBorderColor(IndexedColors.BLACK.getIndex());

			HSSFCellStyle styleRedHeader = wb.createCellStyle();
			styleRedHeader.setRotation((short) 90);
			styleRedHeader.setFillForegroundColor(HSSFColor.RED.index);
			styleRedHeader.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
			styleRedHeader.setBorderBottom(CellStyle.BORDER_THIN);
			styleRedHeader.setBottomBorderColor(IndexedColors.BLACK.getIndex());
			styleRedHeader.setBorderLeft(CellStyle.BORDER_THIN);
			styleRedHeader.setLeftBorderColor(IndexedColors.GREEN.getIndex());
			styleRedHeader.setBorderRight(CellStyle.BORDER_THIN);
			styleRedHeader.setRightBorderColor(IndexedColors.BLUE.getIndex());
			styleRedHeader.setBorderTop(CellStyle.BORDER_MEDIUM_DASHED);
			styleRedHeader.setTopBorderColor(IndexedColors.BLACK.getIndex());

			HSSFCellStyle styleCommon90 = wb.createCellStyle();
			styleCommon90.setRotation((short) 90);
			styleCommon90.setFillForegroundColor(HSSFColor.YELLOW.index);
			styleCommon90.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
			styleCommon90.setBorderBottom(CellStyle.BORDER_THIN);
			styleCommon90.setBottomBorderColor(IndexedColors.BLACK.getIndex());
			styleCommon90.setBorderLeft(CellStyle.BORDER_THIN);
			styleCommon90.setLeftBorderColor(IndexedColors.GREEN.getIndex());
			styleCommon90.setBorderRight(CellStyle.BORDER_THIN);
			styleCommon90.setRightBorderColor(IndexedColors.BLUE.getIndex());
			styleCommon90.setBorderTop(CellStyle.BORDER_MEDIUM_DASHED);
			styleCommon90.setTopBorderColor(IndexedColors.BLACK.getIndex());

			HSSFCellStyle styleCommon = wb.createCellStyle();
			styleCommon90.setRotation((short) 90);
			styleCommon.setFillForegroundColor(HSSFColor.YELLOW.index);
			styleCommon.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
			styleCommon.setBorderBottom(CellStyle.BORDER_THIN);
			styleCommon.setBottomBorderColor(IndexedColors.BLACK.getIndex());
			styleCommon.setBorderLeft(CellStyle.BORDER_THIN);
			styleCommon.setLeftBorderColor(IndexedColors.GREEN.getIndex());
			styleCommon.setBorderRight(CellStyle.BORDER_THIN);
			styleCommon.setRightBorderColor(IndexedColors.BLUE.getIndex());
			styleCommon.setBorderTop(CellStyle.BORDER_MEDIUM_DASHED);
			styleCommon.setTopBorderColor(IndexedColors.BLACK.getIndex());
			Font font = wb.createFont();
			font.setBoldweight(Font.BOLDWEIGHT_BOLD);

			int rowNum = 0;
			HSSFRow row = null;
			HSSFCell cell = null;
			row = sheet.createRow(rowNum++);
			for (int i = 0; i < jobHeader.length; i++) {
				cell = row.createCell(i);
				cell.setCellValue(jobHeader[i]);
				cell.setCellStyle(styleHeader);
				sheet.setColumnWidth(i, (2000));
			}
			int rowCounter = 1;
			Iterator<JobBean> itrbean = jobList.iterator();
			while (itrbean.hasNext()) {
				JobBean jobBean = (JobBean) itrbean.next();
				String jobNo = jobBean.getJobNo();
				JobWellBean jobWellBean = new JobWellBean();
				SearchJobService searchJobService = new SearchJobService();
				EditJobService editJobService = new EditJobService();
				jobBean = searchJobService.getJobBean(jobNo);
				jobWellBean = searchJobService.getJobWellBean(jobNo);
				String[] rigToExplosive = new String[5];
				Session session = HibernateSession.getSessionFactory().openSession();
				Criteria jobRigCriteria = session.createCriteria(JobRigBean.class);
				jobRigCriteria.add(Restrictions.like("jobNo", jobNo));
				List<JobRigBean> list = jobRigCriteria.list();
				Collections.sort(list, new Comparator<JobRigBean>() {
					@Override
					public int compare(JobRigBean obj1, JobRigBean obj2) {
						return obj1.getRigNo().compareTo(obj2.getRigNo());
					}
				});

				Iterator<JobRigBean> jobRigItr = list.iterator();
				Integer rigCount = list.size();
				Integer runCount = 0;
				Integer serviceCount = 0;
				Integer explosiveCount = 0;
				/* int rowCounter = 1; */

				while (jobRigItr.hasNext()) {
					int cellCounter = 0;
					JobRigBean jobRigBean = jobRigItr.next();
					String rigNo = jobRigBean.getRigNo();
					Criteria jobRunCriteria = session.createCriteria(JobRunBean.class);
					jobRunCriteria.add(Restrictions.like("rigNo", rigNo));
					List<JobRunBean> runList = jobRunCriteria.list();
					Collections.sort(runList, new Comparator<JobRunBean>() {
						@Override
						public int compare(JobRunBean obj1, JobRunBean obj2) {
							return obj1.getRunNo().compareTo(obj2.getRunNo());
						}
					});

					Iterator<JobRunBean> jobRunItr = runList.iterator();
					serviceCount = DownloadWasService.getServiceCount(jobNo);
					runCount = 0;

					while (jobRunItr.hasNext()) {
						JobRunBean jobRunBean = jobRunItr.next();
						String runNo = jobRunBean.getRunNo();
						Criteria jobServiceCriteria = session.createCriteria(JobServiceBean.class);
						jobServiceCriteria.add(Restrictions.like("runNo", runNo));
						@SuppressWarnings("unchecked")
						List<JobServiceBean> jobServiceList = jobServiceCriteria.list();
						Collections.sort(jobServiceList, new Comparator<JobServiceBean>() {
							@Override
							public int compare(JobServiceBean obj1, JobServiceBean obj2) {
								return obj1.getServiceNo().compareTo(obj2.getServiceNo());
							}
						});

						Set<JobServiceBean> jobserviceset = new HashSet<JobServiceBean>(jobServiceList);
						Iterator<JobServiceBean> jobServiceItr = jobserviceset.iterator();
						while (jobServiceItr.hasNext()) {
							JobServiceBean jobServiceBean = jobServiceItr.next();
							String serviceNo = jobServiceBean.getServiceNo();
							Criteria jobExplCriteria = session.createCriteria(JobExplBean.class);
							jobExplCriteria.add(Restrictions.like("serviceNo", serviceNo));
							@SuppressWarnings("unchecked")
							List<JobExplBean> explList = jobExplCriteria.list();
							Collections.sort(explList, new Comparator<JobExplBean>() {
								@Override
								public int compare(JobExplBean obj1, JobExplBean obj2) {
									return obj1.getExplNo().compareTo(obj2.getExplNo());
								}
							});
							Iterator<JobExplBean> jobExplItr = explList.iterator();
							row = sheet.createRow(rowCounter++);
							cellCounter = 0;

							// -------------------------------------JOB_BEAN------------------------------------->
							cell = row.createCell(cellCounter);
							cell.setCellValue(jobServiceBean.getServiceNo());
							cell.setCellStyle(styleCommon);
							cellCounter++;

							cell = row.createCell(cellCounter);
							cell.setCellValue(jobBean.getUnitNo());
							cell.setCellStyle(styleCommon);
							cellCounter++;
							cell = row.createCell(cellCounter);
							cell.setCellValue(jobBean.getJobNoHlsa());
							cell.setCellStyle(styleCommon);
							cellCounter++;
							cell = row.createCell(cellCounter);
							cell.setCellValue(jobBean.getWellNo());
							cell.setCellStyle(styleCommon);
							cellCounter++;
							cell = row.createCell(cellCounter);
							cell.setCellValue(jobBean.getClientName());
							cell.setCellStyle(styleCommon);
							cellCounter++;
							cell = row.createCell(cellCounter);
							cell.setCellValue(jobBean.getUnitLeftBase());
							cell.setCellStyle(styleCommon);
							cellCounter++;
							cell = row.createCell(cellCounter);
							cell.setCellValue(jobBean.getUnitReachedSite());
							cell.setCellStyle(styleCommon);
							cellCounter++;
							cell = row.createCell(cellCounter);
							cell.setCellValue(jobBean.getUnitReachedBase());
							cell.setCellStyle(styleCommon);
							cellCounter++;
							cell = row.createCell(cellCounter);
							cell.setCellValue(jobBean.getUnitLeftSite());
							cell.setCellStyle(styleCommon);
							cellCounter++;
							cell = row.createCell(cellCounter);
							cell.setCellValue(jobBean.getTruckMileage());
							cell.setCellStyle(styleCommon);
							cellCounter++;
							cell = row.createCell(cellCounter);
							cell.setCellValue(jobBean.getVanMileage());
							cell.setCellStyle(styleCommon);
							cellCounter++;

							// ------------------------------------------------RIG_NO---------------------------------------------

							cell = row.createCell(cellCounter);
							cell.setCellValue(jobRigBean.getRigUpStart());
							cell.setCellStyle(styleCommon);
							cellCounter++;
							cell = row.createCell(cellCounter);
							cell.setCellValue(jobRigBean.getRigUpEnd());
							cell.setCellStyle(styleCommon);
							cellCounter++;
							cell = row.createCell(cellCounter);
							cell.setCellValue(jobRigBean.getRigDownStart());
							cell.setCellStyle(styleCommon);
							cellCounter++;
							cell = row.createCell(cellCounter);
							cell.setCellValue(jobRigBean.getRigDownEnd());
							cell.setCellStyle(styleCommon);
							cellCounter++;

							String engValue = jobServiceBean.getEngi();
							if (engValue == null) {
								engValue = "NA";
							}
							String e[] = engValue.split(";");
							ArrayList<String> ss = new ArrayList<String>();

							for (int i = 0; i < e.length; i++) {
								ss.add(e[i]);
							}

							if (ss.size() < 4) {
								for (int i = ss.size(); i < 4; i++) {
									ss.add("NA;");
								}
							}

							Iterator<String> itr = ss.iterator();

							for (String string : ss) {
								cell = row.createCell(cellCounter);
								cell.setCellValue(string);
								cell.setCellStyle(styleCommon);
								cellCounter++;
							}

							String crewValue = jobServiceBean.getCrew();
							if (crewValue == null) {
								crewValue = "NA;";
							}
							String ee[] = crewValue.split(";");
							ArrayList<String> sss = new ArrayList<String>();

							for (int i = 0; i < ee.length; i++) {
								sss.add(ee[i]);
							}

							if (sss.size() < 7) {
								for (int i = sss.size(); i < 7; i++) {
									sss.add("N/A");
								}
							}

							Iterator<String> itrr = sss.iterator();

							for (String string : sss) {
								cell = row.createCell(cellCounter);
								cell.setCellValue(string);
								cell.setCellStyle(styleCommon);
								cellCounter++;
							}

							cell = row.createCell(cellCounter);
							cell.setCellValue(jobRunBean.getBht());
							cell.setCellStyle(styleCommon);
							cellCounter++;

							cell = row.createCell(cellCounter);
							cell.setCellValue(jobRunBean.getRih());
							cell.setCellStyle(styleCommon);
							cellCounter++;

							cell = row.createCell(cellCounter);
							cell.setCellValue(jobRunBean.getPooh());
							cell.setCellStyle(styleCommon);
							cellCounter++;
							cell = row.createCell(cellCounter);
							cell.setCellValue(jobRunBean.getOt());
							cell.setCellStyle(styleCommon);
							cellCounter++;
							cell = row.createCell(cellCounter);
							cell.setCellValue(jobRunBean.getWt());
							cell.setCellStyle(styleCommon);
							cellCounter++;

							// ----------------------------------------------SERVICE_BEAN-------------------------------------------------
							cell = row.createCell(cellCounter);
							cell.setCellValue(jobServiceBean.getServiceType());
							cell.setCellStyle(styleCommon);
							cellCounter++;

							cell = row.createCell(cellCounter);
							cell.setCellValue(jobServiceBean.getServiceName());
							cell.setCellStyle(styleCommon);
							cellCounter++;

							cell = row.createCell(cellCounter);
							cell.setCellValue(jobServiceBean.getLossTime());
							cell.setCellStyle(styleCommon);
							cellCounter++;

							cell = row.createCell(cellCounter);
							cell.setCellValue(jobServiceBean.getSerialNo());
							cell.setCellStyle(styleCommon);
							cellCounter++;

							cell = row.createCell(cellCounter);
							cell.setCellValue(jobServiceBean.getAssetCd());
							cell.setCellStyle(styleCommon);
							cellCounter++;

							cell = row.createCell(cellCounter);
							cell.setCellValue(jobServiceBean.getDeepestDepth());
							cell.setCellStyle(styleCommon);
							cellCounter++;

							cell = row.createCell(cellCounter);
							cell.setCellValue(jobServiceBean.getMeterageLogged());
							cell.setCellStyle(styleCommon);
							cellCounter++;

							cell = row.createCell(cellCounter);
							cell.setCellValue(jobServiceBean.getMeteragePerforated());
							cell.setCellStyle(styleCommon);
							cellCounter++;

							cell = row.createCell(cellCounter);
							cell.setCellValue(jobServiceBean.getChruns());
							cell.setCellStyle(styleCommon);
							cellCounter++;

							cell = row.createCell(cellCounter);
							cell.setCellValue(jobServiceBean.getChmisRuns());
							cell.setCellStyle(styleCommon);
							cellCounter++;

							cell = row.createCell(cellCounter);
							cell.setCellValue(jobServiceBean.getSpf());
							cell.setCellStyle(styleCommon);
							cellCounter++;

							cell = row.createCell(cellCounter);
							cell.setCellValue(jobServiceBean.getCoresCount());
							cell.setCellStyle(styleCommon);
							cellCounter++;

							cell = row.createCell(cellCounter);
							cell.setCellValue(jobServiceBean.getSurfacePressure());
							cell.setCellStyle(styleCommon);
							cellCounter++;

							cell = row.createCell(cellCounter);
							cell.setCellValue(jobServiceBean.getLevelCount());
							cell.setCellStyle(styleCommon);
							cellCounter++;

							cell = row.createCell(cellCounter);
							cell.setCellValue(jobServiceBean.getPretestCount());
							cell.setCellStyle(styleCommon);
							cellCounter++;

							cell = row.createCell(cellCounter);
							cell.setCellValue(jobServiceBean.getDryTestCount());
							cell.setCellStyle(styleCommon);
							cellCounter++;
							cell = row.createCell(cellCounter);
							cell.setCellValue(jobServiceBean.getPumpOutTime());
							cell.setCellStyle(styleCommon);
							cellCounter++;
							cell = row.createCell(cellCounter);
							cell.setCellValue(jobServiceBean.getPvtSample());
							cell.setCellStyle(styleCommon);
							cellCounter++;
							cell = row.createCell(cellCounter);
							cell.setCellValue(jobServiceBean.getNormalSample());
							cell.setCellStyle(styleCommon);
							cellCounter++;
							cell = row.createCell(cellCounter);
							cell.setCellValue(jobServiceBean.getRev());
							cell.setCellStyle(styleCommon);
							cellCounter++;

							cell = row.createCell(cellCounter);
							cell.setCellValue(jobServiceBean.getFailureGroup());
							cell.setCellStyle(styleCommon);
							cellCounter++;

							cell = row.createCell(cellCounter);
							cell.setCellValue(jobServiceBean.getGunSize());
							cell.setCellStyle(styleCommon);
							cellCounter++;

							cell = row.createCell(cellCounter);
							cell.setCellValue(jobServiceBean.getLogSendFromBase());
							cell.setCellStyle(styleCommon);
							cellCounter++;

							cell = row.createCell(cellCounter);
							cell.setCellValue(jobServiceBean.getLogRcieveAtHo());
							cell.setCellStyle(styleCommon);
							cellCounter++;

							cell = row.createCell(cellCounter);
							cell.setCellValue(jobServiceBean.getLqaDoneDate());
							cell.setCellStyle(styleCommon);
							cellCounter++;

							cell = row.createCell(cellCounter);
							cell.setCellValue(jobServiceBean.getLqaTechnical());
							cell.setCellStyle(styleCommon);
							cellCounter++;

							cell = row.createCell(cellCounter);
							cell.setCellValue(jobServiceBean.getLqaPresentation());
							cell.setCellStyle(styleCommon);
							cellCounter++;

							cell = row.createCell(cellCounter);
							cell.setCellValue(jobServiceBean.getSnpSnd());
							cell.setCellStyle(styleCommon);
							cellCounter++;

							cell = row.createCell(cellCounter);
							cell.setCellValue(jobBean.getRemarks());
							cell.setCellStyle(styleCommon);
							cellCounter++;

							cell = row.createCell(cellCounter);
							cell.setCellValue(jobBean.getEjcs1());
							cell.setCellStyle(styleCommon);
							cellCounter++;

							cell = row.createCell(cellCounter);
							cell.setCellValue(jobBean.getEjcs2());
							cell.setCellStyle(styleCommon);
							cellCounter++;

							cell = row.createCell(cellCounter);
							cell.setCellValue(jobBean.getEjcs3());
							cell.setCellStyle(styleCommon);
							cellCounter++;

							cell = row.createCell(cellCounter);
							cell.setCellValue(jobBean.getEjcs4());
							cell.setCellStyle(styleCommon);
							cellCounter++;

							cell = row.createCell(cellCounter);
							cell.setCellValue(jobBean.getEjcs5());
							cell.setCellStyle(styleCommon);
							cellCounter++;

							cell = row.createCell(cellCounter);
							cell.setCellValue(jobBean.getSafetyMeet());
							cell.setCellStyle(styleCommon);
							cellCounter++;

							cell = row.createCell(cellCounter);
							cell.setCellValue(jobWellBean.getHoleSize());
							cell.setCellStyle(styleCommon);
							cellCounter++;

							cell = row.createCell(cellCounter);
							cell.setCellValue(jobWellBean.getField());
							cell.setCellStyle(styleCommon);
							cellCounter++;

							cell = row.createCell(cellCounter);
							cell.setCellValue(jobWellBean.getLatitude_d()+":"+jobWellBean.getLatitude_m()+":"+jobWellBean.getLatitude_s());
							cell.setCellStyle(styleCommon);
							cellCounter++;

							cell = row.createCell(cellCounter);
							cell.setCellValue(jobWellBean.getLongitude_d()+":"+jobWellBean.getLongitude_m()+":"+jobWellBean.getLatitude_s());
							cell.setCellStyle(styleCommon);
							cellCounter++;

							cell = row.createCell(cellCounter);
							cell.setCellValue(jobWellBean.getKb());
							cell.setCellStyle(styleCommon);
							cellCounter++;

							cell = row.createCell(cellCounter);
							cell.setCellValue(jobWellBean.getDl());
							cell.setCellStyle(styleCommon);
							cellCounter++;

							cell = row.createCell(cellCounter);
							cell.setCellValue(jobWellBean.getCasingSize());
							cell.setCellStyle(styleCommon);
							cellCounter++;

							cell = row.createCell(cellCounter);
							cell.setCellValue(jobWellBean.getCasingSizeDepth());
							cell.setCellStyle(styleCommon);
							cellCounter++;

							cell = row.createCell(cellCounter);
							cell.setCellValue(jobWellBean.getRigName());
							cell.setCellStyle(styleCommon);
							cellCounter++;

							cell = row.createCell(cellCounter);
							cell.setCellValue(jobWellBean.getTdDriller());
							cell.setCellStyle(styleCommon);
							cellCounter++;

							cell = row.createCell(cellCounter);
							cell.setCellValue(jobWellBean.getCsDriller());
							cell.setCellStyle(styleCommon);
							cellCounter++;

							cell = row.createCell(cellCounter);
							cell.setCellValue(jobWellBean.getWeekPoint());
							cell.setCellStyle(styleCommon);
							cellCounter++;

							cell = row.createCell(cellCounter);
							cell.setCellValue(jobWellBean.getBitSize());
							cell.setCellStyle(styleCommon);
							cellCounter++;

							cell = row.createCell(cellCounter);
							cell.setCellValue(jobWellBean.getDeviation());
							cell.setCellStyle(styleCommon);
							cellCounter++;

							cell = row.createCell(cellCounter);
							cell.setCellValue(jobWellBean.getStartCirculation());
							cell.setCellStyle(styleCommon);
							cellCounter++;

							cell = row.createCell(cellCounter);
							cell.setCellValue(jobWellBean.getStopCirculation());
							cell.setCellStyle(styleCommon);
							cellCounter++;

							cell = row.createCell(cellCounter);
							cell.setCellValue(jobWellBean.getGf());
							cell.setCellStyle(styleCommon);
							cellCounter++;

							cell = row.createCell(cellCounter);
							cell.setCellValue(jobWellBean.getDensity());
							cell.setCellStyle(styleCommon);
							cellCounter++;

							cell = row.createCell(cellCounter);
							cell.setCellValue(jobWellBean.getRmValue());
							cell.setCellStyle(styleCommon);
							cellCounter++;

							cell = row.createCell(cellCounter);
							cell.setCellValue(jobWellBean.getPh());
							cell.setCellStyle(styleCommon);
							cellCounter++;

							cell = row.createCell(cellCounter);
							cell.setCellValue(jobWellBean.getSalinity());
							cell.setCellStyle(styleCommon);
							cellCounter++;

							cell = row.createCell(cellCounter);
							cell.setCellValue(jobWellBean.getBarities());
							cell.setCellStyle(styleCommon);
							cellCounter++;

							cell = row.createCell(cellCounter);
							cell.setCellValue(jobWellBean.getRmTemp());
							cell.setCellStyle(styleCommon);
							cellCounter++;

							cell = row.createCell(cellCounter);
							cell.setCellValue(jobWellBean.getRmf());
							cell.setCellStyle(styleCommon);
							cellCounter++;

							cell = row.createCell(cellCounter);
							cell.setCellValue(jobWellBean.getRmc());
							cell.setCellStyle(styleCommon);
							cellCounter++;

							cell = row.createCell(cellCounter);
							cell.setCellValue(jobWellBean.getSolid());
							cell.setCellStyle(styleCommon);
							cellCounter++;

						}
						runCount++;
					}
				}

				sheet.createFreezePane(0, 1, 0, 40);
				if (jobMergeEnable) {
					for (int i = 0; i <= 8; i++) {
						sheet.addMergedRegion(new CellRangeAddress(1, getAllServices(jobNo), i, i));
					}
				}
				// rig
				if (rigMergeEnable) {
					SortedSet<String> jobRigList = getRigSet(jobNo);
					int start = 1;
					int from = 0;
					int to = 0;

					for (String rigNo : jobRigList) {
						int run_Count = getServiceCountByRigNo(rigNo);
						sheet.addMergedRegion(new CellRangeAddress(start, start + run_Count - 1, 9, 9));
						sheet.addMergedRegion(new CellRangeAddress(start, start + run_Count - 1, 10, 10));
						sheet.addMergedRegion(new CellRangeAddress(start, start + run_Count - 1, 11, 11));
						sheet.addMergedRegion(new CellRangeAddress(start, start + run_Count - 1, 12, 12));
						start = start + run_Count;
					}
				}
				// run
				if (rigMergeEnable) {
					SortedSet<String> jobRigSet = getRigSet(jobNo);
					int start = 1;
					for (String rigNo : jobRigSet) {
						String runNo = getRunByRigNo(rigNo);
						int service_Count = getServiceCountByRunNo(runNo);
						sheet.addMergedRegion(new CellRangeAddress(start, start + service_Count - 1, 13, 13));
						sheet.addMergedRegion(new CellRangeAddress(start, start + service_Count - 1, 14, 14));
						sheet.addMergedRegion(new CellRangeAddress(start, start + service_Count - 1, 15, 15));
						sheet.addMergedRegion(new CellRangeAddress(start, start + service_Count - 1, 16, 16));
						sheet.addMergedRegion(new CellRangeAddress(start, start + service_Count - 1, 17, 17));
						start = start + service_Count;
					}
				}
			}
			wb.write(fileOut);
			fileOut.flush();
			fileOut.close();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}

	}

	@SuppressWarnings("deprecation")
	public static void generateWas(String jobNo, String filePath) {
		try {
			FileOutputStream fileOut = null;
			fileOut = new FileOutputStream(filePath);
			HSSFWorkbook wb = new HSSFWorkbook();
			HSSFSheet sheet = wb.createSheet();
			HSSFCellStyle styleHeader = wb.createCellStyle();
			styleHeader.setRotation((short) 90);
			styleHeader.setFillForegroundColor(HSSFColor.AQUA.index);
			styleHeader.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
			styleHeader.setBorderBottom(CellStyle.BORDER_THIN);
			styleHeader.setBottomBorderColor(IndexedColors.BLACK.getIndex());
			styleHeader.setBorderLeft(CellStyle.BORDER_THIN);
			styleHeader.setLeftBorderColor(IndexedColors.GREEN.getIndex());
			styleHeader.setBorderRight(CellStyle.BORDER_THIN);
			styleHeader.setRightBorderColor(IndexedColors.BLUE.getIndex());
			styleHeader.setBorderTop(CellStyle.BORDER_MEDIUM_DASHED);
			styleHeader.setTopBorderColor(IndexedColors.BLACK.getIndex());

			HSSFCellStyle styleRedHeader = wb.createCellStyle();
			styleRedHeader.setRotation((short) 90);
			styleRedHeader.setFillForegroundColor(HSSFColor.RED.index);
			styleRedHeader.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
			styleRedHeader.setBorderBottom(CellStyle.BORDER_THIN);
			styleRedHeader.setBottomBorderColor(IndexedColors.BLACK.getIndex());
			styleRedHeader.setBorderLeft(CellStyle.BORDER_THIN);
			styleRedHeader.setLeftBorderColor(IndexedColors.GREEN.getIndex());
			styleRedHeader.setBorderRight(CellStyle.BORDER_THIN);
			styleRedHeader.setRightBorderColor(IndexedColors.BLUE.getIndex());
			styleRedHeader.setBorderTop(CellStyle.BORDER_MEDIUM_DASHED);
			styleRedHeader.setTopBorderColor(IndexedColors.BLACK.getIndex());

			HSSFCellStyle styleCommon90 = wb.createCellStyle();
			styleCommon90.setRotation((short) 90);
			styleCommon90.setFillForegroundColor(HSSFColor.YELLOW.index);
			styleCommon90.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
			styleCommon90.setBorderBottom(CellStyle.BORDER_THIN);
			styleCommon90.setBottomBorderColor(IndexedColors.BLACK.getIndex());
			styleCommon90.setBorderLeft(CellStyle.BORDER_THIN);
			styleCommon90.setLeftBorderColor(IndexedColors.GREEN.getIndex());
			styleCommon90.setBorderRight(CellStyle.BORDER_THIN);
			styleCommon90.setRightBorderColor(IndexedColors.BLUE.getIndex());
			styleCommon90.setBorderTop(CellStyle.BORDER_MEDIUM_DASHED);
			styleCommon90.setTopBorderColor(IndexedColors.BLACK.getIndex());

			HSSFCellStyle styleCommon = wb.createCellStyle();
			styleCommon90.setRotation((short) 90);
			styleCommon.setFillForegroundColor(HSSFColor.YELLOW.index);
			styleCommon.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
			styleCommon.setBorderBottom(CellStyle.BORDER_THIN);
			styleCommon.setBottomBorderColor(IndexedColors.BLACK.getIndex());
			styleCommon.setBorderLeft(CellStyle.BORDER_THIN);
			styleCommon.setLeftBorderColor(IndexedColors.GREEN.getIndex());
			styleCommon.setBorderRight(CellStyle.BORDER_THIN);
			styleCommon.setRightBorderColor(IndexedColors.BLUE.getIndex());
			styleCommon.setBorderTop(CellStyle.BORDER_MEDIUM_DASHED);
			styleCommon.setTopBorderColor(IndexedColors.BLACK.getIndex());
			Font font = wb.createFont();
			font.setBoldweight(Font.BOLDWEIGHT_BOLD);

			int rowNum = 0;
			HSSFRow row = null;
			HSSFCell cell = null;
			row = sheet.createRow(rowNum++);
			for (int i = 0; i < jobHeader.length; i++) {
				cell = row.createCell(i);
				cell.setCellValue(jobHeader[i]);
				cell.setCellStyle(styleHeader);
				sheet.setColumnWidth(i, (2000));

			}

			JobBean jobBean = new JobBean();
			JobWellBean jobWellBean = new JobWellBean();
			SearchJobService searchJobService = new SearchJobService();
			EditJobService editJobService = new EditJobService();
			jobBean = searchJobService.getJobBean(jobNo);
			jobWellBean = searchJobService.getJobWellBean(jobNo);
			String[] rigToExplosive = new String[5];
			Session session = HibernateSession.getSessionFactory().openSession();
			Criteria jobRigCriteria = session.createCriteria(JobRigBean.class);
			jobRigCriteria.add(Restrictions.like("jobNo", jobNo));
			List<JobRigBean> list = jobRigCriteria.list();
			Collections.sort(list, new Comparator<JobRigBean>() {
				@Override
				public int compare(JobRigBean obj1, JobRigBean obj2) {
					return obj1.getRigNo().compareTo(obj2.getRigNo());
				}
			});

			Iterator<JobRigBean> jobRigItr = list.iterator();
			Integer rigCount = list.size();
			Integer runCount = 0;
			Integer serviceCount = 0;
			Integer explosiveCount = 0;
			int rowCounter = 1;

			while (jobRigItr.hasNext()) {
				int cellCounter = 0;
				JobRigBean jobRigBean = jobRigItr.next();
				String rigNo = jobRigBean.getRigNo();
				Criteria jobRunCriteria = session.createCriteria(JobRunBean.class);
				jobRunCriteria.add(Restrictions.like("rigNo", rigNo));
				List<JobRunBean> runList = jobRunCriteria.list();
				Collections.sort(runList, new Comparator<JobRunBean>() {
					@Override
					public int compare(JobRunBean obj1, JobRunBean obj2) {
						return obj1.getRunNo().compareTo(obj2.getRunNo());
					}
				});

				Iterator<JobRunBean> jobRunItr = runList.iterator();
				serviceCount = DownloadWasService.getServiceCount(jobNo);
				runCount = 0;

				while (jobRunItr.hasNext()) {
					JobRunBean jobRunBean = jobRunItr.next();
					String runNo = jobRunBean.getRunNo();
					Criteria jobServiceCriteria = session.createCriteria(JobServiceBean.class);
					jobServiceCriteria.add(Restrictions.like("runNo", runNo));
					@SuppressWarnings("unchecked")
					List<JobServiceBean> jobServiceList = jobServiceCriteria.list();
					Collections.sort(jobServiceList, new Comparator<JobServiceBean>() {
						@Override
						public int compare(JobServiceBean obj1, JobServiceBean obj2) {
							return obj1.getServiceNo().compareTo(obj2.getServiceNo());
						}
					});

					Set<JobServiceBean> jobservicebeanset = new HashSet<JobServiceBean>(jobServiceList);

					Iterator<JobServiceBean> jobServiceItr = jobservicebeanset.iterator();
					while (jobServiceItr.hasNext()) {
						JobServiceBean jobServiceBean = jobServiceItr.next();
						String serviceNo = jobServiceBean.getServiceNo();
						Criteria jobExplCriteria = session.createCriteria(JobExplBean.class);
						jobExplCriteria.add(Restrictions.like("serviceNo", serviceNo));
						@SuppressWarnings("unchecked")
						List<JobExplBean> explList = jobExplCriteria.list();
						Collections.sort(explList, new Comparator<JobExplBean>() {
							@Override
							public int compare(JobExplBean obj1, JobExplBean obj2) {
								return obj1.getExplNo().compareTo(obj2.getExplNo());
							}
						});
						Iterator<JobExplBean> jobExplItr = explList.iterator();
						row = sheet.createRow(rowCounter++);
						cellCounter = 0;
						// -------------------------------------JOB_BEAN------------------------------------->
						cell = row.createCell(cellCounter);
						cell.setCellValue(jobServiceBean.getServiceNo());
						cell.setCellStyle(styleCommon);
						cellCounter++;
						cell = row.createCell(cellCounter);
						cell.setCellValue(jobBean.getUnitNo());
						cell.setCellStyle(styleCommon);
						cellCounter++;
						cell = row.createCell(cellCounter);
						cell.setCellValue(jobBean.getJobNoHlsa());
						cell.setCellStyle(styleCommon);
						cellCounter++;
						cell = row.createCell(cellCounter);
						cell.setCellValue(jobBean.getWellNo());
						cell.setCellStyle(styleCommon);
						cellCounter++;
						cell = row.createCell(cellCounter);
						cell.setCellValue(jobBean.getClientName());
						cell.setCellStyle(styleCommon);
						cellCounter++;
						cell = row.createCell(cellCounter);
						cell.setCellValue(jobBean.getUnitLeftBase());
						cell.setCellStyle(styleCommon);
						cellCounter++;
						cell = row.createCell(cellCounter);
						cell.setCellValue(jobBean.getUnitReachedSite());
						cell.setCellStyle(styleCommon);
						cellCounter++;
						cell = row.createCell(cellCounter);
						cell.setCellValue(jobBean.getUnitReachedBase());
						cell.setCellStyle(styleCommon);
						cellCounter++;
						cell = row.createCell(cellCounter);
						cell.setCellValue(jobBean.getUnitLeftSite());
						cell.setCellStyle(styleCommon);
						cellCounter++;
						cell = row.createCell(cellCounter);
						cell.setCellValue(jobBean.getTruckMileage());
						cell.setCellStyle(styleCommon);
						cellCounter++;
						cell = row.createCell(cellCounter);
						cell.setCellValue(jobBean.getVanMileage());
						cell.setCellStyle(styleCommon);
						cellCounter++;

						// ------------------------------------------------RIG_NO---------------------------------------------

						cell = row.createCell(cellCounter);
						cell.setCellValue(jobRigBean.getRigUpStart());
						cell.setCellStyle(styleCommon);
						cellCounter++;
						cell = row.createCell(cellCounter);
						cell.setCellValue(jobRigBean.getRigUpEnd());
						cell.setCellStyle(styleCommon);
						cellCounter++;
						cell = row.createCell(cellCounter);
						cell.setCellValue(jobRigBean.getRigDownStart());
						cell.setCellStyle(styleCommon);
						cellCounter++;
						cell = row.createCell(cellCounter);
						cell.setCellValue(jobRigBean.getRigDownEnd());
						cell.setCellStyle(styleCommon);
						cellCounter++;

						String engValue = jobServiceBean.getEngi();
						System.out.println(engValue + "-" + jobServiceBean.getServiceNo());
						String e[] = engValue.split(";");
						ArrayList<String> ss = new ArrayList<String>();

						for (int i = 0; i < e.length; i++) {
							ss.add(e[i]);
						}

						if (ss.size() < 4) {
							for (int i = ss.size(); i < 4; i++) {
								ss.add("N/A");
							}
						}

						Iterator<String> itr = ss.iterator();

						for (String string : ss) {
							cell = row.createCell(cellCounter);
							cell.setCellValue(string);
							cell.setCellStyle(styleCommon);
							cellCounter++;
						}

						String crewValue = jobServiceBean.getCrew();
						String ee[] = crewValue.split(";");
						ArrayList<String> sss = new ArrayList<String>();

						for (int i = 0; i < ee.length; i++) {
							sss.add(ee[i]);
						}

						if (sss.size() < 7) {
							for (int i = sss.size(); i < 7; i++) {
								sss.add("N/A");
							}
						}

						Iterator<String> itrr = sss.iterator();

						for (String string : sss) {
							cell = row.createCell(cellCounter);
							cell.setCellValue(string);
							cell.setCellStyle(styleCommon);
							cellCounter++;
						}

						cell = row.createCell(cellCounter);
						cell.setCellValue(jobRunBean.getBht());
						cell.setCellStyle(styleCommon);
						cellCounter++;

						cell = row.createCell(cellCounter);
						cell.setCellValue(jobRunBean.getRih());
						cell.setCellStyle(styleCommon);
						cellCounter++;

						cell = row.createCell(cellCounter);
						cell.setCellValue(jobRunBean.getPooh());
						cell.setCellStyle(styleCommon);
						cellCounter++;
						cell = row.createCell(cellCounter);
						cell.setCellValue(jobRunBean.getOt());
						cell.setCellStyle(styleCommon);
						cellCounter++;
						cell = row.createCell(cellCounter);
						cell.setCellValue(jobRunBean.getWt());
						cell.setCellStyle(styleCommon);
						cellCounter++;

						// ----------------------------------------------SERVICE_BEAN-------------------------------------------------
						cell = row.createCell(cellCounter);
						cell.setCellValue(jobServiceBean.getServiceType());
						cell.setCellStyle(styleCommon);
						cellCounter++;

						cell = row.createCell(cellCounter);
						cell.setCellValue(jobServiceBean.getServiceName());
						cell.setCellStyle(styleCommon);
						cellCounter++;

						cell = row.createCell(cellCounter);
						cell.setCellValue(jobServiceBean.getLossTime());
						cell.setCellStyle(styleCommon);
						cellCounter++;

						cell = row.createCell(cellCounter);
						cell.setCellValue(jobServiceBean.getSerialNo());
						cell.setCellStyle(styleCommon);
						cellCounter++;

						cell = row.createCell(cellCounter);
						cell.setCellValue(jobServiceBean.getAssetCd());
						cell.setCellStyle(styleCommon);
						cellCounter++;

						cell = row.createCell(cellCounter);
						cell.setCellValue(jobServiceBean.getDeepestDepth());
						cell.setCellStyle(styleCommon);
						cellCounter++;

						cell = row.createCell(cellCounter);
						cell.setCellValue(jobServiceBean.getMeterageLogged());
						cell.setCellStyle(styleCommon);
						cellCounter++;

						cell = row.createCell(cellCounter);
						cell.setCellValue(jobServiceBean.getMeteragePerforated());
						cell.setCellStyle(styleCommon);
						cellCounter++;

						cell = row.createCell(cellCounter);
						cell.setCellValue(jobServiceBean.getChruns());
						cell.setCellStyle(styleCommon);
						cellCounter++;

						cell = row.createCell(cellCounter);
						cell.setCellValue(jobServiceBean.getChmisRuns());
						cell.setCellStyle(styleCommon);
						cellCounter++;

						cell = row.createCell(cellCounter);
						cell.setCellValue(jobServiceBean.getSpf());
						cell.setCellStyle(styleCommon);
						cellCounter++;

						cell = row.createCell(cellCounter);
						cell.setCellValue(jobServiceBean.getCoresCount());
						cell.setCellStyle(styleCommon);
						cellCounter++;

						cell = row.createCell(cellCounter);
						cell.setCellValue(jobServiceBean.getSurfacePressure());
						cell.setCellStyle(styleCommon);
						cellCounter++;

						cell = row.createCell(cellCounter);
						cell.setCellValue(jobServiceBean.getLevelCount());
						cell.setCellStyle(styleCommon);
						cellCounter++;

						cell = row.createCell(cellCounter);
						cell.setCellValue(jobServiceBean.getPretestCount());
						cell.setCellStyle(styleCommon);
						cellCounter++;

						cell = row.createCell(cellCounter);
						cell.setCellValue(jobServiceBean.getDryTestCount());
						cell.setCellStyle(styleCommon);
						cellCounter++;
						cell = row.createCell(cellCounter);
						cell.setCellValue(jobServiceBean.getPumpOutTime());
						cell.setCellStyle(styleCommon);
						cellCounter++;
						cell = row.createCell(cellCounter);
						cell.setCellValue(jobServiceBean.getPvtSample());
						cell.setCellStyle(styleCommon);
						cellCounter++;
						cell = row.createCell(cellCounter);
						cell.setCellValue(jobServiceBean.getNormalSample());
						cell.setCellStyle(styleCommon);
						cellCounter++;
						cell = row.createCell(cellCounter);
						cell.setCellValue(jobServiceBean.getRev());
						cell.setCellStyle(styleCommon);
						cellCounter++;

						cell = row.createCell(cellCounter);
						cell.setCellValue(jobServiceBean.getFailureGroup());
						cell.setCellStyle(styleCommon);
						cellCounter++;

						cell = row.createCell(cellCounter);
						cell.setCellValue(jobServiceBean.getGunSize());
						cell.setCellStyle(styleCommon);
						cellCounter++;

						cell = row.createCell(cellCounter);
						cell.setCellValue(jobServiceBean.getLogSendFromBase());
						cell.setCellStyle(styleCommon);
						cellCounter++;

						cell = row.createCell(cellCounter);
						cell.setCellValue(jobServiceBean.getLogRcieveAtHo());
						cell.setCellStyle(styleCommon);
						cellCounter++;

						cell = row.createCell(cellCounter);
						cell.setCellValue(jobServiceBean.getLqaDoneDate());
						cell.setCellStyle(styleCommon);
						cellCounter++;

						cell = row.createCell(cellCounter);
						cell.setCellValue(jobServiceBean.getLqaTechnical());
						cell.setCellStyle(styleCommon);
						cellCounter++;

						cell = row.createCell(cellCounter);
						cell.setCellValue(jobServiceBean.getLqaPresentation());
						cell.setCellStyle(styleCommon);
						cellCounter++;

						cell = row.createCell(cellCounter);
						cell.setCellValue(jobServiceBean.getSnpSnd());
						cell.setCellStyle(styleCommon);
						cellCounter++;

						cell = row.createCell(cellCounter);
						cell.setCellValue(jobBean.getRemarks());
						cell.setCellStyle(styleCommon);
						cellCounter++;

						cell = row.createCell(cellCounter);
						cell.setCellValue(jobBean.getEjcs1());
						cell.setCellStyle(styleCommon);
						cellCounter++;

						cell = row.createCell(cellCounter);
						cell.setCellValue(jobBean.getEjcs2());
						cell.setCellStyle(styleCommon);
						cellCounter++;

						cell = row.createCell(cellCounter);
						cell.setCellValue(jobBean.getEjcs3());
						cell.setCellStyle(styleCommon);
						cellCounter++;

						cell = row.createCell(cellCounter);
						cell.setCellValue(jobBean.getEjcs4());
						cell.setCellStyle(styleCommon);
						cellCounter++;

						cell = row.createCell(cellCounter);
						cell.setCellValue(jobBean.getEjcs5());
						cell.setCellStyle(styleCommon);
						cellCounter++;

						cell = row.createCell(cellCounter);
						cell.setCellValue(jobBean.getSafetyMeet());
						cell.setCellStyle(styleCommon);
						cellCounter++;

						cell = row.createCell(cellCounter);
						cell.setCellValue(jobWellBean.getHoleSize());
						cell.setCellStyle(styleCommon);
						cellCounter++;

						cell = row.createCell(cellCounter);
						cell.setCellValue(jobWellBean.getField());
						cell.setCellStyle(styleCommon);
						cellCounter++;

						cell = row.createCell(cellCounter);
						cell.setCellValue(jobWellBean.getLatitude_d() + ":" + jobWellBean.getLatitude_m() + ":" + jobWellBean.getLatitude_s());
						cell.setCellStyle(styleCommon);
						cellCounter++;

						cell = row.createCell(cellCounter);
						cell.setCellValue(jobWellBean.getLongitude_d() + ":" + jobWellBean.getLongitude_m() + ":" + jobWellBean.getLongitude_s());
						cell.setCellStyle(styleCommon);
						cellCounter++;

						cell = row.createCell(cellCounter);
						cell.setCellValue(jobWellBean.getKb());
						cell.setCellStyle(styleCommon);
						cellCounter++;

						cell = row.createCell(cellCounter);
						cell.setCellValue(jobWellBean.getDl());
						cell.setCellStyle(styleCommon);
						cellCounter++;

						cell = row.createCell(cellCounter);
						cell.setCellValue(jobWellBean.getCasingSize());
						cell.setCellStyle(styleCommon);
						cellCounter++;

						cell = row.createCell(cellCounter);
						cell.setCellValue(jobWellBean.getCasingSizeDepth());
						cell.setCellStyle(styleCommon);
						cellCounter++;

						cell = row.createCell(cellCounter);
						cell.setCellValue(jobWellBean.getRigName());
						cell.setCellStyle(styleCommon);
						cellCounter++;

						cell = row.createCell(cellCounter);
						cell.setCellValue(jobWellBean.getTdDriller());
						cell.setCellStyle(styleCommon);
						cellCounter++;

						cell = row.createCell(cellCounter);
						cell.setCellValue(jobWellBean.getCsDriller());
						cell.setCellStyle(styleCommon);
						cellCounter++;

						cell = row.createCell(cellCounter);
						cell.setCellValue(jobWellBean.getWeekPoint());
						cell.setCellStyle(styleCommon);
						cellCounter++;

						cell = row.createCell(cellCounter);
						cell.setCellValue(jobWellBean.getBitSize());
						cell.setCellStyle(styleCommon);
						cellCounter++;

						cell = row.createCell(cellCounter);
						cell.setCellValue(jobWellBean.getDeviation());
						cell.setCellStyle(styleCommon);
						cellCounter++;

						cell = row.createCell(cellCounter);
						cell.setCellValue(jobWellBean.getStartCirculation());
						cell.setCellStyle(styleCommon);
						cellCounter++;

						cell = row.createCell(cellCounter);
						cell.setCellValue(jobWellBean.getStopCirculation());
						cell.setCellStyle(styleCommon);
						cellCounter++;

						cell = row.createCell(cellCounter);
						cell.setCellValue(jobWellBean.getGf());
						cell.setCellStyle(styleCommon);
						cellCounter++;

						cell = row.createCell(cellCounter);
						cell.setCellValue(jobWellBean.getDensity());
						cell.setCellStyle(styleCommon);
						cellCounter++;

						cell = row.createCell(cellCounter);
						cell.setCellValue(jobWellBean.getRmValue());
						cell.setCellStyle(styleCommon);
						cellCounter++;

						cell = row.createCell(cellCounter);
						cell.setCellValue(jobWellBean.getPh());
						cell.setCellStyle(styleCommon);
						cellCounter++;

						cell = row.createCell(cellCounter);
						cell.setCellValue(jobWellBean.getSalinity());
						cell.setCellStyle(styleCommon);
						cellCounter++;

						cell = row.createCell(cellCounter);
						cell.setCellValue(jobWellBean.getBarities());
						cell.setCellStyle(styleCommon);
						cellCounter++;

						cell = row.createCell(cellCounter);
						cell.setCellValue(jobWellBean.getRmTemp());
						cell.setCellStyle(styleCommon);
						cellCounter++;

						cell = row.createCell(cellCounter);
						cell.setCellValue(jobWellBean.getRmf());
						cell.setCellStyle(styleCommon);
						cellCounter++;

						cell = row.createCell(cellCounter);
						cell.setCellValue(jobWellBean.getRmc());
						cell.setCellStyle(styleCommon);
						cellCounter++;

						cell = row.createCell(cellCounter);
						cell.setCellValue(jobWellBean.getSolid());
						cell.setCellStyle(styleCommon);
						cellCounter++;

						// //
						// ----------------------------------------------EXPL-------------------------------------------------
						// while (jobExplItr.hasNext()) {
						// JobExplBean jobExplBean = jobExplItr.next();
						//
						// cell = row.createCell(cellCounter);
						// cell.setCellValue(jobExplBean.getExplNo());
						// cell.setCellStyle(styleCommon);
						// cellCounter++;
						//
						// cell = row.createCell(cellCounter);
						// cell.setCellValue(jobExplBean.getPartCd());
						// cell.setCellStyle(styleCommon);
						// cellCounter++;
						//
						// cell = row.createCell(cellCounter);
						// cell.setCellValue(jobExplBean.getQty());
						// cell.setCellStyle(styleCommon);
						// cellCounter++;
						//
						// cell = row.createCell(cellCounter);
						// cell.setCellValue(jobExplBean.getUom());
						// cell.setCellStyle(styleCommon);
						// cellCounter++;
						//
						// }
					}
					runCount++;
				}
			}

			sheet.createFreezePane(0, 1, 0, 40);
			if (jobMergeEnable) {
				for (int i = 0; i <= 8; i++) {
					sheet.addMergedRegion(new CellRangeAddress(1, getAllServices(jobNo), i, i));
				}
			}
			// rig
			if (rigMergeEnable) {
				SortedSet<String> jobRigList = getRigSet(jobNo);
				int start = 1;
				int from = 0;
				int to = 0;

				for (String rigNo : jobRigList) {
					int run_Count = getServiceCountByRigNo(rigNo);
					sheet.addMergedRegion(new CellRangeAddress(start, start + run_Count - 1, 9, 9));
					sheet.addMergedRegion(new CellRangeAddress(start, start + run_Count - 1, 10, 10));
					sheet.addMergedRegion(new CellRangeAddress(start, start + run_Count - 1, 11, 11));
					sheet.addMergedRegion(new CellRangeAddress(start, start + run_Count - 1, 12, 12));

					start = start + run_Count;
				}
			}
			// run
			if (rigMergeEnable) {
				SortedSet<String> jobRigSet = getRigSet(jobNo);
				int start = 1;
				for (String rigNo : jobRigSet) {
					String runNo = getRunByRigNo(rigNo);
					int service_Count = getServiceCountByRunNo(runNo);
					sheet.addMergedRegion(new CellRangeAddress(start, start + service_Count - 1, 13, 13));
					sheet.addMergedRegion(new CellRangeAddress(start, start + service_Count - 1, 14, 14));
					sheet.addMergedRegion(new CellRangeAddress(start, start + service_Count - 1, 15, 15));
					sheet.addMergedRegion(new CellRangeAddress(start, start + service_Count - 1, 16, 16));
					sheet.addMergedRegion(new CellRangeAddress(start, start + service_Count - 1, 17, 17));
					start = start + service_Count;
				}
			}

			wb.write(fileOut);
			fileOut.flush();
			fileOut.close();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
	}

}