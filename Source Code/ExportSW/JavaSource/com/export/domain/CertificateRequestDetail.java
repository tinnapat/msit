package com.export.domain;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.export.util.DateUtils;

public class CertificateRequestDetail implements Serializable {
	
	public static final String PROP_ID							= "id";
	public static final String PROP_CERTIFICATE_REQUEST_ID		= "certificateRequestId";
	public static final String PROP_CERTIFICATE_TYPE_ID			= "certificateTypeId";
	
	// Identity
	private Long id;
	
	private Long certificateRequestId;
	private Long certificateTypeId;
	private CertificateType certificateTypeLink;
	private String statusCode;
	private RequestStatus statusLink;
	private Date issueDate;
	private Date expireDate;
	private String issueBy;
	private String signature;
	private Date createDate;
	private Date modifyDate;
	
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
	 * @return Returns the certificateType.
	 */
	public CertificateType getCertificateTypeLink() {
		return certificateTypeLink;
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
	 * @return Returns the expireDate.
	 */
	public Date getExpireDate() {
		return expireDate;
	}
	public String getExpireDateString() {
		return DateUtils.dateToStringThai(this.expireDate);
	}
	/**
	 * @param expireDate The expireDate to set.
	 */
	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
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
	public String getIssueDateString() {
		return DateUtils.dateToStringThai(this.issueDate);
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
	 * @return Returns the statusLink.
	 */
	public RequestStatus getStatusLink() {
		return statusLink;
	}
	/**
	 * @return Returns the certificateTypeId.
	 */
	public Long getCertificateTypeId() {
		return certificateTypeId;
	}
	/**
	 * @param certificateTypeId The certificateTypeId to set.
	 */
	public void setCertificateTypeId(Long certificateTypeId) {
		this.certificateTypeId = certificateTypeId;
	}
	
	public String getCreateDateString() {
		return DateUtils.dateToStringThai(this.createDate);
	}
}
