package com.jimmysapp.mybradapp;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.content.Intent;
import android.view.Window;
import android.widget.Button;
import android.net.Uri;
import android.view.View.OnClickListener;



public class Mainform extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainform);

        Button btn = (Button) findViewById(R.id.bbbtn);
        btn.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Intent myWebLink = new Intent(android.content.Intent.ACTION_VIEW);
                myWebLink.setData(Uri.parse("https://blackboard.brad.ac.uk/webapps/portal/execute/tabs/tabAction?tab_tab_group_id=_14_1"));
                startActivity(myWebLink);
            }
        });

        Button button = (Button) findViewById(R.id.evisionbtn);
        button.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Intent myWebLink = new Intent(android.content.Intent.ACTION_VIEW);
                myWebLink.setData(Uri.parse("https://evision.brad.ac.uk/urd/sits.urd/run/SIW_LGN"));
                startActivity(myWebLink);
            }
        });

        Button btnt = (Button) findViewById(R.id.btntwitter);
        btnt.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myWebLink = new Intent(android.content.Intent.ACTION_VIEW);
                myWebLink.setData(Uri.parse("https://twitter.com/bradforduni"));
                startActivity(myWebLink);
            }
        });

        Button btnf = (Button) findViewById(R.id.btnfacebook);
        btnf.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myWebLink = new Intent(android.content.Intent.ACTION_VIEW);
                myWebLink.setData(Uri.parse("https://www.facebook.com/university.bradford"));
                startActivity(myWebLink);
            }
        });

    }

    public void onClickUobguide(View view){
        Intent i = new Intent(this, Uobguideform.class);
        startActivity(i);
    }

    public void onClickAboutUob(View view){
        Intent i = new Intent(this, Aboutuob.class);
        startActivity(i);
    }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_mainform, menu);
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
