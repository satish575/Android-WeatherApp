package com.example.weatherapp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    TextView city;
    TextView country;
    TextView celcius;
    TextView feelLike;
    TextView condition;
    TextView wind;
    TextView humidity;
    ProgressBar progressBar;
    RecyclerView recycleView;


    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        city=findViewById(R.id.place);
        country=findViewById(R.id.country);
        celcius=findViewById(R.id.celcius);
        feelLike=findViewById(R.id.feelLike);
        img=findViewById(R.id.img);
        condition=findViewById(R.id.condition);
        wind=findViewById(R.id.windValue);
        humidity=findViewById(R.id.himidityValue);
        recycleView=findViewById(R.id.recycleView);

        ApiService apiService=RetrofitClient.getRetrofitClient().create(ApiService.class);



        apiService.getWeather("6bc1a97072ba4c1eb18152815240507","kathmandu").enqueue(new Callback<Weather>() {
            @Override
            public void onResponse(Call<Weather> call, Response<Weather> response) {

                if(response.isSuccessful()){

                    Weather weather=response.body();
                    city.setText(weather.getLocation().getName());
                    country.setText(weather.getLocation().getCountry());
                    celcius.setText(Double.toString(weather.getCurrent().getTemperature())+" °C");
                    feelLike.setText("feels like "+Double.toString(weather.getCurrent().getFeelsLike())+" °C");
                    Glide.with(MainActivity.this).load("https:"+weather.getCurrent().getCondition().getIcon()).into(img);
                  //  Log.d("successForFetch", "onResponse: "+response.body().getLocation().getName());
                    //https://cdn.weatherapi.com/weather/64x64/night/116.png
                    condition.setText(weather.getCurrent().getCondition().getText());
                    wind.setText(Double.toString(weather.getCurrent().getWind())+" km/hr");
                    humidity.setText(Double.toString(weather.getCurrent().getHumidity())+" %");
                }
            }

            @Override
            public void onFailure(Call<Weather> call, Throwable t) {
                Log.d("Failurewhilefetch", "onFailure: failed...");
            }
        });
        String[] names={"satish","mishra"};
        ForcastRecyclarAdapter forcastRecyclarAdapter=new ForcastRecyclarAdapter(Arrays.asList(names));
        recycleView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        recycleView.setAdapter(forcastRecyclarAdapter);

    }
}