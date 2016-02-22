package com.export.web.forms;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import com.export.util.StringUtil;

/**
 * @version 	1.0
 * @author
 */
public class ExporterForm extends ActionForm {

    private static Log logger = LogFactory.getLog(ExporterForm.class);
	
	private String exporterId;
    private String password;
    private String password2;
    private String name;
    private String dateOfBirth;

	private String exporterAddressName;
    private String exporterAddressStreet;
	private String exporterAddressCity;
	private String exporterAddressCountrySubEntity;
	private String exporterAddressPostalZone;
	private String exporterAddressTelephone;

	private String factoryAddressName;
	private String factoryAddressStreet;
	private String factoryAddressCity;
	private String factoryAddressCountrySubEntity;
	private String factoryAddressPostalZone;
	private String factoryAddressTelephone;
	
	/**
	 * @return Returns the exporterAddressCity.
	 */
	public String getExporterAddressCity() {
		return exporterAddressCity;
	}
	/**
	 * @param exporterAddressCity The exporterAddressCity to set.
	 */
	public void setExporterAddressCity(String exporterAddressCity) {
		this.exporterAddressCity = exporterAddressCity;
	}
	/**
	 * @return Returns the exporterAddressCountrySubEntity.
	 */
	public String getExporterAddressCountrySubEntity() {
		return exporterAddressCountrySubEntity;
	}
	/**
	 * @param exporterAddressCountrySubEntity The exporterAddressCountrySubEntity to set.
	 */
	public void setExporterAddressCountrySubEntity(
			String exporterAddressCountrySubEntity) {
		this.exporterAddressCountrySubEntity = exporterAddressCountrySubEntity;
	}
	/**
	 * @return Returns the exporterAddressPostalZone.
	 */
	public String getExporterAddressPostalZone() {
		return exporterAddressPostalZone;
	}
	/**
	 * @param exporterAddressPostalZone The exporterAddressPostalZone to set.
	 */
	public void setExporterAddressPostalZone(String exporterAddressPostalZone) {
		this.exporterAddressPostalZone = exporterAddressPostalZone;
	}
	/**
	 * @return Returns the exporterAddressStreet.
	 */
	public String getExporterAddressStreet() {
		return exporterAddressStreet;
	}
	/**
	 * @param exporterAddressStreet The exporterAddressStreet to set.
	 */
	public void setExporterAddressStreet(String exporterAddressStreet) {
		this.exporterAddressStreet = exporterAddressStreet;
	}
	/**
	 * @return Returns the exporterAddressTelephone.
	 */
	public String getExporterAddressTelephone() {
		return exporterAddressTelephone;
	}
	/**
	 * @param exporterAddressTelephone The exporterAddressTelephone to set.
	 */
	public void setExporterAddressTelephone(String exporterAddressTelephone) {
		this.exporterAddressTelephone = exporterAddressTelephone;
	}
	/**
	 * @return Returns the exporterId.
	 */
	public String getExporterId() {
		return exporterId;
	}
	/**
	 * @param exporterId The exporterId to set.
	 */
	public void setExporterId(String exporterId) {
		this.exporterId = exporterId;
	}
	/**
	 * @return Returns the name.
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name The name to set.
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return Returns the password.
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password The password to set.
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return Returns the password2.
	 */
	public String getPassword2() {
		return password2;
	}
	/**
	 * @param password2 The password2 to set.
	 */
	public void setPassword2(String password2) {
		this.password2 = password2;
	}
	/**
	 * @return Returns the factoryAddressCity.
	 */
	public String getFactoryAddressCity() {
		return factoryAddressCity;
	}
	/**
	 * @param factoryAddressCity The factoryAddressCity to set.
	 */
	public void setFactoryAddressCity(String factoryAddressCity) {
		this.factoryAddressCity = factoryAddressCity;
	}
	/**
	 * @return Returns the factoryAddressCountrySubEntity.
	 */
	public String getFactoryAddressCountrySubEntity() {
		return factoryAddressCountrySubEntity;
	}
	/**
	 * @param factoryAddressCountrySubEntity The factoryAddressCountrySubEntity to set.
	 */
	public void setFactoryAddressCountrySubEntity(
			String factoryAddressCountrySubEntity) {
		this.factoryAddressCountrySubEntity = factoryAddressCountrySubEntity;
	}
	/**
	 * @return Returns the factoryAddressPostalZone.
	 */
	public String getFactoryAddressPostalZone() {
		return factoryAddressPostalZone;
	}
	/**
	 * @param factoryAddressPostalZone The factoryAddressPostalZone to set.
	 */
	public void setFactoryAddressPostalZone(String factoryAddressPostalZone) {
		this.factoryAddressPostalZone = factoryAddressPostalZone;
	}
	/**
	 * @return Returns the factoryAddressStreet.
	 */
	public String getFactoryAddressStreet() {
		return factoryAddressStreet;
	}
	/**
	 * @param factoryAddressStreet The factoryAddressStreet to set.
	 */
	public void setFactoryAddressStreet(String factoryAddressStreet) {
		this.factoryAddressStreet = factoryAddressStreet;
	}
	/**
	 * @return Returns the factoryAddressTelephone.
	 */
	public String getFactoryAddressTelephone() {
		return factoryAddressTelephone;
	}
	/**
	 * @param factoryAddressTelephone The factoryAddressTelephone to set.
	 */
	public void setFactoryAddressTelephone(String factoryAddressTelephone) {
		this.factoryAddressTelephone = factoryAddressTelephone;
	}
	/**
	 * @return Returns the exporterAddressName.
	 */
	public String getExporterAddressName() {
		return exporterAddressName;
	}
	/**
	 * @param exporterAddressName The exporterAddressName to set.
	 */
	public void setExporterAddressName(String exporterAddressName) {
		this.exporterAddressName = exporterAddressName;
	}
	/**
	 * @return Returns the factoryAddressName.
	 */
	public String getFactoryAddressName() {
		return factoryAddressName;
	}
	/**
	 * @param factoryAddressName The factoryAddressName to set.
	 */
	public void setFactoryAddressName(String factoryAddressName) {
		this.factoryAddressName = factoryAddressName;
	}
	
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		logger.debug("Validating input.");
		ActionErrors errors = new ActionErrors();
		
		String action = request.getParameter("action");
		logger.debug("Action: " + action);
		
		String[] validateFields = null;
		if ("AddExporter".equalsIgnoreCase(action)) {
			validateFields = new String[] {exporterId, password, password2, name, exporterAddressStreet, exporterAddressCity, 
					exporterAddressCountrySubEntity, exporterAddressPostalZone, exporterAddressTelephone, 
					factoryAddressStreet, factoryAddressCity, factoryAddressCountrySubEntity, factoryAddressPostalZone, factoryAddressTelephone};
		}
		else if ("ModifyExporter".equalsIgnoreCase(action)) {
			validateFields = new String[] {name, exporterAddressStreet, exporterAddressCity, 
					exporterAddressCountrySubEntity, exporterAddressPostalZone, exporterAddressTelephone, 
					factoryAddressStreet, factoryAddressCity, factoryAddressCountrySubEntity, factoryAddressPostalZone, factoryAddressTelephone};
		}

		if (StringUtil.isBlank(validateFields)) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("field.missing"));
		}
		
		if (!StringUtil.isEqual(password, password2)) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("password.not.match"));
		}
		
		return errors;
	}
	/**
	 * @return Returns the dateOfBirth.
	 */
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	/**
	 * @param dateOfBirth The dateOfBirth to set.
	 */
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
}
