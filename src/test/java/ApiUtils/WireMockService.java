package ApiUtils;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

public class WireMockService {
	
	public void setupStub() {
		stubFor(get(urlEqualTo("/an/endpoint")).willReturn(aResponse()
				.withBody("You've reached a valid WireMock endpoint")
				.withStatus(200)));
		
		stubFor(get(urlEqualTo("/an/endpoint/1")).willReturn(aResponse()
				.withBody("You've reached a valid WireMock endpoint 1")
				.withStatus(200)));
		
		stubFor(post(urlEqualTo("/an/endpoint/1")).willReturn(aResponse()
				.withBody("You've reached a valid WireMock endpoint 2")
				.withStatus(200)));
	}
}
