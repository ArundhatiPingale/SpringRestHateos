package com.example.rest.webservices.restwebservices.user;

public class Name {

	
	private String FirstName;
	private String LastName;
	public Name(String firstName, String lastName) {
		super();
		FirstName = firstName;
		LastName = lastName;
	}
	
	
	
	@Override
	public String toString() {
		return "Name [FirstName=" + FirstName + ", LastName=" + LastName + "]";
	}



	public String getFirstName() {
		return FirstName;
	}



	public String getLastName() {
		return LastName;
	}
	
}
