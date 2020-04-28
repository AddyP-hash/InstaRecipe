package com.example.instarecipe;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;



public final class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Intent intent = getIntent();
        String value = intent.getStringExtra("key");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void setUpUi() {
        findViewById(R.id.app_bar_search).setVisibility(View.VISIBLE);
        findViewById(R.id.searchButton).setVisibility(View.VISIBLE);
        findViewById(R.id.savedRecipes).setVisibility(View.VISIBLE);
        findViewById(R.id.newRecipes).setVisibility(View.VISIBLE);


        View chunk;
        chunk = getLayoutInflater().inflate(R.layout.activity_main);

        Button save = chunk.findViewById(R.id.savedRecipes);
        Button newRecipe = chunk.findViewById(R.id.newRecipes);
        final Intent myIntent = new Intent(MainActivity.this, NewOrder.class);
        save.setOnClickListener((View v) -> {
            myIntent.putExtra("game" ......)
            startActivity(myIntent);
        });
        newRecipe.setOnClickListener((View v) -> {

        });
        myIntent.putExtra("key", value);  //need to fix this
        startActivity(myIntent);
    }

    private String createPackageContext(MainActivity mainActivity) {
        return null;
        //View chunk;
        //chunk = getLayoutInflater().inflate();

        //Button save = chunk.findViewById(R.id.savedRecipes);
        // Button newRecipe = chunk.findViewById(R.id.newRecipes);
    }
}
