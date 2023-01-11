package com.example.rest.webservices.restwebservices.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	
	private static List<User> users = new ArrayList<>();
	
	private static int userCount=0;
	
	static
	
	{
		users.add(new User (userCount++ , "ABC" , LocalDate.now().minusYears(30)));
		users.add(new User (userCount++ , "CDF" , LocalDate.now().minusYears(25)));
		users.add(new User (userCount++, "FGH" , LocalDate.now().minusYears(20)));
		users.add(new User (userCount++ , "IJK" , LocalDate.now().minusYears(15)));
	}

	public List<User>  findAll()
	{
		return users;
	}

	public User findById(int id) {
		// TODO Auto-generated method stub
	
		
		Predicate<? super User> predicate = users -> users.getId().equals(id);
		return users.stream().filter(predicate).findFirst().orElse(null);
				
	}

	public User save(User user) {
		// TODO Auto-generated method stub
		user.setId(userCount++);
		users.add(user);
		
		return user;
		
	}
	
	public void delete(int id) 
	{	
		Predicate<? super User> predicate = users -> users.getId().equals(id);
		
		users.removeIf(predicate);
		 //users.stream().filter(predicate).collect(Collectors.toList()).remove(id);
	
			
	}
	
	
}
