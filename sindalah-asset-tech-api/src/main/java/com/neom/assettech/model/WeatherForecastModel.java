package com.neom.assettech.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;

@Entity
@Table(name = "weather_forecast")
public class WeatherForecastModel extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8626142165531565558L;

	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "forecast_id")
	private Integer forecastId;
	
	@Column(name = "location_id")
	private Integer locationId;
	
	@JsonIgnore
	@Column(name = "weather_forecast", columnDefinition = "JSON")
	private String weatherForecastInternal;
	
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	@Transient
	private JsonNode weatherForecast;

	public Integer getForecastId() {
		return forecastId;
	}

	public void setForecastId(Integer forecastId) {
		this.forecastId = forecastId;
	}

	public Integer getLocationId() {
		return locationId;
	}

	public void setLocationId(Integer locationId) {
		this.locationId = locationId;
	}

	public String getWeatherForecastInternal() {
		return weatherForecastInternal;
	}

	public void setWeatherForecastInternal(String weatherForecastInternal) {
		this.weatherForecastInternal = weatherForecastInternal;
	}

	public JsonNode getWeatherForecast() {
		return weatherForecast;
	}

	public void setWeatherForecast(JsonNode weatherForecast) {
		this.weatherForecast = weatherForecast;
		this.weatherForecastInternal = null != weatherForecast ? weatherForecast.toString() : null;
	}
}
