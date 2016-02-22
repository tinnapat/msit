package com.export.vo;

import java.io.Serializable;
import java.util.Date;

public class CRDetailUpdateMsg implements Serializable {
	
	private long crDetaiId;
	private String certificateId;
	private String statusCode;
	private String signature;
	private Date modifyDate;

	/**
	 * @return Returns the crDetaiId.
	 */
	public long getCrDetaiId() {
		return crDetaiId;
	}
	/**
	 * @param crDetaiId The crDetaiId to set.
	 */
	public void setCrDetaiId(long crDetaiId) {
		this.crDetaiId = crDetaiId;
	}
	/**
	 * @return Returns the statusCode.
	 */
	public String getStatusCode() {
		return statusCode;
	}
	/**
	 * @param statusCode The statusCode to set.
	 */
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	/**
	 * @return Returns the updateDate.
	 */
	public Date getModifyDate() {
		return modifyDate;
	}
	/**
	 * @param updateDate The updateDate to set.
	 */
	public void setModifyDate(Date updateDate) {
		this.modifyDate = updateDate;
	}
	/**
	 * @return Returns the certificateId.
	 */
	public String getCertificateId() {
		return certificateId;
	}
	/**
	 * @param certificateId The certificateId to set.
	 */
	public void setCertificateId(String certificateId) {
		this.certificateId = certificateId;
	}
	/**
	 * @return Returns the signature.
	 */
	public String getSignature() {
		return signature;
	}
	/**
	 * @param signature The signature to set.
	 */
	public void setSignature(String signature) {
		this.signature = signature;
	}
}
