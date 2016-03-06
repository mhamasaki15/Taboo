package com.example.melanie.taboo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

import java.util.ArrayList;

public class ExpansionPacks extends Activity {

    private int rounds, nextTeam, team1score, team2score, hsr_score, hsr_team, hsr_round, time;
    private  double sw_time, lw_time;
    private int pass_count1, pass_count2, correct_count1, correct_count2;
    private String sw_word, lw_word, name1, name2;
    private ArrayList<Integer> validIndices;
    private ArrayList<String> passList;
    private boolean usc, pop, pres;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expansion_packs);
        Intent intent = getIntent();

        sw_word = intent.getStringExtra(TitleScreenActivity.SW_WORD);
        lw_word = intent.getStringExtra(TitleScreenActivity.LW_WORD);
        name1 = intent.getStringExtra(TitleScreenActivity.NAME1);
        name2 = intent.getStringExtra(TitleScreenActivity.NAME2);
    }

    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        switch(view.getId()) {
            case R.id.uscBox:
                if (checked) usc = true;
                else usc = false;
                break;
            case R.id.popBox:
                if (checked) pop = true;
                else pop = false;
                break;
            case R.id.presBox:
                if (checked) pres = true;
                else
                    pres = false;
                break;
        }
    }

    public void sendToStart(View view){
        Intent ret = new Intent(this, StartRoundScreen.class);
        ret.putExtra(TitleScreenActivity.ROUNDS_LEFT, rounds);
        ret.putExtra(TitleScreenActivity.TIME, time);
        ret.putExtra(TitleScreenActivity.NAME1, name1);
        ret.putExtra(TitleScreenActivity.NAME2, name2);
        ret.putExtra(TitleScreenActivity.SW_WORD, "");
        ret.putExtra(TitleScreenActivity.LW_WORD, "");

        passList = new ArrayList<String>();
        validIndices = new ArrayList<Integer>();

        for (int i=0; i<29; i++){
            validIndices.add(i);
        }
        if (usc){
            for (int i=29; i<53; i++){
                validIndices.add(i);
            }
        }
        if (pop){
            for (int i=53; i<63; i++){
                validIndices.add(i);
            }
        }
        if (pres){
            for (int i=63; i<71; i++){
                validIndices.add(i);
            }
        }

        ret.putStringArrayListExtra(TitleScreenActivity.PASS_LIST, passList);
        ret.putIntegerArrayListExtra(TitleScreenActivity.INDICES, validIndices);


    }
}
