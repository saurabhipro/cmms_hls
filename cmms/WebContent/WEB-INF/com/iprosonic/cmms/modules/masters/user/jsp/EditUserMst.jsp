<%@ page contentType="text/html; charset=ISO-8859-1" language="java"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="sjg" uri="/struts-jquery-grid-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Page</title>
<sj:head jqueryui="true" />
<s:head />
<style type="text/css">
@import url(css/tablestyle.css);
</style>
</head>
<body>
	<sj:tabbedpanel id="localtabs">
		<sj:tab id="tab1" target="tone" label="Edit Employee" />
		<div id="tone">
			<div class="type-text">
				<s:form id="formValidate" theme="qxhtml"
					action="UpdateEmployeeAction.action">
					<s:push value="employeeBean">
						<s:hidden name="id" />
						<s:textfield id="employeeName" name="employeeName"
							label="Employee Name" />
						<s:textfield id="employeeCd" readonly="true" name="employeeCd"
							label="Employee Code" />

                           <s:textfield id="employeeShortName" name="employeeShortName"
							label="Short Name" />
							

						<s:textfield id="password" name="password" label="Password" />
						<s:textfield id="departmentName" name="departmentName"
							label="Department Name" />
						<s:textfield id="designation" name="designation"
							label="Designation" />

						<s:select label="LocationCd"
							list="#{'-Select-':'-Select-'
						,'AGTJunk':'AGTJunk'
						,'ASP001OH':'ASP001OH'
						,'ASP001OHBdesh':'ASP001OHBdesh'
						,'HO':'HO'
						,'HOJunk':'HOJunk'
						,'JOGPL TCP':'JOGPL TCP'
						,'KWT001OH':'KWT001OH'
						,'KWT002OH':'KWT002OH'
						,'MMD':'MMD'
						,'MOD001CH':'MOD001CH'
						,'MOD002CH':'MOD002CH'
						,'MOD003CH':'MOD003CH'
						
						,'NAZJunk':'NAZJunk'
						,'NCC':'NCC'
						,'NER':'NER'
						,'OSMUMONGC':'OSMUMONGC'
						,'POOL SWR':'POOL SWR'
						,'SHO':'SHO'
						,'SKD002OH':'SKD002OH'
						,'SKD003CH':'SKD003CH'
						,'SKD004CH':'SKD004CH'
						,'SKD005CH':'SKD005CH'
						,'SKD006CH':'SKD006CH'
						,'SKD007CH':'SKD007CH'
						,'SKD008CH':'SKD008CH'
						,'SKD009CH':'SKD009CH'
						,'SWR':'SWR'
						,'SWRJunk':'SWRJunk'
						
						}"
							name="locationCd" headerKey="0" cssStyle="width:145px">
						</s:select>



						<s:textfield id="mobileNo" name="mobileNo" label="Mobile No." />
						<s:textfield id="emailId" name="emailId" label="EmailId." />

						<s:textfield id="maintainenceType" name="maintainenceType"
							label="Maintainence Type" />



						<s:select label="Role Cd" list="#{'-Select-':'-Select-'
						,'ADMIN':'ADMIN'
						,'ENG':'ENG',
						'FSQC':'FSQC',
						'CREW':'CREW',
						'STAFF':'STAFF'
						}"
						
						
						
							name="roleCd" headerKey="0" cssStyle="width:145px">
						</s:select>
						
						<s:select label="Status"
							list="#{'-Select-':'-Select-'
						,'Active':'Active'
						,'Inactive':'Inactive'
						}"
							name="status" headerKey="0" cssStyle="width:145px">
						</s:select>


						<s:set name="module1" value="module1" />
						<s:set name="module2" value="module2" />
						<s:set name="module3" value="module3" />
						<s:set name="module4" value="module4" />



						<s:if test="%{#module1=='MST'}">
							<s:checkbox name="module1" checked="checked" fieldValue="MST"
								value="MST" label="Master" />

						</s:if>

						<s:else>
							<s:checkbox name="module1" value="MST" fieldValue="MST"
								label="Master" />

						</s:else>


						<s:if test="%{#module2=='CPI'}">
							<s:checkbox name="module2" checked="checked" fieldValue="CPI"
								value="CPI" label="CPI" />

						</s:if>

						<s:else>
							<s:checkbox name="module2" value="CPI" fieldValue="CPI"
								label="CPI" />

						</s:else>



						<s:if test="%{#module3=='WAS'}">
							<s:checkbox name="module3" checked="checked" fieldValue="WAS"
								value="WAS" label="WAS" />

						</s:if>

						<s:else>
							<s:checkbox name="module3" value="WAS" fieldValue="WAS"
								label="WAS" />

						</s:else>

						<s:if test="%{#module4=='REPORT'}">
							<s:checkbox name="module4" checked="checked" fieldValue="REPORT"
								value="REPORT" label="REPORT" />

						</s:if>

						<s:else>
							<s:checkbox name="module4" value="Report" fieldValue="Report"
								label="Report" />

						</s:else>


				
							<sj:submit button="true" value="Update" indicator="indicator" />
					</s:push>
				</s:form>

	



			</div>
		</div>

	</sj:tabbedpanel>





</body>

</html>