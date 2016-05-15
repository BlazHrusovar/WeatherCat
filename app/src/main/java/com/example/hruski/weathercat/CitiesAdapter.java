package com.example.hruski.weathercat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.hruski.weathercat.model.WeatherData;


public class CitiesAdapter extends BaseAdapter {

    private WeatherData[] items;
    private final LayoutInflater inflater;

    public CitiesAdapter(Context context){
        inflater = LayoutInflater.from(context);
    }

    public void setItems(WeatherData[] items) {
        this.items = items;
        notifyDataSetChanged(); //vse še enkrat nariši kar je na zaslonu
    }

    @Override
    public int getCount() {
        if (items == null){
            return 0;
        } else {
            return items.length;
        }
    }

    @Override
    public WeatherData getItem(int position) { //če je 0 itemu, se ta metoda ne bo klicala
        return items[position];
    }

    @Override
    public long getItemId(int position) {
        return getItem(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;
        if (view == null){
            view = inflater.inflate(android.R.layout.simple_list_item_1, parent, false);
        }


        WeatherData item = getItem(position);
        TextView textView = (TextView) view.findViewById(android.R.id.text1);//android.R ker je pred definiran
        textView.setText(item.getName());




        return view;
    }
}
