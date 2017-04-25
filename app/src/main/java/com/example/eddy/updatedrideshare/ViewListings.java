package com.example.eddy.updatedrideshare;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.vision.text.Line;

import java.util.ArrayList;

public class ViewListings extends AppCompatActivity {

    // Variables
    private ListView listingsView;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_listings);

        // Reference the view from the layout
        listingsView = (ListView) findViewById(R.id.listingsList);

        // Set up the floating action button
        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ViewListings.this, PostRide.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //Menu item selected
        switch(item.getItemId()) {
            case R.id.refresh:
                onResume();
                break;
            /*case R.id.action_end:
                stopService(playIntent);
                musicSrv = null;
                System.exit(0);
                break;*/
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // Retrieve listings every time the activity is reloaded
        String method = "getListings";
        BackgroundTask backgroundTask = new BackgroundTask(this);
        backgroundTask.execute(method);
        Toast.makeText(this, "Retrieving listings...", Toast.LENGTH_SHORT).show();
    }

    public void viewRide(View view) {
        int listingPosition = Integer.parseInt(view.getTag().toString());
        Intent intent = new Intent(ViewListings.this, ViewRide.class);
        intent.putExtra("position", listingPosition);
        startActivity(intent);
    }

    public void postRide(View view) {
        // Start the new activity for posting a ride
        Intent i = new Intent(ViewListings.this, PostRide.class);
        startActivity(i);
    }
}
