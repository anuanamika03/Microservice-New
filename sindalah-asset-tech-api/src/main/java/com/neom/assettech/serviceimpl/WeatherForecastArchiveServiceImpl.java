package com.neom.assettech.serviceimpl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.neom.assettech.model.WeatherForecastArchiveModel;
import com.neom.assettech.model.WeatherForecastModel;
import com.neom.assettech.repository.WeatherForecastArchiveRepository;
import com.neom.assettech.repository.WeatherForecastRepository;
import com.neom.assettech.service.WeatherForecastArchiveService;
import com.neom.assettech.service.WeatherForecastService;

@Service
public class WeatherForecastArchiveServiceImpl implements WeatherForecastArchiveService {

	@Autowired
	private WeatherForecastArchiveRepository weatherForecastArchiveRepository;


	@Override
	public WeatherForecastArchiveModel insertOrUpdateForecast(WeatherForecastArchiveModel sensorData) 
	{
		return weatherForecastArchiveRepository.saveAndFlush(sensorData);		
	}

	@Override
	public void deleteBycreatedOnBefore(Date expiryDate) throws Exception {
		weatherForecastArchiveRepository.deleteBycreatedOnBefore(expiryDate);	
		
	}
	
	

}
