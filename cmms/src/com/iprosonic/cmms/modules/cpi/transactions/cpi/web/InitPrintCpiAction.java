package com.iprosonic.cmms.modules.cpi.transactions.cpi.web;
import java.util.List;
import java.util.Map;

import com.iprosonic.cmms.modules.cpi.transactions.cpi.domain.CpiBean;
import com.iprosonic.cmms.pjcommons.valuelist.CpiGetList;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class InitPrintCpiAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private CpiBean cpiBean = new CpiBean();

	private List<String> cpiCdList;
	CpiGetList cpiGetList = new CpiGetList();

	@Override
	public String execute() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		cpiCdList=	cpiGetList.getCpiCd();
		session.put("cpiCd", cpiCdList);
		return SUCCESS;
	}

	public void setCpiBean(CpiBean cpiBean) {
		this.cpiBean = cpiBean;
	}

	public CpiBean getCpiBean() {
		return cpiBean;
	}

	public void setCpiCdList(List<String> cpiCdList) {
		this.cpiCdList = cpiCdList;
	}

	public List<String> getCpiCdList() {
		return cpiCdList;
	}
}
