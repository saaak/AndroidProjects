package com.example.p2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        final Integer[] randIntegers = new Integer[7];

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText edt1=(EditText)findViewById(R.id.editNumber1);
        final TextView tv1=(TextView)findViewById(R.id.textResult);
        Button btn1=(Button)findViewById(R.id.btn1);
        Button btn2=(Button)findViewById(R.id.btn2);
        btn1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                //从输入框中获取输入信息
                String randStr = "";
                Random r = new Random();
                for(int i=0;i<7;i++){
                    int random = (int)(Math.random()*(100)+1);
                    Log.i("suiji",String.valueOf(random));
                    randIntegers[i]=random;
                    randStr+=random+" ";
                }

                edt1.setText(randStr);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Arrays.sort(randIntegers);
                String resStr = "";
                for(int i=0;i<7;i++){

                    resStr+=randIntegers[i]+" ";
                }

                tv1.setText(resStr);
            }
        });

    }
}
