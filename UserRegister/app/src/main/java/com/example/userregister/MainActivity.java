package com.example.userregister;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button confirm = (Button)findViewById(R.id.confirm);
        Button cancel = (Button)findViewById(R.id.cancel);
        final TextView userName = (TextView)findViewById(R.id.userName);
        final TextView password = (TextView)findViewById(R.id.password);
        final TextView result = (TextView)findViewById(R.id.result);
        final RadioButton admin = (RadioButton)findViewById(R.id.administrator);
        final RadioButton user = (RadioButton)findViewById(R.id.commonUser);
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (userName.getText().toString().equals("")){
                    Toast ts = Toast.makeText(getBaseContext(),"用户名不能为空",Toast.LENGTH_LONG);
                    ts.show();
                    return;
                }
                if (password.getText().toString().equals("")){
                    Toast ts = Toast.makeText(getBaseContext(),"密码不能为空",Toast.LENGTH_LONG);
                    ts.show();
                    return;
                }
                if(admin.isChecked()&&(!Character.isUpperCase(userName.getText().toString().charAt(0))||password.getText().length()<=8)){
                    Toast ts = Toast.makeText(getBaseContext(),"用户名与密码必须符合管理员要求",Toast.LENGTH_LONG);
                    ts.show();
                    return;
                }
                String str = new String();
                str = userName.getText().toString()+"\n"+password.getText().toString()+"\n";
                if(admin.isChecked()){
                    str+="管理员";
                }else if(user.isChecked()) {
                    str+="普通用户";
                }
                result.setText(str);
                return;
            }
        });
    }
}
