package com.cucumber.poc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {

	@Autowired
	TestConfiguration testConfiguration;

	public boolean login(String username, String password) throws Exception {

		System.out.println("username: " + testConfiguration.username);

		if (username.equalsIgnoreCase(testConfiguration.username)
				&& password.equalsIgnoreCase(testConfiguration.password)) {
			return true;
		}

		throw new Exception("Invalid credentials");

	}
}
