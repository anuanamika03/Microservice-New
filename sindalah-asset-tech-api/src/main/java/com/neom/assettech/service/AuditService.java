package com.neom.assettech.service;

import java.util.List;

import com.neom.assettech.model.AuditLogModel;
import com.neom.assettech.model.LocationModel;

public interface AuditService {

	public List<AuditLogModel> findAll();
	public AuditLogModel createAuditLog(AuditLogModel auditlog) throws Exception;
}
