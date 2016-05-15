package com.example.hruski.weathercat;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.hruski.weathercat.model.WeatherData;

public class SecondActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private WeatherData city;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Bundle extras = getIntent().getExtras();
        city =  extras.getParcelable("city");

        setTitle(city.getName());

        Resources resources = getResources();
        String text = resources.getString(R.string.temp, city.getMain().getTemp());

        TextView textView = (TextView) findViewById(R.id.temperature);
        textView.setText(text);

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "Main activity is on pause");
    }
}
