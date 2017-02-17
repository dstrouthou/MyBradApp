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


public class fastfood extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fastfood);

        String[] myshops = {"Subway", "Burger Time", "Delichez", "Dunker's Delight", "My Lahore", "Omar's", "Royals", "Chicken Cottage", "Caspian", "Dixy's", "Oasis", "Cyrus"};
        ListAdapter theAdapter = new ArrayAdapter<String>(this, R.layout.text_layout, R.id.textView39, myshops);
        ListView theListView = (ListView) findViewById(R.id.fastfoodlistView);
        theListView.setAdapter(theAdapter);

        theListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String itemClicked = String.valueOf(parent.getItemAtPosition(position));
                switch (itemClicked){
                    case "Subway":
                        Intent intent = new Intent(fastfood.this, subway.class);
                        startActivity(intent);
                        break;

                    case "Burger Time":
                        Intent intent1 = new Intent(fastfood.this, burgertime.class);
                        startActivity(intent1);
                        break;

                    case "Delichez":
                        Intent intent2 = new Intent(fastfood.this, delichez.class);
                        startActivity(intent2);
                        break;

                    case "Dunker's Delight":
                        Intent intent3 = new Intent(fastfood.this, dunkers.class);
                        startActivity(intent3);
                        break;

                    case "My Lahore":
                        Intent intent4 = new Intent(fastfood.this, mylahore.class);
                        startActivity(intent4);
                        break;

                    case "Omar's":
                        Intent intent5 = new Intent(fastfood.this, omars.class);
                        startActivity(intent5);
                        break;

                    case "Royals":
                        Intent intent6 = new Intent(fastfood.this, royals.class);
                        startActivity(intent6);
                        break;

                    case "Chicken Cottage":
                        Intent intent7 = new Intent(fastfood.this, chickencottage.class);
                        startActivity(intent7);
                        break;

                    case "Caspian":
                        Intent intent8 = new Intent(fastfood.this, caspianpizza.class);
                        startActivity(intent8);
                        break;

                    case "Dixy's":
                        Intent intent9 = new Intent(fastfood.this, dixys.class);
                        startActivity(intent9);
                        break;

                    case "Oasis":
                        Intent intent10 = new Intent(fastfood.this, oasis.class);
                        startActivity(intent10);
                        break;

                    case "Cyrus":
                        Intent intent11 = new Intent(fastfood.this, cyrus.class);
                        startActivity(intent11);
                        break;

                }
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_fastfood, menu);
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
