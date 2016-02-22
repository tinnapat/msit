package com.export.dao.hibernate;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.export.dao.ExporterDAO;
import com.export.domain.Address;
import com.export.domain.CertificateType;
import com.export.domain.Exporter;
import com.export.domain.ExporterCertificateStatus;

public class ExporterDAOHibernate implements ExporterDAO {
	
	private static Log logger = LogFactory.getLog(ExporterDAOHibernate.class);

	public String addExporter(Object handle, Exporter exporter) {
		Session session = (Session) handle;
		String id = (String) session.save(exporter);
		
		Address exporterAddress = exporter.getExporterAddress();
		if (exporterAddress != null) {
			exporterAddress.setExporter(exporter);
			session.saveOrUpdate("ExporterAddress", exporterAddress);
		}
		
		Address factoryAddress = exporter.getFactoryAddress();
		if (factoryAddress != null) {
			factoryAddress.setExporter(exporter);
			session.saveOrUpdate("FactoryAddress", factoryAddress);
		}
		
		return id;
	}

	public Exporter getExporterByIdAndPassword(Object handle, String exporterId, String password) {
		Session session = (Session) handle;
		Criteria c = session.createCriteria(Exporter.class);
		c.add(Restrictions.eq("exporterId", exporterId));
		c.add(Restrictions.eq("password", password));
		return (Exporter) c.uniqueResult();
	}

	public void updateExporter(Object handle, Exporter exporter) {
		Session session = (Session) handle;
		session.update(exporter);
		
		Address exporterAddress = exporter.getExporterAddress();
		if (exporterAddress != null) {
			System.out.println("Exporter address id: " + exporterAddress.getId());
			exporterAddress.setExporter(exporter);
			session.update("ExporterAddress", (Object) exporterAddress);
		}
		
		Address factoryAddress = exporter.getFactoryAddress();
		if (factoryAddress != null) {
			factoryAddress.setExporter(exporter);
			session.update("FactoryAddress", (Object) factoryAddress);
		}
	}

	public List getExporterCertStatuses(Object handle, String exporterId) {
		Session session = (Session) handle;
		
		return session.createCriteria(ExporterCertificateStatus.class)
			.add(Restrictions.eq(ExporterCertificateStatus.PROP_EXPORTER_ID, exporterId))
			.list();
	}

	public Exporter getExporter(Object handle, String exporterId) {
		Session session = (Session) handle;
		return (Exporter) session.get(Exporter.class, exporterId);
	}

	public Exporter getExporterForUpdate(Object handle, String exporterId) {
		Session session = (Session) handle;
		return (Exporter) session.get(Exporter.class, exporterId, LockMode.UPGRADE);
	}

	public ExporterCertificateStatus getExporterCertStatus(Object handle, String exporterId, Long certificateTypeId) {
		logger.debug("Enter getExporterCertStatus()");
		
		Session session = (Session) handle;
		
		return (ExporterCertificateStatus) session.createCriteria(ExporterCertificateStatus.class)
			.add(Restrictions.eq(ExporterCertificateStatus.PROP_EXPORTER_ID, exporterId))
			.createCriteria(ExporterCertificateStatus.PROP_CERTIFICATE_TYPE)
				.add(Restrictions.eq(CertificateType.PROP_ID, certificateTypeId))
			.uniqueResult();
	}

	public Long createExporterCertificateStatus(Object handle, ExporterCertificateStatus status) {
		Session session = (Session) handle;
		return (Long) session.save(status);
	}

	public ExporterCertificateStatus getExporterCertStatus(Object handle, Long exporterCertStatusId) {
		Session session = (Session) handle;
		
		return (ExporterCertificateStatus) session.get(ExporterCertificateStatus.class, exporterCertStatusId);
	}
}