package com.example.williammendis.mingalgeleg;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import static android.R.attr.button;
import static com.example.williammendis.mingalgeleg.R.id.guessText;

/**
 * Created by William Mendis on 1/13/2017.
 */

public class GameActivity extends AppCompatActivity implements View.OnClickListener{

    private Button guessButton;
    private ImageView stickman;
    private EditText userText;
    private TextView guessText;
    private TextView someText;
    private TextView someText2;
    Galgelogik logic = new Galgelogik();

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        guessButton = (Button) findViewById(R.id.guessButton);
        guessButton.setOnClickListener(this);
        stickman = (ImageView) findViewById(R.id.stickman);
        userText = (EditText) findViewById(R.id.userText);
        someText = (TextView) findViewById(R.id.someText);
        someText2 = (TextView) findViewById(R.id.someText2);
        guessText = (TextView) findViewById(R.id.guessText);

        guessText.setText("Du skal gætte ordet: " + logic.getSynligtOrd());
        someText.setText("du har gættet forkert 0 gange");
        someText2.setText("brugte bogstaver:");

    }
    @Override
    public void onClick(View v) {
        String usertext = userText.getText().toString();
        if (v == guessButton){
            logic.gætBogstav(usertext);

            if (logic.getAntalForkerteBogstaver() == 1){
                stickman.setImageResource(R.drawable.forkert1);
            }
            if (logic.getAntalForkerteBogstaver() == 2){
                stickman.setImageResource(R.drawable.forkert2);
            }
            if (logic.getAntalForkerteBogstaver() == 3){
                stickman.setImageResource(R.drawable.forkert3);
            }
            if (logic.getAntalForkerteBogstaver() == 4){
                stickman.setImageResource(R.drawable.forkert4);
            }
            if (logic.getAntalForkerteBogstaver() == 5){
                stickman.setImageResource(R.drawable.forkert5);
            }
            if (logic.getAntalForkerteBogstaver() == 6){
                stickman.setImageResource(R.drawable.forkert6);
            }

            guessText.setText("Du skal gætte ordet: " + logic.getSynligtOrd());
            someText2.setText("brugte bogstaver: " + logic.getBrugteBogstaver());
            someText.setText("du har gættet forkert " + logic.getAntalForkerteBogstaver() + " gange");

            if (logic.erSpilletVundet()){
                guessText.setText("SPILLET ER VUNDET!");
            }
            if (logic.erSpilletTabt()){
                guessText.setText("DU ER DØD, GAME OVER!");
                userText.setText("ordet var: " + logic.getOrdet());
            }

        }
    }
}
