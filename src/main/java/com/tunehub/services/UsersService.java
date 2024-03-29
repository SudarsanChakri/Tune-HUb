package com.tunehub.services;

import com.tunehub.entity.Users;

public interface UsersService 
{
	String addUser(Users user);

	boolean emailExists(String email);

	boolean validAccount(String email, String password);

	String getRole(String email);
	
	Users getUser(String email);

	void updateUser(Users u);

	boolean getPaymentStatus(String email);
}
