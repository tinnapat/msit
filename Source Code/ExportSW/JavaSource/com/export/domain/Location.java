package com.export.domain;

import java.io.Serializable;

/**
 * Domain object to represent a location.
 * <p>
 * UN/ECE Recommendation No. 16: United Nations Codes for Ports and other Locations (UN/LOCODE).
 * @author Tinnapat C.
 */
public class Location implements Serializable {
	
	public static final String PROP_LOCATION_CODE			= "locationCode";
	public static final String PROP_LOCATION_NAME			= "locationName";
	
	private String countryCode;
	private String location;
	private String locationCode;
	private String locationName;
	private String status;
	private String function;
	private String coordinates;
	private String remarks;
	

	/**
	 * @return Returns the coordinates.
	 */
	public String getCoordinates() {
		return coordinates;
	}
	/**
	 * @param coordinates The coordinates to set.
	 */
	public void setCoordinates(String coordinates) {
		this.coordinates = coordinates;
	}
	/**
	 * @return Returns the countryCode.
	 */
	public String getCountryCode() {
		return countryCode;
	}
	/**
	 * @param countryCode The countryCode to set.
	 */
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	/**
	 * @return Returns the function.
	 */
	public String getFunction() {
		return function;
	}
	/**
	 * @param function The function to set.
	 */
	public void setFunction(String function) {
		this.function = function;
	}
	/**
	 * @return Returns the locationCode.
	 */
	public String getLocationCode() {
		return locationCode;
	}
	/**
	 * @param locationCode The locationCode to set.
	 */
	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}
	/**
	 * @return Returns the locationName.
	 */
	public String getLocationName() {
		return locationName;
	}
	/**
	 * @param locationName The locationName to set.
	 */
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
	/**
	 * @return Returns the remarks.
	 */
	public String getRemarks() {
		return remarks;
	}
	/**
	 * @param remarks The remarks to set.
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	/**
	 * @return Returns the status.
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status The status to set.
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @return Returns the location.
	 */
	public String getLocation() {
		return location;
	}
	/**
	 * @param location The location to set.
	 */
	public void setLocation(String location) {
		this.location = location;
	}
}
