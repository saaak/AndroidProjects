package com.example.p22;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import static com.example.p22.R.layout.support_simple_spinner_dropdown_item;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ListView listView = (ListView)findViewById(R.id.listView1);
        final Button button = (Button)findViewById(R.id.button);
        final Button button2 = (Button)findViewById(R.id.button2);

        final List<String>list=new ArrayList<String>();
        String val = "";
        Random random = new Random();
        for(int i=0 ; i<20;i++) {
            for (int j = 0; j < 11; j++) {
                val += String.valueOf(random.nextInt(10));
            }
            list.add(val);
            val="";
        }
        final ArrayAdapter<String>adapter = new ArrayAdapter<String>(this, support_simple_spinner_dropdown_item,list);
        listView.setAdapter(adapter);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                for(int k = 0 ;k<list.size();k++){
//                    if(list.get(k).substring(0,2).equals("13")||list.get(k).substring(0,2).equals("15")||list.get(k).substring(0,2).equals("17")||list.get(k).substring(0,2).equals("18")){
//                        continue;
//                    }else {
//                        list.remove(k);
//                    }
//                }
                Iterator<String> iterator = list.iterator();
                while (iterator.hasNext()) {
                    String s = iterator.next();
                    if(s.substring(0,2).equals("13")||s.substring(0,2).equals("15")||s.substring(0,2).equals("17")||s.substring(0,2).equals("18")){
                        continue;
                    }else {
                        iterator.remove();
                    }
                }
                adapter.notifyDataSetChanged();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String val = "";
                Random random = new Random();
                for(int i=0 ; i<20;i++) {
                    for (int j = 0; j < 11; j++) {
                        val += String.valueOf(random.nextInt(10));
                    }
                    list.add(val);
                    val="";
                }
                adapter.notifyDataSetChanged();
            }
        });
    }
}
