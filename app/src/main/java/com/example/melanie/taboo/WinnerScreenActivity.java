package com.example.melanie.taboo;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.widget.TextView;


public class WinnerScreenActivity extends Activity {

    public int score1;
    public int score2;
    private  String SW_WORD = "3";
    private  int SW_TEAM;
    private  double SW_TIME;
    private  String LW_WORD = "11";
    private  int LW_TEAM;
    private  double LW_TIME;
    private  int HSR_SCORE;
    private  int HSR_TEAM;
    private  int HSR_ROUND;
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
        restart.putExtra(TitleScreenActivity.T2_SCORE, team2score);
        restart.putExtra(TitleScreenActivity.NEXT_UP, nextTeam);
        restart.putExtra(TitleScreenActivity.ROUNDS_LEFT,rounds);
        restart.putExtra(TitleScreenActivity.SW_WORD, SW_WORD);
        restart.putExtra(TitleScreenActivity.SW_TIME, SW_TIME);
        restart.putExtra(TitleScreenActivity.SW_TEAM, SW_TEAM);
        restart.putExtra(TitleScreenActivity.LW_WORD, LW_WORD);
        restart.putExtra(TitleScreenActivity.LW_TIME,LW_TIME);
        restart.putExtra(TitleScreenActivity.LW_TEAM,LW_TEAM);
        restart.putExtra(TitleScreenActivity.HSR_SCORE,HSR_SCORE);
        restart.putExtra(TitleScreenActivity.HSR_TEAM,HSR_TEAM);
        restart.putExtra(TitleScreenActivity.HSR_ROUND,HSR_ROUND);

        startActivity(restart);
    }

    public void nah()
    {
        Intent nope = new Intent(this, TitleScreenActivity.class);
        startActivity(nope);

    }
    public void stats()
    {
        Intent send_stats = new Intent(this, StatisticsActivity.class);
        send_stats.putExtra(TitleScreenActivity.T1_SCORE,score1);
        send_stats.putExtra(TitleScreenActivity.T2_SCORE,score2);
        startActivity(send_stats);
    }



}