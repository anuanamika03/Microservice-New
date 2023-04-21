package com.neom.assettech.constants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;

public interface AppConstants {
	
	
	public static String SUCCESS_MESSAGE_FOR_GET = "";
	public static String SUCCESS_MESSAGE_FOR_INSERT = "Record Successfully Created!";
	public static String SUCCESS_MESSAGE_FOR_UPDATE = "Record Successfully Updated!";
	public static String SUCCESS_MESSAGE_FOR_DELETE = "Records Successfully Deleted!";
	public static String WEATHER_API_PROPERTY_KEY = "open.weather.key";
	public static String WEATHER_FORECAST_URL = "https://api.openweathermap.org/data/2.5/forecast?lat=%s&lon=%s&appid=%s&units=metric";
	public static String WEATHER_URL = "https://api.openweathermap.org/data/2.5/weather?lat=%s&lon=%s&appid=%s&units=metric";
	public static String AQI_FORECAST_URL = "http://api.openweathermap.org/data/2.5/air_pollution/forecast?lat=%s&lon=%s&appid=%s";
	public static String AQI_URL = "http://api.openweathermap.org/data/2.5/air_pollution?lat=%s&lon=%s&appid=%s";
	public static String NEOM_IOT_WEATHER_API_URL = "https://iotsenseuat.oci.sense.neomos.online/mockup/fetch";
	public static String NEOM_IOT_LOGIN_API_URL = "https://iotsenseuat.oci.sense.neomos.online/Oauth2/token";
	public static String NEOM_SCOPE = "openid";
	public static String NEOM_GRANT_TYPE = "client_credentials";
	public static String NEOM_CLIENT_ID_KEY = "neom.api.client.id";
	public static String NEOM_CLIENT_SECRET_KEY = "neom.api.client.secret";
	
	public static String ARCHIVE_DAYS="data.archive.days";
	public static String ALERT_MSG_TEMP="alert.msg.temp";
	public static String ALERT_MSG_HUMD="alert.msg.humd";
	public static String ALERT_MSG_AQI="alert.msg.aqi";
	public static String ALERT_MSG_WEATHERPARAMTEMP="alert.msg.weatherparamtemp";
	public static String ALERT_MSG_WEATHERPARAMHUMID="alert.msg.weatherparamhumid";
	public static String ALERT_MSG_WEATHERPARAMAQI="alert.msg.weatherparamaqi";
	public static String CHART_VALUE_TEMP="chart.value.temp";
	public static String CHART_VALUE_HUMID="chart.value.humid";
	public static String CHART_VALUE_UVINDEX="chart.value.uvIndex";
	public static String CHART_VALUE_RAINCHANCE="chart.value.rainChance";
	public static String CHART_VALUE_PRESSURE="chart.value.pressure";
	public static String CHART_VALUE_WINDSPEED="chart.value.windSpeed";
	public static String CHART_VALUE_XAXIS="chart.value.xAxis";
	public static String IOTSENSE_VALUES_RAINCHANCEDEF="iotsense.values.rainchancedef";
	public static String IOTSENSE_VALUES_UVINDEXDEF="iotsense.values.uvindexdef";
	public static String JSON_DATE_FORMAT="yyyy-MM-dd HH:mm:ss";
	public static String  IOTSENSE_VALUES_AQI="iotsense.values.aqi";
	public static String NEOM_IOT_LOCAL="neom.iot.local";
	public static String CLIENT_KEY="client.key";
	public static String IOTSENSE_MSG_AQILABEL_100="iotsense.msg.aqilabel<100";
	public static String IOTSENSE_MSG_AQILABEL_200="iotsense.msg.aqilabel<200";
	public static String IOTSENSE_MSG_AQILABEL_300="iotsense.msg.aqilabel>200";

}
