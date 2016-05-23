package com.example.hruski.weathercat;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hruski.weathercat.model.WeatherData;


public class CitiesAdapter extends BaseAdapter {

    private WeatherData[] items;
    private final LayoutInflater inflater;
    private final Resources resources;

    public CitiesAdapter(Context context){
        inflater = LayoutInflater.from(context);
        resources = context.getResources();
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
            view = inflater.inflate(R.layout.list_item_city, parent, false);
        }


        WeatherData item = getItem(position);
        TextView textView = (TextView) view.findViewById(R.id.title);//android.R ker je preddefiniran
        textView.setText(item.getName());

        final ImageView imageView = (ImageView) view.findViewById(R.id.image);
        new ImageTask(resources, imageView).execute(R.drawable.ic_sun);


/*
        Thread myThread = new Thread(new Runnable() { - basic thread
            @Override
            public void run() {
                try{
                    Thread.sleep(100);
                    Log.v("CitiesAdapter", "Operation finished on: " + Thread.currentThread().getName());
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        });
        myThread.start();

*/

        return view;
    }

    private static class ImageTask extends AsyncTask<Integer/* tip parametra */, Void, Drawable /* kaj dobimo nazaj iz threada */>{

        private final Resources resources;
        private final ImageView imageView;

        public ImageTask(Resources resources, ImageView imageView) {
            this.resources = resources;
            this.imageView = imageView;
        }

        @Override
        protected Drawable doInBackground(Integer... params) { //ta se izvaja na background threadu
            return resources.getDrawable(params[0], null);
        }

        @Override
        protected void onPostExecute(Drawable drawable) { //ta se izvede na main threadu
            imageView.setImageDrawable(drawable);
        }
    }
}

