package com.example.demo.contoller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@GetMapping
	public String HomeControllerHandler1()
	{
		return "Home contoller";
	}
	@GetMapping("/1")
	public String HomeControllerHandler2()
	{
		return "Home contoller operated by devloper";
	}
	
}
