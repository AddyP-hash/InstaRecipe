package com.example.instarecipe;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.Request;
import com.example.instarecipe.logic.DatabaseInfo;
import com.example.instarecipe.logic.PuppyWebApi;
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

    private void connect() {
        findViewById(R.id.app_bar_search).setVisibility(View.VISIBLE);
        findViewById(R.id.searchButton).setVisibility(View.VISIBLE);
        findViewById(R.id.savedRecipes).setVisibility(View.VISIBLE);
        findViewById(R.id.newRecipes).setVisibility(View.VISIBLE);
        PuppyWebApi.startRequest(this, PuppyWebApi.API + "/results", response -> {
            setUpUi(response);
        }, error ->  {
            Toast.makeText(this, "Unable to reach server!", Toast.LENGTH_SHORT).show();
        });
    }

    private void setUpUi(JsonObject info) {

        JsonArray recipes = info.getAsJsonArray("results");
        for (JsonElement j: recipes) {
            JsonObject recipe = j.getAsJsonObject();

        DatabaseInfo data = new DatabaseInfo(recipe);
        String title = data.getTitle();
        String url = data.getURL();
        String ing = data.getIngredients();
        String thumbnail = data.getThumbnail();

        Button save = findViewById(R.id.savedButton);
        Button newRecipe = findViewById(R.id.searchButton);
        Button saved = findViewById(R.id.savedBack);
        Button search = findViewById(R.id.searchBack);

        Intent myIntent = new Intent(this, DatabaseInfo.class);
        search.setOnClickListener((View v) -> {
            startActivity(myIntent);
            getIntent();
            finish();
        });
        saved.setOnClickListener((View v) -> {
        startActivity(myIntent);
        getIntent();
        finish();
        });
        save.setOnClickListener((View v) -> {
            myIntent.putExtra(title, ing);
            startActivity(myIntent);
            finish();
        });
        newRecipe.setOnClickListener((View v) -> {
            PuppyWebApi.startRequest(getApplicationContext(), PuppyWebApi.API + "/Recipe/" + title + "/Ingredients/" + ing + "/Webpage/" + url, Request.Method.GET, null, response -> {
                connect();
                }, error -> {
                Toast.makeText(this, error.getMessage(), Toast.LENGTH_LONG).show(); });
        });
        //myIntent.putExtra("key", value);  //need to fix this
            //startActivity(myIntent);
/**
    private String createPackageContext(MainActivity mainActivity){
            return null;
            View chunk;
            chunk = getLayoutInflater().inflate();

            Button save = chunk.findViewById(R.id.savedRecipes);
            Button newRecipe = chunk.findViewById(R.id.newRecipes);
 */
        }
    }
}
