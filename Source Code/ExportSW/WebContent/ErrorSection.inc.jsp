<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>

<logic:present name="org.apache.struts.action.ERROR">
<table width="100%" border="0" cellpadding="0" cellspacing="0" height="25" bgcolor="yellow">
  <tr>
    <td>
      <div align="center" class="error_message">
        <html:messages id="message" message="false">
          <%= message %><br>
        </html:messages>
      </div>
    </td>
  </tr>
</table>
</logic:present>