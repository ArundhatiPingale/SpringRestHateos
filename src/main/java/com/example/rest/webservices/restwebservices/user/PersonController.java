package com.example.rest.webservices.restwebservices.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {
	
	
	@GetMapping("/Person/V1/")
	public PersonV1 getPersonfirstverson()
	{
		return new PersonV1("Bob Charlie");
		
	}
	
	@GetMapping("/Person/V2/")
	public PersonV2 getPersonsecondverson()
	{
		return new PersonV2(new Name ("Bob","Charlie"));
	}

//REQUEST PARAM VERSIONING	
	@GetMapping(path = "/Person" , params = "version=2")
	public PersonV2 getPersonparamsecondverson()
	{
		return new PersonV2(new Name ("Bob","Charlie"));
	}

	
	@GetMapping(path = "/Person" , params = "version=1")
	public PersonV1 getPersonparamfirstverson()
	{
		return new PersonV1(("Bob Charlie"));
	}
	
	//HEADER  VERSIONINING
	@GetMapping(path = "/Person" , headers = "X-API-VERSION=1")
	public PersonV1 getPersonheaderfirstverson()
	{
		return new PersonV1(("Bob Charlie"));
	}
	
	
	@GetMapping(path = "/Person" , params = "X-API-VERSION=2")
	public PersonV2 getPersonheadersecondverson()
	{
		return new PersonV2(new Name ("Bob","Charlie"));
	}
	
	
	//ACCEPT LANGUAGE INTERNALIZATION VERSIONING
	@GetMapping(path = "/Person" , produces = "application/vnd.company.app-V1+json")
	public PersonV1 getPersonacceptfirstverson()
	{
		return new PersonV1(("Bob Charlie"));
	}
	
	
	@GetMapping(path = "/Person" , produces = "application/vnd.company.app-V2+json")
	public PersonV2 getPersonacceptsecondverson()
	{
		return new PersonV2(new Name ("Bob","Charlie"));
	}
	
	
}
