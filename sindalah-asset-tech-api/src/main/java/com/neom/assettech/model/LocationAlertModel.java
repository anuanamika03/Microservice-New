package com.neom.assettech.model;

import java.util.Date;

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
@Table(name = "locationalert")

public class LocationAlertModel extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 634977359332855937L;
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "LocationAlert_Id")
	private Integer LocationAlertId;

	@Column(name = "location_id")
	private Integer locationId;

	@Column(name = "is_active")
	@NotNull
	private Boolean isActive;

	@Column(name = "IsFavorable")
	@NotNull
	private Boolean IsFavorable;
	

	@Column(name = "AlertStartDate")
	private Date AlertStartDate;

	@Column(name = "AlertEndDate")
	private Date AlertEndDate;

	public Integer getLocationAlertId() {
		return LocationAlertId;
	}

	public void setLocationAlertId(Integer locationAlertId) {
		LocationAlertId = locationAlertId;
	}

	public Integer getLocationId() {
		return locationId;
	}

	public void setLocationId(Integer locationId) {
		this.locationId = locationId;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Boolean getIsFavorable() {
		return IsFavorable;
	}

	public void setIsFavorable(Boolean isFavorable) {
		IsFavorable = isFavorable;
	}

	public Date getAlertStartDate() {
		return AlertStartDate;
	}

	public void setAlertStartDate(Date alertStartDate) {
		AlertStartDate = alertStartDate;
	}

	public Date getAlertEndDate() {
		return AlertEndDate;
	}

	public void setAlertEndDate(Date alertEndDate) {
		AlertEndDate = alertEndDate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
