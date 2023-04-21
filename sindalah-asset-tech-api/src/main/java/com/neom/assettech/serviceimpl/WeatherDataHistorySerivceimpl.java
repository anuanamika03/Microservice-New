package com.neom.assettech.serviceimpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.neom.assettech.constants.AppConstants;
import com.neom.assettech.model.WeatherDataHistoryModel;
import com.neom.assettech.repository.WeatherDataHistoryRepository;
import com.neom.assettech.service.WeatherDataHistoryService;
@Service
public class WeatherDataHistorySerivceimpl implements WeatherDataHistoryService {
	
	@Autowired
	 WeatherDataHistoryRepository  weatherDataHistoryRepository;
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private Environment env;
	
	/*@Override
	public JsonNode getWeatherDataFromOpenWeatherMap(String latitude, String longitude) throws Exception {
		
			System.out.println("Fetching data from Open Weather Map APIs -> " + new Date());
			String response = restTemplate.getForObject(String.format(AppConstants.WEATHER_URL, latitude, longitude,
					env.getProperty(AppConstants.WEATHER_API_PROPERTY_KEY)), String.class);
			ObjectMapper mapper = new ObjectMapper();
			JsonNode rootNode = mapper.readValue(response, JsonNode.class);
			return rootNode;
	}*/

	@Override
	public WeatherDataHistoryModel insertWeatherData(WeatherDataHistoryModel WeatherData) throws Exception {
		
		return weatherDataHistoryRepository.saveAndFlush(WeatherData);
	}

	@Override
	public JsonNode getWeatherDataFromNeomAPI() throws Exception {
		System.out.println("Fetching Weather data from Neom IOT Sense APIs -> " + new Date());
		HttpHeaders headers = new HttpHeaders();
		//headers.add("Authorization", "Bearer " + getToken());
		HttpEntity<String> entity = new HttpEntity<>(null, headers);
		ResponseEntity<String> response = restTemplate.exchange(AppConstants.NEOM_IOT_WEATHER_API_URL, HttpMethod.GET, entity, String.class);
		ObjectMapper mapper = new ObjectMapper();
		JsonNode rootNode = mapper.readValue(response.getBody(), JsonNode.class);
		return rootNode ;
	}

	@Override
		
		public JsonNode getWeatherDataHistoryFromOpenWeatherMap(String latitude, String longitude) throws Exception {
			System.out.println("Fetching data from Open Weather Map APIs -> " + new Date());
			String response = restTemplate.getForObject(String.format(AppConstants.WEATHER_URL, latitude, longitude,
					env.getProperty(AppConstants.WEATHER_API_PROPERTY_KEY)), String.class);
			ObjectMapper mapper = new ObjectMapper();
			JsonNode rootNode = mapper.readValue(response, JsonNode.class);
			return rootNode;
	}

	@Override
	public List<WeatherDataHistoryModel> findAll() {
		
		return weatherDataHistoryRepository.findAll();
	}

	@Override
	public void addweatherdatahistory(WeatherDataHistoryModel weatherDataHistoryModel) {
		weatherDataHistoryRepository.save(weatherDataHistoryModel);
		
	}

	@Override
	public WeatherDataHistoryModel getLatestSensorDataByLocationId(Integer locationId) throws Exception {
		
		return weatherDataHistoryRepository.getLatestSensorDataByLocationId(locationId);
	}

	@Override
	public void deleteAllWeatherDataHistory(Date expiryDate) throws Exception {
		weatherDataHistoryRepository.deleteAll();
		
	}
	

}
