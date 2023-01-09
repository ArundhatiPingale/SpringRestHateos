package com.example.rest.webservices.restwebservices.user;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserReource {
	
	private UserDaoService service;
	
	
	public UserReource(UserDaoService service) {
		
		this.service = service;
	}


	@GetMapping("/users")
	public List<User>  retriveAllUsers()
	{
		return service.findAll();
		
	}
	
	@GetMapping("/users/{id}")
	public User retriveuser(@PathVariable int id )
	{
		return service.findById(id);
		
	}

}
