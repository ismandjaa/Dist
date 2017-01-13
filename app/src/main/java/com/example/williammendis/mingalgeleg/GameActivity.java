package com.example.williammendis.mingalgeleg;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import static android.R.attr.button;

/**
 * Created by William Mendis on 1/13/2017.
 */

public class GameActivity extends AppCompatActivity implements View.OnClickListener{

    private Button guessButton;
    private EditText guesstext;
    private ImageView stickman;
    private TextView sometext;
    Galgelogik logic = new Galgelogik();

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        guessButton = (Button) findViewById(R.id.guessButton);


    }
    @Override
    public void onClick(View v) {
        if (v == guessButton){

        }
    }
}
