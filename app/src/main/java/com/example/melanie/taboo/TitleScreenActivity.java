package com.example.melanie.taboo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
<<<<<<< HEAD
import android.widget.Button;
=======
>>>>>>> origin/master

public class TitleScreenActivity extends AppCompatActivity {
    /*public String NEXT_UP = "0";
    public String T1_SCORE = "0";
    public String T2_SCORE = "0";
    public String ROUNDS_LEFT= "0";*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title_screen);
    }

    public void sendtoAbout(View view){
        Intent intent = new Intent(this, AboutPageActivity.class);
        startActivity(intent);
    }

    public void sendtoRules(View view){
        Intent intent = new Intent(this, RulesPageActivity.class);
        startActivity(intent);
    }

    public void sendtoStartRoundScreen(View view){
        Intent intent = new Intent(this, StartRoundScreen.class);
        /*int roundsLeft= 0;
        intent.putExtra(ROUNDS_LEFT, roundsLeft);
        int team = 1;
        intent.putExtra(NEXT_UP, team);
        int team1Score = 0;
        intent.putExtra(T1_SCORE, team1Score);
        int team2Score = 0;
        intent.putExtra(T2_SCORE, team2Score);*/
        startActivity(intent);
    }
}
