package com.export.domain;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class CertificateRequestHalal implements Serializable {
	
	private Long certificateRequestId;
	private String productDescription;
	private String manufacturer;
	private String halalNo;
	private String halalCompanyCode;

	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}

	/**
	 * @return Returns the certificateRequestId.
	 */
	public Long getCertificateRequestId() {
		return certificateRequestId;
	}
	/**
	 * @param certificateRequestId The certificateRequestId to set.
	 */
	public void setCertificateRequestId(Long certificateRequestId) {
		this.certificateRequestId = certificateRequestId;
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
}
