package com.srk.demo.unit.srk_unit;

import java.io.IOException;

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

		ObjectMapper objectMapper = new ObjectMapper();
		Device device = new Device(100);
		try {
			System.out.println(objectMapper.writeValueAsString(device));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		String json = "{\"id\":100}";
		try {
			Device newDevice = objectMapper.readValue(json, Device.class);
			System.out.println(newDevice.getID());
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		OkHttpClient client = new OkHttpClient();
		Request request = new Request.Builder().url("https://en.wikipedia.org/w/index.php").build();
		Response response = null;
		try {
			response = client.newCall(request).execute();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (!response.isSuccessful())
			try {
				throw new IOException("Unexpected code " + response);
			} catch (IOException e) {
				e.printStackTrace();
			}
		try {
			System.out.println(response.body().string());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	String runa(String url) throws IOException {
		Request request = new Request.Builder().url(url).build();
		OkHttpClient client1 = new OkHttpClient();
		Response response = client1.newCall(request).execute();
		return response.body().string();
	}
}
