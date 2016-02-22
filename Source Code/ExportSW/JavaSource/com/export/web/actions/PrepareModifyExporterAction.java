package com.export.web.actions;

import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.export.domain.Address;
import com.export.domain.Exporter;
import com.export.util.DateUtils;
import com.export.web.forms.ExporterForm;
import com.export.web.util.WebUtils;

/**
 * @version 	1.0
 * @author
 */
public class PrepareModifyExporterAction extends Action {

    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
            throws Exception {

		// Check if exporter is logged in
		if (!WebUtils.isUserLoggedIn(request)) {
			return mapping.findForward("error");
		}
		
		HttpSession session = request.getSession();
		Exporter exporter = (Exporter) session.getAttribute("exporter");
		
		ExporterForm f = new ExporterForm();
		f.setExporterId(exporter.getExporterId());
		f.setName(exporter.getName());
		f.setDateOfBirth(DateUtils.dateToString(exporter.getDateOfBirth()));
		
		Address exporterAddress = exporter.getExporterAddress();
		if (exporterAddress != null) {
			f.setExporterAddressName(exporterAddress.getName());
			f.setExporterAddressStreet(exporterAddress.getStreet());
			f.setExporterAddressCity(exporterAddress.getCity());
			f.setExporterAddressCountrySubEntity(exporterAddress.getCountrySubEntity());
			f.setExporterAddressPostalZone(exporterAddress.getPostalZone());
			f.setExporterAddressTelephone(exporterAddress.getTelephone());
		}
		
		Address factoryAddress = exporter.getFactoryAddress();
		if (factoryAddress != null) {
			f.setFactoryAddressName(factoryAddress.getName());
			f.setFactoryAddressStreet(factoryAddress.getStreet());
			f.setFactoryAddressCity(factoryAddress.getCity());
			f.setFactoryAddressCountrySubEntity(factoryAddress.getCountrySubEntity());
			f.setFactoryAddressPostalZone(factoryAddress.getPostalZone());
			f.setFactoryAddressTelephone(factoryAddress.getTelephone());
		}
		
		request.setAttribute("ExporterForm", f);
		
		Properties pageConfig = new Properties();
		pageConfig.setProperty("action", "ModifyExporter");
		pageConfig.setProperty("title", "แก้ไขข้อมูลผู้ส่งออก");
		pageConfig.setProperty("targetAction", "/PerformModifyExporter");
		request.getSession().setAttribute("pageConfig", pageConfig);
		
		return mapping.findForward("success");
    }
}
