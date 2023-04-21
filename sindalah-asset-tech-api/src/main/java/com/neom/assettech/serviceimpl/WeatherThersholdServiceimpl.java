package com.neom.assettech.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neom.assettech.model.AuditLogModel;
import com.neom.assettech.model.WeatherThersholdModel;
import com.neom.assettech.repository.WeatherThersholdRepository;
import com.neom.assettech.service.AuditService;
import com.neom.assettech.service.WeatherThersholdService;

@Service
public class WeatherThersholdServiceimpl implements WeatherThersholdService{

	@Autowired
	WeatherThersholdRepository weatherthersholdrepository;
	
	@Autowired
	private AuditService auditService;
	
	@Override
	public List<WeatherThersholdModel> findAll() {
		
		return weatherthersholdrepository.findAll();
	}

	

	@Override
	public WeatherThersholdModel getActiveThersholds() {
		
		return weatherthersholdrepository.getActiveThersholds();
	}
	  @Override

	    public void addweatherthershold(WeatherThersholdModel weatherthersholdmodelnew) throws Exception {

	        Optional<WeatherThersholdModel> weatherthersholdmodelval= weatherthersholdrepository.findById(weatherthersholdmodelnew.getWeatherThersholdId());    

	        if(weatherthersholdmodelval.isPresent())

	        {

	            WeatherThersholdModel weatherthersholdmodel=weatherthersholdmodelval.get();    

	           

	            addAuditLog("temperature",weatherthersholdmodel.getTemperature().toString(),weatherthersholdmodelnew.getTemperature().toString(),weatherthersholdmodelnew.getWeatherThersholdId().toString());

	            addAuditLog("humidity",weatherthersholdmodel.getHumidity().toString(),weatherthersholdmodelnew.getHumidity().toString(),weatherthersholdmodelnew.getWeatherThersholdId().toString());

	            addAuditLog("aqi",weatherthersholdmodel.getAqi().toString(),weatherthersholdmodelnew.getAqi().toString(),weatherthersholdmodelnew.getWeatherThersholdId().toString());

	            addAuditLog("pressure",weatherthersholdmodel.getPressure().toString(),weatherthersholdmodelnew.getPressure().toString(),weatherthersholdmodelnew.getWeatherThersholdId().toString());

	            addAuditLog("wind_speed",weatherthersholdmodel.getWindSpeed().toString(),weatherthersholdmodelnew.getWindSpeed().toString(),weatherthersholdmodelnew.getWeatherThersholdId().toString());

	            addAuditLog("rain_chance",weatherthersholdmodel.getRainChance().toString(),weatherthersholdmodelnew.getRainChance().toString(),weatherthersholdmodelnew.getWeatherThersholdId().toString());

	            addAuditLog("uv_index",weatherthersholdmodel.getUvIndex().toString(),weatherthersholdmodelnew.getUvIndex().toString(),weatherthersholdmodelnew.getWeatherThersholdId().toString());

	            addAuditLog("is_active",weatherthersholdmodel.getIsActive().toString(),weatherthersholdmodelnew.getIsActive().toString(),weatherthersholdmodelnew.getWeatherThersholdId().toString());

	         

	}
	        weatherthersholdrepository.save(weatherthersholdmodelnew);
	}
	  
	  private void addAuditLog(String attribute_Name, String oldVal, String newVal, String recordId) throws Exception

	    {

	        if (!oldVal.equals(newVal))

	        {

	            AuditLogModel auditlognew=new AuditLogModel();

	            auditlognew.setEntityName("weatherthershold");

	            auditlognew.setAttribute_Name(attribute_Name);

	            auditlognew.setOldValue(oldVal);

	            auditlognew.setNewValue(newVal);

	            auditlognew.setChangedBy("API");            

	            auditlognew.setRecordId(recordId);                      

	            auditService.createAuditLog(auditlognew);

	        }

	    }

}
