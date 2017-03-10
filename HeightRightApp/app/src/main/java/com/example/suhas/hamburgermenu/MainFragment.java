package com.example.suhas.hamburgermenu;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {


    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        final View rootView=inflater.inflate(R.layout.fragment_main, container, false);
        final Context context = rootView.getContext();
        final Button b= (Button) rootView.findViewById(R.id.calculatebtn);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Pass the context and the Activity class you need to open from the Fragment Class, to the Intent

                RadioButton male,female,kneeyes,kneeno,wingyes,wingno;
                float knee,wing,age,result;
                result=0;
                EditText e = (EditText)rootView.findViewById(R.id.knee);
                EditText e1 = (EditText)rootView.findViewById(R.id.wing);
                EditText e2 = (EditText)rootView.findViewById(R.id.age);
                try {
                    knee = Float.valueOf(e.getText().toString());
                }
                catch(NumberFormatException ex) {
                    knee=(float) 0.0; // default ??
                }
                try {
                    wing = Float.valueOf(e1.getText().toString());
                }
                catch(NumberFormatException ex) {
                    wing= (float)0.0; // default ??
                }
                try{
                    age= Float.valueOf(e2.getText().toString());
                }
                catch(NumberFormatException ex) {
                    age =(float) 0.0; // default ??
                }
                male=(RadioButton)rootView.findViewById(R.id.radio_male);
                female=(RadioButton)rootView.findViewById(R.id.radio_female);
                kneeyes=(RadioButton)rootView.findViewById(R.id.kneeyes);
                kneeno=(RadioButton)rootView.findViewById(R.id.kneeno);
                wingyes=(RadioButton)rootView.findViewById(R.id.wingyes);
                wingno=(RadioButton)rootView.findViewById(R.id.wingno);
                TextView t=(TextView)rootView.findViewById(R.id.result);
                t.setText("Height: "+knee+" cms");
               if((kneeyes.isChecked()&&wingyes.isChecked())||(kneeyes.isChecked()&&wingno.isChecked()))
                {
                    if(male.isChecked())
                    {
                        float base=0;
                        if(age==0){
                             base=28;
                        }
                        else if(0<age){
                            base=(float)(28+2.08);
                        }
                        else if(0.08<age){
                            base=(float)(28+2*2.08);
                        }
                        else if(0.16<age){
                            base=(float)(28+3*2.08);
                        }
                        else if(0.25<age){
                            base=(float)(28+3*2.08);
                        }
                        else if(0.33<age){
                            base=(float)(28+4*2.08);
                        }
                        else if(0.41<age){
                            base=(float)(28+5*2.08);
                        }
                        else if(0.5<age){
                            base=(float)(28+6*2.08);
                        }
                        else if(0.58<age){
                            base=(float)(28+7*2.08);
                        }
                        else if(0.66<age){
                            base=(float)(28+8*2.08);
                        }
                        else if(0.75<age){
                            base=(float)(28+9*2.08);
                        }
                        else if(0.83<age){
                            base=(float)(28+10*2.08);
                        }
                        else if(0.9<age){
                            base=(float)(28+11*2.08);
                        }
                        else if(1<age){
                            base=(float)(84.88);
                        }
                        result= (float)(base-(0.24*age)+(1.83*knee));

                    }
                    if(female.isChecked())
                    {
                        float base=0;
                        if(age==0){
                            base=28;
                        }
                        else if(0<age){
                            base=(float)(28+2.08);
                        }
                        else if(0.08<age){
                            base=(float)(28+2*2.08);
                        }
                        else if(0.16<age){
                            base=(float)(28+3*2.08);
                        }
                        else if(0.25<age){
                            base=(float)(28+3*2.08);
                        }
                        else if(0.33<age){
                            base=(float)(28+4*2.08);
                        }
                        else if(0.41<age){
                            base=(float)(28+5*2.08);
                        }
                        else if(0.5<age){
                            base=(float)(28+6*2.08);
                        }
                        else if(0.58<age){
                            base=(float)(28+7*2.08);
                        }
                        else if(0.66<age){
                            base=(float)(28+8*2.08);
                        }
                        else if(0.75<age){
                            base=(float)(28+9*2.08);
                        }
                        else if(0.83<age){
                            base=(float)(28+10*2.08);
                        }
                        else if(0.9<age){
                            base=(float)(28+11*2.08);
                        }
                        else if(1<age){
                            base=(float)(64.19);
                        }
                        result= (float)(base-(0.04*age)+(2.02*knee));
                    }
                    t.setText("Height: "+result+" cms");
                }
                else if(kneeno.isChecked()&&wingyes.isChecked())
                {
                    result=(float)(1.06*wing);
                    t.setText("Height: "+result+" cms");
                }
                else
                {
                    Intent intent = new Intent(context,Forearm.class);
                    startActivity(intent);
                }
            }

        });

    return rootView;
    }


}
