package com.neom.assettech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.neom.assettech.model.IotSensorDataModel;
import com.neom.assettech.model.WeatherDataHistoryModel;

@Repository
public interface WeatherDataHistoryRepository extends JpaRepository<WeatherDataHistoryModel, Integer>{

	
	@Query(value = "SELECT * FROM weatherdatahistory WHERE location_id = :locationId ORDER BY 1 DESC LIMIT 1", nativeQuery = true)
	public WeatherDataHistoryModel getLatestSensorDataByLocationId(@Param("locationId") Integer locationId) throws Exception;

}
