package com.example.demo.controller;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloController {
	
	@GetMapping("/")
	@ResponseBody
	String helloWorld() {
		return "Hello, World";
	}
	

}
