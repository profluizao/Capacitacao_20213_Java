package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TesteController {

	@GetMapping("/teste/testar")
	public String testar() {
		return "O teste funcionou!!!";
	}
	
}
