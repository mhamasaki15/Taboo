package com.example.melanie.taboo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import android.widget.Button;


public class TitleScreenActivity extends AppCompatActivity {
    public static final String NEXT_UP = "0";
    public static final String T1_SCORE = "1";
    public static final String T2_SCORE = "2";
    public static final String ROUNDS_LEFT= "6";

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
        int roundsLeft= 6;
        intent.putExtra(ROUNDS_LEFT, roundsLeft);
        int team = 1;
        intent.putExtra(NEXT_UP, team);
        int team1Score = 0;
        intent.putExtra(T1_SCORE, team1Score);
        int team2Score = 0;
        intent.putExtra(T2_SCORE, team2Score);
        startActivity(intent);
    }
}
