package com.example.kurobe.calcapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText num1;
    EditText num2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = (Button) findViewById(R.id.calBtn1);
        button1.setOnClickListener(this);

        Button button2 = (Button) findViewById(R.id.calBtn2);
        button2.setOnClickListener(this);

        Button button3 = (Button) findViewById(R.id.calBtn3);
        button3.setOnClickListener(this);

        Button button4 = (Button) findViewById(R.id.calBtn4);
        button4.setOnClickListener(this);

        num1 = (EditText) findViewById(R.id.num1);
        num2 = (EditText) findViewById(R.id.num2);
    }

    @Override
    public void onClick (View v) {


        String str1 = num1.getText().toString();
        double double1 = Double.parseDouble(str1);

        String str2 = num2.getText().toString();
        double double2 = Double.parseDouble(str2);

        Intent intent = new Intent(this, ResultActivity.class);

        if(v.getId() == R.id.calBtn1) {
            intent.putExtra("VALUE", double1 + double2);
        } else if (v.getId() == R.id.calBtn2) {
            intent.putExtra("VALUE", double1 - double2);
        } else if (v.getId() == R.id.calBtn3) {
            intent.putExtra("VALUE", double1 * double2);
        } else if (v.getId() == R.id.calBtn4) {
            if (double2 == 0) {
                return;
            } else {
                intent.putExtra("VALUE", double1 / double2);
            }

        }

        startActivity(intent);
    }
}
