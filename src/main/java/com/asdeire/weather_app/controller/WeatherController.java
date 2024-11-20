package com.asdeire.weather_app.controller;

import com.asdeire.weather_app.model.Weather;
import com.asdeire.weather_app.service.WeatherService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/today")
    public String getWeatherToday(@RequestParam String city, Model model) {
        Weather weather = weatherService.getWeather(city);
        model.addAttribute("weather", weather);
        return "weather-today";
    }

    @GetMapping("/weekly")
    public String getWeatherWeekly(@RequestParam String city, Model model) {
        List<Weather> weeklyWeather = weatherService.getWeeklyForecast(city);
        model.addAttribute("weeklyWeather", weeklyWeather);
        model.addAttribute("city", city);
        return "weather-five";
    }
}

