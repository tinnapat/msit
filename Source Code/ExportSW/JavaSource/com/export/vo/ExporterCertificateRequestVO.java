package com.export.vo;

import java.io.Serializable;

public class ExporterCertificateRequestVO implements Serializable {
	
	private String certTypeId;
	private String certTypeName;

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
	 * @return Returns the certTypeName.
	 */
	public String getCertTypeName() {
		return certTypeName;
	}
	/**
	 * @param certTypeName The certTypeName to set.
	 */
	public void setCertTypeName(String certTypeName) {
		this.certTypeName = certTypeName;
	}
}
