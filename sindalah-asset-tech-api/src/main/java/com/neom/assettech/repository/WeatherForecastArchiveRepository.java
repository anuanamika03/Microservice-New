package com.neom.assettech.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import com.neom.assettech.model.WeatherForecastArchiveModel;
import com.neom.assettech.model.WeatherForecastModel;

@Repository
public interface WeatherForecastArchiveRepository extends JpaRepository<WeatherForecastArchiveModel, Integer> {
	
//	public WeatherForecastArchiveModel findByLocationId(Integer locationId) throws Exception;

	@Modifying
    public void deleteBycreatedOnBefore(Date expiryDate);

}
