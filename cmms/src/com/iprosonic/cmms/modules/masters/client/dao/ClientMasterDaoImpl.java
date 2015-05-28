package com.iprosonic.cmms.modules.masters.client.dao;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;

import com.iprosonic.cmms.modules.masters.client.domain.ClientMasterBean;
import com.iprosonic.cmms.pjcommons.utility.HibernateSession;

public class ClientMasterDaoImpl {
	public List<String> getClientNameList() {
		Session session = HibernateSession.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(ClientMasterBean.class);
		Projection projection = Projections.distinct(Projections.property("clientName"));
		criteria.setProjection(projection);
		List<String> list = criteria.list();
		session.close();
		return list;
	}

	public List<ClientMasterBean> getClient() {
		Session session = HibernateSession.getSessionFactory().openSession();
		session.beginTransaction();
		List<ClientMasterBean> list = (List<ClientMasterBean>) session.createCriteria(ClientMasterBean.class).list();
		session.close();
		return list;
	}

	public void saveClient(Object ob) {
		ClientMasterBean cl = (ClientMasterBean) ob;
		Session session = HibernateSession.getSessionFactory().openSession();
		session.beginTransaction();
		try {
			session.save(cl);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.getTransaction().commit();
			session.close();
		}
	}

	public void deleteClientById(ClientMasterBean bean) {
		// TODO Auto-generated method stub
		Session session = HibernateSession.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.delete(bean);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.getTransaction().commit();
			session.close();
		}
	}

	public void editClientById(ClientMasterBean bean) {
		// TODO Auto-generated method stub
		Session session = HibernateSession.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.update(bean);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.getTransaction().commit();
			session.close();
		}
	}

	public boolean getClientId(int id) {
		// TODO Auto-generated method stub
		Session session = HibernateSession.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			ClientMasterBean cl = (ClientMasterBean) session.get(ClientMasterBean.class, id);
			if (cl == null) {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.getTransaction().commit();
			session.close();
		}
		return true;
	}

}
