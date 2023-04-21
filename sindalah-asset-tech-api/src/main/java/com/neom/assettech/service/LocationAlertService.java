package com.neom.assettech.service;

import java.util.List;

import com.neom.assettech.model.LocationAlertModel;

public interface LocationAlertService {

	public List<LocationAlertModel> findAll();
	public LocationAlertModel getActiveAlert() throws Exception;
	public void addAlert(LocationAlertModel newalert);
	
	
}
