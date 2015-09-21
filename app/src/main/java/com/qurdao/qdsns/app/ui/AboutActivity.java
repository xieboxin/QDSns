package com.qurdao.qdsns.app.ui;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.MenuItem;

import com.qurdao.qdsns.Constant;
import com.qurdao.qdsns.R;
import com.qurdao.qdsns.utils.Utils;


public class AboutActivity extends ActionBarActivity {

    private final static String TAG = Constant.PAKAGE_TAG + "AboutActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        Utils.setCloseActionTitle(this, R.string.title_about);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        Log.d(TAG, "onOptionsItemSelected " + id);

        //noinspection SimplifiableIfStatement
        finish();
        return super.onOptionsItemSelected(item);
    }
}
