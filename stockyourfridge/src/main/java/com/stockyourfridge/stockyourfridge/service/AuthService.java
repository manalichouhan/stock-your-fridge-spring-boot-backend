package com.stockyourfridge.stockyourfridge.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.stockyourfridge.stockyourfridge.dto.RegisterRequest;
import com.stockyourfridge.stockyourfridge.model.User;
import com.stockyourfridge.stockyourfridge.repository.UserRepository;

@Service  
public class AuthService {
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserRepository userRepository;
	
	@Transactional
	public void signup(RegisterRequest registerRequest) {
		User user= new User();
		user.setUserName(registerRequest.getUsername());
		user.setEmail(registerRequest.getEmail());
		user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
		user.setEnabled(true);
		userRepository.save(user);
	}

}
