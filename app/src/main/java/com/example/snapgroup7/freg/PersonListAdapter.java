package com.example.snapgroup7.freg;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class PersonListAdapter extends BaseAdapter {

    ArrayList<Person>  personList;
    Context context;

    public PersonListAdapter(Context context, ArrayList<Person> personList){
        this.context = context;
        this.personList = personList;
    }

    @Override
    public int getCount() {
        return personList.size();
    }

    @Override
    public Person getItem(int i) {
        return personList.get(i);
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
            view = layoutInflater.inflate(R.layout.person_item_layout, null);
        }

        TextView nameTv =  (TextView)view.findViewById(R.id.nameTv);
        TextView ageTv = (TextView)view.findViewById(R.id.ageTv);
        ImageView imageView = (ImageView) view.findViewById(R.id.personIv);
        nameTv.setText(personList.get(i).getName());
        Picasso.with(context).load(personList.get(i).getImagePath()).into(imageView);
        ageTv.setText(personList.get(i).getAge()+ " years old");
        if(personList.get(i).getAge() == -1){
            ageTv.setVisibility(View.GONE);
        }
        return view;
    }


}
