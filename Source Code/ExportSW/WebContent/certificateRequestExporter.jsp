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
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<META http-equiv="Content-Style-Type" content="text/css">
<LINK href="theme/Master.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="theme/winter.css" type="text/css"/>

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

<jsp:include page="ErrorSection.inc.jsp"/>

<bean:define id="exporterAddress" name="exporter" property="exporterAddress"/>
<bean:define id="factoryAddress" name="exporter" property="factoryAddress"/>

<bean:define id="exporterAddressProvince" name="exporterAddress" property="countrySubEntityLink"/>
<bean:define id="factoryAddressProvince" name="factoryAddress" property="countrySubEntityLink"/>

										<BR>
										ใบรับรองที่ท่านต้องการขอคือ <b><font color="blue"><bean:write name="ExporterCertificateRequestVO" property="certTypeName"/></font></b><p>
										กรุณาตรวจสอบข้อมูลของท่าน และกดปุ่ม &quot;ยืนยัน&quot; เพื่อยืนยันการส่งคำร้อง<BR>
										ถ้าข้อมูลของท่านไม่ถูกต้อง กรุณาปรับปรุงข้อมูลของท่านให้ถูกต้อง แล้วทำรายการใหม่อีกครั้ง<h5>ข้อมูลผู้ส่งออก</h5>
<table width="100%" class="body">
	<tr>
		<td width="20%"><b>ชื่อผู้ส่งออก</b></td>
		<td><bean:write name="exporter" property="name"/></td>
	</tr>
	<tr>
		<td><b>หมายเลขประจำตัว</b></td>
		<td><bean:write name="exporter" property="exporterId"/></td>
	</tr>
	<tr>
		<td><b>ที่อยู่</b></td>
		<td><bean:write name="exporterAddress" property="street"/></td>
	</tr>
	<tr>
		<td><b>อำเภอ</b></td>
		<td><bean:write name="exporterAddress" property="city"/></td>
	</tr>
	<tr>
		<td><b>จังหวัด</b></td>
		<td><bean:write name="exporterAddressProvince" property="name"/></td>
	</tr>
	<tr>
		<td><b>รหัสไปรษณีย์</b></td>
		<td><bean:write name="exporterAddress" property="postalZone"/></td>
	</tr>
</table>
<p>
<h5>ข้อมูลโรงงาน</h5>
<table width="100%" class="body">
	<tr>
		<td width="20%"><b>ที่อยู่</b></td>
		<td><bean:write name="factoryAddress" property="street"/></td>
	</tr>
	<tr>
		<td><b>อำเภอ</b></td>
		<td><bean:write name="factoryAddress" property="city"/></td>
	</tr>
	<tr>
		<td><b>จังหวัด</b></td>
		<td><bean:write name="factoryAddressProvince" property="name"/></td>
	</tr>
	<tr>
		<td><b>รหัสไปรษณีย์</b></td>
		<td><bean:write name="factoryAddress" property="postalZone"/></td>
	</tr>
</table>
<p align="center">
<html:form action="PerformExporterCertRequest">
  <html:submit value="ยืนยัน"/>
  <html:hidden name="ExporterCertificateRequestVO" property="certTypeId"/>
  <html:hidden name="exporter" property="exporterId"/>
</html:form>
</P>
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