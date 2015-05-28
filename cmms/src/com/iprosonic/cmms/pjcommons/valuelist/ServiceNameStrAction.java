package com.iprosonic.cmms.pjcommons.valuelist;



import java.sql.*; 
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.iprosonic.cmms.modules.job.masters.service.domain.ServiceMstBean;
import com.iprosonic.cmms.pjcommons.utility.HibernateSession;

public class ServiceNameStrAction {
	public static String getServiceName(String serviceType) {
		Session session = null;
		Transaction transaction = null;
		List<String> list = null;
		String listString = "-Select-:";
		Criteria criteria = null;
		try {
			session = HibernateSession.getSessionFactory().openSession();
			transaction = session.beginTransaction();

			criteria = session.createCriteria(ServiceMstBean.class);
			criteria.add(Restrictions.like("serviceType", serviceType));
			criteria.setProjection(Projections.distinct(Projections
					.property("serviceName")));
			criteria.addOrder(Order.asc("serviceName"));
			list = criteria.list();
			for (String s : list) {
				listString += s + ":";
			}
			transaction.commit();
		} catch (HibernateException e) {
			if (transaction.wasCommitted()) {
				transaction.rollback();
				e.printStackTrace();
			}
			e.printStackTrace();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return listString;
		
		//========================= JDBC Search In Database ====================================
		/*String listString = "-Select-:";
		try{
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/wascpi_demo","root","password");
		PreparedStatement pst=conn.prepareStatement("select distinct serviceName from serviceMaster where serviceType='"+serviceType+"'");
		ResultSet rs=pst.executeQuery();
		while(rs.next()){
			listString += rs.getString(1) + ":";
		}
		
		conn.close();
		
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return listString;
		*/
	}

}
