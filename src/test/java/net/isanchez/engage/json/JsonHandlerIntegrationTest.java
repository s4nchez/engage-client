package net.isanchez.engage.json;

import net.isanchez.engage.AuthInfo;
import net.isanchez.engage.EngageClientException;
import net.isanchez.engage.Profile;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

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
