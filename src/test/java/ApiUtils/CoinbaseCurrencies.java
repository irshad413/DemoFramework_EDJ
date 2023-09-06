package ApiUtils;

import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.thucydides.core.util.EnvironmentVariables;

public class CoinbaseCurrencies {
	
	private EnvironmentVariables env;
	private String baseUrl="";
	
	public CoinbaseCurrencies(String property) {
		baseUrl = EnvironmentSpecificConfiguration.from(env).getProperty(property);
	}
	
	public String getUrl() {
		return baseUrl;
	}
}
