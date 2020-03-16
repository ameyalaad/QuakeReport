package com.example.quakereport;

import android.app.Activity;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {
    private static final String LOCATION_SEPARATOR = " of ";


    public EarthquakeAdapter(Activity context, ArrayList<Earthquake> events) {
        super(context, 0, events);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.custom_adapter, parent, false
            );
        }

        Earthquake shown = getItem(position);
        TextView mag = (TextView) listItemView.findViewById(R.id.magnitude);
        TextView offset = (TextView) listItemView.findViewById(R.id.offset);
        TextView location = (TextView) listItemView.findViewById(R.id.location);
        TextView date = (TextView) listItemView.findViewById(R.id.date);
        TextView time = (TextView) listItemView.findViewById(R.id.time);

        GradientDrawable bg = (GradientDrawable) mag.getBackground();
        int magnitudeColor = ContextCompat.getColor(getContext(), getMagnitudeColor(shown.getMagnitude()));
        bg.setColor(magnitudeColor);
        Double magn = shown.getMagnitude();
        DecimalFormat decimalFormat = new DecimalFormat("0.0");
        mag.setText(decimalFormat.format(magn));


        String loc = shown.getLocation();

        if (loc.contains(LOCATION_SEPARATOR)) {
            String[] data = loc.split(LOCATION_SEPARATOR);
            offset.setText(data[0] + LOCATION_SEPARATOR);
            location.setText(data[1]);
        } else {
            offset.setText(R.string.near_the);
            location.setText(loc);
        }


        Long timeInms = shown.getTime();
        Date realDate = new Date(timeInms);

        SimpleDateFormat dateFormatter = new SimpleDateFormat("MMM dd, yyyy");
        String displayDate = dateFormatter.format(realDate);

        dateFormatter = new SimpleDateFormat("h:mm a");
        String displayTime = dateFormatter.format(realDate);

        date.setText(displayDate);
        time.setText(displayTime);

        return listItemView;
    }

    private int getMagnitudeColor(double mag) {
        switch ((int) mag) {
            case 0:
            case 1:
                return R.color.magnitude1;
            case 2:
                return R.color.magnitude2;
            case 3:
                return R.color.magnitude3;
            case 4:
                return R.color.magnitude4;
            case 5:
                return R.color.magnitude5;
            case 6:
                return R.color.magnitude6;
            case 7:
                return R.color.magnitude7;
            case 8:
                return R.color.magnitude8;
            case 9:
                return R.color.magnitude9;
            default:
                return R.color.magnitude10plus;
        }

    }
}
