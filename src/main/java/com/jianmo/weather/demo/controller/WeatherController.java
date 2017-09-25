package com.jianmo.weather.demo.controller;


import com.alibaba.fastjson.JSONObject;
import com.jianmo.weather.demo.dao.WeatherDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/weather")
public class WeatherController {
    Logger logger= LoggerFactory.getLogger(WeatherController.class);

//    @RequestMapping("/cityId/{cityId}")
//    public WeatherResponse getReportByCityId(@PathVariable("cityId") String cityId){
//        return weatherDataService.getDataByCityId(cityId);
//    }

//    @RequestMapping("/cityName/{cityName}")
//    public WeatherResponse getReportByCityName(@PathVariable("cityName") String cityName){
//        return  weatherDataService.getDataByCityName(cityName);
//    }

    /**
     * 返回json格式
     * @param request
     * @return
     */
    @RequestMapping("/city")
    public JSONObject getResponse(HttpServletRequest request){
        WeatherDao weatherDao=new WeatherDao();
        JSONObject jsonObject=new JSONObject();
        String format=request.getParameter("format");
        logger.info(format);
        String cityId=request.getParameter("城市id");
        String cityName=request.getParameter("城市名");
        logger.info(cityId);
        logger.info(cityName);
        if ("cityname".equals(format)){
           jsonObject.put("response",weatherDao.getResportByCityId(cityId));
        }else if ("cityid".equals(format)){
           jsonObject.put("response",weatherDao.getResportByCityName(cityName));
        }else {
            logger.info("错误，请查看问题");
        }
        return jsonObject;
    }
}
