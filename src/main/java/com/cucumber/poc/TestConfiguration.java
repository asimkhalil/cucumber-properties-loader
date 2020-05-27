package com.cucumber.poc;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Resource(name = "src/main/resources/test.properties")
public class TestConfiguration {

	@Value("${username}")
	public String username;

	@Value("${password}")
	public String password;
}
