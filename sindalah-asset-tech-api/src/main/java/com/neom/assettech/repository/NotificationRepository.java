package com.neom.assettech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.neom.assettech.model.IotSensorDataModel;
import com.neom.assettech.model.NotificationModel;

@Repository
public interface NotificationRepository extends JpaRepository<NotificationModel, Integer>{

	
	@Query(value = "select * from notification order by notification_id desc LIMIT 0, 3", nativeQuery = true)
	
	public List<NotificationModel> getNotifications();
	
	List<NotificationModel> findAll();
	
	
	
}
