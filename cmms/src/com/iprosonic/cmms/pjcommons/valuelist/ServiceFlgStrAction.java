package com.iprosonic.cmms.pjcommons.valuelist;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.iprosonic.cmms.modules.job.masters.service.domain.ServiceMstBean;
import com.iprosonic.cmms.pjcommons.utility.HibernateSession;

public class ServiceFlgStrAction {
	public static String getServiceFlg(String name) {
		Session session = null;
		String listString = ";";
		Criteria criteria = null;
		try {
			session = HibernateSession.getSessionFactory().openSession();
			criteria = session.createCriteria(ServiceMstBean.class);
			criteria.add(Restrictions.eq("serviceName", name));
			List<ServiceMstBean> lt = criteria.list();
			// 24
			for (ServiceMstBean serviceMstBean : lt) {

				listString += serviceMstBean.getDeepestDepth() + ";"
						+ serviceMstBean.getMeterageLogged() + ";"
						+ serviceMstBean.getRevenue() + ";"
						+ serviceMstBean.getFailureGroup() + ";"
						+ serviceMstBean.getPretestCount() + ";"
						+ serviceMstBean.getPumpOutTime() + ";"
						+ serviceMstBean.getDryTestCount() + ";"
						+ serviceMstBean.getPvtSample() + ";"
						+ serviceMstBean.getNormalSample() + ";"
						+ serviceMstBean.getLevelCount() + ";"
						+ serviceMstBean.getCoresCount() + ";"
						+ serviceMstBean.getGunSize() + ";"
						+ serviceMstBean.getSpf() + ";"
						+ serviceMstBean.getMeteragePerforated() + ";"
						+ serviceMstBean.getSurfacePressure() + ";"
						+ serviceMstBean.getChRuns() + ";"
						+ serviceMstBean.getChMisRuns() + ";"
						+ "Y"+";"
						+ "Y"+";"
						+ "Y"+";"
						+ "Y"+";"
						+ "Y"+";"
						+ serviceMstBean.getRemarks() + ";"
						+ serviceMstBean.getLogSentFromBase() + ";"	
						+ serviceMstBean.getLogRecievedAtHo() + ";"
						+ serviceMstBean.getLqaDoneDate() + ";"
						+ serviceMstBean.getLqaTpoints() + ";"
						+"Y"+";"
						+ serviceMstBean.getSnpSnd();
						 
				 
			}
			
		 System.out.println(listString);
		} catch (HibernateException e) {
			e.printStackTrace();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return listString;
	}

}
