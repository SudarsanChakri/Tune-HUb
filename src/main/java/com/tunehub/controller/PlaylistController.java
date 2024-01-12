package com.tunehub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

import com.tunehub.entity.Playlist;
import com.tunehub.entity.Song;
import com.tunehub.services.PlaylistService;
import com.tunehub.services.SongService;

@Controller
public class PlaylistController {
	@Autowired
	SongService songService;
	
	@Autowired
	PlaylistService playListService;
	
	@GetMapping("/createplaylist")
	public String createPlaylist(Model model) {
		
		List<Song> songList = songService.fetchAllSongs();
		model.addAttribute("songs", songList);
		return "createplaylist";
	}
	
	@PostMapping("/addplaylist")
	public String addPlaylist(@ModelAttribute Playlist playList) {
		//updating playlist table
		playListService.addPlaylist(playList);
		
		//updating song table
		List<Song> songList = playList.getSongs();
		for(Song s : songList) {
			s.getPlaylists().add(playList);
			
			//updating song object in db
			songService.updateSong(s);
			
		}
		
		return "adminhome";
		
	}
	
	@GetMapping("viewplaylists")
	public String viewPlaylists(Model model) {
		List<Playlist> allPlaylists = playListService.fetchAllPlaylists();
		model.addAttribute("allPlaylists", allPlaylists);
		return "displayplaylists";
	}
}
