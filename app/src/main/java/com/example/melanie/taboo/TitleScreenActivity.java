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
    public static final String SW_WORD = "3";
    public static final String SW_TEAM = "9";
    public static final String SW_TIME = "10";
    public static final String LW_WORD = "11";
    public static final String LW_TEAM = "12";
    public static final String LW_TIME = "13";
    public static final String HSR_SCORE = "14";
    public static final String HSR_TEAM = "15";
    public static final String HSR_ROUND = "16";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title_screen);
        getIntent();
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
        double short_time = 61.0;
        double long_time = 0.0;
        int sw_team = 1;
        int long_team = 1;
        int hsr_team = 1;
        String word = "";
        String long_word = "";
        int high_round = 9;
        int high_score = 1200;

        intent.putExtra(T2_SCORE, team2Score);
        intent.putExtra(SW_WORD,word );
        intent.putExtra(LW_WORD,long_word);
        intent.putExtra(SW_TEAM,sw_team);
        intent.putExtra(LW_TEAM,long_team);
        intent.putExtra(HSR_TEAM, hsr_team);
        intent.putExtra(SW_TIME,short_time);
        intent.putExtra(LW_TIME, long_time);
        intent.putExtra(HSR_SCORE, high_score);
        intent.putExtra(HSR_ROUND,high_round);

        startActivity(intent);
    }
}
