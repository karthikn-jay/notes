package com.karthiknjay.notes.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.Window;
import android.widget.Toast;

import com.karthiknjay.notes.R;
import com.karthiknjay.notes.fragment.SettingsFragment;
import com.karthiknjay.notes.widgets.AboutDialog;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_main, menu);
        //return true;
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        switch (id) {
            case R.id.action_search:
                openSearch();
                return true;
            case R.id.action_settings:
                // Display the fragment as the main content.
                //requestWindowFeature(Window.FEATURE_NO_TITLE);

                Intent settingsIntent = new Intent();
                settingsIntent.setClass(MainActivity.this, SettingsActivity.class);

                startActivityForResult(settingsIntent, 0);
                return true;
            case R.id.action_about:
                new AboutDialog().show(getFragmentManager(), "dialog_notice");
                return true;
            default: return super.onOptionsItemSelected(item);
        }
    }

    private void openSearch() {
        Context context = getApplicationContext();
        CharSequence text = "Under contruction...";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        loadPref();
    }

    private void loadPref() {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);

        boolean chkDeleteOldMsg = sp.getBoolean("pref_sync", false);
        Log.i("Notes", "chkDeleteOldMsg: "+chkDeleteOldMsg);
    }
}
