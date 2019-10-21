package com.example.p1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText edt1=(EditText)findViewById(R.id.editNumber1);
        final TextView tv1=(TextView)findViewById(R.id.textResult);
        Button btn1=(Button)findViewById(R.id.btnOk);
        btn1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                //从输入框中获取输入信息
                String s=edt1.getText().toString();
                Log.i("count",s);
                String resultString="";
                //实现统计：
                for (; s.length()>0; ) {
                    int count = 0;//统计单个字符出现的次数
                    int old_length = s.length();
                    char c = s.charAt(0);
                    //定义一个字符等于字符串第一个字符.每次统计完会将统计过的字符替换掉.
                    String new_str=s.replaceAll(c+"", "");//定义一个新字符串将出现的字符
                    //赋给一个新的字符串
                    int new_length=new_str.length();
                    count = old_length - new_length;//旧的长度减去新的长度就是字符出现的 次数
                    s=new_str;//将替换并统计过次数的字符串赋给原来的字符串,便于下一次遍历
                    String res=c+":"+count+",";
                    Log.i("count",s);
                    Log.i("count",res);
                    resultString+=res;
                }

                //将结果显示到手机界面上
                tv1.setText(resultString);
            }
        });

    }
}
