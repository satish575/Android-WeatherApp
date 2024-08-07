package com.example.weatherapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomGridAdapter extends BaseAdapter {

    private Context context;
    private String[] names;
    private int[] images;

    LayoutInflater inflater;

    CustomGridAdapter(Context context,String[] names,int[] images){
        this.context=context;
        this.names=names;
        this.images=images;

        inflater=LayoutInflater.from(this.context);
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

             convertView=inflater.inflate(R.layout.layout_grid_item,parent,false);
             TextView text=convertView.findViewById(R.id.txtGrid);
             ImageView imageView=convertView.findViewById(R.id.imgGrid);
             text.setText(names[position]);
             imageView.setImageResource(images[position]);
             return convertView;
    }
}
