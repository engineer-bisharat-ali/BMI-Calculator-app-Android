package com.bisharatali.bmicalculator;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;

public class BMI_Result extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi_result);

        TextView textview_status;
        TextView textview_status_details;

        textview_status=findViewById(R.id.textview_status);
        textview_status_details=findViewById(R.id.textview_status_details);



        //Print the result in second activity from first activity

        float bmi = (float) getIntent().getDoubleExtra("my_key",0);
        DecimalFormat decimalFormat = new DecimalFormat("#.#");
        String roundedValue = decimalFormat.format(bmi);
        float result = Float.parseFloat(roundedValue);
        TextView bmi_result_textview;
        bmi_result_textview = findViewById(R.id.bmi_result_textview);
        bmi_result_textview.setText(""+result);

        float result_of_bmi =Float.parseFloat(bmi_result_textview.getText().toString());
        if (result_of_bmi>25){
            textview_status.setText("Overweight");
            textview_status.setTextColor(getResources().getColor(R.color.over_weight));
        }
        else if (result_of_bmi < 18 ){
            textview_status.setText("Under weight");
            textview_status.setTextColor(getResources().getColor(R.color.under_weight));

        }
        else {
            textview_status.setText("Normal ");
            textview_status.setTextColor(getResources().getColor(R.color.Normal));

        }

        if (result_of_bmi>25){
            textview_status_details.setText("You are Overweight");
            textview_status_details.setTextColor(getResources().getColor(R.color.over_weight));
            bmi_result_textview.setTextColor(getResources().getColor(R.color.over_weight));

        }
        else if (result_of_bmi < 18 ){
            textview_status_details.setText("You are Under weight");
            textview_status_details.setTextColor(getResources().getColor(R.color.under_weight));
            bmi_result_textview.setTextColor(getResources().getColor(R.color.under_weight));

        }
        else {
            textview_status_details.setText("You are Healthy ");
            textview_status_details.setTextColor(getResources().getColor(R.color.Normal));
            bmi_result_textview.setTextColor(getResources().getColor(R.color.Normal));
        }


        Intent intentBack = new Intent(BMI_Result.this,MainActivity.class);


        ImageView back_btn;
        back_btn=findViewById(R.id.back_btn);

        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentBack = new Intent(BMI_Result.this,MainActivity.class);
                startActivity(intentBack);
            }

        });


        Button Re_calculate_button = findViewById(R.id.Re_calculate_button);

        Re_calculate_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentBack);
            }
        });

        String TAG ="mytag";
        Log.d(TAG, "Result "+result_of_bmi);
    }

}