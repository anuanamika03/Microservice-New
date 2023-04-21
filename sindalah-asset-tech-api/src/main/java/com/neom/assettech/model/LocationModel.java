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
@Table(name = "locations")
public class LocationModel extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1782764037493056583L;
	
	//@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	@Id
	@Column(name = "location_id")
	private Integer locationId;
	
	@Column(name = "device_id", columnDefinition = "VARCHAR(255) NOT NULL")
	@NotBlank
	@NotNull
	private String deviceId;
	
	@Column(name = "location_name", columnDefinition = "VARCHAR(255) NOT NULL")
	@NotBlank
	@NotNull
	private String locationName;
	
	@Column(name = "longitude", columnDefinition = "VARCHAR(255) NOT NULL")
	@NotBlank
	@NotNull
	private String longitude;

	@Column(name = "latitude", columnDefinition = "VARCHAR(255) NOT NULL")
	@NotBlank
	@NotNull
	private String latitude;
	
	@Column(name = "is_active")
	@NotNull
	private Boolean isActive;
	
	/*@Column (name="alert_temperature")
	@NotNull
	private Boolean AlertTemperature;*/

	public Integer getLocationId() {
		return locationId;
	}

	public void setLocationId(Integer locationId) {
		this.locationId = locationId;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

}
