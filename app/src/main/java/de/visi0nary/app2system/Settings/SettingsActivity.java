package de.visi0nary.app2system.Settings;

import android.app.Activity;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import de.visi0nary.app2system.R;


public class SettingsActivity extends Activity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
    }
    //no need to implement logic here as this activity is just a wrapper for the advancedsettingsfragment
}