package com.neom.assettech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.neom.assettech.model.IotSensorDataModel;

@Repository
public interface IotSensorDataRepository extends JpaRepository<IotSensorDataModel, Integer> {
	
	@Query(value = "SELECT * FROM iot_sensor_data WHERE location_id = :locationId ORDER BY 1 DESC LIMIT 1", nativeQuery = true)
	public IotSensorDataModel getLatestSensorDataByLocationId(@Param("locationId") Integer locationId) throws Exception;

}
