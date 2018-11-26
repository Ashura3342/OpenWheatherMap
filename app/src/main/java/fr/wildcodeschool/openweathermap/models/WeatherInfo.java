package fr.wildcodeschool.openweathermap.models;

import java.io.Serializable;

public class WeatherInfo implements Serializable {
    private int id;
    private String main;
    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
