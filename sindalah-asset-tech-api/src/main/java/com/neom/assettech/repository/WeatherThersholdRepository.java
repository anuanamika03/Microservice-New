package com.neom.assettech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.neom.assettech.model.NotificationModel;
import com.neom.assettech.model.WeatherThersholdModel;

@Repository
public interface WeatherThersholdRepository extends JpaRepository<WeatherThersholdModel, Integer>{

	List<WeatherThersholdModel> findAll();
	@Query(value = "select *  from weatherthershold where Is_active=true order by weather_thershold_id desc Limit 1 ", nativeQuery = true)
	public WeatherThersholdModel getActiveThersholds();
}

