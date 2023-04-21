package com.neom.assettech.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.neom.assettech.model.LocationModel;

@Service
public interface LocationService {
	
	public LocationModel createLocation(LocationModel location) throws Exception;
	public List<LocationModel> getAllLocations() throws Exception;
	public LocationModel getLocationByLocationId(Integer locationId) throws Exception;
	public LocationModel getLocationByDeviceId(String deviceId) throws Exception;

}
