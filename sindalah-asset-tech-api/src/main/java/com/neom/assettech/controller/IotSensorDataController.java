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
import com.neom.assettech.model.IotSensorDataModel;
import com.neom.assettech.service.IotSensorDataService;
import com.neom.assettech.service.WeatherForecastService;

@RestController
public class IotSensorDataController {

	@Autowired
	private IotSensorDataService iotSensorDataService;
	
	@Autowired
	private WeatherForecastService weatherForecastService;

	@RequestMapping(value = "/api/iotSensorData", method = RequestMethod.POST)
	public ResponseEntity<?> insertSensorData(HttpServletRequest request,
			@Valid @RequestBody IotSensorDataModel sensorData) throws Exception {
		return ResponseHandler.generatePostWithReturnResponse(HttpStatus.OK,
				iotSensorDataService.insertSensorData(sensorData), request);
	}

	@RequestMapping(value = "/api/iotSensorData/latest/{locationId}", method = RequestMethod.GET)
	public ResponseEntity<?> getLatestSensorDataByLocationId(HttpServletRequest request,
			@PathVariable Integer locationId) throws Exception {
		return ResponseHandler.generateGetResponse(HttpStatus.OK,
				iotSensorDataService.getLatestSensorDataByLocationId(locationId), request);
	}
	
	@RequestMapping(value = "/api/iotSensorData/forecast/{locationId}", method = RequestMethod.GET)
	public ResponseEntity<?> getForcastByLocationId(HttpServletRequest request,
			@PathVariable Integer locationId) throws Exception {
		return ResponseHandler.generateGetResponse(HttpStatus.OK,
				weatherForecastService.getForcastByLocationId(locationId), request);
	}

}
