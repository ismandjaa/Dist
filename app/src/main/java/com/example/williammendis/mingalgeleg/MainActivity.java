package com.example.williammendis.mingalgeleg;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button startGame;
    private Button help;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startGame = (Button) findViewById(R.id.gameOn);
        startGame.setOnClickListener(this);
        help = (Button) findViewById(R.id.help);
        help.setOnClickListener(this);

    }

    @Override
    public void onClick(View v){
        if(v == startGame){
            Intent s = new Intent(this, GameActivity.class);
            startActivity(s);
        }
        else if(v == help){
             Intent h = new Intent(this, HelpActivity.class);
             startActivity(h);
         }
    }
   // @Override
    //public void onClick(View v) {
       // if (v == startGame){
            //FragmentManager fragmentManager = getSupportFragmentManager();
            //FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
           // HelpFragment fragment = new HelpFragment();
           // fragmentTransaction.add(R.id.activity_main, fragment);
          //  fragmentTransaction.commit();

        //}


   // }


    }
