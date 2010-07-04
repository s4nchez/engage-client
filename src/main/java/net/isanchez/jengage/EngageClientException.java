package net.isanchez.jengage;

public class EngageClientException extends Exception {
	private static final long serialVersionUID = -5178375385610109376L;

	public EngageClientException(String message) {
		super(message);
	}

	public EngageClientException(String message, Throwable e) {
		super(message, e);
	}
}
