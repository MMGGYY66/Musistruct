package com.example.android.musistruct;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the Buttons that show the options
        Button online = (Button) findViewById(R.id.button_online);
        Button own = (Button) findViewById(R.id.button_own);

        // Set a click listener on Search Online Music Button
        online.setOnClickListener(new View.OnClickListener() {

            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                Intent onlineIntent = new Intent(MainActivity.this, OnlineSearchActivity.class);
                startActivity(onlineIntent);
            }
        });

        // Set a click listener on Search My Own Music Button
        own.setOnClickListener(new View.OnClickListener() {

            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                Intent ownIntent = new Intent(MainActivity.this, OwnSearchActivity.class);
                startActivity(ownIntent);
            }
        });
    }
}
