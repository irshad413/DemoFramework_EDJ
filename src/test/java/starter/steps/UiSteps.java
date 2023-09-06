package starter.steps;

import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.stepdefinitions.UiStepDefinitions;

public class UiSteps {

	@Steps
	UiStepDefinitions definitions;

	@When("^user navigates to EDJ Home page and checks welcome message$")
	public void openYandex() {
		definitions.openEdjHomePageValidateWelcomeMessage();
	}
}

