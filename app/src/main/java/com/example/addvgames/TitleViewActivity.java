package com.example.addvgames;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class TitleViewActivity extends AppCompatActivity {

    private ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title_view);

        scrollView = findViewById(R.id.scrollView);
        scrollView.removeAllViewsInLayout();
        DatabaseManager dbb = new DatabaseManager(this);
        ArrayList<String> lis = dbb.getTitles();
        GridLayout grid = new GridLayout(this);
        grid.setColumnCount(1);
        grid.setRowCount(lis.size());
        for(String title: lis) {
            TextView text = new TextView(this);
            text.setText(title);
            text.setTextSize(40);
            text.setClickable(true);
            text.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    Intent d = new Intent(getApplicationContext(), ViewActivity.class);
                    d.putExtra("GAME", ((TextView) view).getText().toString());
                    startActivity(d);
                }
            });
            grid.addView(text);
        }
        scrollView.addView(grid);
    }
}
