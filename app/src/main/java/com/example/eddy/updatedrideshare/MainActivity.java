package com.example.eddy.updatedrideshare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void viewListings(View view) {
        // Start the view listings activity
        Intent intent = new Intent(MainActivity.this, ViewListings.class);
        startActivity(intent);
    }
}
