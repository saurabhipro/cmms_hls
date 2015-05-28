package com.iprosonic.cmms.modules.cpi.masters.assets.dao;


import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.iprosonic.cmms.modules.cpi.masters.assets.domain.AssetBean;
import com.iprosonic.cmms.pjcommons.utility.HibernateSession;
public class AssetDaoImp  {
	public void saveAsset(AssetBean assetBean) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateSession.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.save(assetBean);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session.isConnected()) {
				session.close();
				HibernateSession.shoutDown();
			}
		}
 //Hi 1
	}

	
	public List<AssetBean> assetList(String assetType, String assetCd) {

		List<AssetBean> assetBeansList = null;
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateSession.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Criteria assetBeansCriteria = session
					.createCriteria(AssetBean.class);

			if (!assetType.equalsIgnoreCase("-Select-")) {
				assetBeansCriteria.add(Restrictions
						.like("assetType", assetType));

			}
			if (!assetCd.equalsIgnoreCase("-Select-")) {
				assetBeansCriteria.add(Restrictions.like("assetCd", assetCd));

			}

			assetBeansList = assetBeansCriteria.list();
			transaction.commit();

		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			if (session.isConnected()) {
				session.close();
				HibernateSession.shoutDown();
			}

		}

		return assetBeansList;
	}

	
	public AssetBean listAssetById(int assetId) {
		Session session = null;
		Transaction transaction = null;
		AssetBean assetBean = null;
		try {
			session = HibernateSession.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			assetBean = (AssetBean) session.get(AssetBean.class, assetId);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session.isConnected()) {
				session.close();
				HibernateSession.shoutDown();
			}
		}
		return assetBean;

	}

	public void updateAssertById(AssetBean assetBean) {

		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateSession.getSessionFactory().openSession();
			transaction = session.beginTransaction();			
			session.saveOrUpdate(assetBean);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			if (session.isConnected()) {
				session.close();
				HibernateSession.shoutDown();
			}
		}

	}

}
