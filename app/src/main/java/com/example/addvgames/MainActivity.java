package com.example.addvgames;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    private Button view;
    private Button add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        add = findViewById(R.id.add);
        view = findViewById(R.id.view);
    }

    public void addPressed(View v) {
        Intent r = new Intent(this, AddActivity.class);
        startActivity(r);
    }

    public void viewPressed(View v) {
        Intent t = new Intent(this, TitleViewActivity.class);
        startActivity(t);
    }
}

