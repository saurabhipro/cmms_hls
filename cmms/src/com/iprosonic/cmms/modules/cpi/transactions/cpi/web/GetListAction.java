package com.iprosonic.cmms.modules.cpi.transactions.cpi.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.iprosonic.cmms.modules.cpi.transactions.cpi.service.CpiService;
import com.iprosonic.cmms.pjcommons.valuelist.AssetCdStrAction;
import com.iprosonic.cmms.pjcommons.valuelist.AssetSrNoStrAction;
import com.iprosonic.cmms.pjcommons.valuelist.CPITypeAction;
import com.iprosonic.cmms.pjcommons.valuelist.ClientCdListAction;
import com.iprosonic.cmms.pjcommons.valuelist.EmployeeCdListAction;
import com.iprosonic.cmms.pjcommons.valuelist.LocationRegionCdListAction;
import com.iprosonic.cmms.pjcommons.valuelist.MaintainanceTypeCdAction;
import com.iprosonic.cmms.pjcommons.valuelist.OriginatedByAction;
import com.iprosonic.cmms.pjcommons.valuelist.SectionNameStrAction;
import com.iprosonic.cmms.pjcommons.valuelist.SectionSrNoStrAction;
import com.iprosonic.cmms.pjcommons.valuelist.ServiceFlgStrAction;
import com.iprosonic.cmms.pjcommons.valuelist.ServiceNameStrAction;
import com.iprosonic.cmms.pjcommons.valuelist.SubCategoryCdStrAction;
import com.iprosonic.cmms.pjcommons.valuelist.SubGroupCodeStrAction;
import com.iprosonic.cmms.pjcommons.valuelist.SubSourceOfCpiAction;
import com.opensymphony.xwork2.ActionSupport;

public class GetListAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	CpiService cpiSevice = new CpiService();
	private List<String> locationCdList = null;
	LocationRegionCdListAction locationRegionCdListAction = new LocationRegionCdListAction();
	ClientCdListAction clentCdListAction = new ClientCdListAction();
	EmployeeCdListAction employeeCdListAction = new EmployeeCdListAction();
	CPITypeAction cpiTypeAction = new CPITypeAction();
	MaintainanceTypeCdAction maintainceTypeCdAction = new MaintainanceTypeCdAction();
	AssetCdStrAction assertCdStrAction = new AssetCdStrAction();
	AssetSrNoStrAction assertSrNoStrAction = new AssetSrNoStrAction();
	SectionNameStrAction sectionNameStrAction = new SectionNameStrAction();
	SectionSrNoStrAction sectionSrNoStrAction = new SectionSrNoStrAction();
	OriginatedByAction originatedByAction = new OriginatedByAction();
	SubSourceOfCpiAction subSourceOfCpiAction = new SubSourceOfCpiAction();
	SubGroupCodeStrAction subGroupCodeStrAction = new SubGroupCodeStrAction();
	SubCategoryCdStrAction subCategoryCdStrAction = new SubCategoryCdStrAction();

	@Override
	public String execute() {
		
		String outputString = null;

		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html");
		HttpServletRequest request = ServletActionContext.getRequest();
		if (request.getParameter("param").equalsIgnoreCase("getLocationCd")) {
			outputString = locationRegionCdListAction
					.getLocationCdString(request.getParameter("regionCd"));
		}

		if (request.getParameter("param").equalsIgnoreCase("getClientCd")) {
			outputString = clentCdListAction.getClientCdString(request
					.getParameter("unitCd"));

		}

		if (request.getParameter("param").equalsIgnoreCase("getAssetCd1")) {
			outputString = assertCdStrAction.getAssetCd(request
					.getParameter("assetType1"));

		}
		if (request.getParameter("param").equalsIgnoreCase("getAssetSrNo1")) {

			outputString = assertSrNoStrAction.getAssetSrNo(
					request.getParameter("assetSrNo1"), "getAssetSrNo1");
		}

		if (request.getParameter("param").equalsIgnoreCase("getSectionName1")) {
			outputString = sectionNameStrAction.getSectionName(
					request.getParameter("assetSrNo1"), "getSectionName1");
		}
		if (request.getParameter("param").equalsIgnoreCase(
				"getSectionSerialNo1")) {
			outputString = sectionSrNoStrAction
					.getSectionSrNo(request.getParameter("sectionName1"),
							"getSectionSerialNo1");
		}

		// CPI
		if (request.getParameter("param").equalsIgnoreCase(

		"getSubSourceOfCpi")) {

			outputString = subSourceOfCpiAction.getSubSourceOfCpiStr(request
					.getParameter("sourceOfCpi"));

		}

		if (request.getParameter("param").equalsIgnoreCase(

		"getSubGroupCd")) {

			outputString = subGroupCodeStrAction.getSubGroupCodeStr(request
					.getParameter("groupCd"));

		}

		if (request.getParameter("param").equalsIgnoreCase(

		"getSubCategoryCd")) {
			

			outputString = subCategoryCdStrAction.getSubCaregoryStr(request
					.getParameter("category"));

		}

		if (request.getParameter("param").equalsIgnoreCase("getServiceName")) {

			outputString = ServiceNameStrAction.getServiceName(request
					.getParameter("serviceType"));

		}

		if (request.getParameter("param").equalsIgnoreCase("getServiceFlg")) {
			outputString = ServiceFlgStrAction.getServiceFlg(request
					.getParameter("serviceName"));

		}

		// job

		try {
			
			PrintWriter out = response.getWriter();
			out.print(outputString);

		} catch (IOException e) {
			e.printStackTrace();
		}
		return NONE;
	}

	public void setLocationCdList(List<String> locationCdList) {
		this.locationCdList = locationCdList;
	}

	public List<String> getLocationCdList() {
		return locationCdList;
	}

}
