package com.neom.assettech.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neom.assettech.model.AppModel;
import com.neom.assettech.model.AuditLogModel;
import com.neom.assettech.model.ChartDataModel;
import com.neom.assettech.model.NotificationModel;
import com.neom.assettech.model.WeatherThersholdModel;
import com.neom.assettech.service.AppService;
import com.neom.assettech.service.AuditService;
import com.neom.assettech.service.ChartDataService;
import com.neom.assettech.service.NotificationService;
import com.neom.assettech.service.WeatherThersholdService;
import com.neom.assettech.serviceimpl.NotificationServiceimpl;
@CrossOrigin
@RestController
@RequestMapping
public class Controller {


	@Autowired
	ChartDataService chartdataservice;
	
	@GetMapping("/api/chartdata")
	 public List<ChartDataModel> getChartData(){

		return chartdataservice.findAll();
	}
	
	@PostMapping("/api/chartdata")
	public ResponseEntity<HttpStatus> addchartdata(@RequestBody ChartDataModel chartdatamodel){
		 this.chartdataservice.addchartdata(chartdatamodel);
		return new ResponseEntity<>(HttpStatus.OK);
		
		}
	
	@Autowired
	NotificationService notificationservice;
	
	@GetMapping("/api/notification")
	public List<NotificationModel> getNotification(){
		return notificationservice.getNotifications();
		
				
	}
	
	  @GetMapping("/api/notifications/{pageNo}/{pageSize}")
	    public ResponseEntity<Map<String, Object>> getNotificationWithPagination(
	                        @PathVariable Integer pageNo, @PathVariable Integer pageSize)
	    {
		   List<NotificationModel> list=new ArrayList<NotificationModel>();
		   // Page<NotificationModel> pageNoti;
	        Page<NotificationModel> pageNoti = notificationservice.findAllWithPaginatation(pageNo, pageSize);
	        list=pageNoti.getContent();
	        Map<String, Object> response = new HashMap<>();
	     
	        response.put("notifications", list);
	        response.put("currentPage", pageNoti.getNumber());
	        response.put("totalItems", pageNoti.getTotalElements());
	        response.put("totalPages", pageNoti.getTotalPages());
	        return new ResponseEntity<>(response, HttpStatus.OK);
	        
	        }
	
		@PostMapping("/api/notification")
	public ResponseEntity<HttpStatus> addnotification(@RequestBody NotificationModel notificationmodel ){
		this.notificationservice.addnotification(notificationmodel);
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
	
		@DeleteMapping("/api/notification")
		public ResponseEntity<HttpStatus> deletenotification(){
			this.notificationservice.deletenotification();
			return new ResponseEntity<>(HttpStatus.OK);
		}
		
		@Autowired
		AppService appservice;
		
		@GetMapping("/api/app")
		public List<AppModel> getApp(){
			return appservice.findAll();
			
		}
		
		@PostMapping("/api/app")
		public ResponseEntity<HttpStatus> addapp(@RequestBody AppModel appmodel ) throws Exception{
			this.appservice.addapp(appmodel);
			return new ResponseEntity<>(HttpStatus.OK);
			
		}
		
		@Autowired
		AuditService auditservice;
		
		@GetMapping("/api/auditlog")
		public List<AuditLogModel> getAuditLog(){
			return auditservice.findAll();
			
		}
		
		@Autowired
		WeatherThersholdService weatherthersholdservice;
		
		@GetMapping("/api/WeatherThershold")
		public List<WeatherThersholdModel> getWeatherThershold(){
			return weatherthersholdservice.findAll();
			
		}
		
		@PostMapping("/api/WeatherThershold")
		public ResponseEntity<HttpStatus> addweatherthershold(@RequestBody WeatherThersholdModel weatherthersholdmodel ) throws Exception{
			this.weatherthersholdservice.addweatherthershold(weatherthersholdmodel);
			return new ResponseEntity<>(HttpStatus.OK);
			
		}
}