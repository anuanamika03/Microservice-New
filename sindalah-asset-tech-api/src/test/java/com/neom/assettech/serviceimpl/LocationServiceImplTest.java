package com.neom.assettech.serviceimpl;

import com.neom.assettech.model.LocationModel;
import com.neom.assettech.repository.LocationRepository;
import com.neom.assettech.service.AuditService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LocationServiceImplTest {

    @Mock
    private LocationRepository locationRepository;

    @Mock
    private AuditService auditService;

    @InjectMocks
    private LocationServiceImpl locationService;

    private LocationModel locationModel;

    @Before
    public void setUp() {
        locationModel = new LocationModel();
        locationModel.setLocationId(1);
        locationModel.setLocationName("Location 1");
        locationModel.setLatitude("23.45");
        locationModel.setLongitude("67.89");
        locationModel.setIsActive(true);
        locationModel.setDeviceId("device123");
    }

    @Test
    public void testCreateLocation_positive() throws Exception {
        when(locationRepository.saveAndFlush(locationModel)).thenReturn(locationModel);
        LocationModel result = locationService.createLocation(locationModel);
        assertEquals(locationModel, result);
    }


    @Test
    public void createLocation_Failure() throws Exception {

        when(locationRepository.findById(1)).thenReturn(Optional.ofNullable(locationModel));

        LocationModel result = locationService.createLocation(locationModel);

        assertNull(result);

    }


    @Test
    public void testGetAllLocations_positive() throws Exception {
        List<LocationModel> locations = new ArrayList<>();
        locations.add(locationModel);

        when(locationRepository.findAll()).thenReturn(locations);

        List<LocationModel> result = locationService.getAllLocations();

        assertEquals(locations, result);
    }

    @Test
    public void testGetAllLocations_negative() throws Exception {
        when(locationRepository.findAll()).thenReturn(new ArrayList<>());

        List<LocationModel> result = locationService.getAllLocations();

        assertEquals(new ArrayList<>(), result);
    }

    @Test
    public void testGetLocationByLocationId_positive() throws Exception {
        when(locationRepository.findById(1)).thenReturn(Optional.of(locationModel));

        LocationModel result = locationService.getLocationByLocationId(1);

        assertEquals(locationModel, result);
    }

    @Test
    public void testGetLocationByLocationId_negative() throws Exception {
        when(locationRepository.findById(2)).thenReturn(Optional.empty());

        LocationModel result = locationRepository.findById(2).orElse(null);


        assertNull(result);
    }

    @Test
    public void testGetLocationByDeviceId_positive() throws Exception {
        when(locationRepository.findByDeviceId("device123")).thenReturn(locationModel);

        LocationModel result = locationService.getLocationByDeviceId("device123");

        assertEquals(locationModel, result);
    }

    @Test
    public void testGetLocationByDeviceId_negative() throws Exception {
        when(locationRepository.findByDeviceId("device123")).thenReturn(locationModel);

        LocationModel result = locationService.getLocationByDeviceId("device123");


    }
}
