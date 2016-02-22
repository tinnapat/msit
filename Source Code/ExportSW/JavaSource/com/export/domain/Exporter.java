package com.export.domain;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.export.util.DateUtils;

public class Exporter implements Serializable {
	
	public static final String PROP_EXPORTER_ID	= "exporterId";
	
	private String exporterId;
	private String password;
	private String name;
	private Date dateOfBirth;
	
	private Address exporterAddress;
	private Address factoryAddress;
	
	private Date createDate;
	private Date modifyDate;
	

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
	 * @return Returns the exporterAddress.
	 */
	public Address getExporterAddress() {
		return exporterAddress;
	}
	/**
	 * @param exporterAddress The exporterAddress to set.
	 */
	public void setExporterAddress(Address exporterAddress) {
		this.exporterAddress = exporterAddress;
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
	 * @return Returns the factoryAddress.
	 */
	public Address getFactoryAddress() {
		return factoryAddress;
	}
	/**
	 * @param factoryAddress The factoryAddress to set.
	 */
	public void setFactoryAddress(Address factoryAddress) {
		this.factoryAddress = factoryAddress;
	}
	/**
	 * @return Returns the password.
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password The password to set.
	 */
	public void setPassword(String password) {
		this.password = password;
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
	/**
	 * @return Returns the modifyDate.
	 */
	public Date getModifyDate() {
		return modifyDate;
	}
	/**
	 * @param modifyDate The modifyDate to set.
	 */
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
	/**
	 * @return Returns the dateOfBirth.
	 */
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	/**
	 * @param dateOfBirth The dateOfBirth to set.
	 */
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getDateOfBirthString() {
		return DateUtils.dateToStringThai(dateOfBirth);
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}

}
