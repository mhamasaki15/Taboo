package com.example.melanie.taboo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class TitleScreenActivity extends AppCompatActivity {
    public static final String NEXT_UP = "0";
    public static final String T1_SCORE = "1";
    public static final String T2_SCORE = "2";
    public static final String ROUNDS_LEFT= "6";
    public static final String SW_WORD = "3";
    public static final String SW_TIME = "10";
    public static final String LW_WORD = "11";
    public static final String LW_TIME = "13";
    public static final String HSR_SCORE = "14";
    public static final String HSR_TEAM = "15";
    public static final String HSR_ROUND = "16";
    public static final String NAME1 = "17";
    public static final String NAME2 = "18";
    public static final String TIME = "60";
    public static final String PASS_COUNT1 = "34";
    public static final String CORRECT_COUNT1 = "35";
    public static final String PASS_COUNT2 = "36";
    public static final String CORRECT_COUNT2 = "37";
    public static final String INDICES = "41";
    public static final String PASS_LIST = "42";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title_screen);
        getIntent();
    }

    public void sendtoAbout(View view){
        Intent intent = new Intent(this, AboutPageActivity.class);
        startActivity(intent);
    }

    public void sendtoRules(View view){
        Intent intent = new Intent(this, RulesPageActivity.class);
        startActivity(intent);
    }

    public void sendtoSettingsActivity(View view){
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }
}
