<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8" errorPage="/error.jsp" %>
<%@ page import="java.util.Date" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles"%>

<%
response.setHeader("Pragma","no-cache"); //HTTP 1.0
response.setHeader("Cache-Control", "no-cache"); //HTTP 1.1
response.setDateHeader ("Expires", 0); //prevents caching at the proxy server
%>

<html:html>
<HEAD>
<META http-equiv="Content-Type" content="text/html; charset=UTF-8">
<META http-equiv="Content-Style-Type" content="text/css">
<LINK href="<%=request.getContextPath()%>/theme/Master.css" rel="stylesheet" type="text/css">
<TITLE><tiles:getAsString name="title" /></TITLE>
</HEAD>

<BODY>
<TABLE width="100%" border="1" height="100%">
	<TBODY>
		<TR align="center" valign="middle">
			<TD width="90" height="50"><IMG border="0" src="<%=request.getContextPath()%>/pics/pwslogo.JPG"
				width="81" height="21"></TD>
			<TD height="50"><H1><tiles:insert attribute="header"/></H1></TD>
		</TR>
		<TR>
			<TD width="90"><tiles:insert attribute="menu" /></TD>
			<TD><tiles:insert attribute="body"/></TD>
		</TR>
		<TR>
			<TD colspan="2" height="30">PWS Consulting - <%= new Date() %></TD>
		</TR>
	</TBODY>
</TABLE>
</BODY>
</html:html>
