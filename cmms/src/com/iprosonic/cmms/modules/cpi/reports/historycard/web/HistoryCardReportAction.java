package com.iprosonic.cmms.modules.cpi.reports.historycard.web;
import java.io.File;
import java.io.FileInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
import com.iprosonic.cmms.modules.cpi.reports.historycard.service.HistoryCardReportService;
import com.iprosonic.cmms.pjcommons.utility.ContextFile;
import com.opensymphony.xwork2.ActionSupport;

public class HistoryCardReportAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	HistoryCardReportService historyCardReportService = new HistoryCardReportService();

	@Override
	public String execute() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/vnd.ms-excel");
		
		String excelPath=ContextFile.getContextFile("historyCardExcelPath");
		historyCardReportService.generateHistoryCardReport(
				request.getParameter("assetType"),
				request.getParameter("assetName"),
				request.getParameter("assetSrNo"),
				request.getParameter("sectionName"),
				request.getParameter("sectionSerialNo"),excelPath);
		
		File file = null;
		String downloadPath = excelPath;
		ServletOutputStream out = null;
		FileInputStream fis = null;
		try {
			file = new File(downloadPath);
			fis = new FileInputStream(file);
			out = response.getOutputStream();
			byte[] outputByte = new byte[(int) file.length()];
			while (fis.read(outputByte, 0, (int) file.length()) != -1) {
				out.write(outputByte, 0, (int) file.length());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			try {
				fis.close();
				out.flush();
				out.close();

			}

			catch (Exception e) {
				e.printStackTrace();
			}
		}
		// file.delete();

		return NONE;
	}

}
