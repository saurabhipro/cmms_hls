package com.iprosonic.cmms.pjcommons.utility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.iprosonic.cmms.modules.job.transactions.job.domain.JobBean;

public class DateUtil {
	public static String getCurrentDateWasCpi() {

		Date date = new Date();
		SimpleDateFormat sdf;
		sdf = new SimpleDateFormat("yyyy-MM-dd");
		String dateStr = sdf.format(date);
		return dateStr;
	}
	
	public static String getJobDate(String date) {
		
		String dateStr = null;
		SimpleDateFormat sdf,sdt;
		try {
			sdf = new SimpleDateFormat("dd-MM-yyyy");
			sdf.setLenient(false);
			sdt = new SimpleDateFormat("yyyy-MM-dd");
			sdt.setLenient(false);
			Date date1 = sdf.parse(date);
			dateStr = sdt.format(date1);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			dateStr=date;
			System.out.println(e.getMessage());
		}
		return dateStr;
	}
	
	public static String getJobDateFromTimeFormate(String date) {
		
		String dateStr = null;
		SimpleDateFormat sdf,sdt;
		try {
			
			sdf = new SimpleDateFormat("dd-MMM-yyyy");
			sdf.setLenient(false);
			sdt = new SimpleDateFormat("yyyy-MM-dd");
			sdt.setLenient(false);
			Date date1 = sdf.parse(date);
			dateStr = sdt.format(date1);
			
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			System.out.println("input : date ="+date);
			e.printStackTrace();
		
		}
		return dateStr;
	}

	public static String getCurrentJobDate() {

		Date date = new Date();
		SimpleDateFormat sdf;
		sdf = new SimpleDateFormat("yyyy-MM-dd");
		String dateStr = sdf.format(date);
		return dateStr;
	}

	public static String getCurrentMonth() {

		Date date = new Date();
		SimpleDateFormat sdf;
		sdf = new SimpleDateFormat("yyyy-MM-dd");
		String dateStr = sdf.format(date);
		return dateStr.substring(5, 7);
	}

	public static String getCurrentYear() {

		Date date = new Date();
		SimpleDateFormat sdf;
		sdf = new SimpleDateFormat("yyyy-MM-dd");
		String dateStr = sdf.format(date);
		return dateStr.substring(2, 4);
	}

