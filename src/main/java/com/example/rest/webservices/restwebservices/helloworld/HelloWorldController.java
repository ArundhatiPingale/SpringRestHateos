package com.example.rest.webservices.restwebservices.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	@GetMapping(path="/hello-world")
	public String helloworld()
	{
		return "Hello World";
	}
	@GetMapping(path="/hello-world-bean")
	public  HelloWorldBean helloWorldBean()
	{
		return new HelloWorldBean( "Hello World");
	}
	
	@GetMapping(path="/hello-world/pathvariable/{name}")
	public  HelloWorldBean helloWorldPathVariable(@PathVariable String name)
	{
		return new HelloWorldBean( String.format( "Hello World ,%s", name));
	}
	
}
