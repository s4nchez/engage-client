package net.isanchez.jengage.util;

import org.mortbay.jetty.Connector;
import org.mortbay.jetty.Server;
import org.mortbay.jetty.bio.SocketConnector;
import org.mortbay.jetty.servlet.ServletHandler;
import org.mortbay.jetty.servlet.ServletHolder;

import java.net.HttpURLConnection;
import java.net.URL;

public class HttpServer implements Runnable {
	private final int port;
	private final JsonServlet servlet;
	private Server server;

	public HttpServer(int port, JsonServlet servlet) {
		server = new Server();
		this.port = port;
		this.servlet = servlet;
	}

	public void run() {
		Connector connector = new SocketConnector();
		connector.setPort(port);
		server.setConnectors(new Connector[]{connector});
		final ServletHandler handler = new ServletHandler();
		final ServletHolder holder = new ServletHolder(servlet);
		handler.addServletWithMapping(holder, servlet.getPath());
		server.setHandler(handler);
		try {
			server.start();
			server.join();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean isRunning() {
		final URL url;
		try {
			url = new URL("http://localhost:" + port + "/");
			final HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.connect();
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public void stop() {
		try {
			server.stop();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}