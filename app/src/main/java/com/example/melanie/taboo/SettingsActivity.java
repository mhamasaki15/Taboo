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
    private int rounds;
    private double time;
    private String team1;
    private String team2;
    public int score1;
    public int score2;
    private  String SW_WORD = "3";
    private  int SW_TEAM = 1;
    private  double SW_TIME = 60.0;
    private  String LW_WORD = "11";
    private  int LW_TEAM = 1;
    private  double LW_TIME = 0.0;
    private  int HSR_SCORE = 0;
    private  int HSR_TEAM = 0;
    private  int HSR_ROUND = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        Intent setting = getIntent();
        Spinner spinner = (Spinner) findViewById(R.id.RoundSelect);
        Spinner spinner2 = (Spinner) findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.rounds_array, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.time_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner2.setAdapter(adapter2);
        EditText name1 = (EditText) findViewById(R.id.Team1Name);
        EditText name2 = (EditText) findViewById(R.id.Team2Name);
        name1.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                int id = actionId;
                if(id == R.id.Team1Name)
                {
                    team1 = v.getText().toString();
                }
                else
                {
                    team2 = v.getText().toString();
                }
                return false;
            }
        });
    }

    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id)
    {
        int sammie = parent.getId();
        if (sammie == R.id.RoundSelect){
            if(pos == 0)
            {
                rounds = 2;
            }
            else if(pos == 1)
            {
                rounds = 4;
            }
            else if(pos == 2)
            {
                rounds = 6;
            }
            else if(pos == 3)
            {
                rounds = 8;
            }
            else
            {
                rounds = 10;
            }

        }
        else{
            if(pos == 0)
            {
                time = 10.0;
            }
            else if(pos == 1)
            {
                time = 20.0;
            }
            else if(pos == 2)
            {
                time = 30.0;
            }
            else if(pos == 3)
            {
                time = 40.0;
            }
            else
            {
                time = 50.0;
            }

        }

    }
    public void onNothingSelected(AdapterView<?> parent)
    {

    }


    public void sendToStartRound(View view)
    {
        Intent ret = new Intent(this, StartRoundScreen.class);
        ret.putExtra(TitleScreenActivity.ROUNDS_LEFT,rounds);
        ret.putExtra(TitleScreenActivity.LW_WORD, LW_WORD);
        ret.putExtra(TitleScreenActivity.LW_TIME, LW_TIME);
        ret.putExtra(TitleScreenActivity.LW_TEAM, LW_TEAM);
        ret.putExtra(TitleScreenActivity.HSR_ROUND,HSR_ROUND);
        ret.putExtra(TitleScreenActivity.HSR_TEAM,HSR_TEAM);
        ret.putExtra(TitleScreenActivity.HSR_SCORE,HSR_SCORE);
        ret.putExtra(TitleScreenActivity.NAME1, team1);
        ret.putExtra(TitleScreenActivity.NAME2, team2);
        ret.putExtra(TitleScreenActivity.SW_TIME, SW_TIME);
        ret.putExtra(TitleScreenActivity.SW_TEAM,SW_TEAM);
        ret.putExtra(TitleScreenActivity.SW_WORD, SW_WORD);
        ret.putExtra(TitleScreenActivity.T2_SCORE, score1);
        ret.putExtra(TitleScreenActivity.T2_SCORE, score2);
        ret.putExtra(TitleScreenActivity.Time,time);
        startActivity(ret);




    }

}
