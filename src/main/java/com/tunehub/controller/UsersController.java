package com.tunehub.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tunehub.entity.Users;
import com.tunehub.services.UsersService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UsersController {
	@Autowired
	UsersService userServ;

	//method to check account existance and to diaplay register success page
	@PostMapping("/registered")
	public String addUser(@ModelAttribute Users user) {
		boolean userStatus = userServ.emailExists(user.getEmail());
		if(userStatus == false) {
			
			userServ.addUser(user);
		}
		
		return "registersuccess";
	}
	
	//Mothod to validate the login data and returns the login success or failure status
	@PostMapping("/user")
	public String validate(@RequestParam String email, @RequestParam String password, HttpSession session) {
		boolean validUser = userServ.validAccount(email,password);
		if(validUser==true) 
		{
			
			String role = userServ.getRole(email);
			session.setAttribute("email", email);
			if(role.equals("Admin")) 
			{
				return "adminhome";	
			}
			else if(role.equals("Customer")) 
			{
				
				return "customerhome";
			}
			
			
		}
		else 
		{
			
			return "invalid";
		}
		
		return null;
		
		
	}
	
	
/*	
	@GetMapping("/pay")
	public String pay(@RequestParam String email) {
		boolean paymentStatus = false;
		Users u = userServ.getUser(email);
		if(paymentStatus==true) {
			
			u.setPremium(true);
			userServ.updateUser(u);
		}
		
		return "login";
		
	}
*/	
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "login";
	}
	
	
	
	
	
	
	
	
}
