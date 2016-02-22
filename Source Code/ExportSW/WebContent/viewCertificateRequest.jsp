<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%-- tpl:insert page="/theme/B-01_green.htpl" --%><!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css">
<link rel="stylesheet" href="/ExportSW/theme/green.css" type="text/css">
<%-- tpl:put name="headarea" --%>
<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>

<META http-equiv="Content-Style-Type" content="text/css">
<LINK href="theme/Master.css" rel="stylesheet" type="text/css">
<TITLE></TITLE>
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
<h4>ตรวจสอบสถานะคำร้อง</h4>
<TABLE border="1" class="body">
	<TBODY>
		<TR>
			<TH>เลขที่คำร้อง</TH>
			<TH>วันที่ยื่นคำร้อง</TH>
			<TH>วันที่แก้ไขล่าสุด</TH>
		</TR>
		<logic:iterate id="certificateRequests" name="certificateRequests">
		<TR>
			<TD><html:link action="/ViewCertificateRequestDetail" paramId="crId" paramName="certificateRequests" paramProperty="id"><bean:write name="certificateRequests" property="id"/></html:link></TD>
			<TD><bean:write name="certificateRequests" property="createDateString"/></TD>
			<TD><bean:write name="certificateRequests" property="modifyDateString"/></TD>
		</TR>
		</logic:iterate>
	</TBODY>
</TABLE>
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