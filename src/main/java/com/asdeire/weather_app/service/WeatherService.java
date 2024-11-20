package com.asdeire.weather_app.service;

import com.asdeire.weather_app.model.Weather;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class WeatherService {

    @Value("${openweathermap.api-key}")
    private String apiKey;

    @Value("${openweathermap.base-url}")
    private String baseUrl;

    @Value("${openweathermap.icon-url}")
    private String iconUrl;

    private final RestTemplate restTemplate = new RestTemplate();

    public Weather getWeather(String city) {
        String url = String.format("%s/weather?q=%s&units=metric&appid=%s", baseUrl, city, apiKey);

        var response = restTemplate.getForObject(url, Map.class);
        if (response == null) throw new RuntimeException("Weather data not found");

        Weather weather = new Weather();
        weather.setCityName((String) response.get("name"));
        weather.setCountry((String) ((Map) response.get("sys")).get("country"));
        weather.setDescription((String) ((Map) ((List) response.get("weather")).get(0)).get("description"));
        weather.setTemperature((Double) ((Map) response.get("main")).get("temp"));
        weather.setIcon(iconUrl + ((Map) ((List) response.get("weather")).get(0)).get("icon") + ".png");

        return weather;
    }

    public List<Weather> getWeeklyForecast(String city) {
        String url = String.format("%s/forecast?q=%s&units=metric&cnt=5&appid=%s", baseUrl, city, apiKey);

        var response = restTemplate.getForObject(url, Map.class);
        if (response == null) throw new RuntimeException("Weekly forecast data not found");

        List<Map<String, Object>> dailyForecast = (List<Map<String, Object>>) response.get("list");
        List<Weather> weeklyWeather = new ArrayList<>();

        for (Map<String, Object> day : dailyForecast) {
            Weather weather = new Weather();
            weather.setTemperature((Double) ((Map<String, Object>) day.get("main")).get("temp"));

            List<Map<String, Object>> weatherList = (List<Map<String, Object>>) day.get("weather");
            weather.setDescription((String) weatherList.get(0).get("description"));

            weather.setIcon(iconUrl + weatherList.get(0).get("icon") + ".png");

            weeklyWeather.add(weather);
        }

        return weeklyWeather;
    }

}
