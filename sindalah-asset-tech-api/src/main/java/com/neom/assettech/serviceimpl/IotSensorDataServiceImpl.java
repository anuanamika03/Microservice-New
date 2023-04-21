package com.neom.assettech.serviceimpl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.neom.assettech.constants.AppConstants;
import com.neom.assettech.model.IotSensorDataModel;
import com.neom.assettech.repository.IotSensorDataRepository;
import com.neom.assettech.service.IotSensorDataService;

@Service
public class IotSensorDataServiceImpl implements IotSensorDataService {

	@Autowired
	private IotSensorDataRepository iotSensorDataRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private Environment env;
	
	@Override
	public IotSensorDataModel insertSensorData(IotSensorDataModel sensorData) throws Exception {
		return iotSensorDataRepository.saveAndFlush(sensorData);
	}

	@Override
	public IotSensorDataModel getLatestSensorDataByLocationId(Integer locationId) throws Exception {
	
		
		IotSensorDataModel model=iotSensorDataRepository.getLatestSensorDataByLocationId(locationId);
		if(model.getAqi()<100) {
			model.setAQIinterpretlabel(env.getProperty(AppConstants.IOTSENSE_MSG_AQILABEL_100));
		}
		else if(model.getAqi()<200){
			
			model.setAQIinterpretlabel(env.getProperty(AppConstants.IOTSENSE_MSG_AQILABEL_200));
		}
        else if(model.getAqi()>=200){
			
			model.setAQIinterpretlabel(env.getProperty(AppConstants.IOTSENSE_MSG_AQILABEL_300));
		}
		
		
		model.setCreatedOn(model.getDatatimestamp());
		return model;
		
	}

	@Override
	public JsonNode getIotSenseDataFromNeomAPI() throws Exception {
		System.out.println("Fetching data from Neom IOT Sense APIs -> " + new Date());
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Bearer " + getToken());
		HttpEntity<String> entity = new HttpEntity<>(null, headers);
		ResponseEntity<String> response = restTemplate.exchange(AppConstants.NEOM_IOT_WEATHER_API_URL, HttpMethod.GET, entity, String.class);
		ObjectMapper mapper = new ObjectMapper();
		JsonNode rootNode = mapper.readValue(response.getBody(), JsonNode.class);
		return rootNode;
	}
	
	private String getToken() throws Exception {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
		map.add("scope", AppConstants.NEOM_SCOPE);
		map.add("grant_type", AppConstants.NEOM_GRANT_TYPE);
		map.add("client_secret", env.getProperty(AppConstants.NEOM_CLIENT_SECRET_KEY));
		map.add("client_id", env.getProperty(AppConstants.NEOM_CLIENT_ID_KEY));
		HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(map, headers);
		ResponseEntity<String> response = restTemplate.exchange(AppConstants.NEOM_IOT_LOGIN_API_URL, HttpMethod.POST, entity, String.class);
		ObjectMapper mapper = new ObjectMapper();
		JsonNode rootNode = mapper.readValue(response.getBody(), JsonNode.class);
		return rootNode.get("access_token").asText();
	}

	@Override
	public JsonNode getWeatherDataFromOpenWeatherMap(String latitude, String longitude) throws Exception {
		System.out.println("Fetching data from Open Weather Map APIs -> " + new Date());
		String response = restTemplate.getForObject(String.format(AppConstants.WEATHER_URL, latitude, longitude,
				env.getProperty(AppConstants.WEATHER_API_PROPERTY_KEY)), String.class);
		ObjectMapper mapper = new ObjectMapper();
		JsonNode rootNode = mapper.readValue(response, JsonNode.class);
		return rootNode;
	}
	
	@Override
	public JsonNode getIotSenseDataFromLocal() throws Exception {
		System.out.println("Fetching data from locally deployed open sense API -> " + new Date());
		String response = restTemplate.getForObject("http://150.230.242.158:8080/iotsense/getIotSensorData", String.class);
		ObjectMapper mapper = new ObjectMapper();
		JsonNode rootNode = mapper.readValue(response, JsonNode.class);
		return rootNode;
	}

	@Override
	public JsonNode getForecastFromOpenWeatherMap(String latitude, String longitude) throws Exception {
		String response = restTemplate.getForObject(String.format(AppConstants.WEATHER_FORECAST_URL, latitude,
				longitude, env.getProperty(AppConstants.WEATHER_API_PROPERTY_KEY)), String.class);
		ObjectMapper mapper = new ObjectMapper();
		JsonNode rootNode = mapper.readValue(response, JsonNode.class);
		return rootNode;
	}

	@Override
	public void deleteAllIotSensorData() throws Exception {
		iotSensorDataRepository.deleteAll();
	}

}
