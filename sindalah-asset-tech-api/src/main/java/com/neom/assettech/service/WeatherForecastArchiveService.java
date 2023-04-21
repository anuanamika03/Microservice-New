package com.neom.assettech.service;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.neom.assettech.model.WeatherForecastArchiveModel;
import com.neom.assettech.model.WeatherForecastModel;

@Service
public interface WeatherForecastArchiveService {
	
//	public WeatherForecastArchiveModel insertOrUpdateForecast(WeatherForecastArchiveModel weatherforecastarchiveId) throws Exception;
//	public WeatherForecastArchiveModel getForcastByLocationId(Integer locationId) throws Exception;

	public WeatherForecastArchiveModel insertOrUpdateForecast(WeatherForecastArchiveModel sensorData);

	public void deleteBycreatedOnBefore(Date expiryDate) throws Exception;
}
