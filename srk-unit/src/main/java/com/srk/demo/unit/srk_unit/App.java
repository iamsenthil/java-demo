package com.srk.demo.unit.srk_unit;

import java.io.IOException;

import com.demo.java.http.WebClient;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Json Parsing
 *
 */
public class App {
	public static void main(String[] args) {

		final ObjectMapper objectMapper = new ObjectMapper();
		final Device device = new Device(100);
		try {
			System.out.println(objectMapper.writeValueAsString(device));
		} catch (final JsonProcessingException e) {
			e.printStackTrace();
		}
		final String json = "{\"id\":100}";
		try {
			final Device newDevice = objectMapper.readValue(json, Device.class);
			System.out.println(newDevice.getID());
		} catch (final JsonParseException e) {
			e.printStackTrace();
		} catch (final JsonMappingException e) {
			e.printStackTrace();
		} catch (final IOException e) {
			e.printStackTrace();
		}
		final WebClient webclient = WebClient.getInstance();
		System.out.println(webclient.getData("https://www.google.com").getResponse());
	}

	String requestForData(String url) throws IOException {
		final Request request = new Request.Builder().url(url).build();
		final OkHttpClient client1 = new OkHttpClient();
		final Response response = client1.newCall(request).execute();
		return response.body().string();
	}
}
