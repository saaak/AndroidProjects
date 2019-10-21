package com.example.p23;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Integer count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RadioButton radioButton1 = (RadioButton)findViewById(R.id.radioButton1);
        RadioButton radioButton2 = (RadioButton)findViewById(R.id.radioButton2);
        RadioButton radioButton3 = (RadioButton)findViewById(R.id.radioButton3);
        final TextView textView = (TextView)findViewById(R.id.textView);
        final Button button = (Button)findViewById(R.id.button1);
        RadioButton.OnClickListener radioButtonListener = new RadioButton.OnClickListener(){

            @Override
            public void onClick(View view) {
                count++;
                switch (view.getId()){
                    case R.id.radioButton1:
                        textView.setBackgroundColor(Color.RED);
                        break;
                    case R.id.radioButton2:
                        textView.setBackgroundColor(Color.GREEN);
                        break;
                    case R.id.radioButton3:
                        textView.setBackgroundColor(Color.BLUE);
                        break;
                }
            }
        };
        radioButton1.setOnClickListener(radioButtonListener);
        radioButton2.setOnClickListener(radioButtonListener);
        radioButton3.setOnClickListener(radioButtonListener);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setBackgroundColor(Color.rgb(255, 255, 255));
                button.setText("点击了"+count+"次");
                count=0;
            }
        });
    }
}
