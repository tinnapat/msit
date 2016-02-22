package com.export.dao;

import java.util.List;

import com.export.criteria.CertificateRequestDetailCriteria;
import com.export.domain.CertificateRequest;
import com.export.domain.CertificateRequestDetail;

public interface CertificateRequestDAO {
	
	public CertificateRequest getCertificateRequestById(Object handle, Long crId);
	
	public List getCertificateRequestByExporterId(Object handle, String exporterId);
	
	public CertificateRequestDetail getCertificateRequestDetailById(Object handle, Long id);
	
	/**
	 * Get CertificateRequestDetail information with given <code>certificate request id</code> and <code>certificate type id</code>
	 * @param handle Session handle.
	 * @param certReqId Certificate request id.
	 * @param certTypeId Certificate type id.
	 * @return
	 */
	public CertificateRequestDetail getCertificateRequestDetail(Object handle, Long certReqId, Long certTypeId);
	
	public List getCertificateRequestDetails(Object handle, CertificateRequestDetailCriteria criteria);

}
