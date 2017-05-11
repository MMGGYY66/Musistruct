package com.example.android.musistruct;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class OnlineSearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_online_search);

        //Get the explanation and display it
        TextView explainOnline = (TextView) findViewById(R.id.explain_online_search);
        explainOnline.setText(getString(R.string.explain_online_search));

        //Create the list of tracks
        ArrayList<Track> tracks = new ArrayList<Track>();

        //Add the tracks to the list
        tracks.add(new Track(getString(R.string.rolling), getString(R.string.twentyOne), getString(R.string.adele), 2011, 10, R.drawable.adele));
        tracks.add(new Track(getString(R.string.someone), getString(R.string.twentyOne), getString(R.string.adele), 2011, 10, R.drawable.adele));
        tracks.add(new Track(getString(R.string.formation), getString(R.string.lemo), getString(R.string.beyonce), 2016, 20, R.drawable.beyonce));
        tracks.add(new Track(getString(R.string.woohoo), getString(R.string.bionic), getString(R.string.aguilera), 2010, 5, R.drawable.aguilera));
        tracks.add(new Track(getString(R.string.myself), getString(R.string.bionic), getString(R.string.aguilera), 2010, 10, R.drawable.aguilera));
        tracks.add(new Track(getString(R.string.without), getString(R.string.dance), getString(R.string.bowie), 1983, 1, R.drawable.bowie));
        tracks.add(new Track(getString(R.string.tarantula), getString(R.string.zeitgeist), getString(R.string.pumpkins), 2007, 2, R.drawable.zeitgeist));
        tracks.add(new Track(getString(R.string.doom), getString(R.string.zeitgeist), getString(R.string.pumpkins), 2007, 2, R.drawable.zeitgeist));

        //Display the list by using a TrackListAdapter
        TrackListAdapter itemsAdapter = new TrackListAdapter(this, tracks);

        ListView listView = (ListView) findViewById(R.id.onlineListView);

        listView.setAdapter(itemsAdapter);
    }
}
