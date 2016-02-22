package com.export.domain;

import java.io.Serializable;

public class TransportMode implements Serializable {
	
	private String code;
	private String name;
	private String thaiName;
	private String description;

	/**
	 * @return Returns the code.
	 */
	public String getCode() {
		return code;
	}
	/**
	 * @param code The code to set.
	 */
	public void setCode(String code) {
		this.code = code;
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
	 * @return Returns the thaiName.
	 */
	public String getThaiName() {
		return thaiName;
	}
	/**
	 * @param thaiName The thaiName to set.
	 */
	public void setThaiName(String thaiName) {
		this.thaiName = thaiName;
	}
}
