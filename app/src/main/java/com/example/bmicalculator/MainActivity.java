package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editWeight, editHeightFt, editHeightIn;
        Button calculateBtn;
        TextView textResult;
        LinearLayout llMain;

        editWeight = findViewById(R.id.editWeight);
        editHeightFt = findViewById(R.id.editHeightFt);
        editHeightIn = findViewById(R.id.editHeightIn);
        calculateBtn = findViewById(R.id.calculateBtn);
        textResult = findViewById(R.id.result);
        llMain = findViewById(R.id.llMain);

        calculateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int weight = Integer.parseInt(editWeight.getText().toString());
                int heightFt = Integer.parseInt(editHeightFt.getText().toString());
                int heightIn = Integer.parseInt(editHeightIn.getText().toString());

                int totalIn = heightFt * 12 + heightIn;

                double totalCm = totalIn * 2.53;

                double totalM = totalCm /100;

                double bmi = weight/(totalM * totalM);

                if(bmi > 25){
                    textResult.setText("You Are Over Weight!!!!!");
                    llMain.setBackgroundColor(getResources().getColor( R.color.overWeight));
                }else if(bmi < 18){
                    textResult.setText("You Are Under Weight!!");
                    llMain.setBackgroundColor(getResources().getColor(R.color.underWeight));
                }else{
                    textResult.setText("You Are Healthy");
                    llMain.setBackgroundColor(getResources().getColor(R.color.healthy));
                }


            }
        });
    }
}