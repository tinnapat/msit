package governmentapp.domain;

import java.util.Date;

public class ShipmentCertificateRequestDetail extends ExporterCertificateRequestDetail {
	
    private String proxyId;
    private String proxyName;
    private String destinationCountry;
    private String destinationCountryCode;
    
    private Date invoiceDate;
    private String invoiceNo;
    
    private Date shipmentDate;
    private String transportMeansJourneyId;
    private String transportMode;
    private String transportModeCode;
    private String dischargeLocation;
    private String dischargeLocationCode;
    private String loadingLocation;
    private String loadingLocationCode;
    private String consigneeName;
    private String consigneeAddress;
    private String dispatcherName;
    private String dispatcherAddress;
    
    // Invoice
    private String productDescription;
    private String commodityCode;
    private Double productAmount;
    private String productAmountUom;
    private Double productValue;
    private String productCurrency;
    private Double packageQuantity;
    private String packageType;
    
    // Halal
    private String halalProductDescription;
    private String manufacturer;
    private String halalNo;
    private String halalCompanyCode;
    
    // Health Certificate
    private String species;
    private String productPresentation;
    private String codeNumber;
    private Double storageTemperature;
    private String storageTemperatureUom;
    private Double transportTemperature;
    private String transportTemperatureUom;
    
    // Quarantine Certificate
    private String productOriginDistrict;
    private String productOriginProvince;
    private Province productOriginProvinceLink;

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
	 * @return Returns the destinationCountry.
	 */
	public String getDestinationCountry() {
		return destinationCountry;
	}
	/**
	 * @param destinationCountry The destinationCountry to set.
	 */
	public void setDestinationCountry(String destinationCountry) {
		this.destinationCountry = destinationCountry;
	}
	/**
	 * @return Returns the destinationCountryCode.
	 */
	public String getDestinationCountryCode() {
		return destinationCountryCode;
	}
	/**
	 * @param destinationCountryCode The destinationCountryCode to set.
	 */
	public void setDestinationCountryCode(String destinationCountryCode) {
		this.destinationCountryCode = destinationCountryCode;
	}
	/**
	 * @return Returns the dischargeLocation.
	 */
	public String getDischargeLocation() {
		return dischargeLocation;
	}
	/**
	 * @param dischargeLocation The dischargeLocation to set.
	 */
	public void setDischargeLocation(String dischargeLocation) {
		this.dischargeLocation = dischargeLocation;
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
	 * @return Returns the invoiceDate.
	 */
	public Date getInvoiceDate() {
		return invoiceDate;
	}
	/**
	 * @param invoiceDate The invoiceDate to set.
	 */
	public void setInvoiceDate(Date invoiceDate) {
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
	 * @return Returns the loadingLocation.
	 */
	public String getLoadingLocation() {
		return loadingLocation;
	}
	/**
	 * @param loadingLocation The loadingLocation to set.
	 */
	public void setLoadingLocation(String loadingLocation) {
		this.loadingLocation = loadingLocation;
	}
	/**
	 * @return Returns the loadingLocationCode.
	 */
	public String getLoadingLocationCode() {
		return loadingLocationCode;
	}
	/**
	 * @param loadingLocationCode The loadingLocationCode to set.
	 */
	public void setLoadingLocationCode(String loadingLocationCode) {
		this.loadingLocationCode = loadingLocationCode;
	}
	/**
	 * @return Returns the manufacturer.
	 */
	public String getManufacturer() {
		return manufacturer;
	}
	/**
	 * @param manufacturer The manufacturer to set.
	 */
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	/**
	 * @return Returns the packageQuantity.
	 */
	public Double getPackageQuantity() {
		return packageQuantity;
	}
	/**
	 * @param packageQuantity The packageQuantity to set.
	 */
	public void setPackageQuantity(Double packageQuantity) {
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
	 * @return Returns the productAmount.
	 */
	public Double getProductAmount() {
		return productAmount;
	}
	/**
	 * @param productAmount The productAmount to set.
	 */
	public void setProductAmount(Double productAmount) {
		this.productAmount = productAmount;
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
	 * @return Returns the productValue.
	 */
	public Double getProductValue() {
		return productValue;
	}
	/**
	 * @param productValue The productValue to set.
	 */
	public void setProductValue(Double productValue) {
		this.productValue = productValue;
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
	 * @return Returns the shipmentDate.
	 */
	public Date getShipmentDate() {
		return shipmentDate;
	}
	/**
	 * @param shipmentDate The shipmentDate to set.
	 */
	public void setShipmentDate(Date shipmentDate) {
		this.shipmentDate = shipmentDate;
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
	 * @return Returns the storageTemperature.
	 */
	public Double getStorageTemperature() {
		return storageTemperature;
	}
	/**
	 * @param storageTemperature The storageTemperature to set.
	 */
	public void setStorageTemperature(Double storageTemperature) {
		this.storageTemperature = storageTemperature;
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
	 * @return Returns the transportModeCode.
	 */
	public String getTransportModeCode() {
		return transportModeCode;
	}
	/**
	 * @param transportModeCode The transportModeCode to set.
	 */
	public void setTransportModeCode(String transportModeCode) {
		this.transportModeCode = transportModeCode;
	}
	/**
	 * @return Returns the transportTemperature.
	 */
	public Double getTransportTemperature() {
		return transportTemperature;
	}
	/**
	 * @param transportTemperature The transportTemperature to set.
	 */
	public void setTransportTemperature(Double transportTemperature) {
		this.transportTemperature = transportTemperature;
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
	 * @return Returns the productOriginProvinceLink.
	 */
	public Province getProductOriginProvinceLink() {
		return productOriginProvinceLink;
	}
}
