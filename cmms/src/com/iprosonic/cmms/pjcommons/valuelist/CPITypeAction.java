package com.iprosonic.cmms.pjcommons.valuelist;



import java.util.ArrayList;
import java.util.List;

public class CPITypeAction 
{
	public List<String> getCpiTypeList() {
		List<String> cpiNatureList = null;
		
		
		try {
			cpiNatureList = new ArrayList<String>();
			cpiNatureList.add("PM3");			
			cpiNatureList.add("PM2");			
			cpiNatureList.add("JOBP");
			cpiNatureList.add("REPR");
			cpiNatureList.add("MECH");
			cpiNatureList.add("ROUTINE");
			cpiNatureList.add("OTHERS");
			

		} catch (Exception e) {

			e.printStackTrace();
		}

		return cpiNatureList;
	}

}
