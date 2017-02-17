package com.jimmysapp.mybradapp;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;


public class admin extends ActionBarActivity {

    //DBAdapter dbAdapter;
    DBAdapter myDb;
    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_admin);
        openDB();
        populateListView();
    }

    private void openDB() {
        myDb = new DBAdapter(this);
        myDb.open();
    }




    private void populateListView() {
        Cursor cursor = myDb.getAllRows();
        String[] fromFieldNames = new String[] {DBAdapter.NAME, DBAdapter.SURNAME,
                DBAdapter.USERNAME, DBAdapter.PASSWORD, DBAdapter.EMAIL, DBAdapter.CEMAIL};
        int[] toViewIDs = new int[] {R.id.txtName, R.id.txtSurname, R.id.txtUsername,
                R.id.txtPassword, R.id.txtEmail, R.id.txtEmail1};

        SimpleCursorAdapter myCursorAdapter;
        myCursorAdapter = new SimpleCursorAdapter(getBaseContext(), R.layout.item_layout,
                cursor, fromFieldNames, toViewIDs, 0);
        ListView myList = (ListView) findViewById(R.id.adminlistview1);
        myList.setAdapter(myCursorAdapter);

    }

    public void onClickOptions(View view) {
        Intent v = new Intent(this, Mainform.class);
        startActivity(v);

    }

    public void onClickDelete(View view) {
        ListView myList = (ListView) findViewById(R.id.adminlistview1);
        myList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                myDb.deleteRow(id);
                Toast.makeText(admin.this, "Register successfully deleted!!", Toast.LENGTH_LONG).show();
                populateListView();
            }
        });
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_admin, menu);
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
