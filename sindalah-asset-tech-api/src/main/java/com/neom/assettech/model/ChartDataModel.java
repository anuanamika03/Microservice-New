package com.neom.assettech.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="chartdata")

public class ChartDataModel extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1439000618302413069L;
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name ="chartdata_Id")
	private Integer chartdataId;
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name = "timestamp")
	private Date Timestamp;
	
	
	@Column(name = "Temperature")
	private double[] Temperature;

	@Column(name = "Humidity")
	private double[] Humidity;
	
	@Column(name = "rain_chance")
	private double[] RainChance;
	
	@Column(name="wind_speed")
	private double[] WindSpeed;
	
	@Column(name="Pressure")
	private double[] Pressure;
	
	@Column(name="UvIndex")
	private double[] UvIndex;
	
	@Column(name="xAxis")
	private String[] xAxis;
	
	@Transient
	private int AxisZone;

	public Integer getChartdataId() {
		return chartdataId;
	}

	public void setChartdataId(Integer chartdataId) {
		this.chartdataId = chartdataId;
	}

	public Date getTimestamp() {
		return Timestamp;
	}

	public void setTimestamp(Date timestamp) {
		Timestamp = timestamp;
	}

	public double[] getTemperature() {
		return Temperature;
	}

	public void setTemperature(double[] temperature) {
		Temperature = temperature;
	}

	public double[] getHumidity() {
		return Humidity;
	}

	public void setHumidity(double[] humidity) {
		Humidity = humidity;
	}

	public double[] getRainChance() {
		return RainChance;
	}

	public void setRainChance(double[] rainChance) {
		RainChance = rainChance;
	}

	public double[] getWindSpeed() {
		return WindSpeed;
	}

	public void setWindSpeed(double[] windSpeed) {
		WindSpeed = windSpeed;
	}

	public double[] getPressure() {
		return Pressure;
	}

	public void setPressure(double[] pressure) {
		Pressure = pressure;
	}

	public double[] getUvIndex() {
		return UvIndex;
	}

	public void setUvIndex(double[] uvIndex) {
		UvIndex = uvIndex;
	}

	public String[] getxAxis() {
		return xAxis;
	}

	public void setxAxis(String[] xAxis) {
		this.xAxis = xAxis;
	}

	public int getAxisZone() {
		return AxisZone;
	}

	public void setAxisZone(int axisZone) {
		AxisZone = axisZone;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

	
}

