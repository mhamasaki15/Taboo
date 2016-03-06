package com.example.melanie.taboo;

import android.content.Intent;
import android.media.TimedText;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class StartRoundScreen extends Activity {
/*    public int ROUNDS_LEFT;
    public int NEXT_UP;
    public int T1_SCORE;
    public int T2_SCORE;
 */
    private int rounds;
    private int nextTeam;
    private int team1score;
    private int team2score;
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
        Intent intent = getIntent();
        setContentView(R.layout.activity_start_round_screen);
        rounds = intent.getIntExtra(TitleScreenActivity.ROUNDS_LEFT, 0);
        nextTeam = intent.getIntExtra( TitleScreenActivity.NEXT_UP, 1);
        team1score = intent.getIntExtra( TitleScreenActivity.T1_SCORE, 0);

        team2score = intent.getIntExtra(TitleScreenActivity.T2_SCORE, 0);
        SW_WORD = intent.getStringExtra(TitleScreenActivity.SW_WORD);
        SW_TIME = intent.getDoubleExtra(TitleScreenActivity.SW_TIME, 0.0);
        SW_TEAM = intent.getIntExtra(TitleScreenActivity.SW_TEAM, 0);
        LW_WORD = intent.getStringExtra(TitleScreenActivity.LW_WORD);
        LW_TIME = intent.getDoubleExtra(TitleScreenActivity.LW_TIME, 0.0);
        LW_TEAM = intent.getIntExtra(TitleScreenActivity.LW_TEAM, 0);
        HSR_SCORE = intent.getIntExtra(TitleScreenActivity.HSR_SCORE,0);
        HSR_TEAM = intent.getIntExtra(TitleScreenActivity.HSR_TEAM,0);
        HSR_ROUND = intent.getIntExtra(TitleScreenActivity.HSR_ROUND,0);
        TextView next = (TextView) findViewById(R.id.next);
        TextView left = (TextView) findViewById(R.id.rounds);
        TextView score1 = (TextView) findViewById(R.id.score1);
        TextView score2 = (TextView) findViewById(R.id.score2);
        team2score = intent.getIntExtra( TitleScreenActivity.T2_SCORE, 0);;
        next.setText("GET READY Team " + nextTeam);
        left.setText("ROUNDS LEFT: " + rounds);
        score1.setText("" + team1score);
        score2.setText("" + team2score);


    }

    public void RoundScreen(View view) {
        Intent send = new Intent(this, InGameActivity.class);

        send.putExtra(TitleScreenActivity.T1_SCORE, team1score);
        send.putExtra(TitleScreenActivity.T2_SCORE, team2score);
        send.putExtra(TitleScreenActivity.ROUNDS_LEFT, rounds);
        send.putExtra(TitleScreenActivity.NEXT_UP, nextTeam);
        send.putExtra(TitleScreenActivity.SW_WORD, SW_WORD);
        send.putExtra(TitleScreenActivity.SW_TIME, SW_TIME);
        send.putExtra(TitleScreenActivity.SW_TEAM, SW_TEAM);
        send.putExtra(TitleScreenActivity.LW_WORD, LW_WORD);
        send.putExtra(TitleScreenActivity.LW_TIME,LW_TIME);
        send.putExtra(TitleScreenActivity.LW_TEAM,LW_TEAM);
        send.putExtra(TitleScreenActivity.HSR_SCORE,HSR_SCORE);
        send.putExtra(TitleScreenActivity.HSR_TEAM,HSR_TEAM);
        send.putExtra(TitleScreenActivity.HSR_ROUND,HSR_ROUND);

        startActivity(send);


    }

}
