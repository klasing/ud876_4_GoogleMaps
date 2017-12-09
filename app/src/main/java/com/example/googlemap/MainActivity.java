package com.example.googlemap;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/*****************************************************************************
 * Following Udacity course ud876-4
 */
public class MainActivity extends AppCompatActivity {
    /*************************************************************************
     * declare
     */
    private static final String LOG_TAG = "***" + MainActivity.class.getSimpleName();
    /*************************************************************************
     * onCreate
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(LOG_TAG, "onCreate()");
        setContentView(R.layout.activity_main);
    }
}
