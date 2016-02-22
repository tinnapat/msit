package com.export.vo;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.export.util.Encodable;

public class ShipmentCertificateStatusVO implements Serializable, Encodable {

	private String certificateRequestId;
	private String certificateTypeId;
	private String issueDate;
	private String expireDate;
	private String issueBy;
	private String statusCode;
	
	public static void main(String args[]) {
		ShipmentCertificateStatusVO vo = new ShipmentCertificateStatusVO();
		System.out.println(vo.encode());
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
	
	public String encode() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SIMPLE_STYLE);
	}

	/**
	 * @return Returns the expireDate.
	 */
	public String getExpireDate() {
		return expireDate;
	}
	/**
	 * @param expireDate The expireDate to set.
	 */
	public void setExpireDate(String expireDate) {
		this.expireDate = expireDate;
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
	public String getIssueDate() {
		return issueDate;
	}
	/**
	 * @param issueDate The issueDate to set.
	 */
	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
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
	 * @return Returns the certificateRequestId.
	 */
	public String getCertificateRequestId() {
		return certificateRequestId;
	}
	/**
	 * @param certificateRequestId The certificateRequestId to set.
	 */
	public void setCertificateRequestId(String certificateRequestId) {
		this.certificateRequestId = certificateRequestId;
	}
	/**
	 * @return Returns the certificateTypeId.
	 */
	public String getCertificateTypeId() {
		return certificateTypeId;
	}
	/**
	 * @param certificateTypeId The certificateTypeId to set.
	 */
	public void setCertificateTypeId(String certificateTypeId) {
		this.certificateTypeId = certificateTypeId;
	}
}
