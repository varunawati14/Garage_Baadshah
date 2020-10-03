package com.example.garagebaadshah.Maps;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.garagebaadshah.R;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

import static com.example.garagebaadshah.R.layout.custom_info_window;

public class CustomInfoWindow implements GoogleMap.InfoWindowAdapter {

    private View view;
    private LayoutInflater layoutInflater;
    private Context context;

    public CustomInfoWindow(Context context) {
        this.context=context;

        layoutInflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        view=layoutInflater.inflate(R.layout.custom_info_window,null);
    }

    private int getCustom_info_window() {
        return custom_info_window;
    }

    @Override
    public View getInfoWindow(Marker marker) {
        return null;
    }

    @Override
    public View getInfoContents(Marker marker) {
        TextView title=(TextView) view.findViewById(R.id.custext);
        title.setText(marker.getTitle());

        TextView dis=(TextView) view.findViewById(R.id.dista);
        dis.setText(marker.getSnippet());

        RatingBar rate=(RatingBar) view.findViewById(R.id.cusrate);
        rate.setRating(8);

        return view;
    }
}
