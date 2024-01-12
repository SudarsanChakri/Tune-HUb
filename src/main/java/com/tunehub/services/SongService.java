package com.tunehub.services;

import java.util.List;

import com.tunehub.entity.Song;

public interface SongService {
	void addSong(Song song);

	List<Song> fetchAllSongs();

	boolean songExists(String link);
	
	void updateSong(Song song);

}
