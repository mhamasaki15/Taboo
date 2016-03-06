package com.example.melanie.taboo;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class SettingsActivity extends Activity implements AdapterView.OnItemSelectedListener {
    private int rounds, time;
    private String team1;
    private String team2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        //Intent setting = getIntent();
        Spinner spinner = (Spinner) findViewById(R.id.RoundSelect);
        Spinner spinner2 = (Spinner) findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.time_array, R.layout.spinner_item);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.rounds_array, R.layout.spinner_item);
        adapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        adapter2.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner2.setAdapter(adapter2);
        spinner.setOnItemSelectedListener(this);
        spinner2.setOnItemSelectedListener(this);
        EditText name1 = (EditText) findViewById(R.id.Team1Name);
        EditText name2 = (EditText) findViewById(R.id.Team2Name);
        name1.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                int id = actionId;
                team1 = v.getText().toString();
                return false;
            }
        });
        name2.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                team2 = v.getText().toString();
                return false;
            }
        });
    }

    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id)
    {
        switch (parent.getId()) {
            case R.id.spinner2:
                if (pos == 0) time = 30;
                else if (pos == 1) time = 60;
                else if (pos == 2) time = 90;
                else if (pos == 3) time = 120;
                break;
            case R.id.RoundSelect:
                if (pos == 0) rounds = 2;
                else if (pos == 1) rounds = 4;
                else if (pos == 2) rounds = 6;
                else if (pos == 3) rounds = 8;
                else if (pos == 4) rounds = 10;
                break;
        }
    }
    public void onNothingSelected(AdapterView<?> parent)
    {
    }

    public void sendToReturn(View view)
    {
        int team2Score = 0;
        double short_time = 61.0;
        double long_time = 0.0;
       // int sw_team = 1;
     //   int long_team = 1;
        int hsr_team = 0;
        String long_word = "";
        String short_word = "";
        int high_round = 0;
        int high_score = 0;
        int team1Score = 0;
        Intent ret = new Intent(this, StartRoundScreen.class);
        ret.putExtra(TitleScreenActivity.ROUNDS_LEFT, rounds);
        ret.putExtra(TitleScreenActivity.TIME, time);
        ret.putExtra(TitleScreenActivity.NAME1, team1);
        ret.putExtra(TitleScreenActivity.NAME2, team2);
        ret.putExtra(TitleScreenActivity.T2_SCORE, team2Score);
        ret.putExtra(TitleScreenActivity.SW_TIME,short_time);
        ret.putExtra(TitleScreenActivity.SW_WORD,short_word );
        ret.putExtra(TitleScreenActivity.LW_TIME,long_time);
        ret.putExtra(TitleScreenActivity.LW_WORD,long_word);
        ret.putExtra(TitleScreenActivity.HSR_TEAM,hsr_team);
        ret.putExtra(TitleScreenActivity.HSR_ROUND,high_round);
        ret.putExtra(TitleScreenActivity.HSR_SCORE,high_score);
        ret.putExtra(TitleScreenActivity.T1_SCORE, team1Score);

        startActivity(ret);
    }

}
