package com.neom.assettech.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.neom.assettech.model.WeatherDataHistoryModel;

@Service
public interface WeatherDataHistoryService {
	public WeatherDataHistoryModel insertWeatherData(WeatherDataHistoryModel WeatherData) throws Exception;
	//public JsonNode getWeatherDataFromOpenWeatherMap() throws Exception;
	public JsonNode getWeatherDataFromNeomAPI() throws Exception;
	public WeatherDataHistoryModel getLatestSensorDataByLocationId(Integer locationId) throws Exception;
	public JsonNode getWeatherDataHistoryFromOpenWeatherMap(String latitude, String longitude) throws Exception;
    public List<WeatherDataHistoryModel> findAll();
	public void addweatherdatahistory(WeatherDataHistoryModel weatherDataHistoryModel);
	public void deleteAllWeatherDataHistory(Date today) throws Exception;
	}
