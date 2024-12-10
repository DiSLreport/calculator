package com.example.d1;

import static java.lang.Double.*;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView result;
    double num1=0;
    double num2=0;
    double temp=0;
    char ch='$';
    boolean calced=false;
    boolean operatorSet = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        result=findViewById(R.id.textViewResult);

        result.setText("0");
    }

    public void numFunc(View view) { // number button

        Button button = (Button) view;

        if(calced == true)
        {
            result.setText("0");
            calced = false;
        }
        if(result.getText().toString().equals("0")||result.getText().toString().equals("Error"))
        {
            result.setText("");
        }
        result.append(button.getText().toString());



    }

    public void oparitorFunc(View view) // operator button
    {
        ch = ((Button) view).getText().toString().charAt(0);
        num1 = Double.parseDouble(result.getText().toString());
        result.setText("0");
    }

    public void clearBtn(View view)
    {
        result.setText("0");
        num1=0;
        num2=0;
    }

    public void equalFunc(View view)// equality button
    {

        if(result.getText().toString().equals("Error")==false)
        {
            num2=Double.parseDouble(result.getText().toString());
        }


        double calculateResult=0;

        if (ch=='+')
        {
            calculateResult=num1+num2;
        }
        else if (ch=='-')
        {
            calculateResult=num1-num2;
        }
        else if (ch=='X'||ch=='x')
        {
            calculateResult=num1*num2;
        }
        else
        {
            if(num2!=0)
            {
                calculateResult = num1 / num2;

            }
            else
            {

                result.setText("Error");
                if(calced==false) {
                    ch = '$';
                    num1 = 0;
                    num2 = 0;
                    calced = true;
                    return;
                }

            }
        }
        if(calculateResult%1==0) {
            result.setText(String.valueOf((int) calculateResult + ""));
        }
        else {
            result.setText(String.valueOf(calculateResult + ""));
        }

        ch='$';
        num1=0;
        num2=0;
        calced=true;
    }
}