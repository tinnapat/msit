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
<title>certificateRequestDetail.jsp</title>
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
<% System.out.println(request.getAttribute("certificateRequest")); %>
<h4>รายละเอียดคำร้อง<h4>
<table class="body">
	<tr>
		<td><b>หมายเลขคำร้อง</b></td>
		<td><bean:write name="certificateRequest" property="id" format="00000000"/></td>
	</tr>
	<tr>
		<td><b>วันที่ยื่นคำร้อง</b></td>
		<td><bean:write name="certificateRequest" property="createDate"/></td>
	</tr>
</table>
<h5>ข้อมูลคำร้อง<h5>

<bean:define id="consignee" name="certificateRequest" property="consignee"/>
<bean:define id="halal" name="certificateRequest" property="halal"/>
<bean:define id="healthCertificate" name="certificateRequest" property="healthCertificate"/>
<bean:define id="invoice" name="certificateRequest" property="invoice"/>
<bean:define id="transport" name="certificateRequest" property="transport"/>

<bean:define id="destinationCountry" name="consignee" property="destinationCountryLink"/>

<TABLE class="body" border="1" cellpadding="5" width="100%">
	<TR>
		<TH>ข้อมูลใบคำขอกลาง</TH>
	</TR>
	<TR>
		<TD>
<b>ผู้ซื้อ / ผู้รับปลายทาง</b>
<p>
ชื่อผู้รับ / Consignee Name
<br>
<input type="text" size="50" value='<bean:write name="consignee" property="consigneeName"/>' disabled>
<br>
ที่อยู่ผู้รับ / Consignee Address
<br>
<textarea rows="6" cols="50" disabled><bean:write name="consignee" property="consigneeAddress"/></textarea>
<br>
ประเทศปลายทาง / Country of Destination
<input type="text" value='<bean:write name="destinationCountry" property="countryName"/>' disabled>
		</TD>
	</TR>

	<tr>
		<td>
      <b>ผู้รับมอบอำนาจ</b>
      <p>
      <table class="body">
        <tr>
          <td>ชื่อ</td>
          <td><input type="text" disabled value='<bean:write name="certificateRequest" property="authorizedPersonName"/>'></td>
        </tr>
        <tr>
          <td>เลขที่บัตรผู้รับมอบอำนาจ</td>
          <td><input type="text" disabled value='<bean:write name="certificateRequest" property="authorizedPersonId"/>'></td>
        </tr>
      </table>
		</td>
  </tr>
  
  <tr>
		<td>
<b>การขนส่ง<b> 
<p>
<table class="body">
	<tr>
		<td>วันที่ขนส่ง (Date of Shipment)</td>
		<td><input type="text" disabled value='<bean:write name="transport" property="shipmentDateString"/>'></td>
	</tr>
	<tr>
		<td>วิธีขนส่ง (Mode of Transport)</td>
		<td>
      <bean:define id="transportMode" name="transport" property="transportModeLink"/>
      <input type="text" disabled value='<bean:write name="transportMode" property="thaiName"/>'>
		</td>
	</tr>
	<tr>
		<td>ชื่อเรือ / เที่ยวบิน (Vessel / Flight No.)</td>
		<td><input type="text" disabled value='<bean:write name="transport" property="journeyId"/>'></td>
	</tr>
	<tr>
		<td>ท่าที่ส่งออก (Port of Loading)</td>
		<td>
      <bean:define id="loadingLocation" name="transport" property="loadingLocationLink"/>
      <input type="text" disabled value='<bean:write name="loadingLocation" property="locationName"/>'>
		</td>
	</tr>
	<tr>
		<td>ท่าที่นำเข้า (Port of Entry)</td>
		<td>
      <bean:define id="dischargeLocation" name="transport" property="dischargeLocationLink"/>
      <input type="text" disabled value='<bean:write name="dischargeLocation" property="locationName"/>'>
		</td>
	</tr>
  <tr>
    <td>&nbsp;</td>
  <tr>
  <tr>
    <td colspan="2">
      ชื่อผู้ขนส่ง / Dispatcher Name
                <br>
                <input type="text" disabled size="50" value='<bean:write name="transport" property="dispatcherName"/>'>
                <br>
   ที่อยู่ผู้ขนส่ง / Dispatcher Address
                <br>
                <textarea rows="6" cols="50" disabled><bean:write name="transport" property="dispatcherAddress"/></textarea>
    </td>
  <tr>
