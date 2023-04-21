package com.neom.assettech.serviceimpl;

import com.neom.assettech.model.IotSensorDataArchiveModel;
import com.neom.assettech.repository.IotSensorDataArchiveRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Date;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class IotSensorDataArchiveServiceImplTest {

    @Mock
    private IotSensorDataArchiveRepository iotSensorDataArchiveRepository;

    @InjectMocks
    private IotSensorDataArchiveServiceImpl iotSensorDataArchiveServiceImpl;

    private IotSensorDataArchiveModel iotSensorDataArchiveModel;

    @Before
    public void setUp() {
        iotSensorDataArchiveModel = new IotSensorDataArchiveModel();
        iotSensorDataArchiveModel.setIotsensordataarchiveId(1);
        iotSensorDataArchiveModel.setSensorDataId(1);
        iotSensorDataArchiveModel.setLocationId(1);
        iotSensorDataArchiveModel.setTemperature(30.0);
        iotSensorDataArchiveModel.setHumidity(70.0);
        iotSensorDataArchiveModel.setAqi(50.0);
        iotSensorDataArchiveModel.setPressure(1020.0);
        iotSensorDataArchiveModel.setWindSpeed(10.0);
        iotSensorDataArchiveModel.setRainChance(20.0);
        iotSensorDataArchiveModel.setUvIndex(8.0);
        iotSensorDataArchiveModel.setDatatimestamp(new Date());
        iotSensorDataArchiveModel.setAQIinterpretlabel("Moderate");
    }

    @Test
    public void testInsertOrUpdateForecast_Success() throws Exception {
        when(iotSensorDataArchiveRepository.saveAndFlush(any(IotSensorDataArchiveModel.class)))
                .thenReturn(iotSensorDataArchiveModel);

        IotSensorDataArchiveModel result = iotSensorDataArchiveServiceImpl
                .insertOrUpdateForecast(iotSensorDataArchiveModel);

        assertEquals(iotSensorDataArchiveModel.getAqi(), result.getAqi());
        assertEquals(iotSensorDataArchiveModel.getHumidity(), result.getHumidity());
        assertEquals(iotSensorDataArchiveModel.getPressure(), result.getPressure());
        verify(iotSensorDataArchiveRepository, times(1)).saveAndFlush(any(IotSensorDataArchiveModel.class));
    }

    @Test
    public void testInsertOrUpdateForecast_Failure() throws Exception {
        when(iotSensorDataArchiveRepository.saveAndFlush(any(IotSensorDataArchiveModel.class)))
                .thenReturn(null);

        IotSensorDataArchiveModel result = iotSensorDataArchiveServiceImpl
                .insertOrUpdateForecast(iotSensorDataArchiveModel);

        assertNotEquals(iotSensorDataArchiveModel, result);
        verify(iotSensorDataArchiveRepository, times(1)).saveAndFlush(any(IotSensorDataArchiveModel.class));
    }

    @Test
    public void testDeleteAllIotSensorData_Success() throws Exception {
        iotSensorDataArchiveServiceImpl.deleteAllIotSensorData();
        assertEquals(0, iotSensorDataArchiveRepository.findAll().size());
    }

    @Test
    public void testDeleteAllIotSensorData_Failure() throws Exception {
        doNothing().when(iotSensorDataArchiveRepository).deleteAll();
        iotSensorDataArchiveServiceImpl.deleteAllIotSensorData();
        verify(iotSensorDataArchiveRepository, times(1)).deleteAll();
    }


    @Test
    public void testDeleteBycreatedOnBefore_Success() throws Exception {
        Date date = new Date();
        doNothing().when(iotSensorDataArchiveRepository).deleteBycreatedOnBefore(date);
        iotSensorDataArchiveServiceImpl.deleteBycreatedOnBefore(date);
        verify(iotSensorDataArchiveRepository, times(1)).deleteBycreatedOnBefore(date);
    }

    @Test
    public void testDeleteBycreatedOnBefore_Failure() throws Exception {
        Date date = new Date();

        doThrow(new RuntimeException("Database error")).when(iotSensorDataArchiveRepository).deleteBycreatedOnBefore(date);
        assertThrows(RuntimeException.class, () -> iotSensorDataArchiveServiceImpl.deleteBycreatedOnBefore(date));
    }


}