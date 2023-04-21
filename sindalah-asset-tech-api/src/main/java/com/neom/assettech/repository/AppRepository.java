package com.neom.assettech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.neom.assettech.model.AppModel;

@Repository
public interface AppRepository extends  JpaRepository<AppModel, Integer> {
	
	List<AppModel> findAll();

}
