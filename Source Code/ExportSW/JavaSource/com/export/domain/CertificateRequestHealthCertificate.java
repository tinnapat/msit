package com.export.domain;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class CertificateRequestHealthCertificate implements Serializable {
	
	private Long certificateRequestId;
	private String species;
	private String productDescription;
	private String codeNumber;
	private Double storageTemperature;
	private String storageTemperatureUom;
	private Double transportTemperature;
	private String transportTemperatureUom;

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
}
