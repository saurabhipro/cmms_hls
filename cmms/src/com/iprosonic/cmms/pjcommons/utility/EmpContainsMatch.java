package com.iprosonic.cmms.pjcommons.utility;

 

public class EmpContainsMatch {
	  
	 public static boolean matchEmp(String sourceStr,String destStr){
	  try{
	   String ss=sourceStr.trim();
	  // System.out.println(sourceStr +"--"+ss);
	   String sourceStrArr[]=ss.split(";");
	   for (String string : sourceStrArr) {
	    if(string.trim().equals(destStr.trim())){
	     return true;
	    }
	   }
	   return false;
	  }catch(Exception e){
	    
	   return false;
	  }
	  
	 }

	}