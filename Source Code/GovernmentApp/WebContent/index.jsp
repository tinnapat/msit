<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>

<%-- tpl:insert page="/theme/B_gray.htpl" --%><!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css">
<link rel="stylesheet" href="/GovernmentApp/theme/gray.css" type="text/css">
<%-- tpl:put name="headarea" --%>
<title>index.jsp</title>
<link rel="stylesheet" href="/GovernmentApp/theme/Master.css" type="text/css">
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
<p>&nbsp;</p>
<ul>
  <li><html:link action="/ExporterCertRequest">คำร้อง แบบต่ออายุเป็นช่วงเวลา</html:link></LI>
  <LI><html:link action="/ShipmentCertRequest">คำร้อง สำหรับการส่งออกแต่ละครั้ง</html:link></LI>
</ul>
                <%-- /tpl:put --%></td>
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