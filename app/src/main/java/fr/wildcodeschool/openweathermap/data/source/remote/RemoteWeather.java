package fr.wildcodeschool.openweathermap.data.source.remote;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Date;

import fr.wildcodeschool.openweathermap.data.source.WeatherDataSource;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RemoteWeather {
    private static final String BASE_URL = "http://api.openweathermap.org/data/2.5/";

    private static RemoteWeather INSTANCE;
    private WeatherDataSource weatherDataSource;

    private RemoteWeather() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .registerTypeAdapter(Date.class, new DateTypeAdapter())
                .create();

        OkHttpClient httpClient = new OkHttpClient.Builder()
                .addInterceptor(LoggingInterceptor.getInstance())
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(httpClient)
                .build();

        weatherDataSource = retrofit.create(WeatherDataSource.class);
    }

    public static RemoteWeather getInstance() {
        if (INSTANCE == null)
            INSTANCE = new RemoteWeather();
        return INSTANCE;
    }

    public WeatherDataSource getWeatherDataSource() {
        return weatherDataSource;
    }
}
