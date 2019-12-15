package com.example.simplemathservice;

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

public class MainActivity extends AppCompatActivity {
    private MathService mathService;
    private boolean isBound = false;
    TextView labelView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        labelView = findViewById(R.id.textView);
        Button bind = findViewById(R.id.bind);
        final Button unbind = findViewById(R.id.unbind);
        Button comput = findViewById(R.id.comput);
        bind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isBound){
                    final Intent serviceIntent = new Intent(MainActivity.this,MathService.class);
                    bindService(serviceIntent,mConnection, Context.BIND_AUTO_CREATE);
                    isBound=true;
                }

            }
        });
        unbind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isBound){
                    isBound=false;
                    unbindService(mConnection);
                    mathService=null;
                }
            }
        });
        comput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mathService == null){
                    labelView.setText("未绑定服务");
                    return;
                }
                long a = Math.round(Math.random()*100);
                long b = Math.round(Math.random()*100);
                long result = mathService.add(a,b);
                String msg = String.valueOf(a)+"+"+String.valueOf(b)+"="+String.valueOf(result);
                labelView.setText(msg);
            }
        });


    }

    private ServiceConnection mConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mathService = ((MathService.LocalBinder)service).getService();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            mathService=null;
        }
    };
}
