package com.example.snapgroup7.firstapp;

import android.graphics.Color;
import android.net.wifi.p2p.WifiP2pManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity{


    EditText tx1;
    EditText tx2;
    TextView txtres;
    Button bt1;
    Button bt2;

    Random r = new Random();
    final int i1 = r.nextInt(10);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tx1= (EditText) findViewById(R.id.txt1);
        tx2= (EditText) findViewById(R.id.txt2);
        txtres= (TextView) findViewById(R.id.txtres);

        bt1= (Button)findViewById(R.id.bt1);
        bt2= (Button)findViewById(R.id.bt2);
        bt2.setEnabled(false);




        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(tx1.getText().toString().equals(i1)){
                    txtres.setText("sucsess");
                }
                else{
                    txtres.setText("next player");
                    bt1.setEnabled(false);
                    bt2.setEnabled(true);
                }

            }
        });

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(tx2.getText().toString().equals(i1)){
                    txtres.setText("sucsess");
                }
                else{
                    txtres.setText("next player");
                    bt2.setEnabled(false);
                    bt1.setEnabled(true);

                }

            }
        });

        txtres.setText(String.valueOf(i1));

    }



}
