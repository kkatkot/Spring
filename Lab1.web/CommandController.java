package com.example.demo.controller;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
public class CommandController {
	@GetMapping("/command")
	String command() {
		return "command.html";
	}
	@GetMapping("/about")
	String about() {
		return "about.html";
	}

}
