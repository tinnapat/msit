package governmentapp.forms;

import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.FormFile;

/**
 * Form bean for a Struts application.
 * @version 	1.0
 * @author
 */
public class UpdateExporterCerificateForm extends ActionForm {
	
	private String certificateRequestId;
	private String exporterId;
	private String certificateTypeCode;
	private String statusCode;
	private String issueDate;
	private String expireDate;
	private String issueBy;
	private String signature;
	private FormFile privateKeyFile;

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
	 * @return Returns the certificateFile.
	 */
	public FormFile getPrivateKeyFile() {
		return privateKeyFile;
	}
	/**
	 * @param certificateFile The certificateFile to set.
	 */
	public void setPrivateKeyFile(FormFile certificateFile) {
		this.privateKeyFile = certificateFile;
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
}
