package governmentapp.domain;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class ExporterCertificateRequestDetail implements Serializable {
	
	private Long id;
	
	private String exporterAddressName;
	private String exporterAddressStreet;
	private String exporterAddressCity;
	private String exporterAddressProvince;
	private Province exporterAddressProvinceLink;
	private String exporterAddressPostalZone;
	private String exporterAddressTelephone;
	private String exporterAddressCountry;
	
	private String factoryAddressName;
	private String factoryAddressStreet;
	private String factoryAddressCity;
	private String factoryAddressProvince;
	private Province factoryAddressProvinceLink;
	private String factoryAddressPostalZone;
	private String factoryAddressTelephone;
	private String factoryAddressCountry;
	
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
	
	/**
	 * @return Returns the exporterAddressCity.
	 */
	public String getExporterAddressCity() {
		return exporterAddressCity;
	}
	/**
	 * @param exporterAddressCity The exporterAddressCity to set.
	 */
	public void setExporterAddressCity(String exporterAddressCity) {
		this.exporterAddressCity = exporterAddressCity;
	}
	/**
	 * @return Returns the exporterAddressCountry.
	 */
	public String getExporterAddressCountry() {
		return exporterAddressCountry;
	}
	/**
	 * @param exporterAddressCountry The exporterAddressCountry to set.
	 */
	public void setExporterAddressCountry(String exporterAddressCountry) {
		this.exporterAddressCountry = exporterAddressCountry;
	}
	/**
	 * @return Returns the exporterAddressName.
	 */
	public String getExporterAddressName() {
		return exporterAddressName;
	}
	/**
	 * @param exporterAddressName The exporterAddressName to set.
	 */
	public void setExporterAddressName(String exporterAddressName) {
		this.exporterAddressName = exporterAddressName;
	}
	/**
	 * @return Returns the exporterAddressPostalZone.
	 */
	public String getExporterAddressPostalZone() {
		return exporterAddressPostalZone;
	}
	/**
	 * @param exporterAddressPostalZone The exporterAddressPostalZone to set.
	 */
	public void setExporterAddressPostalZone(String exporterAddressPostalZone) {
		this.exporterAddressPostalZone = exporterAddressPostalZone;
	}
	/**
	 * @return Returns the exporterAddressProvince.
	 */
	public String getExporterAddressProvince() {
		return exporterAddressProvince;
	}
	/**
	 * @param exporterAddressProvince The exporterAddressProvince to set.
	 */
	public void setExporterAddressProvince(String exporterAddressProvince) {
		this.exporterAddressProvince = exporterAddressProvince;
	}
	/**
	 * @return Returns the exporterAddressStreet.
	 */
	public String getExporterAddressStreet() {
		return exporterAddressStreet;
	}
	/**
	 * @param exporterAddressStreet The exporterAddressStreet to set.
	 */
	public void setExporterAddressStreet(String exporterAddressStreet) {
		this.exporterAddressStreet = exporterAddressStreet;
	}
	/**
	 * @return Returns the exporterAddressTelephone.
	 */
	public String getExporterAddressTelephone() {
		return exporterAddressTelephone;
	}
	/**
	 * @param exporterAddressTelephone The exporterAddressTelephone to set.
	 */
	public void setExporterAddressTelephone(String exporterAddressTelephone) {
		this.exporterAddressTelephone = exporterAddressTelephone;
	}
	/**
	 * @return Returns the factoryAddressCity.
	 */
	public String getFactoryAddressCity() {
		return factoryAddressCity;
	}
	/**
	 * @param factoryAddressCity The factoryAddressCity to set.
	 */
	public void setFactoryAddressCity(String factoryAddressCity) {
		this.factoryAddressCity = factoryAddressCity;
	}
	/**
	 * @return Returns the factoryAddressCountry.
	 */
	public String getFactoryAddressCountry() {
		return factoryAddressCountry;
	}
	/**
	 * @param factoryAddressCountry The factoryAddressCountry to set.
	 */
	public void setFactoryAddressCountry(String factoryAddressCountry) {
		this.factoryAddressCountry = factoryAddressCountry;
	}
	/**
	 * @return Returns the factoryAddressName.
	 */
	public String getFactoryAddressName() {
		return factoryAddressName;
	}
	/**
	 * @param factoryAddressName The factoryAddressName to set.
	 */
	public void setFactoryAddressName(String factoryAddressName) {
		this.factoryAddressName = factoryAddressName;
	}
	/**
	 * @return Returns the factoryAddressPostalZone.
	 */
	public String getFactoryAddressPostalZone() {
		return factoryAddressPostalZone;
	}
	/**
	 * @param factoryAddressPostalZone The factoryAddressPostalZone to set.
	 */
	public void setFactoryAddressPostalZone(String factoryAddressPostalZone) {
		this.factoryAddressPostalZone = factoryAddressPostalZone;
	}
	/**
	 * @return Returns the factoryAddressProvince.
	 */
	public String getFactoryAddressProvince() {
		return factoryAddressProvince;
	}
	/**
	 * @param factoryAddressProvince The factoryAddressProvince to set.
	 */
	public void setFactoryAddressProvince(String factoryAddressProvince) {
		this.factoryAddressProvince = factoryAddressProvince;
	}
	/**
	 * @return Returns the factoryAddressStreet.
	 */
	public String getFactoryAddressStreet() {
		return factoryAddressStreet;
	}
	/**
	 * @param factoryAddressStreet The factoryAddressStreet to set.
	 */
	public void setFactoryAddressStreet(String factoryAddressStreet) {
		this.factoryAddressStreet = factoryAddressStreet;
	}
	/**
	 * @return Returns the factoryAddressTelephone.
	 */
	public String getFactoryAddressTelephone() {
		return factoryAddressTelephone;
	}
	/**
	 * @param factoryAddressTelephone The factoryAddressTelephone to set.
	 */
	public void setFactoryAddressTelephone(String factoryAddressTelephone) {
		this.factoryAddressTelephone = factoryAddressTelephone;
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
	 * @return Returns the exporterAddressProvinceLink.
	 */
	public Province getExporterAddressProvinceLink() {
		return exporterAddressProvinceLink;
	}
	/**
	 * @return Returns the factoryAddressProvinceLink.
	 */
	public Province getFactoryAddressProvinceLink() {
		return factoryAddressProvinceLink;
	}
}
