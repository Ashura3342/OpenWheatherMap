package fr.wildcodeschool.openweathermap.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Weather implements Serializable {
    @SerializedName("weather")
    private ArrayList<WeatherInfo> weatherInfo;
    private Main main;
    @SerializedName("dt")
    private Date date;
    private int id;

    public ArrayList<WeatherInfo> getWeatherInfo() {
        return weatherInfo;
    }

    public void setWeatherInfo(ArrayList<WeatherInfo> weatherInfo) {
        this.weatherInfo = weatherInfo;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
