package com.iprosonic.cmms.pjcommons.valuelist;


import java.util.ArrayList;
import java.util.List;

public class CPIProcessListAction {
	public List<String> getCpiProcess() {
		List<String> cpiProcessList = null;
		try {
			cpiProcessList = new ArrayList<String>();
			cpiProcessList.add("Diagnosis");
			cpiProcessList.add("Partially_Diagnosed");
			cpiProcessList.add("Ready_For_Analysis");
			cpiProcessList.add("Partially_Analysed");
			cpiProcessList.add("Waiting_For_Job");
			cpiProcessList.add("Job_Done");
			cpiProcessList.add("Closed");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cpiProcessList;
	}
}