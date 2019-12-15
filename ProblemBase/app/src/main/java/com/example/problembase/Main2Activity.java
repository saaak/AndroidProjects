package com.example.problembase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main2Activity extends AppCompatActivity {

    private TextView proText = null;
    private TextView aT = null;
    private TextView bT = null;
    private TextView cT = null;
    private TextView dT = null;
    private Integer[] proNum={0};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        proText = findViewById(R.id.problem);
        aT = findViewById(R.id.A);
        bT = findViewById(R.id.B);
        cT = findViewById(R.id.C);
        dT = findViewById(R.id.D);
        Button up = findViewById(R.id.up);
        final Button down = findViewById(R.id.down);
        Button addpro = findViewById(R.id.addAct);
        final Button destory = findViewById(R.id.destory);
        final ProblemController problemController = new ProblemController();
        final Integer[] nowPro = {1};
        init();


        up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(nowPro[0] ==1){
                    return;
                }else {
                    BufferedReader bfe = null;
                    try {
                        File pro = problemController.getProFile(getApplicationContext().getFilesDir().getAbsolutePath());
                        bfe = problemController.readProblemBfe(pro);
                        int lineCnt=1;
                        while(lineCnt<=6*(nowPro[0] -2)&&bfe.readLine()!=null){
                            lineCnt++;
                        }
                        setProText(nowPro[0]-1,bfe);
                        nowPro[0]--;

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            }
        });
        down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(nowPro[0] ==proNum[0]){
                    return;
                }else {
                    BufferedReader bfe = null;
                    try {
                        File pro = problemController.getProFile(getApplicationContext().getFilesDir().getAbsolutePath());
                        bfe = problemController.readProblemBfe(pro);
                        int lineCnt=1;
                        while(lineCnt<=6*(nowPro[0])&&bfe.readLine()!=null){
                            lineCnt++;
                        }
                        setProText(nowPro[0]+1,bfe);
                        nowPro[0] ++;

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        addpro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main2Activity.this,MainActivity.class);
                startActivity(intent);
            }
        });

        destory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();

            }
        });
    }

    public void setProText(Integer proNum,BufferedReader bfe) throws IOException {
        String str = bfe.readLine();
        proText.setText(proNum+"."+str.substring(3,str.length()-3));
        str = bfe.readLine();
        aT.setText(str.substring(0,str.length()-3));
        str = bfe.readLine();
        bT.setText(str.substring(0,str.length()-3));
        str = bfe.readLine();
        cT.setText(str.substring(0,str.length()-3));
        str = bfe.readLine();
        dT.setText(str.substring(0,str.length()-3));
    }

    public void init(){
        ProblemController problemController = new ProblemController();
        File pro = problemController.getProFile(getApplicationContext().getFilesDir().getAbsolutePath());

        try {
            BufferedReader bfe = problemController.readProblemBfe(pro);
            BufferedReader bfeCp = problemController.readProblemBfe(pro);
            proNum[0] =problemController.getLastProblemNum(bfeCp);
            setProText(1,bfe);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
