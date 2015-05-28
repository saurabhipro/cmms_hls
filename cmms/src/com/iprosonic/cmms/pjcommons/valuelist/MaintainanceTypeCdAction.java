package com.iprosonic.cmms.pjcommons.valuelist;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaintainanceTypeCdAction 
{	
	public List<String> getMaintenanceType() {
		List<String> maintenanceTypeList = null;

		try {

			maintenanceTypeList = new ArrayList<String>();
			maintenanceTypeList.add("CABLES");
			maintenanceTypeList.add("ELECTRONICS");
			maintenanceTypeList.add("FIELD ENGG CELL");
			maintenanceTypeList.add("HEADS");
			maintenanceTypeList.add("MECHANICAL");
			maintenanceTypeList.add("PERFORATION");
			maintenanceTypeList.add("PRODUCTION");
			maintenanceTypeList.add("SONDE");
			maintenanceTypeList.add("WHE");		
			maintenanceTypeList.add("SAMPLING");
			maintenanceTypeList.add("SOFTWARE");
			maintenanceTypeList.add("TCP");
			maintenanceTypeList.add("OTHERS");
			Collections.sort(maintenanceTypeList);
			
		} catch (Exception e) {

			e.printStackTrace();
		} finally {

		}
		return maintenanceTypeList;
	}

}
