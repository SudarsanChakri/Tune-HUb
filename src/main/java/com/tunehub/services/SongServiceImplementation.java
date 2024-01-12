package com.tunehub.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.tunehub.entity.Song;
import com.tunehub.repository.SongRepository;

@Service
public class SongServiceImplementation implements SongService
{
	@Autowired
	SongRepository songRepo;
	
	@Override
	public void addSong(@ModelAttribute Song song) {
		
		songRepo.save(song);
	}

	@Override
	public List<Song> fetchAllSongs() {
		// TODO Auto-generated method stub
		List<Song> songsList = songRepo.findAll();
		
		return songsList;
	}

	@Override
	public boolean songExists(String link) {
		Song s = songRepo.findByLink(link);
		if(s==null) {
			
			System.out.println("Song added");
			return false;
		}
		else {
			System.out.println("Song exist");
			return true;
		}
	}

	@Override
	public void updateSong(Song song) {
		songRepo.save(song);
		
	}

}
