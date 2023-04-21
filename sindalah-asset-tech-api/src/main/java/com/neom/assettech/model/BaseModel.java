package com.neom.assettech.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.neom.assettech.constants.AppConstants;

@MappedSuperclass
public class BaseModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6981297054086795727L;
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	@Column(name = "createdBy", columnDefinition = "INT(9)")
	private Integer createdBy;
	
	@JsonFormat(pattern = AppConstants.JSON_DATE_FORMAT)
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	@Column(name = "createdOn")
	@CreationTimestamp
	private Date createdOn;
	
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	@Column(name = "updatedBy", columnDefinition = "INT(9)")
	private Integer updatedBy;
	
	@JsonFormat(pattern =  AppConstants.JSON_DATE_FORMAT)
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	@Column(name = "updatedOn")
	@UpdateTimestamp
	private Date updatedOn;

	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Integer getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(Integer updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}
	
	
}
