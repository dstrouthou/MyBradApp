package com.jimmysapp.mybradapp;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.content.Intent;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;


public class Cafes extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cafes);

        String[] mycafes = {"Starbucks", "Costa Coffee", "Cafe East", "Richmond Coffee Shop"};
        ListAdapter theAdapter = new ArrayAdapter<String>(this, R.layout.text_layout, R.id.textView39, mycafes);
        ListView theListView = (ListView) findViewById(R.id.cafelistView);
        theListView.setAdapter(theAdapter);

        theListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String itemclicked = String.valueOf(parent.getItemAtPosition(position));
                switch (itemclicked){
                    case "Starbucks":
                        Intent intent = new Intent(Cafes.this, starbucks.class);
                        startActivity(intent);
                        break;
                    case "Costa Coffee":
                        Intent intent1 = new Intent(Cafes.this, costacoffee.class);
                        startActivity(intent1);
                        break;
                    case "Cafe East":
                        Intent intent2 = new Intent(Cafes.this, cafeeast.class);
                        startActivity(intent2);
                        break;
                    case "Richmond Coffee Shop":
                        Intent intent3 = new Intent(Cafes.this, richmondcoffeeshop.class);
                        startActivity(intent3);
                        break;
                }
            }
        });
    }




}
