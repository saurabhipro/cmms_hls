package com.iprosonic.cmms.modules.cpi.transactions.cpi.web;
import java.io.File;
import java.io.FileInputStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.iprosonic.cmms.modules.cpi.transactions.cpi.domain.CpiBean;
import com.iprosonic.cmms.modules.cpi.transactions.cpi.service.CpiService;
import com.iprosonic.cmms.pjcommons.utility.ContextFile;
import com.iprosonic.cmms.pjcommons.utility.MyPropertiesReader;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class PrintCpiAction extends ActionSupport implements
		ModelDriven<CpiBean> {

	private static final long serialVersionUID = 1L;
	private CpiBean cpiBean = new CpiBean();
	CpiService cpiService = new CpiService();

	@Override
	public String execute() {
		String cpiCd = getModel().getCpiCd();
		cpiService.generateCpiPdf(cpiCd);

		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/octet-stream");
		response.setHeader("Content-Disposition", "attachment;filename="
				+ cpiCd + ".pdf");

		File file = null;
		MyPropertiesReader myPropertiesReader = new MyPropertiesReader();
		String downloadPath = myPropertiesReader.getFilePath("pdfdownload");

		String filePath = ContextFile.getContextFile(downloadPath);
		
		ServletOutputStream out = null;
		FileInputStream fis = null;
		try {

			file = new File(filePath);
			fis = new FileInputStream(file);
			out = response.getOutputStream();
			byte[] outputByte = new byte[(int) file.length()];
			while (fis.read(outputByte, 0, (int) file.length()) != -1) {
				out.write(outputByte, 0, (int) file.length());

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fis.close();
				out.flush();
				out.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return NONE;
	}

	@Override
	public CpiBean getModel() {
		return cpiBean;
	}

	public void setCpiBean(CpiBean cpiBean) {
		this.cpiBean = cpiBean;
	}

	public CpiBean getCpiBean() {
		return cpiBean;
	}

}
