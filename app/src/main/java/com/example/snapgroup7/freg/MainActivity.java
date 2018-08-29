package com.example.snapgroup7.freg;

import android.content.Intent;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {


    ListView listViewFl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listViewFl =(ListView)findViewById(R.id.listView);


        String url = "https://api.snapgroup.co/api/demo/flowers";

        final RequestQueue requestQueeue = Volley.newRequestQueue(MainActivity.this);
        final ArrayList<Flowers> flowerList = new ArrayList<Flowers>();


        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        Log.i("Response", response.toString());
                            try {
                                JSONArray data = response.getJSONArray("data");

                                for (int i =0 ; i< data.length();i++){
                                    JSONObject d = data.getJSONObject(i);
                                    Log.i("data",d.toString());
                                    flowerList.add(new Flowers(d.getString("name"),d.getString("best_season"),d.getString("image_link")));
                                }

                                FlowersListAdapter  adapter = new FlowersListAdapter(MainActivity.this,flowerList);
                                listViewFl.setAdapter(adapter);



                            } catch (final JSONException e) {
                                Log.e("error", "json parsing error " + e.getMessage());
                            }

                        }


                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO: Handle error

                    }
                });
        requestQueeue.add(jsonObjectRequest);


        ///////////////////////////////////////////////////////////////////////////////////////////

//        ListView listView = (ListView)findViewById(R.id.listView);
//        final ArrayList<Person> personList = new ArrayList<Person>();
//        personList.add(new Person("osyed",12,"https://scontent.fsdv3-1.fna.fbcdn.net/v/t1.0-1/c0.62.160.160/p160x160/21032394_1458980184185249_2020633729112850492_n.jpg?_nc_cat=0&oh=ddbafa366568ac928e544f16b1d41035&oe=5BEE292C"));
//        personList.add(new Person("mohamed",-1,"https://scontent.fsdv3-1.fna.fbcdn.net/v/t1.0-1/p160x160/39878780_2052206598177421_2111928774852345856_n.jpg?_nc_cat=0&oh=aa795b1e307a67af544780f2a9cd1513&oe=5C01C40C"));
//        personList.add(new Person("hosen",15,"https://scontent.fsdv3-1.fna.fbcdn.net/v/t1.0-1/c0.21.160.160/p160x160/40083559_294538994476552_2901268503145218048_n.jpg?_nc_cat=0&oh=5e1e6e0695148ef59b89858b1c126855&oe=5C3A2045"));
//        personList.add(new Person("abed",17,"https://scontent.fsdv3-1.fna.fbcdn.net/v/t1.0-1/p160x160/22728649_303250156825961_3174685739784669374_n.jpg?_nc_cat=0&oh=68584769f490c083bd9a9babeac3cd81&oe=5BFE1F59"));
//
//        PersonListAdapter  adapter = new PersonListAdapter(this,personList);
//        listView.setAdapter(adapter);
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Intent intent = new Intent(MainActivity.this,PersonDetails1.class);
//                intent.putExtra("name",personList.get(i).getName());
//                intent.putExtra("age",personList.get(i).getAge());
//                intent.putExtra("image",personList.get(i).getImagePath());
//                startActivityForResult(intent,1);
//            }
//        });


    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("deatils","onPause");
    }
}
