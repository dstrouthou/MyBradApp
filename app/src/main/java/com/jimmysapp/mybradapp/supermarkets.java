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
import java.security.AccessController;
import java.util.ArrayList;
import java.util.List;

public class supermarkets extends ActionBarActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supermarkets);

        String[] stores = {"Sainsburys", "Tesco", "Tesco Express", "Lidl", "Morrisons", "Aldi", "Nisa Local", "Premier", "Daily News" };
        ListAdapter theAdapter = new ArrayAdapter<String>(this, R.layout.text_layout, R.id.textView39, stores);
        ListView theListView = (ListView) findViewById(R.id.theListView);
        theListView.setAdapter(theAdapter);

        theListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String itemClicked = String.valueOf(parent.getItemAtPosition(position));
                switch (itemClicked){
                    case "Sainsburys":
                        Intent intent = new Intent(supermarkets.this, sainsburys.class);
                        startActivity(intent);
                        break;

                    case "Tesco":
                        Intent intent1 = new Intent(supermarkets.this, tesco.class);
                        startActivity(intent1);
                        break;

                    case "Tesco Express":
                        Intent intent5 = new Intent(supermarkets.this, tescoexpress.class);
                        startActivity(intent5);
                        break;

                    case "Lidl":
                        Intent intent6 = new Intent(supermarkets.this, lidl.class);
                        startActivity(intent6);
                        break;

                    case "Morrisons":
                        Intent intent7 = new Intent(supermarkets.this, morissons.class);
                        startActivity(intent7);
                        break;

                    case "Aldi":
                        Intent intent8 = new Intent(supermarkets.this, aldi.class);
                        startActivity(intent8);
                        break;

                    case "Nisa Local":
                        Intent intent2 = new Intent(supermarkets.this, nisalocal.class);
                        startActivity(intent2);
                        break;

                    case "Premier":
                        Intent intent3 = new Intent(supermarkets.this, premier.class);
                        startActivity(intent3);
                        break;

                    case "Daily News":
                        Intent intent4 = new Intent(supermarkets.this, dailynews.class);
                        startActivity(intent4);
                        break;

                }
            }
        });

    }




}
