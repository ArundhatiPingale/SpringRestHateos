package com.example.rest.webservices.restwebservices.user;

import java.net.URI;
import java.util.List;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;

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
	public EntityModel<User> retriveuser(@PathVariable int id )
	{
		User user =service.findById(id);
		
		if (user==null)
		{
			throw new UserNotFoundException("id"+id );
		}
		
		EntityModel<User> model= EntityModel.of(user);
		
		WebMvcLinkBuilder link= linkTo(methodOn(this.getClass()).retriveAllUsers());
		model.add(link.withRel("all-users"));
		return model;
	}

	@PostMapping("/users")
	public  ResponseEntity<User> createUser( @Valid @RequestBody User user)
	{
		User saveduser=service.save(user);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				   .path("{id}")
				   .buildAndExpand(saveduser.getId())
				   .toUri();
	
		return ResponseEntity.created(location).build();
	}
	
	
	@DeleteMapping("/users/{id}")
	public void deleteuser(@PathVariable int id )
	{
		User user =service.findById(id);
		
		if (user==null)
		{
			throw new UserNotFoundException("id"+id );
		}
		
		service.delete(id);
	}
}
