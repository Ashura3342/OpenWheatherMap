package fr.wildcodeschool.openweathermap.main;

import fr.wildcodeschool.openweathermap.base.IMvpView;
import fr.wildcodeschool.openweathermap.models.City;

public interface IMainView extends IMvpView {
    void notifyWeatherInserted(int size);

    void setCity(City city);

    void showError(String msg);
}
