package com.quiz.weather_history.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.quiz.weather_history.domain.Weather;

@Mapper
public interface WeatherMapper {

	public List<Weather> selectWeatherList();
	
	public void insertWeather(Date date,String weather,String microDust,double temperatures,double precipitation,double windSpeed);
}
