package com.iprosonic.cmms.modules.cpi.transactions.cpi.dao;


import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.iprosonic.cmms.modules.cpi.transactions.cpi.domain.CpiBean;
import com.iprosonic.cmms.modules.cpi.transactions.cpi.service.CpiService;
import com.iprosonic.cmms.pjcommons.utility.DateUtil;
import com.iprosonic.cmms.pjcommons.utility.HibernateSession;

public class CpiDAOImpl {
	public List<CpiBean> getCpiList() {
		List<CpiBean> cpiList = null;
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateSession.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Criteria cpiBeanCriteria = session.createCriteria(CpiBean.class);
			cpiList = cpiBeanCriteria.list();
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

		finally {
			if (session.isConnected()) {
				session.close();
				HibernateSession.shoutDown();
			}
		}

		return cpiList;

	}

	public String saveCpi(CpiBean cpiBean) {
		Session session = null;
		Transaction transaction = null;
		CpiService cpiService = new CpiService();
		String cpiCd = null;
		try {
			session = HibernateSession.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			String latestNo = cpiService.genereateCpiCd("CPI");
			String cpiCreatedDate = cpiBean.getDateOfCpi();
			String month = cpiCreatedDate.substring(5, 7);
			String date = cpiCreatedDate.substring(8, 10);
			cpiCd = cpiBean.getUnitCd() + month + date + latestNo;
			cpiBean.setCpiCd(cpiCd);
			cpiBean.setAssetName("NA");
			cpiBean.setAssetType("NA");
			cpiBean.setAssetName("NA");
			cpiBean.setAssetSrNo("NA");
			cpiBean.setSectionSerialNo("NA");
			cpiBean.setSectionName("NA");
			cpiBean.setCpiStatus("NA");
			cpiBean.setCpiProcess("NA");
			cpiBean.setWhyOpen("NA");
			cpiBean.setWhyOpenOthers("NA");
			cpiBean.setJobSuccessfullyDone("NA");
			cpiBean.setPm2status("NA");
			cpiBean.setLastCalibrationDate("NA");
			cpiBean.setLastJobDone("NA");
			cpiBean.setLastFailure("NA");
			cpiBean.setCorrectiveAction1("NA");
			cpiBean.setCorrectiveAction2("NA");
			cpiBean.setCorrectiveAction3("NA");
			cpiBean.setCorrectiveAction4("NA");
			cpiBean.setCorrectiveAction5("NA");
			cpiBean.setCorrectiveAction6("NA");
			cpiBean.setCorrectiveActionDoneBy1("NA");
			cpiBean.setCorrectiveActionDoneBy2("NA");
			cpiBean.setCorrectiveActionDoneBy3("NA");
			cpiBean.setCorrectiveActionDoneBy4("NA");
			cpiBean.setCorrectiveActionDoneBy5("NA");
			cpiBean.setCorrectiveActionDoneBy6("NA");

			cpiBean.setOpenDate1("NA");
			cpiBean.setOpenDate2("NA");
			cpiBean.setOpenDate3("NA");
			cpiBean.setOpenDate4("NA");
			cpiBean.setOpenDate5("NA");
			cpiBean.setOpenDate6("NA");

			cpiBean.setCloseDate1("NA");
			cpiBean.setCloseDate2("NA");
			cpiBean.setCloseDate3("NA");
			cpiBean.setCloseDate4("NA");
			cpiBean.setCloseDate5("NA");
			cpiBean.setCloseDate6("NA");

			cpiBean.setCorrectiveActionCode1("NA");
			cpiBean.setCorrectiveActionCode2("NA");
			cpiBean.setCorrectiveActionCode3("NA");
			cpiBean.setCorrectiveActionCode4("NA");
			cpiBean.setCorrectiveActionCode5("NA");
			cpiBean.setCorrectiveActionCode6("NA");

			cpiBean.setMrfNo("NA");
			cpiBean.setRemarksOnMrf("NA");
			cpiBean.setPrcaAssignedTo("NA");
			cpiBean.setPrcaDoneBy("NA");

			cpiBean.setDateOfPrca("NA");
			cpiBean.setPrcaReport("NA");
			cpiBean.setPrcaRemarks("NA");
			cpiBean.setFrcaAssignedTo("NA");
			cpiBean.setFrcaDoneBy("NA");
			cpiBean.setDateOfFrca("NA");
			cpiBean.setFrcaReport("NA");
			cpiBean.setFrcaRemarks("NA");

			cpiBean.setSourceOfCpi("NA");
			cpiBean.setSubSourceOfCpi("NA");
			cpiBean.setGroupCode("NA");
			cpiBean.setSubGroupCd("NA");
			cpiBean.setCategory("NA");
			cpiBean.setSubCategory("NA");
			cpiBean.setEffectOnCustomer("NA");
			cpiBean.setImpactToCoustomer("NA");
			cpiBean.setCommentsOnCloser("NA");

			session.saveOrUpdate(cpiBean);
			transaction.commit();
		} catch (HibernateException e) {
			e.printStackTrace();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session.isConnected()) {
				session.close();
				HibernateSession.shoutDown();
			}
		}
		return cpiCd;
	}

	public CpiBean listCpiById(int cpiId) {
		Session session = null;
		Transaction transaction = null;
		CpiBean cpiBean = null;
		try {
			session = HibernateSession.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			cpiBean = (CpiBean) session.get(CpiBean.class, cpiId);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session.isConnected()) {
				session.close();
				HibernateSession.shoutDown();
			}
		}
		return cpiBean;
	}

	public void updateCpi(CpiBean cpiBean) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateSession.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.saveOrUpdate(cpiBean);

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

	public List<CpiBean> getCpiList(String fromDate, String toDate,
			String cpiCd, String unitCd, String cpiStatus, String assetType,
			String correctiveActionDoneBy1, String typeOfCpi,
			String impactToCoustomer, String effectOnCustomer,
			String sourceOfCpi, String subSourceOfCpi, String groupCd,
			String subGroupCd, String category, String subCategory,
			String prcaDoneBy, String frcaDoneBy) {

		List<CpiBean> cpiList = null;
		Session session = null;
		Transaction transaction = null;

		try {
			session = HibernateSession.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Criteria cpiBeanCriteria = session.createCriteria(CpiBean.class);

			cpiBeanCriteria.add(Restrictions.ge("dateOfCpi", fromDate));
			cpiBeanCriteria.add(Restrictions.le("dateOfCpi", toDate));

			if (!cpiCd.equalsIgnoreCase("-Select-")) {
				cpiBeanCriteria.add(Restrictions.like("cpiCd", cpiCd));
			}
			if (!unitCd.equalsIgnoreCase("-Select-")) {
				cpiBeanCriteria.add(Restrictions.like("unitCd", unitCd));
			}

			if (!cpiStatus.equalsIgnoreCase("-Select-")) {
				cpiBeanCriteria.add(Restrictions.like("cpiStatus", cpiStatus));
			}

			// -------

			if (!assetType.equalsIgnoreCase("-Select-")) {
				cpiBeanCriteria.add(Restrictions.like("assetType", assetType));
			}

			if (!correctiveActionDoneBy1.equalsIgnoreCase("-Select-")) {
				cpiBeanCriteria.add(Restrictions.like(
						"correctiveActionDoneBy1", correctiveActionDoneBy1));
			}

			if (!typeOfCpi.equalsIgnoreCase("-Select-")) {
				cpiBeanCriteria.add(Restrictions.like("cpiNature", typeOfCpi));
			}

			if (!impactToCoustomer.equalsIgnoreCase("-Select-")) {
				cpiBeanCriteria.add(Restrictions.like("impactToCoustomer",
						impactToCoustomer));
			}

			if (!effectOnCustomer.equalsIgnoreCase("-Select-")) {
				cpiBeanCriteria.add(Restrictions.like("effectOnCustomer",
						effectOnCustomer));
			}

			if (!sourceOfCpi.equalsIgnoreCase("-Select-")) {
				cpiBeanCriteria.add(Restrictions.like("sourceOfCpi",
						sourceOfCpi));
			}

			if (!subSourceOfCpi.equalsIgnoreCase("-Select-")) {
				cpiBeanCriteria.add(Restrictions.like("subSourceOfCpi",
						subSourceOfCpi));
			}

			if (!groupCd.equalsIgnoreCase("-Select-")) {
				cpiBeanCriteria.add(Restrictions.like("groupCode", groupCd));
			}

			if (!subGroupCd.equalsIgnoreCase("-Select-")) {
				cpiBeanCriteria
						.add(Restrictions.like("subGroupCd", subGroupCd));
			}

			if (!prcaDoneBy.equalsIgnoreCase("-Select-")) {
				cpiBeanCriteria
						.add(Restrictions.like("prcaDoneBy", prcaDoneBy));
			}

			if (!frcaDoneBy.equalsIgnoreCase("-Select-")) {
				cpiBeanCriteria
						.add(Restrictions.like("frcaDoneBy", prcaDoneBy));
			}

			cpiList = cpiBeanCriteria.list();
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

		finally {
			if (session.isConnected()) {
				session.close();
				HibernateSession.shoutDown();
			}
		}

		return cpiList;

	}

	public List<CpiBean> listCpiByCpiCd(String cpiCd) {
		Session session = null;
		Transaction transaction = null;
		List<CpiBean> cpiBeansList = null;

		try {
			session = HibernateSession.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(CpiBean.class);
			if (!cpiCd.equalsIgnoreCase("-Select-")) {
				criteria.add(Restrictions.like("cpiCd", cpiCd));
			}
			cpiBeansList = criteria.list();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			if (session.isConnected()) {
				session.close();
				HibernateSession.shoutDown();
			}
		}
		return cpiBeansList;
	}

	public CpiBean getDefaultValue() {

		CpiBean cpiBean = new CpiBean();
		cpiBean.setDateOfCpi(DateUtil.getCurrentDateWasCpi());
		cpiBean.setUpdateDate(DateUtil.getCurrentDateWasCpi());

		return cpiBean;
	}

	public List<CpiBean> getCpiList(String sectionName, String sectionSrNo) {
		List<CpiBean> cpiList = null;
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateSession.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Criteria cpiBeanCriteria = session.createCriteria(CpiBean.class);

			if (!sectionName.equalsIgnoreCase("-Select-")) {
				cpiBeanCriteria.add(Restrictions.like("sectionName",
						sectionName));
			}

			if (!sectionSrNo.equalsIgnoreCase("-Select-")) {
				cpiBeanCriteria.add(Restrictions.like("sectionSerialNo",
						sectionSrNo));
			}

			cpiList = cpiBeanCriteria.list();
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

		finally {
			if (session.isConnected()) {
				session.close();
				HibernateSession.shoutDown();
			}
		}

		return cpiList;
	}
}
