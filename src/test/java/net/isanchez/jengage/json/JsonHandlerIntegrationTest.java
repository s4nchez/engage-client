package net.isanchez.jengage.json;

import net.isanchez.jengage.AuthInfo;
import net.isanchez.jengage.EngageClientException;
import net.isanchez.jengage.Profile;
import org.junit.Test;

import java.io.*;

import static junit.framework.Assert.fail;
import static org.junit.Assert.assertEquals;

public class JsonHandlerIntegrationTest {

	final JsonHandler jsonHandler = new JsonHandler();

	@Test
	public void shouldConvertBasicAuthInfo() throws IOException, EngageClientException {
		Profile profile = new Profile("brian", "bri4n", "http://brian.myopenid.com/", "Other", "http://brian.myopenid.com/");
		final AuthInfo expected = new AuthInfo(profile);
		final AuthInfo actual = jsonHandler.buildAuthInfo(loadJson("/json/auth_info_simple.json"));
		assertEquals(expected, actual);
	}

	@Test
	public void shouldConvertErrorResponse() throws IOException {
		try {
			jsonHandler.buildAuthInfo(loadJson("/json/auth_info_error.json"));
			fail("exception not thrown");
		} catch (EngageClientException e) {
			assertEquals("Data not found", e.getMessage());
		}
	}

	private Reader loadJson(String fileName) throws IOException {
		final InputStream is = this.getClass().getResourceAsStream(fileName);
		return new InputStreamReader(is, "UTF-8");
	}

}
