package com.iprosonic.cmms.pjcommons.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.iprosonic.cmms.modules.job.transactions.job.domain.JobBean;

public class DateConvertorProgram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			String date="1/7/2014 16:00:00";
			SimpleDateFormat format1 = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
			Date date1 = format1.parse(date);
			format1.applyPattern("dd-MMM-yyyy HH:mm:ss");
			System.out.println(date+"    ::::   "+format1.format(date1));
			
	 /*
			Session session = HibernateSession.getSessionFactory()
						.openSession();
				Transaction tr = session.beginTransaction();
				Criteria crt=session.createCriteria(JobBean.class);
				List<JobBean> l=crt.list();
				SimpleDateFormat formater = new SimpleDateFormat(
						"dd-MMM-yyyy HH:mm:ss");
				SimpleDateFormat format1 = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
				SimpleDateFormat format2 = new SimpleDateFormat("MM-dd-yyyy  HH:mm:ss");
				Date d1=null;
				
				for (JobBean jobBean : l) {
					String data=jobBean.getUnitLeftSite();
					try{
					d1=formater.parse(data);
					System.out.println("Successfull parse : "+data);
					}catch(Exception e){

					try {
						d1=format1.parse(data);
						format1.applyPattern("dd-MMM-yyyy HH:mm:ss");
						jobBean.setUnitLeftSite(format1.format(d1));
						System.out.println("Successfull convert in format 1: "+data+ " To "+format1.format(d1));
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						System.out.println("Error in format 1:"+data);
						try {
							d1=format2.parse(data);
							format2.applyPattern("dd-MMM-yyyy HH:mm:ss");
							jobBean.setUnitLeftSite(format2.format(d1));
							System.out.println("Successfull convert in format 2: "+data+ " To "+format2.format(d1));
						} catch (Exception e2) {
							// TODO Auto-generated catch block
							System.out.println("Error in format 2:"+data);
							
						}
						
					}
					}
					session.saveOrUpdate(jobBean);
				
				}
			 
				tr.commit();
				session.close(); 
*/
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
	}


