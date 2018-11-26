package fr.wildcodeschool.openweathermap.main;

import fr.wildcodeschool.openweathermap.base.IMvpPresenter;
import fr.wildcodeschool.openweathermap.main.adapter.WeatherViewHolder;

public interface IMainPresent<V extends IMainView> extends IMvpPresenter<V> {
    void onGetWeather(String city);

    void onBindRepositoryRowViewAtPosition(WeatherViewHolder weatherViewHolder, int position);

    int getTripsRowsCount();
}
