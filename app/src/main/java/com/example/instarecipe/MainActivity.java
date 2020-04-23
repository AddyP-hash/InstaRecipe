package com.example.instarecipe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void setUpUi() {
        View chunk;
        chunk = getLayoutInflater().inflate()

        Button save = chunk.findViewById(R.id.savedRecipes);
        Button newRecipe = chunk.findViewById(R.id.newRecipes);
    }
}
