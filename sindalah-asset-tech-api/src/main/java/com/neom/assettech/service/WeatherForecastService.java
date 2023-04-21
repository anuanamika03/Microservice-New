package com.neom.assettech.service;

import org.springframework.stereotype.Service;

import com.neom.assettech.model.WeatherForecastModel;

@Service
public interface WeatherForecastService {
	
	public WeatherForecastModel insertOrUpdateForecast(WeatherForecastModel forecast) throws Exception;
	public WeatherForecastModel getForcastByLocationId(Integer locationId) throws Exception;

}
