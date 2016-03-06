package com.example.melanie.taboo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class StatisticsActivity extends Activity implements AdapterView.OnItemSelectedListener {
    private double sw_time, lw_time;
    private String sw_word, lw_word, name1, name2;
    private int sw_team, lw_team, hsr_score, hsr_team, hsr_round, pass_count1, correct_count1, pass_count2, correct_count2;

    private ArrayList<String> passList;
    private ArrayAdapter<String> myArrayAdapter;
    private ListView myListView;
    private TextView text1, text2, text3, text4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);

        text1 = (TextView)findViewById(R.id.part1);
        text2 = (TextView)findViewById(R.id.part2);
        text3 = (TextView)findViewById(R.id.part3);
        text4 = (TextView)findViewById(R.id.part4);
        Intent intent = getIntent();
        passList = intent.getStringArrayListExtra(TitleScreenActivity.PASS_LIST);
        sw_time = intent.getDoubleExtra(TitleScreenActivity.SW_TIME, 1.0);
        lw_time = intent.getDoubleExtra(TitleScreenActivity.LW_TIME, 1.0);
        sw_word = intent.getStringExtra(TitleScreenActivity.SW_WORD);
        lw_word = intent.getStringExtra(TitleScreenActivity.LW_WORD);
        hsr_score = intent.getIntExtra(TitleScreenActivity.HSR_SCORE, 1);
        hsr_round = intent.getIntExtra(TitleScreenActivity.HSR_ROUND, 1);
        hsr_team = intent.getIntExtra(TitleScreenActivity.HSR_TEAM, 1);
        pass_count1 = intent.getIntExtra(TitleScreenActivity.PASS_COUNT1, 0);
        correct_count1 = intent.getIntExtra(TitleScreenActivity.CORRECT_COUNT1, 0);
        pass_count2 = intent.getIntExtra(TitleScreenActivity.PASS_COUNT2, 0);
        correct_count2 = intent.getIntExtra(TitleScreenActivity.CORRECT_COUNT2, 0);
        name1= intent.getStringExtra(TitleScreenActivity.NAME1);
        name2 = intent.getStringExtra(TitleScreenActivity.NAME2);

        myListView = (ListView)findViewById(R.id.passedList);
        //String[] passArray = {"nice", "memes", "bro", "yeah"};
        myArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, passList);
        myListView.setAdapter(myArrayAdapter);
        myListView.setVisibility(View.INVISIBLE);
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.stats_array, R.layout.spinner_state_item);
        adapter.setDropDownViewResource(R.layout.spinner_stat_dropdown);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

    }

    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        myListView.setVisibility(View.INVISIBLE);
        if (pos == 0){
            text1.setText("The FASTEST guessed word was...");
            text2.setText(sw_word + "\n");

            text3.setText("It was guessed in\n");
            text4.setText(String.format("%.2f", sw_time) + " seconds");

        }
        else if (pos == 1){
            text1.setText("The SLOWEST guessed word was...");
            text2.setText(lw_word + "\n");

            text3.setText("It was guessed in\n");
            text4.setText(String.format("%.2f", lw_time) + " seconds");
        }
        else if (pos == 2){
            String tempName;
            if (hsr_team == 1) tempName = name1;
            else tempName = name2;
            text1.setText("TEAM" + "\n");
            text2.setText(tempName);
            text3.setText("had the HIGHEST SCORING round with\n");
            text4.setText("" + hsr_score + " POINTS");
        }
        else if (pos == 3){
            text1.setText("");
            text2.setText("");
            text3.setText("");
            text4.setText("");
            myListView.setVisibility(View.VISIBLE);
        }
        else if (pos == 4){
            double t1P = 100.0*(double)correct_count1/(pass_count1+correct_count1);
            text1.setText("Team " + ":");
            text2.setText(String.format("%.2f", t1P) + "%\n");
            double t2P = 100.0*(double)correct_count2/(pass_count2+correct_count2);
            text3.setText("Team " + "teamPlaceHolder:");
            text4.setText(String.format("%.2f", t2P) + "%\n");

        }
    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }
}
