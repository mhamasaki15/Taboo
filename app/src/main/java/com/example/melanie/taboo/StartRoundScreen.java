package com.example.melanie.taboo;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class StartRoundScreen extends Activity {
    public int Rounds_Left;
    public int Next_UP;
    public int T1_score;
    public int T2_score;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_round_screen);
        Intent intent = getIntent();
        Rounds_Left = intent.getIntExtra(TitleScreenActivity.Rounds_Left);
        Next_UP = intent.getIntExtra( TitleScreenActivity.Next_UP);
        T1_score = intent.getIntExtra( TitleScreenActivity.T1_score);
        T2_score = intent.getIntExtra( TitleScreenActivity.T2_score);
        TextView next = (TextView) findViewById(R.id.textView);
        TextView left = (TextView) findViewById(R.id.textView2);
        TextView score1 = (TextView) findViewById(R.id.textView3);
        TextView score2 = (TextView) findViewById(R.id.textView4);
        next.setText("Next up: " + Next_UP);
        left.setText("Rounds Left: " + Rounds_Left);
        score1.setText("Team 1: " + T1_score);
        score2.setText("Team 2: " + T2_score);
        Button start_round = (Button) findViewById(R.id.button);





    }

    public void RoundScreen(View view) {




    }


}
