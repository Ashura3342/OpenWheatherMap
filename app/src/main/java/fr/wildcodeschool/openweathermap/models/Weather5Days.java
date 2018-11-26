package fr.wildcodeschool.openweathermap.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * @author : giallo_n
 */
public class Weather5Days implements Serializable {
    private City city;
    @SerializedName("list")
    private List<Weather> weathers;

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public List<Weather> getWeathers() {
        return weathers;
    }

    public void setWeathers(List<Weather> weathers) {
        this.weathers = weathers;
    }
}
