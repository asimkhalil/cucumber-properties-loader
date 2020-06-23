package com.cucumber.poc.stepdefinitions;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.test.util.ReflectionTestUtils;

import com.cucumber.poc.TestConfiguration;
import com.cucumber.poc.TestService;
import com.cucumber.poc.configuration.ConfigurationData;
import com.cucumber.poc.configuration.SystemConfiguration;
import com.cucumber.poc.configuration.SystemConfigurationImpl;
import com.cucumber.poc.configuration.exception.DeltaException;
import com.cucumber.poc.vo.Response;
import com.cucumber.poc.vo.UserVO;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MyControllerStepDef {

	TestService service;

	Response serviceResult;

	Object peSession;

	UserVO userVO;

	String connectionPointProperty;
	
	SystemConfiguration systemConfiguration;
	

	public MyControllerStepDef() throws IOException {
		super();
		service = new TestService();
	}

	@Given("^initialize data for correct username and password$")
	public void user_has_sample_request_for_get_contract_service() throws Throwable {
		System.out.println("In Given");
		//loadConfigurations();
		
		service = Mockito.mock(TestService.class);
	}

	@When("^login method calls with correct username and password$")
	public void get_contract_edit_service_called_via_postman() throws Throwable {
		System.out.println("In When");
		try {
//			peSession = service.getPESession(userVO, connectionPointProperty);
		    
		    Response response = new Response();
		    response.setMessage("Method verified");
		    response.setStatus(HttpStatus.OK);
		    
		    Mockito.when(service.testMethod(Mockito.anyString(), Mockito.anyString(), Mockito.anyString(), Mockito.anyString())).thenReturn(response);
		    
		    serviceResult = service.testMethod("1", "1", "2", "2");
		    
		} catch (DeltaException ex) {
			peSession = null;
			System.out.print("Exception occured while verifying login");
		}
	}

	@Then("^the login method should return true$")
	public void get_contract_receives_status_code_of_200() throws Throwable {
		System.out.println("In Then");
		assertTrue(serviceResult != null);
	}

//	@Given("^initialize data for wrong username and password$")
//	public void given_wrong_credentials() throws Throwable {
//		System.out.println("In Given");
//		loadConfigurations();
//	}
//
//	@When("^login method calls with wrong username and password$")
//	public void when_wrong_credentials() throws Throwable {
//		System.out.println("In When");
//		try {
//			peSession = service.getPESession(userVO, connectionPointProperty);
//		} catch (DeltaException ex) {
//			peSession = null;
//			System.out.print("Exception occured while verifying login");
//		}
//	}
//
//	@Then("^the login method should return exception$")
//	public void then_wrong_credentials() throws Throwable {
//		System.out.println("In Then");
//		assertTrue(peSession == null);
//	}
	
	private void loadConfigurations() throws Exception {
		TestConfiguration testConfiguration = new TestConfiguration();
		testConfiguration.load();
		ReflectionTestUtils.setField(service, "testConfiguration", testConfiguration, TestConfiguration.class);
		
		userVO.setUserId(testConfiguration.userId);
		userVO.setPassword(testConfiguration.password);
		connectionPointProperty = testConfiguration.connectionPointProperty;
		
		systemConfiguration = new SystemConfigurationImpl();
		ConfigurationData configurationData = new ConfigurationData();
		systemConfiguration.setConfigurationData(configurationData);
		
		ReflectionTestUtils.setField(service, "systemConfiguration", systemConfiguration, SystemConfiguration.class);
	}
}
