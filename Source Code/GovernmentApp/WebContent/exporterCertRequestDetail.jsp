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
<title>exporterCertRequestDetail.jsp</title>

<link rel="stylesheet" href="/GovernmentApp/theme/Master.css" type="text/css">
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
	inputField        : "issueDate",
	button            : "issueDateTrigger",
	ifFormat          : "%Y-%m-%d",
	daFormat          : "%Y/%m/%d"
  });

  Zapatec.Calendar.setup({
	showOthers        : true,
	electric          : false,
	inputField        : "expireDate",
	button            : "expireDateTrigger",
	ifFormat          : "%Y-%m-%d",
	daFormat          : "%Y/%m/%d"
  });

//]]></script>

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
<table width="100%" class="body">
  <tr>
    <td>
      <table width="100%" class="body">
        <tr>
          <td width="20%">หมายเลขคำ้ร้อง</td>
          <td><bean:write name="certRequest" property="id"/></td>
        </tr>
      </table>
      <p>
      <h4>ข้อมูลผู้ส่งออก</h4><p>
      <table width="100%" class="body">
        <tr>
          <td width="20%">หมายเลขผู้ส่งออก</td>
          <td><bean:write name="certRequest" property="exporterId"/></td>
        </tr>
        <tr>
          <td>ชื่อผู้ส่งออก</td>
          <td><bean:write name="certRequest" property="exporterName"/></td>
        </tr>
        <tr>
          <td>ที่อยู่</td>
          <td><bean:write name="detail" property="exporterAddressStreet"/></td>
        </tr>
        <tr>
          <td>อำเภอ</td>
          <td><bean:write name="detail" property="exporterAddressCity"/></td>
        </tr>
        <tr>
          <td>จังหวัด</td>
          <td>
            <bean:define id="exporterAddressProvince" name="detail" property="exporterAddressProvinceLink"/>
            <bean:write name="exporterAddressProvince" property="name"/>
          </td>
        </tr>
        <tr>
          <td>รหัสไปรษณีย์</td>
          <td><bean:write name="detail" property="exporterAddressPostalZone"/></td>
        </tr>
      </table>
      <p>
      <h4>ข้อมูลสถานประกอบการ</h4><p>
      <table width="100%" class="body">
        <tr>
          <td width="20%">ชื่อ</td>
          <td><bean:write name="detail" property="factoryAddressName"/></td>
        </tr>
        <tr>
          <td>ที่อยู่</td>
          <td><bean:write name="detail" property="factoryAddressStreet"/></td>
        </tr>
        <tr>
          <td>อำเภอ</td>
          <td><bean:write name="detail" property="factoryAddressCity"/></td>
        </tr>
        <tr>
          <td>จังหวัด</td>
          <td>
            <bean:define id="factoryAddressProvince" name="detail" property="factoryAddressProvinceLink"/>
            <bean:write name="factoryAddressProvince" property="name"/>
          </td>
        </tr>
        <tr>
          <td>รหัสไปรษณีย์</td>
          <td><bean:write name="detail" property="factoryAddressPostalZone"/></td>
        </tr>
      </table>
      <p>
      <h4>สถานะคำร้อง</h4>
      <html:form action="/UpdateExporterCertificate" enctype="multipart/form-data">
      <table width="100%" class="body">
        <tr>
          <td width="20%">การอนุมัติเอกสาร</td>
          <td>
            <html:select property="statusCode">
              <html:options labelProperty="description" property="code" collection="statuses"/>
            </html:select>
          </td>
        </tr>
        <tr>
          <td>วันที่ออกเอกสาร</td>
          <td><html:text property="issueDate" readonly="true"/> <img id="issueDateTrigger" src="images/calendar.gif"></td>
        </tr>
        <tr>
          <td>วันหมดอายุ</td>
          <td><html:text property="expireDate" readonly="true"/> <img id="expireDateTrigger" src="images/calendar.gif"></td>
        </tr>
        <tr>
          <td>ผู้อนุมัติ</td>
          <td><html:text property="issueBy"/></td>
        </tr>
        <tr>
          <td>Private Key</td>
          <td><html:file property="privateKeyFile"/></td>
        </tr>
      </table>
      <p>
      <div align="center">
        <html:submit value="บันทึก"/>
      </div>
      <input type="hidden" name="exporterId" value='<bean:write name="certRequest" property="exporterId"/>'>
      <input type="hidden" name="certificateTypeCode" value='<bean:write name="certRequest" property="certificateTypeId"/>'>
      <input type="hidden" name="certificateRequestId" value='<bean:write name="certRequest" property="id"/>'>
      
      </html:form>
    </td>
  </tr>
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