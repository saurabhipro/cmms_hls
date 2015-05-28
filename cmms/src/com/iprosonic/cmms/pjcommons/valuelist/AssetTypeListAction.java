package com.iprosonic.cmms.pjcommons.valuelist;



import java.util.Collections;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;

import com.iprosonic.cmms.modules.cpi.masters.assets.domain.AssetBean;
import com.iprosonic.cmms.pjcommons.utility.HibernateSession;

public class AssetTypeListAction {
	public List<String> getAssetType() {

		List<String> assetTypeList1 = null;
		Session session = null;
		Transaction transaction = null;

		
		try {
			session = HibernateSession.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(AssetBean.class);
			criteria.setProjection(Projections.distinct(Projections.property("assetType")));
			assetTypeList1=  criteria.list(); 
			Collections.sort(assetTypeList1);
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}
		return assetTypeList1;
	}
}
