<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%-- tpl:insert page="/theme/B-01_green.htpl" --%><!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css">
<link rel="stylesheet" href="/ExportSW/theme/green.css" type="text/css">
<%-- tpl:put name="headarea" --%>
<title>exporterCertificate.jsp</title>
<LINK href="theme/Master.css" rel="stylesheet" type="text/css">
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

<bean:define id="certType" name="detail" property="certificateTypeLink"/>
<bean:define id="status" name="detail" property="statusLink"/>

<h5>ข้อมูลเอกสาร</h5>
<table width="100%" class="body">
  <tr>
    <td width="20%">ชื่อเอกสาร</td>
    <td><bean:write name="certType" property="name"/></td>
  </tr>
  <tr>
    <td>สถานะ</td>
    <td><bean:write name="status" property="description"/></td>
  </tr>
  <tr>
    <td>วันที่ออกเอกสาร</td>
    <td><bean:write name="detail" property="issueDateString"/></td>
  </tr>
  <tr>
    <td>วันที่หมดอายุ</td>
    <td><bean:write name="detail" property="expireDateString"/></td>
  </tr>
  <tr>
    <td>ผู้ออกเอกสาร</td>
    <td><bean:write name="detail" property="issueBy"/></td>
  </tr>
  <tr>
    <td>Signature</td>
    <td><bean:write name="detail" property="signature"/></td>
  </tr>
</table>

<html:form action="/VerifyShipmentCertificate" enctype="multipart/form-data">
<h5>Document Verification</h5>
<table width="100%" class="body">
  <tr>
    <td width="20%">Digital Certificate File</td>
    <td><html:file property="certificateFile"/> <html:submit value="Verify"/></td>
  </tr>
</table>
<input type="hidden" name="certificateRequestId" value='<bean:write name="detail" property="certificateRequestId"/>'/>
<input type="hidden" name="certificateTypeId" value='<bean:write name="detail" property="certificateTypeId"/>'/>
</html:form>

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