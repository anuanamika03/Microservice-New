package com.neom.assettech.serviceimpl;

import com.neom.assettech.model.ChartDataModel;
import com.neom.assettech.repository.ChartDataRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

public class ChartDataServiceimplTest {

    @InjectMocks
    ChartDataServiceimpl chartDataServiceimpl;

    @Mock
    ChartDataRepository chartDataRepository;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindAll_Positive() {
        List<ChartDataModel> chartDataModels = new ArrayList<>();
        ChartDataModel chartDataModel = new ChartDataModel();
        chartDataModel.setTimestamp(new Date());
        chartDataModels.add(chartDataModel);

        when(chartDataRepository.findAll()).thenReturn(chartDataModels);

        List<ChartDataModel> charts = chartDataServiceimpl.findAll();

        assertEquals(charts.size(), chartDataModels.size());
    }

    @Test
    public void testFindAll_Negative() {
        List<ChartDataModel> chartDataModels = new ArrayList<>();

        when(chartDataRepository.findAll()).thenReturn(chartDataModels);

        List<ChartDataModel> charts = chartDataServiceimpl.findAll();

        assertEquals(charts.size(), chartDataModels.size());
    }

    @Test
    public void testAddChartData_Positive() {
        ChartDataModel chartDataModel = new ChartDataModel();
        chartDataServiceimpl.addchartdata(chartDataModel);
    }

    @Test
    public void testAddChartData_Negative() {
        ChartDataModel chartDataModel = null;

        doThrow(IllegalArgumentException.class).when(chartDataRepository).save(chartDataModel);

        assertThrows(IllegalArgumentException.class, () -> chartDataServiceimpl.addchartdata(chartDataModel));
    }

}

