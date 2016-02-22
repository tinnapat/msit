<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%-- tpl:insert page="/theme/B-01_green.htpl" --%><!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css">
<link rel="stylesheet" href="/ExportSW/theme/green.css" type="text/css">
<%-- tpl:put name="headarea" --%>
<LINK href="theme/Master.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="theme/winter.css" type="text/css"/>

<!-- Loading Calendar JavaScript files -->
<script type="text/javascript" src="js/utils.js"></script>
<script type="text/javascript" src="js/calendar.js"></script>
<script type="text/javascript" src="js/calendar-setup.js"></script>

<!-- Loading language definition file -->
<script type="text/javascript" src="js/calendar-en.js"></script>

<script type="text/javascript" defer>//<![CDATA[
  Zapatec.Calendar.setup({
	showOthers        : true,
	electric          : false,
	inputField        : "dateOfBirth",
	button            : "dateOfBirthTrigger",
	ifFormat          : "%d-%m-%Y",
	daFormat          : "%Y/%m/%d"
  });

//]]></script>

<%-- /tpl:put --%></head>
<body>
<table width="760" cellspacing="0" cellpadding="0" border="0">
   <tbody>
      <tr>
         <td valign="top">
         <table class="header" cellspacing="0" cellpadding="0" border="0" width="100%">
            <tbody>
               <tr>
                  <td width="150"><img border="0" width="150" height="55" alt="Company's LOGO" src="/ExportSW/theme/logo_green.gif"></td>
                  <td valign="middle" align="center"><font color="white"><b>ระบบต้นแบบธุรกรรมอิเล็กทรอนิกส์สำหรับการส่งออกกุ้ง</b></font></td>
               </tr>
            </tbody>
         </table>
         </td>
      </tr>
      <tr>
         <td valign="top">
         <table border="0" width="100%" cellspacing="0" cellpadding="0">
            <tbody>
               <tr>
                  <td valign="top" width="150">
                  	<jsp:include page="theme/menu.jsp"/>
                  </td>
                  <td valign="top" class="content-area" height="300">
                  <table cellpadding="5" class="body" width="100%">
                  	<tr>
                  		<td><%-- tpl:put name="bodyarea" --%>
<div class="body">
<h4><bean:write name="pageConfig" property="title"/></h4>
	<html:form action="/PerformAddExporter" method="post">
	<input type="hidden" name="action" value='<bean:write name="pageConfig" property="action"/>'>
	<h5>ข้อมูลผู้ส่งออก</h5>
    <jsp:include page="ErrorSection.inc.jsp"/>
		<TABLE class="body">
			<TBODY>
				<TR>
					<TD>รหัสประจำตัวประชาชน หรือนิติบุคคล</TD>
					<TD>
					<logic:equal name="pageConfig" property="action" value="AddExporter">
						<html:text property="exporterId" maxlength="13"></html:text>
					</logic:equal>
					<logic:notEqual name="pageConfig" property="action" value="AddExporter">
						<bean:write name="ExporterForm" property="exporterId"/>
						<html:hidden name="ExporterForm" property="exporterId"/>
					</logic:notEqual>
					</TD>
				</TR>
				<TR>
					<TD>รหัสผ่าน</TD>
					<TD><html:password property="password"></html:password></TD>
				</TR>
				<TR>
					<TD>ยืนยันรหัสผ่าน</TD>
					<TD><html:password property="password2"></html:password></TD>
				</TR>
				<TR>
					<TD>ชื่อ</TD>
					<TD><html:text size="50" property="name"></html:text></TD>
				</TR>
				<TR>
					<TD>วันที่เกิด</TD>
					<TD><html:text property="dateOfBirth" readonly="true"/> <img id="dateOfBirthTrigger" src="images/calendar.gif"></TD>
				</TR>
				<TR>
					<TD>ที่อยู่</TD>
					<TD><html:text size="50" property="exporterAddressStreet"></html:text></TD>
				</TR>
				<TR>
					<TD>เขต / อำเภอ</TD>
					<TD><html:text size="50" property="exporterAddressCity"></html:text></TD>
				</TR>
				<TR>
					<TD>จังหวัด</TD>
					<TD><html:select property="exporterAddressCountrySubEntity">
						<html:options labelProperty="name" property="code" collection="provinces"/>
					</html:select></TD>
				</TR>
				<TR>
					<TD>รหัสไปรษณีย์</TD>
					<TD><html:text maxlength="5" property="exporterAddressPostalZone"></html:text></TD>
				</TR>
				<TR>
					<TD>โทรศัพท์</TD>
					<TD><html:text property="exporterAddressTelephone"></html:text></TD>
				</TR>
			</TBODY>
		</TABLE>

		<h5>ข้อมูลสถานประกอบการ<h5>
		<TABLE class="body">
			<TBODY>
				<TR>
					<TD>ชื่อ</TD>
					<TD><html:text size="50" property="factoryAddressName"></html:text></TD>
				</TR>
				<TR>
					<TD>ที่อยู่</TD>
					<TD><html:text size="50" property="factoryAddressStreet"></html:text></TD>
				</TR>
				<TR>
					<TD>เขต / อำเภอ</TD>
					<TD><html:text size="50" property="factoryAddressCity"></html:text></TD>
				</TR>
				<TR>
					<TD>จังหวัด</TD>
					<TD>
						<html:select property="factoryAddressCountrySubEntity">
							<html:options labelProperty="name" property="code" collection="provinces"/>
						</html:select>
					</TD>
				</TR>
				<TR>
					<TD>รหัสไปรษณีย์</TD>
					<TD><html:text maxlength="5" property="factoryAddressPostalZone"></html:text></TD>
				</TR>
				<TR>
					<TD>โทรศัพท์</TD>
					<TD><html:text property="factoryAddressTelephone"></html:text></TD>
				</TR>
			</TBODY>
		</TABLE>

		<div align="center"><BR><html:submit value="ส่งข้อมูล"/> <html:reset value="ล้างข้อมูล"/></div>
	</html:form>
</div>
<%-- /tpl:put --%></td>
                  	</tr>
                  </table>
                  </td>
               </tr>
            </tbody>
         </table>
         </td>
      </tr>
      <tr>
         <td valign="top">
         	<jsp:include page="theme/footer.html"/>
         </td>
      </tr>
   </tbody>
</table>
</body>
</html><%-- /tpl:insert --%>