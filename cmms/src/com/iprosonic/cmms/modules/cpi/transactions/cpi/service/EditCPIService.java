package com.iprosonic.cmms.modules.cpi.transactions.cpi.service;
import com.iprosonic.cmms.modules.cpi.transactions.cpi.dao.CpiDAOImpl;
import com.iprosonic.cmms.modules.cpi.transactions.cpi.domain.CpiBean;
public class EditCPIService 
{
	private CpiBean cpiBean = new CpiBean();	
	CpiDAOImpl cpiDAOImpl = new CpiDAOImpl();
	CpiService cpiService = new CpiService();

	public CpiBean edit(String id) {
		cpiBean = cpiDAOImpl.listCpiById(Integer.parseInt(id));
		return cpiBean;
	}
}
