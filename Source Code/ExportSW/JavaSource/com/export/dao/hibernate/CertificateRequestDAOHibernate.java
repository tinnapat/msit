package com.export.dao.hibernate;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.export.criteria.CertificateRequestCriteria;
import com.export.criteria.CertificateRequestDetailCriteria;
import com.export.dao.CertificateRequestDAO;
import com.export.domain.CertificateRequest;
import com.export.domain.CertificateRequestDetail;
import com.export.domain.Exporter;

public class CertificateRequestDAOHibernate implements CertificateRequestDAO {
	
	private static Log logger = LogFactory.getLog(CertificateRequestDAOHibernate.class);

	public CertificateRequest getCertificateRequestById(Object handle, Long crId) {
		Session session = (Session) handle;
		return (CertificateRequest) session.get(CertificateRequest.class, crId);
	}

	public CertificateRequestDetail getCertificateRequestDetailById(Object handle, Long id) {
		Session session = (Session) handle;
		return (CertificateRequestDetail) session.get(CertificateRequestDetail.class, id);
	}

	public List getCertificateRequestByExporterId(Object handle, String exporterId) {
		CertificateRequestCriteria c = new CertificateRequestCriteria();
		c.setExporterId(exporterId);
		
		return getCertificateRequestByCriteria(handle, c);
	}
	
	public List getCertificateRequestByCriteria(Object handle, CertificateRequestCriteria criteria) {
		Session session = (Session) handle;
		Criteria c = session.createCriteria(CertificateRequest.class);
		c.addOrder(Order.asc(CertificateRequest.ID));
		
		String exporterId = criteria.getExporterId();
		if (exporterId != null) {
			Criteria exporterCriteria = c.createCriteria(CertificateRequest.EXPORTER);
			exporterCriteria.add(Restrictions.eq(Exporter.PROP_EXPORTER_ID, exporterId));
		}
		
		return c.list();
	}

	public List getCertificateRequestDetails(Object handle, CertificateRequestDetailCriteria criteria) {
		Session session = (Session) handle;
		
		Criteria c = session.createCriteria(CertificateRequestDetail.class);
		if (criteria.getCertificateRequestDetailId() != null) {
			c.add(Restrictions.eq(CertificateRequestDetail.PROP_ID, criteria.getCertificateRequestDetailId()));
		}
		
		return c.list();
	}


	public CertificateRequestDetail getCertificateRequestDetail(Object handle, Long certReqId, Long certTypeId) {
		logger.debug("Enter getCertificateRequestDetail.");
		Session session = (Session) handle;
		Criteria c = session.createCriteria(CertificateRequestDetail.class);
		c.add(Restrictions.eq(CertificateRequestDetail.PROP_CERTIFICATE_REQUEST_ID, certReqId));
		c.add(Restrictions.eq(CertificateRequestDetail.PROP_CERTIFICATE_TYPE_ID, certTypeId));
		logger.debug("Returning result.");
		return (CertificateRequestDetail) c.uniqueResult();
	}

}
