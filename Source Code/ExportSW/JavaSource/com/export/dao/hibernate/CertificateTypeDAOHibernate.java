package com.export.dao.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.export.dao.CertificateTypeDAO;
import com.export.domain.CertificateType;

public class CertificateTypeDAOHibernate implements CertificateTypeDAO {

	public List getAllCertificateTypes(Object handle) {
		return getAllCertificateTypesByType(handle, "S");
	}

	public List getAllExporterCertificateTypes(Object handle) {
		return getAllCertificateTypesByType(handle, CertificateType.TYPE_EXPORTER);
	}
	
	private List getAllCertificateTypesByType(Object handle, String type) {
		Session session = (Session) handle;
		Criteria c = session.createCriteria(CertificateType.class);
		c.add(Restrictions.eq("certificateType", type));
		c.add(Restrictions.eq(CertificateType.PROP_ACTIVE_FLAG, "A"));
		return c.list();
	}

	public CertificateType getCertificateType(Object handle, Long id) {
		Session session = (Session) handle;
		return (CertificateType) session.get(CertificateType.class, id);
	}

}
