package com.jianmo.weather.demo.service;

import com.jianmo.weather.demo.vo.WeatherResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WeatherDataServiceTests {
    @Autowired
    WeatherDataService weatherDataService;
    @Test
    public void testGetDataByCityId(){
        WeatherResponse response = weatherDataService.getDataByCityName("金华");
        System.out.println(response.getData());
        System.out.println(response.getStatus());
        System.out.println(response.getDesc());
    }
}
