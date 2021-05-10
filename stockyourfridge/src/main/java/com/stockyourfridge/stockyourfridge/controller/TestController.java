package com.stockyourfridge.stockyourfridge.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Test controller, used to check basic api, working of server
 * 
 * @author rhishabh
 *
 */
@RestController
@RequestMapping("/test")
public class TestController {
	
	/**
	 * Test method, just to check that the apis are working
	 * 
	 * @return String
	 */
	@GetMapping()
	public String test() {
		return "test successful";
	}
	
}
