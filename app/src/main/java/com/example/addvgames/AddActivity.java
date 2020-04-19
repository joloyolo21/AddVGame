package com.example.addvgames;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class AddActivity extends AppCompatActivity {

    private EditText gameBox;
    private EditText studioBox;
    private EditText yearBox;
    private Button done;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        yearBox = findViewById(R.id.yearBox);
        gameBox = findViewById(R.id.gameBox);
        studioBox = findViewById(R.id.studioBox);
        done = findViewById(R.id.done);
    }

    public void addPressed(View v){
        String game = gameBox.getText().toString();
        String year = yearBox.getText().toString();
        String studio = studioBox.getText().toString();
        DatabaseManager dbm = new DatabaseManager(this);
        dbm.insert(game,studio,year);
        finish();
    }

}