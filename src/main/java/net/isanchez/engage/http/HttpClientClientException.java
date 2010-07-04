package net.isanchez.engage.http;

import net.isanchez.engage.EngageClientException;

public class HttpClientClientException extends EngageClientException {
	private static final long serialVersionUID = -3963173011983047519L;

	public HttpClientClientException(String message) {
		super(message);
	}

	public HttpClientClientException(String message, Throwable e) {
		super(message, e);
	}
}
