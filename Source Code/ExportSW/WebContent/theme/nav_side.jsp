<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>nav_side.html</title>
</head>
<body>
<table class="nav_side" cellspacing="0" cellpadding="0" border="0" width="100%" height="100%">
	<jsp:include page="menu.jsp"/>
   <tbody>
      <tr>
         <td valign="top">
         <table border="0" width="100%" cellspacing="0" cellpadding="2">
            <tbody>
<!--siteedit:forEach var="item" items="${sitenav.items}"-->
 <!--siteedit:choose-->
  <!--siteedit:when test="${item.self}"-->
               <tr>
                  <td class="nav-s-highlighted">${item.label}</td>
               </tr>
  <!--/siteedit:when-->
  <!--siteedit:when test="${item.group}"-->
               <tr>
                  <td class="nav-s-normal"><br><b>${item.label}:</b></td>
               </tr>
  <!--/siteedit:when-->
  <!--siteedit:otherwise-->
               <tr>
                  <td class="nav-s-normal"><a href="${item.href}">${item.label}</a></td>
               </tr>
  <!--/siteedit:otherwise-->
 <!--/siteedit:choose-->
<!--/siteedit:forEach-->
			   <tr><td>&nbsp;</td></tr>
            </tbody>
         </table>
         </td>
      </tr>
   </tbody>
</table>
</body>
</html>
