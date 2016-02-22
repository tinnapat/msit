<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>

<html>
<body>
<table class="nav_side" cellspacing="0" cellpadding="0" border="0" width="100%" height="100%">
   <tbody>
      <tr>
         <td valign="top">
         <table border="0" width="100%" cellspacing="0" cellpadding="2">
            <tbody>
    			   <logic:notPresent name="exporter">
               <tr>
                  <td class="nav-s-normal"><a href="<%= request.getContextPath() %>/index.jsp">หน้าแรก</a></td>
               </tr>
               <tr>
                  <td class="nav-s-normal"><html:link href="login.jsp">เข้าสู่ระบบ</html:link></td>
               </tr>
		    	   </logic:notPresent>
			       <logic:present name="exporter">
               <tr>
                  <td class="nav-s-normal"><a href="<%= request.getContextPath() %>/ExporterMain.do">หน้าแรก</a></td>
               </tr>
               <tr>
                  <td class="nav-s-normal"><html:link action="/PerformLogout">ออกจากระบบ</html:link></td>
               </tr>
    			   </logic:present>
               <tr>
                  <td>&nbsp;</td>
               </tr>
               <tr>
                  <td class="nav-s-normal"><b>ข้อมูลผู้ส่งออก:</b></td>
               </tr>
		    	   <logic:notPresent name="exporter">
               <tr>
                  <td class="nav-s-normal"><html:link action="/PrepareAddExporter">ลงทะเบียนผู้ส่งออก</html:link></td>
               </tr>
			       </logic:notPresent>
    			   <logic:present name="exporter">
               <tr>
                  <td class="nav-s-normal"><html:link action="/ViewExporter">เรียกดูข้อมูลผู้ส่งออก</html:link></td>
               </tr>
               <tr>
                  <td>&nbsp;</td>
               </tr>
               <tr>
                  <td class="nav-s-normal"><b>คำร้อง:</b></td>
               </tr>
               <tr>
                  <td class="nav-s-normal"><html:link action="/PrepareCertificateRequest">ยื่นแบบฟอร์มคำร้อง</html:link></td>
               </tr>
               <tr>
                  <td class="nav-s-normal"><html:link action="/PrepareViewCertificateRequest">ตรวจสอบสถานะ</html:link></td>
               </tr>
		    	   </logic:present>
			   <tr><td>&nbsp;</td></tr>
            </tbody>
         </table>
         </td>
      </tr>
   </tbody>
</table>
</body>
</html>
