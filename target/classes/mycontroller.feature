Feature: validate login
Scenario: Validate login with correct username and password
	Given initialize data for correct username and password
		When login method calls with correct username and password
		Then the login method should return true
Scenario: Validate login with wrong username and password
	Given initialize data for wrong username and password
		When login method calls with wrong username and password
		Then the login method should return exception		