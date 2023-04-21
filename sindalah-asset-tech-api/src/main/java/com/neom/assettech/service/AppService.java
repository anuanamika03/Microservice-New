package com.neom.assettech.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.neom.assettech.model.AppModel;
import com.neom.assettech.model.NotificationModel;

@Service
public interface AppService {
	
	public List<AppModel> findAll();

	public void addapp(AppModel appmodel) throws Exception;
	
}
