package com.example.hruski.weathercat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hruski.weathercat.model.WeatherData;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    public static final WeatherData[] DATA = new WeatherData[] {
            new WeatherData(3239318, "Mestna Občina Ljubljana", 13.91f),
            new WeatherData(3186843, "Občina Žalec", 13.91f),
            new WeatherData(3192062, "Občina Radovljica", 13.91f),
            new WeatherData(3197378, "Kranj", 13.91f),
            new WeatherData(3194351, "Novo Mesto", 13.91f),
            new WeatherData(3198647, "Jesenice", 13.91f),
            new WeatherData(3192241, "Ptuj", 13.91f),
            new WeatherData(3195506, "Maribor", 13.91f),
            new WeatherData(5128638, "New York", 13.91f),
            new WeatherData(1689973, "San Francisco", 13.91f),
            new WeatherData(3186886, "Zagreb", 13.91f),
            new WeatherData(2759794, "Amsterdam", 13.91f),
            new WeatherData(5056033, "London", 13.91f),
            new WeatherData(2950159, "Berlin", 13.91f),
            new WeatherData(2988507, "Paris", 13.91f),
            new WeatherData(292223, "Dubai", 13.91f),
            new WeatherData(1609350, "Bangkok", 13.91f),
            new WeatherData(1138958, "Kabul", 13.91f) };


    private CitiesAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG, "Hey");

        Button refresh = (Button) findViewById(R.id.button);

        refresh.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Log.i(TAG, "Refresh was clicked");
                        TextView text = (TextView) findViewById(R.id.textView);
                        text.setText(R.string.refresh);
                    }
                }

        );

        adapter = new CitiesAdapter(this);
        adapter.setItems(DATA);

        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                WeatherData item = adapter.getItem(position);

                Intent intent = new Intent (MainActivity.this, SecondActivity.class);
                intent.putExtra("city", item);
                startActivity(intent);
            }
        });

    }
}
