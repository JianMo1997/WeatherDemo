package com.jianmo.weather.demo.vo;

public class WeatherResponse {
    private static final long serialVersionUID=1L;
    private Weather data;
    private int status;
    private String desc;

    public void setData(Weather data){
        this.data=data;
    }
    public Weather getData(){
        return data;
    }

    public void setStatus(int status){
        this.status=status;
    }
    public int getStatus(){
        return status;
    }

    public void setDesc(String desc){
        this.desc=desc;
    }
    public String getDesc(){
        return desc;
    }
}
