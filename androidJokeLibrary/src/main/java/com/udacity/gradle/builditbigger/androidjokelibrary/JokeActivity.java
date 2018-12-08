package com.udacity.gradle.builditbigger.androidjokelibrary;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class JokeActivity extends AppCompatActivity {
    private static final String EXTRA_JOKE = "joke";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);
        TextView textViewJoke = findViewById(R.id.text_view_joke);
        String joke = getIntent().getStringExtra(EXTRA_JOKE);
        textViewJoke.setText(joke);
    }
}
