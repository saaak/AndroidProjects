package com.example.buttondemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    TextView tv1;
    CheckBox checkbox01;
    CheckBox checkbox02;
    RadioButton radio1;
    RadioButton radio2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        tv1=(TextView)findViewById(R.id.textView01);
        checkbox01=(CheckBox)findViewById(R.id.checkBox01);
        checkbox02=(CheckBox)findViewById(R.id.checkBox02);
        radio1=(RadioButton)findViewById(R.id.radioButton01);
        radio2=(RadioButton)findViewById(R.id.radioButton02);

        View.OnClickListener checkboxListener=new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                tv1.setText(arg0.getId()+"is selected!");
            }
        };

        checkbox01.setOnClickListener(checkboxListener);
        checkbox02.setOnClickListener(checkboxListener);


        View.OnClickListener checkboxListener2=new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                tv1.setText(arg0.getId()+"is selected!");
            }
        };

        radio1.setOnClickListener(checkboxListener2);
        radio2.setOnClickListener(checkboxListener2);

    }

    



}
