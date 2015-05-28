package com.iprosonic.cmms.modules.job.transactions.job.web;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import com.iprosonic.cmms.modules.job.transactions.job.domain.JobExplBean;
import com.iprosonic.cmms.modules.job.transactions.job.domain.JobRigBean;
import com.iprosonic.cmms.modules.job.transactions.job.domain.JobRunBean;
import com.iprosonic.cmms.modules.job.transactions.job.domain.JobServiceBean;
import com.iprosonic.cmms.modules.job.transactions.job.service.EmpCompare;
import com.iprosonic.cmms.modules.job.transactions.job.service.SearchJobExplosive;
import com.iprosonic.cmms.modules.job.transactions.job.service.SearchJobService;
import com.iprosonic.cmms.modules.job.transactions.job.service.SearchRigService;
import com.iprosonic.cmms.modules.job.transactions.job.service.SearchRunService;
import com.iprosonic.cmms.modules.masters.user.dao.EmployeeDaoImpl;
import com.iprosonic.cmms.modules.masters.user.domain.EmployeeBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class PopUpAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private SearchRigService searchRigService = new SearchRigService();
	private SearchRunService searchRunService = new SearchRunService();
	private SearchJobService searchJobService = new SearchJobService();
	private SearchJobExplosive searchJobExplosive = new SearchJobExplosive();
	private EmployeeDaoImpl employeeDaoImpl = new EmployeeDaoImpl();
	private List<EmployeeBean> employeeBeansList = new ArrayList<EmployeeBean>();
	private JobServiceBean jobServiceBean = new JobServiceBean();
	private Map<String, String> UomMap = new HashMap<String, String>();
	private String uomData = new String();

	public String getUomData() {
		return uomData;
	}

	public void setUomData(String uomData) {
		this.uomData = uomData;
	}

	public Map<String, String> getUomMap() {
		UomMap.put("Feet", "Feet");
		UomMap.put("No", "No");
		UomMap.put("DETO", "DETO");
		UomMap.put("RED DETO", "RED DETO");
		UomMap.put("CHARGE", "CHARGE");
		UomMap.put("BOOSTER", "BOOSTER");
		UomMap.put("INDICATOR", "INDICATOR");
		return UomMap;
	}

	public void setUomMap(Map<String, String> uomMap) {
		UomMap = uomMap;
	}

	public String execute() throws Exception {
		HttpServletRequest request = (HttpServletRequest) ActionContext
				.getContext().get(ServletActionContext.HTTP_REQUEST);
		
		String type = request.getParameter("type");
		String value = request.getParameter("value");
		String retValue = "";

		if (type.equalsIgnoreCase("rig")) {
			try {
				JobRigBean jobRigBean = searchRigService.getRigByNo(value);
				request.setAttribute("jobRigBean", jobRigBean);
				retValue = "rig";
			} catch (NumberFormatException e) {

				e.printStackTrace();
			} catch (Exception e) {

				e.printStackTrace();
			}
		}

		if (type.equalsIgnoreCase("run")) {

			try {
				JobRunBean jobRunBean = searchRunService.getRunByNo(value);
				request.setAttribute("jobRunBean", jobRunBean);
				retValue = "run";
			} catch (Exception e) {

				e.printStackTrace();
			}
		}

		// service
		if (type.equalsIgnoreCase("ser")) {
			try {
				jobServiceBean = searchJobService.getJobServiceByNo(value);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("jobServiceBean", jobServiceBean);
			retValue = "ser";
		}

		// explosive
		if (type.equalsIgnoreCase("exp")) {
			try {
				JobExplBean jobExplBean = searchJobExplosive
						.getJobExplosiveByNo(value);
				request.setAttribute("jobExplBean", jobExplBean);
				uomData = jobExplBean.getUom();
				Iterator<String> keySetIterator = this.getUomMap().keySet()
						.iterator();
				String key = "";
				while (keySetIterator.hasNext()) {
					key = keySetIterator.next();
					if (UomMap.get(key).equals(uomData)) {
						break;
					}
				}
				uomData = key;
				
				retValue = "exp";
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (type.equals("insExp")) {
			try {
				int SizeofEx=0;
				List<JobServiceBean> serviceBeans = searchJobService
						.getJobServiceBeans(value);
				JobServiceBean jobservicebean = searchJobService
						.getJobServiceByNo(value);
				Set<JobExplBean> ss = jobservicebean.getJobExplBeanSet();
				TreeSet<Integer> t = new TreeSet<Integer>();
				if (ss.size() == 0) {
					SizeofEx=1;
					
				} else {
					for (JobExplBean jeb : ss) {
						// JOB-KWT001OH-PRIEZE PETROLEUM
						// SAHDOL-0314-3-rig-1-run-1-ser-
						int i = jeb.getExplNo().toCharArray().length;
						String exNo = jeb.getExplNo().substring(i - 1);
						t.add(Integer.parseInt(exNo));
					}
					SizeofEx=t.last()+1;
				}
				
				

				/*
				 * int sizeofex=jobservicebean.getJobExplBeanSet().size();
				 * if(sizeofex==0){ sizeofex=1; }
				 */
				// int sizeOfTree=t.size();

				String genExpId = value + "-exp-" + SizeofEx + "";
				JobExplBean jobExpBean = new JobExplBean();
				jobExpBean.setExplNo(genExpId);
				jobExpBean.setServiceNo(value);
				String no[] = value.split("-");
				String jobNo = "";
				int i = 0;
				while (i < 5) {
					if (i == 0) {
						jobNo = jobNo + no[i];
						i++;
						continue;
					}
					jobNo = jobNo + "-" + no[i];
					i++;
				}
				jobExpBean.setJobNo(jobNo);
				
				request.setAttribute("jobExpBean", jobExpBean);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			retValue = "insExp";
		}

		if (type.equals("insSer")) {
			try {
				List<JobServiceBean> serviceBeans = searchJobService
						.getJobServiceBeans(value);
				String genServiceID = value + "-ser-0"
						+ (serviceBeans.size() + 1);
				JobServiceBean jobservicebean = new JobServiceBean();
				jobservicebean.setServiceNo(genServiceID);
				jobservicebean.setRunNo(value);
				int i = 0;
				String no[] = value.split("-");
				String jobNo = "";
				while (i < 5) {
					if (i == 0) {
						jobNo = jobNo + no[i];
						i++;
						continue;
					}
					jobNo = jobNo + "-" + no[i];
					i++;
				}
				jobservicebean.setJobNo(jobNo);
				request.setAttribute("jobServiceBean", jobservicebean);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			retValue = "insSer";
		}
		if (type.equals("crew")) {
			employeeBeansList = employeeDaoImpl.crewlist();
			Collections.sort(employeeBeansList, new EmpCompare());
			retValue = "crew";
		}
		
		
		if (type.equals("latlongangle")) {
			employeeBeansList = employeeDaoImpl.crewlist();
			Collections.sort(employeeBeansList, new EmpCompare());
			retValue = "latlongangle";
		}
		
		

		if (type.equals("emp")) {
			employeeBeansList = employeeDaoImpl.englist();
			Collections.sort(employeeBeansList, new EmpCompare());
			retValue = "emp";
		}
		return retValue;
	}

	public void setEmployeeBeansList(List<EmployeeBean> employeeBeansList) {
		this.employeeBeansList = employeeBeansList;
	}

	public List<EmployeeBean> getEmployeeBeansList() {
		return employeeBeansList;
	}

	public void setJobServiceBean(JobServiceBean jobServiceBean) {
		this.jobServiceBean = jobServiceBean;
	}

	public JobServiceBean getJobServiceBean() {
		return jobServiceBean;
	}

}
