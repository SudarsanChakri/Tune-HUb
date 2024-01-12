package com.tunehub.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tunehub.entity.Playlist;
import com.tunehub.repository.PlaylistRepository;
@Service
public class PlaylistServiceImplementation implements PlaylistService
{
	@Autowired
	PlaylistRepository playListRepo;
	
	@Override
	public void addPlaylist(Playlist playList){
		playListRepo.save(playList);
		System.out.println("Saved to playlist");
		
	}

	@Override
	public List<Playlist> fetchAllPlaylists() {
		List<Playlist> allPlaylists = playListRepo.findAll();
		return allPlaylists;
	}

}
