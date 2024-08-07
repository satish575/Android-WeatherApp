package com.example.weatherapp;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class Current {


    @SerializedName("last_updated")
    private String last_updated;
    @SerializedName("temp_c")
    private double temperature;

    @SerializedName("feelslike_c")
    private double feelsLike;

    @SerializedName("condition")
    private Condition condition;

    @SerializedName("wind_kph")
    private double wind;

    @SerializedName("humidity")
    private double humidity;

    public double getWind() {
        return wind;
    }

    public void setWind(double wind) {
        this.wind = wind;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    public String getLast_updated() {
        return last_updated;
    }

    public double getFeelsLike() {
        return feelsLike;
    }

    public void setFeelsLike(double feelsLike) {
        this.feelsLike = feelsLike;
    }

    public void setLast_updated(String last_updated) {
        this.last_updated = last_updated;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }
}
