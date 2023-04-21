package com.neom.assettech.serviceimpl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.neom.assettech.model.WeatherForecastModel;
import com.neom.assettech.repository.WeatherForecastRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class WeatherForecastServiceImplTest {

    @InjectMocks
    private WeatherForecastServiceImpl weatherForecastServiceImpl;

    @Mock
    private WeatherForecastRepository weatherForecastRepository;

    private WeatherForecastModel weatherForecastModel;

    @Before
    public void setup() {
        weatherForecastModel = new WeatherForecastModel();
        weatherForecastModel.setForecastId(1);
        weatherForecastModel.setWeatherForecastInternal("internal");
        weatherForecastModel.setLocationId(1);
    }

    @Test
    public void testInsertOrUpdateForecast_positive() throws Exception {
        when(weatherForecastRepository.saveAndFlush(any(WeatherForecastModel.class))).thenReturn(weatherForecastModel);
        WeatherForecastModel result = weatherForecastServiceImpl.insertOrUpdateForecast(weatherForecastModel);
        assertEquals(weatherForecastModel.getForecastId(), result.getForecastId());
        assertEquals(weatherForecastModel.getLocationId(), result.getLocationId());
        assertEquals(weatherForecastModel.getWeatherForecastInternal(), result.getWeatherForecastInternal());
        verify(weatherForecastRepository, times(1)).saveAndFlush(any(WeatherForecastModel.class));
    }

    @Test
    public void testInsertOrUpdateForecast_Negative() throws Exception {
        when(weatherForecastRepository.saveAndFlush(any(WeatherForecastModel.class)))
                .thenReturn(null);

        WeatherForecastModel result = weatherForecastServiceImpl
                .insertOrUpdateForecast(weatherForecastModel);

        assertNotEquals(weatherForecastModel, result);
        verify(weatherForecastRepository, times(1)).saveAndFlush(any(WeatherForecastModel.class));

    }

    @Test
    public void testGetForcastByLocationId_Positive() throws Exception {
        WeatherForecastModel expected = new WeatherForecastModel();
        expected.setLocationId(123);
        expected.setWeatherForecastInternal("{\"temperature\": 20}");

        when(weatherForecastRepository.findByLocationId(anyInt())).thenReturn(expected);

        WeatherForecastModel actual = weatherForecastServiceImpl.getForcastByLocationId(123);
        JsonNode expectedWeatherForecast = new ObjectMapper().readTree("{\"temperature\": 20}");

        assertEquals(expected.getLocationId(), actual.getLocationId());
        assertEquals(expectedWeatherForecast, actual.getWeatherForecast());
    }


    @Test(expected = Exception.class)
    public void testGetForcastByLocationId_Negative() throws Exception {
        when(weatherForecastRepository.findByLocationId(anyInt())).thenThrow(new Exception());
        weatherForecastServiceImpl.getForcastByLocationId(123);
    }


}

