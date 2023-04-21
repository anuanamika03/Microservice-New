package com.neom.assettech.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.neom.assettech.model.NotificationModel;
import com.neom.assettech.repository.NotificationRepository;
import com.neom.assettech.service.NotificationService;
@Service
public class NotificationServiceimpl implements NotificationService {

	@Autowired
	NotificationRepository notificationrepository;

	@Override
	public List<NotificationModel> findAll() {
		
		return notificationrepository.findAll();
	}
	
	@Override
	public void addnotification(NotificationModel notificationmodel) {
		this.notificationrepository.save(notificationmodel);
		
	}


	@Override
	public List<NotificationModel> getNotifications() {
		
		return notificationrepository.getNotifications() ;
	}


	@Override
	public void deletenotification() {
		notificationrepository.deleteAll();
		
	}

	@Override
	public Page<NotificationModel> findAllWithPaginatation(Integer pageNo, Integer pageSize) {
		 Pageable paging = PageRequest.of(pageNo, pageSize,Sort.by("notificationID").descending());

		   Page<NotificationModel> pagedResult = notificationrepository.findAll(paging);
		 
		   return pagedResult;	
		   }






	
	
}
