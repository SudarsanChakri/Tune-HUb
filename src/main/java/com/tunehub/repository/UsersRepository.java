package com.tunehub.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tunehub.entity.Users;

public interface UsersRepository extends JpaRepository<Users, Integer>
{

	Users findByEmail(String email);
	

	

}
