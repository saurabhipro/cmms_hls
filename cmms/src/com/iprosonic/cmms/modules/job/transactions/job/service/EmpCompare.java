package com.iprosonic.cmms.modules.job.transactions.job.service;

import java.util.Comparator;

import com.iprosonic.cmms.modules.masters.user.domain.EmployeeBean;

public class EmpCompare implements Comparator<EmployeeBean> {

	@Override
	public int compare(EmployeeBean o1, EmployeeBean o2) {
		// TODO Auto-generated method stub
		String name1=o1.getEmployeeName();
		String name2=o2.getEmployeeName();
		int coms=name1.compareTo(name2);
		if(coms!=0){
			return coms;
		}else{
			String code1=o1.getEmployeeShortName();
			String code2=o2.getEmployeeShortName();
			return code1.compareTo(code2);
		}
	}

	
	
	
}
