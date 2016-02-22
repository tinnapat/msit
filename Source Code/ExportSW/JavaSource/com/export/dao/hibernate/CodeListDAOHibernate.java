package com.export.dao.hibernate;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.export.dao.CodeListDAO;
import com.export.domain.Country;

public class CodeListDAOHibernate implements CodeListDAO {

	public Country getCountryByCountryCode(Object handle, String countryCode) {
		Session session = (Session) handle;
		return (Country) session.createCriteria(Country.class)
			.add(Restrictions.eq(Country.PROP_COUNTRY_CODE, countryCode))
			.uniqueResult();
	}
	
	

}
