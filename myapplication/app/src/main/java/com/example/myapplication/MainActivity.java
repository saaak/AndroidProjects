package com.example.myapplication;

import android.nfc.Tag;
import android.os.Bundle;
import android.app.Activity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.util.Log;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "LIFTCYCLE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG,"(1)oncreate()");

        Button button = (Button)findViewById(R.id.btn_finish);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void onStart(){
        super.onStart();
        Log.i(TAG,"(2)onStart");
    }

    @Override
    public void onRestoreInstanceState(Bundle saveInstanceState){
        super.onRestoreInstanceState(saveInstanceState);
        Log.i(TAG,"(3)onRestoreInstanceState");
    }

    @Override
    public void onResume(){
        super.onResume();
        Log.i(TAG,"(4)onResume");
    }

    @Override
    public void onSaveInstanceState(Bundle saveInstanceState){
        super.onSaveInstanceState(saveInstanceState);
        Log.i(TAG,"(5)onSaveInstaceState");
    }

    @Override
    public void onRestart() {
        super.onRestart();
        Log.i(TAG,"(6)onRestart");
    }

    @Override
    public void onPause(){
        super.onPause();
        Log.i(TAG,"(7)onPause()");
    }

    @Override
    public void onStop(){
        super.onStop();
        Log.i(TAG,"(8)onStop()");
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.i(TAG,"(9)onDestroy");
    }
}
