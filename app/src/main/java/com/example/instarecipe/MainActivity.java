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

import com.example.instarecipe.logic.DatabaseInfo;
import com.example.instarecipe.logic.PuppyWebApi;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

public final class MainActivity extends AppCompatActivity {

    DatabaseInfo recentData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search);
        Button exit = findViewById(R.id.searchBack);
        Button newRecipe = findViewById(R.id.search);
        SearchView searchView = findViewById(R.id.searchView);
        newRecipe.setOnClickListener((View v) -> {
            String title = searchView.getQuery().toString();
            System.out.println(title);
            PuppyWebApi.startRequest(getApplicationContext(), PuppyWebApi.API + "?q=" + title, response -> {
                System.out.println("response received");
                JsonObject responseAsJson = new Gson().fromJson(response, JsonObject.class);
                String link = responseAsJson.get("results").getAsJsonArray().get(0).getAsJsonObject().get("href").getAsString();
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
                System.out.println("error");
                Toast.makeText(this, error.getMessage(), Toast.LENGTH_LONG).show(); });
        });
        exit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });
    }
}
