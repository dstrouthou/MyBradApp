package com.jimmysapp.mybradapp;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;


public class forstersquareshops extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forstersquareshops);

        String[] myshops2 = {"Next", "Topshop", "JD Sports", "Sports Direct", "Mothercare", "Currys", "Asda", "Argos", "TK Maxx" };
        ListAdapter theAdapter = new ArrayAdapter<String>(this, R.layout.text_layout, R.id.textView39, myshops2);
        ListView theListView = (ListView) findViewById(R.id.forstersquarelistView);
        theListView.setAdapter(theAdapter);

        theListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String itemClicked = String.valueOf(parent.getItemAtPosition(position));
                switch (itemClicked){
                    case "Next":
                        Intent intent = new Intent(forstersquareshops.this, next.class);
                        startActivity(intent);
                        break;

                    case "Topshop":
                        Intent intent1 = new Intent(forstersquareshops.this, topshop.class);
                        startActivity(intent1);
                        break;

                    case "JD Sports":
                        Intent intent2 = new Intent(forstersquareshops.this, jdsports.class);
                        startActivity(intent2);
                        break;

                    case "Sports Direct":
                        Intent intent3 = new Intent(forstersquareshops.this, sportsdirectforster.class);
                        startActivity(intent3);
                        break;

                    case "Mothercare":
                        Intent intent5 = new Intent(forstersquareshops.this, mothercare.class);
                        startActivity(intent5);
                        break;

                    case "Currys":
                        Intent intent6 = new Intent(forstersquareshops.this, currys.class);
                        startActivity(intent6);
                        break;

                    case "Asda":
                        Intent intent7 = new Intent(forstersquareshops.this, asda.class);
                        startActivity(intent7);
                        break;

                    case "Argos":
                    Intent intent4 = new Intent(forstersquareshops.this, argosforster.class);
                    startActivity(intent4);
                    break;

                    case "TK Maxx":
                        Intent intent8 = new Intent(forstersquareshops.this, tkmax.class);
                        startActivity(intent8);
                        break;
                }
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_forstersquareshops, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
