package com.myapplicationdev.android.demoweather;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter {
    Context parent_context;
    int layout_id;
    ArrayList<Weather> weatherList;

    public CustomAdapter(Context context, int resource, ArrayList<Weather> objects) {
        super(context, resource);
        this.parent_context = context;
        this.layout_id = resource;
        this.weatherList = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater) parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(layout_id, parent,false);

        TextView tvArea = rowView.findViewById(R.id.textViewArea);
        TextView tvForecast = rowView.findViewById(R.id.textViewForecast);

        Weather currentWeather = weatherList.get(position);
        tvArea.setText("Area: " + currentWeather.getArea());
        tvForecast.setText("Forecast: " + currentWeather.getForecast());

        return rowView;
    }
}