package com.neom.assettech.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
@Table(name="notification")
public class NotificationModel extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4158377078581215802L;
//	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="notification_ID")
	private Integer notificationID;
	 
	@Column(name ="App_Id")
	private Integer AppID;
	
	@Column(name="Alert_Id")
	private Integer AlertID;
	
	
	@Column(name = "Action", columnDefinition = "VARCHAR(255) NOT NULL")
        private String Action;
	
	@Column(name="weatherparameter",columnDefinition = "VARCHAR(255) NOT NULL")
	private String weatherparameter;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name = "ActionTimeStamp")
	private Date ActionTimeStamp;
	
	@Column(name = "App_Name", columnDefinition = "VARCHAR(255) NOT NULL")
	private String AppName;

	@Column(name = "Message", columnDefinition = "VARCHAR(255) NOT NULL")
	private String Message;

	public Integer getNotificationID() {
		return notificationID;
	}

	public void setNotificationID(Integer notificationID) {
		this.notificationID = notificationID;
	}

	public Integer getAppID() {
		return AppID;
	}

	public void setAppID(Integer appID) {
		AppID = appID;
	}

	public Integer getAlertID() {
		return AlertID;
	}

	public void setAlertID(Integer alertID) {
		AlertID = alertID;
	}

	public String getAction() {
		return Action;
	}

	public void setAction(String action) {
		Action = action;
	}

	public String getWeatherparameter() {
		return weatherparameter;
	}

	public void setWeatherparameter(String weatherparameter) {
		this.weatherparameter = weatherparameter;
	}

	public Date getActionTimeStamp() {
		return ActionTimeStamp;
	}

	public void setActionTimeStamp(Date actionTimeStamp) {
		ActionTimeStamp = actionTimeStamp;
	}

	public String getAppName() {
		return AppName;
	}

	public void setAppName(String appName) {
		AppName = appName;
	}

	public String getMessage() {
		return Message;
	}

	public void setMessage(String message) {
		Message = message;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

	

}
