package com.fulllearn.helper;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class HttpConnectionHelper {

	private HttpConnectionHelper() {

	}

	public static String getJson(String method, String urlString, String params, Map<String, String> headers)
			throws IOException {

		String responseJson = "";
		if (urlString != null) {

			URL url = new URL(urlString);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setDoOutput(true);

			if (method != null) {
				connection.setRequestMethod(method);
			}

			if (headers != null && !headers.isEmpty()) {
				for (Entry<String, String> headerEntry : headers.entrySet()) {
					connection.setRequestProperty(headerEntry.getKey(), headerEntry.getValue());
				}
			}
			if (params != null && !params.isEmpty()) {
				OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());
				writer.write(params);
				writer.flush();
			}
			try (Scanner scanner = new Scanner(new InputStreamReader(connection.getInputStream()));) {

				while (scanner.hasNext()) {
					responseJson += scanner.nextLine();
				}

			}

		}

		return responseJson;
	}
}
