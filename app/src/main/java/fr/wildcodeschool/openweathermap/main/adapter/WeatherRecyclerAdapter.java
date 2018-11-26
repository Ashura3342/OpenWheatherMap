package fr.wildcodeschool.openweathermap.main.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import fr.wildcodeschool.openweathermap.R;
import fr.wildcodeschool.openweathermap.main.IMainPresent;
import fr.wildcodeschool.openweathermap.main.IMainView;

/**
 * @author : giallo_n
 */
public class WeatherRecyclerAdapter extends RecyclerView.Adapter<WeatherViewHolder> {

    private IMainPresent<IMainView> presenter;

    public WeatherRecyclerAdapter(IMainPresent<IMainView> presenter) {
        this.presenter = presenter;
    }

    @NonNull
    @Override
    public WeatherViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        return new WeatherViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.weather_row, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull WeatherViewHolder weatherViewHolder, int i) {
        presenter.onBindRepositoryRowViewAtPosition(weatherViewHolder, i);
    }

    @Override
    public int getItemCount() {
        return presenter.getTripsRowsCount();
    }
}
