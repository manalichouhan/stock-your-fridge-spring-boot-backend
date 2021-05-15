package com.stockyourfridge.stockyourfridge.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.stockyourfridge.stockyourfridge.dto.AuthenticationResponse;
import com.stockyourfridge.stockyourfridge.dto.LoginRequest;
import com.stockyourfridge.stockyourfridge.dto.RegisterRequest;
import com.stockyourfridge.stockyourfridge.model.User;
import com.stockyourfridge.stockyourfridge.repository.UserRepository;
import com.stockyourfridge.stockyourfridge.security.JwtProvider;

@Service  
public class AuthService {
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private JwtProvider jwtProvider;
	
	@Transactional
	public void signup(RegisterRequest registerRequest) {
		User user= new User();
		user.setUserName(registerRequest.getUsername());
		user.setEmail(registerRequest.getEmail());
		user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
		user.setEnabled(true);
		userRepository.save(user);
	}
	
	public AuthenticationResponse login(LoginRequest loginRequest) {
			
			Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
			 SecurityContextHolder.getContext().setAuthentication(authenticate);
			 String token = jwtProvider.generateToken(authenticate);
			 
			 return new AuthenticationResponse(token,loginRequest.getUsername());
}

}
