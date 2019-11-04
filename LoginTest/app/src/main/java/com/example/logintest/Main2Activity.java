package com.example.logintest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Button btnOk = findViewById(R.id.btnOk);
        final TextView code = findViewById(R.id.verifyCode);
        final Bundle bundle = this.getIntent().getExtras();
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = bundle.getString("userName");
                String pwd = bundle.getString("pwd");
                Uri data = null;
                if(userName.equals("admin")&&pwd.equals("123456")&&code.getText().toString().equals("code")){
                    data = Uri.parse("登陆成功");
                }else{
                    data = Uri.parse("登陆失败");
                }
                Intent res = new Intent(null,data);
                setResult(RESULT_OK,res);
                finish();
            }
        });
    }
}
