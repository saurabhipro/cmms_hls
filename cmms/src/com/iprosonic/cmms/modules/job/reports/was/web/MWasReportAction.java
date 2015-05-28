package com.iprosonic.cmms.modules.job.reports.was.web;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.iprosonic.cmms.modules.cpi.transactions.cpi.domain.CpiBean;
import com.iprosonic.cmms.modules.cpi.transactions.cpi.service.CpiService;
import com.iprosonic.cmms.modules.job.reports.was.service.MWASReportService;
import com.iprosonic.cmms.pjcommons.utility.ContextFile;
import com.iprosonic.cmms.pjcommons.utility.MyPropertiesReader;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class MWasReportAction extends ActionSupport implements
		ModelDriven<CpiBean> {

	private static final long serialVersionUID = 1L;
	private CpiBean cpiBean = new CpiBean();
	private List<CpiBean> cpiBeanList;
	CpiService cpiService = new CpiService();

	@Override
	public String execute() {

		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/vnd.ms-excel");
		String fromDate = request.getParameter("fromDate");
		String toDate = request.getParameter("toDate");

		MWASReportService mwasReportService = new MWASReportService();

		mwasReportService.generateMWasReport(fromDate, toDate, getModel()
				.getCpiCd(), getModel().getUnitCd(), getModel().getCpiStatus(),
				getModel().getAssetType(), getModel()
						.getCorrectiveActionDoneBy1(), getModel()
						.getCpiNature(), getModel().getImpactToCoustomer(),
				getModel().getEffectOnCustomer(), getModel().getSourceOfCpi(),
				getModel().getSubSourceOfCpi(), getModel().getGroupCode(),
				getModel().getSubGroupCd(), getModel().getCategory(),
				getModel().getSubCategory(), getModel().getPrcaDoneBy(),
				getModel().getFrcaDoneBy());
		File file = null;

		MyPropertiesReader myPropertiesReader = new MyPropertiesReader();
		String downloadPath = myPropertiesReader.getFilePath("exceldownload");

		ServletOutputStream out = null;
		FileInputStream fis = null;
		try {

			file = new File(ContextFile.getContextFile(downloadPath));
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

				file.delete();

			}

			catch (Exception e) {
				e.printStackTrace();
			}
		}
		file.delete();

		return SUCCESS;
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

	public void setCpiBeanList(List<CpiBean> cpiBeanList) {
		this.cpiBeanList = cpiBeanList;
	}

	public List<CpiBean> getCpiBeanList() {
		return cpiBeanList;
	}

}
