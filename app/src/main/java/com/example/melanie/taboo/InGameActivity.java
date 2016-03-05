package com.example.melanie.taboo;

import android.content.res.Resources;
import android.os.Bundle;
import android.app.Activity;
import android.widget.TextView;

import java.util.Random;

public class InGameActivity extends Activity {

    private String[] words;
    private String[] taboo1;
    private String[] taboo2;
    private String[] taboo3;
    private String[] taboo4;
    private String[] taboo5;

    private TextView mwText;
    private TextView t1Text;
    private TextView t2Text;
    private TextView t3Text;
    private TextView t4Text;
    private TextView t5Text;

    private Resources res;

    private static final Random rgenerator = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_in_game);
        getActionBar().setDisplayHomeAsUpEnabled(true);

        res = getResources();
        words = res.getStringArray(R.array.mainWord);
        taboo1 = res.getStringArray(R.array.Taboo1);
        taboo2 = res.getStringArray(R.array.Taboo2);

        int randNum = rgenerator.nextInt(words.length);

        String mw = words[randNum];

    }

}
