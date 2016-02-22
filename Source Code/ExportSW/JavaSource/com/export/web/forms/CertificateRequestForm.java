package com.export.web.forms;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

public class CertificateRequestForm extends ActionForm {
	
	private static Log logger = LogFactory.getLog(CertificateRequestForm.class);

    private String[] certificateTypes = null;
    private String loadingLocationCode			= "THBKK";
    private String dischargeLocationCode;
    private String transportMode				= "1";
    private String transportMeansJourneyId;
    private String shipmentDate;
    private String invoiceNo;
    private String invoiceDate;
    private String destinationCountryCode 		= "US";
    
    private String proxyName;
    private String proxyId;
    
    private String consigneeName;
    private String consigneeAddress;
    private String dispatcherName;
    private String dispatcherAddress;
    private String packageQuantity;
    private String packageType;
    
    // Invoice
    private String productDescription;
    private String commodityCode;
    private String productAmount;
    private String productAmountUom;
    private String productValue;
    private String productCurrency				= "USD";
    
    // Halal
    private String halalProductDescription;
    private String manufacturer;
    private String halalNo;
    private String halalCompanyCode;
    
    // Health Certificate
    private String species;
    private String productPresentation;
    private String codeNumber;
    private String storageTemperature;
    private String storageTemperatureUom;
    private String transportTemperature;
    private String transportTemperatureUom;
    
    // Quarantine Certificate
    private String productOriginDistrict;
    private String productOriginProvince;
    
