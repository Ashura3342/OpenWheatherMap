package fr.wildcodeschool.openweathermap.main.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import fr.wildcodeschool.openweathermap.R;

/**
 * @author : giallo_n
 */
public class WeatherViewHolder
        extends RecyclerView.ViewHolder
        implements IWeatherRowView {

    private DateFormat dateFormat
            = new SimpleDateFormat("dd/MM/YYYY hh:mm aaa");

    private TextView date;
    private TextView desc;
    private TextView temp;

    public WeatherViewHolder(@NonNull View itemView) {
        super(itemView);
        date = itemView.findViewById(R.id.weather_row_date);
        desc = itemView.findViewById(R.id.weather_row_desc);
        temp = itemView.findViewById(R.id.weather_row_temp);
    }

    @Override
    public void setDate(Date date) {
        this.date.setText(dateFormat.format(date));
    }

    @Override
    public void setDesc(String desc) {
        this.desc.setText(desc);
    }

    @Override
    public void setTemp(float temp) {
        this.temp.setText(String.format("%.2f°C", temp - 273.15));
    }
}
