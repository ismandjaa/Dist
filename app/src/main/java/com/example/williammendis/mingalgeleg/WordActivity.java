package com.example.williammendis.mingalgeleg;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ListViewCompat;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.net.URL;
import java.util.List;


/**
 * Created by William Mendis on 1/14/2017.
 */
public class WordActivity extends AppCompatActivity{
    Galgelogik logic = new Galgelogik();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word);
        ListView wordList = (ListView) findViewById(R.id.wordList);
        async task = new async();
        task.execute();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ArrayAdapter<String> myAdapter =
                new ArrayAdapter<String>(this, R.layout.activity_word2, logic.getMuligeOrd());
        wordList.setAdapter(myAdapter);

    }
    private class async extends AsyncTask<URL, Integer, Long>{


        @Override
        protected Long doInBackground(URL... urls) {
            try {
                logic.hentOrdFraDr();

            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

    }

}
