package starter.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.stepdefinitions.ApiStepDefinitions;

public class ApiSteps {

	@Steps
	ApiStepDefinitions definitions;

	@When("^user make GET request to \"(.*)\"$")
	public void makeGetRequest(String endpoint) {
		definitions.getRequestCode(endpoint);
	}

	@Then("^user get the 200 response code$")
	public void assert200Code() {
		definitions.assertSuccessCode();
	}
	
	@Then("validate response received in the POST call")
	public void assertPostResponse() {
		
	}
}

