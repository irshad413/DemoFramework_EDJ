@regression @smoke @api
Feature: Some API test

@api
	Scenario: First api scenario
		When user make GET request to "/users"
		Then user get the 200 response code