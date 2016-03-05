package com.example.melanie.taboo;

import android.os.Bundle;
import android.app.Activity;

public class StartRoundScreen extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_round_screen);
        getActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
