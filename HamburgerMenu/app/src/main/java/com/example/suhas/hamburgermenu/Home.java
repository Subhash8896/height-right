package com.example.suhas.hamburgermenu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Home extends AppCompatActivity {

    public static String volunteer,kid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        Button b1= (Button)findViewById(R.id.homebutton1);
        Button b2= (Button)findViewById(R.id.homebutton2);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                //Pass the context and the Activity class you need to open from the Fragment Class, to the Intent

                Intent intent = new Intent(Home.this, MainActivity.class);

                startActivity(intent);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                //Pass the context and the Activity class you need to open from the Fragment Class, to the Intent

                Intent intent = new Intent(Home.this, DataActivity.class);

                startActivity(intent);
            }
        });
    }
}
