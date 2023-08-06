
package com.example.childheightpredictorbyakshai;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.LinkedHashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    //All the resources
    private Spinner unitSpinner;
    private Spinner ageSpinner;
    private Spinner genderSpinner;
    private ArrayAdapter<CharSequence> unitAdapter;
    private ArrayAdapter<CharSequence> ageAdapter;
    private ArrayAdapter<CharSequence> genderAdapter;
    private Button pbutton;
    private TextView finalValue;
    private EditText childHeight;
    private EditText fatherHeight;
    private EditText motherHeight;

    double cHeight=0;
    double fHeight=0;
    double mHeight=0;
    int verifier = 1;
    String selectedUnit="",selectedGender="";
    double childAge=0;
    double predictedHeight;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Unit Spinner stuff
        unitSpinner = findViewById(R.id.unitSpinner);
        unitAdapter = ArrayAdapter.createFromResource(this,R.array.unit_Converter,R.layout.unit_spinner_layout);
        unitAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        unitSpinner.setAdapter(unitAdapter);

        //Age spinner stuff
        ageSpinner = findViewById(R.id.ageSpinner);
        ageAdapter = ArrayAdapter.createFromResource(this,R.array.Child_Age,R.layout.age_spinner_layout);
        ageAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ageSpinner.setAdapter(ageAdapter);

        //Gender spinner stuff
        genderSpinner = findViewById(R.id.genderSpinner);
        genderAdapter = ArrayAdapter.createFromResource(this,R.array.Child_Gender,R.layout.gender_spinner_layout);
        genderAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        genderSpinner.setAdapter(genderAdapter);

        pbutton = findViewById(R.id.Pbutton);
        childHeight = findViewById(R.id.childHeight);
        fatherHeight = findViewById(R.id.fatherHeight);
        motherHeight = findViewById(R.id.motherHeight);
        finalValue = findViewById(R.id.predictedAge);

        pbutton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                try {
                    verifier =1;
                    String s1;
                    s1 = String.valueOf(childHeight.getText());

                    if (s1.equals("") || s1.equals(".")) {
                        //Toast.makeText(MainActivity.this, "Enter a valid Child height", Toast.LENGTH_SHORT).show();
                        verifier = 0;
                    } else {
                        cHeight = Double.parseDouble(s1);
                        //Toast.makeText(MainActivity.this, "Your child height is " + cHeight, Toast.LENGTH_SHORT).show();
                    }
                    String s2;
                    s2 = String.valueOf(fatherHeight.getText());

                    if (s2.equals("") || s2.equals(".")) {
                        //Toast.makeText(MainActivity.this, "Enter a valid father height", Toast.LENGTH_SHORT).show();
                        verifier = 0;
                    } else {
                        fHeight = Double.parseDouble(s2);
                        //Toast.makeText(MainActivity.this, "Your father height is " + fHeight, Toast.LENGTH_SHORT).show();
                    }
                    String s3;
                    s3 = String.valueOf(motherHeight.getText());

                    if (s3.equals("") || s3.equals(".")) {
                        //Toast.makeText(MainActivity.this, "Enter a valid mother height", Toast.LENGTH_SHORT).show();
                        verifier = 0;
                    } else {
                        mHeight = Double.parseDouble(s3);
                        //Toast.makeText(MainActivity.this, "Your mother height is " + mHeight, Toast.LENGTH_SHORT).show();
                    }
                    selectedUnit = unitSpinner.getSelectedItem().toString();
                    if (selectedUnit.equals("Select unit")) {
                        //Toast.makeText(MainActivity.this, "You forgot to select an Unit", Toast.LENGTH_SHORT).show();
                        verifier = 0;
                    } else {
                        //Toast.makeText(MainActivity.this, selectedUnit, Toast.LENGTH_SHORT).show();
                    }
                    String selectedAge;
                    selectedAge = ageSpinner.getSelectedItem().toString();
                    if (selectedAge.equals("Select age")) {
                        //Toast.makeText(MainActivity.this, "You forgot to select an age", Toast.LENGTH_SHORT).show();
                        verifier = 0;
                    } else {
                        childAge = new GetTheAge(selectedAge).getAgeValue();
                        //Toast.makeText(MainActivity.this, childAge+"", Toast.LENGTH_SHORT).show();

                    }

                    selectedGender = genderSpinner.getSelectedItem().toString();
                    if (selectedGender.equals("Select gender")) {
                        //Toast.makeText(MainActivity.this, "You forgot to select an age", Toast.LENGTH_SHORT).show();
                        verifier = 0;
                    } else {
                        //Toast.makeText(MainActivity.this, selectedGender, Toast.LENGTH_SHORT).show();
                    }


                    if (verifier == 0){
                        Toast.makeText(MainActivity.this, "You missed out something!!!", Toast.LENGTH_SHORT).show();
                        finalValue.setText(" ");
                    }
                    else {
                        //Calculation code here
                        String s11;
                        HeightPredictor h1 = new HeightPredictor(fHeight, mHeight, cHeight, childAge, selectedUnit, selectedGender);
                        if (selectedUnit.equals("cm")) {
                            predictedHeight = h1.ifInCentiMeters();
                            s11 = "Child's future height will be " + (predictedHeight-24.5) + " cm";
                            finalValue.setText(s11);
                        }
                        else {

                            predictedHeight = h1.IfInFeet() ;
                            s11 = "Child's future height will be " + predictedHeight + " feet";
                            finalValue.setText("Child's future height will be " + (predictedHeight-0.8) + " feet");
                        }
                    }
                }
                catch(Exception e){
                    String errorMessage = "An error occurred: " + e.getMessage();
                    Toast.makeText(MainActivity.this, "An error occurred. Check logs for details.", Toast.LENGTH_LONG).show();
                    Log.e("ChildHeightPredictor", errorMessage);
                    e.printStackTrace();
                }
            }
        }
        );

    }
}