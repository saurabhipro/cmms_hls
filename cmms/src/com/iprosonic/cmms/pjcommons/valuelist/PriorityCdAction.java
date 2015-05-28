package com.iprosonic.cmms.pjcommons.valuelist;

import java.util.ArrayList;
import java.util.List;

public class PriorityCdAction {
	public List<String> getPriority() {
		List<String> prioritylist = null;
		try {
			prioritylist = new ArrayList<String>();
			prioritylist.add("LOW");
			prioritylist.add("HIGH");
			prioritylist.add("MEDIUM");

		} catch (Exception e) {

			e.printStackTrace();
		}
		return prioritylist;
	}


}
