package com.iprosonic.cmms.pjcommons.valuelist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.iprosonic.cmms.modules.cpi.masters.assets.domain.AssetBean;
import com.iprosonic.cmms.modules.cpi.masters.group.domain.CpiMasterBean;
import com.iprosonic.cmms.modules.cpi.transactions.cpi.dao.CpiDAOImpl;
import com.iprosonic.cmms.modules.cpi.transactions.cpi.domain.CpiBean;
import com.iprosonic.cmms.modules.masters.user.domain.EmployeeBean;
import com.iprosonic.cmms.pjcommons.model.NumberingBean;
import com.iprosonic.cmms.pjcommons.utility.HibernateSession;

public class CpiGetList {

	public List<String> correctiveActionDoneBy() {
		List<String> correctiveActionDoneByList = null;
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateSession.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(EmployeeBean.class);
			criteria.setProjection(Projections.distinct(Projections.property("employeeName")));
			correctiveActionDoneByList = criteria.list();
			// Collections.sort(correctiveActionDoneByList);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}

		finally {
			if (session.isConnected()) {
				session.close();
				HibernateSession.shoutDown();
			}
		}

		return correctiveActionDoneByList;
	}

	public String getCpiNo(String codeType) {
		String latestCpiNo = "";

		Session session = null;
		Transaction transaction = null;
		List<String> codeTypeList = null;
		String updateQuery = null;
		String updateNo = "";
		int nextNo = 0;
		try {
			session = HibernateSession.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(NumberingBean.class);
			ProjectionList projectionList = Projections.projectionList();
			criteria.add(Restrictions.like("codeType", codeType));
			projectionList.add(Projections.property("latestNo"));
			criteria.setProjection(projectionList);
			codeTypeList = criteria.list();
			Iterator<String> codeTypeIterator = codeTypeList.iterator();
			while (codeTypeIterator.hasNext()) {

				latestCpiNo = codeTypeIterator.next();
			}

			transaction.commit();
			session.close();
			nextNo = Integer.parseInt(latestCpiNo) + 1;
			updateNo = String.valueOf(nextNo);

			updateQuery = "update NumberingBean set latestNo =:latestNo where codeType=:codeType";
			session = HibernateSession.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Query updateNumberingQuery = session.createQuery(updateQuery);
			updateNumberingQuery.setString("latestNo", updateNo);
			updateNumberingQuery.setString("codeType", codeType);
			updateNumberingQuery.executeUpdate();
			transaction.commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session.isConnected()) {
				session.close();
				HibernateSession.shoutDown();
			}
		}

