package com.example.melanie.taboo;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class WinnerScreenActivity extends Activity {

    private int score1, score2;
    private double sw_time, lw_time;
    private String sw_word, lw_word, name1, name2;
    private int hsr_score, hsr_team, pass_count1, correct_count1, pass_count2, correct_count2;
    private ArrayList<String> passList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winner_screen);
        TextView winner = (TextView) findViewById(R.id.textView5);
        Intent win = getIntent();
        passList = win.getStringArrayListExtra(TitleScreenActivity.PASS_LIST);
        name1 = win.getStringExtra(TitleScreenActivity.NAME1);
        name1 = win.getStringExtra(TitleScreenActivity.NAME2);
        sw_time = win.getDoubleExtra(TitleScreenActivity.SW_TIME, 0);
        lw_time = win.getDoubleExtra(TitleScreenActivity.LW_TIME, 0);
        sw_word = win.getStringExtra(TitleScreenActivity.SW_WORD);
        lw_word = win.getStringExtra(TitleScreenActivity.LW_WORD);
        hsr_score = win.getIntExtra(TitleScreenActivity.HSR_SCORE, 0);
        hsr_team = win.getIntExtra(TitleScreenActivity.HSR_TEAM, 0);
        correct_count1 = win.getIntExtra(TitleScreenActivity.CORRECT_COUNT1, 0);
        correct_count2 = win.getIntExtra(TitleScreenActivity.CORRECT_COUNT2, 0);
        pass_count1 = win.getIntExtra(TitleScreenActivity.PASS_COUNT1, 0);
        pass_count2 = win.getIntExtra(TitleScreenActivity.PASS_COUNT2, 0);

        score1 = win.getIntExtra(TitleScreenActivity.T1_SCORE, 0);
        score2 = win.getIntExtra(TitleScreenActivity.T2_SCORE,0);
        if (score1 > score2) {
            winner.setText("Team 1 wins!");
        } else if (score2 > score1)
        {
            winner.setText("Team 2 wins!");
        }
        else
        {
            winner.setText("Tie Game!");
        }

    }

    public void Restart(View view)
    {
        Intent restart = new Intent(this, SettingsActivity.class);
        startActivity(restart);
    }

    public void nah(View view)
    {
        Intent nope = new Intent(this, TitleScreenActivity.class);
        startActivity(nope);

    }
    public void stats(View view)
    {
        Intent it = new Intent(this, StatisticsActivity.class);
        it.putExtra(TitleScreenActivity.SW_TIME, sw_time);
        it.putExtra(TitleScreenActivity.LW_TIME, lw_time);
        it.putExtra(TitleScreenActivity.SW_WORD, sw_word);
        it.putExtra(TitleScreenActivity.LW_WORD, lw_word);
        it.putExtra(TitleScreenActivity.HSR_SCORE, hsr_score);
        it.putExtra(TitleScreenActivity.HSR_TEAM, hsr_team);
        it.putExtra(TitleScreenActivity.PASS_COUNT1, pass_count1);
        it.putExtra(TitleScreenActivity.PASS_COUNT2, pass_count2);
        it.putExtra(TitleScreenActivity.CORRECT_COUNT1, correct_count1);
        it.putExtra(TitleScreenActivity.CORRECT_COUNT2, correct_count2);
        it.putExtra(TitleScreenActivity.NAME1, name1);
        it.putExtra(TitleScreenActivity.NAME2, name2);
        it.putStringArrayListExtra(TitleScreenActivity.PASS_LIST, passList);
        startActivity(it);
    }

}