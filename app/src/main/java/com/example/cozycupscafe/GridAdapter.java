package com.example.cozycupscafe;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class GridAdapter extends BaseAdapter {

    private final Context context;
    private final int[] offeringImages;

    public GridAdapter(Context context, int[] offeringImages) {
        this.context = context;
        this.offeringImages = offeringImages;
    }


    @Override
    public int getCount() {
        return offeringImages.length;
    }


    @Override
    public Object getItem(int position) {
        return offeringImages[position];
    }


    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View gridItemView;


        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            gridItemView = inflater.inflate(R.layout.grid_item, parent, false);
        } else {
            gridItemView = convertView;
        }


        ImageView imageView = gridItemView.findViewById(R.id.gridImage);
        imageView.setImageResource(offeringImages[position]);

        return gridItemView;
    }
}
