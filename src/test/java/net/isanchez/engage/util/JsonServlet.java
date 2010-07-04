package net.isanchez.engage.util;

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

public class JsonServlet extends HttpServlet {
	private static final long serialVersionUID = -2230438642977985499L;
	private final String jsonFile;
	private final String path;

	public JsonServlet(String path, String jsonFile) {
		this.jsonFile = jsonFile;
		this.path = path;
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final InputStream is = this.getClass().getResourceAsStream("/json/" + jsonFile);
		response.setContentType("text/javascript");
		response.setStatus(HttpServletResponse.SC_OK);
		final ServletOutputStream os = response.getOutputStream();
		IOUtils.copy(is, os);
		os.flush();
		os.close();
	}

	public String getPath() {
		return path;
	}
}