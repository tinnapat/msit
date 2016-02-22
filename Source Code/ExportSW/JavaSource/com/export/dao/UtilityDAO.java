package com.export.dao;

import java.util.List;

import com.export.domain.Location;
import com.export.domain.Province;
import com.export.domain.TransportMode;

public interface UtilityDAO {
	
	public List getAllProvinces(Object handle);
	
	public List getAllCountries(Object handle);
	
	public List getAllTransportModes(Object handle);
	
	public List getAllThaiLocations(Object handle);
	
	public List getAllLocations(Object handle);
	
	public List getAllLocationsByCountryCode(Object handle, String countryCode);
	
	public List getAllCurrency(Object handle);
	
	public Location getLocation(Object handle, String locationCode);
	public Province getProvince(Object handle, String provinceCode);
	public TransportMode getTransportMode(Object handle, String transportModeCode);

}
