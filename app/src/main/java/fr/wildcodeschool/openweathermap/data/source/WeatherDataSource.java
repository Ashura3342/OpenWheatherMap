package fr.wildcodeschool.openweathermap.data.source;

import fr.wildcodeschool.openweathermap.models.Weather5Days;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherDataSource {

    @GET("forecast/")
    Call<Weather5Days> getWeatherTo5Days(@Query("q") String city);
}
