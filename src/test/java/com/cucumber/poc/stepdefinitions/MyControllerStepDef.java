package com.cucumber.poc.stepdefinitions;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.springframework.test.util.ReflectionTestUtils;

import com.cucumber.poc.TestConfiguration;
import com.cucumber.poc.TestService;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MyControllerStepDef {

	TestService service;
	
	boolean serviceResult;
	
	public MyControllerStepDef() throws IOException {
		super();
		service = new TestService();
	}

	@Given("^initialize data for correct username and password$")
	public void user_has_sample_request_for_get_contract_service() throws Throwable {
		System.out.println("In Given");
		TestConfiguration testConfiguration = new TestConfiguration();
		testConfiguration.username = "asim";
		testConfiguration.password = "abc123";
		ReflectionTestUtils.setField(service, "testConfiguration", testConfiguration, TestConfiguration.class);
	}

	@When("^login method calls with correct username and password$")
	public void get_contract_edit_service_called_via_postman() throws Throwable {
		System.out.println("In When");
		serviceResult = service.login("asim", "abc123");
	}

	@Then("^the login method should return true$")
	public void get_contract_receives_status_code_of_200() throws Throwable {
		System.out.println("In Then");
		assertTrue(serviceResult);
	}
	
	@Given("^initialize data for wrong username and password$")
	public void given_wrong_credentials() throws Throwable {
		System.out.println("In Given");
		TestConfiguration testConfiguration = new TestConfiguration();
		testConfiguration.username = "asim";
		testConfiguration.password = "password";
		ReflectionTestUtils.setField(service, "testConfiguration", testConfiguration, TestConfiguration.class);
	}

	@When("^login method calls with wrong username and password$")
	public void when_wrong_credentials() throws Throwable {
		System.out.println("In When");
		try {
			service.login("äsim1", "abc123");
		} catch (Exception ex) {
			serviceResult = true;
		}
	}

	@Then("^the login method should return exception$")
	public void then_wrong_credentials() throws Throwable {
		System.out.println("In Then");
		assertTrue(serviceResult);
	}
}
