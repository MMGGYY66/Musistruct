package com.example.android.musistruct;

/**
 * Created by MátéZoltán on 2017. 05. 07..
 */

public class Track {

    //Title of the track

    private String mTrackTitle;

    //Title of the Album

    private String mAlbumTitle;

    //Performing Artist of the Album

    private String mAlbumPerformer;

    //Year of the Album

    private int mAlbumYear;

    //Price of the Track

    private int mTrackPrice;

    //Image ID of the Album

    private int mImageId;

    /*Default constructor of the Track Object.
    * @param trackTitle title of the Track
    * @param albumTitle title of the album
    * @param albumPerformer performer of the album
    * @param albumYear year of the release of the album
    * @param albumPrice price of the album
    * @param imageID image of the album
     */

    public Track(String trackTitle, String albumTitle, String albumPerformer, int albumYear, int trackPrice, int imageID) {
        mTrackTitle = trackTitle;
        mAlbumTitle = albumTitle;
        mAlbumPerformer = albumPerformer;
        mAlbumYear = albumYear;
        mTrackPrice = trackPrice;
        mImageId = imageID;
    }

    //@return title of the track
    public String getTrackTitle() {
        return mTrackTitle;
    }

    //@return title of the album
    public String getAlbumTitle() {
        return mAlbumTitle;
    }

    //@return performer of the album
    public String getAlbumPerformer() {
        return mAlbumPerformer;
    }

    //@return release year of the album
    public int getAlbumYear() {
        return mAlbumYear;
    }

    //@return price of the album
    public int getTrackPrice() {
        return mTrackPrice;
    }

    //@return image of the album
    public int getAlbumImage() {
        return mImageId;
    }
}
