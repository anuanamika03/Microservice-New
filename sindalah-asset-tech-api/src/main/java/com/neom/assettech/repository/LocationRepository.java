package com.neom.assettech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.neom.assettech.model.LocationModel;

@Repository
public interface LocationRepository extends JpaRepository<LocationModel, Integer> {
	
	public LocationModel findByDeviceId(String deviceId) throws Exception;

}
