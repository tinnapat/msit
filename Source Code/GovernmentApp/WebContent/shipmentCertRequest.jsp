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
<link rel="stylesheet" href="/GovernmentApp/theme/Master.css" type="text/css">
<%-- tpl:put name="headarea" --%>
<title>exporterCertRequest.jsp</title>
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
<h3>รายการคำร้อง</h3>
<table width="100%" border="0" class="body">
<tr>
<TH bgcolor="#ffff80">หมายเลขคำร้อง</TH>
<TH bgcolor="#ffff80">หมายเลขคำร้อง ระบบ Single Window</TH>
<TH bgcolor="#ffff80">รหัสผู้ส่งออก</TH>
<TH bgcolor="#ffff80">ชื่อผู้ส่งออก</TH>
<TH bgcolor="#ffff80">เอกสารที่ขอ</TH>
<TH bgcolor="#ffff80">สถานะ</TH>
<TH bgcolor="#ffff80">วันที่ยื่นคำร้อง</TH>
</tr>
<logic:iterate id="certRequest" name="shipmentCertRequests">
  <tr>
    <td>
      <html:link action="/ShipmentCertRequestDetail" paramId="requestId" paramName="certRequest" paramProperty="id">
        <bean:write name="certRequest" property="id"/>
      </html:link>
    </td>
    <td><bean:write name="certRequest" property="certificateRequestId"/></td>
    <td><bean:write name="certRequest" property="exporterId"/></td>
    <td><bean:write name="certRequest" property="exporterName"/></td>
    <td><bean:write name="certRequest" property="certificateTypeName"/></td>
    <td><bean:write name="certRequest" property="statusCode"/></td>
    <td><bean:write name="certRequest" property="requestDate"/></td>
  </tr>
</logic:iterate>
</table>

<p>

<table border="0" class="body">
<tr>
<TH bgcolor="#ffff80">รหัสสถานะ</TH>
<TH bgcolor="#ffff80">คำอธิบาย</TH>
</tr>
<logic:iterate id="status" name="requestStatuses">
  <tr>
    <td><bean:write name="status" property="code"/></td>
    <td><bean:write name="status" property="description"/></td>
  </tr>
</logic:iterate>
</table>
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