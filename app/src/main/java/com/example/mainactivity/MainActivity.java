package com.example.mainactivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        EditText edtWeight, edtHeightFt, edtHeightInc;
        Button btnCalculateBmi;
        TextView txtResult;
        ImageView myImageView;

        edtWeight = findViewById(R.id.edtWeight);
        edtHeightFt = findViewById(R.id.edtHeightFt);
        edtHeightInc = findViewById(R.id.edtHeightInc);
        btnCalculateBmi = findViewById(R.id.btnCalculateBmi);
        txtResult = findViewById(R.id.txtResult);
        myImageView = findViewById(R.id.myImageView);

        btnCalculateBmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int wt = Integer.parseInt(edtWeight.getText().toString());
                int ft = Integer.parseInt(edtHeightFt.getText().toString());
                int in = Integer.parseInt(edtHeightInc.getText().toString());

                int totalIn = ft*12 + in;
                double totalCm = totalIn*2.53;
                double totalM = totalCm/100;

                double bmi = wt/(totalM*totalM);
                bmi = (double) Math.round(bmi * 1000) /1000.0;

                if (bmi>25){
                    txtResult.setText("You are Overweight and your BMI is : "+ bmi +"\n🏻🫃🏻" );
                    myImageView.setImageResource(R.drawable.fat_peter_griffin);

                } else if (bmi<18) {
                    txtResult.setText("You are Underweight and your BMI is : "+ bmi );
                    myImageView.setImageResource(R.drawable.skinny_peter_griffin);
                }else if (bmi>18 && bmi<25){
                    txtResult.setText("You are Healty and your BMI is : "+ bmi );
                    //myImageView.setImageResource(R.drawable.giga_chad);
                    myImageView.setImageResource(R.drawable.fit_peter_griffin);
                }
            }
        });



    }
}