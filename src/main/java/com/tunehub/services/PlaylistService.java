package com.tunehub.services;

import java.util.List;

import com.tunehub.entity.Playlist;

public interface PlaylistService {

	

	void addPlaylist(Playlist playList);

	List<Playlist> fetchAllPlaylists();

}
