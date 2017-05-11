package com.example.android.musistruct;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class PlayActivity extends AppCompatActivity {

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

            //Set the title of the track
            this.setTitle(getString(R.string.nowPlaying) + trackTitle);


            //Display the explanation of the activity
            TextView listItemTextView = (TextView) findViewById(R.id.explain_list_item);
            listItemTextView.setText(getString(R.string.explain_played_item));

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
            trackPriceTextView.setVisibility(View.GONE);
            buyButton.setVisibility(View.GONE);
        }
    }
}
