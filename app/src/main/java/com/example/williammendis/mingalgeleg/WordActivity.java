package com.example.williammendis.mingalgeleg;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ListViewCompat;
import android.view.View;
import android.widget.AdapterView;
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
        final ListView wordList = (ListView) findViewById(R.id.wordList);
        async task = new async();
        task.execute();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        final ArrayAdapter<String> myAdapter =
                new ArrayAdapter<String>(this, R.layout.activity_word2, logic.getMuligeOrd());
        wordList.setAdapter(myAdapter);

        wordList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapter, View v, int position,
                                    long arg3) {
                // TODO Auto-generated method stub
                String chosentext = (String)adapter.getItemAtPosition(position);
                System.out.println("chosen word was: " + chosentext);
                logic.setOrdet(chosentext);
                Intent myIntent = new Intent(v.getContext(), GameActivity.class);
                startActivity(myIntent);

            }

        });

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
