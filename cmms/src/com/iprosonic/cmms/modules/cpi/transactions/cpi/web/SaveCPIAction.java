package com.iprosonic.cmms.modules.cpi.transactions.cpi.web;

import com.iprosonic.cmms.modules.cpi.transactions.cpi.dao.CpiDAOImpl;
import com.iprosonic.cmms.modules.cpi.transactions.cpi.domain.CpiBean;
import com.iprosonic.cmms.modules.cpi.transactions.cpi.service.CpiService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class SaveCPIAction extends ActionSupport implements
		ModelDriven<CpiBean> {
	private static final long serialVersionUID = 1L;
	private CpiBean cpiBean = new CpiBean();
	CpiDAOImpl cpiDAOImpl = new CpiDAOImpl();
	CpiService cpiService = new CpiService();
	private String unitCd;
	private String cpiCd;

	@Override
	public String execute() {
		try {
			cpiCd = cpiDAOImpl.saveCpi(cpiBean);
			setCpiCd(cpiCd);
		} catch (Exception e) {
			e.printStackTrace();
		}
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

	public void setCpiCd(String cpiCd) {
		this.cpiCd = cpiCd;
	}

	public String getCpiCd() {
		return cpiCd;
	}

	public void setUnitCd(String unitCd) {
		this.unitCd = unitCd;
	}

	public String getUnitCd() {
		return unitCd;
	}

}
