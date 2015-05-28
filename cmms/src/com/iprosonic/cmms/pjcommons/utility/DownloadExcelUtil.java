package com.iprosonic.cmms.pjcommons.utility;
import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import com.iprosonic.cmms.modules.job.transactions.job.domain.JobBean;
import com.iprosonic.cmms.modules.job.transactions.job.service.DownloadWasService;
public class DownloadExcelUtil {
	public static void downloadExcelUtil(ServletContext context,
			HttpServletResponse response, String jobNo) throws Exception {
		File file = null;
		
		MyPropertiesReader myPropertiesReader = new MyPropertiesReader();
		String downloadPath = myPropertiesReader.getFilePath("downloadPath");
		String filePath = context.getRealPath(downloadPath);
		filePath = filePath + File.separator + jobNo + ".xls";
		System.out.println("**********filePath********"+filePath);
		DownloadWasService.generateWas(jobNo, filePath);
		ServletOutputStream out = null;
		FileInputStream fis = null;
		file = new File(filePath);
		fis = new FileInputStream(file);
		out = response.getOutputStream();
		byte[] outputByte = new byte[(int) file.length()];
		
		while (fis.read(outputByte, 0, (int) file.length()) != -1) {
			out.write(outputByte, 0, (int) file.length());
		}
	}
	
	public static void downloadExcelAllJobUtil(ServletContext context,
			HttpServletResponse response,List jobList) throws Exception {
		File file = null;
		
		MyPropertiesReader myPropertiesReader = new MyPropertiesReader();
		String downloadPath = myPropertiesReader.getFilePath("downloadPath");
		String filePath = context.getRealPath(downloadPath);
		filePath = filePath + File.separator+"AllJobExcel.xls";
		System.out.println("**********filePath********"+filePath);
		DownloadWasService.genrateAllWas(jobList,filePath);
		Iterator itr=jobList.iterator();
		while (itr.hasNext()) {
			JobBean object = (JobBean) itr.next();
			
		}
		ServletOutputStream out = null;
		FileInputStream fis = null;
		file = new File(filePath);
		fis = new FileInputStream(file);
		out = response.getOutputStream();
		byte[] outputByte = new byte[(int) file.length()];
		
		while (fis.read(outputByte, 0, (int) file.length()) != -1) {
			out.write(outputByte, 0, (int) file.length());
		}
	}
	
	
	
		
	

}
