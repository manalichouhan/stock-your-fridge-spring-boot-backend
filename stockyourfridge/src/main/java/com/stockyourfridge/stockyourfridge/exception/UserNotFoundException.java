package com.stockyourfridge.stockyourfridge.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception class when user with userName is not found.
 * 
 * @author rhishabh
 *
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserNotFoundException(String userName) {
		super("User with userName: " + userName + " not found.");
	}
	
}
