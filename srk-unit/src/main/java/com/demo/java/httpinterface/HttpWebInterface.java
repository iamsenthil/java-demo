package com.demo.java.httpinterface;

public interface HttpWebInterface {

	public boolean sendData(String URL, String data);

	public WebResponse getData(String URL);
}
