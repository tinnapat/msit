package com.export.domain;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class Currency implements Serializable {
	
	public static final String PROP_CURRENCY_CODE_A			= "currencyCodeA";
	public static final String PROP_CURRENCY_NAME			= "currencyName";
	
	private String currencyCodeA;
	private String currencyCodeN;
	private Integer minorUnit;
	private String currencyName;
	/**
	 * @return Returns the currencyCodeA.
	 */
	public String getCurrencyCodeA() {
		return currencyCodeA;
	}
	/**
	 * @param currencyCodeA The currencyCodeA to set.
	 */
	public void setCurrencyCodeA(String currencyCodeA) {
		this.currencyCodeA = currencyCodeA;
	}
	/**
	 * @return Returns the currencyCodeN.
	 */
	public String getCurrencyCodeN() {
		return currencyCodeN;
	}
	/**
	 * @param currencyCodeN The currencyCodeN to set.
	 */
	public void setCurrencyCodeN(String currencyCodeN) {
		this.currencyCodeN = currencyCodeN;
	}
	/**
	 * @return Returns the currencyName.
	 */
	public String getCurrencyName() {
		return currencyName;
	}
	/**
	 * @param currencyName The currencyName to set.
	 */
	public void setCurrencyName(String currencyName) {
		this.currencyName = currencyName;
	}
	/**
	 * @return Returns the minorUnit.
	 */
	public Integer getMinorUnit() {
		return minorUnit;
	}
	/**
	 * @param minorUnit The minorUnit to set.
	 */
	public void setMinorUnit(Integer minorUnit) {
		this.minorUnit = minorUnit;
	}
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
