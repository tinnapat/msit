package com.export.dao.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.export.dao.UtilityDAO;
import com.export.domain.Country;
import com.export.domain.Currency;
import com.export.domain.Location;
import com.export.domain.Province;
import com.export.domain.TransportMode;
import com.export.util.StringUtil;

public class UtilityDAOHibernate implements UtilityDAO {

	public List getAllProvinces(Object handle) {
		Session session = (Session) handle;
		
		Criteria c = session.createCriteria(Province.class);
		
		// Add sorting by name.
		c.addOrder(Order.asc("name"));
		
		return c.list();
	}

	public List getAllCountries(Object handle) {
		Session session = (Session) handle;
		Criteria c = session.createCriteria(Country.class);
		c.addOrder(Order.asc("countryName"));
		return c.list();
	}

	public List getAllTransportModes(Object handle) {
		Session session = (Session) handle;
		Criteria c = session.createCriteria(TransportMode.class);
		c.addOrder(Order.asc("code"));
		return c.list();
	}

	public List getAllLocationsByCountryCode(Object handle, String countryCode) {
		Session session = (Session) handle;
		Criteria c = session.createCriteria(Location.class);
		c.addOrder(Order.asc(Location.PROP_LOCATION_NAME));
		if (StringUtil.isValidString(countryCode)) {
			c.add(Restrictions.eq("countryCode", countryCode));
		}
		c.setProjection(Projections.distinct(Projections.projectionList()
			.add(Projections.property(Location.PROP_LOCATION_CODE), Location.PROP_LOCATION_CODE) 
			.add(Projections.property(Location.PROP_LOCATION_NAME), Location.PROP_LOCATION_NAME)
		));
		c.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		return c.list();
	}

	public List getAllThaiLocations(Object handle) {
		return getAllLocationsByCountryCode(handle, "TH");
	}

	public List getAllLocations(Object handle) {
		return getAllLocationsByCountryCode(handle, null);
	}

	public List getAllCurrency(Object handle) {
		Session session = (Session) handle;
		Criteria c = session.createCriteria(Currency.class);
		c.setProjection(Projections.distinct(Projections.projectionList()
			.add(Projections.property(Currency.PROP_CURRENCY_CODE_A), Currency.PROP_CURRENCY_CODE_A) 
			.add(Projections.property(Currency.PROP_CURRENCY_NAME), Currency.PROP_CURRENCY_NAME)
		));
		c.addOrder(Order.asc(Currency.PROP_CURRENCY_NAME));
		c.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		return c.list();
	}

	public Location getLocation(Object handle, String locationCode) {
		Session session = (Session) handle;
		return (Location) session.get(Location.class, locationCode);
	}
	public Province getProvince(Object handle, String provinceCode) {
		Session session = (Session) handle;
		return (Province) session.get(Province.class, provinceCode);
	}
	public TransportMode getTransportMode(Object handle, String transportModeCode) {
		Session session = (Session) handle;
		return (TransportMode) session.get(TransportMode.class, transportModeCode);
	}

}
