package com.example.snapgroup7.freg;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class PersonDetails1 extends AppCompatActivity {

    TextView nameTvSec;
    TextView ageTvSec;
    ImageView pathIv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_details1);
        String name = getIntent().getExtras().getString("name");
        int age =getIntent().getExtras().getInt("age");
        String image =getIntent().getExtras().getString("image");

        nameTvSec = (TextView)findViewById(R.id.nameSecTv);
        ageTvSec = (TextView)findViewById(R.id.ageSecTV);
        pathIv = (ImageView)findViewById(R.id.imageSecTv);

        nameTvSec.setText(name.toString());
        ageTvSec.setText(age + "years old");
        Picasso.with(this).load(image.toString()).into(pathIv);


        Log.i("deatils",name + ", " + age +" ," + image);
    }
}
