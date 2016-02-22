package com.export.domain;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.export.util.DateUtils;

public class CertificateRequestInvoice implements Serializable {
	
	private Long certificateRequestId;
	private String invoiceNo;
	private Date invoiceDate;
	private String itemDescription;
	private String itemHarmonizeCode;
	private Double itemWeight;
	private String itemWeightUom;
	private Double itemPrice;
	private String itemPriceCurrencyCode;
	private Currency itemPriceCurrencyLink;
	private Double itemQuantity;
	private String packageType;

	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}

	/**
	 * @return Returns the certificateRequestId.
	 */
	public Long getCertificateRequestId() {
		return certificateRequestId;
	}
	/**
	 * @param certificateRequestId The certificateRequestId to set.
	 */
	public void setCertificateRequestId(Long certificateRequestId) {
		this.certificateRequestId = certificateRequestId;
	}
	/**
	 * @return Returns the invoiceDate.
	 */
	public Date getInvoiceDate() {
		return invoiceDate;
	}
	public String getInvoiceDateString() {
		return DateUtils.dateToStringThai(this.invoiceDate);
	}
	/**
	 * @param invoiceDate The invoiceDate to set.
	 */
	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}
	/**
	 * @return Returns the invoiceNo.
	 */
	public String getInvoiceNo() {
		return invoiceNo;
	}
	/**
	 * @param invoiceNo The invoiceNo to set.
	 */
	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}
	/**
	 * @return Returns the itemDescription.
	 */
	public String getItemDescription() {
		return itemDescription;
	}
	/**
	 * @param itemDescription The itemDescription to set.
	 */
	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}
	/**
	 * @return Returns the itemHarmonizeCode.
	 */
	public String getItemHarmonizeCode() {
		return itemHarmonizeCode;
	}
	/**
	 * @param itemHarmonizeCode The itemHarmonizeCode to set.
	 */
	public void setItemHarmonizeCode(String itemHarmonizeCode) {
		this.itemHarmonizeCode = itemHarmonizeCode;
	}
	/**
	 * @return Returns the itemPrice.
	 */
	public Double getItemPrice() {
		return itemPrice;
	}
	/**
	 * @param itemPrice The itemPrice to set.
	 */
	public void setItemPrice(Double itemPrice) {
		this.itemPrice = itemPrice;
	}
	/**
	 * @return Returns the itemPriceCurrencyCode.
	 */
	public String getItemPriceCurrencyCode() {
		return itemPriceCurrencyCode;
	}
	/**
	 * @param itemPriceCurrencyCode The itemPriceCurrencyCode to set.
	 */
	public void setItemPriceCurrencyCode(String itemPriceCurrencyCode) {
		this.itemPriceCurrencyCode = itemPriceCurrencyCode;
	}
	/**
	 * @return Returns the itemQuantity.
	 */
	public Double getItemQuantity() {
		return itemQuantity;
	}
	/**
	 * @param itemQuantity The itemQuantity to set.
	 */
	public void setItemQuantity(Double itemQuantity) {
		this.itemQuantity = itemQuantity;
	}
	/**
	 * @return Returns the itemWeight.
	 */
	public Double getItemWeight() {
		return itemWeight;
	}
	/**
	 * @param itemWeight The itemWeight to set.
	 */
	public void setItemWeight(Double itemWeight) {
		this.itemWeight = itemWeight;
	}
	/**
	 * @return Returns the itemWeightUom.
	 */
	public String getItemWeightUom() {
		return itemWeightUom;
	}
	/**
	 * @param itemWeightUom The itemWeightUom to set.
	 */
	public void setItemWeightUom(String itemWeightUom) {
		this.itemWeightUom = itemWeightUom;
	}
	/**
	 * @return Returns the packageType.
	 */
	public String getPackageType() {
		return packageType;
	}
	/**
	 * @param packageType The packageType to set.
	 */
	public void setPackageType(String packageType) {
		this.packageType = packageType;
	}
	/**
	 * @return Returns the itemPriceCurrencyLink.
	 */
	public Currency getItemPriceCurrencyLink() {
		return itemPriceCurrencyLink;
	}
}
