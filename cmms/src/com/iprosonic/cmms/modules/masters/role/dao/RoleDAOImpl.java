package com.iprosonic.cmms.modules.masters.role.dao;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.iprosonic.cmms.modules.masters.role.domain.RoleBean;
import com.iprosonic.cmms.pjcommons.utility.HibernateSession;

public class RoleDAOImpl {

	Session session;
	Transaction transaction;

	public void saveOrUpdateRole(RoleBean role) {
		try {			
			session = HibernateSession.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.saveOrUpdate(role);		
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}finally
		{
			HibernateSession.shoutDown();
		}
	}

	public void deleteRole(int roleId) {
		try {
			session = HibernateSession.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			RoleBean role = (RoleBean) session.get(RoleBean.class, roleId);
			session.delete(role);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}finally
		{
			HibernateSession.shoutDown();
		}
	}

	@SuppressWarnings("unchecked")
	public List<RoleBean> listRoles() {
		
		List<RoleBean> roles = null;
		session = HibernateSession.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		Criteria criteria = session.createCriteria(RoleBean.class);
		roles = criteria.list();
		try {
			roles = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateSession.shoutDown();
		}
		return roles;
	}


	public RoleBean listRoleById(int roleId) {
		RoleBean role = null;		
		try {
			session = HibernateSession.getSessionFactory().openSession();			
			role = (RoleBean) session.get(RoleBean.class, roleId);
		} catch (Exception e) {
			e.printStackTrace();
		}finally
		{
			HibernateSession.shoutDown();
		}
		return role;
	}

	
}
