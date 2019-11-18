package com.example.implicitstartup;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        TextView textView = findViewById(R.id.textView1);
        Bundle bundle = getIntent().getExtras();
        String list = bundle.getString("list");
        list = list.replaceAll("－","-");
        System.out.println(list);
        String [] list1 = list.split("\\s+");
        Integer  arraylist[] = new Integer[list1.length+1];
        int i=1;
        for (String s:list1){
            arraylist[i] = Integer.valueOf(s);
            i++;
        }
        System.out.println(arraylist.toString());
        Integer sum[] = new Integer[list1.length+2];
        //计算数组前缀和
        sum[0] = 0;
        for(i = 1; i <= arraylist.length-1; i++) {
            System.out.println(arraylist[i]);
            System.out.println(sum[i-1]);
            sum[i] = arraylist[i] + sum[i - 1];
        }

        int ans = arraylist[1]; //ans保存最大子序列和，初始化为num[1]能保证最终结果正确
        //i和j分别是枚举的子序列的起点和终点
        int start = 0,end=0;
        for(i = 1; i <= arraylist.length-1; i++) {
            for(int j = i; j <= arraylist.length-1; j++) {
                int s = sum[j] - sum[i - 1];
                if(s > ans) {
                    ans = s;
                    start = i;
                    end = j;
                }
            }
        }
        System.out.println("start"+start+"end"+end);
        String result = "";
        result = result.concat("子列和："+ans+"\n子列个数:"+(end-start+1)+"\n子列序列：");
        for(;start<=end;start++){
            result = result.concat(list1[start-1]+" ");
        }
        System.out.println(result);
        textView.setText(result);
    }
}
