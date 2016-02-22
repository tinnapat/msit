package com.export.web.forms;

import org.apache.struts.action.ActionForm;

public class ExporterCertRequestForm extends ActionForm {
	
	private String certTypeId;
	private String exporterId;

	/**
	 * @return Returns the certTypeId.
	 */
	public String getCertTypeId() {
		return certTypeId;
	}
	/**
	 * @param certTypeId The certTypeId to set.
	 */
	public void setCertTypeId(String certTypeId) {
		this.certTypeId = certTypeId;
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
}
