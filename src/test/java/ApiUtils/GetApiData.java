package ApiUtils;

import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.thucydides.core.util.EnvironmentVariables;

public class GetApiData {
	
	private EnvironmentVariables env;
	private String baseUrl="";
	
	public GetApiData(String property) {
		baseUrl = EnvironmentSpecificConfiguration.from(env).getProperty(property);
	}
	
	public String getUrl() {
		return baseUrl;
	}
	
	
	
}
