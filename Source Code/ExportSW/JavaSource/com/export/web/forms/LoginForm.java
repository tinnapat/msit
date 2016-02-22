package com.export.web.forms;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

/**
 * Form bean for a Struts application.
 * Users may access 2 fields on this form:
 * <ul>
 * <li>password - [your comment here]
 * <li>exporterId - [your comment here]
 * </ul>
 * @version 	1.0
 * @author
 */
public class LoginForm extends ActionForm {

    private String password = null;

    private String exporterId = null;

    /**
     * Get password
     * @return String
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set password
     * @param <code>String</code>
     */
    public void setPassword(String p) {
        this.password = p;
    }

    /**
     * Get exporterId
     * @return String
     */
    public String getExporterId() {
        return exporterId;
    }

    /**
     * Set exporterId
     * @param <code>String</code>
     */
    public void setExporterId(String e) {
        this.exporterId = e;
    }

    public void reset(ActionMapping mapping, HttpServletRequest request) {

        // Reset values are provided as samples only. Change as appropriate.

        password = null;
        exporterId = null;

    }

    public ActionErrors validate(ActionMapping mapping,
            HttpServletRequest request) {

        ActionErrors errors = new ActionErrors();

        if (StringUtils.isEmpty(exporterId)
        		|| StringUtils.isEmpty(password)) {
        	errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("field.missing"));
        }
        return errors;

    }
}
