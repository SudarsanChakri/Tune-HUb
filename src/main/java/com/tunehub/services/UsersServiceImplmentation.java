package com.tunehub.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tunehub.entity.Users;
import com.tunehub.repository.UsersRepository;

@Service
public class UsersServiceImplmentation implements UsersService
{
	@Autowired
	UsersRepository userRepo;
	@Override
	public String addUser(Users user) {
		userRepo.save(user);
		return "addedsuccesfully";
	}
	@Override
	public boolean emailExists(String email) {
		if(userRepo.findByEmail(email)==null) {
			
			return false;
		}
		else {
			return true;
		}
	}
	@Override
	public boolean validAccount(String email, String password) {
		Users user = userRepo.findByEmail(email);
		String dbPassword = user.getPassword();
		if(user!=null) {
			if(password.equals(dbPassword)) {
				return true;
			}
		}
		return false;
	}
	@Override
	public String getRole(String email) {
		Users user = userRepo.findByEmail(email);
		
		return user.getRole();
	}
	@Override
	public Users getUser(String email) {
		Users user = userRepo.findByEmail(email);
		return user;
	}
	@Override
	public void updateUser(Users u) {
		userRepo.save(u);
	}
	@Override
	public boolean getPaymentStatus(String email) {
		Users user = userRepo.findByEmail(email);
		if(user.isPremium()) {
			return true;
		}
		return false;
	}

}
