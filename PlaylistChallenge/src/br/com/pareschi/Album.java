package br.com.pareschi;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Album {
    //        1.   Album
//
//      -   It has three fields, two Strings called name and artist, and an ArrayList that holds objects of type Song called songs.
//
//      -   A constructor that accepts two Strings (name of the album and artist). It initialises the fields and instantiates songs.
//
//      -   And three methods, they are:
//
//            -   addSong(), has two parameters of type String (title of song), double (duration of song) and returns a boolean. Returns true if the song was added successfully or false otherwise.
//
//            -   findSong(), has one parameter of type String (title of song) and returns a Song. Returns the Song if it exists, null if it doesn't exists.
//
//            -   addToPlayList(), has two parameters of type int (track number of song in album) and LinkedList (the playlist) that holds objects of type Song,
//            and returns a boolean. Returns true if it exists and it was added successfully using the track number, or false otherwise.
//
//            -   addToPlayList(), has two parameters of type String (title of song) and LinkedList (the playlist)
//            that holds objects of type Song, and returns a boolean. Returns true if it exists and it was added
//            successfully using the name of the song, or false otherwise.
//
//
    private String name;
    private String artist;
    private List<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<>();
    }

    public boolean addSong(String title, double duration){
        if(findSong(title) != null){
            return false;
        }
        Song song = new Song(title, duration);
        songs.add(song);
        return true;
    }

    private Song findSong(String title){
        for(Song song: songs){
            if(song.getTitle().equals(title)){
                return song;
            }
        }
        return null;
    }

    public boolean addToPlayList(int trackNumber, List<Song> playlist){
        trackNumber--;
        if((trackNumber < 0) || (trackNumber >= songs.size())){
            return false;
        }
        playlist.add(songs.get(trackNumber));
        return true;
    }

    public boolean addToPlayList(String songTitle, List<Song> playlist){
        Song song = findSong(songTitle);
        if(song == null){
            return false;
        }
        return addToPlayList(songs.indexOf(song), playlist);
    }
}
