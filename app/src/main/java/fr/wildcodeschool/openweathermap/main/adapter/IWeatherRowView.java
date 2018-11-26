package fr.wildcodeschool.openweathermap.main.adapter;

import java.util.Date;

import fr.wildcodeschool.openweathermap.base.IMvpView;

/**
 * @author : giallo_n
 */
public interface IWeatherRowView extends IMvpView {
    void setDate(Date date);

    void setDesc(String desc);

    void setTemp(float temp);
}
