package com.export.domain;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.export.util.DateUtils;

public class CertificateRequestTransport implements Serializable {
	
	private Long certificateRequestId;
	private Date shipmentDate;
	private String transportModeCode;
	private TransportMode transportModeLink;
	private String journeyId;
	private String loadingLocationCode;
	private Location loadingLocationLink;
	private String dischargeLocationCode;
	private Location dischargeLocationLink;
	private String dispatcherName;
	private String dispatcherAddress;

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
	 * @return Returns the dischargeLocationCode.
	 */
	public String getDischargeLocationCode() {
		return dischargeLocationCode;
	}
	/**
	 * @param dischargeLocationCode The dischargeLocationCode to set.
	 */
	public void setDischargeLocationCode(String dischargeLocationCode) {
		this.dischargeLocationCode = dischargeLocationCode;
	}
	/**
	 * @return Returns the dischargeLocationLink.
	 */
	public Location getDischargeLocationLink() {
		return dischargeLocationLink;
	}
	/**
	 * @param dischargeLocationLink The dischargeLocationLink to set.
	 */
	public void setDischargeLocationLink(Location dischargeLocationLink) {
		this.dischargeLocationLink = dischargeLocationLink;
	}
	/**
	 * @return Returns the dispatcherAddress.
	 */
	public String getDispatcherAddress() {
		return dispatcherAddress;
	}
	/**
	 * @param dispatcherAddress The dispatcherAddress to set.
	 */
	public void setDispatcherAddress(String dispatcherAddress) {
		this.dispatcherAddress = dispatcherAddress;
	}
	/**
	 * @return Returns the dispatcherName.
	 */
	public String getDispatcherName() {
		return dispatcherName;
	}
	/**
	 * @param dispatcherName The dispatcherName to set.
	 */
	public void setDispatcherName(String dispatcherName) {
		this.dispatcherName = dispatcherName;
	}
	/**
	 * @return Returns the journeyId.
	 */
	public String getJourneyId() {
		return journeyId;
	}
	/**
	 * @param journeyId The journeyId to set.
	 */
	public void setJourneyId(String journeyId) {
		this.journeyId = journeyId;
	}
	/**
	 * @return Returns the loadingLocationCode.
	 */
	public String getLoadingLocationCode() {
		return loadingLocationCode;
	}
	/**
	 * @param loadingLocationCode The loadingLocationCode to set.
	 */
	public void setLoadingLocationCode(String loadingLocationCode) {
		this.loadingLocationCode = loadingLocationCode;
	}
	/**
	 * @return Returns the loadingLocationLink.
	 */
	public Location getLoadingLocationLink() {
		return loadingLocationLink;
	}
	/**
	 * @param loadingLocationLink The loadingLocationLink to set.
	 */
	public void setLoadingLocationLink(Location loadingLocationLink) {
		this.loadingLocationLink = loadingLocationLink;
	}
	/**
	 * @return Returns the shipmentDate.
	 */
	public Date getShipmentDate() {
		return shipmentDate;
	}
	public String getShipmentDateString() {
		return DateUtils.dateToStringThai(this.shipmentDate);
	}
	/**
	 * @param shipmentDate The shipmentDate to set.
	 */
	public void setShipmentDate(Date shipmentDate) {
		this.shipmentDate = shipmentDate;
	}
	/**
	 * @return Returns the transportModeCode.
	 */
	public String getTransportModeCode() {
		return transportModeCode;
	}
	/**
	 * @param transportModeCode The transportModeCode to set.
	 */
	public void setTransportModeCode(String transportModeCode) {
		this.transportModeCode = transportModeCode;
	}
	/**
	 * @return Returns the transportModeLink.
	 */
	public TransportMode getTransportModeLink() {
		return transportModeLink;
	}
	/**
	 * @param transportModeLink The transportModeLink to set.
	 */
	public void setTransportModeLink(TransportMode transportModeLink) {
		this.transportModeLink = transportModeLink;
	}
}
