package com.iprosonic.cmms.pjcommons.valuelist;
import java.util.ArrayList;
import java.util.List;

public class WhyOpenCdListAction {
	public List<String> getWhyOpen() {
		List<String> cpiWhyOpenList = null;		
		try {			
			cpiWhyOpenList = new ArrayList<String>();
			cpiWhyOpenList.add("Waiting For Job");
			cpiWhyOpenList.add("Waiting For Parts");
			cpiWhyOpenList.add("Waiting For Troubleshoot");
			cpiWhyOpenList.add("Waiting For ME Visit");
			cpiWhyOpenList.add("Other");

		} catch (Exception e) {

			e.printStackTrace();
		}
		return cpiWhyOpenList;
	}

}