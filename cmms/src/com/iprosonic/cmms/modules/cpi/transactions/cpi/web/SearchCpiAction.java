package com.iprosonic.cmms.modules.cpi.transactions.cpi.web;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import com.iprosonic.cmms.modules.cpi.transactions.cpi.domain.CpiBean;
import com.iprosonic.cmms.modules.cpi.transactions.cpi.service.CpiService;
import com.iprosonic.cmms.pjcommons.utility.DateUtil;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class SearchCpiAction extends ActionSupport implements SessionAware, ModelDriven<CpiBean> {
	private static final long	serialVersionUID	= 1L;
	private List<CpiBean>		cpiBeanList;
	private Map<String, Object>	session;
	private CpiBean				cpiBean				= new CpiBean();
	CpiService					cpiService			= new CpiService();

	public String execute() {

		cpiBean.setDateOfCpi(DateUtil.getCurrentDateWasCpi());

		HttpServletRequest request = ServletActionContext.getRequest();
		String fromDate = request.getParameter("fromDate");
		String toDate = request.getParameter("toDate");

		cpiBeanList = cpiService.getCpi(fromDate, toDate, getModel().getCpiCd(), getModel().getCpiStatus(), getModel().getAssetName(), getModel().getSectionSerialNo());
		session = ActionContext.getContext().getSession();
		session.put("cpiBeanList", cpiBeanList);
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

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;

	}

	public Map<String, Object> getSession() {
		return this.session;
	}

	public void setCpiBeanList(List<CpiBean> cpiBeanList) {
		this.cpiBeanList = cpiBeanList;
	}

	public List<CpiBean> getCpiBeanList() {
		return cpiBeanList;
	}

}
