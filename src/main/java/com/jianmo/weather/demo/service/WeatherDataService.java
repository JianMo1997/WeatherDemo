package com.jianmo.weather.demo.service;

import com.jianmo.weather.demo.vo.WeatherResponse;

public interface WeatherDataService {

    /**
     * 根据城市的编号查找天气
     * @param cityId
     * @return
     */
    WeatherResponse getDataByCityId(String cityId);

    /**
     * 根据城市名称查找天气
     * @param cityName
     * @return
     */
    WeatherResponse getDataByCityName(String cityName);
}
