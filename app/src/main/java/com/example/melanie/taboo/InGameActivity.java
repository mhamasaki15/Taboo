package com.example.melanie.taboo;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.os.CountDownTimer;
import android.widget.Chronometer;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Random;

public class InGameActivity extends Activity {

    private String[] words, taboo1, taboo2, taboo3, taboo4, taboo5;
    private ArrayList<Integer> validIndices;
    private int index;
    private ArrayList<String> passList;
    private TextView mwText, t1Text, t2Text, t3Text, t4Text, t5Text,timer;

    private double startTime, endTime;
    private double sw_time, lw_time;
    private String sw_word, lw_word, name1, name2;
    private int hsr_score, hsr_team, hsr_round, time, pass_count1, pass_count2, correct_count1, correct_count2;

    private Resources res;
    private int roundsLeft, teamNum, score1, score2, randNum;

    private static final Random rgenerator = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_in_game);
        timer = (TextView) findViewById(R.id.textView6);

        Intent intent = getIntent();
        passList = intent.getStringArrayListExtra(TitleScreenActivity.PASS_LIST);
        validIndices = intent.getIntegerArrayListExtra(TitleScreenActivity.INDICES);
        sw_time = intent.getDoubleExtra(TitleScreenActivity.SW_TIME, 1.0);
        lw_time = intent.getDoubleExtra(TitleScreenActivity.LW_TIME, 1.0);
        sw_word = intent.getStringExtra(TitleScreenActivity.SW_WORD);
        lw_word = intent.getStringExtra(TitleScreenActivity.LW_WORD);
        hsr_score = intent.getIntExtra(TitleScreenActivity.HSR_SCORE, 1);
        hsr_round = intent.getIntExtra(TitleScreenActivity.HSR_ROUND, 1);
        hsr_team = intent.getIntExtra(TitleScreenActivity.HSR_TEAM, 1);
        roundsLeft = intent.getIntExtra(TitleScreenActivity.ROUNDS_LEFT, 21);
        teamNum = intent.getIntExtra(TitleScreenActivity.NEXT_UP, 22);
        score1 = intent.getIntExtra(TitleScreenActivity.T1_SCORE, 23);
        score2 = intent.getIntExtra(TitleScreenActivity.T2_SCORE, 24);
        time = intent.getIntExtra(TitleScreenActivity.TIME, 60);
        correct_count1 = intent.getIntExtra(TitleScreenActivity.CORRECT_COUNT1, 0);
        correct_count2 = intent.getIntExtra(TitleScreenActivity.CORRECT_COUNT2, 0);
        pass_count1 = intent.getIntExtra(TitleScreenActivity.PASS_COUNT1, 0);
        pass_count2 = intent.getIntExtra(TitleScreenActivity.PASS_COUNT2, 0);
        name1 = intent.getStringExtra(TitleScreenActivity.NAME1);
        name2 = intent.getStringExtra(TitleScreenActivity.NAME2);

        res = getResources();
        words = res.getStringArray(R.array.mainWord);
        taboo1 = res.getStringArray(R.array.Taboo1);
        taboo2 = res.getStringArray(R.array.Taboo2);
        taboo3 = res.getStringArray(R.array.Taboo3);
        taboo4 = res.getStringArray(R.array.Taboo4);
        taboo5 = res.getStringArray(R.array.Taboo5);

        randNum = rgenerator.nextInt(validIndices.size());
        index = validIndices.get(randNum);
        validIndices.remove(randNum);

        mwText = (TextView)findViewById(R.id.main_word);
        t1Text = (TextView)findViewById(R.id.tabooText1);
        t2Text = (TextView)findViewById(R.id.tabooText2);
        t3Text = (TextView)findViewById(R.id.tabooText3);
        t4Text = (TextView)findViewById(R.id.tabooText4);
        t5Text = (TextView)findViewById(R.id.tabooText5);

        mwText.setText(words[index]); //
        t1Text.setText(taboo1[index]);
        t2Text.setText(taboo2[index]);
        t3Text.setText(taboo3[index]);
        t4Text.setText(taboo4[index]);
        t5Text.setText(taboo5[index]);

        startTime = (System.currentTimeMillis() / 1000.0);

        new CountDownTimer((time*1000 + 2500), 1000)
        {
            public void onTick(long millisUntilFinished)
            {
                timer.setText(""+ (millisUntilFinished / 1000 - 1));
            }
            public void onFinish()
            {
                roundOver(null);
            }
        }.start();

    }

    public void roundOver(View view){
        if (score1>hsr_score) {
            hsr_score = score1;
            hsr_team = 1;
            hsr_round = roundsLeft; //passes rounds left, but need to subtract value by 5

        }
        if (score2>hsr_score){
            hsr_score = score1;
            hsr_team = 1;
            hsr_round = roundsLeft;
        }
        if (roundsLeft == 1) {
            Intent doneData = new Intent(this, WinnerScreenActivity.class);
            doneData.putExtra(TitleScreenActivity.T1_SCORE, score1);
            doneData.putExtra(TitleScreenActivity.T2_SCORE, score2);
            doneData.putExtra(TitleScreenActivity.SW_WORD,sw_word );
            doneData.putExtra(TitleScreenActivity.LW_WORD, lw_word);
            doneData.putExtra(TitleScreenActivity.HSR_TEAM, hsr_team);
            doneData.putExtra(TitleScreenActivity.SW_TIME,sw_time);
            doneData.putExtra(TitleScreenActivity.LW_TIME, lw_time);
            doneData.putExtra(TitleScreenActivity.HSR_SCORE, hsr_score);
            doneData.putExtra(TitleScreenActivity.HSR_ROUND, hsr_round);
            doneData.putExtra(TitleScreenActivity.CORRECT_COUNT1, correct_count1);
            doneData.putExtra(TitleScreenActivity.CORRECT_COUNT2, correct_count2);
            doneData.putExtra(TitleScreenActivity.PASS_COUNT1, pass_count1);
            doneData.putExtra(TitleScreenActivity.PASS_COUNT2, pass_count2);
            doneData.putExtra(TitleScreenActivity.NAME1, name1);
            doneData.putExtra(TitleScreenActivity.NAME2, name2);
            doneData.putStringArrayListExtra(TitleScreenActivity.PASS_LIST, passList);

            startActivity(doneData);
        }
        else {
            Intent sendData = new Intent(this, StartRoundScreen.class);
            sendData.putExtra(TitleScreenActivity.ROUNDS_LEFT, roundsLeft - 1);
            if (teamNum == 2) teamNum = 1;
            else teamNum = 2;
            sendData.putExtra(TitleScreenActivity.TIME, time);
            sendData.putExtra(TitleScreenActivity.NEXT_UP, teamNum);
            sendData.putExtra(TitleScreenActivity.T1_SCORE, score1);
            sendData.putExtra(TitleScreenActivity.T2_SCORE, score2);
            sendData.putExtra(TitleScreenActivity.SW_WORD,sw_word);
            sendData.putExtra(TitleScreenActivity.LW_WORD,lw_word);
            sendData.putExtra(TitleScreenActivity.SW_TIME,sw_time);
            sendData.putExtra(TitleScreenActivity.LW_TIME,lw_time);
            sendData.putExtra(TitleScreenActivity.HSR_SCORE, hsr_score);
            sendData.putExtra(TitleScreenActivity.HSR_ROUND, hsr_round);
            sendData.putExtra(TitleScreenActivity.HSR_TEAM, hsr_team);
            sendData.putExtra(TitleScreenActivity.NAME1, name1);
            sendData.putExtra(TitleScreenActivity.NAME2, name2);
            sendData.putIntegerArrayListExtra(TitleScreenActivity.INDICES, validIndices);
            sendData.putStringArrayListExtra(TitleScreenActivity.PASS_LIST, passList);


            startActivity(sendData);
        }
    }

    public void passWord(View view){
        passList.add(words[index]);
        randNum = rgenerator.nextInt(validIndices.size());
        index = validIndices.get(randNum);
        validIndices.remove(randNum);
        mwText.setText(words[index]);
        t1Text.setText(taboo1[index]);
        t2Text.setText(taboo2[index]);
        t3Text.setText(taboo3[index]);
        t4Text.setText(taboo4[index]);
        t5Text.setText(taboo5[index]);
        if (teamNum ==  1){
            pass_count1++;
            score1--;
        }
        else{
            pass_count2++;
            score2--;
        }
        startTime = System.currentTimeMillis()/1000.0;
    }

    public void correctWord(View view) {
        if (teamNum == 2){
            correct_count2++;
            score2+=2;
        }
        else{
            correct_count1++;
            score1+=2;
        }
        endTime = System.currentTimeMillis() / 1000.0;
        double temp = endTime - startTime;
        if (temp < sw_time) {
            sw_time = temp;
            sw_word = words[index];
        } else if (temp > lw_time) {
            lw_time = temp;
            lw_word = words[index];
        }
        startTime = endTime;
        randNum = rgenerator.nextInt(validIndices.size());
        index = validIndices.get(randNum);
        validIndices.remove(randNum);
        mwText.setText(words[index]);
        t1Text.setText(taboo1[index]);
        t2Text.setText(taboo2[index]);
        t3Text.setText(taboo3[index]);
        t4Text.setText(taboo4[index]);
        t5Text.setText(taboo5[index]);
    }
}
