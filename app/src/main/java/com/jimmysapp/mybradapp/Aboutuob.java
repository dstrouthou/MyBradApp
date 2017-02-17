package com.jimmysapp.mybradapp;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.view.View;
import android.widget.ImageView;
import android.view.ViewGroup;
import java.util.List;
import java.util.ArrayList;
import android.widget.TextView;
import android.content.Intent;
import android.widget.Toast;
import java.util.List;

public class Aboutuob extends ActionBarActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutuob);

        String[] myguide = {"Cafes", "Supermarkets", "Fast Foods", "Clubs/Bars", "Clothing", "Transport", "Post Office", "Taxi", "Opticians"};
        ListAdapter theAdapter = new ArrayAdapter<String>(this, R.layout.text_layout, R.id.textView39, myguide);
        ListView theListView = (ListView) findViewById(R.id.AboutUobListView);
        theListView.setAdapter(theAdapter);

        theListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String itemClicked = String.valueOf(parent.getItemAtPosition(position));
                switch (itemClicked){
                    case "Cafes":
                        Intent intent = new Intent(Aboutuob.this, Cafes.class);
                        startActivity(intent);
                        break;

                    case "Supermarkets":
                        Intent intent1 = new Intent(Aboutuob.this, supermarkets.class);
                        startActivity(intent1);
                        break;

                    case "Fast Foods":
                        Intent intent2 = new Intent(Aboutuob.this, fastfood.class);
                        startActivity(intent2);
                        break;

                    case "Clubs/Bars":
                        Intent intent3 = new Intent(Aboutuob.this, clubsbars.class);
                        startActivity(intent3);
                        break;

                    case "Clothing":
                        Intent intent4 = new Intent(Aboutuob.this, clothing.class);
                        startActivity(intent4);
                        break;

                    case "Transport":
                        Intent intent9 = new Intent(Aboutuob.this, transport.class);
                        startActivity(intent9);
                        break;

                    case "Post Office":
                        Intent intent6 = new Intent(Aboutuob.this, postoffices.class);
                        startActivity(intent6);
                        break;

                    case "Taxi":
                        Intent intent7 = new Intent(Aboutuob.this, taxi.class);
                        startActivity(intent7);
                        break;

                    case "Opticians":
                        Intent intent8 = new Intent(Aboutuob.this, opticians.class);
                        startActivity(intent8);
                        break;
                }
            }
        });

    }
}


