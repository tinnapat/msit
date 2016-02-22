package com.export.domain;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.export.util.DateUtils;

public class ExporterCertificateStatus implements Serializable {
	
	public static final String PROP_EXPORTER_ID 			= "exporterId";
	public static final String PROP_CERTIFICATE_TYPE		= "certificateType";
	
	private Long id;
	private String exporterId;
	private Exporter exporterLink;
	private CertificateType certificateType;
	private String statusCode;
	private RequestStatus statusLink;
	private Date issueDate;
	private Date expireDate;
	private String issueBy;
	private Date createDate;
	private Date modifyDate;
	private String signature;

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
	 * @return Returns the certificateType.
	 */
	public CertificateType getCertificateType() {
		return certificateType;
	}
	/**
	 * @param certificateType The certificateType to set.
	 */
	public void setCertificateType(CertificateType certificateType) {
		this.certificateType = certificateType;
	}
	/**
	 * @return Returns the status.
	 */
	public RequestStatus getStatusLink() {
		return statusLink;
	}
	/**
	 * @param status The status to set.
	 */
	public void setStatusLink(RequestStatus status) {
		this.statusLink = status;
	}
	
	public String getIssueDateString() {
		return DateUtils.dateToStringThai(issueDate);
	}
	
	public String getExpireDateString() {
		return DateUtils.dateToStringThai(expireDate);
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
	 * @return Returns the exporterLink.
	 */
	public Exporter getExporterLink() {
		return exporterLink;
	}
	/**
	 * @param exporterLink The exporterLink to set.
	 */
	public void setExporterLink(Exporter exporterLink) {
		this.exporterLink = exporterLink;
	}
	
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
