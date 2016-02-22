package com.export.dao;

import com.export.domain.Country;

public interface CodeListDAO {
	
	public Country getCountryByCountryCode(Object handle, String countryId);

}
