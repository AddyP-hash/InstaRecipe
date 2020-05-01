package com.example.instarecipe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.webkit.WebView;
import android.webkit.WebViewClient;

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
                final Button brownies = findViewById(R.id.brownies);
                final Button grilledCheese = findViewById(R.id.grilledCheese);
                final Button tunaMelt = findViewById(R.id.tunaMelt);
                final Button beefTend = findViewById(R.id.beefTenderloin);
                final Button salmon = findViewById(R.id.salmon);
                final Button cake = findViewById(R.id.cake);

                brownies.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        setContentView(R.layout.brownies);
                        WebView webview = findViewById(R.id.webView);

                        webview.setWebViewClient(new WebViewClient());
                        webview.getSettings().setJavaScriptEnabled(true);
                        webview.getSettings().setDomStorageEnabled(true);
                        webview.setOverScrollMode(WebView.OVER_SCROLL_NEVER);
                        webview.loadUrl("https://www.food.com/recipe/double-fudge-cream-cheese-brownies-81799");
                        final Button savedBack = findViewById(R.id.savedBack);
                        savedBack.setOnClickListener(new View.OnClickListener() {
                            public void onClick(View v) {
                                finish();
                            }
                        });
                    }
                });

                grilledCheese.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        setContentView(R.layout.brownies);
                        WebView webview = findViewById(R.id.webView);

                        webview.setWebViewClient(new WebViewClient());
                        webview.getSettings().setJavaScriptEnabled(true);
                        webview.getSettings().setDomStorageEnabled(true);
                        webview.setOverScrollMode(WebView.OVER_SCROLL_NEVER);
                        webview.loadUrl("https://www.allrecipes.com/recipe/139180/grilled-ham-and-cheese-with-a-twist/");
                        final Button savedBack = findViewById(R.id.savedBack);
                        savedBack.setOnClickListener(new View.OnClickListener() {
                            public void onClick(View v) {
                                finish();
                            }
                        });
                    }
                });

                tunaMelt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        setContentView(R.layout.brownies);
                        WebView webview = findViewById(R.id.webView);

                        webview.setWebViewClient(new WebViewClient());
                        webview.getSettings().setJavaScriptEnabled(true);
                        webview.getSettings().setDomStorageEnabled(true);
                        webview.setOverScrollMode(WebView.OVER_SCROLL_NEVER);
                        webview.loadUrl("https://www.allrecipes.com/recipe/163924/mr-heads-spicy-tuna-melt/");
                        final Button savedBack = findViewById(R.id.savedBack);
                        savedBack.setOnClickListener(new View.OnClickListener() {
                            public void onClick(View v) {
                                finish();
                            }
                        });
                    }
                });

                beefTend.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        setContentView(R.layout.brownies);
                        WebView webview = findViewById(R.id.webView);

                        webview.setWebViewClient(new WebViewClient());
                        webview.getSettings().setJavaScriptEnabled(true);
                        webview.getSettings().setDomStorageEnabled(true);
                        webview.setOverScrollMode(WebView.OVER_SCROLL_NEVER);
                        webview.loadUrl("https://www.food.com/recipe/fillet-of-beef-beef-tenderloin-whole-57685");
                        final Button savedBack = findViewById(R.id.savedBack);
                        savedBack.setOnClickListener(new View.OnClickListener() {
                            public void onClick(View v) {
                                finish();
                            }
                        });
                    }
                });

                salmon.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        setContentView(R.layout.brownies);
                        WebView webview = findViewById(R.id.webView);

                        webview.setWebViewClient(new WebViewClient());
                        webview.getSettings().setJavaScriptEnabled(true);
                        webview.getSettings().setDomStorageEnabled(true);
                        webview.setOverScrollMode(WebView.OVER_SCROLL_NEVER);
                        webview.loadUrl("https://www.epicurious.com/recipes/food/views/Salmon-with-Beurre-Rouge-and-Smoked-Salmon-Stuffed-Baked-Potato-235839");
                        final Button savedBack = findViewById(R.id.savedBack);
                        savedBack.setOnClickListener(new View.OnClickListener() {
                            public void onClick(View v) {
                                finish();
                            }
                        });
                    }
                });

                cake.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        setContentView(R.layout.brownies);
                        WebView webview = findViewById(R.id.webView);

                        webview.setWebViewClient(new WebViewClient());
                        webview.getSettings().setJavaScriptEnabled(true);
                        webview.getSettings().setDomStorageEnabled(true);
                        webview.setOverScrollMode(WebView.OVER_SCROLL_NEVER);
                        webview.loadUrl("https://www.food.com/recipe/chocolate-truffle-cake-305333");
                        final Button savedBack = findViewById(R.id.savedBack);
                        savedBack.setOnClickListener(new View.OnClickListener() {
                            public void onClick(View v) {
                                finish();
                            }
                        });
                    }
                });

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
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
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