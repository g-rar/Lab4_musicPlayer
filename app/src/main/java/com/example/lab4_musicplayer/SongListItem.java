package com.example.lab4_musicplayer;

import android.content.Context;
import android.media.MediaMetadataRetriever;
import android.net.Uri;

public class SongListItem {

    private MediaMetadataRetriever mmr = new MediaMetadataRetriever();

    private String songName;
    private String songArtist;
    private String songDuration;
    private int songID;

    public SongListItem(String name, String artist, String duration, int id){
        this.songName = name;
        this.songArtist = artist;
        this.songDuration = duration;
        this.songID = id;
    }

    public SongListItem(String name, String artist, int secs, int id){
        this.songName = name;
        this.songArtist = artist;
        this.songDuration = String.format("%02d:%02d", secs/60, secs%60);
        this.songID = id;
    }

    public SongListItem(Context context, int id){
        Uri path = Uri.parse("android.resource://"+ context.getPackageName() + "/" + id);
        mmr.setDataSource(context, path);
        songName = mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_TITLE);
        songArtist = mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_ARTIST);
        int d = (int) Long.parseLong(mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION));
        long duration = d / 1000;
        long h = duration / 3600;
        int m = (int)(duration - h * 3600) / 60;
        int s = (int)(duration - (h * 3600 + m * 60));
        songDuration = String.format("%02d:%02d", m, s);
        songID = id;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getSongArtist() {
        return songArtist;
    }

    public void setSongArtist(String songArtist) {
        this.songArtist = songArtist;
    }

    public String getSongDuration() {
        return songDuration;
    }

    public void setSongDuration(String songDuration) {
        this.songDuration = songDuration;
    }

    public int getSongID() {
        return songID;
    }

    public void setSongID(int songID) {
        this.songID = songID;
    }
}
