package com.example.menutest;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    final static int CONTEXT_MENU_1 = Menu.FIRST;
    final static int CONTEXT_MENU_2 = Menu.FIRST+1;
    EditText colorText = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        colorText = (EditText)findViewById(R.id.colorText);
        registerForContextMenu(colorText);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){
        menu.setHeaderTitle("操作选项");
        menu.add(0,CONTEXT_MENU_1,0,"大写");
        menu.add(0,CONTEXT_MENU_2,1,"小写");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item){
        switch (item.getItemId()){
            case CONTEXT_MENU_1:
                colorText.setText(colorText.getText().toString().toUpperCase());
                return true;
            case CONTEXT_MENU_2:
                colorText.setText(colorText.getText().toString().toLowerCase());
                return true;
        }
        return false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.main_menu_0:
                colorText.setBackgroundColor(Color.RED);
                return true;
            case R.id.main_menu_1:
                colorText.setBackgroundColor(Color.GREEN);
                return true;
            case R.id.main_menu_2:
                colorText.setBackgroundColor(Color.BLUE);
                return true;
        }
        return false;
    }
}
