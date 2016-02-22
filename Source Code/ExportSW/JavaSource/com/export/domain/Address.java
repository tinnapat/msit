package com.export.domain;

import java.io.Serializable;

public class Address implements Serializable {
	
	private Long id;
	private Exporter exporter;
	private String name;
	private String street;
	private String city;
	private String countrySubEntity;		// State
	private Province countrySubEntityLink;	// State
	private String postalZone;
	private String telephone;

	/**
	 * @return Returns the city.
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city The city to set.
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @return Returns the countrySubEntity.
	 */
	public String getCountrySubEntity() {
		return countrySubEntity;
	}
	/**
	 * @param countrySubEntity The countrySubEntity to set.
	 */
	public void setCountrySubEntity(String countrySubEntity) {
		this.countrySubEntity = countrySubEntity;
	}
	/**
	 * @return Returns the postalZone.
	 */
	public String getPostalZone() {
		return postalZone;
	}
	/**
	 * @param postalZone The postalZone to set.
	 */
	public void setPostalZone(String postalZone) {
		this.postalZone = postalZone;
	}
	/**
	 * @return Returns the street.
	 */
	public String getStreet() {
		return street;
	}
	/**
	 * @param street The street to set.
	 */
	public void setStreet(String street) {
		this.street = street;
	}
	/**
	 * @return Returns the telephone.
	 */
	public String getTelephone() {
		return telephone;
	}
	/**
	 * @param telephone The telephone to set.
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
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
	 * @return Returns the exporter.
	 */
	public Exporter getExporter() {
		return exporter;
	}
	/**
	 * @param exporter The exporter to set.
	 */
	public void setExporter(Exporter exporter) {
		this.exporter = exporter;
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
	 * @return Returns the countrySubEntityLink.
	 */
	public Province getCountrySubEntityLink() {
		return countrySubEntityLink;
	}
}
