package com.example.melanie.taboo;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class StartRoundScreen extends Activity {
    public int ROUNDS_LEFT;
    public int NEXT_UP;
    public int T1_SCORE;
    public int T2_SCORE;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        setContentView(R.layout.activity_start_round_screen);
        ROUNDS_LEFT = intent.getIntExtra(TitleScreenActivity.ROUNDS_LEFT);
        NEXT_UP = intent.getIntExtra( TitleScreenActivity.NEXT_UP);
        T1_SCORE = intent.getIntExtra( TitleScreenActivity.T1_SCORE);
        T2_SCORE = intent.getIntExtra( TitleScreenActivity.T2_SCORE);
        TextView next = (TextView) findViewById(R.id.textView);
        TextView left = (TextView) findViewById(R.id.textView2);
        TextView score1 = (TextView) findViewById(R.id.textView3);
        TextView score2 = (TextView) findViewById(R.id.textView4);
        next.setText("Next up: " + NEXT_UP);
        left.setText("Rounds Left: " + ROUNDS_LEFT);
        score1.setText("Team 1: " + T1_SCORE);
        score2.setText("Team 2: " + T2_SCORE);







    }

    public void RoundScreen(View view) {
        Intent send = new Intent(this, InGameActivity.class);
        send.putExtra("T1_SCORE", T1_SCORE);
        send.putExtra("T2_SCORE",T2_SCORE);
        send.putExtra("ROUNDS_LEFT", ROUNDS_LEFT);
        send.putExtra("NEXT_UP",NEXT_UP);
        startActivity(send);








    }


}
