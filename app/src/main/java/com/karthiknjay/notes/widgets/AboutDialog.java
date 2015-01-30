package com.karthiknjay.notes.widgets;

import android.app.DialogFragment;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import com.karthiknjay.notes.R;

/**
 * Created by karthik on 30/1/15.
 */
public class AboutDialog extends DialogFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.dialog_about, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        try {
            String versionName = getActivity().getPackageManager().getPackageInfo(getActivity().getPackageName(), 0).versionName;
            Log.i("Notes", "versionName:"+versionName);
            //versionText.setText(getString(R.string.version_format, versionName));
        } catch (PackageManager.NameNotFoundException ex) {
            //Log.e(TAG, "Couldn't find version name", ex);
        }
    }
}
