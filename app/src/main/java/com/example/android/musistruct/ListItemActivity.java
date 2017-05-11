package com.example.android.musistruct;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ListItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_item);

        //Get the details of the track from the previous activity
        Bundle b = getIntent().getExtras();
        if (b != null) {
            int albumImage = b.getInt("albumImage");
            String albumTitle = b.getString("albumTitle");
            String trackTitle = b.getString("trackTitle");
            String albumPerformer = b.getString("albumPerformer");
            int albumYear = b.getInt("albumYear");
            int trackPrice = b.getInt("trackPrice");

            //Set the title of the track
            this.setTitle(trackTitle);


            //Display the explanation of the activity
            TextView listItemTextView = (TextView) findViewById(R.id.explain_list_item);
            listItemTextView.setText(getString(R.string.explain_list_item));

            //Display the album image
            ImageView albumImageView = (ImageView) findViewById(R.id.album_image);
            albumImageView.setImageResource(albumImage);

            //Display the track title
            TextView trackTitleTextView = (TextView) findViewById(R.id.track_title);
            trackTitleTextView.setText(trackTitle);

            //Display the album title
            TextView albumTitleTextView = (TextView) findViewById(R.id.album_title);
            albumTitleTextView.setText(getString(R.string.album) + albumTitle);

            //Display the album performer
            TextView albumPerformerTextView = (TextView) findViewById(R.id.album_performer);
            albumPerformerTextView.setText(getString(R.string.by) + albumPerformer);

            //Display the release year of the album
            TextView albumYearTextView = (TextView) findViewById(R.id.album_year);
            albumYearTextView.setText(getString(R.string.from) + albumYear);

            //Get the price textView and the buy button
            TextView trackPriceTextView = (TextView) findViewById(R.id.track_price);
            Button buyButton = (Button) findViewById(R.id.buy_button);

            //If price is not 0, so if it is not bought yet, display the price and the buy button
            if (trackPrice != 0) {
                //Display the track price and the set the text of the button to "Buy this track now"
                trackPriceTextView.setText(getString(R.string.dollars) + trackPrice);
                buyButton.setText(getString(R.string.buyTrack));

                //Create a new Intent for buying a track
                final Intent buyIntent = new Intent(ListItemActivity.this, BuyActivity.class);

                //Put the details of the Track Object into the intent
                buyIntent.putExtra("albumImage", albumImage);
                buyIntent.putExtra("albumTitle", albumTitle);
                buyIntent.putExtra("trackTitle", trackTitle);
                buyIntent.putExtra("albumPerformer", albumPerformer);
                buyIntent.putExtra("albumYear", albumYear);
                buyIntent.putExtra("trackPrice", trackPrice);

                // Set a click listener on listItemView
                buyButton.setOnClickListener(new View.OnClickListener() {

                    // The code in this method will be executed when the "Buy this track now" button is clicked on.
                    @Override
                    public void onClick(View view) {
                        startActivity(buyIntent);
                    }
                });
            }

            //If price is 0, so if it is already bought, hide the price but change the text of the button to "Play this track"
            else {
                //Hide the track price and the set the text of the button to "Play this track"
                trackPriceTextView.setVisibility(View.GONE);
                buyButton.setText(getString(R.string.playTrack));

                //Create a new Intent for playing a track
                final Intent playIntent = new Intent(ListItemActivity.this, PlayActivity.class);

                //Put the details of the Track Object into the intent
                playIntent.putExtra("albumImage", albumImage);
                playIntent.putExtra("albumTitle", albumTitle);
                playIntent.putExtra("trackTitle", trackTitle);
                playIntent.putExtra("albumPerformer", albumPerformer);
                playIntent.putExtra("albumYear", albumYear);

                // Set a click listener on "Play this track" button
                buyButton.setOnClickListener(new View.OnClickListener() {

                    // The code in this method will be executed when the "Play this track" button is clicked on.
                    @Override
                    public void onClick(View view) {
                        startActivity(playIntent);
                    }
                });
            }
        }
    }

}
