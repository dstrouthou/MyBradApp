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


public class opticians extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opticians);

        String[] myopticians = {"Specsavers Opticians", "Boots Opticians", "Sidney Fraser Opticians", "City Eyeweare Opticians"};
        ListAdapter theAdapter = new ArrayAdapter<String>(this, R.layout.text_layout, R.id.textView39, myopticians);
        ListView theListView = (ListView) findViewById(R.id.opticiansListView);
        theListView.setAdapter(theAdapter);

        theListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String itemClicked = String.valueOf(parent.getItemAtPosition(position));
                switch (itemClicked){
                    case "Specsavers Opticians":
                        Intent intent = new Intent(opticians.this, specsaversopt.class);
                        startActivity(intent);
                        break;

                    case "Boots Opticians":
                        Intent intent2 = new Intent(opticians.this, bootsopt.class);
                        startActivity(intent2);
                        break;

                    case "Sidney Fraser Opticians":
                        Intent intent3 = new Intent(opticians.this, sidneyopt.class);
                        startActivity(intent3);
                        break;

                    case "City Eyeweare Opticians":
                        Intent intent4 = new Intent(opticians.this, cityeyeopt.class);
                        startActivity(intent4);
                        break;
                }
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_opticians, menu);
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
