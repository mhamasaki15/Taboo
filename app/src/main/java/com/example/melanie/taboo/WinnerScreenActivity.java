package com.example.melanie.taboo;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.widget.TextView;

import org.w3c.dom.Text;

public class WinnerScreenActivity extends Activity {

    @Override
    public int score1;
    public int score2;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winner_screen);
        TextView winner = (TextView) findViewById(R.id.textView5);
        Intent win = getIntent();
        score1 = win.getIntExtra(InGameActivity.T1_SCORE);
        score2 = win.getIntExtra(InGameActivity.T2_SCORE);
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

}
