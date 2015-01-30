package com.karthiknjay.notes.activity;

import android.app.Activity;
import android.os.Bundle;

import com.karthiknjay.notes.fragment.SettingsFragment;

/**
 * Created by karthik on 31/1/15.
 */
public class SettingsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getFragmentManager().beginTransaction().replace(android.R.id.content, new SettingsFragment()).commit();
    }
}
