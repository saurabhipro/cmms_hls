package com.iprosonic.cmms.modules.job.transactions.job.web;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Hibernate;

import com.iprosonic.cmms.modules.job.transactions.job.domain.JobBean;
import com.iprosonic.cmms.modules.job.transactions.job.domain.JobWellBean;
import com.iprosonic.cmms.modules.job.transactions.job.service.EditJobService;
import com.iprosonic.cmms.modules.job.transactions.job.service.SearchJobService;
import com.iprosonic.cmms.modules.masters.client.service.SearchClientMaster;
import com.iprosonic.cmms.modules.masters.location.service.LocationCDService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class EditJobAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	private JobBean jobBean = new JobBean();
	private JobWellBean jobWellBean = new JobWellBean();
	private SearchJobService searchJobService = new SearchJobService();
	private EditJobService editJobService = new EditJobService();
	private LocationCDService locationCDService=new LocationCDService();
	private String clientName = new String();
	private Map<String, String> clientNameMap = new HashMap<String, String>(); 
	SearchClientMaster searchClientMaster = new SearchClientMaster();
	
	
	
	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public Map<String, String> getClientNameMap() {
		List<String> clientList=searchClientMaster.getClientNameList();
		int i=1;
		for (String string : clientList) {
			clientNameMap.put(string, string);
			i++;
		}
		
		return clientNameMap;
	}

	public void setClientNameMap(Map<String, String> clientNameMap) {
		this.clientNameMap = clientNameMap;
	}

	public String execute() {

		HttpServletRequest request = (HttpServletRequest) ActionContext
				.getContext().get(ServletActionContext.HTTP_REQUEST);
		HttpServletResponse responce = (HttpServletResponse) ActionContext
				.getContext().get(ServletActionContext.HTTP_RESPONSE);

		Map session = (Map) ActionContext.getContext().get("session");
		String jobNo = request.getParameter("jobNo");
		session.put("jobNo", jobNo);
		
		
		List locationMstList = locationCDService.getUnitNameList();
		session.put("locationMstList",locationMstList);
		try {

			jobBean = searchJobService.getJobBean(jobNo.trim());
			jobWellBean = searchJobService.getJobWellBean(jobNo);

			String role = (String) session.get("role");
			request.setAttribute("jobBean", jobBean);
//			Hibernate.initialize(jobBean);
			String[] rigToExplosive = editJobService.getValueRigToExplosive(
					jobNo, role);

			setJobBean(jobBean);
			request.setAttribute("editRigToExplosive", rigToExplosive[0]);

			if (rigToExplosive[1] != null) {
				request.setAttribute("rigcount",
						Integer.parseInt(rigToExplosive[1]));
			}

			if (rigToExplosive[2] != null) {
				request.setAttribute("runcount",
						Integer.parseInt(rigToExplosive[2]));

			}

			if (rigToExplosive[3] != null) {
				request.setAttribute("sercount",
						Integer.parseInt(rigToExplosive[3]));

			}

			if (rigToExplosive[4] != null) {
				request.setAttribute("expcount",
						Integer.parseInt(rigToExplosive[4]));
			}
			
			clientName = jobBean.getClientName();
			System.out.println(clientName);
			Iterator<String> keySetIterator = this.getClientNameMap().keySet()
					.iterator();
			String key = "";
			while (keySetIterator.hasNext()) {
				key = keySetIterator.next();
				if (clientNameMap.get(key).equals(clientName)) {
					break;
				}
			}
			clientName = key;
			
			session.put("jobStatus", jobBean.getJobStatus());
			session.put("role", role);

		} catch (Exception e) {

			e.printStackTrace();
		}

		return SUCCESS;
	}

	public void setJobBean(JobBean jobBean) {
		this.jobBean = jobBean;
	}

	public JobBean getJobBean() {
		return jobBean;
	}

	public void setJobWellBean(JobWellBean jobWellBean) {
		this.jobWellBean = jobWellBean;
	}

	public JobWellBean getJobWellBean() {
		return jobWellBean;
	}

}