	public static String getCurrentDateTimeWasCpi() {

		String dateTime;
		dateTime = "";
		try {
			Date date = new Date();
			SimpleDateFormat sdf;
			sdf = new SimpleDateFormat("yyyy-MM-dd");
			String dateStr = sdf.format(date);
			dateTime = dateStr + ":" + date.getHours() + ":" + date.getMinutes();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dateTime;
	}

	public static String getOpTime(String ru1, String rd1)
			throws ParseException {
		String dateStart = ru1;
		String dateStop = rd1;

		SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy HH:mm");
		Date d1 = null;
		Date d2 = null;
		Long hrs = 0L;
		Long mts = 0L;

		try {
			d1 = format.parse(dateStart);
			d2 = format.parse(dateStop);
			// in milliseconds
			long diff = d2.getTime() - d1.getTime();
			long diffSeconds = diff / 1000 % 60;
			long diffMinutes = diff / (60 * 1000) % 60;
			long diffHours = diff / (60 * 60 * 1000) % 24;
			long diffDays = diff / (24 * 60 * 60 * 1000);

			System.out.print(diffDays + " days, ");
			System.out.print(diffHours + " hours, ");
			System.out.print(diffMinutes + " minutes, ");
			System.out.print(diffSeconds + " seconds.");

			hrs = (diffHours) + (long) (diffDays * 24);
			mts = diffMinutes;

		} catch (Exception e) {
			System.out.println("input : ru1="+ru1+",rd1="+rd1);
			e.printStackTrace();
		}
		return String.valueOf(hrs) + "Hrs," + String.valueOf(mts) + "Mins";

	}

	public static String getTotalOpTime(String ru1, String rd1)
			throws ParseException {

		String dateStart = ru1;
		String dateStop = rd1;

		SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy HH:mm");
		format.setLenient(false);
		Date d1 = null;
		Date d2 = null;
		Long hrs = 0L;
		Long mts = 0L;

		try {
			d1 = format.parse(dateStart);
			d2 = format.parse(dateStop);
			// in milliseconds
			long diff = d2.getTime() - d1.getTime();
			long diffSeconds = diff / 1000 % 60;
			long diffMinutes = diff / (60 * 1000) % 60;
			long diffHours = diff / (60 * 60 * 1000) % 24;
			long diffDays = diff / (24 * 60 * 60 * 1000);


			hrs = (diffHours) + (long) (diffDays * 24);
			mts = diffMinutes;

		} catch (Exception e) {
			System.out.println("input : ru1="+ru1+",rd1="+rd1);
			e.printStackTrace();
		}

		return String.valueOf(hrs) + ";" + String.valueOf(mts);

	}

	public static Long getTotalOTTime(String ru1, String rd1)
			throws ParseException {
		String dateStart = ru1;
		String dateStop = rd1;

		SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy HH:mm");
		format.setLenient(false);
		Date d1 = null;
		Date d2 = null;
		Long hrs = 0L;
		Long mts = 0L;

		try {
			
			d1 = format.parse(dateStart);
			d2 = format.parse(dateStop);
			// in milliseconds
			long diff = d2.getTime() - d1.getTime();
			long diffSeconds = diff / 1000 % 60;
			long diffMinutes = diff / (60 * 1000) % 60;
			long diffHours = diff / (60 * 60 * 1000) % 24;
			long diffDays = diff / (24 * 60 * 60 * 1000);

			hrs = (diffHours) + (long) (diffDays * 24);
			mts = diffMinutes;

			
		} catch (Exception e) {
			System.out.println("input : ru1="+ru1+",rd1="+rd1);
			e.printStackTrace();
			return 0L;
		}
		return hrs*60+mts;

	}
/* 
 * Date Handler created by Arpit ..  /*
 */
	public static Long getUnit1Diff(String UnitReachedSite, String unitLeftSite , String jobNo) {
		// TODO Auto-generated method stub
		
		String dateStart = UnitReachedSite;
		String dateStop = unitLeftSite;

		SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
		SimpleDateFormat format1 = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		SimpleDateFormat format2 = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");
		
		format.setLenient(false);
		Date d1 = null;
		Date d2 = null;
		Long hrs = 0L;
		Long mts = 0L;

		try {
			
			try {
				d1 = format.parse(dateStart);
				d2 = format.parse(dateStop);
				//System.out.println("Successfull : unitLeftBase="+unitLeftBase+",unitLeftSite="+unitLeftSite+ "jobNo"+jobNo);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				try {
					d1 = format1.parse(dateStart);
					d2 = format1.parse(dateStop);
					//System.out.println("Successfull : unitLeftBase="+unitLeftBase+",unitLeftSite="+unitLeftSite +"jobNo"+jobNo);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					d1 = format2.parse(dateStart);
					d2 = format2.parse(dateStop);
					//System.out.println("Successfull : unitLeftBase="+unitLeftBase+",unitLeftSite="+unitLeftSite +"jobNo"+jobNo);
				}
				
			}
				
			
			
			// in milliseconds
			long diff = d1.getTime() - d2.getTime();
			long diffSeconds = diff / 1000 % 60;
			long diffMinutes = diff / (60 * 1000) % 60;
			long diffHours = diff / (60 * 60 * 1000) % 24;
			long diffDays = diff / (24 * 60 * 60 * 1000);
			
		 
			 
			
			hrs = (diffHours) + (long) (diffDays * 24);
			mts = diffMinutes;
				
			
		} catch (Exception e) {
			//System.out.println("Error : unitLeftBase="+UnitReachedSite+",unitLeftSite="+unitLeftSite+"jobNo"+jobNo);
			 
			return 0L;
		}
		/*if(hrs*60+mts<0){
			System.out.println("Nagetive Date : unitLeftBase="+UnitReachedSite+",unitLeftSite="+unitLeftSite+"jobNo"+jobNo);
		}*/
		return hrs*60+mts;
	}
	
	public static Long getUnit2Diff(String unitReachedBase, String unitLeftSite , String jobNo) {
		// TODO Auto-generated method stub
		
		String dateStart = unitReachedBase;
		String dateStop = unitLeftSite;

		SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
		SimpleDateFormat format1 = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		SimpleDateFormat format2 = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");
		
		format.setLenient(false);
		Date d1 = null;
		Date d2 = null;
		Long hrs = 0L;
		Long mts = 0L;

		try {
			
			try {
				d1 = format.parse(dateStart);
				d2 = format.parse(dateStop);
				//System.out.println("Successfull : unitReachedSite="+unitReachedSite+",unitLeftBase="+unitLeftBase + "jobNo"+jobNo);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				try {
					d1 = format1.parse(dateStart);
					d2 = format1.parse(dateStop);
				//	System.out.println("Successfull : unitReachedSite="+unitReachedSite+",unitLeftBase="+unitLeftBase +"jobNo"+jobNo);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					d1 = format2.parse(dateStart);
					d2 = format2.parse(dateStop);
					//System.out.println("Successfull : unitReachedSite="+unitReachedSite+",unitLeftBase="+unitLeftBase+"jobNo"+jobNo);
				}
				
			}
				
			
			
			// in milliseconds
			long diff = d1.getTime() - d2.getTime();
			long diffSeconds = diff / 1000 % 60;
			long diffMinutes = diff / (60 * 1000) % 60;
			long diffHours = diff / (60 * 60 * 1000) % 24;
			long diffDays = diff / (24 * 60 * 60 * 1000);
			
			
			 
			
			hrs = (diffHours) + (long) (diffDays * 24);
			mts = diffMinutes;
				
			
		} catch (Exception e) {
			//System.out.println("Error : unitReachedBase="+unitReachedBase+",unitLeftSite="+unitLeftSite+"jobNo"+jobNo) ;
			 
			return 0L;
		}
		/*if(hrs*60+mts<0){
			System.out.println("Nagetive Date : unitReachedBase="+unitReachedBase+",unitLeftSite="+unitLeftSite+"jobNo"+jobNo);
		}*/
		return hrs*60+mts;
	}
	
}
