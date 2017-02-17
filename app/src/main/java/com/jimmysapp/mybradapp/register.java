package com.jimmysapp.mybradapp;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class register extends ActionBarActivity {
    EditText NAME, SURNAME, USERNAME, PASSWORD, EMAIL, CEMAIL;
    Context context = this;
    DBAdapter dbAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        NAME = (EditText) findViewById(R.id.reg_name);
        SURNAME = (EditText) findViewById(R.id.reg_sname);
        USERNAME = (EditText) findViewById(R.id.reg_uname);
        PASSWORD = (EditText) findViewById(R.id.reg_pass);
        EMAIL = (EditText) findViewById(R.id.reg_email);
        CEMAIL = (EditText) findViewById(R.id.reg_cemail);
    }

    private boolean isValidEmail(String email) {
        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" +
                "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public void onClickScreen(View view){
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(getWindow().getCurrentFocus().getWindowToken(), 0);
    }

    private boolean isValidPassword(String pass) {
        if (pass != null && pass.length() > 6) {
            return true;
        }
        return false;
    }

    public void registerOnClick(View view){
        String name = NAME.getText().toString();
        String surname = SURNAME.getText().toString();
        String username = USERNAME.getText().toString();
        String password = PASSWORD.getText().toString();
        String email = EMAIL.getText().toString();
        String cemail = CEMAIL.getText().toString();

        if (name.matches("") | surname.matches("") | username.matches("")
                | password.matches("") | email.matches("") | cemail.matches("")){
            Toast.makeText(view.getContext(),
                    "Please fill in all the fields", Toast.LENGTH_LONG).show();
        } else if(!isValidEmail(email)){
            EMAIL.setError("Invalid Email");
            EMAIL.requestFocus();
        }   else if(!email.equals(cemail)) {
            CEMAIL.setError("Emails not matching");
            CEMAIL.requestFocus();
        }   else if (!isValidPassword(password)) {
            PASSWORD.setError("Invalid Password");
            PASSWORD.requestFocus();
        }   else {
            dbAdapter = new DBAdapter(context);
            dbAdapter.open();
            dbAdapter.insertRow(name, surname, username, password, email, cemail);
            Toast.makeText(view.getContext(),
                    "You have created account successfully !!", Toast.LENGTH_LONG).show();
            dbAdapter.close();
            ((EditText) findViewById(R.id.reg_name)).setText("");
            ((EditText) findViewById(R.id.reg_sname)).setText("");
            ((EditText) findViewById(R.id.reg_uname)).setText("");
            ((EditText) findViewById(R.id.reg_pass)).setText("");
            ((EditText) findViewById(R.id.reg_email)).setText("");
            ((EditText) findViewById(R.id.reg_cemail)).setText("");
            Intent i = new Intent(this, Login.class);
            startActivity(i);
        }

    }

    public void clearOnClick(View v){
        ((EditText) findViewById(R.id.reg_name)).setText("");
        ((EditText) findViewById(R.id.reg_sname)).setText("");
        ((EditText) findViewById(R.id.reg_uname)).setText("");
        ((EditText) findViewById(R.id.reg_pass)).setText("");
        ((EditText) findViewById(R.id.reg_email)).setText("");
        ((EditText) findViewById(R.id.reg_cemail)).setText("");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_register, menu);
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
