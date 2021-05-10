package com.stockyourfridge.stockyourfridge.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

/**
 * Test controller, used to check basic api, working of server
 * 
 * @author rhishabh
 *
 */
@RestController
@RequestMapping("/test")
@Slf4j
public class TestController {
	
	/**
	 * Test method, just to check that the apis are working
	 * 
	 * @return String
	 */
	@GetMapping()
	public String test() {
		log.error("test successful error");
		log.info("test successful info");
		log.warn("test successful warn");
		log.debug("test successful debug");
		log.trace("test successful trace");
		return "test successful";
	}
	
}
