<%@ page 
language="java"
contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"
%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%-- tpl:insert page="/theme/B-01_green.htpl" --%><!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css">
<link rel="stylesheet" href="/ExportSW/theme/green.css" type="text/css">
<%-- tpl:put name="headarea" --%>
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
<h4>เข้าสู่ระบบ</h4>
<CENTER>
	<TABLE width="100%">
		<TR>
			<TD><html:form action="/PerformLogin" method="post">
				<CENTER>
				<BR>
				<div class="error_message"><html:errors/></div>
				<BR>
				<TABLE class="body">
					<TR>
						<TD>รหัสผู้ส่งออก</TD>
						<TD><html:text property="exporterId" maxlength="13"/></TD>
					</TR>
					<TR>
						<TD>รหัสผ่าน</TD>
						<TD><html:password property="password"/></TD>
					</TR>
				</TABLE>
				<BR>
				<html:submit value="ตกลง"></html:submit> <html:reset value="ลบข้อมูล"></html:reset></CENTER>
			</html:form></TD>
		</TR>
	</TABLE>
</CENTER>
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