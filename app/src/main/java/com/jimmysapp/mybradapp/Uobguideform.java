package com.jimmysapp.mybradapp;

import android.os.Build;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.content.Intent;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;


public class Uobguideform extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uobguideform);

        String[] mybuildings = {"Richmond", "Horton", "Chesham", "Phoenix", "Ashfield", "Norcroft", "Atrium", "Pemberton", "Library", "Sports Leisure", "The Green", "Student Central"};
        ListAdapter theAdapter = new ArrayAdapter<String>(this, R.layout.text_layout, R.id.textView39, mybuildings);
        ListView theListView = (ListView) findViewById(R.id.UobGuideListView);
        theListView.setAdapter(theAdapter);

        theListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String itemClicked = String.valueOf(parent.getItemAtPosition(position));
                switch (itemClicked){
                    case "Richmond":
                        Intent intent = new Intent(Uobguideform.this, Richmond.class);
                        startActivity(intent);
                        break;

                    case "Horton":
                        Intent intent1 = new Intent(Uobguideform.this, horton.class);
                        startActivity(intent1);
                        break;

                    case "Chesham":
                        Intent intent2 = new Intent(Uobguideform.this, chesham.class);
                        startActivity(intent2);
                        break;

                    case "Phoenix":
                        Intent intent3 = new Intent(Uobguideform.this, phoenix.class);
                        startActivity(intent3);
                        break;

                    case "Ashfield":
                        Intent intent4 = new Intent(Uobguideform.this, ashfield.class);
                        startActivity(intent4);
                        break;

                    case "Norcroft":
                        Intent intent5 = new Intent(Uobguideform.this, norcroft.class);
                        startActivity(intent5);
                        break;

                    case "Atrium":
                        Intent intent12 = new Intent(Uobguideform.this, atrium.class);
                        startActivity(intent12);
                        break;

                    case "Pemberton":
                        Intent intent11 = new Intent(Uobguideform.this, pemberton.class);
                        startActivity(intent11);
                        break;

                    case "Library":
                        Intent intent6 = new Intent(Uobguideform.this, library.class);
                        startActivity(intent6);
                        break;

                    case "Sports Leisure":
                        Intent intent7 = new Intent(Uobguideform.this, sportsleisure.class);
                        startActivity(intent7);
                        break;

                    case "The Green":
                        Intent intent8 = new Intent(Uobguideform.this, thegreen.class);
                        startActivity(intent8);
                        break;

                    case "Student Central":
                        Intent intent9 = new Intent(Uobguideform.this, studentcentral.class);
                        startActivity(intent9);
                        break;


                }
            }
        });

    }
}

