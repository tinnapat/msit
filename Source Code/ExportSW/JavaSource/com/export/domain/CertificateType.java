package com.export.domain;

import java.io.Serializable;
import java.util.Date;

public class CertificateType implements Serializable {
	
	public static final String TYPE_EXPORTER				= "E";
	public static final String TYPE_SHIPMENT				= "S";
	
	public static final String PROP_ID						= "id";
	public static final String PROP_ACTIVE_FLAG				= "activeFlag";
	
	private Long id;
	private String name;
	private String description;
	private String certificateType;
	private Authority authority;
	private char activeFlag;
	private Date createDate;

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
	 * @return Returns the description.
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description The description to set.
	 */
	public void setDescription(String description) {
		this.description = description;
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
	 * @return Returns the name.
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name The name to set.
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(super.toString());
		sb.append(";id=" + id);
		sb.append(";name=" + name);
		sb.append(";description=" + description);
		return sb.toString();
	}
	/**
	 * @return Returns the certificateType.
	 */
	public String getCertificateType() {
		return certificateType;
	}
	/**
	 * @param certificateType The certificateType to set.
	 */
	public void setCertificateType(String certificateType) {
		this.certificateType = certificateType;
	}
	/**
	 * @return Returns the authority.
	 */
	public Authority getAuthority() {
		return authority;
	}
	/**
	 * @param authority The authority to set.
	 */
	public void setAuthority(Authority authority) {
		this.authority = authority;
	}
	
	private boolean isActive() {
		return activeFlag == 'A';
	}
}
