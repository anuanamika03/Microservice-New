
package com.neom.assettech.serviceimpl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.neom.assettech.constants.AppConstants;
import com.neom.assettech.model.IotSensorDataModel;
import com.neom.assettech.repository.IotSensorDataRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.core.env.Environment;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
public class IotSensorDataServiceImplTest {
    @Mock
    RestTemplate restTemplate;
    @Mock
    private IotSensorDataRepository iotSensorDataRepository;
    @InjectMocks
    private IotSensorDataServiceImpl iotSensorDataServiceImpl;

    private IotSensorDataModel iotSensorDataModel;
    @Mock
    private Environment env;
    @Mock
    private ObjectMapper objectMapper;

    @Mock
    private JsonNode jsonNode;


    @Before
    public void setUp() {
        iotSensorDataModel = new IotSensorDataModel();
        iotSensorDataModel.setSensorDataId(1);
        iotSensorDataModel.setLocationId(1);
        iotSensorDataModel.setAqi(40.0);
        iotSensorDataModel.setHumidity(34.0);
        iotSensorDataModel.setTemperature(26.0);
        iotSensorDataModel.setPressure(1004.0);
        iotSensorDataModel.setWindSpeed(6.0);
        iotSensorDataModel.setDatatimestamp(new Date());
        iotSensorDataModel.setRainChance(20.0);
        iotSensorDataModel.setUvIndex(2.33);
        iotSensorDataModel.setAQIinterpretlabel("Good");

    }

    @Test
    public void testInsertSensorData_positive() throws Exception {
        when(iotSensorDataRepository.saveAndFlush(any(IotSensorDataModel.class)))
                .thenReturn(iotSensorDataModel);
        IotSensorDataModel result = iotSensorDataServiceImpl
                .insertSensorData(iotSensorDataModel);

        assertEquals(iotSensorDataModel.getAqi(), result.getAqi());
        assertEquals(iotSensorDataModel.getHumidity(), result.getHumidity());
        assertEquals(iotSensorDataModel.getPressure(), result.getPressure());
        verify(iotSensorDataRepository, times(1)).saveAndFlush(any(IotSensorDataModel.class));

    }

    @Test
    public void testInsertSensorData_Negative() throws Exception {
        when(iotSensorDataRepository.saveAndFlush(any(IotSensorDataModel.class)))
                .thenReturn(null);

        IotSensorDataModel result = iotSensorDataServiceImpl
                .insertSensorData(iotSensorDataModel);

        assertNotEquals(iotSensorDataModel, result);
        verify(iotSensorDataRepository, times(1)).saveAndFlush(any(IotSensorDataModel.class));
    }

    @Test
    public void testGetLatestSensorDataByLocationId_Success() throws Exception {

        IotSensorDataModel sensorData = new IotSensorDataModel();
        sensorData.setLocationId(1);
        sensorData.setAqi(50.0);
        sensorData.setDatatimestamp(new Date());
        sensorData.setCreatedOn(new Date());


        Mockito.when(iotSensorDataRepository.getLatestSensorDataByLocationId(1)).thenReturn(sensorData);
        Mockito.when(env.getProperty(AppConstants.IOTSENSE_MSG_AQILABEL_100)).thenReturn("Good");

        IotSensorDataModel result = iotSensorDataServiceImpl.getLatestSensorDataByLocationId(1);

        assertEquals("Good", result.getAQIinterpretlabel());
    }

    @Test
    public void testGetLatestSensorDataByLocationId_negative() throws Exception {
        Mockito.when(iotSensorDataRepository.getLatestSensorDataByLocationId(1)).thenThrow(new Exception("No data found"));
        try {
            iotSensorDataServiceImpl.getLatestSensorDataByLocationId(1);
        } catch (Exception e) {
            assertEquals("No data found", e.getMessage());
        }
    }

