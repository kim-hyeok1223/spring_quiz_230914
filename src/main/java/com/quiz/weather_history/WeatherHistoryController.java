package com.quiz.weather_history;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.weather_history.bo.WeatherBO;
import com.quiz.weather_history.domain.Weather;

@RequestMapping("/weather-history")
@Controller
public class WeatherHistoryController {

	@Autowired
	private WeatherBO weatherBO;
	
	@GetMapping("/weather-list-view")
	public String weatherListView(Model model) {
		List<Weather> weather = weatherBO.getWeatherList();
		
		model.addAttribute("weather", weather);
		
		return "weather_history/weatherList";
	}
	
	//input : 날짜, 날씨, 미세먼지, 기온, 강수량, 풍속

	@GetMapping("/add-weahter-view")
	public String addWeatherView(
			@RequestParam("date") Date date,
			@RequestParam("weather") String weather,
			@RequestParam("microDust") String microDust,
			@RequestParam("temperatures") double temperatures,
			@RequestParam("precipitation") double precipitation,
			@RequestParam("windSpeed") double windSpeed) {
		
		weatherBO.addWeather(date, weather, microDust, temperatures, precipitation, windSpeed);
		return "weather_history/addWeather";
	}
	

	
}
