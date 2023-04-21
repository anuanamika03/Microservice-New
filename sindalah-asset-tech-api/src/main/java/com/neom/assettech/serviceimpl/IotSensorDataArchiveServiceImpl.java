package com.neom.assettech.serviceimpl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.neom.assettech.model.IotSensorDataArchiveModel;
import com.neom.assettech.model.IotSensorDataModel;
import com.neom.assettech.repository.IotSensorDataArchiveRepository;
import com.neom.assettech.repository.IotSensorDataRepository;
import com.neom.assettech.service.IotSensorDataArchiveService;
@Service
public class IotSensorDataArchiveServiceImpl implements IotSensorDataArchiveService{

	@Autowired
	private IotSensorDataArchiveRepository iotSensorDataArchiveRepository;

	
	@Override
	public IotSensorDataArchiveModel insertOrUpdateForecast(IotSensorDataArchiveModel sensorData) throws Exception {
		return iotSensorDataArchiveRepository.saveAndFlush(sensorData);
	}
	

	@Override
	public void deleteAllIotSensorData() throws Exception {
		iotSensorDataArchiveRepository.deleteAll();
		
	}

	@Override
	public void deleteBycreatedOnBefore(Date expiryDate)  {
		iotSensorDataArchiveRepository.deleteBycreatedOnBefore(expiryDate);	
		
	}

	
}
