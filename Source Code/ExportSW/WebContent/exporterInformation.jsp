<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>

<bean:define id="exporterAddress" name="exporter" property="exporterAddress"/>
<bean:define id="factoryAddress" name="exporter" property="factoryAddress"/>

<bean:define id="exporterAddressProvince" name="exporterAddress" property="countrySubEntityLink"/>
<bean:define id="factoryAddressProvince" name="factoryAddress" property="countrySubEntityLink"/>

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
			<TD><bean:write name="exporter" property="dateOfBirthString"></bean:write></TD>
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
