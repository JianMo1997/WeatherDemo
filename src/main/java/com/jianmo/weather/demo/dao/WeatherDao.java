package com.jianmo.weather.demo.dao;

import com.jianmo.weather.demo.service.WeatherDataService;
import com.jianmo.weather.demo.vo.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherDao {
    @Autowired
    private WeatherDataService weatherDataService ;

    public  WeatherResponse getResportByCityId(String cityId){
        return weatherDataService.getDataByCityId(cityId);
    }
    public  WeatherResponse getResportByCityName(String cityName){
        System.out.println("WeatherDao:"+cityName);
        return weatherDataService.getDataByCityName(cityName);
    }
}
