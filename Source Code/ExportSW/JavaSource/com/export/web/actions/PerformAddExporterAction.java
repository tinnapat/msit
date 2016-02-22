package com.export.web.actions;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.Session;

import com.export.dao.ExporterDAO;
import com.export.dao.hibernate.ExporterDAOHibernate;
import com.export.domain.Address;
import com.export.domain.Exporter;
import com.export.framework.hibernate.HibernateSession;
import com.export.util.DateUtils;
import com.export.web.forms.ExporterForm;

/**
 * @version 	1.0
 * @author
 */
public class PerformAddExporterAction extends Action {

    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) 
            throws Exception {

    	String action = request.getParameter("action");
    	Date currentDate = new Date();
    	
    	ActionErrors errors = new ActionErrors();

        try {
        	ExporterForm f = (ExporterForm) form;
        	
        	Session session = HibernateSession.currentSession();

        	ExporterDAO exporterDAO = new ExporterDAOHibernate();
        	if ("AddExporter".equalsIgnoreCase(action)) {
            	Exporter exporter = new Exporter();
            	exporter.setExporterId(f.getExporterId());

            	populateExporter(exporter, f);
            	
        		exporter.setCreateDate(currentDate);
        		exporterDAO.addExporter(session, exporter);
        	}
        	else if ("ModifyExporter".equalsIgnoreCase(action)) {
        		Exporter exporter = exporterDAO.getExporterForUpdate(session, f.getExporterId());
        		if (exporter == null) {
            		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("exporter.not.exist"));
        		}
        		else {
        			populateExporter(exporter, f);
        	    	exporter.setModifyDate(currentDate);
	        		exporterDAO.updateExporter(session, exporter);
	        		
	        		// Refresh session
	        		exporter = exporterDAO.getExporter(session, exporter.getExporterId());
	        		
	        		HttpSession httpSession = request.getSession();
	        		httpSession.setAttribute("exporter", exporter);
        		}
        	}
        	else {
        		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("invalid.action"));
        	}
        	
        	HibernateSession.closeSession();
        	
        	request.setAttribute("successMessage", "ระบบได้ทำการบันทึกข้อมูลของคุณเรียบร้อยแล้ว");
        } 
        catch (Exception e) {
        	e.printStackTrace();
            // Report the error using the appropriate name and ID.
            errors.add("name", new ActionError("id"));
        }

        // If a message is required, save the specified key(s)
        // into the request for use by the <struts:errors> tag.

        if (!errors.isEmpty()) {
            saveErrors(request, errors);

            // Forward control to the appropriate 'failure' URI (change name as desired)
            return mapping.getInputForward();
        }
        
        // Finish with
        return mapping.findForward("success");
    }
    
    private void populateExporter(Exporter exporter, ExporterForm f) {
    	exporter.setName(f.getName());
    	if (StringUtils.isNotEmpty(f.getPassword())) {
    		exporter.setPassword(f.getPassword());
    	}
    	
    	String dobString = f.getDateOfBirth();
    	exporter.setDateOfBirth(DateUtils.stringToDate(dobString));
    	
    	// Set exporter address
    	Address exporterAddress = exporter.getExporterAddress();
    	if (exporterAddress == null) {
    		exporterAddress = new Address();
        	exporter.setExporterAddress(exporterAddress);
    	}
    	exporterAddress.setStreet(f.getExporterAddressStreet());
    	exporterAddress.setCity(f.getExporterAddressCity());
    	exporterAddress.setCountrySubEntity(f.getExporterAddressCountrySubEntity());
    	exporterAddress.setPostalZone(f.getExporterAddressPostalZone());
    	exporterAddress.setTelephone(f.getExporterAddressTelephone());
    	exporterAddress.setExporter(exporter);

    	// Set factory address
    	Address factoryAddress = exporter.getFactoryAddress();
    	if (factoryAddress == null) {
    		factoryAddress = new Address();
        	exporter.setFactoryAddress(factoryAddress);
    	}
    	factoryAddress.setStreet(f.getFactoryAddressStreet());
    	factoryAddress.setCity(f.getFactoryAddressCity());
    	factoryAddress.setCountrySubEntity(f.getFactoryAddressCountrySubEntity());
    	factoryAddress.setPostalZone(f.getFactoryAddressPostalZone());
    	factoryAddress.setTelephone(f.getFactoryAddressTelephone());
    	factoryAddress.setExporter(exporter);
    }
}
