package com.tunehub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tunehub.entity.Users;
import com.tunehub.services.UsersService;

@Controller
public class NavController {
	
	@Autowired
	UsersService userService;
	@GetMapping("/register")
	public String registerPageDisplay()
	{

		return "register";
	}
	//for displaying login page when user clicks on login
	@GetMapping("/login")
	public String loginPageDisplay()
	{

		return "login";
	}
	
	//To navigate into add song page
	@GetMapping("/newsong")
	public String addSongDisp() {
		return "addsong";
	}
	
	
}
