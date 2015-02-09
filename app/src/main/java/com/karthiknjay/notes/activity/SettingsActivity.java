package com.karthiknjay.notes.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import com.karthiknjay.notes.fragment.SettingsFragment;

/**
 * Created by karthik on 31/1/15.
 */
public class SettingsActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //requestWindowFeature(Window.FEATURE_ACTION_BAR);
        super.onCreate(savedInstanceState);
        getFragmentManager().beginTransaction().replace(android.R.id.content, new SettingsFragment()).commit();

        // show title
        //getSupportActionBar().setDisplayShowTitleEnabled(true);
        // show back/up button
        //getSupportActionBar().setHomeButtonEnabled(true);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true); // appcompat with ActionBarActivity
        //getActionBar().setDisplayHomeAsUpEnabled(true); // for 11 and up
    }
}
