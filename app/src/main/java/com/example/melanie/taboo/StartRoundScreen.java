package com.example.melanie.taboo;

import android.content.Intent;
import android.media.TimedText;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class StartRoundScreen extends Activity {
    private int rounds, nextTeam, team1score, team2score, hsr_score, hsr_team, hsr_round, time;
    private  double sw_time, lw_time;
    private int pass_count1, pass_count2, correct_count1, correct_count2;
    private String sw_word, lw_word, name1, name2;
    private ArrayList<Integer> validIndices;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();

        setContentView(R.layout.activity_start_round_screen);
        validIndices = intent.getIntegerArrayListExtra(TitleScreenActivity.INDICES);
        rounds = intent.getIntExtra(TitleScreenActivity.ROUNDS_LEFT, 0);
        time = intent.getIntExtra(TitleScreenActivity.TIME, 0);
        nextTeam = intent.getIntExtra( TitleScreenActivity.NEXT_UP, 1);
        team1score = intent.getIntExtra(TitleScreenActivity.T1_SCORE, 0);
        team2score = intent.getIntExtra(TitleScreenActivity.T2_SCORE, 0);
        sw_time = intent.getDoubleExtra(TitleScreenActivity.SW_TIME, 0.0);
        lw_time = intent.getDoubleExtra(TitleScreenActivity.LW_TIME, 121.0);
        sw_word = intent.getStringExtra(TitleScreenActivity.SW_WORD);
        lw_word = intent.getStringExtra(TitleScreenActivity.LW_WORD);
        hsr_score = intent.getIntExtra(TitleScreenActivity.HSR_SCORE, 0);
        hsr_team = intent.getIntExtra(TitleScreenActivity.HSR_TEAM, 0);
        hsr_round = intent.getIntExtra(TitleScreenActivity.HSR_ROUND,0);
        correct_count1 = intent.getIntExtra(TitleScreenActivity.CORRECT_COUNT1, 0);
        pass_count1 = intent.getIntExtra(TitleScreenActivity.PASS_COUNT1, 0);
        correct_count2 = intent.getIntExtra(TitleScreenActivity.CORRECT_COUNT2, 0);
        pass_count2 = intent.getIntExtra(TitleScreenActivity.PASS_COUNT2, 0);
        name1 = intent.getStringExtra(TitleScreenActivity.NAME1);
        name2 = intent.getStringExtra(TitleScreenActivity.NAME2);

        TextView next = (TextView) findViewById(R.id.next);
        TextView left = (TextView) findViewById(R.id.rounds);
        TextView score1 = (TextView) findViewById(R.id.score1);
        TextView score2 = (TextView) findViewById(R.id.score2);

        String tempName;
        if (nextTeam == 1) tempName = name1;
        else tempName = name2;
        next.setText("Team " + tempName);
        left.setText("ROUNDS LEFT: " + rounds);
        score1.setText("" + team1score);
        score2.setText("" + team2score);


    }

    public void RoundScreen(View view) {
        Intent send = new Intent(this, InGameActivity.class);

        send.putExtra(TitleScreenActivity.NAME1, name1);
        send.putExtra(TitleScreenActivity.NAME2, name2);
        send.putExtra(TitleScreenActivity.TIME, time);
        send.putExtra(TitleScreenActivity.T1_SCORE, team1score);
        send.putExtra(TitleScreenActivity.T2_SCORE, team2score);
        send.putExtra(TitleScreenActivity.ROUNDS_LEFT, rounds);
        send.putExtra(TitleScreenActivity.NEXT_UP, nextTeam);
        send.putExtra(TitleScreenActivity.SW_WORD, sw_word);
        send.putExtra(TitleScreenActivity.SW_TIME, sw_time);
        send.putExtra(TitleScreenActivity.LW_WORD, lw_word);
        send.putExtra(TitleScreenActivity.LW_TIME,lw_time);
        send.putExtra(TitleScreenActivity.HSR_SCORE,hsr_score);
        send.putExtra(TitleScreenActivity.HSR_TEAM,hsr_team);
        send.putExtra(TitleScreenActivity.HSR_ROUND,hsr_round);
        send.putExtra(TitleScreenActivity.PASS_COUNT1, pass_count1);
        send.putExtra(TitleScreenActivity.CORRECT_COUNT1, correct_count1);
        send.putExtra(TitleScreenActivity.PASS_COUNT1, pass_count2);
        send.putExtra(TitleScreenActivity.CORRECT_COUNT1, correct_count2);
        send.putIntegerArrayListExtra(TitleScreenActivity.INDICES, validIndices);

        startActivity(send);

    }

    public void nah(View view)
    {
        Intent send = new Intent(this, TitleScreenActivity.class);
        startActivity(send);
    }

}
