package com.neom.assettech.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neom.assettech.model.AuditLogModel;
import com.neom.assettech.model.LocationModel;
import com.neom.assettech.repository.AuditRepository;
import com.neom.assettech.service.AuditService;

@Service
public class AuditServiceimpl implements AuditService {

	@Autowired
	AuditRepository auditrepository;
	@Override
	public List<AuditLogModel> findAll() {
		
		return auditrepository.findAll();
		
	}
	@Override
	public AuditLogModel createAuditLog(AuditLogModel auditlog) throws Exception {
		// TODO Auto-generated method stub
		return auditrepository.saveAndFlush(auditlog);
	}

}
