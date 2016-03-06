package com.example.melanie.taboo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class StatisticsActivity extends Activity {
    private int score1;
    private int score2;

    private double shortestTime;
    private String shortestTimeWord;
    private int shortestTimeTeam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);

        Intent intent = getIntent();
        score1 = intent.getIntExtra(TitleScreenActivity.T1_SCORE, 23);
        score2 = intent.getIntExtra(TitleScreenActivity.T2_SCORE, 24);
        /*


         */

    }
}
