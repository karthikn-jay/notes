package com.karthiknjay.notes.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.karthiknjay.notes.R;
import com.karthiknjay.notes.fragment.SettingsFragment;
import com.karthiknjay.notes.model.Note;
import com.karthiknjay.notes.model.NoteAdapter;
import com.karthiknjay.notes.widgets.AboutDialog;
import com.shamanland.fab.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    RecyclerView listView;

    TextView noNotesTxt;

    FloatingActionButton addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (RecyclerView) findViewById(R.id.listMain);
        listView.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listView.setLayoutManager(llm);

        noNotesTxt = (TextView) findViewById(R.id.no_notes);

        String[] items = {"Milk", "Butter", "Yogurt", "Cheese", "Ice Cream"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);

        Note[] items2 = {
            new Note(1, "Milk", "milk content"),
            new Note(2, "Butter", "butter content"),
            new Note(3, "Yogurt", "yogurt content"),
            new Note(4, "Cheese", "cheese content"),
            new Note(5, "Ice cream", "icecream content")
        };
        ArrayAdapter<Note> adapter2 = new ArrayAdapter<Note>(this, android.R.layout.simple_list_item_1, items2);

        //listView.setAdapter(adapter);
        //listView.setAdapter(adapter2);

        NoteAdapter noteAdapter = new NoteAdapter(createList(20));
        listView.setAdapter(noteAdapter);

        //if( !listView.getAdapter().isEmpty() ) {
          //  noNotesTxt.setVisibility(View.GONE);
        //}
        if(noteAdapter.getItemCount() == 0) {
            noNotesTxt.setVisibility(View.VISIBLE);
        } else {
            noNotesTxt.setVisibility(View.GONE);
        }

        addButton = (FloatingActionButton) findViewById(R.id.add_button);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openEditActivity();
            }
        });
    }

    private List<Note> createList(int size) {

        List<Note> result = new ArrayList<Note>();
        for (int i=1; i <= size; i++) {
            Note ci = new Note(i, "title" + i, "content" + i);
            result.add(ci);
        }

        return result;
    }

    private void openEditActivity() {
        Intent intent = new Intent(this, EditActivity.class);
        startActivity(intent);
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
