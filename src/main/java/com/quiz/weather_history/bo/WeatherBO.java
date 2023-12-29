package com.quiz.weather_history.bo;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.weather_history.domain.Weather;
import com.quiz.weather_history.mapper.WeatherMapper;

@Service
public class WeatherBO {

	@Autowired
	private WeatherMapper weatherMapper;
	
	public List<Weather> getWeatherList() {
		return weatherMapper.selectWeatherList();
	}
	
	
	
	//input : 날짜, 날씨, 미세먼지, 기온, 강수량, 풍속
	public void addWeather(Date date,String weather,String microDust,double temperatures,double precipitation,double windSpeed) {
		weatherMapper.insertWeather(date, weather, microDust, temperatures, precipitation, windSpeed);
	}
}
