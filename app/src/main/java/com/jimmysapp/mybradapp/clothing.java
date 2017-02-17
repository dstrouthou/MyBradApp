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


public class clothing extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clothing);

        String[] myclothes = {"Kirkgate Shopping Mall", "Forster Square Mall" };
        ListAdapter theAdapter = new ArrayAdapter<String>(this, R.layout.text_layout, R.id.textView39, myclothes);
        ListView theListView = (ListView) findViewById(R.id.clothingListView);
        theListView.setAdapter(theAdapter);

        theListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String itemClicked = String.valueOf(parent.getItemAtPosition(position));
                switch (itemClicked){
                    case "Kirkgate Shopping Mall":
                        Intent intent = new Intent(clothing.this, kirkgatemall.class);
                        startActivity(intent);
                        break;

                    case "Forster Square Mall":
                        Intent intent1 = new Intent(clothing.this, forstersquareshops.class);
                        startActivity(intent1);
                        break;

                }
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_clothing, menu);
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