    @Test
    public void testGetForecastFromOpenWeatherMap_Positive() throws Exception {
        // Given
        String latitude = "34.05";
        String longitude = "-118.24";
        String expectedResponse = "{\"cod\":\"200\",\"message\":0.0047,\"cnt\":40,\"list\":[{\"dt\":1572537200,\"main\":{\"temp\":298.14,\"feels_like\":296.06,\"temp_min\":298.14,\"temp_max\":298.14,\"pressure\":1021,\"sea_level\":1021,\"grnd_level\":1005,\"humidity\":100,\"temp_kf\":0},\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04n\"}],\"clouds\":{\"all\":100},\"wind\":{\"speed\":1.02,\"deg\":66},\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2019-11-02 03:00:00\"}]}";
        JsonNode expectedJson = new ObjectMapper().readValue(expectedResponse, JsonNode.class);
        when(restTemplate.getForObject(String.format(AppConstants.WEATHER_FORECAST_URL, latitude,
                longitude, env.getProperty(AppConstants.WEATHER_API_PROPERTY_KEY)), String.class))
                .thenReturn(expectedResponse);


        JsonNode result = iotSensorDataServiceImpl.getForecastFromOpenWeatherMap(latitude, longitude);


        assertEquals(expectedJson, result);
    }

    @Test
    public void testGetForecastFromOpenWeatherMap_Negative() throws Exception {
        // Given
        String latitude = "34.05";
        String longitude = "-118.24";
        String expectedResponse = "{\"cod\":\"404\",\"message\":\"city not found\"}";
        JsonNode expectedJson = new ObjectMapper().readValue(expectedResponse, JsonNode.class);
        when(restTemplate.getForObject(String.format(AppConstants.WEATHER_FORECAST_URL, latitude,
                longitude, env.getProperty(AppConstants.WEATHER_API_PROPERTY_KEY)), String.class))
                .thenReturn(expectedResponse);
        JsonNode result = iotSensorDataServiceImpl.getForecastFromOpenWeatherMap(latitude, longitude);
        assertEquals(expectedJson, result);
    }

    @Test
    public void testDeleteAllIotSensorData_Positive() throws Exception {

        IotSensorDataModel iotSensorDataModel = new IotSensorDataModel();
        iotSensorDataRepository.save(iotSensorDataModel);

        iotSensorDataServiceImpl.deleteAllIotSensorData();
        List<IotSensorDataModel> result = iotSensorDataRepository.findAll();
        assertTrue(result.isEmpty());
    }

    @Test
    public void testDeleteAllIotSensorData_Negative() throws Exception {

        doNothing().when(iotSensorDataRepository).deleteAll();
        iotSensorDataServiceImpl.deleteAllIotSensorData();
        verify(iotSensorDataRepository, times(1)).deleteAll();
    }
 @Test
  public  void getIotSenseDataFromNeomAPI() throws Exception {

        ResponseEntity<String> response = new ResponseEntity<>("{\"Test\":\"JsonRespnose\",\"access_token\":\"TEST\"}", HttpStatus.ACCEPTED);
        Mockito.when(restTemplate.exchange(any(String.class), any(HttpMethod.class), any(HttpEntity.class), any(Class.class))).thenReturn(response);
        JsonNode result = iotSensorDataServiceImpl.getIotSenseDataFromNeomAPI();
        assertNotNull(result);
        assertEquals(HttpStatus.ACCEPTED, response.getStatusCode());
        assertEquals("{\"Test\":\"JsonRespnose\",\"access_token\":\"TEST\"}", result.toString());

    }

    @Test
    public void testgetToken() throws NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException, IllegalAccessException {
        Method method = IotSensorDataServiceImpl.class.getDeclaredMethod("getToken");
        method.setAccessible(true);
        ResponseEntity<String> response = new ResponseEntity<>("{\"Test\":\"JsonRespnose\",\"access_token\":\"TEST\"}", HttpStatus.ACCEPTED);
        Mockito.when(restTemplate.exchange(any(String.class), any(HttpMethod.class), any(HttpEntity.class), any(Class.class))).thenReturn(response);
        Object ob = method.invoke(iotSensorDataServiceImpl);
        assertEquals(HttpStatus.ACCEPTED, response.getStatusCode());
        assertEquals("TEST", ob.toString(), "Expected Access Token");

    }
}


