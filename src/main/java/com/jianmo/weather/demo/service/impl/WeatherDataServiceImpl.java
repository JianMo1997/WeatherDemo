package com.jianmo.weather.demo.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jianmo.weather.demo.vo.WeatherResponse;
import com.jianmo.weather.demo.service.WeatherDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.io.IOException;

@Service("WeatherDataService")
public class WeatherDataServiceImpl implements WeatherDataService{
    private static final Logger logger= LoggerFactory.getLogger(WeatherDataServiceImpl.class);
    @Resource
    RestTemplate restTemplate;

    private final String WEATHER_API="http://wthrcdn.etouch.cn/weather_mini";

    @Override
    public WeatherResponse getDataByCityId(String cityId){
        String url=WEATHER_API+"?citykey="+cityId;
        return this.doGetWeatherData(url);
    }

    @Override
    public WeatherResponse getDataByCityName(String cityName){
        String url=WEATHER_API+"?city="+cityName;
        return this.doGetWeatherData(url);
    }

    private WeatherResponse doGetWeatherData(String url){
        ResponseEntity<String> responseEntity=restTemplate.getForEntity(url,String.class);
        String strBody=null;
        if (responseEntity.getStatusCodeValue()==200){
            strBody=responseEntity.getBody();
        }

        ObjectMapper objectMapper=new ObjectMapper();
        WeatherResponse weatherResponse=null;
        try {
            weatherResponse=objectMapper.readValue(strBody,WeatherResponse.class);
        }catch (IOException e){
            logger.info("IOException:"+e.getMessage());
        }
        return weatherResponse;
    }
}