		return latestCpiNo;

	}

	public List<String> getCorrectiveActionDoneById(int id) {
		List<String> correctiveActionDoneList = null;

		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateSession.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(CpiBean.class);
			criteria.add(Restrictions.like("id", id));
			correctiveActionDoneList = criteria.list();
			transaction.commit();
		} catch (Exception e) {
		} finally {
			if (session.isConnected()) {
				session.close();
				HibernateSession.shoutDown();
			}

		}

		return correctiveActionDoneList;
	}

	public List<CpiBean> getCpiListById(int id) {

		List<CpiBean> cpiBeanListById = null;
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateSession.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(CpiBean.class);
			criteria.add(Restrictions.like("id", id));
			cpiBeanListById = criteria.list();
			transaction.commit();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			if (session.isConnected()) {
				session.close();
				HibernateSession.shoutDown();
			}
		}

		return cpiBeanListById;
	}

	public List<CpiBean> getCpiList(String cpiCd) {
		List<CpiBean> cpiBeanList = null;
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateSession.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(CpiBean.class);
			if (!cpiCd.equalsIgnoreCase("-Select-")) {
				criteria.add(Restrictions.like("cpiCd", cpiCd));
			}
			cpiBeanList = criteria.list();
			transaction.commit();
		} catch (HibernateException e) {
			if (transaction.wasCommitted()) {
				transaction.rollback();
				e.printStackTrace();

			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			if (session.isConnected()) {
				session.close();
				HibernateSession.shoutDown();
			}

		}

		return cpiBeanList;

	}

	public Set<String> getRegionCd() {
		Set<String> regionSet = null;
		CpiDAOImpl cpiDAOImpl = null;

		try {
			cpiDAOImpl = new CpiDAOImpl();
			List<CpiBean> cpiList = cpiDAOImpl.getCpiList();
			Iterator<CpiBean> cpiListIterator = cpiList.iterator();
			regionSet = new HashSet<String>();
			while (cpiListIterator.hasNext()) {
				CpiBean cpiBean = cpiListIterator.next();
				String regionCd = cpiBean.getRegionCd();
				regionSet.add(regionCd);
			}

		} catch (Exception e) {
			e.printStackTrace();

		}

		return regionSet;
	}

	public String getLocationCdString(String regionCd) {
		List<String> locationCdList = null;

		String listString = "-Select-:";
		Session session = null;
		try {
			session = HibernateSession.getSessionFactory().openSession();
			Criteria criteria = session.createCriteria(CpiBean.class);
			criteria.add(Restrictions.like("regionCd", regionCd));
			criteria.setProjection(Projections.distinct(Projections.property("locationCd")));
			locationCdList = criteria.list();

			for (String s : locationCdList) {

				listString += s + ":";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return listString;
	}

	public String getUnitCdString(String locationCd) {
		List<String> unitCdList = null;

		String listString = "-Select-:";
		Session session = null;
		try {
			session = HibernateSession.getSessionFactory().openSession();
			Criteria criteria = session.createCriteria(CpiBean.class);
			criteria.add(Restrictions.like("locationCd", locationCd));
			criteria.setProjection(Projections.distinct(Projections.property("unitCd")));
			unitCdList = criteria.list();
			for (String s : unitCdList) {

				listString += s + ":";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return listString;
	}

	public String getClientCdString(String unitCd) {
		List<String> clientCdList = null;

		String listString = "-Select-:";
		Session session = null;
		try {
			session = HibernateSession.getSessionFactory().openSession();
			Criteria criteria = session.createCriteria(CpiBean.class);
			criteria.add(Restrictions.like("unitCd", unitCd));
			criteria.setProjection(Projections.distinct(Projections.property("clientCd")));
			clientCdList = criteria.list();

			for (String s : clientCdList) {

				listString += s + ":";

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return listString;
	}

	public String getOriginatedByString(String clientCd) {
		List<String> originatedByCdList = null;

		String listString = "-Select-:";

		Session session = null;
		try {
			session = HibernateSession.getSessionFactory().openSession();
			Criteria criteria = session.createCriteria(CpiBean.class);
			criteria.setProjection(Projections.distinct(Projections.property("originatedBy")));

			originatedByCdList = criteria.list();

			for (String s : originatedByCdList) {

				listString += s + ":";

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return listString;
	}

	public List<String> getPriority() {
		List<String> prioritylist = null;
		Session session = null;
		Transaction transaction = null;

		try {
			session = HibernateSession.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(CpiBean.class);
			criteria.setProjection(Projections.distinct(Projections.property("priority")));
			prioritylist = criteria.list();

		} catch (Exception e) {
			if (transaction.wasCommitted()) {
				transaction.rollback();
			}

			e.printStackTrace();
		} finally {
			if (session.isConnected()) {
				session.close();
				HibernateSession.shoutDown();
			}
		}
		return prioritylist;
	}

	public String getCpiType(String priority) {
		List<String> cpiTypeList = null;
		Session session = null;
		Transaction transaction = null;
		String listString = "-Select-:";

		try {
			session = HibernateSession.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(CpiBean.class);
			criteria.add(Restrictions.like("priority", priority));
			criteria.setProjection(Projections.distinct(Projections.property("cpiType")));
			cpiTypeList = criteria.list();

			for (String s : cpiTypeList) {

				listString += s + ":";

			}

		} catch (Exception e) {
			if (transaction.wasCommitted()) {
				transaction.rollback();
			}

			e.printStackTrace();
		} finally {
			if (session.isConnected()) {
				session.close();
				HibernateSession.shoutDown();
			}
		}
		return listString;
	}

	public String getMaintenanceType(String cpiType) {
		List<String> maintenanceTypeList = null;
		Session session = null;
		String listString = "-Select-:";
		Transaction transaction = null;
		try {
			session = HibernateSession.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(CpiBean.class);
			criteria.add(Restrictions.like("cpiType", cpiType));
			criteria.setProjection(Projections.distinct(Projections.property("maintanenceType")));
			maintenanceTypeList = criteria.list();
			for (String s : maintenanceTypeList) {
				listString += s + ":";
			}

		} catch (Exception e) {
			if (transaction.wasCommitted()) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session.isConnected()) {
				session.close();
				HibernateSession.shoutDown();
			}
		}
		return listString;
	}

	public List<String> getAssetType1() {
		List<String> assetTypeList1 = null;
		try {
			assetTypeList1 = new ArrayList<String>();
			assetTypeList1.add("ASQS");
			assetTypeList1.add("DTHL");
			assetTypeList1.add("FILD");

		} catch (Exception e) {

			e.printStackTrace();
		}
		return assetTypeList1;
	}

	public String getAssetCd(String assetType, String type) {

		Session session = null;
		Transaction transaction = null;
		List<String> assetCdList = null;
		String listString = "-Select-:";

		Criteria criteria = null;

		try {
			session = HibernateSession.getSessionFactory().openSession();
			transaction = session.beginTransaction();

			if (type.equalsIgnoreCase("getAssetCd1")) {
				criteria = session.createCriteria(AssetBean.class);
				criteria.add(Restrictions.like("assetType", assetType));
				criteria.setProjection(Projections.distinct(Projections.property("assetCd")));

				assetCdList = criteria.list();
			}
			assetCdList = criteria.list();
			for (String s : assetCdList) {

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
	}

	public String getAssetSrNo(String assertCd1, String type) {

		List<String> assetSrNo1List = null;
		Session session = null;
		Transaction transaction = null;
		Criteria criteria = null;
		String listString = "-Select-:";

		try {

			session = HibernateSession.getSessionFactory().openSession();

			if (type.equalsIgnoreCase("getAssetSrNo1")) {

				criteria = session.createCriteria(AssetBean.class);
				transaction = session.beginTransaction();
				criteria.add(Restrictions.like("assetCd", assertCd1));
				criteria.setProjection(Projections.distinct(Projections.property("assetSerialNo")));
				assetSrNo1List = criteria.list();

				for (String assetSrNo : assetSrNo1List) {

					listString += assetSrNo + ":";

				}

				transaction.commit();
			}

		}

		catch (Exception e) {
			if (transaction.wasCommitted()) {
				transaction.rollback();
			}

			e.printStackTrace();
		} finally {
			if (session.isConnected()) {
				session.close();
				HibernateSession.shoutDown();
			}
		}
		return listString;
	}

	public String getSectionName(String assetSrNo, String type) {
		List<String> sectionNameList = null;

		Session session = null;
		Transaction transaction = null;
		Criteria criteria = null;
		String listString = "-Select-:";

		try {
			session = HibernateSession.getSessionFactory().openSession();
			transaction = session.beginTransaction();

			if (type.equalsIgnoreCase("getSectionName1")) {
				criteria = session.createCriteria(AssetBean.class);
				criteria.add(Restrictions.like("assetSerialNo", assetSrNo));
				criteria.setProjection(Projections.distinct(Projections.property("sectionCd")));
				sectionNameList = criteria.list();

			}

			for (String assetSr1 : sectionNameList) {
				listString += assetSr1 + ":";
			}

		} catch (Exception e) {
			if (transaction.wasCommitted()) {
				transaction.rollback();
			}

			e.printStackTrace();
		} finally {
			if (session.isConnected()) {
				session.close();
				HibernateSession.shoutDown();
			}
		}
		return listString;
	}

	public String getSectionSrNo(String sectionName, String type) {
		List<String> sectionSrNoList = null;

		Session session = null;
		Transaction transaction = null;
		String listString = "-Select:-";
		Criteria criteria = null;
		try {
			session = HibernateSession.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			if (type.equalsIgnoreCase("getSectionSerialNo1")) {
				criteria = session.createCriteria(AssetBean.class);
				criteria.add(Restrictions.like("sectionCd", sectionName));
				criteria.setProjection(Projections.distinct(Projections.property("sectionSerialNo")));
				sectionSrNoList = criteria.list();
			}
			for (String assetSr1 : sectionSrNoList) {
				listString += assetSr1 + ":";
			}
		} catch (Exception e) {
			if (transaction.wasCommitted()) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session.isConnected()) {
				session.close();
				HibernateSession.shoutDown();
			}
		}
		return listString;
	}

	public List<String> getCpiProcess() {
		List<String> cpiProcessList = null;
		try {
			cpiProcessList = new ArrayList<String>();
			cpiProcessList.add("Diagnosis");
			cpiProcessList.add("Partially_Diagnosed");
			cpiProcessList.add("Ready_For_Analysis");
			cpiProcessList.add("Partially_Analysed");
			cpiProcessList.add("Waiting_For_Job");
			cpiProcessList.add("Job_Done");
			cpiProcessList.add("Closed");

		} catch (Exception e) {

			e.printStackTrace();
		}

		return cpiProcessList;

	}

	/*-Common for Search Cpi and MWAS REPORT INPUT Criteria
	 * INPUT 1--> CpiCd
	 */

	public synchronized List<String> getCpiCd() {

		List<String> cpiCdList = null;

		Session session = null;
		Transaction transaction = null;
		Criteria criteria = null;
		try {
			session = HibernateSession.getSessionFactory().openSession();
			transaction = session.beginTransaction();

			criteria = session.createCriteria(CpiBean.class);
			criteria.setProjection(Projections.distinct(Projections.property("cpiCd")));
			cpiCdList = criteria.list();

		} catch (Exception e) {
			if (transaction.wasCommitted()) {
				transaction.rollback();
			}

			e.printStackTrace();
		} finally {
			if (session.isConnected()) {
				session.close();
				HibernateSession.shoutDown();
			}
		}
		return cpiCdList;
	}

	// --------------- cpi master
	public List<String> getCpiStatus() {
		List<String> cpiStatusList = null;
		try {

			cpiStatusList = new ArrayList<String>();
			cpiStatusList.add("OPEN_YELLOW");
			cpiStatusList.add("OPEN_RED");
			cpiStatusList.add("OPEN_BLUE");
			cpiStatusList.add("CLOSE_GREEN");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cpiStatusList;
	}

	public List<String> getWhyOpen() {
		Session session = null;
		Transaction transaction = null;

		List<String> cpiWhyOpenList = null;
		try {
			session = HibernateSession.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Criteria whyOpenCriteria = session.createCriteria(CpiMasterBean.class);
			whyOpenCriteria.setProjection(Projections.distinct(Projections.property("whyOpen")));
			cpiWhyOpenList = whyOpenCriteria.list();
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
		return cpiWhyOpenList;
	}

	// --

	public List<String> getAssetTypeList() {
		List<String> assetTypeList = null;
		Session session = null;
		Transaction transaction = null;

		try {
			session = HibernateSession.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Criteria assetTypeCriteria = session.createCriteria(AssetBean.class);
			assetTypeCriteria.setProjection(Projections.distinct(Projections.property("assetType")));
			assetTypeList = assetTypeCriteria.list();
			Collections.sort(assetTypeList);
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			if (session.isConnected()) {
				session.close();
				HibernateSession.shoutDown();
			}
		}
		return assetTypeList;
	}

	public List<String> getAssetNameList() {
		List<String> assetNameList = null;
		Session session = null;
		Transaction transaction = null;

		try {
			session = HibernateSession.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Criteria assetNameCriteria = session.createCriteria(AssetBean.class);
			assetNameCriteria.setProjection(Projections.distinct(Projections.property("assetCd")));
			assetNameList = assetNameCriteria.list();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			if (session.isConnected()) {
				session.close();
				HibernateSession.shoutDown();
			}
		}
		return assetNameList;
	}

	public List<String> getassetCdList() {
		List<String> assertCdList = null;
		Session session = null;
		Transaction transaction = null;

		try {
			session = HibernateSession.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(AssetBean.class);
			criteria.setProjection(Projections.distinct(Projections.property("assetCd")));
			assertCdList = criteria.list();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			if (session.isConnected()) {
				session.close();
				HibernateSession.shoutDown();
			}
		}
		return assertCdList;
	}

	public List<String> getAssetSrNoList() {
		List<String> assetSrNoList = null;

		Session session = null;
		Transaction transaction = null;

		try {
			session = HibernateSession.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(AssetBean.class);
			criteria.setProjection(Projections.distinct(Projections.property("assetSerialNo")));
			assetSrNoList = criteria.list();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			if (session.isConnected()) {
				session.close();
				HibernateSession.shoutDown();
			}
		}

		return assetSrNoList;
	}

	public List<String> getSectionNoList() {
		List<String> sectionCdList = null;

		Session session = null;
		Transaction transaction = null;

		try {
			session = HibernateSession.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(AssetBean.class);
			criteria.setProjection(Projections.distinct(Projections.property("sectionCd")));
			sectionCdList = criteria.list();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			if (session.isConnected()) {
				session.close();
				HibernateSession.shoutDown();
			}
		}

		return sectionCdList;
	}

	public List<String> getSectionSerialNoList() {
		List<String> sectionSerialNoList = null;
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateSession.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(AssetBean.class);
			criteria.setProjection(Projections.distinct(Projections.property("sectionSerialNo")));

			sectionSerialNoList = criteria.list();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			if (session.isConnected()) {
				session.close();
				HibernateSession.shoutDown();
			}

		}
		return sectionSerialNoList;
	}

	// -------CPI Master

	public List<String> getTypeOfCpiList() {
		List<String> typeOfCpiList = null;
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateSession.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Criteria typeOfCpiCriteria = session.createCriteria(CpiMasterBean.class);
			typeOfCpiCriteria.setProjection(Projections.distinct(Projections.property("typeOfCpi")));
			typeOfCpiList = typeOfCpiCriteria.list();

		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();

		} finally {
			if (session.isConnected()) {
				session.close();
				HibernateSession.shoutDown();
			}

		}

		return typeOfCpiList;

	}

	public List<String> getSourceOfCpiList() {
		List<String> sourceOfCpiList = null;
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateSession.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Criteria sourceOfCpiCriteria = session.createCriteria(CpiMasterBean.class);
			sourceOfCpiCriteria.setProjection(Projections.distinct(Projections.property("sourceOfCpi")));
			sourceOfCpiList = sourceOfCpiCriteria.list();

		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();

		} finally {
			if (session.isConnected()) {
				session.close();
				HibernateSession.shoutDown();
			}

		}

		return sourceOfCpiList;

	}

	public List<String> getSubSourceOfCpiList() {
		List<String> subSourceOfCpiList = null;
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateSession.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Criteria subSourceOfCpiCriteria = session.createCriteria(CpiMasterBean.class);
			subSourceOfCpiCriteria.setProjection(Projections.distinct(Projections.property("subSourceOfCpi")));
			subSourceOfCpiList = subSourceOfCpiCriteria.list();

		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();

		} finally {
			if (session.isConnected()) {
				session.close();
				HibernateSession.shoutDown();
			}

		}

		return subSourceOfCpiList;

	}

	// ------

	public List<String> getsubGroupCdList() {
		List<String> subGroupCdList = null;
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateSession.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Criteria subGroupCdCriteria = session.createCriteria(CpiMasterBean.class);
			subGroupCdCriteria.setProjection(Projections.distinct(Projections.property("subGroupName")));
			subGroupCdList = subGroupCdCriteria.list();

		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();

		} finally {
			if (session.isConnected()) {
				session.close();
				HibernateSession.shoutDown();
			}

		}

		return subGroupCdList;

	}

	public List<String> getCpiCategoryList() {
		List<String> cpiCategoryList = null;
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateSession.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Criteria cpiCategoryCriteria = session.createCriteria(CpiMasterBean.class);
			cpiCategoryCriteria.setProjection(Projections.distinct(Projections.property("category")));
			cpiCategoryList = cpiCategoryCriteria.list();

		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();

		} finally {
			if (session.isConnected()) {
				session.close();
				HibernateSession.shoutDown();
			}

		}

		return cpiCategoryList;

	}

	public List<String> getCpiSubCategoryList() {
		List<String> cpiSubCategoryList = null;
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateSession.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Criteria cpiSubCategoryCriteria = session.createCriteria(CpiMasterBean.class);
			cpiSubCategoryCriteria.setProjection(Projections.distinct(Projections.property("subCategory")));
			cpiSubCategoryList = cpiSubCategoryCriteria.list();

		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();

		} finally {
			if (session.isConnected()) {
				session.close();
				HibernateSession.shoutDown();
			}

		}

		return cpiSubCategoryList;

	}

	/*-MWAS REPORT INPUT Criteria
	 
	 * INPUT 2--> UnitCd

	 */

	public List<String> getUnitCdList() {

		List<String> unitCdList = null;
		Session session = null;
		Transaction transaction = null;

		try {
			session = HibernateSession.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Criteria unitCdCriteria = session.createCriteria(AssetBean.class);
			unitCdCriteria.setProjection(Projections.distinct(Projections.property("unitCd")));
			unitCdList = unitCdCriteria.list();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();

		} finally {
			if (session.isConnected()) {
				session.close();
				HibernateSession.shoutDown();
			}
		}

		return unitCdList;
	}

}
