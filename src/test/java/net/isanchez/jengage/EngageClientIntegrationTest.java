package net.isanchez.jengage;

import net.isanchez.jengage.util.EngageTestServer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;

public class EngageClientIntegrationTest {

	private final EngageTestServer server = new EngageTestServer();
	private final EngageClient client = new EngageClient("anyKey", "anyToken");

	@Before
	public void setUp() {
		client.setBaseUrl("http://localhost:14523/");
	}

	@Test
	public void shouldRequestAuthInfo() throws Exception {
		server.serve("/auth_info", "auth_info_simple.json", 14523);
		final AuthInfo authInfo = client.authInfo(false);
		assertNotNull(authInfo);
		final Profile profile = authInfo.getProfile();
		assertNotNull(profile);
		assertEquals("brian", profile.getDisplayName());
	}

	@Test(expected = EngageClientException.class)
	public void shouldHandleErrors() throws EngageClientException {
		server.serve("/auth_info", "auth_info_error.json", 14523);
		client.authInfo(false);
	}

	@After
	public void stopServer() {
		server.stop();
	}
}
