package com.neom.assettech.serviceimpl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.neom.assettech.constants.AppConstants;
import com.neom.assettech.model.WeatherDataHistoryModel;
import com.neom.assettech.repository.WeatherDataHistoryRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class WeatherDataHistoryServiceImplTest {


    @InjectMocks
    WeatherDataHistorySerivceimpl weatherDataHistorySerivceimpl;

    @Mock
    WeatherDataHistoryRepository weatherDataHistoryRepository;
    Date date;
    private WeatherDataHistoryModel weatherDataHistoryModel;
    @Mock
    private RestTemplate restTemplate;
    @Mock
    private Environment env;

    @Before
    public void setup() {

        weatherDataHistoryModel = new WeatherDataHistoryModel();
        weatherDataHistoryModel.setLocationId(1);
        weatherDataHistoryModel.setAqi(60.0);
        weatherDataHistoryModel.setTemperature(20.0);
        weatherDataHistoryModel.setHumidity(40.0);
        weatherDataHistoryModel.setPressure(1002.0);
        weatherDataHistoryModel.setRainChance(20.0);
        weatherDataHistoryModel.setUvIndex(2.3);
        weatherDataHistoryModel.setWindSpeed(3.0);
        weatherDataHistoryModel.setTimestamp(new Date());

    }

    @Test
    public void testInsertWeatherData_positive() throws Exception {
        when(weatherDataHistoryRepository.saveAndFlush(any(WeatherDataHistoryModel.class)))
                .thenReturn(weatherDataHistoryModel);
        WeatherDataHistoryModel result = weatherDataHistorySerivceimpl
                .insertWeatherData(weatherDataHistoryModel);
        assertEquals(weatherDataHistoryModel.getAqi(), result.getAqi());
        assertEquals(weatherDataHistoryModel.getTemperature(), result.getTemperature());
        assertEquals(weatherDataHistoryModel.getHumidity(), result.getHumidity());
        verify(weatherDataHistoryRepository, times(1)).saveAndFlush(any(WeatherDataHistoryModel.class));

    }

    @Test
    public void testInsertOrUpdateForecast_Negative() throws Exception {
        when(weatherDataHistoryRepository.saveAndFlush(any(WeatherDataHistoryModel.class)))
                .thenReturn(null);

        WeatherDataHistoryModel result = weatherDataHistorySerivceimpl
                .insertWeatherData(weatherDataHistoryModel);

        assertNotEquals(weatherDataHistoryModel, result);
        verify(weatherDataHistoryRepository, times(1)).saveAndFlush(any(WeatherDataHistoryModel.class));
    }

    @Test
    public void testGetLatestSensorDataByLocationId_Positive() throws Exception {
        WeatherDataHistoryModel expectedWeatherData = new WeatherDataHistoryModel();
        expectedWeatherData.setLocationId(1);
        when(weatherDataHistoryRepository.getLatestSensorDataByLocationId(1)).thenReturn(expectedWeatherData);

        WeatherDataHistoryModel actualWeatherData = weatherDataHistorySerivceimpl.getLatestSensorDataByLocationId(1);

        assertEquals(expectedWeatherData, actualWeatherData);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetLatestSensorDataByLocationId_Negative() throws Exception {

        int invalidLocationId = -1;
        when(weatherDataHistoryRepository.getLatestSensorDataByLocationId(invalidLocationId))
                .thenThrow(new IllegalArgumentException("Invalid location id"));
        weatherDataHistorySerivceimpl.getLatestSensorDataByLocationId(invalidLocationId);
    }
    @Test
    public void testAddweatherdatahistory() {

        weatherDataHistorySerivceimpl.addweatherdatahistory(any());
        Mockito.verify(weatherDataHistoryRepository, Mockito.times(1)).save(any());
    }

    @Test
    public void testDeleteAllWeatherDataHistory_positive() throws Exception {

        weatherDataHistorySerivceimpl.deleteAllWeatherDataHistory(date);
        Assert.assertEquals(0, weatherDataHistoryRepository.findAll().size());
    }

    @Test
    public void testDeleteAllWeatherDataHistory_Failure() throws Exception {
        doNothing().when(weatherDataHistoryRepository).deleteAll();
        weatherDataHistorySerivceimpl.deleteAllWeatherDataHistory(date);
        verify(weatherDataHistoryRepository, times(1)).deleteAll();

    }

    @Test
    public void testGetWeatherDataFromNeomAPI_Positive() throws Exception {
        // Mock RestTemplate response
        String mockResponse = "{ \"temperature\": 25, \"humidity\": 50 }";
        when(restTemplate.exchange(anyString(), eq(HttpMethod.GET), any(), eq(String.class)))
                .thenReturn(new ResponseEntity<>(mockResponse, HttpStatus.OK));
        JsonNode result = weatherDataHistorySerivceimpl.getWeatherDataFromNeomAPI();
        assertNotNull(result.get("temperature"));
        assertEquals(25, result.get("temperature").asInt());
        assertNotNull(result.get("humidity"));
        assertEquals(50, result.get("humidity").asInt());
    }


    @Test(expected = Exception.class)
    public void testGetWeatherDataFromNeomAPI_Negative() throws Exception {

        when(restTemplate.exchange(anyString(), eq(HttpMethod.GET), any(), eq(String.class)))
                .thenThrow(new RestClientException("Error"));

        weatherDataHistorySerivceimpl.getWeatherDataFromNeomAPI();
    }

    @Test
    public void testGetWeatherDataHistoryFromOpenWeatherMap_Positive() throws Exception {
        // Given
        String expectedResponse = "{\"coord\":{\"lon\":-122.08,\"lat\":37.39},\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"clear sky\",\"icon\":\"01d\"}],\"base\":\"stations\",\"main\":{\"temp\":282.55,\"feels_like\":281.86,\"temp_min\":280.37,\"temp_max\":284.26,\"pressure\":1023,\"humidity\":100},\"visibility\":16093,\"wind\":{\"speed\":1.5,\"deg\":350},\"clouds\":{\"all\":1},\"dt\":1560350645,\"sys\":{\"type\":1,\"id\":5122,\"message\":0.0139,\"country\":\"US\",\"sunrise\":1560343627,\"sunset\":1560396563},\"timezone\":-25200,\"id\":420006353,\"name\":\"Mountain View\",\"cod\":200}";
        String expectedLatitude = "37.39";
        String expectedLongitude = "-122.08";
        when(restTemplate.getForObject(String.format(AppConstants.WEATHER_URL, expectedLatitude, expectedLongitude,
                env.getProperty(AppConstants.WEATHER_API_PROPERTY_KEY)), String.class)).thenReturn(expectedResponse);
        ObjectMapper mapper = new ObjectMapper();
        JsonNode expectedJsonNode = mapper.readTree(expectedResponse);

        // When
        JsonNode actualJsonNode = weatherDataHistorySerivceimpl.getWeatherDataHistoryFromOpenWeatherMap(expectedLatitude, expectedLongitude);

        // Then
        assertEquals(expectedJsonNode, actualJsonNode);
    }

    @Test
    public void testGetWeatherDataHistoryFromOpenWeatherMap_Negative() throws Exception {
        // Given
        String expectedLatitude = "invalidLatitude";
        String expectedLongitude = "invalidLongitude";
        when(restTemplate.getForObject(String.format(AppConstants.WEATHER_URL, expectedLatitude, expectedLongitude,
                env.getProperty(AppConstants.WEATHER_API_PROPERTY_KEY)), String.class)).thenThrow(new RestClientException("Invalid latitude and longitude"));

        // When, Then
        assertThrows(RestClientException.class, () -> weatherDataHistorySerivceimpl.getWeatherDataHistoryFromOpenWeatherMap(expectedLatitude, expectedLongitude));
    }


}

