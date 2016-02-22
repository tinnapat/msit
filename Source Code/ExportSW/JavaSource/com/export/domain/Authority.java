package com.export.domain;

import java.util.Date;

public class Authority extends SimpleDomain {
	
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
}
