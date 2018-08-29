package com.example.snapgroup7.freg;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Response;
import com.squareup.picasso.Picasso;

import org.json.JSONObject;

import java.util.ArrayList;

public class FlowersListAdapter extends BaseAdapter {

    ArrayList<Flowers> flowersList;
    Context context;

    public FlowersListAdapter(Context context, ArrayList<Flowers> flowersList){
        this.context = context;
        this.flowersList = flowersList;
    }


    @Override
    public int getCount() {
        return flowersList.size();
    }

    @Override
    public Object getItem(int i) {
        return flowersList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {

        View view = convertView;

        if (view == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            view = layoutInflater.inflate(R.layout.flowers, null);

            ImageView image = (ImageView)view.findViewById(R.id.imageFL);
            TextView name = (TextView)view.findViewById(R.id.nameFL);
            TextView best_season = (TextView)view.findViewById(R.id.bestSeasonFL);

            name.setText(flowersList.get(i).getName());
            best_season.setText(flowersList.get(i).getBest_season());
            Picasso.with(context).load(flowersList.get(i).getImage_link()).error(R.drawable.ic_launcher_background).into(image);


        }

        return view;
    }
}
