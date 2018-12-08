package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import com.udacity.gradle.builditbigger.androidjokelibrary.JokeActivity;

public class MainActivity extends AppCompatActivity {
    private static final String EXTRA_JOKE = "joke";
    private JokeTask ThisJokeTask;
    private Context ThisContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ThisContext = this;
    }

    @Override
    protected void onDestroy() {
        ThisJokeTask.setListener(null);
        super.onDestroy();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view) {
        ThisJokeTask = new JokeTask();
        ThisJokeTask.setListener(new JokeTask.JokeTaskListener() {
            public void onJokeTaskFinished(String s) {
                Intent intent = new Intent(ThisContext, JokeActivity.class);
                intent.putExtra(EXTRA_JOKE, s);
                startActivity(intent);
            }
        });
        ProgressBar progressBar = findViewById(R.id.progress_bar);
        progressBar.setVisibility(View.VISIBLE);
        ThisJokeTask.execute();
    }


}
