package com.neom.assettech.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
@Entity
@Table(name="weatherdatahistory")
public class WeatherDataHistoryModel extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2486947092027523819L;

//	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "weatherdatahistory_Id")
		private Integer weatherdatahistoryId;
		
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
		
		
		@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
		@Column(name = "timestamp")
		private Date Timestamp;




		public Integer getWeatherdatahistoryId() {
			return weatherdatahistoryId;
		}


		public void setWeatherdatahistoryId(Integer weatherdatahistoryId) {
			this.weatherdatahistoryId = weatherdatahistoryId;
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


		public Date getTimestamp() {
			return Timestamp;
		}


		public void setTimestamp(Date timestamp) {
			Timestamp = timestamp;
		}


		public static long getSerialversionuid() {
			return serialVersionUID;
		}
		
		
		
	
	

}
