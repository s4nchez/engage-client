package net.isanchez.jengage.http;

import net.isanchez.jengage.EngageClientException;

public class HttpClientClientException extends EngageClientException {
	private static final long serialVersionUID = -3963173011983047519L;

	public HttpClientClientException(String message) {
		super(message);
	}

	public HttpClientClientException(String message, Throwable e) {
		super(message, e);
	}
}