    // Ror 9
    private String lifeAnimalDescription;
    private String lifeAnimalAmount;
    private String animalRemainsDescription;
    private String animalRemainsAmount;

	
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}

	/**
     * Get certificateTypes
     * @return String[]
     */
    public String[] getCertificateTypes() {
        return certificateTypes;
    }

    /**
     * Set certificateTypes
     * @param <code>String[]</code>
     */
    public void setCertificateTypes(String[] c) {
        this.certificateTypes = c;
    }

    public void reset(ActionMapping mapping, HttpServletRequest request) {

        // Reset values are provided as samples only. Change as appropriate.

        certificateTypes = null;

    }

    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
    	logger.debug("Enter validate()");

        ActionErrors errors = new ActionErrors();
        
        if (certificateTypes == null || certificateTypes.length == 0) {
        	errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.certificate.type.required"));
        }
        
        return errors;
    }
	/**
	 * @return Returns the countryCode.
	 */
	public String getDestinationCountryCode() {
		return destinationCountryCode;
	}
	/**
	 * @param countryCode The countryCode to set.
	 */
	public void setDestinationCountryCode(String countryCode) {
		this.destinationCountryCode = countryCode;
	}
	/**
	 * @return Returns the transportMode.
	 */
	public String getTransportMode() {
		return transportMode;
	}
	/**
	 * @param transportMode The transportMode to set.
	 */
	public void setTransportMode(String transportMode) {
		this.transportMode = transportMode;
	}
	/**
	 * @return Returns the portOfDepartureCode.
	 */
	public String getLoadingLocationCode() {
		return loadingLocationCode;
	}
	/**
	 * @param portOfDepartureCode The portOfDepartureCode to set.
	 */
	public void setLoadingLocationCode(String portOfDepartureCode) {
		this.loadingLocationCode = portOfDepartureCode;
	}
	/**
	 * @return Returns the transportMeansJourneyId.
	 */
	public String getTransportMeansJourneyId() {
		return transportMeansJourneyId;
	}
	/**
	 * @param transportMeansJourneyId The transportMeansJourneyId to set.
	 */
	public void setTransportMeansJourneyId(String transportMeansJourneyId) {
		this.transportMeansJourneyId = transportMeansJourneyId;
	}
	/**
	 * @return Returns the invoiceDate.
	 */
	public String getInvoiceDate() {
		return invoiceDate;
	}
	/**
	 * @param invoiceDate The invoiceDate to set.
	 */
	public void setInvoiceDate(String invoiceDate) {
		this.invoiceDate = invoiceDate;
	}
	/**
	 * @return Returns the invoiceNo.
	 */
	public String getInvoiceNo() {
		return invoiceNo;
	}
	/**
	 * @param invoiceNo The invoiceNo to set.
	 */
	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}
	/**
	 * @return Returns the shipmentDate.
	 */
	public String getShipmentDate() {
		return shipmentDate;
	}
	/**
	 * @param shipmentDate The shipmentDate to set.
	 */
	public void setShipmentDate(String shipmentDate) {
		this.shipmentDate = shipmentDate;
	}
	/**
	 * @return Returns the dischargeLocationCode.
	 */
	public String getDischargeLocationCode() {
		return dischargeLocationCode;
	}
	/**
	 * @param dischargeLocationCode The dischargeLocationCode to set.
	 */
	public void setDischargeLocationCode(String dischargeLocationCode) {
		this.dischargeLocationCode = dischargeLocationCode;
	}
	/**
	 * @return Returns the productOriginProvince.
	 */
	public String getProductOriginProvince() {
		return productOriginProvince;
	}
	/**
	 * @param productOriginProvince The productOriginProvince to set.
	 */
	public void setProductOriginProvince(String productOriginProvince) {
		this.productOriginProvince = productOriginProvince;
	}
	/**
	 * @return Returns the storageTemperatureUom.
	 */
	public String getStorageTemperatureUom() {
		return storageTemperatureUom;
	}
	/**
	 * @param storageTemperatureUom The storageTemperatureUom to set.
	 */
	public void setStorageTemperatureUom(String storageTemperatureUom) {
		this.storageTemperatureUom = storageTemperatureUom;
	}
	/**
	 * @return Returns the transportTemperatureUom.
	 */
	public String getTransportTemperatureUom() {
		return transportTemperatureUom;
	}
	/**
	 * @param transportTemperatureUom The transportTemperatureUom to set.
	 */
	public void setTransportTemperatureUom(String transportTemperatureUom) {
		this.transportTemperatureUom = transportTemperatureUom;
	}
	/**
	 * @return Returns the codeNumber.
	 */
	public String getCodeNumber() {
		return codeNumber;
	}
	/**
	 * @param codeNumber The codeNumber to set.
	 */
	public void setCodeNumber(String codeNumber) {
		this.codeNumber = codeNumber;
	}
	/**
	 * @return Returns the consigneeAddress.
	 */
	public String getConsigneeAddress() {
		return consigneeAddress;
	}
	/**
	 * @param consigneeAddress The consigneeAddress to set.
	 */
	public void setConsigneeAddress(String consigneeAddress) {
		this.consigneeAddress = consigneeAddress;
	}
	/**
	 * @return Returns the consigneeName.
	 */
	public String getConsigneeName() {
		return consigneeName;
	}
	/**
	 * @param consigneeName The consigneeName to set.
	 */
	public void setConsigneeName(String consigneeName) {
		this.consigneeName = consigneeName;
	}
	/**
	 * @return Returns the dispatcherAddress.
	 */
	public String getDispatcherAddress() {
		return dispatcherAddress;
	}
	/**
	 * @param dispatcherAddress The dispatcherAddress to set.
	 */
	public void setDispatcherAddress(String dispatcherAddress) {
		this.dispatcherAddress = dispatcherAddress;
	}
	/**
	 * @return Returns the dispatcherName.
	 */
	public String getDispatcherName() {
		return dispatcherName;
	}
	/**
	 * @param dispatcherName The dispatcherName to set.
	 */
	public void setDispatcherName(String dispatcherName) {
		this.dispatcherName = dispatcherName;
	}
	/**
	 * @return Returns the halalCompanyCode.
	 */
	public String getHalalCompanyCode() {
		return halalCompanyCode;
	}
	/**
	 * @param halalCompanyCode The halalCompanyCode to set.
	 */
	public void setHalalCompanyCode(String halalCompanyCode) {
		this.halalCompanyCode = halalCompanyCode;
	}
	/**
	 * @return Returns the halalNo.
	 */
	public String getHalalNo() {
		return halalNo;
	}
	/**
	 * @param halalNo The halalNo to set.
	 */
	public void setHalalNo(String halalNo) {
		this.halalNo = halalNo;
	}
	/**
	 * @return Returns the halalProductDescription.
	 */
	public String getHalalProductDescription() {
		return halalProductDescription;
	}
	/**
	 * @param halalProductDescription The halalProductDescription to set.
	 */
	public void setHalalProductDescription(String halalProductDescription) {
		this.halalProductDescription = halalProductDescription;
	}
	/**
	 * @return Returns the maufacturer.
	 */
	public String getManufacturer() {
		return manufacturer;
	}
	/**
	 * @param maufacturer The maufacturer to set.
	 */
	public void setManufacturer(String maufacturer) {
		this.manufacturer = maufacturer;
	}
	/**
	 * @return Returns the packageQuantity.
	 */
	public String getPackageQuantity() {
		return packageQuantity;
	}
	/**
	 * @param packageQuantity The packageQuantity to set.
	 */
	public void setPackageQuantity(String packageQuantity) {
		this.packageQuantity = packageQuantity;
	}
	/**
	 * @return Returns the packageType.
	 */
	public String getPackageType() {
		return packageType;
	}
	/**
	 * @param packageType The packageType to set.
	 */
	public void setPackageType(String packageType) {
		this.packageType = packageType;
	}
	/**
	 * @return Returns the productOriginDistrict.
	 */
	public String getProductOriginDistrict() {
		return productOriginDistrict;
	}
	/**
	 * @param productOriginDistrict The productOriginDistrict to set.
	 */
	public void setProductOriginDistrict(String productOriginDistrict) {
		this.productOriginDistrict = productOriginDistrict;
	}
	/**
	 * @return Returns the productPresentation.
	 */
	public String getProductPresentation() {
		return productPresentation;
	}
	/**
	 * @param productPresentation The productPresentation to set.
	 */
	public void setProductPresentation(String productPresentation) {
		this.productPresentation = productPresentation;
	}
	/**
	 * @return Returns the proxyId.
	 */
	public String getProxyId() {
		return proxyId;
	}
	/**
	 * @param proxyId The proxyId to set.
	 */
	public void setProxyId(String proxyId) {
		this.proxyId = proxyId;
	}
	/**
	 * @return Returns the proxyName.
	 */
	public String getProxyName() {
		return proxyName;
	}
	/**
	 * @param proxyName The proxyName to set.
	 */
	public void setProxyName(String proxyName) {
		this.proxyName = proxyName;
	}
	/**
	 * @return Returns the species.
	 */
	public String getSpecies() {
		return species;
	}
	/**
	 * @param species The species to set.
	 */
	public void setSpecies(String species) {
		this.species = species;
	}
	/**
	 * @return Returns the animalRemainsAmount.
	 */
	public String getAnimalRemainsAmount() {
		return animalRemainsAmount;
	}
	/**
	 * @param animalRemainsAmount The animalRemainsAmount to set.
	 */
	public void setAnimalRemainsAmount(String animalRemainsAmount) {
		this.animalRemainsAmount = animalRemainsAmount;
	}
	/**
	 * @return Returns the animalRemainsDescription.
	 */
	public String getAnimalRemainsDescription() {
		return animalRemainsDescription;
	}
	/**
	 * @param animalRemainsDescription The animalRemainsDescription to set.
	 */
	public void setAnimalRemainsDescription(String animalRemainsDescription) {
		this.animalRemainsDescription = animalRemainsDescription;
	}
	/**
	 * @return Returns the lifeAnimalAmount.
	 */
	public String getLifeAnimalAmount() {
		return lifeAnimalAmount;
	}
	/**
	 * @param lifeAnimalAmount The lifeAnimalAmount to set.
	 */
	public void setLifeAnimalAmount(String lifeAnimalAmount) {
		this.lifeAnimalAmount = lifeAnimalAmount;
	}
	/**
	 * @return Returns the lifeAnimalDescription.
	 */
	public String getLifeAnimalDescription() {
		return lifeAnimalDescription;
	}
	/**
	 * @param lifeAnimalDescription The lifeAnimalDescription to set.
	 */
	public void setLifeAnimalDescription(String lifeAnimalDescription) {
		this.lifeAnimalDescription = lifeAnimalDescription;
	}
	/**
	 * @return Returns the storageTemperature.
	 */
	public String getStorageTemperature() {
		return storageTemperature;
	}
	/**
	 * @param storageTemperature The storageTemperature to set.
	 */
	public void setStorageTemperature(String storageTemperature) {
		this.storageTemperature = storageTemperature;
	}
	/**
	 * @return Returns the transportTemperature.
	 */
	public String getTransportTemperature() {
		return transportTemperature;
	}
	/**
	 * @param transportTemperature The transportTemperature to set.
	 */
	public void setTransportTemperature(String transportTemperature) {
		this.transportTemperature = transportTemperature;
	}
	/**
	 * @return Returns the commodityCode.
	 */
	public String getCommodityCode() {
		return commodityCode;
	}
	/**
	 * @param commodityCode The commodityCode to set.
	 */
	public void setCommodityCode(String commodityCode) {
		this.commodityCode = commodityCode;
	}
	/**
	 * @return Returns the productAmount.
	 */
	public String getProductAmount() {
		return productAmount;
	}
	/**
	 * @param productAmount The productAmount to set.
	 */
	public void setProductAmount(String productAmount) {
		this.productAmount = productAmount;
	}
	/**
	 * @return Returns the productDescription.
	 */
	public String getProductDescription() {
		return productDescription;
	}
	/**
	 * @param productDescription The productDescription to set.
	 */
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	/**
	 * @return Returns the productValue.
	 */
	public String getProductValue() {
		return productValue;
	}
	/**
	 * @param productValue The productValue to set.
	 */
	public void setProductValue(String productValue) {
		this.productValue = productValue;
	}
	/**
	 * @return Returns the productCurrency.
	 */
	public String getProductCurrency() {
		return productCurrency;
	}
	/**
	 * @param productCurrency The productCurrency to set.
	 */
	public void setProductCurrency(String productCurrency) {
		this.productCurrency = productCurrency;
	}
	/**
	 * @return Returns the productAmountUom.
	 */
	public String getProductAmountUom() {
		return productAmountUom;
	}
	/**
	 * @param productAmountUom The productAmountUom to set.
	 */
	public void setProductAmountUom(String productAmountUom) {
		this.productAmountUom = productAmountUom;
	}
	
}
