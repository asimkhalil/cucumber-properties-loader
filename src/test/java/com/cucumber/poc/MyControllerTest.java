package com.cucumber.poc;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/main/resources", 
glue = {"classpath:com.cucumber.poc.stepdefinitions"},
plugin = "json:target/cucumber-resport.json")
public class MyControllerTest {
}
