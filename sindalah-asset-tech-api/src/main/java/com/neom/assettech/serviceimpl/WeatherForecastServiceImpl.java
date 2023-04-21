package com.neom.assettech.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.neom.assettech.model.WeatherForecastModel;
import com.neom.assettech.repository.WeatherForecastRepository;
import com.neom.assettech.service.WeatherForecastService;

@Service
public class WeatherForecastServiceImpl implements WeatherForecastService {

	@Autowired
	private WeatherForecastRepository weatherForecastRepository;
	
	@Override
	public WeatherForecastModel insertOrUpdateForecast(WeatherForecastModel forecast) throws Exception {
		WeatherForecastModel existingData = weatherForecastRepository.findByLocationId(forecast.getLocationId());
		if(null != existingData && null != existingData.getForecastId() && !existingData.getForecastId().equals(0)) {
			existingData.setWeatherForecast(forecast.getWeatherForecast());
			return weatherForecastRepository.saveAndFlush(existingData);
		} else {
			return weatherForecastRepository.saveAndFlush(forecast);
		}
	}

	@Override
	public WeatherForecastModel getForcastByLocationId(Integer locationId) throws Exception {
		WeatherForecastModel forecast = weatherForecastRepository.findByLocationId(locationId);
		forecast.setWeatherForecast(new ObjectMapper().readTree(forecast.getWeatherForecastInternal()));
		return forecast;
	}

}
