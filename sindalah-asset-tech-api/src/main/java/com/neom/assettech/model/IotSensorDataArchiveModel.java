package com.neom.assettech.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "iot_sensor_data_archive")
public class IotSensorDataArchiveModel extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2907368009408904915L;
	
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "iot_sensor_data_archive_id")
	private Integer iotsensordataarchiveId;
	

	@Column(name = "sensor_data_id")
	private Integer sensorDataId;
	
	@Column(name = "location_id")
	private Integer locationId;
	
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
	
	@Column(name = "datatimestamp")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date datatimestamp;
	
	@Transient
	private String AQIinterpretlabel;
	
	public Integer getIotsensordataarchiveId() {
		return iotsensordataarchiveId;
	}

	public void setIotsensordataarchiveId(Integer iotsensordataarchiveId) {
		this.iotsensordataarchiveId = iotsensordataarchiveId;
	}


	public String getAQIinterpretlabel() {
		return AQIinterpretlabel;
	}

	public void setAQIinterpretlabel(String aQIinterpretlabel) {
		AQIinterpretlabel = aQIinterpretlabel;
	}

	public Integer getSensorDataId() {
		return sensorDataId;
	}

	public void setSensorDataId(Integer sensorDataId) {
		this.sensorDataId = sensorDataId;
	}

	public Integer getLocationId() {
		return locationId;
	}

	public void setLocationId(Integer locationId) {
		this.locationId = locationId;
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

	public Date getDatatimestamp() {
		return datatimestamp;
	}

	public void setDatatimestamp(Date datatimestamp) {
		this.datatimestamp = datatimestamp;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


}
