package com.jianmo.weather.demo.controller;


import com.alibaba.fastjson.JSONObject;
import com.jianmo.weather.demo.service.impl.WeatherDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/weather")
public class WeatherController {
    Logger logger= LoggerFactory.getLogger(WeatherController.class);
    @Autowired
    private WeatherDao weatherDao;
    /**
     * 返回json格式
     * @param request
     * @return
     */
    @RequestMapping("/city")
    public JSONObject getResponse(HttpServletRequest request){
        JSONObject jsonObject=new JSONObject();
        String format=request.getParameter("format");
        logger.info(format);
        if ("cityname".equals(format)){
            String cityName=request.getParameter("城市名");
            logger.info("cityName:"+cityName);
            jsonObject.put("response",weatherDao.getResportByCityName(cityName));
        }else if ("cityid".equals(format)){
            String cityId=request.getParameter("城市id");
            logger.info("cityId:"+cityId);
            jsonObject.put("response",weatherDao.getResportByCityId(cityId));
        }else {
            logger.info("错误，请查看问题");
        }
        return jsonObject;
    }



//    @RequestMapping("/cityId/{cityId}")
//    public WeatherResponse getReportByCityId(@PathVariable("cityId") String cityId){
//        return weatherDataService.getDataByCityId(cityId);
//    }

//    @RequestMapping("/cityName/{cityName}")
//    public WeatherResponse getReportByCityName(@PathVariable("cityName") String cityName){
//        return  weatherDataService.getDataByCityName(cityName);
//    }

}
