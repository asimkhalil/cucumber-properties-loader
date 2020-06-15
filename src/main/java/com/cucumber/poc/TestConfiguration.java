package com.cucumber.poc;

import java.io.InputStream;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TestConfiguration {

	@Value("${userId}")
	public String userId;
	
	@Value("${connectionPointPropety}")
	public String connectionPointProperty;
	
	@Value("${username}")
	public String username;

	@Value("${password}")
	public String password;

	public void load() {
		try {
			Properties props = new Properties();
			String resourceName = "test.properties";
			ClassLoader loader = Thread.currentThread().getContextClassLoader();
			InputStream resourceStream = loader.getResourceAsStream(resourceName);
			props.load(resourceStream);
			this.username = props.getProperty("username");
			this.password = props.getProperty("password");
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("Unable to load test configurations");
		}
	}
}