</table>

		</td>
	</tr>
	<tr>
		<td>
      <b>ข้อมูลใบกำกับสินค้า</b>
      <p>
      <table class="body">
        <tr>
          <td>ใบกำกับสินค้าเลขที่</td>
          <td><input type="text" disabled value='<bean:write name="invoice" property="invoiceNo"/>'></td>
        </tr>
        <tr>
          <td>ลงวันที่</td>
          <td><input type="text" disabled value='<bean:write name="invoice" property="invoiceDateString"/>'></td>
        </tr>
      </table>
		</td>
	</tr>
	<tr>
		<td>
      <b>รายละเอียดสินค้า</b>
      <p>
      <table class="body">
        <tr>
          <td colspan="2">สินค้า
            <br>
            <textarea rows="6" cols="50" disabled><bean:write name="invoice" property="itemDescription"/></textarea>
          </td>
        </tr>
        <tr>
          <td>พิกัดศุลกากร</td>
          <td><input type="text" disabled value='<bean:write name="invoice" property="itemHarmonizeCode"/>'></td>
        </tr>
        <tr>
          <td>ปริมาณ / น้ำหนักสุทธิ</td>
          <td>
            <input type="text" size="10" disabled value='<bean:write name="invoice" property="itemWeight"/>'>
              หน่วย
            <input type="text" size="10" disabled value='<bean:write name="invoice" property="itemWeightUom"/>'>
          </td>
        </tr>
        <tr>
          <td>มูลค่า</td>
          <td>
            <input type="text" disabled size="10" value='<bean:write name="invoice" property="itemPrice"/>'> สกุลเงิน 
            <bean:define id="itemPriceCurrency" name="invoice" property="itemPriceCurrencyLink"/>
            <input type="text" disabled size="10" value='<bean:write name="itemPriceCurrency" property="currencyName"/>'>
          </td>
        </tr>
        <tr>
          <td>จำนวนหีบห่อ (Quantity)</td>
          <td><input type="text" disabled value='<bean:write name="invoice" property="itemQuantity"/>'></td>
        </tr>
        <tr>
          <td>ประเภทหีบห่อ (Kind of packages)</td>
          <td><input type="text" disabled value='<bean:write name="invoice" property="packageType"/>'></td>
        </tr>
      </table>
		</td>
	</tr>
  <tr>
    <td>
      <TABLE class="body" width="100%">
        <TR>
          <TH>สำหรับการขอ "ใบรับรองฮาลาล" เท่านั้น</TH>
        </TR>
      </table>
    </td>
  </tr>
  <tr>
    <td>
      <table class="body" width="100%">
        <TR>
          <TD>
            Product Description<br>
            <textarea rows="6" cols="50" disabled><bean:write name="halal" property="productDescription"/></textarea>
            <br>
            Manufactured By<br>
            <textarea rows="6" cols="50" disabled><bean:write name="halal" property="manufacturer"/></textarea>
            <table class="body">
              <tr>
                <td>Halal No.</td>
                <td><input type="text" disabled value='<bean:write name="halal" property="halalNo"/>'></td>
              </tr>
              <tr>
                <td>Halal Company Code</td>
                <td><input type="text" disabled value='<bean:write name="halal" property="halalCompanyCode"/>'></td>
              </tr>
            </table>
          </td>
        </tr>
      </table>
    </td>
  </tr>

  <tr>
    <td>
      <TABLE class="body" width="100%">
        <TR>
          <TH>สำหรับการขอ "ใบรับรองสุขอนามัย (Health Certificate)" เท่านั้น</TH>
        </TR>
      </table>
    </td>
  </tr>
  <tr>
    <td>
      <table class="body">
        <tr>
          <td>Species (Scientific name)</td>
          <td><input type="text" disabled value='<bean:write name="healthCertificate" property="species"/>'></td>
        </tr>
        <tr>
          <td>Presentation of product and type of treatment</td>
          <td><input type="text" disabled value='<bean:write name="healthCertificate" property="productDescription"/>'></td>
        </tr>
        <tr>
          <td>Code number (where available)</td>
          <td><input type="text" disabled value='<bean:write name="healthCertificate" property="codeNumber"/>'></td>
        </tr>
        <tr>
          <td>Requisit storage temperature</td>
          <td>
            <input type="text" disabled size="10" value='<bean:write name="healthCertificate" property="storageTemperature"/>'> Degree
            <input type="text" disabled size="10" value='<bean:write name="healthCertificate" property="storageTemperatureUom"/>'>
          </td>
        </tr>
        <tr>
          <td>Requisit transport temperature</td>
          <td>
            <input type="text" disabled size="10" value='<bean:write name="healthCertificate" property="transportTemperature"/>'> Degree
            <input type="text" disabled size="10" value='<bean:write name="healthCertificate" property="transportTemperatureUom"/>'>
          </td>
        </tr>
      </table>
    </td>
  </tr>

  <tr>
    <td>
      <TABLE class="body" width="100%">
        <TR>
          <TH>สำหรับการขอ "ใบรับรองแหล่งผลิต และแหล่งกำเนิดสินค้าปลอดโรค" เท่านั้น</TH>
        </TR>
      </table>
    </td>
  </tr>
  <tr>
    <td>
      <b>Origin of Products</b>
      <table class="body">
        <tr>
          <td>District (Amphoe or Khet)</td>
          <td><input type="text" disabled value='<bean:write name="certificateRequest" property="originDistrict"/>'></td>
        </tr>
        <tr>
          <td>Province</td>
          <td>
            <bean:define id="originProvince" name="certificateRequest" property="originProvinceLink"/>
            <input type="text" disabled value='<bean:write name="originProvince" property="name"/>'>
          </td>
        </tr>
      </table>
    </td>
  </tr>

