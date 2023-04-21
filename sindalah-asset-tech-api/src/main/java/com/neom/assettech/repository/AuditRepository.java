package com.neom.assettech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.neom.assettech.model.AuditLogModel;
@Repository
public interface AuditRepository extends JpaRepository<AuditLogModel, Integer> {
	
	List<AuditLogModel> findAll();

}
