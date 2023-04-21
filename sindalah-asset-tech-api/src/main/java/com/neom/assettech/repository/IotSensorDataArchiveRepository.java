package com.neom.assettech.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.neom.assettech.model.IotSensorDataArchiveModel;
import com.neom.assettech.model.IotSensorDataModel;

@Repository
public interface IotSensorDataArchiveRepository extends JpaRepository<IotSensorDataArchiveModel, Integer> {
	
//	@Query(value = "SELECT * FROM iot_sensor_data_archive WHERE location_id = :locationId ORDER BY 1 DESC LIMIT 1", nativeQuery = true)
//	public IotSensorDataArchiveModel getLatestSensorDataByLocationId(@Param("locationId") Integer locationId) throws Exception;

	@Modifying
    public void deleteBycreatedOnBefore(Date expiryDate);
}
