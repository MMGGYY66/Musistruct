package com.example.android.musistruct;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by MátéZoltán on 2017. 05. 07..
 */

public class TrackListAdapter extends ArrayAdapter<Track> {

    //Constructor of the TrackListAdapter
    public TrackListAdapter(Activity context, ArrayList<Track> tracks) {
        super(context, 0, tracks);
    }

    @Override

    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        // Get the {@link Track} object located at this position in the list
        Track currentTrack = getItem(position);

        //Get the details of the current Track Object

        int albumImage = currentTrack.getAlbumImage();
        String albumTitle = currentTrack.getAlbumTitle();
        String trackTitle = currentTrack.getTrackTitle();
        String albumPerformer = currentTrack.getAlbumPerformer();
        int albumYear = currentTrack.getAlbumYear();
        int trackPrice = currentTrack.getTrackPrice();

        // Find the ImageView in the list_item.xml layout with the ID album_image
        ImageView albumImageView = (ImageView) listItemView.findViewById(R.id.album_image);

        // Get the album image of the current Track object and
        // set this image on the album image TextView
        albumImageView.setImageResource(albumImage);

        // Find the TextView in the list_item.xml layout with the ID track_title
        TextView trackTitleTextView = (TextView) listItemView.findViewById(R.id.track_title);

        // Get the track title of the current Track object and
        // set this text on the track title TextView
        trackTitleTextView.setText(trackTitle);

        // Find the TextView in the list_item.xml layout with the ID album_title
        TextView albumTitleTextView = (TextView) listItemView.findViewById(R.id.album_title);

        // Get the album title of the current Track object and
        // set this text on the album title TextView

        albumTitleTextView.setText(albumTitle);

        // Find the TextView in the list_item.xml layout with the ID album_performer
        TextView albumPerformerTextView = (TextView) listItemView.findViewById(R.id.album_performer);

        // Get the album performer of the current Track object and
        // set this text on the album performer TextView

        albumPerformerTextView.setText(albumPerformer);


        //Get the context of the List Item and create an Intent for its unique activity
        final Context context = listItemView.getContext();
        final Intent listItemIntent = new Intent(context, ListItemActivity.class);

        //Put the details of the Track Object into the intent
        listItemIntent.putExtra("albumImage", albumImage);
        listItemIntent.putExtra("albumTitle", albumTitle);
        listItemIntent.putExtra("trackTitle", trackTitle);
        listItemIntent.putExtra("albumPerformer", albumPerformer);
        listItemIntent.putExtra("albumYear", albumYear);
        listItemIntent.putExtra("trackPrice", trackPrice);


        // Set a click listener on listItemView
        listItemView.setOnClickListener(new View.OnClickListener() {

            // The code in this method will be executed when the ListItemView is clicked on.
            @Override
            public void onClick(View view) {
                context.startActivity(listItemIntent);
            }
        });

        return listItemView;
    }
}
