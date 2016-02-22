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
<%@page language="java" contentType="text/html; charset=utf-8"%>

<META http-equiv="Content-Style-Type" content="text/css">
<LINK href="theme/Master.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="theme/winter.css" type="text/css"/>

<!-- Loading Calendar JavaScript files -->
<script type="text/javascript" src="js/utils.js"></script>
<script type="text/javascript" src="js/calendar.js"></script>
<script type="text/javascript" src="js/calendar-setup.js"></script>

<!-- Loading language definition file -->
<script type="text/javascript" src="js/calendar-en.js"></script>


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


<bean:define id="exporterAddress" name="exporter" property="exporterAddress"/>
<bean:define id="factoryAddress" name="exporter" property="factoryAddress"/>

<bean:define id="exporterAddressProvince" name="exporterAddress" property="countrySubEntityLink"/>
<bean:define id="factoryAddressProvince" name="factoryAddress" property="countrySubEntityLink"/>

<h5>ข้อมูลผู้ส่งออก</h5>
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
		<td><b>จังหวัด<b></td>
		<td><bean:write name="factoryAddressProvince" property="name"/></td>
	</tr>
	<tr>
		<td><b>รหัสไปรษณีย์</b></td>
		<td><bean:write name="factoryAddress" property="postalZone"/></td>
	</tr>
</table>
<p>
<html:form action="/PerformCertificateRequest">
<jsp:include page="ErrorSection.inc.jsp"/>
<TABLE class="body">
	<TR>
		<TD><b>กรุณาเลือกแบบฟอร์มที่ท่านต้องการยื่นคำร้อง</b></TD>
	</TR>
	<TR>
		<TD>
			<logic:iterate id="certificateTypes" name="certificateTypes">
				<html:multibox property="certificateTypes">
					<bean:write name="certificateTypes" property="id" />
				</html:multibox>
				<bean:write name="certificateTypes" property="name" /><BR>
			</logic:iterate>
		</TD>
	</TR>
</TABLE>
<P>
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
<html:text size="50" property="consigneeName" value="SOMSAK KAMLOONWASARAJ"/>
<br>
ที่อยู่ผู้รับ / Consignee Address
<br>
<html:textarea rows="6" cols="50" property="consigneeAddress" value="82 KIPLING DR., MILL VALLEY, CA 94941
USA. TEL & FAX: 001-1-415-388 1177">
</html:textarea>
<br>
ประเทศปลายทาง / Country of Destination
<html:select property="destinationCountryCode">
	<html:options labelProperty="countryName" property="countryCode" collection="countries"/>
</html:select>
		</TD>
	</TR>

	<tr>
		<td>
      <b>ผู้รับมอบอำนาจ</b>
      <p>
      <table class="body">
        <tr>
          <td>ชื่อ</td>
          <td><html:text property="proxyName"/></td>
        </tr>
        <tr>
          <td>เลขที่บัตรผู้รับมอบอำนาจ</td>
          <td><html:text property="proxyId"/></td>
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
		<td><html:text property="shipmentDate" value="2006-07-25" readonly="true"/> <img id="shipmentDateTrigger" src="images/calendar.gif"></td>
	</tr>
	<tr>
		<td>วิธีขนส่ง (Mode of Transport)</td>
		<td>
			<html:select property="transportMode">
				<html:options labelProperty="thaiName" property="code" collection="transportModes"/>
			</html:select>
		</td>
	</tr>
	<tr>
		<td>ชื่อเรือ / เที่ยวบิน (Vessel / Flight No.)</td>
		<td><html:text property="transportMeansJourneyId" value="V.LB074 / V.017E"/></td>
	</tr>
	<tr>
		<td>ท่าที่ส่งออก (Port of Loading)</td>
		<td>
			<html:select property="loadingLocationCode">
				<html:options labelProperty="locationName" property="locationCode" collection="thaiLocations"/>
			</html:select>
		</td>
	</tr>
	<tr>
		<td>ท่าที่นำเข้า (Port of Entry)</td>
		<td>
			<html:select property="dischargeLocationCode">
				<html:options labelProperty="locationName" property="locationCode" collection="locations"/>
			</html:select>
		</td>
	</tr>
  <tr>
    <td>&nbsp;</td>
  <tr>
  <tr>
    <td colspan="2">
      ชื่อผู้ขนส่ง / Dispatcher Name
                <br>
                <html:text size="50" property="dispatcherName" value="Kin Kawh Agency"/>
                <br>
   ที่อยู่ผู้ขนส่ง / Dispatcher Address
                <br>
                <html:textarea rows="6" cols="50" property="dispatcherAddress" value="Street name 12, Block #23
