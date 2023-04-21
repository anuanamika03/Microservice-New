package com.neom.assettech.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="weatherthershold")

public class WeatherThersholdModel extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 634977359332855937L;
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "WeatherThershold_Id")
    private Integer WeatherThersholdId;
	
	@Column(name = "temperature", columnDefinition = "DECIMAL(6,2)")
	@NotNull
	@PositiveOrZero
	private Double temperature;
	
	@Column(name = "humidity", columnDefinition = "DECIMAL(6,2)")
	@NotNull
	@PositiveOrZero
	private Double humidity;
	
	@Column(name = "aqi", columnDefinition = "DECIMAL(6,2)")
	@NotNull
	@PositiveOrZero
	private Double aqi;
	
	@Column(name = "pressure", columnDefinition = "DECIMAL(6,2)")
	@NotNull
	@PositiveOrZero
	private Double pressure;
	
	@Column(name = "wind_speed", columnDefinition = "DECIMAL(6,2)")
	@NotNull
	@PositiveOrZero
	private Double windSpeed;
	
	@Column(name = "rain_chance", columnDefinition = "DECIMAL(6,2)")
	@NotNull
	@PositiveOrZero
	private Double rainChance;
	
	@Column(name = "uv_index")
	@NotNull
	private Double uvIndex;
	
	@Column(name = "is_active")
	@NotNull
	private Boolean isActive;

	public Integer getWeatherThersholdId() {
		return WeatherThersholdId;
	}

	public void setWeatherThersholdId(Integer weatherThersholdId) {
		WeatherThersholdId = weatherThersholdId;
	}

	public Double getTemperature() {
		return temperature;
	}

	public void setTemperature(Double temperature) {
		this.temperature = temperature;
	}

	public Double getHumidity() {
		return humidity;
	}

	public void setHumidity(Double humidity) {
		this.humidity = humidity;
	}

	public Double getAqi() {
		return aqi;
	}

	public void setAqi(Double aqi) {
		this.aqi = aqi;
	}

	public Double getPressure() {
		return pressure;
	}

	public void setPressure(Double pressure) {
		this.pressure = pressure;
	}

	public Double getWindSpeed() {
		return windSpeed;
	}

	public void setWindSpeed(Double windSpeed) {
		this.windSpeed = windSpeed;
	}

	public Double getRainChance() {
		return rainChance;
	}

	public void setRainChance(Double rainChance) {
		this.rainChance = rainChance;
	}

	public Double getUvIndex() {
		return uvIndex;
	}

	public void setUvIndex(Double uvIndex) {
		this.uvIndex = uvIndex;
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

