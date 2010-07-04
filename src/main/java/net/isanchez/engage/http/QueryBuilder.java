package net.isanchez.engage.http;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;


public class QueryBuilder {

	private static final String EMPTY_STRING = "";
	private static final String EQUALS = "=";
	private static final String AMPERSAND = "&";

	private static final String ENCODING = "UTF-8";

	public String buildQuery(Map<String, String> parameters, boolean includeNullValues) {
		if (parameters == null) return EMPTY_STRING;
		final StringBuilder query = new StringBuilder();
		for (String key : parameters.keySet()) {
			String value = parameters.get(key);
			if (value != null || includeNullValues) {
				String encodedKey = encode(key);
				String encodedValue = encode(value);
				query.append(encodedKey).append(EQUALS).append(encodedValue).append(AMPERSAND);
			}
		}
		if (query.length() > 0) query.deleteCharAt(query.length() - 1);
		return query.toString();
	}

	private String encode(String value) {
		if (value == null) return EMPTY_STRING;
		try {
			return URLEncoder.encode(value, ENCODING);
		}
		catch (UnsupportedEncodingException e) {
			throw new IllegalStateException("Encoding " + ENCODING + " was verified at construction but is now unsupported!");
		}
	}

}
