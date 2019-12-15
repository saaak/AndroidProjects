package com.example.internalfiledemo;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText name;
    private EditText age;
    private EditText height;
    public static final String PREFERENCE_NAME="SaveString";
    public static int MODE = Context.MODE_PRIVATE+Context.MODE_ENABLE_WRITE_AHEAD_LOGGING;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.name);
        age = findViewById(R.id.age);
        height = findViewById(R.id.height);
    }

    public void onStart() {
        super.onStart();
        loadSharedPreferences();
    }

    public void onStop(){
        super.onStop();
        saveSharedPreferences();
    }

    private void loadSharedPreferences(){
        SharedPreferences sharedPreferences = getSharedPreferences(PREFERENCE_NAME,MODE);
        String namestr = sharedPreferences.getString("Name","Tom");
        int agenum = sharedPreferences.getInt("Age",(int)20);
        float heightval = sharedPreferences.getFloat("Height",1.83f);
        name.setText(namestr);
        age.setText(String.valueOf(agenum));
        height.setText(String.valueOf(heightval));
    }

    private void saveSharedPreferences(){
        @SuppressLint("WrongConstant") SharedPreferences sharedPreferences = getSharedPreferences(PREFERENCE_NAME,MODE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("Name",name.getText().toString());
        editor.putInt("Age",Integer.parseInt(age.getText().toString()));
        editor.putFloat("Height",Float.parseFloat(height.getText().toString()));
        editor.commit();
    }
}
