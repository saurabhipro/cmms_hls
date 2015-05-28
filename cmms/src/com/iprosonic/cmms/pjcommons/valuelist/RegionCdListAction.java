package com.iprosonic.cmms.pjcommons.valuelist;



import java.util.HashSet;
import java.util.Set;

public class RegionCdListAction {
	public Set<String> getRegionCd() {
		Set<String> regionSet = null;
		try {
			regionSet = new HashSet<String>();	
			regionSet.add("NER");
			regionSet.add("SWR");			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return regionSet;
	}

}