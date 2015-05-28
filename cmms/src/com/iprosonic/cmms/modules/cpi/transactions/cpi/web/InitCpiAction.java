package com.iprosonic.cmms.modules.cpi.transactions.cpi.web;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.iprosonic.cmms.modules.cpi.transactions.cpi.dao.CpiDAOImpl;
import com.iprosonic.cmms.modules.cpi.transactions.cpi.domain.CpiBean;
import com.iprosonic.cmms.modules.cpi.transactions.cpi.service.CpiService;
import com.iprosonic.cmms.modules.masters.user.domain.EmployeeBean;
import com.iprosonic.cmms.pjcommons.valuelist.AssetTypeListAction;
import com.iprosonic.cmms.pjcommons.valuelist.CPICdListAction;
import com.iprosonic.cmms.pjcommons.valuelist.CPIProcessListAction;
import com.iprosonic.cmms.pjcommons.valuelist.CPITypeAction;
import com.iprosonic.cmms.pjcommons.valuelist.CpiGetList;
import com.iprosonic.cmms.pjcommons.valuelist.EmployeeCdListAction;
import com.iprosonic.cmms.pjcommons.valuelist.MaintainanceTypeCdAction;
import com.iprosonic.cmms.pjcommons.valuelist.OriginatedByAction;
import com.iprosonic.cmms.pjcommons.valuelist.PriorityCdAction;
import com.iprosonic.cmms.pjcommons.valuelist.RegionCdListAction;
import com.iprosonic.cmms.pjcommons.valuelist.WhyOpenCdListAction;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class InitCpiAction extends ActionSupport implements
		ModelDriven<CpiBean> {
	private CpiBean cpiBean = new CpiBean();
	RegionCdListAction regionCdListAction = new RegionCdListAction();
	PriorityCdAction priorityCdAction = new PriorityCdAction();
	CPIProcessListAction cpiProcessListAction = new CPIProcessListAction();
	CPICdListAction cpiCdListAction = new CPICdListAction();
	WhyOpenCdListAction whyOpenCdListAction = new WhyOpenCdListAction();
	AssetTypeListAction assetTypeListAction = new AssetTypeListAction();
	MaintainanceTypeCdAction maintainanceTypeCdAction = new MaintainanceTypeCdAction();
	CPITypeAction cpiTypeAction = new CPITypeAction();
	EmployeeCdListAction employeeCdListAction = new EmployeeCdListAction();
	CpiService cpiService = new CpiService();
	CpiGetList cpiGetList = new CpiGetList();
	RegionCdListAction regionCdList = new RegionCdListAction();
	CpiDAOImpl cpiDAOImpl = new CpiDAOImpl();
	OriginatedByAction originatedByAction = new OriginatedByAction();
	private static final long serialVersionUID = 1L;
	private List<EmployeeBean> userList;
	private Set<String> regionCdSet;
	private List<String> priorityList;
	private List<String> maintenanceTypeList;
	private List<String> assetCdList;
	private List<String> cpiProcessList;
	private List<String> cpiCdList;
	private List<String> cpiStatusList;
	private List<String> cpiWhyOpenList;
	private List<String> assetTypeList;
	private List<String> orientedByList;
	private List<String> employeeList;
	private List<String> cpiTypeList;

	// ---------

	public String execute() {
		
		
		cpiBean = cpiDAOImpl.getDefaultValue();
		Map<String, Object> session = ActionContext.getContext().getSession();
		regionCdSet = regionCdListAction.getRegionCd();
		priorityList = priorityCdAction.getPriority();
		cpiProcessList = cpiProcessListAction.getCpiProcess();
		cpiCdList = cpiCdListAction.getCpiCdList();
		cpiWhyOpenList = whyOpenCdListAction.getWhyOpen();
		assetTypeList = assetTypeListAction.getAssetType();
		employeeList = employeeCdListAction.getOriginatedByString();
		maintenanceTypeList = maintainanceTypeCdAction.getMaintenanceType();
		cpiTypeList = cpiTypeAction.getCpiTypeList();
		
		session.put("assetType1", assetTypeList);
		session.put("regionCd", regionCdSet);
		session.put("priority", priorityList);
		session.put("assetCd", assetCdList);
		session.put("cpiType", cpiTypeList);
        session.put("maintenanceTypeList", maintenanceTypeList);
		session.put("cpiCd", cpiCdList);
		session.put("cpiStatus", cpiStatusList);
		session.put("whyOpen", cpiWhyOpenList);
		session.put("originatedBy", employeeList);

		return SUCCESS;
	}

	@Override
	public CpiBean getModel() {

		return cpiBean;
	}

	public void setUserList(List<EmployeeBean> userList) {
		this.userList = userList;
	}

	public List<EmployeeBean> getUserList() {
		return userList;
	}

	public void setCpiBean(CpiBean cpiBean) {
		this.cpiBean = cpiBean;
	}

	public CpiBean getCpiBean() {
		return cpiBean;
	}

	public void setPriorityList(List<String> priorityList) {
		this.priorityList = priorityList;
	}

	public List<String> getPriorityList() {
		return priorityList;
	}

	public void setMaintenanceTypeList(List<String> maintenanceTypeList) {
		this.maintenanceTypeList = maintenanceTypeList;
	}

	public List<String> getMaintenanceTypeList() {
		return maintenanceTypeList;
	}

	public void setCpiProcessList(List<String> cpiProcessList) {
		this.cpiProcessList = cpiProcessList;
	}

	public List<String> getCpiProcessList() {
		return cpiProcessList;
	}

	public void setCpiCdList(List<String> cpiCdList) {
		this.cpiCdList = cpiCdList;
	}

	public List<String> getCpiCdList() {
		return cpiCdList;
	}

	public void setCpiStatusList(List<String> cpiStatusList) {
		this.cpiStatusList = cpiStatusList;
	}

	public List<String> getCpiStatusList() {
		return cpiStatusList;
	}

	public void setCpiWhyOpenList(List<String> cpiWhyOpenList) {
		this.cpiWhyOpenList = cpiWhyOpenList;
	}

	public List<String> getCpiWhyOpenList() {
		return cpiWhyOpenList;
	}

	public void setassetTypeList(List<String> assetTypeList) {
		this.assetTypeList = assetTypeList;
	}

	public List<String> getassetTypeList() {
		return assetTypeList;
	}

	public void setOrientedByList(List<String> orientedByList) {
		this.orientedByList = orientedByList;
	}

	public List<String> getOrientedByList() {
		return orientedByList;
	}

	public void setEmployeeList(List<String> employeeList) {
		this.employeeList = employeeList;
	}

	public List<String> getEmployeeList() {
		return employeeList;
	}



}
