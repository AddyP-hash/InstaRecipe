package com.example.instarecipe;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
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
        PuppyWebApi.startRequest(this, PuppyWebApi.API + "/recipes", response -> {
            setUpUi(response);
        }, error ->  {
            Toast.makeText(this, "Unable to reach server!", Toast.LENGTH_SHORT).show();
        });
    }

    private void setUpUi(JsonObject info) {

        JsonArray recipes = info.getAsJsonArray("results");
        for (JsonElement j: recipes) {
            JsonObject recipe = j.getAsJsonObject();

        DatabaseInfo data = new DatabaseInfo();
        String title = data.getTitle();
        String url = data.getURL();
        String ing = data.getIngredients();
        String thumbnail = data.getThumbnail();

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

    private String createPackageContext(MainActivity mainActivity){
            return null;
            View chunk;
            chunk = getLayoutInflater().inflate();

            Button save = chunk.findViewById(R.id.savedRecipes);
            Button newRecipe = chunk.findViewById(R.id.newRecipes);
        }
    }
}
