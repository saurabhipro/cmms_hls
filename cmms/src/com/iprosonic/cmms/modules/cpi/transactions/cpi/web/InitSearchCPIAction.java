package com.iprosonic.cmms.modules.cpi.transactions.cpi.web;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.iprosonic.cmms.modules.cpi.transactions.cpi.dao.CpiDAOImpl;
import com.iprosonic.cmms.modules.cpi.transactions.cpi.domain.CpiBean;
import com.iprosonic.cmms.modules.cpi.transactions.cpi.service.CpiService;
import com.iprosonic.cmms.pjcommons.valuelist.AssetCdStrAction;
import com.iprosonic.cmms.pjcommons.valuelist.CPICdListAction;
import com.iprosonic.cmms.pjcommons.valuelist.CpiGetList;
import com.iprosonic.cmms.pjcommons.valuelist.SectionSrNoStrAction;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class InitSearchCPIAction extends ActionSupport implements SessionAware, ModelDriven<CpiBean> {

	private static final long	serialVersionUID		= 1L;
	private Map<String, Object>	session;
	private List<String>		cpiCdList;
	private List<String>		cpiStatusList;
	private List<String>		assetCdList;
	private List<String>		sectionSrNoList;
	private CpiBean				cpiBean					= new CpiBean();
	CpiService					cpiService				= new CpiService();
	CpiGetList					cpiGetList				= new CpiGetList();
	CPICdListAction				cpiCdListAction			= new CPICdListAction();
	AssetCdStrAction			assetCdStrAction		= new AssetCdStrAction();
	SectionSrNoStrAction		sectionSrNoStrAction	= new SectionSrNoStrAction();
	CpiDAOImpl					cpiDAOImpl				= new CpiDAOImpl();

	@Override
	public String execute() {

		cpiBean = cpiDAOImpl.getDefaultValue();
		cpiCdList = cpiCdListAction.getCpiCdList();
		cpiStatusList = cpiGetList.getCpiStatus();
		assetCdList = AssetCdStrAction.getAssetCdList();
		sectionSrNoList = sectionSrNoStrAction.getSectionSrNoList();

		session.put("cpiCd", cpiCdList);
		session.put("cpiStatus", cpiStatusList);
		session.put("assetCd", assetCdList);
		session.put("sectionSerialNo", sectionSrNoList);

		return SUCCESS;
	}

	public void setCpiCdList(List<String> cpiCdList) {
		this.cpiCdList = cpiCdList;
	}

	public List<String> getCpiCdList() {
		return cpiCdList;
	}

	public void setCpiBean(CpiBean cpiBean) {
		this.cpiBean = cpiBean;
	}

	public CpiBean getCpiBean() {
		return cpiBean;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;

	}

	public Map<String, Object> getSession() {
		return this.session;
	}

	@Override
	public CpiBean getModel() {
		return cpiBean;
	}

	public void setCpiStatusList(List<String> cpiStatusList) {
		this.cpiStatusList = cpiStatusList;
	}

	public List<String> getCpiStatusList() {
		return cpiStatusList;
	}

	public void setAssetCdList(List<String> assetCdList) {
		this.assetCdList = assetCdList;
	}

	public List<String> getAssetCdList() {
		return assetCdList;
	}

	public void setSectionSrNoList(List<String> sectionSrNoList) {
		this.sectionSrNoList = sectionSrNoList;
	}

	public List<String> getSectionSrNoList() {
		return sectionSrNoList;
	}

}
