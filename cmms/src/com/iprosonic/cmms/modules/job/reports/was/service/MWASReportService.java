package com.iprosonic.cmms.modules.job.reports.was.service;


import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRXlsExporter;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Font;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.iprosonic.cmms.modules.cpi.transactions.cpi.dao.CpiDAOImpl;
import com.iprosonic.cmms.modules.cpi.transactions.cpi.domain.CpiBean;
import com.iprosonic.cmms.pjcommons.model.NumberingBean;
import com.iprosonic.cmms.pjcommons.utility.ContextFile;
import com.iprosonic.cmms.pjcommons.utility.HibernateSession;
import com.iprosonic.cmms.pjcommons.utility.MyPropertiesReader;

public class MWASReportService {

	public void generateCpiPdf(String cpiCd) {
		CpiDAOImpl cpiDAOImpl = new CpiDAOImpl();
		List<CpiBean> liCpiBeansList = null;
		MyPropertiesReader myPropertiesReader = new MyPropertiesReader();
		String jrxmlPath = null;
		String logoPath = null;
		String imagePath = null;
		String cpiJrxmlPath = null;
		String fileDownloadPath = null;
		String downloadFile = null;
		try {

			imagePath = myPropertiesReader.getFilePath("logoPath");
			jrxmlPath = myPropertiesReader.getFilePath("cpijrxml");
			fileDownloadPath = myPropertiesReader.getFilePath("pdfdownload");
			logoPath = ContextFile.getContextFile(imagePath);
			cpiJrxmlPath = ContextFile.getContextFile(jrxmlPath);
			downloadFile = ContextFile.getContextFile(fileDownloadPath);
			liCpiBeansList = cpiDAOImpl.listCpiByCpiCd(cpiCd);
			File imageFile = new File(logoPath);
			JRDataSource jds = new JRBeanCollectionDataSource(liCpiBeansList);

			HashMap map = new HashMap();
			map.put("cpiCd", cpiCd);
			map.put("IMG", imageFile);

			File dest = new File(downloadFile);
			JasperPrint jasperPrint = JasperFillManager.fillReport(
					cpiJrxmlPath, map, jds);
			JasperExportManager.exportReportToPdfFile(jasperPrint,
					dest.getPath());
			

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public void generateCpiExcel(String cpiCd) {

		

		CpiDAOImpl cpiDAOImpl = new CpiDAOImpl();
		List<CpiBean> liCpiBeansList = null;
		MyPropertiesReader myPropertiesReader = new MyPropertiesReader();
		String jrxmlPath = null;
		String logoPath = null;
		String imagePath = null;
		String cpiJrxmlPath = null;
		String fileDownloadPath = null;
		String downloadFile = null;
		try {

			imagePath = myPropertiesReader.getFilePath("logoPath");
			jrxmlPath = myPropertiesReader.getFilePath("cpijrxml");
			fileDownloadPath = myPropertiesReader.getFilePath("exceldownload");

			logoPath = ContextFile.getContextFile(imagePath);
			cpiJrxmlPath = ContextFile.getContextFile(jrxmlPath);
			downloadFile = ContextFile.getContextFile(fileDownloadPath);
			liCpiBeansList = cpiDAOImpl.listCpiByCpiCd(cpiCd);
			File imageFile = new File(logoPath);
			File dest = new File(downloadFile);
			JRDataSource jds = new JRBeanCollectionDataSource(liCpiBeansList);

			HashMap map = new HashMap();
			map.put("cpiCd", cpiCd);
			map.put("IMG", imageFile);

			JasperPrint jasperPrint = JasperFillManager.fillReport(
					cpiJrxmlPath, map, jds);
			JRXlsExporter exporter = new JRXlsExporter();
			exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
			exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME,
					dest.getPath());

			exporter.exportReport();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void generateMWasReport(String fromDate, String toDate,
			String cpiCd, String unitCd, String cpiStatus, String assetType,
			String correctiveActionDoneBy1, String typeOfCpi,
			String impactToCoustomer, String effectOnCustomer,
			String sourceOfCpi, String subSourceOfCpi, String groupCd,
			String subGroupCd, String category, String subCategory,
			String prcaDoneBy, String frcaDoneBy) {

		
		
		CpiDAOImpl cpiDAOImpl = new CpiDAOImpl();
		List<CpiBean> cpiBeansList = cpiDAOImpl.getCpiList(fromDate, toDate,
				cpiCd, unitCd, cpiStatus, assetType, correctiveActionDoneBy1,
				typeOfCpi, impactToCoustomer, effectOnCustomer, sourceOfCpi,
				subSourceOfCpi, groupCd, subGroupCd, category, subCategory,
				prcaDoneBy, frcaDoneBy);

		String fileDownloadPath = null;
		FileOutputStream fileOut = null;
		
		try {
			MyPropertiesReader myPropertiesReader = new MyPropertiesReader();
			
			String filePath = null;
		    fileDownloadPath = myPropertiesReader.getFilePath("exceldownload");
		    
			filePath = ContextFile.getContextFile(fileDownloadPath);
			
			fileOut = new FileOutputStream(filePath,true);
			HSSFWorkbook wb = new HSSFWorkbook();
			HSSFSheet sheet = wb.createSheet();
			HSSFRow row1 = null;
			HSSFCell cell1 = null;
			HSSFCell cell2 = null;
			HSSFCell cell3 = null;
			HSSFCell cell4 = null;
			HSSFCell cell5 = null;
			HSSFCell cell6 = null;
			HSSFCell cell7 = null;
			HSSFCell cell8 = null;
			HSSFCell cell9 = null;
			HSSFCell cell10 = null;
			HSSFCell cell11 = null;
			HSSFCell cell12 = null;
			HSSFCell cell13 = null;
			HSSFCell cell14 = null;
			HSSFCell cell15 = null;
			HSSFCell cell16 = null;
			HSSFCell cell17 = null;
			HSSFCell cell18 = null;
			HSSFCell cell19 = null;
			HSSFCell cell20 = null;
			HSSFCell cell21 = null;
			HSSFCell cell22 = null;
			HSSFCell cell23 = null;
			HSSFCell cell24 = null;
			HSSFCell cell25 = null;
			HSSFCell cell26 = null;
			HSSFCell cell27 = null;
			HSSFCell cell28 = null;
			HSSFCell cell29 = null;
			HSSFCell cell30 = null;
			HSSFCell cell31 = null;
			HSSFCell cell32 = null;
			HSSFCell cell33 = null;
			HSSFCell cell34 = null;
			HSSFCell cell35 = null;
			HSSFCell cell36 = null;
			HSSFCell cell37 = null;
			HSSFCell cell38 = null;
			HSSFCell cell39 = null;
			HSSFCell cell40 = null;
			HSSFCell cell41 = null;
			HSSFCell cell42 = null;
			HSSFCell cell43 = null;
			HSSFCell cell44 = null;
			HSSFCell cell45 = null;
			HSSFCell cell46 = null;
			HSSFCell cell47 = null;
			HSSFCell cell48 = null;
			HSSFCell cell49 = null;
			HSSFCell cell50 = null;
			HSSFCell cell51 = null;
			HSSFCell cell52 = null;
			HSSFCell cell53 = null;
			HSSFCell cell54 = null;
			HSSFCell cell55 = null;
			HSSFCell cell56 = null;
			HSSFCell cell57 = null;
			HSSFCell cell58 = null;
			HSSFCell cell59 = null;
			HSSFCell cell60 = null;
			HSSFCell cell61 = null;
			HSSFCell cell62 = null;
			HSSFCell cell63 = null;
			HSSFCell cell64 = null;
			HSSFCell cell65 = null;
			HSSFCell cell66 = null;
			HSSFCell cell67 = null;
			HSSFCell cell68 = null;
			HSSFCell cell69 = null;
			HSSFCell cell70 = null;
			HSSFCell cell71 = null;
			HSSFCell cell72 = null;
			HSSFCell cell73 = null;
			HSSFCell cell74 = null;
			HSSFCell cell75 = null;
			HSSFCell cell76 = null;
			HSSFCell cell77 = null;
			HSSFCell cell78 = null;
			HSSFCell cell79 = null;
			HSSFCell cell80 = null;
			HSSFCell cell81 = null;
			HSSFCell cell82 = null;
			HSSFCell cell83 = null;
			HSSFCell cell84 = null;
			HSSFCell cell85 = null;

			short rowNum = 1;
			row1 = sheet.createRow(0);
			cell1 = row1.createCell(0);
			cell2 = row1.createCell(1);
			cell3 = row1.createCell(2);
			cell4 = row1.createCell(3);
			cell5 = row1.createCell(4);
			cell6 = row1.createCell(5);
			cell7 = row1.createCell(6);
			cell8 = row1.createCell(7);
			cell9 = row1.createCell(8);
			cell10 = row1.createCell(9);
			cell11 = row1.createCell(10);
			cell12 = row1.createCell(11);
			cell13 = row1.createCell(12);
			cell14 = row1.createCell(13);
			cell15 = row1.createCell(14);
			cell16 = row1.createCell(15);
			cell17 = row1.createCell(16);
			cell18 = row1.createCell(17);
			cell19 = row1.createCell(18);
			cell20 = row1.createCell(19);
			cell21 = row1.createCell(20);
			cell22 = row1.createCell(21);
			cell23 = row1.createCell(22);
			cell24 = row1.createCell(23);
			cell25 = row1.createCell(24);
			cell26 = row1.createCell(25);
			cell27 = row1.createCell(26);
			cell28 = row1.createCell(27);
			cell29 = row1.createCell(28);
			cell30 = row1.createCell(29);
			cell31 = row1.createCell(30);
			cell32 = row1.createCell(31);
			cell33 = row1.createCell(32);
			cell34 = row1.createCell(33);
			cell35 = row1.createCell(34);
			cell36 = row1.createCell(35);
			cell37 = row1.createCell(36);
			cell38 = row1.createCell(37);
			cell39 = row1.createCell(38);
			cell40 = row1.createCell(39);
			cell41 = row1.createCell(40);
			cell42 = row1.createCell(41);
			cell43 = row1.createCell(42);
			cell44 = row1.createCell(43);
			cell45 = row1.createCell(44);
			cell46 = row1.createCell(45);
			cell47 = row1.createCell(46);
			cell48 = row1.createCell(47);
			cell49 = row1.createCell(48);
			cell50 = row1.createCell(49);
			cell51 = row1.createCell(50);
			cell52 = row1.createCell(51);
			cell53 = row1.createCell(52);
			cell54 = row1.createCell(53);
			cell55 = row1.createCell(54);
			cell56 = row1.createCell(55);
			cell57 = row1.createCell(56);
			cell58 = row1.createCell(57);
			cell59 = row1.createCell(58);
			cell60 = row1.createCell(59);
			cell61 = row1.createCell(60);
			cell62 = row1.createCell(61);
			cell63 = row1.createCell(62);
			cell64 = row1.createCell(63);
			cell65 = row1.createCell(64);
			cell66 = row1.createCell(65);
			cell67 = row1.createCell(66);
			cell68 = row1.createCell(67);
			cell69 = row1.createCell(68);
			cell70 = row1.createCell(69);
			cell71 = row1.createCell(70);
			cell72 = row1.createCell(71);
			cell73 = row1.createCell(72);
			cell74 = row1.createCell(73);
			cell75 = row1.createCell(74);
			cell76 = row1.createCell(75);
			cell77 = row1.createCell(76);
			cell78 = row1.createCell(77);
			cell79 = row1.createCell(78);
			cell80 = row1.createCell(79);
			cell81 = row1.createCell(80);
			cell82 = row1.createCell(81);
			cell83 = row1.createCell(82);
			cell84 = row1.createCell(83);
			cell85 = row1.createCell(84);

			sheet.setColumnWidth(0, (20 * 90));
			sheet.setColumnWidth(1, (30 * 200));
			sheet.setColumnWidth(2, (20 * 200));
			sheet.setColumnWidth(3, (20 * 200));
			sheet.setColumnWidth(4, (20 * 200));
			sheet.setColumnWidth(5, (20 * 400));
			sheet.setColumnWidth(6, (20 * 200));
			sheet.setColumnWidth(7, (20 * 200));
			sheet.setColumnWidth(8, (20 * 240));
			sheet.setColumnWidth(9, (20 * 260));
			sheet.setColumnWidth(10, (20 * 200));
			sheet.setColumnWidth(11, (20 * 200));
			sheet.setColumnWidth(12, (20 * 200));
			sheet.setColumnWidth(13, (20 * 200));
			sheet.setColumnWidth(14, (20 * 200));
			sheet.setColumnWidth(15, (20 * 200));
			sheet.setColumnWidth(16, (20 * 200));
			sheet.setColumnWidth(18, (20 * 200));
			sheet.setColumnWidth(19, (20 * 200));
			sheet.setColumnWidth(20, (20 * 200));
			sheet.setColumnWidth(21, (20 * 200));
			sheet.setColumnWidth(22, (20 * 200));
			sheet.setColumnWidth(23, (20 * 200));
			sheet.setColumnWidth(24, (20 * 200));
			sheet.setColumnWidth(25, (20 * 200));
			sheet.setColumnWidth(26, (20 * 200));
			sheet.setColumnWidth(27, (20 * 200));
			sheet.setColumnWidth(28, (20 * 200));
			sheet.setColumnWidth(29, (20 * 200));
			sheet.setColumnWidth(30, (20 * 200));
			sheet.setColumnWidth(31, (20 * 200));
			sheet.setColumnWidth(32, (20 * 400));
			sheet.setColumnWidth(33, (20 * 400));
			sheet.setColumnWidth(34, (20 * 400));
			sheet.setColumnWidth(35, (20 * 400));
			sheet.setColumnWidth(36, (20 * 400));
			sheet.setColumnWidth(37, (20 * 400));
			sheet.setColumnWidth(38, (20 * 400));
			sheet.setColumnWidth(39, (20 * 400));
			sheet.setColumnWidth(40, (20 * 400));
			sheet.setColumnWidth(41, (20 * 400));
			sheet.setColumnWidth(42, (20 * 400));
			sheet.setColumnWidth(43, (20 * 400));
			sheet.setColumnWidth(44, (20 * 400));
			sheet.setColumnWidth(45, (20 * 400));
			sheet.setColumnWidth(46, (20 * 400));
			sheet.setColumnWidth(47, (20 * 400));
			sheet.setColumnWidth(48, (20 * 400));
			sheet.setColumnWidth(49, (20 * 400));
			sheet.setColumnWidth(50, (20 * 400));
			sheet.setColumnWidth(51, (20 * 400));
			sheet.setColumnWidth(52, (20 * 400));
			sheet.setColumnWidth(53, (20 * 400));
			sheet.setColumnWidth(54, (20 * 400));
			sheet.setColumnWidth(55, (20 * 400));
			sheet.setColumnWidth(56, (20 * 400));
			sheet.setColumnWidth(57, (20 * 400));
			sheet.setColumnWidth(58, (20 * 400));
			sheet.setColumnWidth(59, (20 * 400));
			sheet.setColumnWidth(60, (20 * 400));
			sheet.setColumnWidth(61, (20 * 400));
			sheet.setColumnWidth(62, (20 * 400));
			sheet.setColumnWidth(63, (20 * 400));
			sheet.setColumnWidth(64, (20 * 400));
			sheet.setColumnWidth(65, (20 * 400));
			sheet.setColumnWidth(66, (20 * 400));
			sheet.setColumnWidth(67, (20 * 400));
			sheet.setColumnWidth(68, (20 * 400));
			sheet.setColumnWidth(69, (20 * 400));
			sheet.setColumnWidth(70, (20 * 400));
			sheet.setColumnWidth(71, (20 * 400));
			sheet.setColumnWidth(72, (20 * 400));
			sheet.setColumnWidth(73, (20 * 400));
			sheet.setColumnWidth(74, (20 * 400));
			sheet.setColumnWidth(75, (20 * 400));
			sheet.setColumnWidth(76, (20 * 400));
			sheet.setColumnWidth(77, (20 * 400));
			sheet.setColumnWidth(78, (20 * 400));
			sheet.setColumnWidth(79, (20 * 400));
			sheet.setColumnWidth(80, (20 * 400));
			sheet.setColumnWidth(81, (20 * 400));
			sheet.setColumnWidth(82, (20 * 400));
			sheet.setColumnWidth(83, (20 * 400));
			sheet.setColumnWidth(84, (20 * 400));
			sheet.setColumnWidth(85, (20 * 400));

			cell1.setCellValue("Sl No.");
			cell2.setCellValue("CPI Code");
			cell3.setCellValue("Location Code");
			cell4.setCellValue("Tool Code");
			cell5.setCellValue("CPI Open Date");

			cell6.setCellValue("CPI Nature");

			cell7.setCellValue("Asset Type 1");
			cell8.setCellValue("Asset Name 1");
			cell9.setCellValue("Asset Sr No. 1");
			cell10.setCellValue("Section Name 1");
			cell11.setCellValue("Section Sr No. 1");

			cell12.setCellValue("Asset Type 2");
			cell13.setCellValue("Asset Name 2");
			cell14.setCellValue("Asset Sr No. 2");
			cell15.setCellValue("Section Name 2");
			cell16.setCellValue("Section Sr No. 2");

			cell17.setCellValue("Asset Type 3");
			cell18.setCellValue("Asset Name 3");
			cell19.setCellValue("Asset Sr No. 3");
			cell20.setCellValue("Section Name 3");
			cell21.setCellValue("Section Sr No. 3");

			cell22.setCellValue("Asset Type 4");
			cell23.setCellValue("Asset Name 4");
			cell24.setCellValue("Asset Sr No. 4");
			cell25.setCellValue("Section Name 4");
			cell26.setCellValue("Section Sr No. 4");

			cell27.setCellValue("Asset Type 5");
			cell28.setCellValue("Asset Name 5");
			cell29.setCellValue("Asset Sr No. 5");
			cell30.setCellValue("Section Name 5");
			cell31.setCellValue("Section Sr No. 5");

			cell32.setCellValue("Asset Type 6");
			
			cell33.setCellValue("Asset Name 6");
			cell34.setCellValue("Asset Sr No. 6");
			cell35.setCellValue("Section Name 6");
			cell36.setCellValue("Section Sr No. 6");

			cell37.setCellValue("Problem Details");

			cell38.setCellValue("CA1 Done By");
			cell39.setCellValue("CA1 Code");
			cell40.setCellValue("Open Date 1");
			cell41.setCellValue("Close Date 1");
			cell42.setCellValue("CA1 Done(Remarks)");

			cell43.setCellValue("CA2 Done By");
			cell44.setCellValue("CA2 Code");
			cell45.setCellValue("Open Date 2");
			cell46.setCellValue("Close Date 2");
			cell47.setCellValue("CA2 Done(Remarks)");

			cell48.setCellValue("CA3 Done By");
			cell49.setCellValue("CA3 Code");
			cell50.setCellValue("Open Date 3");
			cell51.setCellValue("Close Date 3");
			cell52.setCellValue("CA3 Done(Remarks)");

			cell53.setCellValue("CA4 Done By");
			cell54.setCellValue("CA4 Code");
			cell55.setCellValue("Open Date 4");
			cell56.setCellValue("Close Date 4");
			cell57.setCellValue("CA4 Done(Remarks)");

			cell58.setCellValue("CA5 Done By");
			cell59.setCellValue("CA5 Code");
			cell60.setCellValue("Open Date 5");
			cell61.setCellValue("Close Date 5");
			cell62.setCellValue("CA5 Done(Remarks)");

			cell63.setCellValue("CA6 Done By");
			cell64.setCellValue("CA6 Code");
			cell65.setCellValue("Open Date 6");
			cell66.setCellValue("Close Date 6");
			cell67.setCellValue("CA6 Done(Remarks)");

			cell68.setCellValue("Update Date ");
			cell69.setCellValue("CPI Status");
			cell70.setCellValue("Why Open");
			cell71.setCellValue("MRF No.");
			cell72.setCellValue("Remarks On MRF");
			cell73.setCellValue("PRCA");
			cell74.setCellValue("Date of PRCA");
			cell75.setCellValue("Type Of CPI");
			cell76.setCellValue("Impact To Customer");
			cell77.setCellValue("Effect On Customer");
			cell78.setCellValue("Source Of CPI");
			cell79.setCellValue("Category Code");
			cell80.setCellValue("Group Code");

			cell81.setCellValue("Asset Type (Faulty)");
			cell82.setCellValue("Asset Name (Faulty)");
			cell83.setCellValue("Asset Sr No. (Faulty)");
			cell84.setCellValue("Section Name (Faulty)");
			cell85.setCellValue("Section Sr No. (Faulty)");

			HSSFCellStyle style = wb.createCellStyle();
			style.setFillForegroundColor(HSSFColor.YELLOW.index);
			style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);

			HSSFCellStyle styleR = wb.createCellStyle();
			styleR.setFillForegroundColor(HSSFColor.RED.index);
			styleR.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);

			HSSFCellStyle styleG = wb.createCellStyle();
			styleG.setFillForegroundColor(HSSFColor.GREEN.index);
			styleG.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);

			HSSFCellStyle styleY = wb.createCellStyle();
			styleY.setFillForegroundColor(HSSFColor.YELLOW.index);
			styleY.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);

			HSSFCellStyle styleB = wb.createCellStyle();
			styleB.setFillForegroundColor(HSSFColor.BLUE.index);
			styleB.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
			Font font = wb.createFont();
			
			font.setBoldweight(Font.BOLDWEIGHT_BOLD);
			font.setFontHeight((short) 3000);

			cell1.setCellStyle(style);
			cell2.setCellStyle(style);
			cell3.setCellStyle(style);
			cell4.setCellStyle(style);
			cell5.setCellStyle(style);
			cell6.setCellStyle(style);
			cell7.setCellStyle(style);
			cell8.setCellStyle(style);
			cell9.setCellStyle(style);
			cell10.setCellStyle(style);
			cell11.setCellStyle(style);
			cell12.setCellStyle(style);
			cell13.setCellStyle(style);
			cell14.setCellStyle(style);
			cell15.setCellStyle(style);
			cell16.setCellStyle(style);
			cell17.setCellStyle(style);
			cell18.setCellStyle(style);
			cell19.setCellStyle(style);
			cell20.setCellStyle(style);
			cell21.setCellStyle(style);
			cell22.setCellStyle(style);
			cell23.setCellStyle(style);
			cell24.setCellStyle(style);
			cell25.setCellStyle(style);
			cell26.setCellStyle(style);
			cell27.setCellStyle(style);
			cell28.setCellStyle(style);
			cell29.setCellStyle(style);
			cell30.setCellStyle(style);
			cell31.setCellStyle(style);
			cell32.setCellStyle(style);
			cell33.setCellStyle(style);
			cell34.setCellStyle(style);
			cell35.setCellStyle(style);
			cell36.setCellStyle(style);
			cell37.setCellStyle(style);
			cell38.setCellStyle(style);
			cell39.setCellStyle(style);
			cell40.setCellStyle(style);
			cell41.setCellStyle(style);
			cell42.setCellStyle(style);
			cell43.setCellStyle(style);
			cell44.setCellStyle(style);
			cell45.setCellStyle(style);
			cell46.setCellStyle(style);
			cell47.setCellStyle(style);
			cell48.setCellStyle(style);
			cell49.setCellStyle(style);
			cell50.setCellStyle(style);
			cell51.setCellStyle(style);
			cell52.setCellStyle(style);
			cell53.setCellStyle(style);
			cell54.setCellStyle(style);
			cell55.setCellStyle(style);
			cell56.setCellStyle(style);
			cell57.setCellStyle(style);
			cell58.setCellStyle(style);
			cell59.setCellStyle(style);
			cell60.setCellStyle(style);
			cell61.setCellStyle(style);
			cell62.setCellStyle(style);
			cell63.setCellStyle(style);
			cell64.setCellStyle(style);
			cell65.setCellStyle(style);
			cell66.setCellStyle(style);
			cell67.setCellStyle(style);
			cell68.setCellStyle(style);
			cell69.setCellStyle(style);
			cell70.setCellStyle(style);
			cell71.setCellStyle(style);
			cell72.setCellStyle(style);
			cell73.setCellStyle(style);
			cell74.setCellStyle(style);
			cell75.setCellStyle(style);
			cell76.setCellStyle(style);
			cell77.setCellStyle(style);
			cell78.setCellStyle(style);
			cell79.setCellStyle(style);
			cell80.setCellStyle(style);
			cell81.setCellStyle(styleR);
			cell82.setCellStyle(styleR);
			cell83.setCellStyle(styleR);
			cell84.setCellStyle(styleR);
			cell85.setCellStyle(styleR);
			
			Iterator<CpiBean> cpiBeanLitIterator = cpiBeansList.iterator();
			while (cpiBeanLitIterator.hasNext()) {
				CpiBean cpiBean = cpiBeanLitIterator.next();
				row1 = sheet.createRow(rowNum++);

				cell1 = row1.createCell(0);
				cell1.setCellValue(cpiBean.getId());
				
				cell2 = row1.createCell(1);
				cell2.setCellValue(cpiBean.getCpiCd());
				cell3 = row1.createCell(2);
				cell3.setCellValue(cpiBean.getLocationCd());
				cell4 = row1.createCell(3);
				cell4.setCellValue(cpiBean.getMaintanenceType());

				cell5 = row1.createCell(4);
				cell5.setCellValue(cpiBean.getDateOfCpi());
				cell6 = row1.createCell(5);
				cell6.setCellValue(cpiBean.getCpiNature());

				// STACK RUN..

				cell7 = row1.createCell(6);
				cell7.setCellValue(cpiBean.getAssetType1());
				cell8 = row1.createCell(7);
				cell8.setCellValue(cpiBean.getAssetName1());
				cell9 = row1.createCell(8);
				cell9.setCellValue(cpiBean.getAssetSrNo1());
				cell10 = row1.createCell(9);
				cell10.setCellValue(cpiBean.getSectionName1());
				cell11 = row1.createCell(10);
				cell11.setCellValue(cpiBean.getSectionSerialNo1());

				cell12 = row1.createCell(11);
				cell12.setCellValue(cpiBean.getAssetType2());
				cell13 = row1.createCell(12);
				cell13.setCellValue(cpiBean.getAssetName2());
				cell14 = row1.createCell(13);
				cell14.setCellValue(cpiBean.getAssetSrNo2());
				cell15 = row1.createCell(14);
				cell15.setCellValue(cpiBean.getSectionName2());
				cell16 = row1.createCell(15);
				cell16.setCellValue(cpiBean.getSectionSerialNo2());

				cell17 = row1.createCell(16);
				cell17.setCellValue(cpiBean.getAssetType3());
				cell18 = row1.createCell(17);
				cell18.setCellValue(cpiBean.getAssetName3());
				cell19 = row1.createCell(18);
				cell19.setCellValue(cpiBean.getAssetSrNo3());
				cell20 = row1.createCell(19);
				cell20.setCellValue(cpiBean.getSectionName3());
				cell21 = row1.createCell(20);
				cell21.setCellValue(cpiBean.getSectionSerialNo3());

				cell22 = row1.createCell(21);
				cell22.setCellValue(cpiBean.getAssetType4());
				cell23 = row1.createCell(22);
				cell23.setCellValue(cpiBean.getAssetName4());
				cell24 = row1.createCell(23);
				cell24.setCellValue(cpiBean.getAssetSrNo4());
				cell25 = row1.createCell(24);
				cell25.setCellValue(cpiBean.getSectionName4());
				cell26 = row1.createCell(25);
				cell26.setCellValue(cpiBean.getSectionSerialNo4());

				cell26 = row1.createCell(26);
				cell26.setCellValue(cpiBean.getAssetType5());
				cell27 = row1.createCell(27);
				cell27.setCellValue(cpiBean.getAssetName5());
				cell28 = row1.createCell(28);
				cell28.setCellValue(cpiBean.getAssetSrNo5());
				cell30 = row1.createCell(29);
				cell30.setCellValue(cpiBean.getSectionName5());
				cell31 = row1.createCell(30);
				cell31.setCellValue(cpiBean.getSectionSerialNo5());

				cell32 = row1.createCell(31);
				cell32.setCellValue(cpiBean.getAssetType6());
				cell33 = row1.createCell(32);
				cell33.setCellValue(cpiBean.getAssetName6());
				cell34 = row1.createCell(33);
				cell34.setCellValue(cpiBean.getAssetSrNo6());
				cell35 = row1.createCell(34);
				cell35.setCellValue(cpiBean.getSectionName6());
				cell36 = row1.createCell(35);
				cell36.setCellValue(cpiBean.getSectionSerialNo6());

				cell37 = row1.createCell(36);
				cell37.setCellValue(cpiBean.getProblem());

				cell38 = row1.createCell(37);
				cell38.setCellValue(cpiBean.getCorrectiveActionDoneBy1());
				cell39 = row1.createCell(38);
				cell39.setCellValue(cpiBean.getCorrectiveActionCode1());
				cell40 = row1.createCell(39);
				cell40.setCellValue(cpiBean.getOpenDate1());
				cell41 = row1.createCell(40);
				cell41.setCellValue(cpiBean.getCloseDate1());
				cell42 = row1.createCell(41);
				cell42.setCellValue(cpiBean.getCorrectiveAction1());

				cell43 = row1.createCell(42);
				cell43.setCellValue(cpiBean.getCorrectiveActionDoneBy2());
				cell44 = row1.createCell(43);
				cell44.setCellValue(cpiBean.getCorrectiveActionCode2());
				cell45 = row1.createCell(44);
				cell45.setCellValue(cpiBean.getOpenDate2());
				cell46 = row1.createCell(45);
				cell46.setCellValue(cpiBean.getCloseDate2());
				cell47 = row1.createCell(46);
				cell47.setCellValue(cpiBean.getCorrectiveAction2());

				cell48 = row1.createCell(47);
				cell48.setCellValue(cpiBean.getCorrectiveActionDoneBy3());
				cell49 = row1.createCell(48);
				cell49.setCellValue(cpiBean.getCorrectiveActionCode3());
				cell50 = row1.createCell(49);
				cell50.setCellValue(cpiBean.getOpenDate3());
				cell51 = row1.createCell(50);
				cell51.setCellValue(cpiBean.getCloseDate3());
				cell52 = row1.createCell(51);
				cell52.setCellValue(cpiBean.getCorrectiveAction3());

				cell53 = row1.createCell(52);
				cell53.setCellValue(cpiBean.getCorrectiveActionDoneBy4());
				cell54 = row1.createCell(53);
				cell54.setCellValue(cpiBean.getCorrectiveActionCode4());
				cell55 = row1.createCell(54);
				cell55.setCellValue(cpiBean.getOpenDate4());
				cell56 = row1.createCell(55);
				cell56.setCellValue(cpiBean.getCloseDate4());
				cell57 = row1.createCell(56);
				cell57.setCellValue(cpiBean.getCorrectiveAction4());

				cell58 = row1.createCell(57);
				cell58.setCellValue(cpiBean.getCorrectiveActionDoneBy5());
				cell59 = row1.createCell(58);
				cell59.setCellValue(cpiBean.getCorrectiveActionCode5());
				cell60 = row1.createCell(59);
				cell60.setCellValue(cpiBean.getOpenDate5());
				cell61 = row1.createCell(60);
				cell61.setCellValue(cpiBean.getCloseDate5());
				cell62 = row1.createCell(61);
				cell62.setCellValue(cpiBean.getCorrectiveAction5());

				cell63 = row1.createCell(62);
				cell63.setCellValue(cpiBean.getCorrectiveActionDoneBy6());
				cell64 = row1.createCell(63);
				cell64.setCellValue(cpiBean.getCorrectiveActionCode6());
				cell65 = row1.createCell(64);
				cell65.setCellValue(cpiBean.getOpenDate6());
				cell66 = row1.createCell(65);
				cell66.setCellValue(cpiBean.getCloseDate6());
				cell67 = row1.createCell(66);
				cell67.setCellValue(cpiBean.getCorrectiveAction6());

				cell68 = row1.createCell(67);
				cell68.setCellValue(cpiBean.getUpdateDate());

				cell69 = row1.createCell(68);
				if (cpiBean.getCpiStatus().equalsIgnoreCase( "OPEN_RED")) {					
					cell69.setCellStyle(styleR);
				}
				if (cpiBean.getCpiStatus().equalsIgnoreCase("CLOSE_GREEN")){ 					
					cell69.setCellStyle(styleG);
				}
				if (cpiBean.getCpiStatus().equalsIgnoreCase("OPEN_YELLOW")) {
					cell69.setCellStyle(styleY);
				}
				if (cpiBean.getCpiStatus().equalsIgnoreCase("OPEN_BLUE")) {
					cell69.setCellStyle(styleB);
				}
				

				cell69.setCellValue(cpiBean.getCpiStatus());
				cell70 = row1.createCell(69);
				cell70.setCellValue(cpiBean.getWhyOpen());
				cell71 = row1.createCell(70);
				cell71.setCellValue(cpiBean.getMrfNo());
				cell72 = row1.createCell(71);
				cell72.setCellValue(cpiBean.getRemarksOnMrf());
				cell73 = row1.createCell(72);
				cell73.setCellValue(cpiBean.getPrcaRemarks());
				cell74 = row1.createCell(73);
				cell74.setCellValue(cpiBean.getDateOfPrca());
				cell75 = row1.createCell(74);
				cell75.setCellValue(cpiBean.getCpiType());
				cell76 = row1.createCell(75);
				cell76.setCellValue(cpiBean.getImpactToCoustomer());
				cell77 = row1.createCell(76);
				cell77.setCellValue(cpiBean.getEffectOnCustomer());
				cell78 = row1.createCell(77);
				cell78.setCellValue(cpiBean.getSourceOfCpi());
				cell79 = row1.createCell(78);
				cell79.setCellValue(cpiBean.getCategory());
				cell80 = row1.createCell(79);
				cell80.setCellValue(cpiBean.getGroupCode());

				// FAULTY
				cell81 = row1.createCell(80);
				cell81.setCellValue(cpiBean.getAssetType());
				cell82 = row1.createCell(81);
				cell82.setCellValue(cpiBean.getAssetName());
				cell83 = row1.createCell(82);
				cell83.setCellValue(cpiBean.getAssetSrNo());
				cell84 = row1.createCell(83);
				cell84.setCellValue(cpiBean.getSectionName());
				cell85 = row1.createCell(84);
				cell85.setCellValue(cpiBean.getSectionSerialNo());

			}
			wb.write(fileOut);
			fileOut.flush();
			fileOut.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	@SuppressWarnings("unchecked")
	public String genereateCpiCd(String codeType) {

		
		String latestCpiNo = "";
		Session session = null;
		Transaction transaction = null;
		List<String> codeTypeList = null;
		String updateQuery = null;
		String updateNo = "";
		int nextNo = 0;
		try {
			session = HibernateSession.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(NumberingBean.class);
			ProjectionList projectionList = Projections.projectionList();
			criteria.add(Restrictions.like("codeType", codeType));
			projectionList.add(Projections.property("latestNo"));
			criteria.setProjection(projectionList);
			codeTypeList = criteria.list();
			Iterator<String> codeTypeIterator = codeTypeList.iterator();
			while (codeTypeIterator.hasNext()) {
				latestCpiNo = codeTypeIterator.next();
			}

			transaction.commit();
			session.close();

			nextNo = Integer.parseInt(latestCpiNo) + 1;
			updateNo = String.valueOf(nextNo);

			
			

			updateQuery = "update NumberingBean set latestNo =:latestNo where codeType=:codeType";
			session = HibernateSession.getSessionFactory().openSession();
			transaction = session.beginTransaction();

			Query updateNumberingQuery = session.createQuery(updateQuery);
			updateNumberingQuery.setString("latestNo", updateNo);
			updateNumberingQuery.setString("codeType", codeType);
			updateNumberingQuery.executeUpdate();
			transaction.commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session.isConnected()) {
				session.close();
				HibernateSession.shoutDown();
			}
		}
		return latestCpiNo;
	}

