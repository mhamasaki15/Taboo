package com.example.melanie.taboo;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.widget.TextView;


public class WinnerScreenActivity extends Activity {

    public int score1;
    public int score2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winner_screen);
        TextView winner = (TextView) findViewById(R.id.textView5);
        Intent win = getIntent();
        score1 = win.getIntExtra(TitleScreenActivity.T1_SCORE,0);
        score2 = win.getIntExtra(TitleScreenActivity.T2_SCORE,0);
        if (score1 > score2) {
            winner.setText("Team 1 wins!");
        } else if (score2 > score1)
        {
            winner.setText("Team 2 wins!");
        }
        else
        {
            winner.setText("Tie game!");
            //maybe include coin flip?
        }

    }

    public void Restart()
    {
        Intent restart = new Intent(this, StartRoundScreen.class);
        int rounds = 6;
        int nextTeam = 1;
        int team1score = 0;
        int team2score = 0;
        restart.putExtra(TitleScreenActivity.T1_SCORE, team1score);
        restart.putExtra(TitleScreenActivity.T2_SCORE,team2score);
        restart.putExtra(TitleScreenActivity.NEXT_UP, nextTeam);
        restart.putExtra(TitleScreenActivity.ROUNDS_LEFT,rounds);
        
        startActivity(restart);
    }



}