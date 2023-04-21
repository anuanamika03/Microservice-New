package com.neom.assettech.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import com.neom.assettech.model.NotificationModel;

@Service
public interface NotificationService {


	public List<NotificationModel> findAll();
	
	public List<NotificationModel> getNotifications();
	
	public void addnotification(NotificationModel notificationmodel);
	
	public void deletenotification();

	public Page<NotificationModel> findAllWithPaginatation(Integer pageNo, Integer pageSize);


}
