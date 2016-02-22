package com.export.web.forms;

import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.FormFile;

public class VerifyShipmentCertificateForm extends ActionForm {
	
	private String certificateRequestId;
	private String certificateTypeId;
	private FormFile certificateFile;

	/**
	 * @return Returns the certificateFile.
	 */
	public FormFile getCertificateFile() {
		return certificateFile;
	}
	/**
	 * @param certificateFile The certificateFile to set.
	 */
	public void setCertificateFile(FormFile certificateFile) {
		this.certificateFile = certificateFile;
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
