package com.export.domain;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class CertificateRequestAnimalExport implements Serializable {
	
	private Long certificateRequestId;
	private String liveAnimalDescription;
	private Double liveAnimalAmount;
	private String animalRemainsDescription;
	private Double animalRemainsAmount;

	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}

	/**
	 * @return Returns the animalRemainsAmount.
	 */
	public Double getAnimalRemainsAmount() {
		return animalRemainsAmount;
	}
	/**
	 * @param animalRemainsAmount The animalRemainsAmount to set.
	 */
	public void setAnimalRemainsAmount(Double animalRemainsAmount) {
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
	 * @return Returns the liveAnimalAmount.
	 */
	public Double getLiveAnimalAmount() {
		return liveAnimalAmount;
	}
	/**
	 * @param liveAnimalAmount The liveAnimalAmount to set.
	 */
	public void setLiveAnimalAmount(Double liveAnimalAmount) {
		this.liveAnimalAmount = liveAnimalAmount;
	}
	/**
	 * @return Returns the liveAnimalDescription.
	 */
	public String getLiveAnimalDescription() {
		return liveAnimalDescription;
	}
	/**
	 * @param liveAnimalDescription The liveAnimalDescription to set.
	 */
	public void setLiveAnimalDescription(String liveAnimalDescription) {
		this.liveAnimalDescription = liveAnimalDescription;
	}
}
