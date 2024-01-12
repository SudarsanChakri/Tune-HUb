package com.tunehub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.tunehub.entity.Song;
import com.tunehub.services.SongService;

@Controller
public class SongController {
@Autowired
SongService service;

@PostMapping("/addsong")
public String addSong(@ModelAttribute Song song) {
	boolean songStatus = service.songExists(song.getLink());
	if(songStatus==false) {
		
		service.addSong(song);
	}
	return "adminhome";
}


@GetMapping("/viewsongs")
public String viewAllSong(Model model) {
	
	System.out.println("Control coming inside");
	model.addAttribute("allsongs", service.fetchAllSongs());
	return "viewallsongs";
}

@GetMapping("/playsongs")
public String playSongs(Model model) {
	
	boolean payment = false;
	if(payment==true) {
		model.addAttribute("allsongs", service.fetchAllSongs());
		return "viewallsongs";
	}
	else {
		return "makepaymentpage";
	}
}

}
