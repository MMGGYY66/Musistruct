package com.example.android.musistruct;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class BuyActivity extends AppCompatActivity {
    //Create global variables for the Intent
    String title;
    int price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_item);

        //Get the details of the track from the previous activity
        Bundle b = getIntent().getExtras();
        if (b != null) {
            int albumImage = b.getInt("albumImage");
            String albumTitle = b.getString("albumTitle");
            final String trackTitle = b.getString("trackTitle");
            String albumPerformer = b.getString("albumPerformer");
            int albumYear = b.getInt("albumYear");
            final int trackPrice = b.getInt("trackPrice");

            //Set the title of the track
            this.setTitle(getString(R.string.toBuy) + trackTitle);


            //Display the explanation of the activity
            TextView listItemTextView = (TextView) findViewById(R.id.explain_list_item);
            listItemTextView.setText(getString(R.string.explain_item_buy));

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

            //Display the price of the track
            TextView trackPriceTextView = (TextView) findViewById(R.id.track_price);
            trackPriceTextView.setText(getString(R.string.total) + trackPrice);

            //Get the LinearLayout that will contain the purchase form show it
            LinearLayout purchaseForm = (LinearLayout) findViewById(R.id.purchase_form);
            purchaseForm.setVisibility(View.VISIBLE);


            //Get the buy button and set its text to Submit
            Button buyButton = (Button) findViewById(R.id.buy_button);
            buyButton.setText(getString(R.string.submit));


            buyButton.setOnClickListener(new View.OnClickListener() {

                // The code in this method will be executed when the "Play this track" button is clicked on.
                @Override
                public void onClick(View view) {
                    //Get the content of the Edit Text fields
                    EditText nameField = (EditText) findViewById(R.id.name_field);
                    EditText emailField = (EditText) findViewById(R.id.email_field);
                    String userName = nameField.getText().toString();
                    String email = emailField.getText().toString();

                    //Create and intent
                    Intent submitIntent = new Intent(Intent.ACTION_SENDTO);
                    submitIntent.setData(Uri.parse("mailto:" + email));

                    //Use the global variables to store the value of the local variables
                    title = trackTitle;
                    price = trackPrice;

                    //Put the details of the purchase to the intent and initialize it
                    String message = "Dear " + userName + "!\nYou have purchased the " + title + " track for $" + price + ".\nThank you for your purchase!";
                    submitIntent.putExtra(Intent.EXTRA_TEXT, message);
                    String subject = "Your purchase of " + title + " at " + getString(R.string.app_name);
                    submitIntent.putExtra(Intent.EXTRA_SUBJECT, subject);

                    if (submitIntent.resolveActivity(getPackageManager()) != null) {
                        startActivity(submitIntent);
                    }
                }
            });

        }
    }
}