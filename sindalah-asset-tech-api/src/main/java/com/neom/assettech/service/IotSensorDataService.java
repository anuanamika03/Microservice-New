package com.neom.assettech.service;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.neom.assettech.model.IotSensorDataModel;

@Service
public interface IotSensorDataService {
	
	public IotSensorDataModel insertSensorData(IotSensorDataModel sensorData) throws Exception;
	public IotSensorDataModel getLatestSensorDataByLocationId(Integer locationId) throws Exception;
	public JsonNode getIotSenseDataFromNeomAPI() throws Exception;
	public JsonNode getWeatherDataFromOpenWeatherMap(String latitude, String longitude) throws Exception;
	public JsonNode getIotSenseDataFromLocal() throws Exception;
	public JsonNode getForecastFromOpenWeatherMap(String latitude, String longitude) throws Exception;
	public void deleteAllIotSensorData() throws Exception;

}
