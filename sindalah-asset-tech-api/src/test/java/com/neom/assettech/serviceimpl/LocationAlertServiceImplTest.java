package com.neom.assettech.serviceimpl;

import com.neom.assettech.model.LocationAlertModel;
import com.neom.assettech.repository.LocationAlertRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class LocationAlertServiceImplTest {

    @InjectMocks
    private LocationAlertServiceimpl locationAlertServiceImpl;

    @Mock
    private LocationAlertRepository locationalertrepository;

    @Test
    public void testFindAllPositive() {
        List<LocationAlertModel> expected = new ArrayList<>();
        expected.add(new LocationAlertModel());
        when(locationalertrepository.findAll()).thenReturn(expected);
        List<LocationAlertModel> result = locationAlertServiceImpl.findAll();
        assertEquals(expected, result);
        verify(locationalertrepository, times(1)).findAll();
    }

    @Test
    public void testFindAllNegative() {
        when(locationalertrepository.findAll()).thenReturn(null);
        List<LocationAlertModel> result = locationAlertServiceImpl.findAll();
        assertNull(result);
        verify(locationalertrepository, times(1)).findAll();
    }


    @Test
    public void testGetActiveAlert_Positive() throws Exception {
        LocationAlertModel expected = new LocationAlertModel();
        expected.setLocationAlertId(1);
        when(locationalertrepository.getActiveAlert()).thenReturn(expected);
        LocationAlertModel result = locationAlertServiceImpl.getActiveAlert();
        assertEquals(expected, result);
    }

    @Test(expected = Exception.class)
    public void testGetActiveAlert_Negative() throws Exception {
        when(locationalertrepository.getActiveAlert()).thenThrow(new Exception());
        locationAlertServiceImpl.getActiveAlert();
    }

    @Test
    public void testAddAlert() {
        LocationAlertModel newalert = new LocationAlertModel();
        newalert.setLocationAlertId(1);
        locationAlertServiceImpl.addAlert(newalert);
    }


}

