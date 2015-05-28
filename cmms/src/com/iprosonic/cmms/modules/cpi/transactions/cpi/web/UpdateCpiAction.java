package com.iprosonic.cmms.modules.cpi.transactions.cpi.web;
import com.iprosonic.cmms.modules.cpi.transactions.cpi.dao.CpiDAOImpl;
import com.iprosonic.cmms.modules.cpi.transactions.cpi.domain.CpiBean;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UpdateCpiAction extends ActionSupport implements ModelDriven<CpiBean> 
{
	private static final long serialVersionUID = 1L;
	private CpiBean cpiBean = new CpiBean();
	CpiDAOImpl cpiDAOImpl = new CpiDAOImpl();
	
	public String execute()
	{
		cpiBean.setId(getModel().getId());
		cpiDAOImpl.updateCpi(cpiBean);
		return SUCCESS;
		}
	
	@Override
	public CpiBean getModel() 
	{
		return cpiBean;
	}

	public void setCpiBean(CpiBean cpiBean) {
		this.cpiBean = cpiBean;
	}

	public CpiBean getCpiBean() {
		return cpiBean;
	}

	
}
