package com.jianmo.weather.demo.vo;

import java.util.List;

public class Weather {
    private static final long serialVersionUID=1L;
    private  Yesterday yesterday;
    private String city;
    private  String aqi;
    private List<Forecast> forecast;
    private String ganmao;
    private String wendu;

    public void setYesterday(Yesterday yesterday){
        this.yesterday=yesterday;
    }
    public Yesterday getYesterday(){
        return yesterday;
    }

    public void setCity(String city){
        this.city=city;
    }
    public String getCity(){
        return city;
    }

    public void setAqi(String aqi){
        this.aqi=aqi;
    }
    public String getAqi(){
        return aqi;
    }

    public void setForecast(List<Forecast> forecast){
        this.forecast=forecast;
    }
    public List<Forecast> getForecast(){
        return forecast;
    }

    public void setGanmao(String ganmao){
        this.ganmao=ganmao;
    }
    public String getGanmao(){
        return ganmao;
    }

    public void setWendu(String wendu){
        this.wendu=wendu;
    }
    public String getWendu(){
        return wendu;
    }
}
