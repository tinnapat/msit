package com.export.dao;

import java.util.List;

import com.export.domain.CertificateType;

public interface CertificateTypeDAO {
	
	public CertificateType getCertificateType(Object handle, Long id);
	
	public List getAllCertificateTypes(Object handle);
	
	public List getAllExporterCertificateTypes(Object handle);

}
