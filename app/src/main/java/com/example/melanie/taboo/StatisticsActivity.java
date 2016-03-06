package com.example.melanie.taboo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class StatisticsActivity extends Activity implements AdapterView.OnItemSelectedListener {
    private int score1;
    private int score2;

    private double sw_time, lw_time;
    private String sw_word, lw_word;
    private int sw_team, lw_team, hsr_score, hsr_team, hsr_round;

    private ArrayAdapter myArrayAdapter;
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
        score1 = intent.getIntExtra(TitleScreenActivity.T1_SCORE, 23);
        score2 = intent.getIntExtra(TitleScreenActivity.T2_SCORE, 24);
        sw_time = intent.getDoubleExtra(TitleScreenActivity.SW_TIME, 1.0);
        lw_time = intent.getDoubleExtra(TitleScreenActivity.LW_TIME, 1.0);
        sw_word = intent.getStringExtra(TitleScreenActivity.SW_WORD);
        lw_word = intent.getStringExtra(TitleScreenActivity.LW_WORD);
        sw_team = intent.getIntExtra(TitleScreenActivity.SW_TEAM, 1);
        lw_team = intent.getIntExtra(TitleScreenActivity.LW_TEAM, 1);
        hsr_score = intent.getIntExtra(TitleScreenActivity.HSR_SCORE, 1);
        hsr_round = intent.getIntExtra(TitleScreenActivity.HSR_ROUND, 1);
        hsr_team = intent.getIntExtra(TitleScreenActivity.HSR_TEAM, 1);
        Bundle b = intent.getBundleExtra(TitleScreenActivity.PASS_ARRAY);
        
        myArrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, passArray);
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.stats_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

    }

    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        if (pos == 0){
            text1.setText("The fastest guessed word was...");
            text2.setText(sw_word + "\n");
            text3.setText("Team " + "teamPlaceholder" + " guessed it in\n");
            text4.setText(String.valueOf(sw_time) + " seconds");
        }
        else if (pos == 1){
            text1.setText("The slowest guessed word was...");
            text2.setText(lw_word + "\n");
            text3.setText("Team " + "teamPlaceHolder" + " guessed it in\n");
            text4.setText(String.valueOf(lw_time) + "seconds");
        }
        else if (pos == 2){
            text1.setText("Team " + "teamPlaceHolder\n");
            text2.setText("had the highest scoring round with\n");
            text3.setText("");
            text4.setText("" + hsr_score + " points");
        }
        else if (pos == 3){
            //passed words
        }
        else if (pos == 4){
            text1.setText("Team " + "teamPlaceHolder:\n");
            text2.setText("percentage placeholder" + "%\n");
            text3.setText("Team " + "teamPlaceHolder:");
            text4.setText("percentage placeholder" + "%\n");

        }
        // An item was selected. You can retrieve the selected item using
        // parent.getItemAtPosition(pos)

        //head to head graph
    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }
}
