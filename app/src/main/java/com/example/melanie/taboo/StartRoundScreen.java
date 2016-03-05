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
    private int sam;
    private int sam2;
    private int sam3;
    private int sam4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        setContentView(R.layout.activity_start_round_screen);
        sam = intent.getIntExtra(TitleScreenActivity.ROUNDS_LEFT, 21);
        sam2 = intent.getIntExtra( TitleScreenActivity.NEXT_UP, 22);
        sam3 = intent.getIntExtra( TitleScreenActivity.T1_SCORE, 23);
        sam4 = intent.getIntExtra( TitleScreenActivity.T2_SCORE, 24);
        TextView next = (TextView) findViewById(R.id.textView);
        TextView left = (TextView) findViewById(R.id.textView2);
        TextView score1 = (TextView) findViewById(R.id.textView3);
        TextView score2 = (TextView) findViewById(R.id.textView4);
        next.setText("Next up: " + sam2);
        left.setText("Rounds Left: " + sam);
        score1.setText("Team 1: " + sam3);
        score2.setText("Team 2: " + sam4);







    }

    /*public void RoundScreen(View view) {
        Intent send = new Intent(this, InGameActivity.class);
        send.putExtra("T1_SCORE", T1_SCORE);
        send.putExtra("T2_SCORE",T2_SCORE);
        send.putExtra("ROUNDS_LEFT", ROUNDS_LEFT);
        send.putExtra("NEXT_UP",NEXT_UP);
        startActivity(send);








    }
*/

}
