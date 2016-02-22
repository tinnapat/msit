package governmentapp.web.forms;

import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.FormFile;

public class UpdateShipmentCertificateForm extends ActionForm {
	
	private String id;
	private String certificateRequestId;
	private String certificateTypeId;
	private String statusCode;
	private String issueDate;
	private String expireDate;
	private String issueBy;
	private String signature;
	private FormFile privateKeyFile;


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
	 * @return Returns the id.
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id The id to set.
	 */
	public void setId(String id) {
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
	 * @return Returns the privateKeyFile.
	 */
	public FormFile getPrivateKeyFile() {
		return privateKeyFile;
	}
	/**
	 * @param privateKeyFile The privateKeyFile to set.
	 */
	public void setPrivateKeyFile(FormFile privateKeyFile) {
		this.privateKeyFile = privateKeyFile;
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
