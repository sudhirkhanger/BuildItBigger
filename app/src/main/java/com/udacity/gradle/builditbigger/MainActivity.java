package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.sudhirkhanger.app.libjokesactivity.JokesActivity;
import com.sudhirkhanger.builditbigger.libjokes.LibJokes;


public class MainActivity extends ActionBarActivity {

    public static final String KEY_JOKE = "KEY_JOKE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

//    public void tellJoke(View view) {
//        LibJokes libJokes = new LibJokes();
//        new EndpointsAsyncTask().execute(new Pair<Context, String>(view.getContext(), libJokes.getJokes()));
////        Toast.makeText(this, "derp", Toast.LENGTH_SHORT).show();
//    }

    public void tellJoke(View view) {
        LibJokes libJokes = new LibJokes();
        Intent intent = new Intent(this, JokesActivity.class);
        intent.putExtra(libJokes.getJokes(), KEY_JOKE);
        startActivity(intent);
    }
}
