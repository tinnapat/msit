package com.export.vo;

import java.io.Serializable;
import java.util.Date;

import com.export.util.DateUtils;
import com.export.util.Encodable;
import com.tinnapat.util.StringUtil;

public class ExporterCertificateStatusVO implements Serializable, Encodable {
	
	private String exporterId;
	private String certificateTypeCode;
	private String issueDate;
	private String expireDate;
	private String issueBy;
	private String statusCode;

	/**
	 * @return Returns the certificateTypeCode.
	 */
	public String getCertificateTypeCode() {
		return certificateTypeCode;
	}
	/**
	 * @param certificateTypeCode The certificateTypeCode to set.
	 */
	public void setCertificateTypeCode(String certificateTypeCode) {
		this.certificateTypeCode = certificateTypeCode;
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
	public void setExpireDate(Date expireDate) {
		this.expireDate = DateUtils.dateToString(expireDate);
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
	public String getIssueDate() {
		return issueDate;
	}
	/**
	 * @param issueDate The issueDate to set.
	 */
	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}
	public void setIssueDate(Date issueDate) {
		this.issueDate = DateUtils.dateToString(issueDate);
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
	
	public String encode() {
		String[] pieces = new String[] {
			getExporterId(),
			getCertificateTypeCode(),
			getIssueDate(),
			getExpireDate(),
			getIssueBy(),
			getStatusCode()
    	};
		
		String text = StringUtil.join("|", pieces);
		return text;
	}

}
