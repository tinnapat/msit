<%@ page contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8" errorPage="/error.jsp" %>

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<%-- tpl:insert page="/theme/B-01_green.htpl" --%><!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css">
<link rel="stylesheet" href="/ExportSW/theme/green.css" type="text/css">
<%-- tpl:put name="headarea" --%>
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
<BR>
<div class="body">
<div align="center" class="body">
<p>
</div>
<logic:notPresent name="exporter">
ขณะนี้ คุณยังไม่ได้ Login เข้าสู่ระบบ กรุณา Login เข้าสู่ระบบ หรือลงทะเบียนก่อนใช้งาน
</logic:notPresent>
<logic:present name="exporter">
ยินดีต้อนรับ <font color="blue"><b><bean:write name="exporter" property="name"/></b></font>
สู่ระบบต้นแบบธุรกรรมอิเล็กทรอนิกส์สำหรับการส่งออกกุ้ง
<p>
<B>ใบอนุญาติที่จำเป็น </B><table class="body" border="1">
	<tr>
		<TH width="35%">รายการ</TH>
		<TH width="15%">สถานะ</TH>
		<TH width="20%">วันที่ออกเอกสาร</TH>
		<TH width="20%">วันหมดอายุ</TH>
		<TH width="10%"></TH>
	</tr>
  <logic:iterate id="certStatus" name="exporterCertStatuses">
    <bean:define id="status" name="certStatus" property="statusLink"/>
    <bean:define id="certType" name="certStatus" property="certificateType"/>
    <tr>
      <td>
        <html:link action="/ViewExporterCertificate" paramId="certTypeId" paramName="certType" paramProperty="id">
          <bean:write name="certType" property="name"/>
        </html:link>
      </td>
      <td align="center"><bean:write name="status" property="description"/></td>
      <td align="center"><bean:write name="certStatus" property="issueDateString"/></td>
      <td align="center"><bean:write name="certStatus" property="expireDateString"/></td>
      <td align="center">
        <logic:notEqual name="status" property="code" value="A">
    			<html:link action="/PrepareExporterCertRequest" paramId="certTypeId" paramName="certType" paramProperty="id">
		    	ยื่นคำร้อง</html:link>
		    </logic:notEqual>
      </td>
    </tr>
  </logic:iterate>
</table>
<p>
คุณสามารถยื่นคำร้องได้
<p>
<!--
<B>สถานะคำร้อง </B><table class="body">
	<tr>
		<TH width="121">รอการอนุมัติ</TH>
    <TD width="39" align="center">0</TD>
    <td width="216">รายการ</td>
	</tr>
	<tr>
		<TH width="121">อนุมัติแล้ว</TH>
    <TD width="39" align="center">0</TD>
    <td width="216">รายการ</td>
	</tr>
	<tr>
		<TH width="121">ไม่อนุมัติ</TH>
    <TD width="39" align="center">0</TD>
    <td width="216">รายการ</td>
	</tr>
	<tr>
		<TH width="121">ข้อมูลไม่ครบถ้วน</TH>
    <TD width="39" align="center">0</TD>
    <td width="216">รายการ</td>
	</tr>
-->
</table>
</logic:present>

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