Yishun, Singapore 17452"></html:textarea>
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
          <td><html:text property="invoiceNo" value="J024/2004"/></td>
        </tr>
        <tr>
          <td>ลงวันที่</td>
          <td><html:text property="invoiceDate" value="2006-07-20" readonly="true"/> <img id="invoiceDateTrigger" src="images/calendar.gif"></td>
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
            <html:textarea property="productDescription" rows="6" cols="50" value="FROZEN SHRIMP"></html:textarea>
          </td>
        </tr>
        <tr>
          <td>พิกัดศุลกากร</td>
          <td><html:text property="commodityCode" value="0306110009"/></td>
        </tr>
        <tr>
          <td>ปริมาณ / น้ำหนักสุทธิ</td>
          <td>
            <html:text property="productAmount" size="10" value="15360"/>
              หน่วย
            <html:text property="productAmountUom" size="10" value="KGS"/>
          </td>
        </tr>
        <tr>
          <td>มูลค่า</td>
          <td>
            <html:text property="productValue" value="2500.11" size="10"/> สกุลเงิน 
            <html:select property="productCurrency">
						  <html:options labelProperty="currencyName" property="currencyCodeA" collection="currencies"/>
					  </html:select>
          </td>
        </tr>
        <tr>
          <td>จำนวนหีบห่อ (Quantity)</td>
          <td><html:text property="packageQuantity" value="1"/></td>
        </tr>
        <tr>
          <td>ประเภทหีบห่อ (Kind of packages)</td>
          <td><html:text property="packageType" value="Boxes"/></td>
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
            <html:textarea property="halalProductDescription" rows="6" cols="50" value="TOM YUM PASTE IS A SEASONING PASTE CONSISTING OF SHRIMP POWDER AND SEVERAL SPICES. IT OCCURS AS RED-BROWN TO DARK-BROWN COLOR HAVING CHARACTERISTIC ODOUR AND TASTE"></html:textarea>
            <br>
            Manufactured By<br>
            <html:textarea property="manufacturer" rows="6" cols="50" value="KEWPIE (THAILAND) CO., LTD
55 MOO 6, T. LUMOIN, A MUANG, RATCHABURI
THAILAND"></html:textarea>
            <table class="body">
              <tr>
                <td>Halal No.</td>
                <td><html:text property="halalNo" value="75 215 017 04 44"/></td>
              </tr>
              <tr>
                <td>Halal Company Code</td>
                <td><html:text property="halalCompanyCode" value="215/1999"/></td>
              </tr>
            </table>
          </td>
        </tr>
      </table>
    </td>
  </tr>

  <%--
  <tr>
    <td>
      <TABLE class="body" width="100%">
        <TR>
          <TH>สำหรับการขอ "ใบอนุญาตนำสัตว์ หรือซากสัตว์ออกนอกราชอาณาจักร (ร.๙)" เท่านั้น</TH>
        </TR>
      </table>
    </td>
  </tr>
  <tr>
    <td>
      <table class="body" width="100%">
        <TR>
          <TD>
            <table class="body">
              <tr>
                <td>ชนิดและพันธุ์ของสัตว์</td>
                <td><html:text property="lifeAnimalDescription" size="30"/></td>
                <td>จำนวน </td>
                <td><html:text property="lifeAnimalAmount" size="10"/></td>
                <td>ตัว</td>
              </tr>
              <tr>
                <td>ชนิดของซาก</td>
                <td><html:text property="animalRemainsDescription" size="30"/></td>
                <td>จำนวน</td>
                <td><html:text property="animalRemainsAmount" size="10"/></td>
                <td>กิโลกรัม</td>
              </tr>
            </table>
          </td>
        </tr>
      </table>
    </td>
  </tr>
  --%>

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
          <td><html:text property="species"/></td>
        </tr>
        <tr>
          <td>Presentation of product and type of treatment</td>
          <td><html:text property="productPresentation"/></td>
        </tr>
        <tr>
          <td>Code number (where available)</td>
          <td><html:text property="codeNumber"/></td>
        </tr>
        <tr>
          <td>Requisit storage temperature</td>
          <td>
            <html:text property="storageTemperature" size="10" value="5"/> Degree
            <html:select property="storageTemperatureUom">
						  <html:option value="CEL">Celsius</html:option>
						  <html:option value="FAH">Fahrenheit</html:option>
					  </html:select>
          </td>
        </tr>
        <tr>
          <td>Requisit transport temperature</td>
          <td>
            <html:text property="transportTemperature" size="10" value="8"/> Degree
            <html:select property="transportTemperatureUom">
						  <html:option value="CEL">Celsius</html:option>
						  <html:option value="FAH">Fahrenheit</html:option>
					  </html:select>
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
          <td><html:text property="productOriginDistrict"/></td>
        </tr>
        <tr>
          <td>Province</td>
          <td>
            <html:select property="productOriginProvince">
						  <html:options labelProperty="name" property="code" collection="provinces"/>
					  </html:select>
          </td>
        </tr>
      </table>
    </td>
  </tr>

</table>
<p>
<div align="center"><html:submit value="ส่งข้อมูล"></html:submit></div>
</P></html:form>

<script type="text/javascript">//<![CDATA[
  Zapatec.Calendar.setup({
	showOthers        : true,
	electric          : false,
	inputField        : "invoiceDate",
	button            : "invoiceDateTrigger",
	ifFormat          : "%d-%m-%Y",
	daFormat          : "%Y/%m/%d"
  });

  Zapatec.Calendar.setup({
	showOthers        : true,
	electric          : false,
	inputField        : "shipmentDate",
	button            : "shipmentDateTrigger",
	ifFormat          : "%d-%m-%Y",
	daFormat          : "%Y/%m/%d"
  });
//]]></script>

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