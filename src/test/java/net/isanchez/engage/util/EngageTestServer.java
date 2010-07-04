package net.isanchez.engage.util;

public class EngageTestServer {
	private static final long TIMEOUT = 1000;
	private HttpServer server;

	public void serve(final String pathToServe, final String jsonFile, final int port) {
		final JsonServlet servlet = new JsonServlet(pathToServe, jsonFile);
		final HttpServer newServer = new HttpServer(port, servlet);
		final long timeoutTime = System.currentTimeMillis() + TIMEOUT;
		this.server = newServer;
		new Thread(server).start();
		while (!server.isRunning() && System.currentTimeMillis() < timeoutTime) {
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		if (!server.isRunning()) {
			throw new RuntimeException("Couldn't start server");
		}
	}

	public void stop() {
		server.stop();
		final long timeoutTime = System.currentTimeMillis() + TIMEOUT;
		while (server.isRunning() && System.currentTimeMillis() < timeoutTime) {
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		if (server.isRunning()) {
			throw new RuntimeException("Couldn't start server");
		}
	}
}
