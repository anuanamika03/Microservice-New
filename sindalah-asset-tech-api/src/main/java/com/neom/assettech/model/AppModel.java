package com.neom.assettech.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
@Entity
@Table(name = "App")
public class AppModel extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4113365357433149648L;
	@Id
	@Column(name = "app_id")
	@NotNull
	private Integer AppId;
	
	
	@Column(name = "app_name", columnDefinition = "VARCHAR(255) NOT NULL")
	@NotBlank
	@NotNull
	private String AppName;

	@Column(name = "is_active")
	@NotNull
	private Boolean isActive;

	public Integer getAppId() {
		return AppId;
	}

	public void setAppId(Integer appId) {
		AppId = appId;
	}

	public String getAppName() {
		return AppName;
	}

	public void setAppName(String appName) {
		AppName = appName;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}
