package net.isanchez.jengage.json;

import com.google.gson.Gson;
import net.isanchez.jengage.AuthInfo;
import net.isanchez.jengage.EngageClientException;
import net.isanchez.jengage.Err;
import net.isanchez.jengage.Stat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

public class JsonHandler {

	private static final String UNKNOWN_ERROR = "unknown error";
	private final Gson gson = new Gson();

	public AuthInfo buildAuthInfo(Reader jsonReader) throws EngageClientException {
		if (jsonReader == null) {
			throw new IllegalArgumentException("reader is null");
		}
//		String json = convertStream(jsonReader);
		final AuthInfo status = gson.fromJson(jsonReader, AuthInfo.class);
		if (Stat.fail.equals(status.getStat())) {
			final Err err = status.getErr();
			final String message = err != null ? err.getMsg() : UNKNOWN_ERROR;
			throw new EngageClientException(message);
		}
		return status;
	}

	private String convertStream(Reader jsonReader) {
		BufferedReader reader = new BufferedReader(jsonReader);
		final StringBuilder sb = new StringBuilder();
		String line;
		try {
			while ((line = reader.readLine()) != null) {
				sb.append(line).append("\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("sb=" + sb);
		return sb.toString();
	}

}
