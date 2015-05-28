package com.iprosonic.cmms.modules.masters.user.dao;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.iprosonic.cmms.modules.masters.user.domain.EmployeeBean;
import com.iprosonic.cmms.pjcommons.utility.HibernateSession;

public class EmployeeDaoImpl {
	Session session;
	Transaction transaction;

	public void saveOrUpdateEmployee(EmployeeBean emp) {
		try {
			session = HibernateSession.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.saveOrUpdate(emp);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			HibernateSession.shoutDown();
		}
	}

	@SuppressWarnings("unchecked")
	
	public List<EmployeeBean> listUser() {
		List<EmployeeBean> users = null;
		session = HibernateSession.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		Criteria criteria = session.createCriteria(EmployeeBean.class);
		criteria.add(Restrictions.like("status", "Active"));
		try {
			users = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateSession.shoutDown();
		}
		return users;
	}

	@SuppressWarnings("unchecked")
	
	public List<EmployeeBean> listUser(String cd, String name) {
		List<EmployeeBean> users = null;
		
		

		session = HibernateSession.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(EmployeeBean.class);

		
		if (!name.equalsIgnoreCase("")) {
			criteria.add(Restrictions.like("employeeName", name));

		}

		if (!cd.equalsIgnoreCase("")) {
			criteria.add(Restrictions.like("employeeCd", cd));

		}

		criteria.add(Restrictions.like("status", "Active"));

		try {
			users = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateSession.shoutDown();
		}
		
		return users;
	}

	
	public List<EmployeeBean> listEmployee() {
		List<EmployeeBean> users = null;
		session = HibernateSession.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(EmployeeBean.class);


		try {
			users = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateSession.shoutDown();
		}
		
		return users;
	}

	
	public EmployeeBean getEmployeeByCd(String cd) {
		EmployeeBean emp = null;
		try {
			session = HibernateSession.getSessionFactory().openSession();
			Criteria criteria = session.createCriteria(EmployeeBean.class);
			criteria.add(Restrictions.like("employeeCd", cd));

			Iterator<EmployeeBean> itr = criteria.list().iterator();
			emp = itr.next();

			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateSession.shoutDown();
		}
		return emp;
	}

	/**
	 * Used to list a single user by Id.
	 */

	
	public List<EmployeeBean> crewlist() {
		List<EmployeeBean> users = null;
		session = HibernateSession.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		Criteria criteria = session.createCriteria(EmployeeBean.class);
		criteria.add(Restrictions.like("roleCd", "CREW"));
		try {
			users = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateSession.shoutDown();
		}
		return users;
	}
	


	public List<EmployeeBean> englist() {
		List<EmployeeBean> users = null;
		session = HibernateSession.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		Criteria criteria = session.createCriteria(EmployeeBean.class);
		criteria.add(Restrictions.like("roleCd", "ENG"));
		try {
			users = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateSession.shoutDown();
		}
		return users;
	}
	 
	
	
	public EmployeeBean listEmployeeById(int empId) {
		EmployeeBean emp = null;
		try {
			session = HibernateSession.getSessionFactory().openSession();
			emp = (EmployeeBean) session.get(EmployeeBean.class, empId);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateSession.shoutDown();
		}
		return emp;
	}

	public String getRoleCd(String loginId) {
		String roleCd = null;
		List result = new ArrayList();
		session = HibernateSession.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(EmployeeBean.class);
		ProjectionList projectList = Projections.projectionList();
		projectList.add(Projections.property("roleCd"));
		criteria.add(Restrictions.like("employeeCd", loginId));
		criteria.setProjection(projectList);
		result = criteria.list();
		Iterator it = result.iterator();
		try {
			while (it.hasNext()) {
				roleCd = (String) it.next();
				
			}
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			HibernateSession.shoutDown();
		}
		
		return roleCd;
	}

	public Boolean isLoginIdExist(String employeeCd) {

		List<EmployeeBean> empList = null;
		boolean result = false;

		session = HibernateSession.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		Criteria criteria = session.createCriteria(EmployeeBean.class);
		empList = criteria.list();

		try {
			Iterator<EmployeeBean> iterator = empList.iterator();
			while (iterator.hasNext()) {
				EmployeeBean employeeBean = iterator.next();

				String empCd = employeeBean.getEmployeeCd();
				if (empCd.equalsIgnoreCase(employeeCd)) {
					result = true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateSession.shoutDown();
		}
		
		return result;
	}

	public void updateEmplyeeStatus(Integer id) throws Exception {
		
		String hql = "update EmployeeBean set status =:status  where id =:id";
		session = HibernateSession.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery(hql);
		query.setParameter("status", "Inactive");
		query.setParameter("id", id);
		query.executeUpdate();
		transaction.commit();
	}

}