	public List<CpiBean> getCpi(String fromDate, String toDate, String cpiCd,
			String cpiStatus, String assertCd, String sectionSrNo) {
		List<CpiBean> cpiBeanList = null;
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateSession.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(CpiBean.class);

			criteria.add(Restrictions.ge("dateOfCpi", fromDate));
			criteria.add(Restrictions.le("dateOfCpi", toDate));
			if (!cpiCd.equalsIgnoreCase("-Select-")) {
				criteria.add(Restrictions.like("cpiCd", cpiCd));
			}

			if (!cpiStatus.equalsIgnoreCase("-Select-")) {
				criteria.add(Restrictions.like("cpiStatus", cpiStatus));
			}

			if (!assertCd.equalsIgnoreCase("-Select-")) {
				criteria.add(Restrictions.like("assetName1", assertCd));
			}

			if (!sectionSrNo.equalsIgnoreCase("-Select-")) {
				criteria.add(Restrictions.like("sectionSerialNo", sectionSrNo));
			}

			cpiBeanList = criteria.list();
			transaction.commit();
		} catch (HibernateException e) {
			if (transaction.wasCommitted()) {
				transaction.rollback();
				e.printStackTrace();

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session.isConnected()) {
				session.close();
				HibernateSession.shoutDown();
			}
		}
		return cpiBeanList;
	}
}
