package fr.wildcodeschool.openweathermap.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import fr.wildcodeschool.openweathermap.R;
import fr.wildcodeschool.openweathermap.main.adapter.WeatherRecyclerAdapter;
import fr.wildcodeschool.openweathermap.models.City;

public class MainActivity extends AppCompatActivity implements IMainView {

    private IMainPresent<IMainView> mainPresent = new MainPresent<>();
    private WeatherRecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainPresent.attach(this);
        RecyclerView results = findViewById(R.id.main_results);
        results.setLayoutManager(new LinearLayoutManager(this));
        adapter = new WeatherRecyclerAdapter(mainPresent);
        results.setAdapter(adapter);
        mainPresent.onGetWeather("Bordeaux,FR");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mainPresent.detach();
    }

    @Override
    public void setCity(City city) {
        setTitle(String.format("%s, %s", city.getName(), city.getCountry()));
    }

    @Override
    public void notifyWeatherInserted(final int size) {
        adapter.notifyItemRangeInserted(0, size);
    }

    @Override
    public void showError(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT)
                .show();
    }
}
