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
        save.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setContentView(R.layout.saved);
                final Button savedBack = findViewById(R.id.savedBack);
                savedBack.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        finish();
                    }
                });
            }
        });
        search.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setContentView(R.layout.search);
                final Button searchBack = findViewById(R.id.searchBack);
                searchBack.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        finish();
                    }
                });
            }
        });

    }

}
