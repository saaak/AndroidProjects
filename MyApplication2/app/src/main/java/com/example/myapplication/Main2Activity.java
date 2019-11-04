package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        TextView tx = findViewById(R.id.textView);
        Bundle bundle = this.getIntent().getExtras();
        int num = bundle.getInt("num");
        int sum=0;
        for (int i = 1; i < num; i++) {
            if(num%i==0){
                sum+=i;
            }
        }
        if(sum==num){
            tx.setText("是完数");
            return;
        }else {
            tx.setText("不是完数");
            return;
        }
    }

}
