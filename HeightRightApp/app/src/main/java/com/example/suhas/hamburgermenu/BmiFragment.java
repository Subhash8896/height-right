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
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class BmiFragment extends Fragment {
    private EditText hcal;
    private EditText wcal;
    private Button calc;
    public BmiFragment() {
        // Required empty public constructor

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_bmi, container, false);
        final Context context = rootView.getContext(); // Assign your rootView to context

        final Button b= (Button) rootView.findViewById(R.id.button);
        hcal=(EditText) rootView.findViewById(R.id.hcal);
        wcal=(EditText) rootView.findViewById(R.id.wcal);
        calc = (Button) rootView.findViewById(R.id.calc);
        initButton();
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Pass the context and the Activity class you need to open from the Fragment Class, to the Intent
                Intent intent = new Intent(context,NewEntry.class);
                startActivity(intent);
            }
        });
        return rootView;



    }
    private void initButton() {
        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String calh;
                String calw;
                calh = hcal.getText().toString();
                calw = wcal.getText().toString();
                TextView bmi = (TextView) getView().findViewById(R.id.bmi);
                Double dblAnswer = doCalc(calh, calw);
                String answer ="The BMI is"+ String.valueOf(dblAnswer);
                bmi.setText(answer);
            }
        });
    }
    public double doCalc(String a, String b) {
        // a and b are both variables. they refer to the stuff we put in
        double dblA = Double.parseDouble(a);
        double dblB = Double.parseDouble(b);
        // we're gonna make both of these numbers so we can add them. right now they're just text.
        return dblB/(dblA*dblA);
    }




}
