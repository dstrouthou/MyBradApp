package com.jimmysapp.mybradapp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.content.Intent;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.nio.charset.CharacterCodingException;
import java.sql.SQLException;


public class Login extends ActionBarActivity {

    EditText USERNAME, PASSWORD;
    CheckBox Admin;
    Context context = this;
    DBAdapter dbAdapter;

    @Override
        protected void onCreate(Bundle savedInstanceState) {
        
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        USERNAME = (EditText) findViewById(R.id.uname);
        PASSWORD = (EditText) findViewById(R.id.pass);
        Admin = (CheckBox) findViewById(R.id.checkBoxAdmin);
    }

    public void onClickRegister(View view){
        Intent v = new Intent(this, register.class);
        startActivity(v);
    }

    public void onClickUsername(View view){
        EditText uname = (EditText) findViewById(R.id.uname);
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(uname, InputMethodManager.SHOW_IMPLICIT);
    }

    public void onClickScreen(View view){
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(getWindow().getCurrentFocus().getWindowToken(), 0);
    }

    public void onClickpass(View view) {
        EditText pass = (EditText) findViewById(R.id.pass);
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(pass, InputMethodManager.SHOW_IMPLICIT);
    }

    public void onClickAdmin(View view) {
        boolean checked = ((CheckBox) view).isChecked();
        //CheckBox checkBoxAdmin = (CheckBox) findViewById(R.id.checkBoxAdmin);
    }

    public void onClickLogin(View view) {
        String username = USERNAME.getText().toString();
        String password = PASSWORD.getText().toString();
        String admin = "Admin";
        String adminpass = "Admin1992";
        if (Admin.isChecked()){
            if (username.length() == admin.length() && password.length() == adminpass.length()){
                Toast.makeText(Login.this, "Successfully Login as Admin", Toast.LENGTH_LONG).show();
                Intent v = new Intent(this, admin.class);
                startActivity(v);
                ((EditText) findViewById(R.id.uname)).setText("");
                ((EditText) findViewById(R.id.pass)).setText("");
                Admin.setChecked(false);
            } else {
                Toast.makeText(Login.this, "Please insert correct username/password", Toast.LENGTH_LONG).show();
                Admin.setChecked(false);
            }
        } else if (username.length() > 0 && password.length() > 0) {
                dbAdapter = new DBAdapter(context);
                dbAdapter.open();
                if (dbAdapter.Login(username, password)) {
                    Toast.makeText(Login.this, "Successfully Logged In", Toast.LENGTH_LONG).show();
                    Intent i = new Intent(this, Mainform.class);
                    startActivity(i);
                    ((EditText) findViewById(R.id.uname)).setText("");
                    ((EditText) findViewById(R.id.pass)).setText("");
                } else {
                    Toast.makeText(Login.this, "Invalid Username or Password", Toast.LENGTH_LONG).show();
                }
                dbAdapter.close();

        }else {
                Toast.makeText(Login.this, "Please insert a username and a password", Toast.LENGTH_LONG).show();
                }
        }
}


