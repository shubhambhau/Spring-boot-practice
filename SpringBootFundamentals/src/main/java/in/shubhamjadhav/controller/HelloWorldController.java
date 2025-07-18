package in.shubhamjadhav.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	@GetMapping("/")
	public String message()
	{
		return "Welcome to the SpringBoot Application";
	}
	
	
	@GetMapping("/hello-world")
	public String HelloMessage() {
		return "hello welcome to the Hello World page";
	}
}
