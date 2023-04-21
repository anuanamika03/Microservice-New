package com.neom.assettech.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.neom.assettech.exception.ResponseHandler;
import com.neom.assettech.model.LocationModel;
import com.neom.assettech.service.LocationService;

@RestController
public class LocationController {
	
	@Autowired
	private LocationService locationService;
	
	@RequestMapping(value = "/api/locationDetails", method = RequestMethod.GET)
	public ResponseEntity<?> getAllLocationDetails(HttpServletRequest request) throws Exception {
		return ResponseHandler.generateGetResponse(HttpStatus.OK, locationService.getAllLocations(), request);
	}
	
	@RequestMapping(value = "/api/locationDetails/location/{locationId}", method = RequestMethod.GET)
	public ResponseEntity<?> getLocationByLocationId(HttpServletRequest request, @PathVariable Integer locationId) throws Exception {
		return ResponseHandler.generateGetResponse(HttpStatus.OK, locationService.getLocationByLocationId(locationId), request);
	}
	
	@RequestMapping(value = "/api/locationDetails/device/{deviceId}", method = RequestMethod.GET)
	public ResponseEntity<?> getLocationByDeviceId(HttpServletRequest request, @PathVariable String deviceId) throws Exception {
		return ResponseHandler.generateGetResponse(HttpStatus.OK, locationService.getLocationByDeviceId(deviceId), request);
	}
	
	@RequestMapping(value = "/api/locationDetails", method = RequestMethod.POST)
	public ResponseEntity<?> createLocation(HttpServletRequest request, @Valid @RequestBody LocationModel location) throws Exception {
		return ResponseHandler.generatePostWithReturnResponse(HttpStatus.OK, locationService.createLocation(location), request);
	}

}
