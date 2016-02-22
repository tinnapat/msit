package com.export.web.actions;

import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * @version 	1.0
 * @author
 */
public class PrepareAddExporterAction extends Action {

    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

		Properties pageConfig = new Properties();
		pageConfig.setProperty("action", "AddExporter");
		pageConfig.setProperty("title", "ลงทะเบียนผู้ส่งออก");
		pageConfig.setProperty("targetAction", "/PerformAddExporter");
		request.getSession().setAttribute("pageConfig", pageConfig);

		return mapping.findForward("success");
    }
}
