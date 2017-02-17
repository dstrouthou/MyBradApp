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


public class kirkgatemall extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kirkgatemall);

        String[] myshops = {"Primark", "River Island", "Bank Fashion", "Sports Direct", "Argos" };
        ListAdapter theAdapter = new ArrayAdapter<String>(this, R.layout.text_layout, R.id.textView39, myshops);
        ListView theListView = (ListView) findViewById(R.id.kirkgateListView);
        theListView.setAdapter(theAdapter);

        theListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String itemClicked = String.valueOf(parent.getItemAtPosition(position));
                switch (itemClicked){
                    case "Primark":
                        Intent intent = new Intent(kirkgatemall.this, primark.class);
                        startActivity(intent);
                        break;

                    case "River Island":
                        Intent intent1 = new Intent(kirkgatemall.this, riverisland.class);
                        startActivity(intent1);
                        break;

                    case "Bank Fashion":
                        Intent intent2 = new Intent(kirkgatemall.this, bank.class);
                        startActivity(intent2);
                        break;

                    case "Sports Direct":
                        Intent intent3 = new Intent(kirkgatemall.this, sportsdirect.class);
                        startActivity(intent3);
                        break;

                    case "Argos":
                        Intent intent4 = new Intent(kirkgatemall.this, argos.class);
                        startActivity(intent4);
                        break;

                }
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_kirkgatemall, menu);
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
