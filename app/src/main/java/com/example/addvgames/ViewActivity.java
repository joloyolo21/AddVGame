package com.example.addvgames;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ViewActivity  extends AppCompatActivity {

    private TextView gameView;
    private TextView studioView;
    private TextView yearView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        gameView = findViewById(R.id.gameView);
        studioView = findViewById(R.id.studioView);
        yearView = findViewById(R.id.yearView);

        DatabaseManager dbm = new DatabaseManager(this);
        Intent i = getIntent();
        String game = i.getStringExtra("GAME");
        String[] entry = dbm.get(game);
        gameView.setText(entry[0]);
        studioView.setText(entry[1]);
        yearView.setText(entry[2]);
    }
}