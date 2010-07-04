package net.isanchez.engage;

import net.isanchez.engage.http.HttpClient;
import net.isanchez.engage.json.JsonHandler;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class EngageClientTest {
	private static final String TOKEN = "token";
	private static final String API_KEY = "apiKey";
	private EngageClient engageClient;
	private HttpClient httpClient;
	private JsonHandler jsonHandler;
	private static final String BASE_URL = "BASE_URL";

	@Before
	public void setUp() throws Exception {
		httpClient = mock(HttpClient.class);
		jsonHandler = mock(JsonHandler.class);
		engageClient = new EngageClient(API_KEY, TOKEN);
		engageClient.setBaseUrl(BASE_URL);
		engageClient.setHttpClient(httpClient);
		engageClient.setJsonHandler(jsonHandler);
	}

	@Test
	public void shouldRetrieveAuthInfo() {
		final Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("apiKey", API_KEY);
		parameters.put("token", TOKEN);
		parameters.put("extended", "false");
		final BufferedReader reader = mock(BufferedReader.class);
		final AuthInfo expected = new AuthInfo();
		when(httpClient.post(BASE_URL + "auth_info", parameters)).thenReturn(reader);
		when(jsonHandler.buildAuthInfo(reader)).thenReturn(expected);
		final AuthInfo actual = engageClient.authInfo(false);
		assertEquals(expected, actual);
	}
}
