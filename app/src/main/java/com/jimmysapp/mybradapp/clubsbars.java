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


public class clubsbars extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clubsbars);

        String[] myclubs = {"Flares Reflex", "Tokyo", "Red Square", "The Sir Titus", "Tequila", "Revolution", "FND"};
        ListAdapter theAdapter = new ArrayAdapter<String>(this, R.layout.text_layout, R.id.textView39, myclubs);
        ListView theListView = (ListView) findViewById(R.id.clubsbarslistview);
        theListView.setAdapter(theAdapter);

        theListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String itemClicked = String.valueOf(parent.getItemAtPosition(position));
                switch (itemClicked){
                    case "Flares Reflex":
                        Intent intent = new Intent(clubsbars.this, flaresreflex.class);
                        startActivity(intent);
                        break;

                    case "Tokyo":
                        Intent intent1 = new Intent(clubsbars.this, tokyo.class);
                        startActivity(intent1);
                        break;

                    case "Red Square":
                        Intent intent2 = new Intent(clubsbars.this, redsquare.class);
                        startActivity(intent2);
                        break;

                    case "The Sir Titus":
                        Intent intent3 = new Intent(clubsbars.this, thesirtitus.class);
                        startActivity(intent3);
                        break;

                    case "Tequila":
                        Intent intent4 = new Intent(clubsbars.this, tequila.class);
                        startActivity(intent4);
                        break;

                    case "Revolution":
                        Intent intent5 = new Intent(clubsbars.this, revolution.class);
                        startActivity(intent5);
                        break;

                    case "FND":
                        Intent intent6 = new Intent(clubsbars.this, fnd.class);
                        startActivity(intent6);
                        break;
                }
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_clubsbars, menu);
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
