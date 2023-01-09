package com.example.rest.webservices.restwebservices.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	
	private static List<User> users = new ArrayList<>();
	
	static
	
	{
		users.add(new User (1 , "ABC" , LocalDate.now().minusYears(30)));
		users.add(new User (2 , "CDF" , LocalDate.now().minusYears(25)));
		users.add(new User (3 , "FGH" , LocalDate.now().minusYears(20)));
		users.add(new User (4 , "IJK" , LocalDate.now().minusYears(15)));
	}

	public List<User>  findAll()
	{
		return users;
	}

	public User findById(int id) {
		// TODO Auto-generated method stub
	
		
		Predicate<? super User> predicate = users -> users.getId().equals(id);
		return users.stream().filter(predicate).findFirst().get();
				
	}
}
