package com.jianmo.weather.demo.dao;

import com.jianmo.weather.demo.service.impl.WeatherDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WeatherDaoTest {
    @Autowired
    private WeatherDao weatherDao;
    String cityName="金华";
    @Test
    public void WeatherTest(){
        System.out.println(cityName);
        weatherDao.getResportByCityName(cityName);
    }

}
