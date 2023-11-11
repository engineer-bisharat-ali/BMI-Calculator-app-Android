package com.bisharatali.bmicalculator;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    public double bmiresult;
    public double bmi ;

    EditText height_ft;
    EditText height_inches;
    EditText weight_kg;
    EditText age;
    TextView male , female;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.label_center);

        ImageView imageView1, imageView2 ;
        LinearLayout gender_effect_male;
        LinearLayout gender_effect_female;

        gender_effect_female = findViewById(R.id.gender_effect_female);
        gender_effect_male = findViewById(R.id.gender_effect_male);
        male= findViewById(R.id.male_gender);
        female= findViewById(R.id.female_gender);

        imageView1 = findViewById(R.id.imageView1);
        imageView2 = findViewById(R.id.imageView2);
        Button calculate_Button;
        calculate_Button = findViewById(R.id.calculate_button);



        // This is the code for gender selection effect

        //this for male
        gender_effect_male.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                male.setScaleX(1.3f); // increase X-axis scale by 20%
                male.setScaleY(1.3f); // increase Y-axis scale by 20%
                female.setScaleX(1.0f); // increase X-axis scale by 20%
                female.setScaleY(1.0f); // increase Y-axis scale by 20%

                imageView1.setScaleX(1.3f); // increase X-axis scale by 20%
                imageView1.setScaleY(1.3f); // increase Y-axis scale by 20%
                imageView2.setScaleX(1.0f); // increase X-axis scale by 20%
                imageView2.setScaleY(1.0f); // increase Y-axis scale by 20%

            }

        });


        //this for female

        gender_effect_female.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//
                male.setScaleX(1.0f); // increase X-axis scale by 20%
                male.setScaleY(1.0f); // increase Y-axis scale by 20%
                female.setScaleX(1.3f); // increase X-axis scale by 20%
                female.setScaleY(1.3f); // increase Y-axis scale by 20%

                imageView1.setScaleX(1.0f); // increase X-axis scale by 20%
                imageView1.setScaleY(1.0f); // increase Y-axis scale by 20%
                imageView2.setScaleX(1.3f); // increase X-axis scale by 20%
                imageView2.setScaleY(1.3f); // increase Y-axis scale by 20%
            }
        });







        //Logic Part ........ Calculation For BMI

        calculate_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                bmiresult=calculation();   // method call for calculation of BMi

                // Go for second activity or Result activity
                Intent intent2;
                intent2 = new Intent(MainActivity.this,BMI_Result.class);
                intent2.putExtra("my_key",bmiresult);
                startActivity(intent2);

                height_ft.setText("");
                height_inches.setText("");
                weight_kg.setText("");
                age.setText("");

            }
        });

    }

    //Method For Calculate The BMI

    public double calculation(){

        height_ft = findViewById(R.id.height_ft);
        height_inches = findViewById(R.id.height_inches);
        weight_kg = findViewById(R.id.weight_kg);
        age = findViewById(R.id.age);


        int height_ft_store = Integer.parseInt(height_ft.getText().toString());
        int height_inches_store = Integer.parseInt(height_inches.getText().toString());
        int weight_kg_store = Integer.parseInt(weight_kg.getText().toString());
        int age_store = Integer.parseInt(age.getText().toString());

        //convert weight feet inches into Meter ....... first convert into totalinches and then total CM and the finally into Meter(M)

        int totalInches=height_ft_store*12+height_inches_store;
        double totalCm= totalInches*2.53;
        double totalM = totalCm/100;
        bmi = weight_kg_store/(totalM*totalM);   // Formula
        return bmi;
    }



    public void onBackPressed() {
// display exit message
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Confirm Exit");
        builder.setMessage("Are you sure you want to exit the app?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
              finish();   // close the app
            }
        });
        builder.setNegativeButton("No", null);
        AlertDialog dialog = builder.create();
        dialog.show();
    }


}



