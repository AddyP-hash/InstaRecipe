package com.example.instarecipe;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.Toast;

import com.android.volley.Request;
import com.example.instarecipe.logic.DatabaseInfo;
import com.example.instarecipe.logic.PuppyWebApi;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public final class MainActivity extends AppCompatActivity {

    DatabaseInfo recentData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
        String value = intent.getStringExtra("key");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search);
        Button newRecipe = findViewById(R.id.search);
        SearchView searchView = findViewById(R.id.searchView);
        newRecipe.setOnClickListener((View v) -> {
            String title = searchView.toString();
            PuppyWebApi.startRequest(getApplicationContext(), PuppyWebApi.API + "q" + title, Request.Method.GET, null, response -> {
                String link = response.get("results").getAsJsonArray().get(0).getAsJsonObject().get("href").getAsString();
                setContentView(R.layout.brownies); // called brownies but just the xml that redirects to online websites
                WebView webview = findViewById(R.id.webView);
                webview.setWebViewClient(new WebViewClient());
                webview.getSettings().setJavaScriptEnabled(true);
                webview.getSettings().setDomStorageEnabled(true);
                webview.setOverScrollMode(WebView.OVER_SCROLL_NEVER);
                webview.loadUrl(link);
                final Button savedBack = findViewById(R.id.savedBack);
                savedBack.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        finish();
                    }
                });
            }, error -> {
                Toast.makeText(this, error.getMessage(), Toast.LENGTH_LONG).show(); });
        });
    }

    private void connect() {
        PuppyWebApi.startRequest(this, PuppyWebApi.API + "output", response -> {
            //setUpUi(response);
        }, error ->  {
            Toast.makeText(this, "Unable to reach server!", Toast.LENGTH_SHORT).show();
        });
    }

    private void setUpUi(JsonObject info) {

        JsonArray recipes = info.getAsJsonArray("results");
        for (JsonElement j: recipes) {
            JsonObject recipe = j.getAsJsonObject();

        DatabaseInfo data = new DatabaseInfo(recipe);
        recentData = data;
        String url = data.getURL();
        String ing = data.getIngredients();
        String thumbnail = data.getThumbnail();

        Button searchBack = findViewById(R.id.searchBack);

        Intent myIntent = new Intent(this, DatabaseInfo.class);
            String link = data.getURL();


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
