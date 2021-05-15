package com.stockyourfridge.stockyourfridge.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.stockyourfridge.stockyourfridge.model.User;

public interface UserRepository extends CrudRepository<User, Long> { 
	
	public Optional<User> findByUserName(String userName);
	Optional<User> findByEmail(String email);
}
