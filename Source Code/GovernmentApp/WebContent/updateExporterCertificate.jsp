<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>

<%-- tpl:insert page="/theme/B_gray.htpl" --%><!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css">
<link rel="stylesheet" href="/GovernmentApp/theme/gray.css" type="text/css">
<%-- tpl:put name="headarea" --%>
<title>updateExporterCertificate.jsp</title>
<%-- /tpl:put --%>
</head>
<body>
<table width="760" cellspacing="0" cellpadding="0" border="0">
   <tbody>
      <tr>
         <td valign="top">
         <table class="header" cellspacing="0" cellpadding="0" border="0" width="100%">
            <tbody>
               <tr>
                  <td width="150"><img border="0" width="150" height="55" alt="Company's LOGO" src="/GovernmentApp/theme/logo_gray.gif"></td>
                  <td align="center">ระบบคอมพิวเตอร์ หน่วยงานราชการ</td>
               </tr>
            </tbody>
         </table>
         </td>
      </tr>
      <tr>
         <td valign="top" height="20" class="nav_head"></td>
      </tr>
      <tr>
         <td valign="top">
         <table border="0" width="100%" cellspacing="0" cellpadding="0">
            <tbody>
               <tr>
                  <td valign="top" width="150" class="nav_side"></td>
                  <td class="content-area" height="300" valign="top"><%-- tpl:put name="bodyarea" --%>
<html:form action="/UpdateExporterCertificate" enctype="multipart/form-data">
<table>
	<tr>
		<td>Exporter Id</td>
		<td><html:text property="exporterId"/></td>
	</tr>
	<tr>
		<td>Certificate Type</td>
		<td><html:text property="certificateTypeCode"/></td>
	</tr>
	<tr>
		<td>Status</td>
		<td><html:text property="statusCode"/></td>
	</tr>
	<tr>
		<td>Issue Date</td>
		<td><html:text property="issueDate"/></td>
	</tr>
	<tr>
		<td>Expire Date</td>
		<td><html:text property="expireDate"/></td>
	</tr>
	<tr>
		<td>Issue By</td>
		<td><html:text property="issueBy"/></td>
	</tr>
	<tr>
		<td>Signature</td>
		<td><html:text property="signature"/></td>
	</tr>
	<tr>
		<td>Authorized Private Key</td>
		<td><html:file property="privateKeyFile"/></td>
	</tr>
</table>
<div align="center"><html:submit/></div>
</html:form>
                  <BR><%-- /tpl:put --%></td>
               </tr>
            </tbody>
         </table>
         </td>
      </tr>
      <tr>
         <td valign="top" height="20" class="footer"></td>
      </tr>
   </tbody>
</table>
</body>
</html><%-- /tpl:insert --%>