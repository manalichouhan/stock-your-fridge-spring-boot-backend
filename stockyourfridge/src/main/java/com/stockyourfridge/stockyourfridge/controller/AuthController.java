package com.stockyourfridge.stockyourfridge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stockyourfridge.stockyourfridge.dto.AuthenticationResponse;
import com.stockyourfridge.stockyourfridge.dto.LoginRequest;
import com.stockyourfridge.stockyourfridge.dto.RegisterRequest;
import com.stockyourfridge.stockyourfridge.service.AuthService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	@Autowired
	private AuthService authService;

	@PostMapping("/signup")
	public ResponseEntity<String> signup(@RequestBody RegisterRequest registerRequest ) {
		authService.signup(registerRequest);
		return new ResponseEntity<>("User Registration Successful", 
				HttpStatus.OK);
	}
	
	@PostMapping("/login")
	public AuthenticationResponse login(@RequestBody LoginRequest loginRequest) {
		return authService.login(loginRequest);
	}

	

}
