package governmentapp.domain;

import java.io.Serializable;
import java.util.Date;

public class CertificateRequest implements Serializable {
	
	private Long id;
	private String exporterId;
	private String exporterName;
	private Long certificateTypeId;
	private String certificateTypeName;
	private String statusCode;
	private RequestStatus statusLink;
	private Date requestDate;
	private Date issueDate;
	private Date expiryDate;
	private String issueBy;
	private String signature;
	
	/**
	 * @return Returns the expiryDate.
	 */
	public Date getExpiryDate() {
		return expiryDate;
	}
	/**
	 * @param expiryDate The expiryDate to set.
	 */
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
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
	 * @return Returns the exporterName.
	 */
	public String getExporterName() {
		return exporterName;
	}
	/**
	 * @param exporterName The exporterName to set.
	 */
	public void setExporterName(String exporterName) {
		this.exporterName = exporterName;
	}
	/**
	 * @return Returns the exporterTypeId.
	 */
	public Long getCertificateTypeId() {
		return certificateTypeId;
	}
	/**
	 * @param exporterTypeId The exporterTypeId to set.
	 */
	public void setCertificateTypeId(Long exporterTypeId) {
		this.certificateTypeId = exporterTypeId;
	}
	/**
	 * @return Returns the exporterTypeName.
	 */
	public String getCertificateTypeName() {
		return certificateTypeName;
	}
	/**
	 * @param exporterTypeName The exporterTypeName to set.
	 */
	public void setCertificateTypeName(String exporterTypeName) {
		this.certificateTypeName = exporterTypeName;
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
	 * @return Returns the requestDate.
	 */
	public Date getRequestDate() {
		return requestDate;
	}
	/**
	 * @param requestDate The requestDate to set.
	 */
	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
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
	 * @param statusLink The statusLink to set.
	 */
	public void setStatusLink(RequestStatus statusLink) {
		this.statusLink = statusLink;
	}
}
