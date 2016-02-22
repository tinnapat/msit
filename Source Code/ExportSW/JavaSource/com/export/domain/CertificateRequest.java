package com.export.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.export.util.DateUtils;

/**
 * Domain object to represent a Certificate Request.
 * @author Tinnapat C.
 */
public class CertificateRequest implements Serializable {
	
	public static final String ID			= "id";
	public static final String EXPORTER		= "exporter";
	
	private Long id;
	private Exporter exporter;
	private String originDistrict;
	private String originProvinceCode;
	private Province originProvinceLink;
	private String authorizedPersonName;
	private String authorizedPersonId;
	private String remarks;
	private Date createDate;
	private Date modifyDate;
	
	private CertificateRequestAnimalExport animalExport;
	private CertificateRequestConsignee consignee;
	private CertificateRequestHalal halal;
	private CertificateRequestHealthCertificate healthCertificate;
	private CertificateRequestInvoice invoice;
	private CertificateRequestTransport transport;

	private List details;
	
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
	
	/**
	 * @return Returns the animalExport.
	 */
	public CertificateRequestAnimalExport getAnimalExport() {
		return animalExport;
	}
	/**
	 * @param animalExport The animalExport to set.
	 */
	public void setAnimalExport(CertificateRequestAnimalExport animalExport) {
		this.animalExport = animalExport;
	}
	/**
	 * @return Returns the authorizedPersonId.
	 */
	public String getAuthorizedPersonId() {
		return authorizedPersonId;
	}
	/**
	 * @param authorizedPersonId The authorizedPersonId to set.
	 */
	public void setAuthorizedPersonId(String authorizedPersonId) {
		this.authorizedPersonId = authorizedPersonId;
	}
	/**
	 * @return Returns the authorizedPersonName.
	 */
	public String getAuthorizedPersonName() {
		return authorizedPersonName;
	}
	/**
	 * @param authorizedPersonName The authorizedPersonName to set.
	 */
	public void setAuthorizedPersonName(String authorizedPersonName) {
		this.authorizedPersonName = authorizedPersonName;
	}
	/**
	 * @return Returns the consignee.
	 */
	public CertificateRequestConsignee getConsignee() {
		return consignee;
	}
	/**
	 * @param consignee The consignee to set.
	 */
	public void setConsignee(CertificateRequestConsignee consignee) {
		this.consignee = consignee;
	}
	/**
	 * @return Returns the createDate.
	 */
	public Date getCreateDate() {
		return createDate;
	}
	/**
	 * @param createDate The createDate to set.
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	/**
	 * @return Returns the details.
	 */
	public List getDetails() {
		return details;
	}
	/**
	 * @param details The details to set.
	 */
	public void setDetails(List details) {
		this.details = details;
	}
	/**
	 * @return Returns the exporter.
	 */
	public Exporter getExporter() {
		return exporter;
	}
	/**
	 * @param exporter The exporter to set.
	 */
	public void setExporter(Exporter exporter) {
		this.exporter = exporter;
	}
	/**
	 * @return Returns the halal.
	 */
	public CertificateRequestHalal getHalal() {
		return halal;
	}
	/**
	 * @param halal The halal to set.
	 */
	public void setHalal(CertificateRequestHalal halal) {
		this.halal = halal;
	}
	/**
	 * @return Returns the healthCertificate.
	 */
	public CertificateRequestHealthCertificate getHealthCertificate() {
		return healthCertificate;
	}
	/**
	 * @param healthCertificate The healthCertificate to set.
	 */
	public void setHealthCertificate(
			CertificateRequestHealthCertificate healthCertificate) {
		this.healthCertificate = healthCertificate;
	}
	/**
	 * @return Returns the id.
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id The id to set.
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return Returns the invoice.
	 */
	public CertificateRequestInvoice getInvoice() {
		return invoice;
	}
	/**
	 * @param invoice The invoice to set.
	 */
	public void setInvoice(CertificateRequestInvoice invoice) {
		this.invoice = invoice;
	}
	/**
	 * @return Returns the modifyDate.
	 */
	public Date getModifyDate() {
		return modifyDate;
	}
	/**
	 * @param modifyDate The modifyDate to set.
	 */
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
	/**
	 * @return Returns the originDistrict.
	 */
	public String getOriginDistrict() {
		return originDistrict;
	}
	/**
	 * @param originDistrict The originDistrict to set.
	 */
	public void setOriginDistrict(String originDistrict) {
		this.originDistrict = originDistrict;
	}
	/**
	 * @return Returns the originProvince.
	 */
	public String getOriginProvinceCode() {
		return originProvinceCode;
	}
	/**
	 * @param originProvince The originProvince to set.
	 */
	public void setOriginProvinceCode(String originProvince) {
		this.originProvinceCode = originProvince;
	}
	/**
	 * @return Returns the remarks.
	 */
	public String getRemarks() {
		return remarks;
	}
	/**
	 * @param remarks The remarks to set.
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	/**
	 * @return Returns the transport.
	 */
	public CertificateRequestTransport getTransport() {
		return transport;
	}
	/**
	 * @param transport The transport to set.
	 */
	public void setTransport(CertificateRequestTransport transport) {
		this.transport = transport;
	}
	/**
	 * @return Returns the originProvinceLink.
	 */
	public Province getOriginProvinceLink() {
		return originProvinceLink;
	}
	
	public String getCreateDateString() {
		return DateUtils.dateToStringThai(this.createDate);
	}
	
	public String getModifyDateString() {
		return DateUtils.dateToStringThai(this.modifyDate);
	}
}
