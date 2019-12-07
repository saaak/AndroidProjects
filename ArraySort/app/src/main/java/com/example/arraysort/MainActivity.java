package com.example.arraysort;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private MyService myService;
    private Boolean isBound=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView input = findViewById(R.id.input);
        final Button bind = findViewById(R.id.bindButton);
        final Button unbind = findViewById(R.id.unbind);
        final Button sort = findViewById(R.id.sort);
        final  TextView result = findViewById(R.id.result);
        bind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isBound) {
                    final Intent intent = new Intent(MainActivity.this, MyService.class);
                    bindService(intent, mConnection, Context.BIND_AUTO_CREATE);
                    isBound = true;
                }

            }
        });
        unbind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isBound){
                    isBound = false;
                    unbindService(mConnection);
                    myService = null;
                }
            }
        });
        sort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(myService==null){
                    result.setText("未绑定");
                    return;
                }
                String inputText = input.getText().toString();
                System.out.println(inputText);
                ArrayList arrayList = myService.mySplit(inputText);
                arrayList = myService.mySort(arrayList);
                String resultstr="";
                for (Object i : arrayList){
                    resultstr += i+" ";
                }
                result.setText(resultstr);
            }
        });
    }

    private ServiceConnection mConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            myService = ((MyService.LocalBinder)service).getService();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            myService = null;
        }
    };
}
