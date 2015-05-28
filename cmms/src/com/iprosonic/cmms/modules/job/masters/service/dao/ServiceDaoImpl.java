package com.iprosonic.cmms.modules.job.masters.service.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.iprosonic.cmms.modules.job.masters.service.domain.ServiceMstBean;
import com.iprosonic.cmms.pjcommons.utility.HibernateSession;

public class ServiceDaoImpl {

	private Session session;
	private Transaction transaction;

	public ServiceDaoImpl() {
		session = HibernateSession.getSessionFactory().openSession();
	}

	public void saveService(ServiceMstBean serviceMstBean) {
		transaction = session.beginTransaction();
		session.save(serviceMstBean);
		transaction.commit();

	}

	public List<ServiceMstBean> searchServiceListByType(String type) {
		Criteria criteria = session.createCriteria(ServiceMstBean.class);
		if (!type.equalsIgnoreCase("-Select-")) {
			criteria.add(Restrictions.like("serviceType", type));

		}
		return criteria.list();
	}

	public List<ServiceMstBean> getSerivceList() {
		Criteria criteria = session.createCriteria(ServiceMstBean.class);
		return criteria.list();
	}

	public ServiceMstBean searchSerivceById(int id) {
		return (ServiceMstBean) session.load(ServiceMstBean.class, new Integer(
				id));
	}

	public void updateSerivce(ServiceMstBean serviceMstBean) {
		transaction = session.beginTransaction();
		session.saveOrUpdate(serviceMstBean);
		transaction.commit();

	}

}
