package com.example.multithread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Thread subThread;
    boolean isRunning=true;
    int timer=0;
    private Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView num = findViewById(R.id.num);
        Button start = findViewById(R.id.start);
        Button end = findViewById(R.id.end);
        Button reset = findViewById(R.id.reset);
        subThread=new Thread(new Runnable() {
            public void run() {
                while(isRunning){
                    try {
                        Thread.currentThread().sleep(10);
                        timer++;
                        //构建handler传递消息
                        Message msg=new Message();
                        msg.obj=timer;
                        msg.what=0;
                        handler.sendMessage(msg);

                        Log.i("SUBTHREAD", "Sub Thread:"+timer);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isRunning=true;
                subThread.start();
                handler=new Handler(){

                    @Override
                    public void handleMessage(Message msg) {
                        // TODO Auto-generated method stub
                        switch (msg.what) {
                            case 0:

                                num.setText("Sub Thread:"+timer);
                                break;

                            default:
                                break;
                        }
                    }

                };
            }
        });
        end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isRunning = false;
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timer = 0;
                num.setText("重置啦");
            }
        });
    }
}
