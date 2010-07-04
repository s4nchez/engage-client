package net.isanchez.jengage;

import net.isanchez.jengage.http.HttpClient;
import net.isanchez.jengage.json.JsonHandler;

import java.io.BufferedReader;
import java.util.HashMap;
import java.util.Map;

public class EngageClient {

	private String baseUrl = "https://rpxnow.com/api/v2/";
	private final HttpClient httpClient = new HttpClient();
	private final JsonHandler jsonHandler = new JsonHandler();

	private final Map<String, String> baseParameters = new HashMap<String, String>();

	public EngageClient(String apiKey, String token) {
		baseParameters.put("apiKey", apiKey);
		baseParameters.put("token", token);
	}

	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}

	public AuthInfo authInfo(boolean extended) throws EngageClientException {
		final Map<String, String> parameters = new HashMap<String, String>(baseParameters);
		parameters.put("extended", String.valueOf(extended));
		final BufferedReader json = httpClient.post(baseUrl + "auth_info", parameters);
		return jsonHandler.buildAuthInfo(json);
	}
}
