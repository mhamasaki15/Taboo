package com.example.melanie.taboo;

import android.os.Bundle;
import android.app.Activity;

public class InGameActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_in_game);
        getActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
