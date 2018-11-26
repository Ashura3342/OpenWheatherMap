package fr.wildcodeschool.openweathermap.main;

import fr.wildcodeschool.openweathermap.base.BasePresenter;
import fr.wildcodeschool.openweathermap.data.source.WeatherDataSource;
import fr.wildcodeschool.openweathermap.data.source.remote.RemoteWeather;
import fr.wildcodeschool.openweathermap.main.adapter.WeatherViewHolder;
import fr.wildcodeschool.openweathermap.models.Weather;
import fr.wildcodeschool.openweathermap.models.Weather5Days;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.internal.EverythingIsNonNull;

public class MainPresent<V extends IMainView>
        extends BasePresenter<V>
        implements IMainPresent<V> {

    private WeatherDataSource weatherDataSource;
    private Weather5Days weather5Days;
    private Call<Weather5Days> call;

    @Override
    public void attach(V view) {
        super.attach(view);
        weatherDataSource = RemoteWeather.getInstance()
                .getWeatherDataSource();
    }

    @Override
    public void detach() {
        super.detach();
        call.cancel();
    }

    @Override
    public void onGetWeather(String city) {
        call = weatherDataSource.getWeatherTo5Days(city);
        call.enqueue(new Callback<Weather5Days>() {
            @Override
            @EverythingIsNonNull
            public void onResponse(Call<Weather5Days> call, Response<Weather5Days> response) {
                if (response.isSuccessful() && response.body() != null) {
                    weather5Days = response.body();
                    getView().setCity(weather5Days.getCity());
                    getView().notifyWeatherInserted(getTripsRowsCount());
                } else if (response.errorBody() != null)
                    getView().showError(String.format("%d : %s", response.code(), response.message()));
            }

            @Override
            @EverythingIsNonNull
            public void onFailure(Call<Weather5Days> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    @Override
    public void onBindRepositoryRowViewAtPosition(WeatherViewHolder weatherViewHolder, int position) {
        if (weather5Days != null) {
            Weather weather = weather5Days.getWeathers().get(position);
            weatherViewHolder.setDate(weather.getDate());
            weatherViewHolder.setDesc(weather.getWeatherInfo().get(0).getDescription());
            weatherViewHolder.setTemp(weather.getMain().getTemp());
        }
    }

    @Override
    public int getTripsRowsCount() {
        return weather5Days != null ? weather5Days.getWeathers().size() : 0;
    }
}
