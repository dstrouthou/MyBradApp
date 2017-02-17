package com.jimmysapp.mybradapp;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;


public class adminactivity extends ActionBarActivity {

    DBAdapter dbAdapter;
    Context context = this;
    private SQLiteDatabase db;
    String selectQuery = "SELECT * FROM DATABASE_TABLE ORDER NAME;";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_adminactivity);

        dbAdapter = new DBAdapter(context);
        dbAdapter.open();
        populateListView();


    }

    private void populateListView() {
        Cursor cursor = dbAdapter.getAllRows();
        String[] fromFieldNames = new String[] {DBAdapter.NAME, DBAdapter.SURNAME, DBAdapter.USERNAME, DBAdapter.PASSWORD, DBAdapter.EMAIL, DBAdapter.CEMAIL};
        int[] toViewIDs = new int[] {R.id.nametxt, R.id.surnametxt, R.id.usernametxt, R.id.passwordtxt, R.id.emailtxt, R.id.cemailtxt};

        SimpleCursorAdapter myCursorAdapter;
        myCursorAdapter = new SimpleCursorAdapter(getBaseContext(), R.layout.activity_adminactivity, cursor, fromFieldNames, toViewIDs, 0);
        ListView myList = (ListView) findViewById(R.id.adminlistView);
        myList.setAdapter(myCursorAdapter);

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_adminactivity, menu);
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
