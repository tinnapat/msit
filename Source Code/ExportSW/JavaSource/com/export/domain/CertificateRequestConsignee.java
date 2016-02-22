package com.export.domain;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class CertificateRequestConsignee implements Serializable {
	
	private Long certificateRequestId;
	private String consigneeName;
	private String consigneeAddress;
	private String destinationCountryCode;
	private Country destinationCountryLink;

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
	 * @return Returns the destinationCountryLink.
	 */
	public Country getDestinationCountryLink() {
		return destinationCountryLink;
	}
}
