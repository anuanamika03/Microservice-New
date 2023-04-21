package com.neom.assettech.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neom.assettech.model.LocationAlertModel;
import com.neom.assettech.repository.LocationAlertRepository;
import com.neom.assettech.service.LocationAlertService;
@Service
public class LocationAlertServiceimpl implements LocationAlertService{

	@Autowired
	LocationAlertRepository locationalertrepository;
	
	@Override
	public List<LocationAlertModel> findAll() {
		
		return locationalertrepository.findAll();
	}

	@Override
	public LocationAlertModel getActiveAlert() throws Exception {
		
		return locationalertrepository.getActiveAlert();
	}

	@Override
	public void addAlert(LocationAlertModel newalert) {
		locationalertrepository.save(newalert);
		
	}



}
