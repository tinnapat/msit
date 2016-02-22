package com.export.web.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * @version 	1.0
 * @author
 */
public class LogoutAction extends Action

{

    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        ActionErrors errors = new ActionErrors();
        ActionForward forward = new ActionForward(); // return value

        try {
        	HttpSession session = request.getSession();
        	session.invalidate();
        	
        	request.setAttribute("successMessage", "คุณได้ออกจากระบบเรียบร้อยแล้ว");
        } 
        catch (Exception e) {
        	e.printStackTrace();
            errors.add("name", new ActionError("id"));
        }

        // If a message is required, save the specified key(s)
        // into the request for use by the <struts:errors> tag.

        if (!errors.isEmpty()) {
            saveErrors(request, errors);

            // Forward control to the appropriate 'failure' URI (change name as desired)
            forward = mapping.getInputForward();
        } 
        else {
            // Forward control to the appropriate 'success' URI (change name as desired)
            forward = mapping.findForward("success");
        }

        // Finish with
        return (forward);

    }
}
