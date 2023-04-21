package com.neom.assettech.serviceimpl;

import com.neom.assettech.model.WeatherForecastArchiveModel;
import com.neom.assettech.repository.WeatherForecastArchiveRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
public class WeatherForecastArchiveServiceImplTest {
    Date date;
    @Mock
    private WeatherForecastArchiveRepository weatherForecastArchiveRepository;
    @InjectMocks
    private WeatherForecastArchiveServiceImpl weatherForecastArchiveServiceImpl;
    private WeatherForecastArchiveModel weatherForecastArchiveModel;

    @Before
    public void setup() {
        weatherForecastArchiveModel = new WeatherForecastArchiveModel();
        weatherForecastArchiveModel.setForecastId(1);
        weatherForecastArchiveModel.setLocationId(1);
        weatherForecastArchiveModel.setWeatherForecastInternal("internal");
        weatherForecastArchiveModel.setWeatherforecastarchiveId(1);

    }

    @Test
    public void testInsertOrUpdateForecast_positive() throws Exception {
        when(weatherForecastArchiveRepository.saveAndFlush(any(WeatherForecastArchiveModel.class)))
                .thenReturn(weatherForecastArchiveModel);
        WeatherForecastArchiveModel result = weatherForecastArchiveServiceImpl.insertOrUpdateForecast(weatherForecastArchiveModel);
        assertEquals(weatherForecastArchiveModel.getForecastId(), result.getForecastId());
        assertEquals(weatherForecastArchiveModel.getWeatherforecastarchiveId(), result.getWeatherforecastarchiveId());
        assertEquals(weatherForecastArchiveModel.getLocationId(), result.getLocationId());
        verify(weatherForecastArchiveRepository, times(1)).saveAndFlush(any(WeatherForecastArchiveModel.class));
    }

    @Test
    public void testInsertOrUpdateForecast_negative() throws Exception {
        when(weatherForecastArchiveRepository.saveAndFlush(any(WeatherForecastArchiveModel.class)))
                .thenReturn(null);

        WeatherForecastArchiveModel result = weatherForecastArchiveServiceImpl
                .insertOrUpdateForecast(weatherForecastArchiveModel);

        assertNotEquals(weatherForecastArchiveModel, result);
        verify(weatherForecastArchiveRepository, times(1)).saveAndFlush(any(WeatherForecastArchiveModel.class));

    }

    @Test
    public void testDeleteBycreatedOnBefore_Success() throws Exception {
        weatherForecastArchiveServiceImpl.deleteBycreatedOnBefore(date);
        assertEquals(0, weatherForecastArchiveRepository.findAll().size());
    }

    @Test
    public void testDeleteBycreatedOnBefore_Failure() throws Exception {
        weatherForecastArchiveServiceImpl.deleteBycreatedOnBefore(date);
        verify(weatherForecastArchiveRepository, times(1)).deleteBycreatedOnBefore(date);
    }


}
