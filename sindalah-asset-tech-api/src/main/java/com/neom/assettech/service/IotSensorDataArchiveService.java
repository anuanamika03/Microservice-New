package com.neom.assettech.service;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.neom.assettech.model.IotSensorDataArchiveModel;
import com.neom.assettech.model.IotSensorDataModel;

@Service
public interface IotSensorDataArchiveService {
	
//	public IotSensorDataArchiveModel insertSensorData(IotSensorDataArchiveModel sensorData) throws Exception;
//	public IotSensorDataArchiveModel getLatestSensorDataByLocationId(Integer locationId) throws Exception;
//	public JsonNode getIotSenseDataFromNeomAPI() throws Exception;
//	public JsonNode getWeatherDataFromOpenWeatherMap(String latitude, String longitude) throws Exception;
//	public JsonNode getIotSenseDataFromLocal() throws Exception;
//	public JsonNode getForecastFromOpenWeatherMap(String latitude, String longitude) throws Exception;
//    public void deleteAllIotSensorData() throws Exception;


    public IotSensorDataArchiveModel insertOrUpdateForecast(IotSensorDataArchiveModel sensorData) throws Exception;
  
    public void deleteBycreatedOnBefore(Date expiryDate);
  
    public	void deleteAllIotSensorData() throws Exception;
	

}
