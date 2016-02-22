package com.export.business;

import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;

import com.export.dao.CertificateRequestDAO;
import com.export.dao.ExporterDAO;
import com.export.dao.hibernate.CertificateRequestDAOHibernate;
import com.export.dao.hibernate.ExporterDAOHibernate;
import com.export.domain.CertificateRequestDetail;
import com.export.domain.ExporterCertificateStatus;
import com.export.framework.hibernate.HibernateSession;
import com.export.vo.CRDetailUpdateMsg;
import com.export.vo.ExporterCertificateUpdateMsg;
import com.export.vo.ShipmentCertificateUpdateMsg;

public class SingleWindowService {
	
	private static Log logger = LogFactory.getLog(SingleWindowService.class);
	
	private static CertificateRequestDAO crDAO 	= new CertificateRequestDAOHibernate();
	private static ExporterDAO exporterDAO		= new ExporterDAOHibernate();
	
	public void updateCRDetailStatus(CRDetailUpdateMsg vo) {
		Session session = HibernateSession.currentSession();
		
		CertificateRequestDetail detail = crDAO.getCertificateRequestDetailById(session, new Long(vo.getCrDetaiId()));
		if (detail == null) {
			throw new RuntimeException("Certificate Request Detail ID not found!!");
		}
		
	}
	
	public void updateExporterCertificate(ExporterCertificateUpdateMsg vo) {
		logger.debug("Enter updateExporterCertificate()");
		
		Session session = HibernateSession.currentSession();
		logger.debug("Hibernate session: " + session);
		session.beginTransaction();
		logger.debug("Transaction begin.");
		
		String exporterId = vo.getExporterId();
		String certTypeCode = vo.getCertificateTypeCode();
		
		ExporterCertificateStatus status = exporterDAO.getExporterCertStatus(session, exporterId, Long.valueOf(certTypeCode));
		logger.debug("Retrieve exporter certificate status: " + status);
		if (status == null) {
			throw new RuntimeException("Specified certificate not found.");
		}
		
		status.setStatusCode(vo.getStatusCode());
		status.setSignature(vo.getSignature());
		status.setIssueBy(vo.getIssueBy());
		status.setIssueDate(vo.getIssueDate());
		status.setExpireDate(vo.getExpireDate());
		
		status.setModifyDate(new Date());
		
		session.getTransaction().commit();
		logger.debug("Exit updateExporterCertificate()");
	}
	
	public void updateShipmentCertificate(ShipmentCertificateUpdateMsg vo) {
		logger.debug("Enter updateShipmentCertificate()");
		logger.debug("vo: " + vo);
		
		Session session = HibernateSession.currentSession();
		logger.debug("Hibernate session: " + session);
		session.beginTransaction();
		logger.debug("Transaction begin.");
		
		String certificateRequestId = vo.getCertificateRequestId();
		String certTypeId = vo.getCertificateTypeId();
		
		logger.debug("Retrieveing shipment certificate status.");
		CertificateRequestDetail status = crDAO.getCertificateRequestDetail(session, Long.valueOf(certificateRequestId), Long.valueOf(certTypeId));

		/*
		Criteria c = session.createCriteria(CertificateRequestDetail.class);
		c.add(Restrictions.eq(CertificateRequestDetail.PROP_CERTIFICATE_REQUEST_ID, Long.valueOf(certificateRequestId)));
		c.add(Restrictions.eq(CertificateRequestDetail.PROP_CERTIFICATE_TYPE_ID, Long.valueOf(certTypeId)));
		CertificateRequestDetail status = (CertificateRequestDetail) c.uniqueResult();
		*/

		logger.debug("Retrieve shipment certificate status: " + status);
		if (status == null) {
			throw new RuntimeException("Specified shipment certificate not found.");
		}
		
		status.setStatusCode(vo.getStatusCode());
		status.setSignature(vo.getSignature());
		status.setIssueBy(vo.getIssueBy());
		status.setIssueDate(vo.getIssueDate());
		status.setExpireDate(vo.getExpireDate());
		
		status.setModifyDate(new Date());
		
		session.getTransaction().commit();
		logger.debug("Exit updateShipmentCertificate()");
	}
	
}
