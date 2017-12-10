package com.example.googlemap;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;

/*****************************************************************************
 * Following Udacity course ud876-4
 */
public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {
    /*************************************************************************
     * declare
     */
    private static final String LOG_TAG = "***" + MainActivity.class.getSimpleName();
    GoogleMap m_map;
    boolean mapReady = false;

    /*************************************************************************
     * onCreate
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(LOG_TAG, "onCreate()");
        setContentView(R.layout.activity_main);

        Button btnMap = findViewById(R.id.btnMap);
        btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(LOG_TAG, "onClick()");
                if (mapReady)
                    m_map.setMapType((GoogleMap.MAP_TYPE_NORMAL));
            }

        });

        Button btnSatellite = findViewById(R.id.btnSatellite);
        btnSatellite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(LOG_TAG, "onClick()");
                if (mapReady)
                    m_map.setMapType((GoogleMap.MAP_TYPE_SATELLITE));
            }
        });

        Button btnHybrid = findViewById(R.id.btnHybrid);
        btnHybrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(LOG_TAG, "onClick()");
                if (mapReady)
                    m_map.setMapType((GoogleMap.MAP_TYPE_HYBRID));
            }
        });

        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /*************************************************************************
     * onMapReady
     * @param map
     */
    @Override
    public  void onMapReady(GoogleMap map) {
        Log.d(LOG_TAG, "onMapReady()");
        mapReady = true;
        m_map = map;
        LatLng newYork = new LatLng(40.7484,-73.9857);
        CameraPosition target = CameraPosition.builder().target(newYork).zoom(14).build();
        m_map.moveCamera(CameraUpdateFactory.newCameraPosition(target));
    }

    /*************************************************************************
     * onCreateOptionsMenu
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        Log.d(LOG_TAG, "onCreateOptionsMenu()");
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return  true;
    }

    /*************************************************************************
     * onOptionsItemSelected
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Log.d(LOG_TAG, "onOptionsItemSelected()");
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return  super.onOptionsItemSelected(item);
    }
}
