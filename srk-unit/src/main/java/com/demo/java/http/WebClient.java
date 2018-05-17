package com.demo.java.http;

import java.io.IOException;

import com.demo.java.httpinterface.HttpWebInterface;
import com.demo.java.httpinterface.WebResponse;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class WebClient implements HttpWebInterface {
	class ResponseData implements WebResponse {
		private boolean status = false;
		private String responseString = "";

		public void setResponse(String response) {
			responseString = response;
		}

		public void setStatus(boolean status) {
			this.status = status;
		}

		public boolean getStatus() {
			return status;
		}

		public String getResponse() {
			return responseString;
		}
	}

	private static final WebClient instance = new WebClient();
	private OkHttpClient client = null;

	private WebClient() {
		init();
	}

	public static WebClient getInstance() {
		return instance;
	}

	public boolean sendData(String url, String dataToSend) {
		return sendRequest(url, dataToSend).getStatus();
	}

	private WebResponse sendRequest(String url, String dataToSend) {

		final Request request = new Request.Builder().url(url).build();
		final ResponseData data = new ResponseData();
		try {
			final Response response = client.newCall(request).execute();
			data.setStatus(response.isSuccessful());
			if (response.isSuccessful()) {
				data.setResponse(response.body().string());
			}
		} catch (final IOException e) {
			e.printStackTrace();
		}
		return data;
	}

	public WebResponse getData(String url) {
		return sendRequest(url, "");
	}

	private void init() {
		client = new OkHttpClient();
	}
}
