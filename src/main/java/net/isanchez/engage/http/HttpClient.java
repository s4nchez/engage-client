package net.isanchez.engage.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

public class HttpClient {
	private static final String METHOD = "POST";
	private final QueryBuilder queryBuilder = new QueryBuilder();

	public BufferedReader post(String fullUrl, Map<String, String> parameters) throws HttpClientClientException {
		final String data = queryBuilder.buildQuery(parameters, false);
		try {
			final URL url = new URL(fullUrl);
			final HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod(METHOD);
			conn.setDoOutput(true);
			conn.connect();
			final OutputStreamWriter osw = new OutputStreamWriter(conn.getOutputStream(), "UTF-8");
			osw.write(data);
			osw.close();
			return new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
		} catch (MalformedURLException e) {
			throw new HttpClientClientException("Unexpected URL error", e);
		} catch (IOException e) {
			throw new HttpClientClientException("Unexpected IO error", e);
		}
	}

}
