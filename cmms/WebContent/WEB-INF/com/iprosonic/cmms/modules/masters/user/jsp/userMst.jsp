<%@ page contentType="text/html; charset=ISO-8859-1" language="java"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="sjg" uri="/struts-jquery-grid-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Page</title>
<s:head />
</head>
<body>

	<div class="container">
		<div class="myHeader">Create User</div>
		<s:form id="formValidate" theme="qxhtml"
			action="SaveEmployeeAction.action">
			<s:push value="employeeBean">
				<s:hidden name="id" />
				<s:hidden name="status" value="Active" />
				<s:textfield id="employeeName" name="employeeName"
					label="Employee Name" cssStyle="text-align:left" />
				<s:textfield id="employeeShortName" name="employeeShortName"
					label="Short Name" />
				<s:textfield id="employeeCd" name="employeeCd" label="Employee Code" />
				<s:textfield id="password" name="password" label="Password" />
				<s:textfield id="departmentName" name="departmentName"
					label="Department Name" />
				<s:textfield id="designation" name="designation" label="Designation" />

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



				<s:select label="Role Cd"
					list="#{'-Select-':'-Select-'
						,'ADMIN':'ADMIN'
						,'ENG':'ENG',
						'FSQC':'FSQC',
						'CREW':'CREW',
						'STAFF':'STAFF'
						}"
					name="roleCd" headerKey="0" cssStyle="width:145px">
				</s:select>
				<s:checkbox name="module1" fieldValue="MST" label="Master"
					value="MST" />
				<s:checkbox name="module2" fieldValue="CPI" label="CPI" value="CPI" />
				<s:checkbox name="module3" fieldValue="WAS" label="WAS" value="WAS" />
				<s:checkbox name="module4" fieldValue="REPORT" label="REPORT"
					value="REPORT" />
				
			</s:push>
			
			<sj:submit button="true" value="Save"  cssClass="myButton"  />
		</s:form>
		
	</div>
</body>
</html>