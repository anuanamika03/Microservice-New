package com.neom.assettech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.neom.assettech.model.WeatherForecastModel;

@Repository
public interface WeatherForecastRepository extends JpaRepository<WeatherForecastModel, Integer> {
	
	public WeatherForecastModel findByLocationId(Integer locationId) throws Exception;

}
