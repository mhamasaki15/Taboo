package com.example.melanie.taboo;

import android.content.Intent;
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        setContentView(R.layout.activity_start_round_screen);
        rounds = intent.getIntExtra(TitleScreenActivity.ROUNDS_LEFT, 0);
        nextTeam = intent.getIntExtra( TitleScreenActivity.NEXT_UP, 1);
        team1score = intent.getIntExtra( TitleScreenActivity.T1_SCORE, 0);
        team2score = intent.getIntExtra( TitleScreenActivity.T2_SCORE, 0);
        TextView next = (TextView) findViewById(R.id.textView);
        TextView left = (TextView) findViewById(R.id.textView2);
        TextView score1 = (TextView) findViewById(R.id.textView3);
        TextView score2 = (TextView) findViewById(R.id.textView4);
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

        send.putExtra("T1_SCORE", team1score);
        send.putExtra("T2_SCORE", team2score);
        send.putExtra("ROUNDS_LEFT", rounds);
        send.putExtra("NEXT_UP",nextTeam);

        startActivity(send);


    }

}
