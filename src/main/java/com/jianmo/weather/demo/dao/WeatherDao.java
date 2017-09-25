package com.jianmo.weather.demo.dao;

import com.jianmo.weather.demo.service.WeatherDataService;
import com.jianmo.weather.demo.vo.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;

public class WeatherDao {
    @Autowired
    private WeatherDataService weatherDataService;

    public  WeatherResponse getResportByCityId(String cityId){
        return weatherDataService.getDataByCityName(cityId);
    }
    public  WeatherResponse getResportByCityName(String cityName){
        return weatherDataService.getDataByCityName(cityName);
    }
}
