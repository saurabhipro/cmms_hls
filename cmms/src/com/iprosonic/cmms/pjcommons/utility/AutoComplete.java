package com.iprosonic.cmms.pjcommons.utility;


import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;

import com.iprosonic.cmms.modules.masters.part.domain.PartMstBean;

public class AutoComplete {

    private int totalpartCdList;
    Session hibernateSession = HibernateSession.getSessionFactory().openSession();
    Transaction transaction = null;
    private List<String> partCdList;

    public AutoComplete()
    {
        List result = new ArrayList();
        Criteria crit = hibernateSession.createCriteria(PartMstBean.class);
        ProjectionList projectList = Projections.projectionList();
        projectList.add(Projections.property("partCd"));
        crit.setProjection(projectList);
        result = crit.list();
        partCdList = new ArrayList<String>();
        StringTokenizer st = new StringTokenizer(result.toString(), ",");
        while (st.hasMoreTokens()) {
            partCdList.add(st.nextToken().trim());
        }
        totalpartCdList = partCdList.size();
    }

    public List<String> getData(String query) {
        String partCd = null;
        
        query = query.toLowerCase();
        List<String> matched = new ArrayList<String>();
        for (int i = 0; i < totalpartCdList; i++) {
            partCd = partCdList.get(i).toLowerCase();
            if (partCd.startsWith(query)) {
                matched.add(partCdList.get(i));
            }
        }
        return matched;
    }
}
