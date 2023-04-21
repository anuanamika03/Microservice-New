package com.neom.assettech.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.neom.assettech.model.WeatherThersholdModel;
@Service
public interface WeatherThersholdService {

	public List<WeatherThersholdModel> findAll();

	public void addweatherthershold(WeatherThersholdModel weatherthersholdmodel) throws Exception;
	
	public WeatherThersholdModel getActiveThersholds();
}
