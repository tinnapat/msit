package com.export.vo;

import java.io.Serializable;
import java.util.Date;

public class ExporterCertificateUpdateMsg implements Serializable {
	
	private String exporterId;
	private String certificateTypeCode;
	private String statusCode;
	private Date issueDate;
	private Date expireDate;
	private String issueBy;
	private String signature;
	

	/**
	 * @return Returns the certificateType.
	 */
	public String getCertificateTypeCode() {
		return certificateTypeCode;
	}
	/**
	 * @param certificateType The certificateType to set.
	 */
	public void setCertificateTypeCode(String certificateType) {
		this.certificateTypeCode = certificateType;
	}
	/**
	 * @return Returns the expireDate.
	 */
	public Date getExpireDate() {
		return expireDate;
	}
	/**
	 * @param expireDate The expireDate to set.
	 */
	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
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
	 * @return Returns the issueBy.
	 */
	public String getIssueBy() {
		return issueBy;
	}
	/**
	 * @param issueBy The issueBy to set.
	 */
	public void setIssueBy(String issueBy) {
		this.issueBy = issueBy;
	}
	/**
	 * @return Returns the issueDate.
	 */
	public Date getIssueDate() {
		return issueDate;
	}
	/**
	 * @param issueDate The issueDate to set.
	 */
	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
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
}
