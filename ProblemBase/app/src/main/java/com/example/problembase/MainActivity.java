package com.example.problembase;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;

public class MainActivity extends AppCompatActivity {
    private final String fileName = "saveProblems.txt";

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView problem = findViewById(R.id.problemText);
        final TextView aText = findViewById(R.id.aText);
        final TextView bText = findViewById(R.id.bText);
        final TextView cText = findViewById(R.id.cText);
        final TextView dText = findViewById(R.id.dText);
        Button add = findViewById(R.id.addProblem);
        Button see = findViewById(R.id.seeProblem);
        final ProblemController problemController = new ProblemController();
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    File pro = problemController.getProFile(getApplicationContext().getFilesDir().getAbsolutePath());
                    BufferedReader bfe = problemController.readProblemBfe(pro);
                    Integer proNum = problemController.getLastProblemNum(bfe);
                    String proText =
                            "第"+(proNum+1)+"题 " +problem.getText().toString()+
                            "###\nA." +aText.getText().toString()+
                            "###\nB." +bText.getText().toString()+
                            "###\nC." + cText.getText().toString()+
                            "###\nD." +dText.getText().toString()+"###\n~~~\n";
                    problemController.saveProblem(pro,proText);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        see.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);
            }
        });
    }


}
