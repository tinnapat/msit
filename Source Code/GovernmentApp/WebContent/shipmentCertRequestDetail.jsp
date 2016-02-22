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
                  <td align="center">ระบบคอมพิวเตอร์ กรมประมง</td>
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
        <tr>
          <td width="20%">หมายเลขคำ้ร้อง ระบบ Single Window</td>
          <td><bean:write name="certRequest" property="certificateRequestId"/></td>
        </tr>
        <tr>
          <td width="20%">ประเภทเอกสาร</td>
          <td><bean:write name="certRequest" property="certificateTypeName"/></td>
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
<input type="text" size="50" value='<bean:write name="detail" property="consigneeName"/>' disabled>
<br>
ที่อยู่ผู้รับ / Consignee Address
<br>
<textarea rows="6" cols="50" disabled><bean:write name="detail" property="consigneeAddress"/></textarea>
<br>
ประเทศปลายทาง / Country of Destination
<input type="text" value='<bean:write name="detail" property="destinationCountry"/>' disabled>
		</TD>
	</TR>

	<tr>
		<td>
      <b>ผู้รับมอบอำนาจ</b>
      <p>
      <table class="body">
        <tr>
          <td>ชื่อ</td>
          <td><input type="text" disabled value='<bean:write name="detail" property="proxyName"/>'></td>
        </tr>
        <tr>
          <td>เลขที่บัตรผู้รับมอบอำนาจ</td>
          <td><input type="text" disabled value='<bean:write name="detail" property="proxyId"/>'></td>
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
		<td><input type="text" disabled value='<bean:write name="detail" property="shipmentDate"/>'></td>
	</tr>
	<tr>
		<td>วิธีขนส่ง (Mode of Transport)</td>
		<td>
      <input type="text" disabled value='<bean:write name="detail" property="transportMode"/>'>
		</td>
	</tr>
	<tr>
		<td>ชื่อเรือ / เที่ยวบิน (Vessel / Flight No.)</td>
		<td><input type="text" disabled value='<bean:write name="detail" property="transportMeansJourneyId"/>'></td>
	</tr>
	<tr>
		<td>ท่าที่ส่งออก (Port of Loading)</td>
		<td>
      <input type="text" disabled value='<bean:write name="detail" property="loadingLocation"/>'>
		</td>
	</tr>
	<tr>
		<td>ท่าที่นำเข้า (Port of Entry)</td>
		<td>
      <input type="text" disabled value='<bean:write name="detail" property="dischargeLocation"/>'>
		</td>
	</tr>
  <tr>
    <td>&nbsp;</td>
  <tr>
  <tr>
    <td colspan="2">
      ชื่อผู้ขนส่ง / Dispatcher Name
                <br>
                <input type="text" disabled size="50" value='<bean:write name="detail" property="dispatcherName"/>'>
                <br>
   ที่อยู่ผู้ขนส่ง / Dispatcher Address
                <br>
                <textarea rows="6" cols="50" disabled><bean:write name="detail" property="dispatcherAddress"/></textarea>
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
          <td><input type="text" disabled value='<bean:write name="detail" property="invoiceNo"/>'></td>
        </tr>
        <tr>
          <td>ลงวันที่</td>
          <td><input type="text" disabled value='<bean:write name="detail" property="invoiceDate"/>'></td>
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
            <textarea rows="6" cols="50" disabled><bean:write name="detail" property="productDescription"/></textarea>
          </td>
        </tr>
        <tr>
          <td>พิกัดศุลกากร</td>
          <td><input type="text" disabled value='<bean:write name="detail" property="commodityCode"/>'></td>
        </tr>
        <tr>
          <td>ปริมาณ / น้ำหนักสุทธิ</td>
          <td>
            <input type="text" size="10" disabled value='<bean:write name="detail" property="productAmount"/>'>
              หน่วย
            <input type="text" size="10" disabled value='<bean:write name="detail" property="productAmountUom"/>'>
          </td>
        </tr>
        <tr>
          <td>มูลค่า</td>
          <td>
            <input type="text" disabled size="10" value='<bean:write name="detail" property="productValue"/>'> สกุลเงิน 
            <input type="text" disabled size="10" value='<bean:write name="detail" property="productCurrency"/>'>
          </td>
        </tr>
        <tr>
          <td>จำนวนหีบห่อ (Quantity)</td>
          <td><input type="text" disabled value='<bean:write name="detail" property="packageQuantity"/>'></td>
        </tr>
        <tr>
          <td>ประเภทหีบห่อ (Kind of packages)</td>
          <td><input type="text" disabled value='<bean:write name="detail" property="packageType"/>'></td>
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
            <textarea rows="6" cols="50" disabled><bean:write name="detail" property="halalProductDescription"/></textarea>
            <br>
            Manufactured By<br>
            <textarea rows="6" cols="50" disabled><bean:write name="detail" property="manufacturer"/></textarea>
            <table class="body">
              <tr>
                <td>Halal No.</td>
                <td><input type="text" disabled value='<bean:write name="detail" property="halalNo"/>'></td>
              </tr>
              <tr>
                <td>Halal Company Code</td>
                <td><input type="text" disabled value='<bean:write name="detail" property="halalCompanyCode"/>'></td>
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
          <td><input type="text" disabled value='<bean:write name="detail" property="species"/>'></td>
        </tr>
        <tr>
          <td>Presentation of product and type of treatment</td>
          <td><input type="text" disabled value='<bean:write name="detail" property="productPresentation"/>'></td>
        </tr>
        <tr>
          <td>Code number (where available)</td>
          <td><input type="text" disabled value='<bean:write name="detail" property="codeNumber"/>'></td>
        </tr>
        <tr>
          <td>Requisit storage temperature</td>
          <td>
            <input type="text" disabled size="10" value='<bean:write name="detail" property="storageTemperature"/>'> Degree
            <input type="text" disabled size="10" value='<bean:write name="detail" property="storageTemperatureUom"/>'>
          </td>
        </tr>
        <tr>
          <td>Requisit transport temperature</td>
          <td>
            <input type="text" disabled size="10" value='<bean:write name="detail" property="transportTemperature"/>'> Degree
            <input type="text" disabled size="10" value='<bean:write name="detail" property="transportTemperatureUom"/>'>
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
          <td><input type="text" disabled value='<bean:write name="detail" property="productOriginDistrict"/>'></td>
        </tr>
        <tr>
          <td>Province</td>
          <td>
            <bean:define id="originProvince" name="detail" property="productOriginProvinceLink"/>
            <input type="text" disabled value='<bean:write name="originProvince" property="name"/>'>
          </td>
        </tr>
      </table>
    </td>
  </tr>

</table>

      <p>
      <h4>สถานะคำร้อง</h4>
      <html:form action="/UpdateShipmentCertificate" enctype="multipart/form-data">
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
      <input type="hidden" name="certificateRequestId" value='<bean:write name="certRequest" property="certificateRequestId"/>'>
      <input type="hidden" name="certificateTypeId" value='<bean:write name="certRequest" property="certificateTypeId"/>'>
      <input type="hidden" name="id" value='<bean:write name="certRequest" property="id"/>'>
      
      </html:form>
    </td>
  </tr>
</table>                

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