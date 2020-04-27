package com.example.instarecipe;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class LaunchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.launch);
        final Button save = findViewById(R.id.savedButton);
        final Button search = findViewById(R.id.searchButton);
        save.setVisibility(View.VISIBLE);
        search.setVisibility(View.VISIBLE);
        save.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                save.setVisibility(View.GONE);
                search.setVisibility(View.GONE);
            }
        });
        search.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                save.setVisibility(View.GONE);
                search.setVisibility(View.GONE);
            }
        });
        search.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                save.setVisibility(View.VISIBLE);
                search.setVisibility(View.VISIBLE);
            }
        });
    }

}
