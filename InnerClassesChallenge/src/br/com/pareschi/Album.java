package br.com.pareschi;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
//    Description:
//
//    For this exercise you will need your Album and Song classes from Coding Exercise 46: Playlist. The Playlist class will be modified to use an inner class called SongList which will replace the ArrayList that was used to hold the list of songs for an album.
//
//    The SongList class will use an ArrayList to hold the track list for the album. To do this a member variable called songs will need to be declared and a constructor will need to be implemented to initialize the field.
//
//    In addition, the inner class will need three(3) methods:
//
//            1) add - accepts a parameter of type Song. This method returns a boolean value which will be false if the song is found to already be in the songs list. If not, the song will be added to the list and a value of true will be returned.
//
//2) findSong - accepts the title of a song as its only parameter. If the song with that title is found in the list then the song is returned from the method. If not, a value of null is returned.
//
//            3) findSong - overridden method which accepts a track number for a song. The track number is of type int. If a song is found with that track number the song is returned, otherwise null is returned.
//
//    The member variable, constructor and all methods may be marked with private access.
//
//***IMPORTANT*** - If you are using an IDE to write this code you may have your inner class marked with private access. However, for the purposes of this code evaluation please mark the class itself public static.

    private String name;
    private String artist;
    private SongList songs;

    public static class SongList{
        private ArrayList<Song> songs;

        private SongList() {
            this.songs = new ArrayList<>();
        }

        private boolean add(Song song){
            if(findSong(song.getTitle()) != null){
                return false;
            }
            this.songs.add(song);
            return true;
        }

        private Song findSong(String title){
            for(Song song: this.songs){
                if(song.getTitle().equals(title)){
                    return song;
                }
            }
            return null;
        }

        private Song findSong(int trackNumber){
            trackNumber--;
            if(trackNumber < 0 || trackNumber >= this.songs.size()){
                return null;
            }
            return this.songs.get(trackNumber);
        }
    }

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new SongList();
    }

    public boolean addSong(String title, double duration){
        Song song = new Song(title, duration);
        return songs.add(song);
    }

    public boolean addToPlayList(int trackNumber, LinkedList<Song> playlist){
        trackNumber--;
        Song song = songs.findSong(trackNumber);
        if(song == null){
            return false;
        }
        playlist.add(song);
        return true;
    }

    public boolean addToPlayList(String songTitle, LinkedList<Song> playlist){
        Song song = songs.findSong(songTitle);
        if(song == null){
            return false;
        }
        playlist.add(song);
        return true;
    }
}
