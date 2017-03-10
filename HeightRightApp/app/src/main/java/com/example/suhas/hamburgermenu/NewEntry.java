package com.example.suhas.hamburgermenu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

public class NewEntry extends Activity {
    EditText userName;
    DBController controller = new DBController(this);

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_new_entry);

    }

    public void submitData(View view){
        String volid, kidname, height, bmi, date, entry;
        EditText e1 = (EditText) findViewById(R.id.volid);
        volid = e1.getText().toString();
        EditText e2 = (EditText) findViewById(R.id.kidname);
        kidname = e2.getText().toString();
        EditText e3 = (EditText) findViewById(R.id.finalheight);
        height = e3.getText().toString();
        EditText e4 = (EditText) findViewById(R.id.finalbmi);
        bmi = e4.getText().toString();
        EditText e5 = (EditText) findViewById(R.id.date);
        date = e5.getText().toString();
        entry = volid + " | " + kidname + " | " + height + " | " + bmi + " | " + date;
        userName = (EditText) findViewById(R.id.userName);
        userName.setText(entry);
    }

    /**
     * Called when Save button is clicked
     * @param view
     */
    public void addNewUser(View view) {
        HashMap<String, String> queryValues = new HashMap<String, String>();
        queryValues.put("userName", userName.getText().toString());
        if (userName.getText().toString() != null
                && userName.getText().toString().trim().length() != 0) {
            controller.insertUser(queryValues);
            this.callHomeActivity(view);
        } else {
            Toast.makeText(getApplicationContext(), "Please enter User name",
                    Toast.LENGTH_LONG).show();
        }
    }

    /**
     * Navigate to Home Screen
     * @param view
     */
    public void callHomeActivity(View view) {
        Intent objIntent = new Intent(getApplicationContext(),
                DataActivity.class);
        startActivity(objIntent);
    }

    /**
     * Called when Cancel button is clicked
     * @param view
     */
    public void cancelAddUser(View view) {
        this.callHomeActivity(view);
    }
}
