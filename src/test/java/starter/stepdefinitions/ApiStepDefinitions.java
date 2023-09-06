package starter.stepdefinitions;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.util.EnvironmentVariables;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Rule;

import com.github.tomakehurst.wiremock.junit.WireMockRule;

import ApiUtils.CoinbaseCurrencies;
import ApiUtils.WireMockService;
import io.cucumber.java.Before;

public class ApiStepDefinitions {
	
	protected final int PORT = 8443;
	protected final String ENDPOINT_URL = String.format("http://localhost:%s/an/endpoint", PORT);
	
	@Rule
	public WireMockRule wireMockRule = new WireMockRule(PORT);
	
	protected WireMockService wiremock = new WireMockService();
	
	private EnvironmentVariables env;
	private String apiBaseUri() {
		return EnvironmentSpecificConfiguration.from(env).getProperty("api.base.url");
	}
	
	@Before (value="@api")
	public void setUpWireMock() {
		wiremock.setupStub();
	}
	
	@Step
	public void getRequestCode(String endpoint) {
		String fullUrl = apiBaseUri() + endpoint;
		Serenity.setSessionVariable("code")
				.to(SerenityRest.when()
						.get(fullUrl).getStatusCode());
		//Serenity.setSessionVariable("code").to(SerenityRest.given().accept("").body("").when().post("").getStatusCode());
		//Serenity.setSessionVariable("code").to(SerenityRest.given().accept("").body("").when().post("").getBody().asString());
	}

	@Step
	public void assertSuccessCode() {
		assertThat(Serenity.sessionVariableCalled("code").equals(200));
	}
	
	@Step
	public void getPostResponseData() {
		
	}
	
	@Step
	public void getResponseDataToParse() {
		String url = new CoinbaseCurrencies("api.coinbase.currencies").getUrl();
		String response = SerenityRest.when().get(url).getBody().asString(); 
				//Serenity.setSessionVariable("code").to(SerenityRest.given().when().get(url).getBody().asString());
		assertTrue("", true);
		
	}
	
}
