package com.neom.assettech.serviceimpl;

import com.neom.assettech.model.WeatherThersholdModel;
import com.neom.assettech.repository.WeatherThersholdRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static junit.framework.TestCase.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class WeatherThersholdServiceimplTest {
    @Mock

    WeatherThersholdRepository weatherThersholdRepository;

    @InjectMocks
    WeatherThersholdServiceimpl weatherThersholdServiceimpl;

    WeatherThersholdModel weatherThersholdModel;

    @Before
    public void setup() {

        weatherThersholdModel = new WeatherThersholdModel();
        weatherThersholdModel.setWeatherThersholdId(1);
        weatherThersholdModel.setAqi(55.0);
        weatherThersholdModel.setHumidity(40.0);
        weatherThersholdModel.setTemperature(35.0);
        weatherThersholdModel.setPressure(1001.0);
        weatherThersholdModel.setRainChance(20.0);
        weatherThersholdModel.setUvIndex(2.33);
        weatherThersholdModel.setWindSpeed(20.0);
        weatherThersholdModel.setIsActive(true);

    }

    @Test
    public void testFindAll_positive() {
        List<WeatherThersholdModel> weatherThersholdModels = new ArrayList<>();
        WeatherThersholdModel weatherThersholdModel = new WeatherThersholdModel();
        weatherThersholdModel.setCreatedOn(new Date());

        weatherThersholdModels.add(weatherThersholdModel);


        when(weatherThersholdRepository.findAll()).thenReturn(weatherThersholdModels);
        List<WeatherThersholdModel> result = weatherThersholdServiceimpl.findAll();
        Assert.assertEquals(result.size(), weatherThersholdModels.size());

    }

    @Test
    public void testFindAll_Negative() {
        List<WeatherThersholdModel> weatherThersholdModels = new ArrayList<>();

        when(weatherThersholdRepository.findAll()).thenReturn(weatherThersholdModels);

        List<WeatherThersholdModel> result = weatherThersholdServiceimpl.findAll();

        Assert.assertEquals(result.size(), weatherThersholdModels.size());
    }

    @Test
    public void testGetActiveThersholds_Positive() {
        when(weatherThersholdRepository.getActiveThersholds()).thenReturn(weatherThersholdModel);
        WeatherThersholdModel result = weatherThersholdServiceimpl.getActiveThersholds();
        assertEquals(weatherThersholdModel.getAqi(), result.getAqi());
        assertEquals(weatherThersholdModel.getHumidity(), result.getHumidity());
        assertEquals(weatherThersholdModel.getPressure(), result.getPressure());
        verify(weatherThersholdRepository, times(1)).getActiveThersholds();
    }

    @Test
    public void testGetActiveThersholds_Negative() {
        when(weatherThersholdRepository.getActiveThersholds()).thenReturn(null);
        WeatherThersholdModel result = weatherThersholdServiceimpl.getActiveThersholds();
        assertNull(result);
    }

    @Test
    public void testAddweatherthershold_positive() throws Exception {
        WeatherThersholdModel weatherthersholdmodelnew = new WeatherThersholdModel();
        weatherthersholdmodelnew.setWeatherThersholdId(1);
        weatherthersholdmodelnew.setTemperature(30.0);
        weatherthersholdmodelnew.setHumidity(70.0);
        weatherthersholdmodelnew.setAqi(60.0);
        weatherthersholdmodelnew.setPressure(100.0);
        weatherthersholdmodelnew.setWindSpeed(20.0);
        weatherthersholdmodelnew.setRainChance(50.0);
        weatherthersholdmodelnew.setUvIndex(5.0);
        weatherthersholdmodelnew.setIsActive(true);

        Optional<WeatherThersholdModel> weatherthersholdmodelval = Optional.empty();
        when(weatherThersholdRepository.findById(1)).thenReturn(weatherthersholdmodelval);

        weatherThersholdServiceimpl.addweatherthershold(weatherthersholdmodelnew);

        verify(weatherThersholdRepository, times(1)).save(weatherthersholdmodelnew);

    }

    @Test
    public void testAddWeatherThershold_Negative() throws Exception {
        WeatherThersholdModel weatherthersholdmodelnew = new WeatherThersholdModel();
        weatherthersholdmodelnew.setWeatherThersholdId(1);

        Optional<WeatherThersholdModel> weatherthersholdmodelval = Optional.empty();
        when(weatherThersholdRepository.findById(weatherthersholdmodelnew.getWeatherThersholdId())).thenReturn(weatherthersholdmodelval);

        weatherThersholdServiceimpl.addweatherthershold(weatherthersholdmodelnew);
    }

}
