package com.example.experiment.udacitystageone;

import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import kaaes.spotify.webapi.android.SpotifyApi;
import kaaes.spotify.webapi.android.SpotifyService;
import kaaes.spotify.webapi.android.models.Artist;
import kaaes.spotify.webapi.android.models.ArtistsPager;
import kaaes.spotify.webapi.android.models.Tracks;

/**
 * Created by Bingtao on 5/30/2015.
 */
public class TopTracksForArtistTask extends AsyncTask<String, Void, Tracks> {

    public ArtistHitsActivity Parent = null;
    private SpotifyApi Spotify_API = null;
    private SpotifyService Spotify_Service = null;
    public String CountryCode = "us";

    public TopTracksForArtistTask(ArtistHitsActivity parent, String countryCode) {
        Parent = parent;
        CountryCode = countryCode;
    }

    protected Tracks doInBackground(String... searchString) {
        Spotify_API = new SpotifyApi();
        Spotify_Service = Spotify_API.getService();

        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("country", CountryCode);

        return Spotify_Service.getArtistTopTrack(searchString[0], map);
    }

    protected void onPostExecute(Tracks result) {
        Parent.setArtistTracks(result);
    }
}
