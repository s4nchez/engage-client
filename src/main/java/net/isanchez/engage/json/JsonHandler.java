package net.isanchez.engage.json;

import com.google.gson.Gson;
import net.isanchez.engage.AuthInfo;
import net.isanchez.engage.EngageClientException;
import net.isanchez.engage.Err;
import net.isanchez.engage.Stat;

import java.io.Reader;

public class JsonHandler {

	private static final String UNKNOWN_ERROR = "unknown error";
	private final Gson gson = new Gson();

	public AuthInfo buildAuthInfo(Reader jsonReader) throws EngageClientException {
		if (jsonReader == null) {
			throw new IllegalArgumentException("reader is null");
		}
		final AuthInfo status = gson.fromJson(jsonReader, AuthInfo.class);
		if (status == null) {
			throw new EngageClientException("Couldn't convert response to json");
		}
		if (Stat.fail.equals(status.getStat())) {
			final Err err = status.getErr();
			final String message = err != null ? err.getMsg() : UNKNOWN_ERROR;
			throw new EngageClientException(message);
		}
		return status;
	}
}
