package com.iprosonic.cmms.modules.job.transactions.job.service;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;
import com.iprosonic.cmms.modules.job.transactions.job.domain.JobExplBean;
import com.iprosonic.cmms.modules.job.transactions.job.domain.JobRigBean;
import com.iprosonic.cmms.modules.job.transactions.job.domain.JobRunBean;
import com.iprosonic.cmms.modules.job.transactions.job.domain.JobServiceBean;
import com.iprosonic.cmms.pjcommons.utility.HibernateSession;

public class EditJobService {

	public String[] getValueRigToExplosive(String jobNo, String role) {

		String[] rigToExplosive = new String[5];
		StringBuffer stringBuffer = new StringBuffer();
		Session session = HibernateSession.getSessionFactory().openSession();
		stringBuffer.append("<table id='datatable'>");
		Criteria jobRigCriteria = session.createCriteria(JobRigBean.class);
		jobRigCriteria.add(Restrictions.eq("jobNo", jobNo));
		List<JobRigBean> list = jobRigCriteria.list();
		Iterator<JobRigBean> jobRigItr = list.iterator();
		Integer rigCount = list.size();
		Integer runCount = 0;
		Integer serviceCount = 0;
		Integer explosiveCount = 0;
		int i = 0;
		String width = "80px";
		String width_disabled = "80px";
		String width_date = "110px";

		while (jobRigItr.hasNext()) {
			JobRigBean jobRigBean = jobRigItr.next();
			String rigNo = jobRigBean.getRigNo();
			stringBuffer.append("<tr id='" + jobRigBean.getRigNo()
					+ "' class='rig'>");
			stringBuffer.append("<td><input  type ='radio' name='chk1' "
					+ "value= '" + jobRigBean.getRigNo() + "' id='"
					+ jobRigBean.getRigNo() + "' />");
			i++;
			stringBuffer.append("<td>" + "<input id='" + jobRigBean.getRigNo()
					+ "' style='width:" + width_disabled
					+ "' type='text' readonly='true'  value='"
					+ jobRigBean.getRigNo() + "'</input></td>");

			stringBuffer.append("<td>Rig Up Start</td>");
			stringBuffer
					.append("<td><input type='text' readOnly='true'  style='width:"
							+ width_date
							+ "' id='rigUpStart' value='"
							+ jobRigBean.getRigUpStart() + "'</input></td>");

			stringBuffer.append("<td>Rig Up End</td>");
			stringBuffer
					.append("<td><input type='text' readOnly='true'  style='width:"
							+ width_date
							+ "' id='rigUpEnd' value='"
							+ jobRigBean.getRigUpEnd() + "'</input></td>");

			stringBuffer.append("<td>Rig Down Start</td>");
			stringBuffer
					.append("<td><input type='text' readOnly='true'  style='width:"
							+ width_date
							+ "'  id='rigDownStart' value='"
							+ jobRigBean.getRigDownStart() + "'</input></td>");

			stringBuffer.append("<td>Rig Down End</td>");
			stringBuffer
					.append("<td><input type='text' readOnly='true'  style='width:"
							+ width_date
							+ "'  id='rigDownEnd' value='"
							+ jobRigBean.getRigDownEnd() + "'</input></td>");
			stringBuffer.append("</tr>");
			
			

			
			Criteria jobRunCriteria = session.createCriteria(JobRunBean.class);
			jobRunCriteria.add(Restrictions.eq("rigNo", rigNo));
			Iterator<JobRunBean> jobRunItr = jobRunCriteria.list().iterator();
			
			while (jobRunItr.hasNext()) {
				runCount++;
				JobRunBean jobRunBean = jobRunItr.next();
				String runNo = jobRunBean.getRunNo();
				stringBuffer.append("<tr id='" + i + "' class='run'>");
				stringBuffer.append("<td><input  type ='radio'"
						+ "name='chk1'  value= '" + jobRunBean.getRunNo()
						+ "' id='" + jobRunBean.getRunNo() + "'  />");
				i++;
				stringBuffer.append("<td style='visibility:visible'>"
						+ "<input id='jobNo'  type='text'  style='width:"
						+ width_disabled + "' readonly='true' value='"
						+ jobRunBean.getRunNo() + "'</input></td>");

				 

				stringBuffer.append("<td>BHT</td>");
				stringBuffer
						.append("<td><input id='jobNo' readOnly='true'  style='width:"
								+ width
								+ "' type='text' value="
								+ jobRunBean.getBht() + "></input></td>");

				stringBuffer.append("<td>Operating time start</td>");
				stringBuffer
						.append("<td><input id='jobNo' readOnly='true'  style='width:"
								+ width_date
								+ "' type='text' value='"
								+ jobRunBean.getRih() + "'</input></td>");

				stringBuffer.append("<td>Operating time stop</td>");
				stringBuffer
						.append("<td><input id='jobNo' readOnly='true'  style='width:"
								+ width_date
								+ "' type='text' value='"
								+ jobRunBean.getPooh() + "'</input></td>");

				stringBuffer.append("<td>OT</td>");
				stringBuffer
						.append("<td><input id='jobNo' readOnly='true'  style='width:"
								+ width
								+ "' type='text' value='"
								+ jobRunBean.getOt() + "'</input></td>");
				stringBuffer.append("<td>WT</td>");
				stringBuffer
						.append("<td><input id='jobNo' readOnly='true'  style='width:"
								+ width
								+ "' type='text' value='"
								+ jobRunBean.getWt() + "'</input></td>");
				stringBuffer.append("</tr>");

				//-------------------------------------------SERVICE--------------------------------------------------------

				Query q=session.createQuery("from JobServiceBean where runNo=:run");
				q.setParameter("run", runNo);
				
				Iterator<JobServiceBean> jobServiceItr = q.list().iterator();
				
				
				while (jobServiceItr.hasNext()) {
					JobServiceBean jobServiceBean = jobServiceItr.next();
					serviceCount++;
					String serviceNo = jobServiceBean.getServiceNo();
					stringBuffer.append("<tr id='" + i + "' class='ser'>");
					stringBuffer.append("<td><input  type ='radio' name='chk1'"
							+ "  value= '" + jobServiceBean.getServiceNo()
							+ "' id='" + jobServiceBean.getServiceNo()
							+ "'  />");
					i++;


					stringBuffer.append("<td style='visibility: visible'>"
							+ "<input id='jobNo' style='width:"
							+ width_disabled
							+ "' type='text' readonly='true' value='"
							+ jobServiceBean.getServiceNo() + "'</input></td>");

					stringBuffer.append("<td>Service Type</td>");

					stringBuffer
							.append("<td><input id='jobNo' readOnly='true' style='width:"
									+ width
									+ "' type='text' value="
									+ jobServiceBean.getServiceType()
									+ "></input></td>");

					stringBuffer.append("<td>Service Name</td>");
					stringBuffer
							.append("<td><input id='jobNo' readOnly='true'  style='width:"
									+ width
									+ "' type='text' value="
									+ jobServiceBean.getServiceName()
									+ "></input></td>");

					stringBuffer.append("<td>Loss Time</td>");
					stringBuffer
							.append("<td><input id='jobNo' readOnly='true' style='width:"
									+ width
									+ "' type='text' value='"
									+ jobServiceBean.getLossTime()
									+ "'></input></td>");
					stringBuffer.append("</tr>");
					
					stringBuffer.append("<tr class='ser'>");
					
					stringBuffer.append("<td>Deepest Depth</td>");
					stringBuffer
							.append("<td><input id='jobNo' readOnly='true' style='width:"
									+ width
									+ "' type='text' value="
									+ jobServiceBean.getDeepestDepth()
									+ "></input></td>");
					
					
					
					
					stringBuffer.append("<td>Meterage Logged</td>");
					stringBuffer
					.append("<td><input id='jobNo'  readOnly='true' style='width:"
							+ width
							+ "' type='text' value="
							+ jobServiceBean.getMeterageLogged()
							+ "></input></td>");
					
					
					stringBuffer.append("<td>Rev($)</td>");
					stringBuffer
					.append("<td><input id='spf' readOnly='true'  style='width:"
							+ width
							+ "' type='text' value='"
							+ jobServiceBean.getRev()
							+ "'</input></td>");
					
					stringBuffer.append("<td>Failure Group</td>");
					stringBuffer
					.append("<td><input id='spf'  readOnly='true' style='width:"
							+ width
							+ "' type='text' value='"
							+ jobServiceBean.getFailureGroup()
							+ "'</input></td>");
					
					stringBuffer.append("</tr>");
					
					stringBuffer.append("<tr class='ser'>");
					
					stringBuffer.append("<td>Pretest Count</td>");
					stringBuffer
					.append("<td><input id='spf' readOnly='true'  style='width:"
							+ width
							+ "' type='text' value='"
							+ jobServiceBean.getPretestCount()
							+ "'</input></td>");
					
					stringBuffer.append("<td>PumpOut Time</td>");
					stringBuffer
					.append("<td><input id='spf' readOnly='true'  style='width:"
							+ width
							+ "' type='text' value='"
							+ jobServiceBean.getPumpOutTime()
							+ "'</input></td>");
					
				
					stringBuffer.append("<td>DryTest Count</td>");
					stringBuffer
					.append("<td><input id='spf' readOnly='true'  style='width:"
							+ width
							+ "' type='text' value='"
							+ jobServiceBean.getDryTestCount()
							+ "'</input></td>");
					
					stringBuffer.append("<td>Pvt Sample</td>");
					stringBuffer
					.append("<td><input id='spf' readOnly='true'  style='width:"
							+ width
							+ "' type='text' value='"
							+ jobServiceBean.getPvtSample()
							+ "'</input></td>");
					
					

					stringBuffer.append("<td>Normal Sample</td>");
					stringBuffer
					.append("<td><input id='spf' readOnly='true'  style='width:"
							+ width
							+ "' type='text' value='"
							+ jobServiceBean.getNormalSample()
							+ "'</input></td>");
					
					stringBuffer.append("</tr>");
					
					stringBuffer.append("<tr class='ser'>");
					
					stringBuffer.append("<td>Level Count</td>");
					stringBuffer
					.append("<td><input id='spf' readOnly='true'  style='width:"
							+ width
							+ "' type='text' value='"
							+ jobServiceBean.getLevelCount()
							+ "'</input></td>");
					
					stringBuffer.append("<td>Cross Count</td>");
					stringBuffer
					.append("<td><input id='spf' readOnly='true'  style='width:"
							+ width
							+ "' type='text' value='"
							+ jobServiceBean.getCoresCount()
							+ "'</input></td>");
					
					stringBuffer.append("</tr>");
					
					stringBuffer.append("<tr class='ser'>");
					
					
					stringBuffer.append("<td>Gun Size</td>");
					stringBuffer
					.append("<td><input id='gunSize' readOnly='true' style='width:"
							+ width
							+ "' type='text' value='"
							+ jobServiceBean.getGunSize()
							+ "'</input></td>");
					stringBuffer.append("<td>SPF</td>");
					stringBuffer
					.append("<td><input id='spf' readOnly='true' style='width:"
							+ width
							+ "' type='text' value='"
							+ jobServiceBean.getSpf()
							+ "'</input></td>");
					
					stringBuffer.append("<td>Meterage Perforated</td>");
					stringBuffer
					.append("<td><input id='jobNo' readOnly='true'  style='width:"
							+ width
							+ "' type='text' value="
							+ jobServiceBean.getMeteragePerforated()
							+ "></input></td>");
					
					
					
					stringBuffer.append("<td>Surface Pressure</td>");
					stringBuffer
					.append("<td><input id='spf' readOnly='true' style='width:"
							+ width
							+ "' type='text' value='"
							+ jobServiceBean.getSurfacePressure()
							+ "'</input></td>");
					
					stringBuffer.append("</tr>");
					
					stringBuffer.append("<tr class='ser'>"); 
					
					stringBuffer.append("<td>Ch Run</td>");
					stringBuffer
					.append("<td><input id='jobNo' readOnly='true' style='width:"
							+ width
							+ "' type='text' value="
							+ jobServiceBean.getChruns()
							+ "></input></td>");
					
					
					
					stringBuffer.append("<td>Ch MisRuns</td>");
					stringBuffer
					.append("<td><input id='chMisRuns' readOnly='true' style='width:"
							+ width
							+ "' type='text' value='"
							+ jobServiceBean.getChmisRuns()
							+ "'</input></td>");
					
					stringBuffer.append("<td>TCPMissRun</td>");
					stringBuffer
					.append("<td><input id='tcpmissrun' readOnly='true' style='width:"
							+ width
							+ "' type='text' value='"
							+ jobServiceBean.getTcpmissrun()
							+ "'</input></td>");
					
					stringBuffer.append("</tr>");
					
					stringBuffer.append("<tr class='ser'>"); 
					
					
					stringBuffer.append("<td>Asset Code</td>");
					
					stringBuffer
					.append("<td><input id='jobNo' readOnly='true' style='width:"
							+ width
							+ "' type='text' value="
							+ jobServiceBean.getAssetCd()
							+ "></input></td>");
					
					stringBuffer.append("<td>Serial No</td>");
					stringBuffer
							.append("<td><input id='jobNo' readOnly='true'  style='width:"
									+ width
									+ "' type='text' value="
									+ jobServiceBean.getSerialNo()
									+ "></input></td>");


				






 


					stringBuffer.append("<td>Engi</td>");
					stringBuffer
					.append("<td><input id='engi' readOnly='true' style='width:"
							+ width
							+ "' type='text' value='"
							+ jobServiceBean.getEngi()
							+ "'</input></td>");
					
				
					stringBuffer.append("<td>Crew</td>");
					stringBuffer
					.append("<td><input id='crew' readOnly='true' style='width:"
							+ width
							+ "' type='text' value='"
							+ jobServiceBean.getCrew()
							+ "'</input></td>");


					stringBuffer.append("<td>Remarks</td>");
					stringBuffer
							.append("<td><input id='spf' readOnly='true'  style='width:"
									+ width
									+ "' type='text' value='"
									+ jobServiceBean.getRemarks()
									+ "'</input></td>");

					
					
					stringBuffer.append("</tr>");
					
					stringBuffer.append("<tr class='ser'>"); 
					

					stringBuffer.append("<td>Log Send From Base</td>");
					stringBuffer
					.append("<td><input id='spf' readOnly='true'  style='width:"
							+ width
							+ "' type='text' value='"
							+ jobServiceBean.getLogSendFromBase()
							+ "'</input></td>");
					
					

					stringBuffer.append("<td>Log Recieve at HO</td>");
					stringBuffer
					.append("<td><input id='logRcieveAtHo' readOnly='true'  style='width:"
							+ width
							+ "' type='text' value='"
							+ jobServiceBean.getLogRcieveAtHo()
							+ "'</input></td>");


				/*	stringBuffer.append("</tr>");
					stringBuffer.append("<tr class='ser'>");*/


					// if (role.equalsIgnoreCase("FSQC"))
					

						stringBuffer.append("<td>LqaDoneDate</td>");
						stringBuffer
								.append("<td><input id='lquDoneDate' readOnly='true' style='width:"
										+ width_date
										+ "' type='text' value='"
										+ jobServiceBean.getLqaDoneDate()
										+ "'</input></td>");

						 
						
						stringBuffer.append("<td>Lqa Technical</td>");
						stringBuffer
								.append("<td><input id='lquDoneDate' readOnly='true'  style='width:"
										+ width
										+ "' type='text' value='"
										+ jobServiceBean.getLqaTechnical()
										+ "'</input></td>");

						stringBuffer.append("<td>Lqa Presentation</td>");
						stringBuffer
								.append("<td><input id='lquDoneDate' readOnly='true' style='width:"
										+ width
										+ "' type='text' value='"
										+ jobServiceBean.getLqaPresentation()
										+ "'</input></td>");
						stringBuffer.append("</tr><tr><td colspan='33'><hr></td></tr>");

						
						
						// -----------------------------------Explosives-------------------------------------------------------------------
						Query q1=session.createQuery("from JobExplBean where serviceNo=:service");
						q1.setParameter("service", serviceNo);
						
						@SuppressWarnings("unchecked")
						Iterator<JobExplBean> jobExplItr = q1.list().iterator();
						
						
						
						while (jobExplItr.hasNext()) {
							JobExplBean jobExplBean = jobExplItr.next();
							explosiveCount++;
							stringBuffer.append("<tr id='" + i	+ "' class='expl'>");
							stringBuffer.append("<td><input  type ='radio' name='chk1' "+ "value='"	+ jobExplBean.getExplNo()
											+ "' id='"+ jobExplBean.getExplNo() + "' />");
							i++;
							stringBuffer
									.append("<td style='visibility: visibility'>"
											+ "<input id='jobNo' style='width:"
											+ width
											+ "'type='text' readonly='true' value='"
											+ jobExplBean.getExplNo()
											+ "'</input></td>");

							stringBuffer.append("<td>PartCd</td>");
							stringBuffer
									.append("<td><input id='jobNo' readOnly='true' style='width:"
											+ width
											+ "' type='text' value="
											+ jobExplBean.getPartCd()
											+ "></input></td>");

							stringBuffer.append("<td>Qty</td>");
							stringBuffer
									.append("<td><input id='jobNo' readOnly='true' style='width:"
											+ width
											+ "' type='text' value="
											+ jobExplBean.getQty()
											+ "></input></td>");

							stringBuffer.append("<td>uom</td>");
							stringBuffer
									.append("<td><input id='jobNo' readOnly='true' style='width:"
											+ width
											+ "' type='text' value="
											+ jobExplBean.getUom()
											+ "></input></td>");
							stringBuffer.append("</tr>");
						}
					}
				}
			}
		
		stringBuffer.append("</table>");
		rigToExplosive[0] = stringBuffer.toString();
		rigToExplosive[1] = String.valueOf(rigCount);
		rigToExplosive[2] = String.valueOf(runCount);
		rigToExplosive[3] = String.valueOf(serviceCount);
		rigToExplosive[4] = String.valueOf(explosiveCount);

		session.close();
		HibernateSession.shoutDown();

		return rigToExplosive;
	}

}
