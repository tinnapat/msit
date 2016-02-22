package com.export.dao;

import java.util.List;

import com.export.domain.Exporter;
import com.export.domain.ExporterCertificateStatus;

public interface ExporterDAO {
	
	public String addExporter(Object handle, Exporter exporter);
	
	public Exporter getExporter(Object handle, String exporterId);
	public Exporter getExporterForUpdate(Object handle, String exporterId);
	public Exporter getExporterByIdAndPassword(Object handle, String exporterId, String password);
	
	public void updateExporter(Object session, Exporter exporter);
	
	/**
	 * Retrieve all certificate status of exporter with given <code>exporterId</code>
	 * @param handle Session handle.
	 * @param exporterId Exporter ID of exporter to retrieve certificate statuses.
	 * @return List of certificate statuses of given exporter.
	 */
	public List getExporterCertStatuses(Object handle, String exporterId);
	
	public ExporterCertificateStatus getExporterCertStatus(Object handle, String exporterId, Long certificateTypeId);
	
	/**
	 * Retrieve exporter certificate status information by certificate status id.
	 * @param handle
	 * @param exporterCertStatusId
	 * @return
	 */
	public ExporterCertificateStatus getExporterCertStatus(Object handle, Long exporterCertStatusId);
	
	public Long createExporterCertificateStatus(Object handle, ExporterCertificateStatus status);
	
}
