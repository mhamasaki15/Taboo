package com.example.melanie.taboo;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class InGameActivity extends Activity {

    private String[] words, taboo1, taboo2, taboo3, taboo4, taboo5;
    private TextView mwText, t1Text, t2Text, t3Text, t4Text, t5Text;

    private Resources res;
    private int roundsLeft, teamNum, score1, score2;

    private static final Random rgenerator = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_in_game);
        getActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        roundsLeft = intent.getIntExtra(TitleScreenActivity.ROUNDS_LEFT, 21);
        teamNum = intent.getIntExtra(TitleScreenActivity.NEXT_UP, 22);
        score1 = intent.getIntExtra(TitleScreenActivity.T1_SCORE, 23);
        score2 = intent.getIntExtra(TitleScreenActivity.T2_SCORE, 24);


        res = getResources();
        words = res.getStringArray(R.array.mainWord);
        taboo1 = res.getStringArray(R.array.Taboo1);
        taboo2 = res.getStringArray(R.array.Taboo2);
        taboo3 = res.getStringArray(R.array.Taboo3);
        taboo4 = res.getStringArray(R.array.Taboo4);
        taboo5 = res.getStringArray(R.array.Taboo5);

        int randNum = rgenerator.nextInt(words.length);

        mwText = (TextView)findViewById(R.id.main_word);
        t1Text = (TextView)findViewById(R.id.tabooText1);
        t2Text = (TextView)findViewById(R.id.tabooText2);
        t3Text = (TextView)findViewById(R.id.tabooText3);
        t4Text = (TextView)findViewById(R.id.tabooText4);
        t5Text = (TextView)findViewById(R.id.tabooText5);

        mwText.setText(words[randNum]);
        t1Text.setText(taboo1[randNum]);
        t2Text.setText(taboo2[randNum]);
        t3Text.setText(taboo3[randNum]);
        t4Text.setText(taboo4[randNum]);
        t5Text.setText(taboo5[randNum]);
    }

    public void roundOver(View view){
        Intent sendData = new Intent(this, StartRoundScreen.class);
        sendData.putExtra(TitleScreenActivity.ROUNDS_LEFT, roundsLeft-1);
        if (teamNum == 2) teamNum = 1;
        else teamNum = 2;
        sendData.putExtra(TitleScreenActivity.NEXT_UP, teamNum);
        sendData.putExtra(TitleScreenActivity.T1_SCORE, score1);
        sendData.putExtra(TitleScreenActivity.T2_SCORE, score2);
        startActivity(sendData);


    }

}
