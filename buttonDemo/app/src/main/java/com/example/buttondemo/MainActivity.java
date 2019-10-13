package com.example.buttondemo;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.button01);
        ImageButton imageButton = (ImageButton) findViewById(R.id.imageButton01);
        button.setText("Button按钮");
        imageButton.setImageResource(R.drawable.download);
        final TextView textView = (TextView) findViewById(R.id.textView01);
        //button和imagebutton分别添加点击事件
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                textView.setText("button按钮");
//            }
//        });
//        imageButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                textView.setText("imagebutton按钮");
//            }
//        });

        Button.OnClickListener buttonListener = new Button.OnClickListener() {
            /**
             * Called when a view has been clicked.
             *
             * @param v The view that was clicked.
             */
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.button01:
                        textView.setText("button按钮");
                        return;
                    case R.id.imageButton01:
                        textView.setText("imagebutton按钮");
                        return;
                }
            }
        };
        button.setOnClickListener(buttonListener);
        imageButton.setOnClickListener(buttonListener);
    }
}

