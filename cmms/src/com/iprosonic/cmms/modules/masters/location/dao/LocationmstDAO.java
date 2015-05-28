package com.iprosonic.cmms.modules.masters.location.dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;

import com.iprosonic.cmms.modules.masters.client.domain.ClientMasterBean;
import com.iprosonic.cmms.modules.masters.location.domain.Locationmst;
import com.iprosonic.cmms.pjcommons.utility.HibernateSession;

import static org.hibernate.criterion.Example.create;

/**
 * A data access object (DAO) providing persistence and search support for
 * Locationmst entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see org.iprosonic.com.Locationmst
 * @author MyEclipse Persistence Tools
 */

public class LocationmstDAO {
	private static final Log	log				= LogFactory.getLog(LocationmstDAO.class);
	// property constants
	public static final String	LOCATION_CD		= "locationCd";
	public static final String	LOCATION_NAME	= "locationName";
	public static final String	COUNTRY_NAME	= "countryName";
	public static final String	STATE_NAME		= "stateName";
	public static final String	CITY_NAME		= "cityName";
	public static final String	DESCRIPTION		= "description";
	public static final String	LOCATION_STATUS	= "locationStatus";

	public void save(Locationmst transientInstance) {
		log.debug("saving Locationmst instance");
		Session session = HibernateSession.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		} finally {
			session.beginTransaction();
			session.close();

		}
	}

	public void delete(Locationmst persistentInstance) {
		log.debug("deleting Locationmst instance");
		Session session = HibernateSession.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		} finally {
			session.beginTransaction();
			session.close();

		}
	}

	public Locationmst findById(java.lang.Integer id) {
		log.debug("getting Locationmst instance with id: " + id);
		Session session = HibernateSession.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			Locationmst instance = (Locationmst) session.get("org.iprosonic.com.Locationmst", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		} finally {
			session.beginTransaction();
			session.close();

		}
	}

	public List<Locationmst> findByExample(Locationmst instance) {
		log.debug("finding Locationmst instance by example");
		Session session = HibernateSession.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			List<Locationmst> results = (List<Locationmst>) session.createCriteria("org.iprosonic.com.Locationmst").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		} finally {
			session.beginTransaction();
			session.close();

		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Locationmst instance with property: " + propertyName + ", value: " + value);
		Session session = HibernateSession.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			String queryString = "from Locationmst as model where model." + propertyName + "= ?";
			Query queryObject = session.createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		} finally {
			session.beginTransaction();
			session.close();

		}
	}

	public List<Locationmst> findByLocationCd(Object locationCd) {
		return findByProperty(LOCATION_CD, locationCd);
	}

	public List<Locationmst> findByLocationName(Object locationName) {
		return findByProperty(LOCATION_NAME, locationName);
	}

	public List<Locationmst> findByCountryName(Object countryName) {
		return findByProperty(COUNTRY_NAME, countryName);
	}

	public List<Locationmst> findByStateName(Object stateName) {
		return findByProperty(STATE_NAME, stateName);
	}

	public List<Locationmst> findByCityName(Object cityName) {
		return findByProperty(CITY_NAME, cityName);
	}

	public List<Locationmst> findByDescription(Object description) {
		return findByProperty(DESCRIPTION, description);
	}

	public List<Locationmst> findByLocationStatus(Object locationStatus) {
		return findByProperty(LOCATION_STATUS, locationStatus);
	}

	public List findAll() {
		log.debug("finding all Locationmst instances");
		Session session = HibernateSession.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			String queryString = "from Locationmst";
			Query queryObject = session.createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		} finally {
			session.beginTransaction();
			session.close();

		}
	}

	public Locationmst merge(Locationmst detachedInstance) {
		log.debug("merging Locationmst instance");
		Session session = HibernateSession.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			Locationmst result = (Locationmst) session.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		} finally {
			session.beginTransaction();
			session.close();

		}
	}

	public void attachDirty(Locationmst instance) {
		log.debug("attaching dirty Locationmst instance");
		Session session = HibernateSession.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		} finally {
			session.beginTransaction();
			session.close();

		}
	}

	public void attachClean(Locationmst instance) {
		log.debug("attaching clean Locationmst instance");
		Session session = HibernateSession.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		} finally {
			session.beginTransaction();
			session.close();

		}
	}

	public List<String> getLocationNameList() {
		Session session = HibernateSession.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(Locationmst.class);
		Projection projection = Projections.distinct(Projections.property("locationName"));
		criteria.setProjection(projection);
		List<String> list = criteria.list();
		session.close();
		return list;
	}

	public List<Locationmst> getLocation() {
		// TODO Auto-generated method stub
		Session session = HibernateSession.getSessionFactory().openSession();
		List<Locationmst> list;
		try {
			list = (List<Locationmst>) session.createCriteria(Locationmst.class).list();
			session.close();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return list;
	}

	public boolean getlocationId(int id) {
		// TODO Auto-generated method stub
		Session session = HibernateSession.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			Locationmst cl = (Locationmst) session.get(Locationmst.class, id);
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

	public void editLocationById(Locationmst bean) {
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

	public void saveLocation(Locationmst bean) {
		// TODO Auto-generated method stub
		Session session = HibernateSession.getSessionFactory().openSession();
		session.beginTransaction();
		try {
			session.save(bean);
			log.debug("save is done...");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.getTransaction().commit();
			session.flush();
			session.close();
		}
	}

	public void deleteLocationById(Locationmst bean) {
		// TODO Auto-generated method stub
		Locationmst cl = (Locationmst) bean;

		Session session = HibernateSession.getSessionFactory().openSession();
		session.beginTransaction();
		try {
			session.delete(cl);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.getTransaction().commit();
			session.close();
		}
	}

	public List<String> getUnitCd() {
		// TODO Auto-generated method stub
		Session session = HibernateSession.getSessionFactory().openSession();
		session.beginTransaction();
		try {
			Criteria cr = session.createCriteria(Locationmst.class);
			Projection pro = Projections.distinct(Projections.property("locationCd"));
			cr.setProjection(pro);
			List<String> list = cr.list();
			log.debug("save is done...");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.getTransaction().commit();
			session.flush();
			session.close();
		}
		return null;
	}
}