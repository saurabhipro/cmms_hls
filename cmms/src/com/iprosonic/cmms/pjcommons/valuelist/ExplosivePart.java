package com.iprosonic.cmms.pjcommons.valuelist;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.classic.Session;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.iprosonic.cmms.modules.masters.part.domain.PartMstBean;
import com.iprosonic.cmms.pjcommons.utility.HibernateAnnotationSession;

public class ExplosivePart {
	public static List<String> getExplosivePart() {

		Session session = HibernateAnnotationSession.getSessionFactory()
				.openSession();
		Criteria criteria = session.createCriteria(PartMstBean.class);
		ProjectionList projectionList = Projections.projectionList();
		projectionList.add(Projections.property("partCd"));
		criteria.add(Restrictions.like("l3CategoryCd", "Explosives"));
		criteria.setProjection(projectionList);
		List<String> list = criteria.list();
		session.close();
		HibernateAnnotationSession.shoutDown();
		return list;

	}

}
	