</table>

<h5>สถานะของเอกสาร<h5>
<table class="body" border="1">
	<tr>
		<TH>ลำดับที่</TH>
		<TH>ประเภทเอกสาร</TH>
		<TH>หน่วยงานผู้รับผิดชอบ</TH>
		<TH>สถานะ</TH>
		<TH>แก้ไขล่าสุด</TH>
	</tr>
  <% int count = 1; %>
  <logic:iterate id="detail" name="certificateRequest" property="details">
  <bean:define id="certificateType" name="detail" property="certificateTypeLink"/>
  <bean:define id="authority" name="certificateType"  property="authority"/>
  <bean:define id="status" name="detail"  property="statusLink"/>
	<tr>
		<td><%= count++ %></td>
		<td>
      <bean:define id="certTypeId" name="certificateType" property="id"/>
      <bean:define id="certReqId" name="certificateRequest" property="id"/>
      <%
        java.util.Map params = new java.util.HashMap();
        params.put("certTypeId", certTypeId);
        params.put("certReqId", certReqId);
        pageContext.setAttribute("params", params);
      %>
      <html:link action="/ViewShipmentCertificate" name="params">
        <bean:write name="certificateType" property="name"/>
      </html:link>
    </td>
		<td><bean:write name="authority" property="name"/></td>
		<td><bean:write name="status" property="description"/></td>
		<td><bean:write name="detail" property="modifyDate"/></td>
	</tr>
  </logic:iterate>
</table>


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