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

<bean:define id="exporter" name="exporterCertStatus" property="exporterLink"/>
<bean:define id="certType" name="exporterCertStatus" property="certificateType"/>
<bean:define id="status" name="exporterCertStatus" property="statusLink"/>

<bean:define id="exporterAddress" name="exporter" property="exporterAddress"/>
<bean:define id="factoryAddress" name="exporter" property="factoryAddress"/>

<bean:define id="exporterAddressProvince" name="exporterAddress" property="countrySubEntityLink"/>
<bean:define id="factoryAddressProvince" name="exporterAddress" property="countrySubEntityLink"/>

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
    <td><bean:write name="exporterCertStatus" property="issueDateString"/></td>
  </tr>
  <tr>
    <td>วันที่หมดอายุ</td>
    <td><bean:write name="exporterCertStatus" property="expireDateString"/></td>
  </tr>
  <tr>
    <td>ผู้ออกเอกสาร</td>
    <td><bean:write name="exporterCertStatus" property="issueBy"/></td>
  </tr>
  <tr>
    <td>Signature</td>
    <td><bean:write name="exporterCertStatus" property="signature"/></td>
  </tr>
</table>
<p>
<h5>ข้อมูลผู้ส่งออก</h5>
<TABLE width="100%" class="body">
	<TBODY>
		<TR>
			<TD width="20%">รหัสประจำตัวประชาชน หรือนิติบุคคล</TD>
			<TD><bean:write name="exporter" property="exporterId"></bean:write></TD>
		</TR>
		<TR>
			<TD>ชื่อ</TD>
			<TD><bean:write name="exporter" property="name"></bean:write></TD>
		</TR>
		<TR>
			<TD>วันที่เกิด</TD>
			<TD><bean:write name="exporter" property="dateOfBirth"></bean:write></TD>
		</TR>
		<TR>
			<TD>ที่อยู่</TD>
			<TD><bean:write name="exporterAddress" property="street"></bean:write></TD>
		</TR>
		<TR>
			<TD>เขต / อำเภอ</TD>
			<TD><bean:write name="exporterAddress" property="city"></bean:write></TD>
		</TR>
		<TR>
			<TD>จังหวัด</TD>
			<TD><bean:write name="exporterAddressProvince" property="name"/></TD>
		</TR>
		<TR>
			<TD>รหัสไปรษณีย์</TD>
			<TD><bean:write name="exporterAddress" property="postalZone"></bean:write></TD>
		</TR>
		<TR>
			<TD>โทรศัพท์</TD>
			<TD><bean:write name="exporterAddress" property="telephone"></bean:write></TD>
		</TR>
	</TBODY>
</TABLE>
<p>
<h5>ข้อมูลสถานประกอบการ</h5>
<TABLE width="100%" class="body">
	<TBODY>
		<TR>
			<TD width="20%">ชื่อ</TD>
			<TD><bean:write name="factoryAddress" property="name"></bean:write></TD>
		</TR>
		<TR>
			<TD width="20%">ที่อยู่</TD>
			<TD><bean:write name="factoryAddress" property="street"></bean:write></TD>
		</TR>
		<TR>
			<TD>เขต / อำเภอ</TD>
			<TD><bean:write name="factoryAddress" property="city"></bean:write></TD>
		</TR>
		<TR>
			<TD>จังหวัด</TD>
			<TD><bean:write name="factoryAddressProvince" property="name"/></TD>
		</TR>
		<TR>
			<TD>รหัสไปรษณีย์</TD>
			<TD><bean:write name="factoryAddress" property="postalZone"/></TD>
		</TR>
		<TR>
			<TD>โทรศัพท์</TD>
			<TD><bean:write name="factoryAddress" property="telephone"/></TD>
		</TR>
	</TBODY>
</TABLE>

<html:form action="/VerifyExporterCertificate" enctype="multipart/form-data">
<h5>Document Verification</h5>
<table width="100%" class="body">
  <tr>
    <td width="20%">Digital Certificate File</td>
    <td><html:file property="certificateFile"/> <html:submit value="Verify"/></td>
  </tr>
</table>
<input type="hidden" name="exporterCertRequestId" value='<bean:write name="exporterCertStatus" property="id"/>'/>
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