package com.export.web.forms;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

public class VerifyExporterCertificateForm extends ActionForm {

	private static Log logger = LogFactory.getLog(VerifyExporterCertificateForm.class);
	
	private String exporterCertRequestId;
	private FormFile certificateFile;
	
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		exporterCertRequestId = null;
		certificateFile = null;
    }

	/**
	 * @return Returns the exporterCertRequestId.
	 */
	public String getExporterCertRequestId() {
		return exporterCertRequestId;
	}
	/**
	 * @param exporterCertRequestId The exporterCertRequestId to set.
	 */
	public void setExporterCertRequestId(String exporterCertRequestId) {
		this.exporterCertRequestId = exporterCertRequestId;
	}
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
}
