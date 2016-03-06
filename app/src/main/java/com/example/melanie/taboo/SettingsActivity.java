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

import java.util.ArrayList;

public class SettingsActivity extends Activity implements AdapterView.OnItemSelectedListener {
    private int rounds, time;
    private String team1;
    private String team2;
    private boolean uscSet =  true, popSet = true; //basic set always included
    private ArrayList<Integer> newList;
    private ArrayList<String> passList;
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
        EditText name1 = (EditText) findViewById(R.id.Team1Name);
        EditText name2 = (EditText) findViewById(R.id.Team2Name);
        team1 = name1.getText().toString();
        team2 = name2.getText().toString();
        Intent ret = new Intent(this, StartRoundScreen.class);
        ret.putExtra(TitleScreenActivity.ROUNDS_LEFT, rounds);
        ret.putExtra(TitleScreenActivity.TIME, time);
        ret.putExtra(TitleScreenActivity.NAME1, team1);
        ret.putExtra(TitleScreenActivity.NAME2, team2);
        ret.putExtra(TitleScreenActivity.T1_SCORE, 0);
        ret.putExtra(TitleScreenActivity.T2_SCORE, 0);
        ret.putExtra(TitleScreenActivity.SW_TIME, 121.0);
        ret.putExtra(TitleScreenActivity.SW_WORD, "");
        ret.putExtra(TitleScreenActivity.LW_TIME, 0.0);
        ret.putExtra(TitleScreenActivity.LW_WORD, "");
        ret.putExtra(TitleScreenActivity.HSR_TEAM, 0);
        ret.putExtra(TitleScreenActivity.HSR_ROUND, 0);
        ret.putExtra(TitleScreenActivity.HSR_SCORE, -1);
        passList = new ArrayList<String>();
        ret.putStringArrayListExtra(TitleScreenActivity.PASS_LIST, passList);

        newList = new ArrayList<Integer>();
        for (int i=0; i<65; i++) newList.add(i);

        ret.putIntegerArrayListExtra(TitleScreenActivity.INDICES, newList);
        startActivity(ret);
    }

}
