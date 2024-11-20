package com.asdeire.weather_app.model;

import lombok.Data;

@Data
public class Weather {
    private String cityName;
    private String country;
    private String description;
    private double temperature;
    private String icon;
}

