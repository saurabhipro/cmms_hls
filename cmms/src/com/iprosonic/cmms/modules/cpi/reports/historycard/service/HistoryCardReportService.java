package com.iprosonic.cmms.modules.cpi.reports.historycard.service;


import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Font;

import com.iprosonic.cmms.modules.cpi.transactions.cpi.dao.CpiDAOImpl;
import com.iprosonic.cmms.modules.cpi.transactions.cpi.domain.CpiBean;

public class HistoryCardReportService {
	public void generateHistoryCardReport(String assetType, String assetCode,
			String assetSrNo, String sectionName, String sectionSrNo,String excelPath) {
		CpiDAOImpl cpiDAOImpl = new CpiDAOImpl();
		List<CpiBean> cpiBeansList = cpiDAOImpl.getCpiList(sectionName,sectionSrNo);
		try {

			String historyCardHeaderArray[] = { "Asset Type", "Asset Code",
					"Asset Sr No", "Section Name" };
			String historyCardValueArray[] = { assetType, assetCode, assetSrNo,
					sectionSrNo };

			String maintainanceHeaderArray[] = { "SL No","CPI No", "Location Code","Tool Code","CPI Open Date","CPI Nature","Asset Type 1","Asset Name","Asset Sr No","Faulty Section Name","Faulty Section Sr No","Problem Details","CA1 Done ByProblem Details","CA1 Done(Remarks)","CA2 Done By","CA2 Done(Remarks)","Update Date","CPI Status","Why Open"};
			String nomemHeaderArray[] ={"CPI NO", "CPI Date",	"CPI CREATED BY"};			
			String nomemValueArray[] = { "NA", "NA", "NA" };
			String oebHeaderArray[] = { "CPI NO", "CPI Date", "CPI CREATED BY" };
			String oebValueArray[] = { "NA", "NA", "NA" };
			String counterReadingHeaderArray[] = { "Date", "used Hrs",
					"Max Temperature Exposed", "Job No.", "Vibration",
					"Special Job(TPL,Fishing)", "Value", "Counter" };
			String counterReadingValueArray[] = { "0", "0", "0", "0", "0", "0",
					"0", "0" };
			String jobHeaderArray[] = { "CPI NO", "CPI Date", "CPI CREATED BY" };
			String jobValuesArray[] = { "CPI NO", "CPI Date", "CPI CREATED BY" };			
			String movementsHeaderArray[] = { "Date", "Location(To)","Location(From)", "Assign/Done", "Remarks" };
			String movementsValuesArray[] = { "Date", "Location(To)","Location(From)", "Assign/Done", "Remarks" };
			
			String fileDownloadPath = excelPath;

			FileOutputStream fileOut = null;
			String filePath = null;
		//	filePath = fileDownloadPath + "historyCard.xls";
			filePath=fileDownloadPath;
			fileOut = new FileOutputStream(filePath);
			HSSFWorkbook wb = new HSSFWorkbook();
			HSSFSheet sheet = wb.createSheet();
			HSSFRow row = null;
			HSSFCell cell = null;
			short rowNum = 1;
			sheet.setColumnWidth(0, (10000));
			HSSFCellStyle styleH = wb.createCellStyle();
			styleH.setFillForegroundColor(HSSFColor.GREEN.index);
			styleH.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
			Font font = wb.createFont();
			font.setBoldweight(Font.BOLDWEIGHT_BOLD);
			font.setFontHeight((short) 3000);
			HSSFCellStyle styleY = wb.createCellStyle();
			styleY.setFillForegroundColor(HSSFColor.YELLOW.index);
			styleY.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);

			for (int i = 0; i < historyCardHeaderArray.length; i++) {
				row = sheet.createRow(rowNum++);
				cell = row.createCell(0);
				cell.setCellStyle(styleH);
				cell.setCellValue(historyCardValueArray[i]);
				cell = row.createCell(1);
				cell.setCellValue(historyCardValueArray[i]);
			}

			row = sheet.createRow(rowNum++);

			for (int i = 0; i < maintainanceHeaderArray.length; i++) {
				cell = row.createCell(i);
				cell.setCellStyle(styleH);
				cell.setCellValue(maintainanceHeaderArray[i]);
			}
			row = sheet.createRow(rowNum++);
			Iterator<CpiBean> cpiBeanLitIterator = cpiBeansList.iterator();
			int slNo= 1;
			while (cpiBeanLitIterator.hasNext()) {
				CpiBean cpiBean = cpiBeanLitIterator.next();
				row = sheet.createRow(rowNum++);
				
				cell = row.createCell(0);
				cell.setCellStyle(styleY);
				cell.setCellValue(slNo);
				
				cell = row.createCell(1);
				cell.setCellStyle(styleY);
				cell.setCellValue(cpiBean.getCpiCd());
				
				cell = row.createCell(2);
				cell.setCellStyle(styleY);
				cell.setCellValue(cpiBean.getLocationCd());
				
				
				cell = row.createCell(3);
				cell.setCellStyle(styleY);
				cell.setCellValue(cpiBean.getAssetType());
				
				cell = row.createCell(4);
				cell.setCellStyle(styleY);
				cell.setCellValue(cpiBean.getOpenDate1());
				
				
				cell = row.createCell(5);
				cell.setCellStyle(styleY);
				cell.setCellValue(cpiBean.getCpiNature());
				
				
				cell = row.createCell(6);
				cell.setCellStyle(styleY);
				cell.setCellValue(cpiBean.getAssetName());
				
				
				cell = row.createCell(7);
				cell.setCellStyle(styleY);
				cell.setCellValue(cpiBean.getAssetName());
				
				cell = row.createCell(8);
				cell.setCellStyle(styleY);
				cell.setCellValue(cpiBean.getAssetSrNo());
				
				
				cell = row.createCell(9);
				cell.setCellStyle(styleY);
				cell.setCellValue(cpiBean.getSectionName());
				
				cell = row.createCell(10);
				cell.setCellStyle(styleY);
				cell.setCellValue(cpiBean.getAssetSrNo());
				
				cell = row.createCell(11);
				cell.setCellStyle(styleY);
				cell.setCellValue(cpiBean.getCorrectiveActionCode1());
				
				cell = row.createCell(12);
				cell.setCellStyle(styleY);
				cell.setCellValue(cpiBean.getCorrectiveAction1());
				
				cell = row.createCell(13);
				cell.setCellStyle(styleY);
				cell.setCellValue(cpiBean.getCorrectiveActionDoneBy1());
				
				cell = row.createCell(14);
				cell.setCellStyle(styleY);
				cell.setCellValue(cpiBean.getCorrectiveAction2());
				
				
				cell = row.createCell(15);
				cell.setCellStyle(styleY);
				cell.setCellValue(cpiBean.getUpdateDate());
				
				
				cell = row.createCell(16);
				cell.setCellStyle(styleY);
				cell.setCellValue(cpiBean.getCpiStatus());
				
				cell = row.createCell(17);
				cell.setCellStyle(styleY);
				cell.setCellValue(cpiBean.getWhyOpen());
				
				cell = row.createCell(18);
				cell.setCellStyle(styleY);
				cell.setCellValue(cpiBean.getWhyOpen());
				
				
				
				
				
				
				
				
				slNo++;
			}
			
			

			// NOMEM OEB
			row = sheet.createRow(rowNum++);
			for (int i = 0; i < nomemHeaderArray.length; i++) {
				cell = row.createCell(i);
				cell.setCellStyle(styleH);
				cell.setCellValue(nomemHeaderArray[i]);
			}
			row = sheet.createRow(rowNum++);
			for (int i = 0; i < nomemHeaderArray.length; i++) {
				cell = row.createCell(i);
				cell.setCellStyle(styleY);
				cell.setCellValue(nomemValueArray[i]);
			}
			
			// OEB
			row = sheet.createRow(rowNum++);
			row = sheet.createRow(rowNum++);
			for (int i = 0; i < oebHeaderArray.length; i++) {
				cell = row.createCell(i);
				cell.setCellStyle(styleH);
				cell.setCellValue(oebHeaderArray[i]);
			}
			row = sheet.createRow(rowNum++);
			for (int i = 0; i < oebHeaderArray.length; i++) {
				cell = row.createCell(i);
				cell.setCellStyle(styleY);
				cell.setCellValue(oebValueArray[i]);
			}
			
			// Counter
			row = sheet.createRow(rowNum++);
			row = sheet.createRow(rowNum++);
			for (int i = 0; i < counterReadingHeaderArray.length; i++) {
				cell = row.createCell(i);
				cell.setCellStyle(styleH);
				cell.setCellValue(counterReadingHeaderArray[i]);
			}
			row = sheet.createRow(rowNum++);
			for (int i = 0; i < counterReadingValueArray.length; i++) {
				cell = row.createCell(i);
				cell.setCellStyle(styleY);
				cell.setCellValue(counterReadingValueArray[i]);
			}

			// JOB
			row = sheet.createRow(rowNum++);
			row = sheet.createRow(rowNum++);			
			for (int i = 0; i < jobHeaderArray.length; i++) {
				cell = row.createCell(i);
				cell.setCellStyle(styleH);
				cell.setCellValue(jobHeaderArray[i]);
			}
			row = sheet.createRow(rowNum++);
			for (int i = 0; i < jobValuesArray.length; i++) {
				cell = row.createCell(i);
				cell.setCellStyle(styleY);
				cell.setCellValue(jobValuesArray[i]);
			}
			
			// MOVEMENTS
			row = sheet.createRow(rowNum++);
			row = sheet.createRow(rowNum++);
			for (int i = 0; i < movementsHeaderArray.length; i++) {
				cell = row.createCell(i);
				cell.setCellStyle(styleH);
				cell.setCellValue(movementsHeaderArray[i]);
			}
			row = sheet.createRow(rowNum++);
			for (int i = 0; i < movementsValuesArray.length; i++) {
				cell = row.createCell(i);
				cell.setCellStyle(styleY);
				cell.setCellValue(movementsValuesArray[i]);
			}
			
			wb.write(fileOut);
			fileOut.flush();
			fileOut.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
